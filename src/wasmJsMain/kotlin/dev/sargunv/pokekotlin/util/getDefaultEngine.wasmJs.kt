package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.js.Js

internal actual fun getDefaultEngine() = Js.create()
