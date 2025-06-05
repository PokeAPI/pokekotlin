package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.ContestName
import dev.sargunv.pokekotlin.model.Effect
import dev.sargunv.pokekotlin.model.FlavorText
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.MockServer
import kotlin.test.assertEquals
import org.junit.Test

class ContestTest {

  @Test
  fun getContestType() {
    MockServer.client.getContestType(4).apply {
      assertEquals(4, id)
      assertEquals("smart", name)
      assertEquals(NamedApiResource("bitter", "berry-flavor", 4), berryFlavor)
      assert(
        ContestName(
          name = "Smart",
          color = "Green",
          language = NamedApiResource("en", "language", 9),
        ) in names
      )
    }
  }

  @Test
  fun getContestEffect() {
    MockServer.client.getContestEffect(27).apply {
      assertEquals(27, id)
      assertEquals(2, appeal)
      assertEquals(0, jam)
      assert(
        Effect(
          effect = "If user appeals first this turn, earns six points instead of two.",
          language = NamedApiResource("en", "language", 9),
        ) in effectEntries
      )
      assert(
        FlavorText(
          flavorText = "The appeal works great if performed first.",
          language = NamedApiResource("en", "language", 9),
        ) in flavorTextEntries
      )
    }
  }

  @Test
  fun getSuperContestEffect() {
    MockServer.client.getSuperContestEffect(14).apply {
      assertEquals(14, id)
      assertEquals(2, appeal)
      assert(
        FlavorText(
          flavorText = "Makes the order of contestants random in the next turn.",
          language = NamedApiResource("en", "language", 9),
        ) in flavorTextEntries
      )
      assert(NamedApiResource("assist", "move", 274) in moves)
    }
  }
}
