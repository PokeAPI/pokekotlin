package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.client.PokeApiClient
import dev.sargunv.pokekotlin.client.PokeApiJson
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.readText
import kotlinx.io.IOException
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray

object MockServer {
  val mockEngine = MockEngine { request -> dispatch(request) }
  val client = PokeApiClient(engine = mockEngine)

  private fun limit(text: String, limit: Int): String {
    val fullObj = PokeApiJson.decodeFromString<JsonObject>(text)
    val fullResults = fullObj["results"]!!.jsonArray
    val newResults = buildJsonArray { fullResults.take(limit).forEach { add(it) } }
    val newObj = buildJsonObject {
      fullObj.entries.forEach { (key, value) -> put(key = key, element = value) }
      put(key = "results", element = newResults)
      if (fullResults.size > limit) put(key = "next", element = JsonPrimitive("DUMMY"))
    }
    return PokeApiJson.encodeToString(newObj)
  }

  fun readFile(path: Path) =
    try {
      SystemFileSystem.source(path).buffered().use { it.readText() }
    } catch (e: IOException) {
      println("Error reading file: ${e.message}")
      null
    }

  private fun MockRequestHandleScope.dispatch(request: HttpRequestData): HttpResponseData {
    val basePath = request.url.encodedPath
    val limit = request.url.parameters["limit"]?.toInt()
    val file = Path("src/commonTest/resources/data" + basePath + "index.json")
    val text = readFile(file) ?: return respondError(HttpStatusCode.NotFound)
    val responseContent = if (limit != null) limit(text, limit) else text
    return respond(
      content = responseContent,
      headers = headersOf("content-type", "application/json"),
    )
  }
}
