package me.sargunvohra.lib.pokekotlin.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class PokeApiRetrofit(
        val rootUrl: String = "http://pokeapi.co/api/v2/",
        val httpClient: OkHttpClient = OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build()
) : IPokeApiRetrofit by Retrofit.Builder()
        .baseUrl(rootUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(httpClient)
        .build()
        .create(IPokeApiRetrofit::class.java)