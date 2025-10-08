plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation(libs.kotlinx.serialization.json)
}