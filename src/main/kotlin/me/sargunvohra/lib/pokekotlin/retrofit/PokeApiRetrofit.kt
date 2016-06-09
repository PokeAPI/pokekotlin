package me.sargunvohra.lib.pokekotlin.retrofit

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import me.sargunvohra.lib.pokekotlin.json.*
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

class PokeApiRetrofit(
        val rootUrl: HttpUrl = HttpUrl.parse("https://pokeapi.co/api/v2/"),
        val httpClient: OkHttpClient = OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
) : IPokeApiRetrofit by Retrofit.Builder()
        .baseUrl(rootUrl)
        .addConverterFactory(JacksonConverterFactory.create(
                ObjectMapper().apply {
                    registerKotlinModule()
                    registerModule(SimpleModule().apply {
                        addDeserializer(ApiResource::class.java, ApiResourceAdapter())
                        addDeserializer(NamedApiResource::class.java, NamedApiResourceAdapter())
                    })
                    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
                    propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
                }
        ))
        .client(httpClient)
        .build()
        .create(IPokeApiRetrofit::class.java)