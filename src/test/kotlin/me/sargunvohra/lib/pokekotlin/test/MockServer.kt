package me.sargunvohra.lib.pokekotlin.test

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.nio.file.Paths
import java.util.logging.Level
import java.util.logging.LogManager
import me.sargunvohra.lib.pokekotlin.client.ClientConfig
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer

object MockServer {

    private val server = MockWebServer()

    val url = server.url("/api/v2/")!!
    val client = PokeApiClient(ClientConfig(url))

    init {
        // disable MockWebServer logging
        LogManager.getLogManager().getLogger(MockWebServer::class.qualifiedName).level = Level.OFF

        // get path to sample API responses archive
        val sampleArchivePath = Paths.get(MockServer::class.java.getResource("/data").toURI())

        // setup the dispatcher to use files in the archive as the mock responses
        server.dispatcher = object : Dispatcher() {
            private val gson = Gson()

            private fun limit(text: String, limit: Int): String {
                val obj = gson.fromJson(text, JsonObject::class.java)
                val fullResults = obj["results"].asJsonArray
                val limitedResults = JsonArray(limit)
                fullResults.take(limit).forEach { limitedResults.add(it) }
                obj.add("results", limitedResults)
                if (fullResults.size() > limit)
                    obj.addProperty("next", "DUMMY")
                return gson.toJson(obj)
            }

            override fun dispatch(request: RecordedRequest): MockResponse {
                val basePath = request.path.dropLastWhile { it != '/' }
                val limit = server.url(request.path).queryParameter("limit")?.toInt()
                val file = File(sampleArchivePath.toString() + basePath + "index.json")
                return if (file.exists()) {
                    var text = FileReader(file).use { it.readText() }
                    if (limit != null)
                        text = limit(text, limit)
                    MockResponse().setBody(Buffer().writeString(text, Charset.defaultCharset()))
                } else MockResponse().setResponseCode(404)
            }
        }
    }
}
