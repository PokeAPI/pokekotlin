import com.vanniktech.maven.publish.SonatypeHost
import fr.brouillard.oss.jgitver.Strategies

plugins {
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

group = "dev.sargunv.pokekotlin"

jgitver {
  strategy(Strategies.MAVEN)
  nonQualifierBranches("main")
}

kotlin {
  jvmToolchain(21)

  compilerOptions { allWarningsAsErrors = true }

  jvm()

  applyDefaultHierarchyTemplate()

  sourceSets {
    jvmMain.dependencies {
      implementation(kotlin("stdlib"))
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.ktor.client.content.negotiation)
      implementation(libs.ktor.serialization.kotlinx.json)
      implementation(libs.ktorfit)
    }

    jvmTest.dependencies {
      implementation(kotlin("test"))
      implementation(kotlin("reflect"))
      implementation(libs.kotlinx.coroutines.test)
      implementation(libs.okhttp.mockwebserver)
    }
  }
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
      externalDocumentationLinks {
        // TODO
      }
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
    target("*.gradle.kts")
    ktfmt().googleStyle()
  }
  kotlin {
    target("src/**/*.kt")
    ktfmt().googleStyle()
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
