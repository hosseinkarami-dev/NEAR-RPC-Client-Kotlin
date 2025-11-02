package io.github.hosseinkarami_dev.near.rpc.generator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ClientGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ClientTestGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ModelGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ModelTestGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.SerializerGenerator
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import java.io.File
import kotlin.reflect.KClass

fun main(args: Array<String>) {
    val parser = ArgParser("generator")

    val rootDir = System.getenv("GITHUB_WORKSPACE") ?: File(System.getProperty("user.dir"), "..").canonicalPath

    val openApiUrl by parser.option(
        ArgType.String,
        fullName = "openapi-url",
        description = "URL to the OpenAPI specification"
    )
        //.default("https://raw.githubusercontent.com/near/nearcore/refs/heads/2.9.0/chain/jsonrpc/openapi/openapi.json")
       .default("https://raw.githubusercontent.com/near/nearcore/refs/heads/master/chain/jsonrpc/openapi/openapi.json")

    val modelsOut by parser.option(
        ArgType.String,
        fullName = "models-out",
        description = "Output directory for generated models"
    ).default("$rootDir/models/src/main/kotlin/")

    val clientOut by parser.option(
        ArgType.String,
        fullName = "client-out",
        description = "Output directory for generated client"
    ).default("$rootDir/client/src/main/kotlin/")

    val testsOut = "$rootDir/client/src/test/kotlin/"

    parser.parse(args)

    val spec = fetchOpenApiSpec(openApiUrl)

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val testsPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val serializerPackage = modelPackage.replace(".models", ".serializers")

    val serializerFiles = File(modelsOut + serializerPackage.replace(".", "/"))
    val modelFiles = File(modelsOut + modelPackage.replace(".", "/"))
    val nearClientFile = File(clientOut + clientPackage.replace(".", "/"))

    serializerFiles.mkdirs()
    modelFiles.mkdirs()
    nearClientFile.mkdirs()

    serializerFiles.takeIf { it.exists() }?.listFiles()?.forEach { it.delete() }
    modelFiles.takeIf { it.exists() }?.listFiles()?.forEach { it.delete() }

    nearClientFile.delete()

    //models & serializers
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

    ClientGenerator.generateNearClientFile(
        spec = spec,
        output = File(clientOut),
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )

    //tests
    ModelTestGenerator.generateTestsForModels(
        spec = spec,
        output = File(testsOut),
        testsPackage = testsPackage,
        modelsPackage = modelPackage
    )

    ClientTestGenerator.generateTestsForClient(
        spec = spec,
        output = File(testsOut),
        testsPackage = testsPackage,
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )
}