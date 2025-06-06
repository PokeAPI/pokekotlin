package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.client.PokeApiClient
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

@Ignore
class LiveTest {

  private val liveClient = PokeApiClient()

  @Test fun liveObject() = runTest { assertEquals("sitrus", liveClient.getBerry(10).name) }

  @Test
  fun liveList() = runTest {
    assertEquals(
      liveClient.getMoveList(0, 50).results[25],
      liveClient.getMoveList(25, 50).results[0],
    )
  }
}
