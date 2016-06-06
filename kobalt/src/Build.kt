import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.publish.bintray

object Versions {
    val kotlin = "1.0.2"
    val retrofit = "2.0.2"
    val testng = "6.9.10"
    val jacksonModuleKotlin = "2.7.1-2"
}

@Suppress("unused")
val p = project {

    name = "pokekotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = "1.2.0"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-jackson:${Versions.retrofit}")
        compile("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jacksonModuleKotlin}")
    }

    dependenciesTest {
        compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
        compile("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
        compile("org.testng:testng:${Versions.testng}")
    }

    assemble {
        jar {}
        mavenJars {}
    }

    bintray {
        publish = true
    }
}
