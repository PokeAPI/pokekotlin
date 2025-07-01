package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.FlavorBerryMap
import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.Name
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
      assertEquals(Handle.of(3, "hard"), firmness)
      assertNotEquals(0, flavors.size)
      assertEquals(Handle.of(159, "durin-berry"), item)
      assertEquals(Handle.of(11, "water"), naturalGiftType)
    }
  }

  @Test
  fun getBerryFirmness() = runTest {
    LocalPokeApi.getBerryFirmness(3).apply {
      assertEquals(3, id)
      assertEquals("hard", name)
      assertContains(berries, Handle.of(4, "rawst"))
      assertContains(names, Name(name = "Hard", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getBerryFlavor() = runTest {
    LocalPokeApi.getBerryFlavor(3).apply {
      assertEquals(3, id)
      assertEquals("sweet", name)
      assertEquals(Handle.of(3, "cute"), contestType)
      assertContains(berries, FlavorBerryMap(potency = 10, berry = Handle.of(6, "leppa")))
      assertContains(names, Name(name = "Sweet", language = Handle.of(9, "en")))
    }
  }
}
