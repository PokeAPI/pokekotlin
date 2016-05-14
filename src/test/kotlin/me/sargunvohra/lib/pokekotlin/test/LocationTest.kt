package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LocationTest {

    @Test
    fun getLocation() {
        PokeApi.getLocation(20).promise.get().apply {
            assertEquals(20, id)
            assertEquals("wayward-cave", name)
            assertEquals(NamedApiResource("sinnoh", PokeApi.rootUrl + "region/4/"), region)
            assert(Name(
                    name = "Wayward Cave",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(GenerationGameIndex(
                    gameIndex = 65,
                    generation = NamedApiResource("generation-iv", PokeApi.rootUrl + "generation/4/")
            ) in gameIndices)
            assert(NamedApiResource("wayward-cave-1f", PokeApi.rootUrl + "location-area/113/") in areas)
        }
    }

    @Test
    fun getLocationArea() {
        PokeApi.getLocationArea(20).promise.get().apply {
            assertEquals(20, id)
            assertEquals("mt-coronet-cave", name)
            assertEquals(20, gameIndex)
            assertEquals(NamedApiResource("mt-coronet", PokeApi.rootUrl + "location/10/"), location)
            assert(Name(
                    name = "cave",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assertNotNull(encounterMethodRates.find {
                it.encounterMethod == NamedApiResource<EncounterMethod>("walk", PokeApi.rootUrl + "encounter-method/1/") &&
                        EncounterMethodRateVersionDetail(10, NamedApiResource("platinum", PokeApi.rootUrl + "version/14/")) in it.versionDetails
            })
            assertNotNull(pokemonEncounters.find {
                it.pokemon == NamedApiResource<Pokemon>("clefairy", PokeApi.rootUrl + "pokemon/35/") &&
                        it.versionDetails.find {
                            it.version == NamedApiResource<Version>("diamond", PokeApi.rootUrl + "version/12/") &&
                                    it.maxChance == 27 &&
                                    it.encounterDetails.find {
                                        it.minLevel == 39 &&
                                                it.maxLevel == 39 &&
                                                it.chance == 4 &&
                                                it.method == NamedApiResource<EncounterMethod>("walk", PokeApi.rootUrl + "encounter-method/1/") &&
                                                NamedApiResource("slot2-none", PokeApi.rootUrl + "encounter-condition-value/8/") in it.conditionValues
                                    } != null
                        } != null
            })
        }
    }

    @Test
    fun getPalParkArea() {
        PokeApi.getPalParkArea(2).promise.get().apply {
            assertEquals(2, id)
            assertEquals("field", name)
            assert(Name(
                    name = "Field",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(PalParkEncounterSpecies(
                    baseScore = 100,
                    rate = 1,
                    pokemonSpecies = NamedApiResource("shaymin", PokeApi.rootUrl + "pokemon-species/492/")
            ) in pokemonEncounters)
        }
    }

    @Test
    fun getRegion() {
        PokeApi.getRegion(1).promise.get().apply {
            assertEquals(1, id)
            assertEquals("kanto", name)
            assertEquals(NamedApiResource("generation-i", PokeApi.rootUrl + "generation/1/"), mainGeneration)
            assert(NamedApiResource("celadon-city", PokeApi.rootUrl + "location/67/") in locations)
            assert(Name(
                    name = "Kanto",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NamedApiResource("kanto", PokeApi.rootUrl + "pokedex/2/") in pokedexes)
            assert(NamedApiResource("red-blue", PokeApi.rootUrl + "version-group/1/") in versionGroups)
        }
    }
}