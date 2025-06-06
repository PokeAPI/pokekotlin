package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.client.PokeApiClient
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class LiveTest {

  private val liveClient = PokeApiClient()

  @Test
  fun liveObject() = runTest {
    assertEquals(MockServer.client.getBerry(10).name, liveClient.getBerry(10).name)
  }

  @Test
  fun liveList() = runTest {
    assertEquals(
      liveClient.getMoveList(0, 50).results[25],
      liveClient.getMoveList(25, 50).results[0],
    )
  }
}
