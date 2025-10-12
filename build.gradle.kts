// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    id("maven-publish")
    id("signing")
}

group = findProperty("GROUP") as String
version = findProperty("VERSION_NAME") as String

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    if (project.name in listOf("app", "generator")) {
        println("⏩ Skipping publication setup for module ${project.name}")
        return@subprojects
    }

    afterEvaluate {
        extensions.configure<PublishingExtension>("publishing") {
            publications {
                create<MavenPublication>("release") {
                    from(components.findByName("release") ?: components.findByName("kotlin"))
                    groupId = "io.github.hosseinkarami-dev"
                    artifactId = project.name
                    version = rootProject.version.toString()

                    pom {
                        name.set(artifactId)
                        description.set("Awesome Android module: $artifactId")
                        url.set("https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin")
                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }
                        developers {
                            developer {
                                id.set("hosseinkarami-dev")
                                name.set("Hossein Karami")
                                email.set("h.karami1811@gmail.com")
                            }
                        }
                        scm {
                            connection.set("scm:git:https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin.git")
                            developerConnection.set("scm:git:ssh://hosseinkarami-dev/NEAR-RPC-Client-Kotlin.git")
                            url.set("https://github.com/hosseinkarami-dev/NEAR-RPC-Client-Kotlin")
                        }
                    }
                }
            }

            repositories {
                maven {
                    name = "MavenCentral"
                    url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    credentials {
                        username = findProperty("mavenCentralUsername") as String?
                        password = findProperty("mavenCentralPassword") as String?
                    }
                }
            }
        }

        extensions.configure<SigningExtension>("signing") {
            sign(extensions.getByType<PublishingExtension>().publications)
        }
    }
}