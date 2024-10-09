architectury {
    neoForge()
}

loom {
    runs {
        create("data") {
            data()
            programArgs("--all", "--mod", "chipped")
            programArgs("--output", project(":common").file("src/main/generated/resources").absolutePath)
            programArgs("--existing", project(":common").file("src/main/resources").absolutePath)
        }
    }
}

val common: Configuration by configurations.creating {
    configurations.compileClasspath.get().extendsFrom(this)
    configurations.runtimeClasspath.get().extendsFrom(this)
    configurations["developmentNeoForge"].extendsFrom(this)
}

dependencies {
    val minecraftVersion: String by project
    val neoforgeVersion: String by project
    // val jeiVersion: String by project
    // val reiVersion: String by project

    neoForge(group = "net.neoforged", name = "neoforge", version = neoforgeVersion)

    // modLocalRuntime(group = "mezz.jei", name = "jei-$minecraftVersion-neoforge", version = jeiVersion) {
    // isTransitive = false
    // }

    // modLocalRuntime(group = "me.shedaniel", name = "RoughlyEnoughItems-neoforge", version = reiVersion) {
    //     isTransitive = false
    // }

    common(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    shadowCommon(project(path = ":common", configuration = "transformProductionNeoForge")) {
        isTransitive = false
    }
    forgeRuntimeLibrary("com.teamresourceful:bytecodecs:1.0.2")
}
