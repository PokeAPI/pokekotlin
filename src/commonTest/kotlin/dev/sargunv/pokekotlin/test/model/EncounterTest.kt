package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.Name
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.LocalPokeApi
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
      assertContains(
        names,
        Name(name = "Surfing", language = NamedApiResource("en", "language", 9)),
      )
    }
  }

  @Test
  fun getEncounterCondition() = runTest {
    LocalPokeApi.getEncounterCondition(5).apply {
      assertEquals(5, id)
      assertEquals("radio", name)
      assertContains(values, NamedApiResource("radio-hoenn", "encounter-condition-value", 15))
      assertContains(names, Name(name = "Radio", language = NamedApiResource("en", "language", 9)))
    }
  }

  @Test
  fun getEncounterConditionValue() = runTest {
    LocalPokeApi.getEncounterConditionValue(5).apply {
      assertEquals(5, id)
      assertEquals("time-night", name)
      assertEquals(NamedApiResource("time", "encounter-condition", 2), condition)
      assertContains(
        names,
        Name(name = "At night", language = NamedApiResource("en", "language", 9)),
      )
    }
  }
}
