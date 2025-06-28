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
      assertEquals(NamedApiResource("sinnoh", "region", 4), region)
      assertContains(
        names,
        Name(name = "Wayward Cave", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        gameIndices,
        GenerationGameIndex(
          gameIndex = 65,
          generation = NamedApiResource("generation-iv", "generation", 4),
        ),
      )
      assertContains(areas, NamedApiResource("wayward-cave-1f", "location-area", 113))
    }
  }

  @Test
  fun getLocationArea() = runTest {
    LocalPokeApi.getLocationArea(20).apply {
      assertEquals(20, id)
      assertEquals("mt-coronet-1f-from-exterior", name)
      assertEquals(20, gameIndex)
      assertEquals(NamedApiResource("mt-coronet", "location", 10), location)
      assertContains(
        names,
        Name(
          name = "Mount Coronet (1F from exterior)",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertNotNull(
        encounterMethodRates.find {
          it.encounterMethod == NamedApiResource("walk", "encounter-method", 1) &&
            EncounterMethodRateVersionDetail(10, NamedApiResource("platinum", "version", 14)) in
              it.versionDetails
        }
      )
      assertNotNull(
        pokemonEncounters.find { pokemonEncounter ->
          pokemonEncounter.pokemon == NamedApiResource("clefairy", "pokemon", 35) &&
            pokemonEncounter.versionDetails.find { encounterDetail ->
              encounterDetail.version == NamedApiResource("diamond", "version", 12) &&
                encounterDetail.maxChance == 27 &&
                encounterDetail.encounterDetails.find { encounter ->
                  encounter.minLevel == 39 &&
                    encounter.maxLevel == 39 &&
                    encounter.chance == 4 &&
                    encounter.method == NamedApiResource("walk", "encounter-method", 1) &&
                    NamedApiResource("slot2-none", "encounter-condition-value", 8) in
                      encounter.conditionValues
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
      assertContains(names, Name(name = "Field", language = NamedApiResource("en", "language", 9)))
      assertContains(
        pokemonEncounters,
        PalParkEncounterSpecies(
          baseScore = 100,
          rate = 1,
          pokemonSpecies = NamedApiResource("shaymin", "pokemon-species", 492),
        ),
      )
    }
  }

  @Test
  fun getRegion() = runTest {
    LocalPokeApi.getRegion(1).apply {
      assertEquals(1, id)
      assertEquals("kanto", name)
      assertEquals(NamedApiResource("generation-i", "generation", 1), mainGeneration)
      assertContains(locations, NamedApiResource("celadon-city", "location", 67))
      assertContains(names, Name(name = "Kanto", language = NamedApiResource("en", "language", 9)))
      assertContains(pokedexes, NamedApiResource("kanto", "pokedex", 2))
      assertContains(versionGroups, NamedApiResource("red-blue", "version-group", 1))
    }
  }
}
