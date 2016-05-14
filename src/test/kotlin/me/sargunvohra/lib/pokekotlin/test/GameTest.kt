package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun getGeneration() {
        PokeApi.getGeneration(6).promise.get().apply {
            assertEquals(6, id)
            assertEquals("generation-vi", name)
            assert(NamedApiResource("primordial-sea", PokeApi.rootUrl + "ability/189/") in abilities)
            assert(Name(
                    name = "Generation VI",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assertEquals(NamedApiResource("kalos", PokeApi.rootUrl + "region/6/"), mainRegion)
            assert(NamedApiResource("belch", PokeApi.rootUrl + "move/562/") in moves)
            assert(NamedApiResource("froakie", PokeApi.rootUrl + "pokemon-species/656/") in pokemonSpecies)
            assert(NamedApiResource("fairy", PokeApi.rootUrl + "type/18/") in types)
            assert(NamedApiResource("x-y", PokeApi.rootUrl + "version-group/15/") in versionGroups)
        }
    }

    @Test
    fun getPokedex() {
        PokeApi.getPokedex(12).promise.get().apply {
            assertEquals(12, id)
            assertEquals("kalos-central", name)
            assertEquals(true, isMainSeries)
            assert(Description(
                    description = "",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in descriptions)
            assert(Name(
                    name = "Central Kalos",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(PokemonEntry(
                    entryNumber = 150,
                    pokemonSpecies = NamedApiResource("haxorus", PokeApi.rootUrl + "pokemon-species/612/")
            ) in pokemonEntries)
            assertEquals(NamedApiResource("kalos", PokeApi.rootUrl + "region/6/"), region)
            assert(NamedApiResource("x-y", PokeApi.rootUrl + "version-group/15/") in versionGroups)
        }
    }

    @Test
    fun getVersion() {
        PokeApi.getVersion(9).promise.get().apply {
            assertEquals(9, id)
            assertEquals("emerald", name)
            assert(Name(
                    name = "Emerald",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assertEquals(NamedApiResource("emerald", PokeApi.rootUrl + "version-group/6/"), versionGroup)
        }
    }

    @Test
    fun getVersionGroup() {
        PokeApi.getVersionGroup(1).promise.get().apply {
            assertEquals(1, id)
            assertEquals("red-blue", name)
            assertEquals(1, order)
            assertEquals(NamedApiResource("generation-i", PokeApi.rootUrl + "generation/1/"), generation)
            assert(NamedApiResource("machine", PokeApi.rootUrl + "move-learn-method/4/") in moveLearnMethods)
            assert(NamedApiResource("kanto", PokeApi.rootUrl + "pokedex/2/") in pokedexes)
            assert(NamedApiResource("kanto", PokeApi.rootUrl + "region/1/") in regions)
            assert(NamedApiResource("red", PokeApi.rootUrl + "version/1/") in versions)
        }
    }
}