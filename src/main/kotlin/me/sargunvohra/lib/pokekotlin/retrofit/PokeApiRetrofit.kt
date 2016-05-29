package me.sargunvohra.lib.pokekotlin.retrofit

import com.squareup.moshi.Moshi
import me.sargunvohra.lib.pokekotlin.json.ApiResourceAdapter
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class PokeApiRetrofit(
        val rootUrl: String = "https://pokeapi.co/api/v2/",
        val httpClient: OkHttpClient = OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
) : IPokeApiRetrofit by Retrofit.Builder()
        .baseUrl(rootUrl)
        .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder().apply {
                    add(ApiResourceAdapter())
                    add(NamedApiResourceAdapter())
                }.build()
        ))
        .client(httpClient)
        .build()
        .create(IPokeApiRetrofit::class.java)