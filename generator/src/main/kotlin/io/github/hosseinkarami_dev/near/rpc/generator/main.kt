package io.github.hosseinkarami_dev.near.rpc.generator

import ModelGenerator
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val parser = ArgParser("generator")

     val gw = System.getenv("GITHUB_WORKSPACE")
    val rootDirStr = gw ?: File(System.getProperty("user.dir"), "..").canonicalPath
    println(">>> rootDir = $rootDirStr")

    val openApiUrl by parser.option(
        ArgType.String,
        fullName = "openapi-url",
        description = "URL to the OpenAPI specification"
    ).default("https://raw.githubusercontent.com/near/nearcore/refs/heads/master/chain/jsonrpc/openapi/openapi.json")

    val modelsOut by parser.option(
        ArgType.String,
        fullName = "models-out",
        description = "Output directory for generated models"
    ).default("$rootDirStr/models/src/main/kotlin")

    val clientOut by parser.option(
        ArgType.String,
        fullName = "client-out",
        description = "Output directory for generated client"
    ).default("$rootDirStr/client/src/main/kotlin")

    parser.parse(args)

    println(">>> modelsOut = $modelsOut")
    println(">>> clientOut = $clientOut")
    println(">>> cwd = ${File(".").absolutePath}")

    // ensure base output directories exist
    try {
        val modelsOutPath: Path = Paths.get(modelsOut)
        val clientOutPath: Path = Paths.get(clientOut)

        println("Creating base output directories (if missing)...")
        Files.createDirectories(modelsOutPath)
        Files.createDirectories(clientOutPath)
        println("Base dirs exist: ${Files.exists(modelsOutPath)} , ${Files.exists(clientOutPath)}")
        println("ModelsOut writable: ${Files.isWritable(modelsOutPath)}")
    } catch (ex: Exception) {
        System.err.println("Failed to create base output dirs: ${ex.message}")
        ex.printStackTrace()
        exitProcess(2)
    }

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val serializerPackage = modelPackage.replace(".models", ".serializers")

    // package directories (inside the base output dirs)
    val serializerDir = Paths.get(modelsOut, *serializerPackage.split(".").toTypedArray())
    val modelDir = Paths.get(modelsOut, *modelPackage.split(".").toTypedArray())
    val nearClientDir = Paths.get(clientOut, *clientPackage.split(".").toTypedArray())

    try {
        println("Creating package directories...")
        Files.createDirectories(serializerDir)
        Files.createDirectories(modelDir)
        Files.createDirectories(nearClientDir)
        println("serializerDir exists: ${Files.exists(serializerDir)}")
        println("modelDir exists: ${Files.exists(modelDir)}")
        println("nearClientDir exists: ${Files.exists(nearClientDir)}")
    } catch (ex: Exception) {
        System.err.println("Failed to create package directories: ${ex.message}")
        ex.printStackTrace()
        exitProcess(3)
    }

    // debug: list a bit of tree
    println("Listing models tree (first 200 lines):")
    File(modelsOut).walkTopDown().take(200).forEach { println(it.absolutePath) }

    // fetch spec (wrap to log errors)
    val spec = try {
        fetchOpenApiSpec(openApiUrl)
    } catch (ex: Exception) {
        System.err.println("Failed to fetch openapi spec: ${ex.message}")
        ex.printStackTrace()
        exitProcess(4)
    }

    // cleanup previous generated files if any (only inside package dirs)
    try {
        serializerDir.toFile().listFiles()?.forEach {
            println("Deleting old file: ${it.absolutePath}")
            it.delete()
        }
        modelDir.toFile().listFiles()?.forEach {
            println("Deleting old file: ${it.absolutePath}")
            it.delete()
        }
        // remove nearClient single file if existed
        nearClientDir.toFile().listFiles()?.forEach {
            println("Deleting old client file: ${it.absolutePath}")
            it.delete()
        }
    } catch (ex: Exception) {
        println("Cleanup warning: ${ex.message}")
    }

    // call generators (wrap to catch exceptions)
    try {
        ModelGenerator.generateAll(
            spec = spec,
            output = File(modelsOut),
            serializerPackage = serializerPackage,
            packageName = modelPackage
        ) { sealedClasses ->
            SerializerGenerator.generateFromSealedInfos(
                sealedInfos = sealedClasses,
                serializerPackage = serializerPackage,
                output = File(modelsOut)
            )
        }
    } catch (ex: Exception) {
        System.err.println("Model generation failed: ${ex.message}")
        ex.printStackTrace()
        exitProcess(5)
    }

    try {
        ClientGenerator.generateNearClientFile(
            spec = spec,
            output = File(clientOut),
            clientPackage = clientPackage,
            modelsPackage = modelPackage
        )
    } catch (ex: Exception) {
        System.err.println("Client generation failed: ${ex.message}")
        ex.printStackTrace()
        exitProcess(6)
    }

    // create a marker file to prove writing succeeded
    try {
        val marker = Paths.get(modelsOut, "__GEN_OK__")
        Files.writeString(marker, "generated at ${java.time.Instant.now()}\n")
        println("Wrote marker: ${marker.toAbsolutePath()}")
    } catch (ex: Exception) {
        System.err.println("Failed to write marker file: ${ex.message}")
        ex.printStackTrace()
    }

    println("Generation finished. final listing (first 200 items):")
    File(modelsOut).walkTopDown().take(200).forEach { println(it.absolutePath) }

    println("✅ Done")
}
