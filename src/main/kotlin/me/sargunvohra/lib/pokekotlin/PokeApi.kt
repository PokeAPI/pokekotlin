package me.sargunvohra.lib.pokekotlin

import me.sargunvohra.lib.pokekotlin.client.IPokeApiClient
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient

object PokeApi : IPokeApiClient by PokeApiClient()