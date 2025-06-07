package dev.sargunv.pokekotlin.internal

import io.ktor.client.engine.darwin.Darwin

internal actual fun getDefaultEngine() = Darwin.create()
