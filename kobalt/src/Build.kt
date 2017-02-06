import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.publish.bintray
import com.beust.kobalt.project
import com.beust.kobalt.repos
import com.beust.kobalt.test

object Versions {
    val pokekotlin = "2.3.0"
    val kotlin = "1.0.3"
    val retrofit = "2.1.0"
    val junit = "4.12"
    val okHttp = "3.4.1"
    val trueZip = "7.7.9"
    val skaffold = "7898fae"
}

@Suppress("unused")
val repos = repos("https://jitpack.io")

@Suppress("unused")
val core = project {

    name = "pokekotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = Versions.pokekotlin
    directory = name

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
        compile("com.squareup.retrofit2:adapter-rxjava:${Versions.retrofit}")
    }

    dependenciesTest {
        compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
        compile("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
        compile("junit:junit:${Versions.junit}")
        compile("com.squareup.okhttp3:mockwebserver:${Versions.okHttp}")
        compile("de.schlichtherle.truezip:truezip-file:${Versions.trueZip}")
        compile("de.schlichtherle.truezip:truezip-driver-zip:${Versions.trueZip}")
    }

    test {
    }

    assemble {
        jar {}
        mavenJars {}
    }

    bintray {
        publish = true
    }
}

@Suppress("unused")
val skaffold = project(core) {

    name = "pokekotlin-skaffold"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = Versions.pokekotlin
    directory = name

    dependencies {
        compile("com.github.pokesource.skaffold:skaffold-data:${Versions.skaffold}")
    }

    dependenciesTest {}

    assemble {
        jar {}
        mavenJars {}
    }
    
    bintray {
        publish = true
    }

}
