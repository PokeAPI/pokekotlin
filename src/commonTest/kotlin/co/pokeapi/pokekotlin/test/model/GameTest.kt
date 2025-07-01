package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Description
import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.Name
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
      assertContains(abilities, Handle.of(189, "primordial-sea"))
      assertContains(names, Name(name = "Generation VI", language = Handle.of(9, "en")))
      assertEquals(Handle.of(6, "kalos"), mainRegion)
      assertContains(moves, Handle.of(562, "belch"))
      assertContains(pokemonSpecies, Handle.of(656, "froakie"))
      assertContains(types, Handle.of(18, "fairy"))
      assertContains(versionGroups, Handle.of(15, "x-y"))
    }
  }

  @Test
  fun getPokedex() = runTest {
    LocalPokeApi.getPokedex(12).apply {
      assertEquals(12, id)
      assertEquals("kalos-central", name)
      assertEquals(true, isMainSeries)
      assertContains(descriptions, Description(description = "", language = Handle.of(9, "en")))
      assertContains(names, Name(name = "Central Kalos", language = Handle.of(9, "en")))
      assertContains(
        pokemonEntries,
        PokemonEntry(entryNumber = 150, pokemonSpecies = Handle.of(612, "haxorus")),
      )
      assertEquals(Handle.of(6, "kalos"), region)
      assertContains(versionGroups, Handle.of(15, "x-y"))
    }
  }

  @Test
  fun getVersion() = runTest {
    LocalPokeApi.getVersion(9).apply {
      assertEquals(9, id)
      assertEquals("emerald", name)
      assertContains(names, Name(name = "Emerald", language = Handle.of(9, "en")))
      assertEquals(Handle.of(6, "emerald"), versionGroup)
    }
  }

  @Test
  fun getVersionGroup() = runTest {
    LocalPokeApi.getVersionGroup(1).apply {
      assertEquals(1, id)
      assertEquals("red-blue", name)
      assertEquals(3, order)
      assertEquals(Handle.of(1, "generation-i"), generation)
      assertContains(moveLearnMethods, Handle.of(4, "machine"))
      assertContains(pokedexes, Handle.of(2, "kanto"))
      assertContains(regions, Handle.of(1, "kanto"))
      assertContains(versions, Handle.of(1, "red"))
    }
  }
}
