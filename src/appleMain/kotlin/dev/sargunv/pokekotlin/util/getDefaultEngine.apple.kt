package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.darwin.Darwin

internal actual fun getDefaultEngine() = Darwin.create()
