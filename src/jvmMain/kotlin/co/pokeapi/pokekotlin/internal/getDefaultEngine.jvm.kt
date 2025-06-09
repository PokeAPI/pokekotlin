package co.pokeapi.pokekotlin.internal

import io.ktor.client.engine.okhttp.OkHttp

internal actual fun getDefaultEngine() = OkHttp.create()
