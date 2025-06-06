package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.winhttp.WinHttp

internal actual fun getDefaultEngine() = WinHttp.create()
