package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.PokeApi
import io.ktor.client.plugins.*
import io.ktor.http.HttpStatusCode.Companion.NotFound
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest

class FailureTest {
  @Test
  fun notFoundError() = runTest {
    val exception = runCatching { LocalPokeApi.getMove(-1) }.exceptionOrNull()
    assertIs<ClientRequestException>(exception)
    assertEquals(NotFound, exception.response.status)
  }

  @Test
  fun badUrlError() = runTest {
    val exception =
      runCatching { PokeApi.Custom("https://localhost:12345/").getBerry(10) }.exceptionOrNull()
    assertNotNull(exception)
  }
}
