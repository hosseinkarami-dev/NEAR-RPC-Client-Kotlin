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
        //.default("https://raw.githubusercontent.com/near/nearcore/refs/heads/2.7.0/chain/jsonrpc/openapi/openapi.json")
        //.default("https://raw.githubusercontent.com/near/nearcore/refs/heads/2.8.0/chain/jsonrpc/openapi/openapi.json")
       .default("https://raw.githubusercontent.com/near/nearcore/refs/heads/master/chain/jsonrpc/openapi/openapi.json")

    val modelsOut by parser.option(
        ArgType.String,
        fullName = "models-out",
        description = "Output directory for generated models"
    ).default("../models/src/main/kotlin/")

    val clientOut by parser.option(
        ArgType.String,
        fullName = "client-out",
        description = "Output directory for generated client"
    ).default("../client/src/main/kotlin/")

    parser.parse(args)

    val spec = fetchOpenApiSpec(openApiUrl)

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val serializerPackage = modelPackage.replace(".models", ".serializers")

    val serializerFiles = File(modelsOut + serializerPackage.replace(".", "/"))
    val modelFiles = File(modelsOut + modelPackage.replace(".", "/"))
    val nearClientFile = File(clientOut + clientPackage.replace(".", "/"))

    serializerFiles.mkdir()
    modelFiles.mkdir()

    serializerFiles.listFiles().forEach {
        it.delete()
    }

    modelFiles.listFiles().forEach {
        it.delete()
    }

    nearClientFile.delete()

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
}