package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.js.PokeApiJs
import io.ktor.client.plugins.*
import io.ktor.http.*
import kotlin.js.Promise
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.coroutines.await
import kotlinx.coroutines.test.runTest

@Suppress("UnusedVariable", "unused")
class LiveJsTest {
  private val client: PokeApiJs =
    js("require('./pokekotlin.js').co.pokeapi.pokekotlin.js.createPokeApi()")

  @Test
  fun resource() = runTest {
    val client = client
    assertEquals(
      "sitrus",
      js("client.getBerry(10).then(function (it) { return it.name; })")
        .unsafeCast<Promise<String>>()
        .await(),
    )
  }

  @Test
  fun list() = runTest {
    val client = client

    val move1 =
      js("client.getMoveList(0, 50).then(function (it) { return it.results[25]; })")
        .unsafeCast<Promise<*>>()
        .await()

    val move2 =
      js("client.getMoveList(25, 50).then(function (it) { return it.results[0]; })")
        .unsafeCast<Promise<*>>()
        .await()

    assertEquals(move1, move2)
  }

  @Test
  fun notFound() = runTest {
    val client = client

    val exception =
      assertFailsWith<ClientRequestException> {
        js("client.getMove(-1)").unsafeCast<Promise<*>>().await()
      }

    assertEquals(HttpStatusCode.NotFound, exception.response.status)
  }
}
