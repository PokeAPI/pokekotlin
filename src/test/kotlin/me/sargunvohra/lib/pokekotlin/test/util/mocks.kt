package me.sargunvohra.lib.pokekotlin.test.util

import de.schlichtherle.truezip.file.TFile
import de.schlichtherle.truezip.file.TFileReader
import me.sargunvohra.lib.pokekotlin.client.ClientConfig
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer
import java.nio.charset.Charset
import java.nio.file.Paths
import java.util.logging.Level
import java.util.logging.LogManager

val mockClient = PokeApiClient(ClientConfig(MockServer.url))

object MockServer {

    private val server = MockWebServer()

    val url = server.url("/api/v2/")!!

    init {
        // disable MockWebServer logging
        LogManager.getLogManager().getLogger(MockWebServer::class.qualifiedName).level = Level.OFF

        // get path to sample API responses archive
        val sampleArchivePath = Paths.get(MockServer::class.java.getResource("/api-data-master.zip").toURI())
                .resolve("api-data-master").resolve("data")

        // setup the dispatcher to use files in the archive as the mock responses
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                val basePath = request.path.dropLastWhile { it != '/' }
                val limit = server.url(request.path).queryParameter("limit")
                val filename = if (limit == null) "index.json" else "limit=$limit.json"
                val file = TFile(sampleArchivePath.toString() + basePath + filename)
                return if (file.exists()) {
                    val text = TFileReader(file).use { it.readText() }
                    MockResponse().setBody(Buffer().writeString(text, Charset.defaultCharset()))
                } else MockResponse().setResponseCode(404)
            }
        }
    }
}