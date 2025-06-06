package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.okhttp.OkHttp

internal actual fun getDefaultEngine() = OkHttp.create()
