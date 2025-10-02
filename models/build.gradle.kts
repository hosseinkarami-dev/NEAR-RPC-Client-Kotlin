plugins {
    `maven-publish`
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

group = "io.github.hosseinkarami_dev"
version = "0.1.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "near-rpc-models"
            from(components["java"])
        }
    }
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation(libs.kotlinx.serialization.json)
}