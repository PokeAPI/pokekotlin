package me.sargunvohra.lib.pokekotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object PokeApi : IPokeApi by Retrofit.Builder()
        .baseUrl(PokeApi.rootUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(
                OkHttpClient.Builder()
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .readTimeout(20, TimeUnit.SECONDS)
                        .writeTimeout(20, TimeUnit.SECONDS)
                        .build()
        )
        .build()
        .create(IPokeApi::class.java) {
    val rootUrl = "http://pokeapi.co/api/v2/"
}