package co.pokeapi.pokekotlin.internal

import io.ktor.client.engine.HttpClientEngine

internal expect fun getDefaultEngine(): HttpClientEngine
