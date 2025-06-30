@file:OptIn(ExperimentalKotlinGradlePluginApi::class, ExperimentalWasmDsl::class)

import fr.brouillard.oss.jgitver.Strategies
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.composeCompiler)
  alias(libs.plugins.compose)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.jgitver)
}

jgitver {
  strategy(Strategies.MAVEN)
  nonQualifierBranches("main")
}

android {
  namespace = "co.pokeapi.pokekotlin.demoapp"

  defaultConfig {
    applicationId = "co.pokeapi.pokekotlin.demoapp"
    minSdk = 30
    compileSdk = 36
    targetSdk = 36
    versionCode = 1
    versionName = project.version.toString()
  }

  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      signingConfig = signingConfigs.getByName("debug")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
}

kotlin {
  androidTarget()
  jvm("desktop")

  listOf(iosArm64(), iosSimulatorArm64(), iosX64()).forEach {
    it.binaries.framework { baseName = "PokeKotlinDemoApp" }
  }

  listOf(macosX64(), macosArm64()).forEach {
    it.binaries.executable { entryPoint = "co.pokeapi.pokekotlin.demoapp.main" }
  }

  listOf(js(), wasmJs()).forEach {
    it.apply {
      browser { commonWebpackConfig { outputFileName = "app.js" } }
      binaries.executable()
    }
  }

  applyDefaultHierarchyTemplate()

  compilerOptions { freeCompilerArgs.addAll("-Xconsistent-data-class-copy-visibility") }

  sourceSets {
    val desktopMain by getting

    all { languageSettings { optIn("androidx.compose.material3.ExperimentalMaterial3Api") } }

    commonMain {
      dependencies {
        implementation(compose.components.resources)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.material3AdaptiveNavigationSuite)
        implementation(compose.runtime)
        implementation(compose.ui)

        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.lifecycle.viewmodel.compose)
        implementation(libs.coil.compose)
        implementation(libs.coil.network.ktor3)

        implementation(project.dependencies.platform(libs.koin.bom))
        implementation(libs.koin.core)
        implementation(libs.koin.compose)
        implementation(libs.koin.composeViewmodel)
        implementation(libs.koin.composeViewmodelNavigation)

        implementation(projects.pokekotlin)
      }
    }

    androidMain {
      dependencies {
        implementation(libs.androidx.activity.compose)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.koin.android)
      }
    }

    desktopMain.apply {
      dependencies {
        implementation(compose.desktop.currentOs)
        implementation(libs.kotlinx.coroutines.swing)
      }
    }
  }
}

compose {
  resources { packageOfResClass = "co.pokeapi.pokekotlin.demoapp.generated" }

  desktop {
    application {
      mainClass = "co.pokeapi.pokekotlin.demoapp.MainKt"

      nativeDistributions {
        targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
        packageName = "co.pokeapi.pokekotlin.demoapp"
        packageVersion = "1.0.0" // https://youtrack.jetbrains.com/issue/CMP-2360
      }
    }
  }
}
