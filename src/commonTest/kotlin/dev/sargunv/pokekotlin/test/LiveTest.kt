package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.client.PokeApi
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

@Ignore
class LiveTest {

  @Test fun liveObject() = runTest { assertEquals("sitrus", PokeApi.getBerry(10).name) }

  @Test
  fun liveList() = runTest {
    assertEquals(PokeApi.getMoveList(0, 50).results[25], PokeApi.getMoveList(25, 50).results[0])
  }
}
