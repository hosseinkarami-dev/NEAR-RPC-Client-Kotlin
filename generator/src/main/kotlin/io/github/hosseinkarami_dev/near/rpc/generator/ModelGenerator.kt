import io.github.hosseinkarami_dev.near.rpc.generator.ModelBuilder
import io.github.hosseinkarami_dev.near.rpc.generator.OpenApiSpec
import java.io.File

/**
 * Generator that produces Kotlin models (kotlinx.serialization) from OpenAPI schemas using KotlinPoet.
 *
 * Usage:
 *   DataClassGenerator.generateAll(spec, File("generator/src/main/kotlin"))
 */
class ModelGenerator(
    spec: OpenApiSpec,
    outputRoot: File,
    packageName: String
) {
    private val modelBuilder = ModelBuilder(spec, packageName, outputRoot)

    companion object {
        fun generateAll(
            spec: OpenApiSpec,
            outputDir: File,
            packageName: String
        ) {
            val gen = ModelGenerator(spec, outputDir, packageName)
            outputDir.mkdirs()

            gen.modelBuilder.buildModels()
            println("✅ Models Generated Successfully to $outputDir")
        }
    }

}