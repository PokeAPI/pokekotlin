package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.PokeApi
import io.ktor.client.plugins.*
import io.ktor.http.HttpStatusCode.Companion.NotFound
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlinx.coroutines.test.runTest

class LiveTest {

  @Test fun resource() = runTest { assertEquals("sitrus", PokeApi.getBerry(10).name) }

  @Test
  fun list() = runTest {
    assertEquals(PokeApi.getMoveList(0, 50).results[25], PokeApi.getMoveList(25, 50).results[0])
  }

  @Test
  fun notFound() = runTest {
    val exception = runCatching { PokeApi.getMove(-1) }.exceptionOrNull()
    assertIs<ClientRequestException>(exception)
    assertEquals(NotFound, exception.response.status)
  }
}
