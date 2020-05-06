object Versions {
    val pokekotlin = "2.3.1"
    val retrofit = "2.8.1"
    val junit = "4.13"
    val okHttp = "3.14.8"
    val trueZip = "7.7.10"
}

plugins {
    kotlin("jvm") version "1.3.70"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    api("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    api("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
    api("com.squareup.retrofit2:adapter-rxjava:${Versions.retrofit}")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
    
    testImplementation("junit:junit:${Versions.junit}")
    testImplementation("com.squareup.okhttp3:mockwebserver:${Versions.okHttp}")
    testImplementation("de.schlichtherle.truezip:truezip-file:${Versions.trueZip}")
    testImplementation("de.schlichtherle.truezip:truezip-driver-zip:${Versions.trueZip}")
}