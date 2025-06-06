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
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.readText
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

  private fun MockRequestHandleScope.dispatch(request: HttpRequestData): HttpResponseData {
    val basePath = request.url.encodedPath
    val limit = request.url.parameters["limit"]?.toInt()
    val file = Path("src/jvmTest/resources/data" + basePath + "index.json")
    return if (file.exists()) {
      val text = file.readText()
      val content = if (limit != null) limit(text, limit) else text
      respond(content = content, headers = headersOf("content-type", "application/json"))
    } else respondError(HttpStatusCode.NotFound)
  }
}
