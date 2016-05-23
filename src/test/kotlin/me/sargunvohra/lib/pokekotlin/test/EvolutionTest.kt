package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.ChainLink
import me.sargunvohra.lib.pokekotlin.json.EvolutionDetail
import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import org.testng.annotations.Test
import kotlin.test.*

class EvolutionTest {

    @Test
    fun getEvolutionChain1() {
        PokeApi.getEvolutionChain(1).promise.get().apply {
            assertEquals(1, id)
            assertEquals(null, babyTriggerItem)
            assertEquals(ChainLink(
                    isBaby = false,
                    species = NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon-species/1/"),
                    evolutionDetails = null,
                    evolvesTo = listOf(ChainLink(
                            isBaby = false,
                            species = NamedApiResource("ivysaur", PokeApi.rootUrl + "pokemon-species/2/"),
                            evolutionDetails = EvolutionDetail(
                                    trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                                    minLevel = 16
                            ),
                            evolvesTo = listOf(ChainLink(
                                    isBaby = false,
                                    species = NamedApiResource("venusaur", PokeApi.rootUrl + "pokemon-species/3/"),
                                    evolutionDetails = EvolutionDetail(
                                            trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                                            minLevel = 32
                                    ),
                                    evolvesTo = emptyList()
                            ))
                    ))
            ), chain)
        }
    }

    @Test
    fun getEvolutionTrigger() {
        PokeApi.getEvolutionTrigger(1).promise.get().apply {
            assertEquals(1, id)
            assertEquals("level-up", name)
            assert(Name(
                    name = "Level up",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NamedApiResource("fletchinder", PokeApi.rootUrl + "pokemon-species/662/") in pokemonSpecies)
        }
    }
}