package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.curl.Curl

internal actual fun getDefaultEngine() = Curl.create()
