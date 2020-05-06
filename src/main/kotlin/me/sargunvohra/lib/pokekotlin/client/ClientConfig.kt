package me.sargunvohra.lib.pokekotlin.client

import java.util.concurrent.TimeUnit
import okhttp3.HttpUrl
import okhttp3.OkHttpClient

class ClientConfig(
    val rootUrl: HttpUrl = HttpUrl.parse("https://pokeapi.co/api/v2/")!!,
    val okHttpConfig: OkHttpClient.Builder.() -> OkHttpClient.Builder = {
        retryOnConnectionFailure(false)
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }
)
