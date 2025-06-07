package dev.sargunv.pokekotlin

class PokeApiError(val code: Int, message: String) : Throwable("($code) $message")
