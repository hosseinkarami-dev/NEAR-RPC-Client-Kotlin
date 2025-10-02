plugins {
    application
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

group = "io.github.hosseinkarami_dev"
version = "0.1.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "near-rpc-client"
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
}

dependencies {
    implementation(project(":models"))
    implementation(libs.kotlinx.cli)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
}