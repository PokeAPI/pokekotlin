package dev.sargunv.pokekotlin.util

import io.ktor.client.engine.HttpClientEngine

internal expect fun getDefaultEngine(): HttpClientEngine
