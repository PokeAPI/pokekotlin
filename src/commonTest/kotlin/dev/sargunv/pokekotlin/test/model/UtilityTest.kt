package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.Name
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.StaticPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class UtilityTest {

  @Test
  fun getLanguage() = runTest {
    StaticPokeApi.getLanguage(9).apply {
      assertEquals(9, id)
      assertEquals("us", iso3166)
      assertEquals("en", iso639)
      assertEquals("en", name)
      assertContains(
        names,
        Name(name = "English", language = NamedApiResource("en", "language", 9)),
      )
    }
  }
}
