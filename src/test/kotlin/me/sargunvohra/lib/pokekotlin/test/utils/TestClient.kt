package me.sargunvohra.lib.pokekotlin.test.utils

import me.sargunvohra.lib.pokekotlin.client.IPokeApiClient
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient

object TestClient : IPokeApiClient by PokeApiClient()