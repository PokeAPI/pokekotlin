package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import me.sargunvohra.lib.pokekotlin.model.Description
import me.sargunvohra.lib.pokekotlin.model.Name
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.model.PokemonEntry
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class GameTest {

    @Test
    fun getGeneration() {
        MockServer.client.getGeneration(6).apply {
            assertEquals(6, id)
            assertEquals("generation-vi", name)
            assert(NamedApiResource("primordial-sea", "ability", 189) in abilities)
            assert(
                Name(
                    name = "Generation VI",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
            assertEquals(NamedApiResource("kalos", "region", 6), mainRegion)
            assert(NamedApiResource("belch", "move", 562) in moves)
            assert(NamedApiResource("froakie", "pokemon-species", 656) in pokemonSpecies)
            assert(NamedApiResource("fairy", "type", 18) in types)
            assert(NamedApiResource("x-y", "version-group", 15) in versionGroups)
        }
    }

    @Test
    fun getPokedex() {
        MockServer.client.getPokedex(12).apply {
            assertEquals(12, id)
            assertEquals("kalos-central", name)
            assertEquals(true, isMainSeries)
            assert(
                Description(
                    description = "",
                    language = NamedApiResource("en", "language", 9)
                ) in descriptions
            )
            assert(
                Name(
                    name = "Central Kalos",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
            assert(
                PokemonEntry(
                    entryNumber = 150,
                    pokemonSpecies = NamedApiResource("haxorus", "pokemon-species", 612)
                ) in pokemonEntries
            )
            assertEquals(NamedApiResource("kalos", "region", 6), region)
            assert(NamedApiResource("x-y", "version-group", 15) in versionGroups)
        }
    }

    @Test
    fun getVersion() {
        MockServer.client.getVersion(9).apply {
            assertEquals(9, id)
            assertEquals("emerald", name)
            assert(
                Name(
                    name = "Emerald",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
            assertEquals(NamedApiResource("emerald", "version-group", 6), versionGroup)
        }
    }

    @Test
    fun getVersionGroup() {
        MockServer.client.getVersionGroup(1).apply {
            assertEquals(1, id)
            assertEquals("red-blue", name)
            assertEquals(1, order)
            assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
            assert(NamedApiResource("machine", "move-learn-method", 4) in moveLearnMethods)
            assert(NamedApiResource("kanto", "pokedex", 2) in pokedexes)
            assert(NamedApiResource("kanto", "region", 1) in regions)
            assert(NamedApiResource("red", "version", 1) in versions)
        }
    }
}
