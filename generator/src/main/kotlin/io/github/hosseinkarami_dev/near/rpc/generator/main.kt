package io.github.hosseinkarami_dev.near.rpc.generator

import java.io.File

fun main() {
    val spec = fetchOpenApiSpec()

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"

    ModelGenerator.generateAll(
        spec = spec,
        outputRoot = File("models/src/main/kotlin/"),
        packageName = modelPackage
    )

    PathGenerator.generateNearClientFile(
        spec = spec,
        outputDir = File("client/src/main/kotlin/"),
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )
}