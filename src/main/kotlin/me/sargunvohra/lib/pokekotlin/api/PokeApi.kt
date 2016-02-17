package me.sargunvohra.lib.pokekotlin.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PokeApi: IPokeApi by Retrofit.Builder()
        .baseUrl("http://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(IPokeApi::class.java)