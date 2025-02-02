// import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
// import groovy.json.StringEscapeUtils

plugins {
    `maven-publish`
    idea
    // id("com.teamresourceful.resourcefulgradle") version "0.0.+"
    id("earth.terrarium.cloche") version "0.7.+"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    maven(url = "https://maven.shedaniel.me")
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
    maven(url = "https://maven.msrandom.net/repository/root/")
}

idea {
    module {
        excludeDirs.add(file("run"))
    }
}

private val minecraftVersion: String by project
private val _minecraftVersion = minecraftVersion

cloche {
    val resourcefulLibVersion: String by project
    val athenaVersion: String by project
    val jeiVersion: String by project
    val reiVersion: String by project

    minecraftVersion = _minecraftVersion

    metadata {
        modId = project.name
        license = "Terrarium License"
        issues = "https://github.com/terrarium-earth/chipped/issues"
        name = "Chipped"
        url = "https://modrinth.com/mod/chipped"
        sources = "https://github.com/terrarium-earth/chipped"
        icon = "icon.png"

        description = "Every block needs a friend!"

        author("Alex Nijjar")
        author("Grimbop")
        author("Kekie6")
        author("ThatGravyBoat")

        contributor("CodexAdrian")
        contributor("Facu")
        contributor("Marc-IceBlade")
        contributor("MsRandom")

        dependency {
            modId = "resourcefullib"
            required = true

            version("3.0.0")
        }

        dependency {
            modId = "athena"
            required = true

            version("4.0.0")
        }

        dependency {
            modId = "jei"
            required = false

            version("19.19.3")
        }

        dependency {
            modId = "rei"
            required = false

            version("18.0.796")
        }
    }

    common {
        mixins.from(file("src/common/main/chipped.mixins.json"))

        dependencies {
            modCompileOnly(
                group = "com.teamresourceful.resourcefullib",
                name = "resourcefullib-common-1.21.4",
                version = resourcefulLibVersion
            )

            modCompileOnly(group = "earth.terrarium.athena", name = "athena-common-1.21.4", version = athenaVersion) {
                exclude(group = "net.fabricmc", module = "fabric-loader")
            }

            modApi(group = "mezz.jei", name = "jei-1.21.1-common-api", version = jeiVersion)
            modCompileOnly(group = "me.shedaniel", name = "RoughlyEnoughItems-api", version = reiVersion)
            modCompileOnly(group = "me.shedaniel", name = "RoughlyEnoughItems-default-plugin", version = reiVersion)
        }
    }

    fabric {
        val fabricLoaderVersion: String by project
        val fabricApiVersion: String by project
        val modMenuVersion: String by project

        loaderVersion = fabricLoaderVersion

        client()
        server()
        data()

        dependencies {
            fabricApi("$fabricApiVersion+$_minecraftVersion")

            modApi(group = "com.terraformersmc", name = "modmenu", version = modMenuVersion)
        }

        metadata {
            entrypoint("main", "earth.terrarium.chipped.fabric.ChippedFabric")
            entrypoint("client", "earth.terrarium.chipped.client.fabric.ChippedClientFabric")
            entrypoint("rei_client", "earth.terrarium.chipped.common.compat.rei.ChippedReiPlugin")
            entrypoint("jei_mod_plugin", "earth.terrarium.chipped.common.compat.jei.ChippedJeiPlugin")
        }
    }

    neoforge {
        val neoforgeVersion: String by project

        loaderVersion = neoforgeVersion

        client()
        server()
        data()
    }

    targets.all {
        dependencies {
            modApi(group = "com.teamresourceful.resourcefullib", name = "resourcefullib-$loaderName-1.21.4", version = resourcefulLibVersion)
            modApi(group = "earth.terrarium.athena", name = "athena-$loaderName-1.21.4", version = athenaVersion)

            modCompileOnly(group = "me.shedaniel", name = "RoughlyEnoughItems-api-$loaderName", version = reiVersion)

            modCompileOnly(
                group = "me.shedaniel",
                name = "RoughlyEnoughItems-default-plugin-$loaderName",
                version = reiVersion
            )
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                val modId = project.name

                name.set("Chipped")
                url.set("https://github.com/terrarium-earth/$modId")

                scm {
                    connection.set("git:https://github.com/terrarium-earth/$modId.git")
                    developerConnection.set("git:https://github.com/terrarium-earth/$modId.git")
                    url.set("https://github.com/terrarium-earth/$modId")
                }

                licenses {
                    license {
                        name.set("MIT")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            setUrl("https://maven.teamresourceful.com/repository/terrarium/")
            credentials {
                username = System.getenv("MAVEN_USER")
                password = System.getenv("MAVEN_PASS")
            }
        }
    }
}

/*subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "architectury-plugin")

    val minecraftVersion: String by project
    val modLoader = project.name
    val modId = rootProject.name
    val isCommon = modLoader == rootProject.projects.common.name

    base {
        archivesName.set("$modId-$modLoader-$minecraftVersion")
    }

    configure<LoomGradleExtensionAPI> {
        silentMojangMappingsLicense()
    }

    repositories {
        maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
        maven(url = "https://maven.neoforged.net/releases/")
    }

    dependencies {
        val resourcefulLibVersion: String by project
        val athenaVersion: String by project
        val jeiVersion: String by project
        val reiVersion: String by project

        "minecraft"("::$minecraftVersion")

        @Suppress("UnstableApiUsage")
        "mappings"(project.the<LoomGradleExtensionAPI>().layered {
            val parchmentVersion: String by project

            officialMojangMappings()

            parchment(create(group = "org.parchmentmc.data", name = "parchment-1.21.4", version = parchmentVersion))
        })

        "modApi"(group = "com.teamresourceful.resourcefullib", name = "resourcefullib-$modLoader-1.21.4", version = resourcefulLibVersion)
        "modApi"(group = "earth.terrarium.athena", name = "athena-$modLoader-1.21.4", version = athenaVersion)
        if (isCommon) {
            "modApi"(group = "mezz.jei", name = "jei-1.21.1-common-api", version = jeiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-api", version = reiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-default-plugin", version = reiVersion)
        } else {
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-api-$modLoader", version = reiVersion)
            "modCompileOnly"(group = "me.shedaniel", name = "RoughlyEnoughItems-default-plugin-$modLoader", version = reiVersion)
        }
    }

    java {
        withSourcesJar()
    }

    tasks.jar {
        archiveClassifier.set("dev")
        isZip64 = true
    }

    tasks.named<RemapJarTask>("remapJar") {
        archiveClassifier.set(null as String?)
    }

    if (!isCommon) {
        apply(plugin = "com.github.johnrengelman.shadow")
        configure<ArchitectPluginExtension> {
            platformSetupLoomIde()
        }

        val shadowCommon by configurations.creating {
            isCanBeConsumed = false
            isCanBeResolved = true
        }

        tasks {
            "shadowJar"(ShadowJar::class) {
                archiveClassifier.set("dev-shadow")
                configurations = listOf(shadowCommon)

                exclude("**ctm/*.png") //Remove CTM textures from jar.
                exclude(".cache/**") //Remove datagen cache from jar.
                exclude("**/chipped/datagen/**") //Remove data gen code from jar.
                isZip64 = true
            }

            "remapJar"(RemapJarTask::class) {
                dependsOn("shadowJar")
                inputFile.set(named<ShadowJar>("shadowJar").flatMap { it.archiveFile })
            }
        }
    } else {
        sourceSets.main.get().resources.srcDir("src/main/generated/resources")
    }

    idea {
        module {
            excludeDirs.add(file("run"))
        }
    }
}

resourcefulGradle {
    templates {
        register("embed") {
            val minecraftVersion: String by project
            val version: String by project
            val changelog: String = file("changelog.md").readText(Charsets.UTF_8)
            val fabricLink: String? = System.getenv("FABRIC_RELEASE_URL")
            val forgeLink: String? = System.getenv("FORGE_RELEASE_URL")

            source.set(file("templates/embed.json.template"))
            injectedValues.set(mapOf(
                    "minecraft" to minecraftVersion,
                    "version" to version,
                    "changelog" to StringEscapeUtils.escapeJava(changelog),
                    "fabric_link" to fabricLink,
                    "forge_link" to forgeLink,
            ))
        }
    }
}*/