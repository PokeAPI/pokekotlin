package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.Name
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.MockServer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class EncounterTest {

  @Test
  fun getEncounterMethod() = runTest {
    MockServer.client.getEncounterMethod(5).apply {
      assertEquals(5, id)
      assertEquals("surf", name)
      assertEquals(14, order)
      assert(Name(name = "Surfing", language = NamedApiResource("en", "language", 9)) in names)
    }
  }

  @Test
  fun getEncounterCondition() = runTest {
    MockServer.client.getEncounterCondition(5).apply {
      assertEquals(5, id)
      assertEquals("radio", name)
      assert(NamedApiResource("radio-hoenn", "encounter-condition-value", 15) in values)
      assert(Name(name = "Radio", language = NamedApiResource("en", "language", 9)) in names)
    }
  }

  @Test
  fun getEncounterConditionValue() = runTest {
    MockServer.client.getEncounterConditionValue(5).apply {
      assertEquals(5, id)
      assertEquals("time-night", name)
      assertEquals(NamedApiResource("time", "encounter-condition", 2), condition)
      assert(Name(name = "At night", language = NamedApiResource("en", "language", 9)) in names)
    }
  }
}
