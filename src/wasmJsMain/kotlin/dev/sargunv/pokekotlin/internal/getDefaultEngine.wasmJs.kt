package dev.sargunv.pokekotlin.internal

import io.ktor.client.engine.js.Js

internal actual fun getDefaultEngine() = Js.create()
