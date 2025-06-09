package co.pokeapi.pokekotlin.internal

import io.ktor.client.engine.winhttp.WinHttp

internal actual fun getDefaultEngine() = WinHttp.create()
