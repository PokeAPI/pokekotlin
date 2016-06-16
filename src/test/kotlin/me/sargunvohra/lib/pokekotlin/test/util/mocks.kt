package me.sargunvohra.lib.pokekotlin.test.util

import de.schlichtherle.truezip.file.TFile
import de.schlichtherle.truezip.file.TFileReader
import me.sargunvohra.lib.pokekotlin.client.ClientConfig
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.client.RetrofitApiCaller
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer
import java.nio.charset.Charset

val mockClient = PokeApiClient(RetrofitApiCaller(ClientConfig(MockServer.url)))

object MockServer {

    private val server = MockWebServer()

    val url = server.url("/api/v2/")

    init {
        val resourcePath = MockServer::class.java.getResource("/api.zip").toURI().path
        server.setDispatcher(object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                val basePath = request.path.dropLastWhile { it != '/' }
                val limit = server.url(request.path).queryParameter("limit")
                val filename = if (limit == null) "index.json" else "limit=$limit.json"
                val file = TFile(resourcePath + basePath + filename)
                return if (file.exists()) {
                    val text = TFileReader(file).use { it.readText() }
                    MockResponse().setBody(Buffer().writeString(text, Charset.defaultCharset()))
                } else MockResponse().setResponseCode(404)
            }
        })
    }
}