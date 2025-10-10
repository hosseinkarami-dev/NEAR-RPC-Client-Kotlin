plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    id("org.jetbrains.kotlinx.kover") version "0.9.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
kotlin {
    sourceSets {
        val main by getting {
            kotlin.srcDir("src/main/kotlin")
        }
        val test by getting {
            kotlin.srcDir("src/test/kotlin")
        }
    }

    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}

kover {
    reports {
        verify {
            rule {
                bound {
                    minValue.set(60)
                }
            }
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
    testImplementation(libs.kotlinx.coroutines.test)

    implementation(kotlin("stdlib"))
    api(project(":models"))
    implementation(libs.kotlinx.cli)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
}