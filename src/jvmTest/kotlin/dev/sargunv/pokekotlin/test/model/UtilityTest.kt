package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.Name
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.MockServer
import kotlin.test.assertEquals
import org.junit.Test

class UtilityTest {

  @Test
  fun getLanguage() {
    MockServer.client.getLanguage(9).apply {
      assertEquals(9, id)
      assertEquals("us", iso3166)
      assertEquals("en", iso639)
      assertEquals("en", name)
      assert(Name(name = "English", language = NamedApiResource("en", "language", 9)) in names)
    }
  }
}
