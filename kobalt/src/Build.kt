import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble

val repos = repos()

object Versions {
    val kotlin = "1.0.0"
    val retrofit = "2.0.0-beta4"
    val kovenant = "3.0.0"
    val testng = "6.9.10"
}

val p = project {

    name = "PokeKotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = "0.1.0"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
        // kotlin
        compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

        // retrofit
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")

        // kovenant
        compile("nl.komponents.kovenant:kovenant-core:${Versions.kovenant}")
        compile("nl.komponents.kovenant:kovenant-combine:${Versions.kovenant}")
        compile("nl.komponents.kovenant:kovenant-jvm:${Versions.kovenant}")
        compile("nl.komponents.kovenant:kovenant-functional:${Versions.kovenant}")
    }

    dependenciesTest {
        compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
        compile("org.testng:testng:${Versions.testng}")
    }

    assemble {
        jar {
        }
    }
}
