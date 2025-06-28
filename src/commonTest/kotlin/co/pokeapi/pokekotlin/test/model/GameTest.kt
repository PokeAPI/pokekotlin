package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Description
import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.model.PokemonEntry
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GameTest {

  @Test
  fun getGeneration() = runTest {
    LocalPokeApi.getGeneration(6).apply {
      assertEquals(6, id)
      assertEquals("generation-vi", name)
      assertContains(abilities, NamedApiResource("primordial-sea", "ability", 189))
      assertContains(
        names,
        Name(name = "Generation VI", language = NamedApiResource("en", "language", 9)),
      )
      assertEquals(NamedApiResource("kalos", "region", 6), mainRegion)
      assertContains(moves, NamedApiResource("belch", "move", 562))
      assertContains(pokemonSpecies, NamedApiResource("froakie", "pokemon-species", 656))
      assertContains(types, NamedApiResource("fairy", "type", 18))
      assertContains(versionGroups, NamedApiResource("x-y", "version-group", 15))
    }
  }

  @Test
  fun getPokedex() = runTest {
    LocalPokeApi.getPokedex(12).apply {
      assertEquals(12, id)
      assertEquals("kalos-central", name)
      assertEquals(true, isMainSeries)
      assertContains(
        descriptions,
        Description(description = "", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        names,
        Name(name = "Central Kalos", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        pokemonEntries,
        PokemonEntry(
          entryNumber = 150,
          pokemonSpecies = NamedApiResource("haxorus", "pokemon-species", 612),
        ),
      )
      assertEquals(NamedApiResource("kalos", "region", 6), region)
      assertContains(versionGroups, NamedApiResource("x-y", "version-group", 15))
    }
  }

  @Test
  fun getVersion() = runTest {
    LocalPokeApi.getVersion(9).apply {
      assertEquals(9, id)
      assertEquals("emerald", name)
      assertContains(
        names,
        Name(name = "Emerald", language = NamedApiResource("en", "language", 9)),
      )
      assertEquals(NamedApiResource("emerald", "version-group", 6), versionGroup)
    }
  }

  @Test
  fun getVersionGroup() = runTest {
    LocalPokeApi.getVersionGroup(1).apply {
      assertEquals(1, id)
      assertEquals("red-blue", name)
      assertEquals(3, order)
      assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
      assertContains(moveLearnMethods, NamedApiResource("machine", "move-learn-method", 4))
      assertContains(pokedexes, NamedApiResource("kanto", "pokedex", 2))
      assertContains(regions, NamedApiResource("kanto", "region", 1))
      assertContains(versions, NamedApiResource("red", "version", 1))
    }
  }
}
