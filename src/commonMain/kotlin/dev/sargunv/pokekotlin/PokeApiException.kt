package dev.sargunv.pokekotlin

import io.ktor.http.HttpStatusCode

sealed class PokeApiException : Throwable {
  constructor(message: String) : super(message)

  constructor(cause: Throwable) : super(cause)

  class HttpStatus(val status: HttpStatusCode) : PokeApiException(status.toString())

  class UnknownException(cause: Throwable) : PokeApiException(cause)
}
