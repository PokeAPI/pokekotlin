package co.pokeapi.pokekotlin.internal

import io.ktor.client.engine.js.Js

internal actual fun getDefaultEngine() = Js.create()
