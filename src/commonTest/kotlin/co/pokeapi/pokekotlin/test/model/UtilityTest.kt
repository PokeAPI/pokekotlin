package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class UtilityTest {

  @Test
  fun getLanguage() = runTest {
    LocalPokeApi.getLanguage(9).apply {
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
