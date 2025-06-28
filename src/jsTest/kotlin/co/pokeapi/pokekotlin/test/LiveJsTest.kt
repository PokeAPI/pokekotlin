package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.PokeApi
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
  private val client: PokeApi =
    js("require('./pokekotlin.js').co.pokeapi.pokekotlin.PokeApi.Default")

  @Test
  fun resource() = runTest {
    val client = client
    assertEquals(
      "sitrus",
      js("client.getBerryAsync(10).then(function (it) { return it.name; })")
        .unsafeCast<Promise<String>>()
        .await(),
    )
  }

  @Test
  fun list() = runTest {
    val client = client

    val berry1 =
      js("client.getBerryListAsync(0, 10).then(function (it) { return it.results[5]; })")
        .unsafeCast<Promise<*>>()
        .await()

    val berry2 =
      js("client.getBerryListAsync(5, 15).then(function (it) { return it.results[0]; })")
        .unsafeCast<Promise<*>>()
        .await()

    assertEquals(berry1, berry2)
  }

  @Test
  fun notFound() = runTest {
    val client = client

    val exception =
      assertFailsWith<ClientRequestException> {
        js("client.getMoveAsync(-1)").unsafeCast<Promise<*>>().await()
      }

    assertEquals(HttpStatusCode.NotFound, exception.response.status)
  }
}
