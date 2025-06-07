package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.PokeApi
import dev.sargunv.pokekotlin.PokeApiException
import io.ktor.http.HttpStatusCode.Companion.NotFound
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.coroutines.test.runTest

class PokeApiExceptionTest {
  @Test
  fun notFoundError() = runTest {
    val e = assertFailsWith(PokeApiException.HttpStatus::class) { LocalPokeApi.getMove(-1) }
    assertEquals(NotFound, e.status)
  }

  @Test
  fun badUrlError() = runTest {
    assertFailsWith(PokeApiException.UnknownException::class) {
      PokeApi("https://localhost:12345/").getBerry(10)
    }
  }
}
