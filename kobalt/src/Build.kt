import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble

val repos = repos()

object Versions {
    val kotlin = "1.0.0"
    val retrofit = "2.0.0-beta4"
    val okhttp = "3.1.2"
    val okio = "1.6.0"
	val kovenant = "3.0.0"
}

val p = project {

    name = "PokeKotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = "1.0.0"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
		compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
		compile("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
		compile("com.squareup.okio:okio:${Versions.okio}")
		compile("nl.komponents.kovenant:kovenant:${Versions.kovenant}")
    }

    dependenciesTest {
		compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
    }

    assemble {
        jar {
        }
    }
}
