package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.PokeApi
import dev.sargunv.pokekotlin.PokeApiError
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.coroutines.test.runTest

class ErrorTest {
  @Test
  fun notFoundError() = runTest {
    val e = assertFailsWith(PokeApiError::class, "404 Not Found") { LocalPokeApi.getMove(-1) }
    assertEquals(404, e.code)
  }

  @Test
  fun badUrlError() = runTest {
    val e =
      assertFailsWith(PokeApiError::class, "????") {
        PokeApi("https://localhost:12345/").getBerry(10)
      }
  }
}
