@file:OptIn(ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import fr.brouillard.oss.jgitver.Strategies
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeSimulatorTest
import ru.vyarus.gradle.plugin.mkdocs.task.MkdocsTask

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.composeCompiler) apply false
  alias(libs.plugins.compose) apply false
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.mavenPublish)
  alias(libs.plugins.spotless)
  alias(libs.plugins.dokka)
  alias(libs.plugins.mkdocs)
  alias(libs.plugins.jgitver)
  alias(libs.plugins.ksp)
  alias(libs.plugins.ktorfit)
  id("maven-publish")
}

group = "co.pokeapi.pokekotlin"

jgitver {
  strategy(Strategies.MAVEN)
  nonQualifierBranches("main")
}

kotlin {
  jvmToolchain(21)
  explicitApiWarning()
  compilerOptions {
    allWarningsAsErrors = true
    freeCompilerArgs.addAll("-Xexpect-actual-classes", "-Xconsistent-data-class-copy-visibility")
  }

  jvm()

  js(IR) {
    browser { testTask { useMocha { timeout = "10min" } } }
    nodejs { testTask { useMocha { timeout = "10min" } } }
  }

  wasmJs {
    browser()
    nodejs()
    d8()
  }

  // native tier 1
  macosX64()
  macosArm64()
  iosSimulatorArm64()
  iosX64()
  iosArm64()

  // native tier 2
  linuxX64()
  linuxArm64()
  watchosSimulatorArm64()
  watchosX64()
  watchosArm32()
  watchosArm64()
  tvosSimulatorArm64()
  tvosX64()
  tvosArm64()

  // native tier 3
  // android native platforms aren't supported due to lack of Ktor support
  mingwX64()
  watchosDeviceArm64()

  applyDefaultHierarchyTemplate()

  sourceSets {
    commonMain.dependencies {
      implementation(kotlin("stdlib"))
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.ktor.client.content.negotiation)
      implementation(libs.ktor.serialization.kotlinx.json)
      implementation(libs.ktorfit)
    }

    jvmMain.dependencies { implementation(libs.ktor.client.okhttp) }
    appleMain.dependencies { implementation(libs.ktor.client.darwin) }
    linuxMain.dependencies { implementation(libs.ktor.client.curl) }
    mingwMain.dependencies { implementation(libs.ktor.client.winhttp) }
    jsMain.dependencies { implementation(libs.ktor.client.js) }
    wasmJsMain.dependencies { implementation(libs.ktor.client.js) }

    commonTest.dependencies {
      implementation(kotlin("test"))
      implementation(libs.kotlinx.coroutines.test)
      implementation(libs.kotlinx.io)
      implementation(libs.ktor.client.mock)
    }

    jvmTest.dependencies { implementation(kotlin("reflect")) }
  }
}

// Gradle complains if we don't have this; unclear why.
tasks.getByName("sourcesJar").dependsOn("kspCommonMainKotlinMetadata")

// Standalone mode is missing certificates, which causes our LiveTest to fail.
// This should resolve it but requires us to start the simulator(s) beforehand.
// https://youtrack.jetbrains.com/issue/KT-38317
tasks.withType<KotlinNativeSimulatorTest> {
  standalone.set(false)
  (project.findProperty("appleNativeSimulatorDevice") as? String)?.let { device.set(it) }
}

publishing {
  repositories {
    maven {
      name = "GitHubPackages"
      setUrl("https://maven.pkg.github.com/PokeAPI/pokekotlin")
      credentials(PasswordCredentials::class)
    }
  }
}

mavenPublishing {
  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
  signAllPublications()
  pom {
    name = "PokeKotlin"
    description = "Kotlin client for The Pokémon API"
    url = "https://github.com/PokeAPI/pokekotlin"
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("https://opensource.org/license/apache-2-0")
        distribution.set("repo")
      }
    }
    developers {
      developer {
        id.set("sargunv")
        name.set("Sargun Vohra")
        url.set("https://github.com/sargunv")
      }
    }
    scm {
      url.set("https://github.com/PokeAPI/pokekotlin")
      connection.set("scm:git:git://github.com/PokeAPI/pokekotlin.git")
      developerConnection.set("scm:git:ssh://git@github.com/PokeAPI/pokekotlin.git")
    }
  }
}

dokka {
  moduleName = "PokeKotlin API Reference"
  dokkaSourceSets {
    configureEach {
      includes.from("MODULE.md")
      sourceLink {
        remoteUrl("https://github.com/PokeAPI/pokekotlin/tree/${project.ext["base_tag"]}/")
        localDirectory.set(rootDir)
      }
      externalDocumentationLinks { create("ktor") { url("https://api.ktor.io/") } }
      suppressedFiles.from("build/generated/ksp/")
    }
  }
}

mkdocs {
  sourcesDir = "docs"
  strict = true
  publish {
    docPath = null // single version site
  }
}

tasks.withType<MkdocsTask>().configureEach {
  val releaseVersion = ext["base_tag"].toString().replace("v", "")
  val snapshotVersion = "${ext["next_patch_version"]}-SNAPSHOT"
  extras.set(mapOf("release_version" to releaseVersion, "snapshot_version" to snapshotVersion))
}

tasks.register("generateDocs") {
  dependsOn("dokkaGenerate", "mkdocsBuild")
  doLast {
    copy {
      from(layout.buildDirectory.dir("mkdocs"))
      into(layout.buildDirectory.dir("docs"))
    }
    copy {
      from(layout.buildDirectory.dir("dokka/html"))
      into(layout.buildDirectory.dir("docs/api"))
    }
  }
}

spotless {
  kotlinGradle {
    target("*.gradle.kts", "demo-app/*.gradle.kts")
    ktfmt().googleStyle()
  }
  kotlin {
    target("src/**/*.kt", "demo-app/src/**/*.kt")
    ktfmt().googleStyle()
  }
  java {
    target("src/**/*.java", "demo-app/src/**/*.java")
    googleJavaFormat()
  }
  format("markdown") {
    target("*.md", "docs/**/*.md")
    prettier(libs.versions.tool.prettier.get()).config(mapOf("proseWrap" to "always"))
  }
  yaml {
    target(".github/**/*.yml")
    prettier(libs.versions.tool.prettier.get())
  }
}

tasks.register("installGitHooks") {
  doLast {
    copy {
      from("${rootProject.projectDir}/scripts/pre-commit")
      into("${rootProject.projectDir}/.git/hooks")
    }
  }
}

tasks.named("clean") { doLast { delete("${rootProject.projectDir}/.git/hooks/pre-commit") } }
