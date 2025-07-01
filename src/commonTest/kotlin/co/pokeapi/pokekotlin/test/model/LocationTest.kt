package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.*
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest

class LocationTest {

  @Test
  fun getLocation() = runTest {
    LocalPokeApi.getLocation(20).apply {
      assertEquals(20, id)
      assertEquals("wayward-cave", name)
      assertEquals(Handle.of(4, "sinnoh"), region)
      assertContains(names, Name(name = "Wayward Cave", language = Handle.of(9, "en")))
      assertContains(
        gameIndices,
        GenerationGameIndex(gameIndex = 65, generation = Handle.of(4, "generation-iv")),
      )
      assertContains(areas, Handle.of(113, "wayward-cave-1f"))
    }
  }

  @Test
  fun getLocationArea() = runTest {
    LocalPokeApi.getLocationArea(20).apply {
      assertEquals(20, id)
      assertEquals("mt-coronet-1f-from-exterior", name)
      assertEquals(20, gameIndex)
      assertEquals(Handle.of(10, "mt-coronet"), location)
      assertContains(
        names,
        Name(name = "Mount Coronet (1F from exterior)", language = Handle.of(9, "en")),
      )
      assertNotNull(
        encounterMethodRates.find {
          it.encounterMethod == Handle.of<EncounterMethod>(1, "walk") &&
            EncounterMethodRateVersionDetail(10, Handle.of(14, "platinum")) in it.versionDetails
        }
      )
      assertNotNull(
        pokemonEncounters.find { pokemonEncounter ->
          pokemonEncounter.pokemon == Handle.of<PokemonVariety>(35, "clefairy") &&
            pokemonEncounter.versionDetails.find { encounterDetail ->
              encounterDetail.version == Handle.of<Version>(12, "diamond") &&
                encounterDetail.maxChance == 27 &&
                encounterDetail.encounterDetails.find { encounter ->
                  encounter.minLevel == 39 &&
                    encounter.maxLevel == 39 &&
                    encounter.chance == 4 &&
                    encounter.method == Handle.of<EncounterMethod>(1, "walk") &&
                    Handle.of(8, "slot2-none") in encounter.conditionValues
                } != null
            } != null
        }
      )
    }
  }

  @Test
  fun getPalParkArea() = runTest {
    LocalPokeApi.getPalParkArea(2).apply {
      assertEquals(2, id)
      assertEquals("field", name)
      assertContains(names, Name(name = "Field", language = Handle.of(9, "en")))
      assertContains(
        pokemonEncounters,
        PalParkEncounterSpecies(
          baseScore = 100,
          rate = 1,
          pokemonSpecies = Handle.of(492, "shaymin"),
        ),
      )
    }
  }

  @Test
  fun getRegion() = runTest {
    LocalPokeApi.getRegion(1).apply {
      assertEquals(1, id)
      assertEquals("kanto", name)
      assertEquals(Handle.of(1, "generation-i"), mainGeneration)
      assertContains(locations, Handle.of(67, "celadon-city"))
      assertContains(names, Name(name = "Kanto", language = Handle.of(9, "en")))
      assertContains(pokedexes, Handle.of(2, "kanto"))
      assertContains(versionGroups, Handle.of(1, "red-blue"))
    }
  }
}
