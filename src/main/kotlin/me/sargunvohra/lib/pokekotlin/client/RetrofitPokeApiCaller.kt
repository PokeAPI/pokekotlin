package me.sargunvohra.lib.pokekotlin.client

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import me.sargunvohra.lib.pokekotlin.model.ApiResource
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.util.ApiResourceAdapter
import me.sargunvohra.lib.pokekotlin.util.NamedApiResourceAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitPokeApiCaller(
        private val config: ClientConfig
) : RetrofitPokeApi by Retrofit.Builder()
        .baseUrl(config.rootUrl)
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
        .client(OkHttpClient.Builder().(config.okHttpConfig)().build())
        .build()
        .create(RetrofitPokeApi::class.java)