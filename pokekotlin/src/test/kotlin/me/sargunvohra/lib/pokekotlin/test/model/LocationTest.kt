package me.sargunvohra.lib.pokekotlin.test.model

import me.sargunvohra.lib.pokekotlin.model.*
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocationTest {

    @Test
    fun getLocation() {
        mockClient.getLocation(20).apply {
            assertEquals(20, id)
            assertEquals("wayward-cave", name)
            assertEquals(NamedApiResource("sinnoh", "region", 4), region)
            assert(Name(
                    name = "Wayward Cave",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(GenerationGameIndex(
                    gameIndex = 65,
                    generation = NamedApiResource("generation-iv", "generation", 4)
            ) in gameIndices)
            assert(NamedApiResource("wayward-cave-1f", "location-area", 113) in areas)
        }
    }

    @Test
    fun getLocationArea() {
        mockClient.getLocationArea(20).apply {
            assertEquals(20, id)
            assertEquals("mt-coronet-cave", name)
            assertEquals(20, gameIndex)
            assertEquals(NamedApiResource("mt-coronet", "location", 10), location)
            assert(Name(
                    name = "cave",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assertNotNull(encounterMethodRates.find {
                it.encounterMethod == NamedApiResource("walk", "encounter-method", 1) &&
                        EncounterMethodRateVersionDetail(10, NamedApiResource("platinum", "version", 14)) in it.versionDetails
            })
            assertNotNull(pokemonEncounters.find {
                it.pokemon == NamedApiResource("clefairy", "pokemon", 35) &&
                        it.versionDetails.find {
                            it.version == NamedApiResource("diamond", "version", 12) &&
                                    it.maxChance == 27 &&
                                    it.encounterDetails.find {
                                        it.minLevel == 39 &&
                                                it.maxLevel == 39 &&
                                                it.chance == 4 &&
                                                it.method == NamedApiResource("walk", "encounter-method", 1) &&
                                                NamedApiResource("slot2-none", "encounter-condition-value", 8) in it.conditionValues
                                    } != null
                        } != null
            })
        }
    }

    @Test
    fun getPalParkArea() {
        mockClient.getPalParkArea(2).apply {
            assertEquals(2, id)
            assertEquals("field", name)
            assert(Name(
                    name = "Field",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(PalParkEncounterSpecies(
                    baseScore = 100,
                    rate = 1,
                    pokemonSpecies = NamedApiResource("shaymin", "pokemon-species", 492)
            ) in pokemonEncounters)
        }
    }

    @Test
    fun getRegion() {
        mockClient.getRegion(1).apply {
            assertEquals(1, id)
            assertEquals("kanto", name)
            assertEquals(NamedApiResource("generation-i", "generation", 1), mainGeneration)
            assert(NamedApiResource("celadon-city", "location", 67) in locations)
            assert(Name(
                    name = "Kanto",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NamedApiResource("kanto", "pokedex", 2) in pokedexes)
            assert(NamedApiResource("red-blue", "version-group", 1) in versionGroups)
        }
    }
}