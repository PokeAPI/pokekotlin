plugins {
    kotlin("jvm") version "1.3.70"
    id("maven-publish")
    jacoco
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

group = "me.sargunvohra.lib"
version = "2.3.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    api("com.squareup.retrofit2:retrofit:2.8.1")
    api("com.squareup.retrofit2:converter-gson:2.8.1")
    api("com.squareup.retrofit2:adapter-rxjava:2.8.1")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
    testImplementation(kotlin("reflect"))
    testImplementation("junit:junit:4.13")
    testImplementation("com.squareup.okhttp3:mockwebserver:3.14.8")
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/pokeapi/pokekotlin")
            credentials {
                username = project.findProperty("gpr.user") as String?
                    ?: System.getenv("GH_USERNAME")
                password = project.findProperty("gpr.key") as String?
                    ?: System.getenv("GH_TOKEN")
            }
        }
    }
    publications {
        register("gpr", MavenPublication::class) {
            from(components["java"])
        }
    }
}

jacoco {
    toolVersion = "0.8.5"
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        csv.isEnabled = true
        html.isEnabled = true
    }
}
