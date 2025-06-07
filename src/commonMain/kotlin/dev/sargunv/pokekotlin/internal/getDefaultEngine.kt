package dev.sargunv.pokekotlin.internal

import io.ktor.client.engine.HttpClientEngine

internal expect fun getDefaultEngine(): HttpClientEngine
