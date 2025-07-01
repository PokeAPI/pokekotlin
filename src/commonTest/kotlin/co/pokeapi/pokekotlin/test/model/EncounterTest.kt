package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.model.ResourceHandle
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class EncounterTest {

  @Test
  fun getEncounterMethod() = runTest {
    LocalPokeApi.getEncounterMethod(5).apply {
      assertEquals(5, id)
      assertEquals("surf", name)
      assertEquals(14, order)
      assertContains(names, Name(name = "Surfing", language = ResourceHandle.of(9, "en")))
    }
  }

  @Test
  fun getEncounterCondition() = runTest {
    LocalPokeApi.getEncounterCondition(5).apply {
      assertEquals(5, id)
      assertEquals("radio", name)
      assertContains(values, ResourceHandle.of(15, "radio-hoenn"))
      assertContains(names, Name(name = "Radio", language = ResourceHandle.of(9, "en")))
    }
  }

  @Test
  fun getEncounterConditionValue() = runTest {
    LocalPokeApi.getEncounterConditionValue(5).apply {
      assertEquals(5, id)
      assertEquals("time-night", name)
      assertEquals(ResourceHandle.of(2, "time"), condition)
      assertContains(names, Name(name = "At night", language = ResourceHandle.of(9, "en")))
    }
  }
}
