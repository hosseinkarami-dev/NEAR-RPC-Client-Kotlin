package io.github.hosseinkarami_dev.near.rpc.generator

import ModelGenerator
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import java.io.File

fun main(args: Array<String>) {
    val parser = ArgParser("generator")

    val openApiUrl by parser.option(
        ArgType.String,
        fullName = "openapi-url",
        description = "URL to the OpenAPI specification"
    )
        .default("https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json")

    val modelsOut by parser.option(
        ArgType.String,
        fullName = "models-out",
        description = "Output directory for generated models"
    ).default("models/src/main/kotlin/")

    val clientOut by parser.option(
        ArgType.String,
        fullName = "client-out",
        description = "Output directory for generated client"
    ).default("client/src/main/kotlin/")

    parser.parse(args)

    println(modelsOut)
    println(clientOut)

    val spec = fetchOpenApiSpec(openApiUrl)

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"

    ModelGenerator.generateAll(
        spec = spec,
        outputRoot = File(modelsOut),
        packageName = modelPackage
    )

    PathGenerator.generateNearClientFile(
        spec = spec,
        outputDir = File(clientOut),
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )
}