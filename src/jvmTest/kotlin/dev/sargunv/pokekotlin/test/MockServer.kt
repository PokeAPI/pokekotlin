package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.client.PokeApiClient
import dev.sargunv.pokekotlin.client.PokeApiJson
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.nio.file.Paths
import java.util.logging.Level
import java.util.logging.LogManager
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer

object MockServer {

  private val server = MockWebServer()

  val url = server.url("/api/v2/")!!
  val client = PokeApiClient(url.url().toString())

  init {
    // disable MockWebServer logging
    LogManager.getLogManager().getLogger(MockWebServer::class.qualifiedName).level = Level.OFF

    // get the path to the sample API responses archive
    val sampleArchivePath = Paths.get(MockServer::class.java.getResource("/data")!!.toURI())

    // set up the dispatcher to use files in the archive as the mock responses
    server.dispatcher =
      object : Dispatcher() {
        private fun limit(text: String, limit: Int): String {
          val fullObj = PokeApiJson.decodeFromString<JsonObject>(text)
          val fullResults = fullObj["results"]!!.jsonArray
          val newResults = buildJsonArray { fullResults.take(limit).forEach { add(it) } }
          val newObj = buildJsonObject {
            fullObj.entries.forEach { (key, value) -> put(key, value) }
            put("results", newResults)
            if (fullResults.size > limit) put("next", JsonPrimitive("DUMMY"))
          }
          return PokeApiJson.encodeToString(newObj)
        }

        override fun dispatch(request: RecordedRequest): MockResponse {
          val basePath = request.path.dropLastWhile { it != '/' }
          val limit = server.url(request.path).queryParameter("limit")?.toInt()
          val file = File(sampleArchivePath.toString() + basePath + "index.json")
          return if (file.exists()) {
            var text = FileReader(file).use { it.readText() }
            if (limit != null) text = limit(text, limit)
            MockResponse()
              .setHeader("content-type", "application/json")
              .setBody(Buffer().writeString(text, Charset.defaultCharset()))
          } else MockResponse().setResponseCode(404)
        }
      }
  }
}
