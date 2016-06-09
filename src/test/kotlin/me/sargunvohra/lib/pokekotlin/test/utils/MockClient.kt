package me.sargunvohra.lib.pokekotlin.test.utils

import me.sargunvohra.lib.pokekotlin.client.IPokeApiClient
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.retrofit.PokeApiRetrofit
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer

object MockClient : IPokeApiClient by PokeApiClient(PokeApiRetrofit(MockServer.url))