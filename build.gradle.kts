import com.vanniktech.maven.publish.SonatypeHost
import de.undercouch.gradle.tasks.download.Download
import fr.brouillard.oss.jgitver.Strategies
import org.yaml.snakeyaml.Yaml

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.mavenPublish)
  alias(libs.plugins.spotless)
  alias(libs.plugins.dokka)
  alias(libs.plugins.mkdocs)
  alias(libs.plugins.jgitver)
  alias(libs.plugins.openapiGenerator)
  alias(libs.plugins.download)
  id("maven-publish")
}

buildscript { dependencies { classpath(libs.snakeyaml) } }

val downloadOpenapiSpec by
  tasks.registering(Download::class) {
    src(
      libs.versions.pokeapi.map { version ->
        "https://raw.githubusercontent.com/PokeAPI/pokeapi/refs/tags/$version/openapi.yml"
      }
    )
    dest(layout.buildDirectory.file("openapi/original.yml"))
  }

abstract class PatchOpenapiSpec : DefaultTask() {
  @get:InputFile abstract val inputFile: RegularFileProperty
  @get:OutputFile abstract val outputFile: RegularFileProperty

  @Suppress("UNCHECKED_CAST")
  private fun MutableMap<*, *>.obj(key: String) = this[key] as MutableMap<Any?, Any?>

  private fun fixEvolutionChainLinkDetails(data: MutableMap<Any?, Any?>) {
    val schemas = data.obj("components").obj("schemas")
    val chainProps =
      schemas.obj("EvolutionChainDetail").obj("properties").obj("chain").obj("properties")

    // create a new schema
    schemas.put(
      "EvolutionChainLinkDetails",
      chainProps
        .obj("evolves_to")
        .obj("items")
        .obj("properties")
        .obj("evolution_details")
        .obj("items"),
    )

    // use it by reference
    chainProps
      .obj("evolution_details")
      .put("items", mapOf("\$ref" to "#/components/schemas/EvolutionChainLinkDetails"))

    // use it by reference
    chainProps
      .obj("evolves_to")
      .obj("items")
      .obj("properties")
      .obj("evolution_details")
      .put("items", mapOf("\$ref" to "#/components/schemas/EvolutionChainLinkDetails"))
  }

  @TaskAction
  fun action() {
    val yaml = Yaml()
    val data = yaml.load(this.inputFile.get().asFile.inputStream()) as MutableMap<Any?, Any?>
    fixEvolutionChainLinkDetails(data)
    this.outputFile.get().asFile.writer().use { yaml.dump(data, it) }
  }
}

val patchOpenapiSpec by
  tasks.registering(PatchOpenapiSpec::class) {
    inputFile = downloadOpenapiSpec.map { it.outputFiles.first() }
    outputFile = layout.buildDirectory.file("openapi/patched.yml")
  }

openApiGenerate {
  generatorName = "kotlin"

  inputSpec = patchOpenapiSpec.get().outputFile.map { it.asFile.absolutePath }
  outputDir = layout.projectDirectory.dir("generatedSrc/commonMain/kotlin").asFile.absolutePath
  packageName = "dev.sargunv.pokekotlin"
  cleanupOutput = true

  ignoreFileOverride = layout.projectDirectory.file(".openapi-generator-ignore").asFile.absolutePath
  generateApiDocumentation = false
  generateApiTests = false
  generateModelDocumentation = false
  generateModelTests = false

  configOptions =
    mapOf(
      "library" to "multiplatform",
      "dateLibrary" to "kotlinx-datetime",
      "sourceFolder" to "",
      "enumPropertyNaming" to "PascalCase",
      "explicitApi" to "true",
    )
}

kotlin {
  jvmToolchain(21)
  explicitApi()

  jvm()

  applyDefaultHierarchyTemplate()

  sourceSets {
    commonMain {
      kotlin { srcDir(tasks.openApiGenerate) }
      dependencies {
        implementation(kotlin("stdlib"))
        implementation(libs.kotlinx.serialization.json)
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.content.negotiation)
        implementation(libs.ktor.serialization.kotlinx.json)

        // only non-browser platforms
        implementation(libs.ktor.client.cio)
      }
    }

    commonTest { dependencies { implementation(kotlin("test")) } }

    jvmTest.dependencies {
      implementation(kotlin("reflect"))
      implementation(libs.okhttp.mockwebserver)
    }
  }
}

group = "dev.sargunv.pokekotlin"

jgitver {
  strategy(Strategies.MAVEN)
  nonQualifierBranches("main")
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
