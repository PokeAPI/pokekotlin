import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.kotlin.*

val repos = repos()

val kotlinVersion = "1.0.0"

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
		compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    }

    dependenciesTest {
		compile("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    }

    assemble {
        jar {
        }
    }
}
