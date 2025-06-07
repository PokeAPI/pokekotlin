package dev.sargunv.pokekotlin.internal

import io.ktor.client.engine.curl.Curl

internal actual fun getDefaultEngine() = Curl.create()
