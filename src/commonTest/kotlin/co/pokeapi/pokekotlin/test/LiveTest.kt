package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.PokeApiException
import io.ktor.http.HttpStatusCode.Companion.NotFound
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.coroutines.test.runTest

@Ignore
class LiveTest {

  @Test fun resource() = runTest { assertEquals("sitrus", PokeApi.getBerry(10).name) }

  @Test
  fun list() = runTest {
    assertEquals(PokeApi.getMoveList(0, 50).results[25], PokeApi.getMoveList(25, 50).results[0])
  }

  @Test
  fun notFound() = runTest {
    val e = assertFailsWith(PokeApiException.HttpStatus::class) { PokeApi.getMove(-1) }
    assertEquals(NotFound, e.status)
  }
}
