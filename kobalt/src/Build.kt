import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.publish.bintray

@Suppress("unused")
val repos = repos()

object Versions {
    val kotlin = "1.0.2"
    val retrofit = "2.0.2"
    val testng = "6.9.10"
}

@Suppress("unused")
val p = project {

    name = "PokeKotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = "1.1.1"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
    }

    dependenciesTest {
        compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
        compile("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
        compile("org.testng:testng:${Versions.testng}")
    }

    assemble {
        jar {
        }
        mavenJars {
        }
    }

    bintray {
        publish = true
    }
}
