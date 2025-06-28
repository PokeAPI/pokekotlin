package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.FlavorBerryMap
import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlinx.coroutines.test.runTest

class BerryTest {

  @Test
  fun getBerry() = runTest {
    LocalPokeApi.getBerry(34).apply {
      assertEquals(34, id)
      assertEquals("durin", name)
      assertEquals(15, growthTime)
      assertEquals(15, maxHarvest)
      assertEquals(80, naturalGiftPower)
      assertEquals(280, size)
      assertEquals(35, smoothness)
      assertEquals(8, soilDryness)
      assertEquals(NamedApiResource("hard", "berry-firmness", 3), firmness)
      assertNotEquals(0, flavors.size)
      assertEquals(NamedApiResource("durin-berry", "item", 159), item)
      assertEquals(NamedApiResource("water", "type", 11), naturalGiftType)
    }
  }

  @Test
  fun getBerryFirmness() = runTest {
    LocalPokeApi.getBerryFirmness(3).apply {
      assertEquals(3, id)
      assertEquals("hard", name)
      assertContains(berries, NamedApiResource("rawst", "berry", 4))
      assertContains(names, Name(name = "Hard", language = NamedApiResource("en", "language", 9)))
    }
  }

  @Test
  fun getBerryFlavor() = runTest {
    LocalPokeApi.getBerryFlavor(3).apply {
      assertEquals(3, id)
      assertEquals("sweet", name)
      assertEquals(NamedApiResource("cute", "contest-type", 3), contestType)
      assertContains(
        berries,
        FlavorBerryMap(potency = 10, berry = NamedApiResource("leppa", "berry", 6)),
      )
      assertContains(names, Name(name = "Sweet", language = NamedApiResource("en", "language", 9)))
    }
  }
}
