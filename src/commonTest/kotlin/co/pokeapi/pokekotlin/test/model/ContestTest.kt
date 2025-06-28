package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.ContestName
import co.pokeapi.pokekotlin.model.Effect
import co.pokeapi.pokekotlin.model.FlavorText
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class ContestTest {

  @Test
  fun getContestType() = runTest {
    LocalPokeApi.getContestType(4).apply {
      assertEquals(4, id)
      assertEquals("smart", name)
      assertEquals(NamedApiResource("bitter", "berry-flavor", 4), berryFlavor)
      assertContains(
        names,
        ContestName(
          name = "Smart",
          color = "Green",
          language = NamedApiResource("en", "language", 9),
        ),
      )
    }
  }

  @Test
  fun getContestEffect() = runTest {
    LocalPokeApi.getContestEffect(27).apply {
      assertEquals(27, id)
      assertEquals(2, appeal)
      assertEquals(0, jam)
      assertContains(
        effectEntries,
        Effect(
          effect = "If user appeals first this turn, earns six points instead of two.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(
        flavorTextEntries,
        FlavorText(
          flavorText = "The appeal works great if performed first.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
    }
  }

  @Test
  fun getSuperContestEffect() = runTest {
    LocalPokeApi.getSuperContestEffect(14).apply {
      assertEquals(14, id)
      assertEquals(2, appeal)
      assertContains(
        flavorTextEntries,
        FlavorText(
          flavorText = "Makes the order of contestants random in the next turn.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(moves, NamedApiResource("assist", "move", 274))
    }
  }
}
