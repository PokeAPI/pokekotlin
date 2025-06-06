package dev.sargunv.pokekotlin.client

class PokeApiError(val code: Int, message: String) : Throwable("($code) $message")
