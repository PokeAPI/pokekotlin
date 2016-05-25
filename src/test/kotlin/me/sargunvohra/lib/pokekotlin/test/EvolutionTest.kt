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
                    evolutionDetails = emptyList(),
                    evolvesTo = listOf(ChainLink(
                            isBaby = false,
                            species = NamedApiResource("ivysaur", PokeApi.rootUrl + "pokemon-species/2/"),
                            evolutionDetails = listOf(EvolutionDetail(
                                    trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                                    minLevel = 16
                            )),
                            evolvesTo = listOf(ChainLink(
                                    isBaby = false,
                                    species = NamedApiResource("venusaur", PokeApi.rootUrl + "pokemon-species/3/"),
                                    evolutionDetails = listOf(EvolutionDetail(
                                            trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                                            minLevel = 32
                                    )),
                                    evolvesTo = emptyList()
                            ))
                    ))
            ), chain)
        }
    }

    @Test
    fun getEvolutionChain2() {
        PokeApi.getEvolutionChain(109).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        heldItem = NamedApiResource("razor-claw", PokeApi.rootUrl + "item/303/"),
                        timeOfDay = "night"
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain3() {
        PokeApi.getEvolutionChain(67).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("use-item", PokeApi.rootUrl + "evolution-trigger/3/"),
                        item = NamedApiResource("water-stone", PokeApi.rootUrl + "item/84/")
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain4() {
        PokeApi.getEvolutionChain(67).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        location = NamedApiResource("eterna-forest", PokeApi.rootUrl + "location/8/")
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain5() {
        PokeApi.getEvolutionChain(67).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minHappiness = 220,
                        timeOfDay = "day"
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain6() {
        PokeApi.getEvolutionChain(67).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        knownMoveType = NamedApiResource("fairy", PokeApi.rootUrl + "type/18/"),
                        minAffection = 2
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain7() {
        PokeApi.getEvolutionChain(112).promise.get().apply {
            assert(chain.evolvesTo[0].evolvesTo[0].evolutionDetails.contains(EvolutionDetail(
                    trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                    knownMove = NamedApiResource("ancient-power", PokeApi.rootUrl + "move/246/")
            )))
        }
    }

    @Test
    fun getEvolutionChain8() {
        PokeApi.getEvolutionChain(213).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        gender = 1,
                        minLevel = 20
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain9() {
        PokeApi.getEvolutionChain(178).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minBeauty = 171
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain10() {
        PokeApi.getEvolutionChain(346).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minLevel = 32,
                        partyType = NamedApiResource("dark", PokeApi.rootUrl + "type/17/")
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain11() {
        PokeApi.getEvolutionChain(47).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minLevel = 20,
                        relativePhysicalStats = 1
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain12() {
        PokeApi.getEvolutionChain(362).promise.get().apply {
            assertNotNull(chain.evolvesTo[0].evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minLevel = 50,
                        needsOverworldRain = true
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain13() {
        PokeApi.getEvolutionChain(352).promise.get().apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(EvolutionDetail(
                        trigger = NamedApiResource("level-up", PokeApi.rootUrl + "evolution-trigger/1/"),
                        minLevel = 30,
                        turnUpsideDown = true
                ))
            })
        }
    }

    @Test
    fun getEvolutionChain14() {
        PokeApi.getEvolutionChain(72).promise.get().apply {
            assertEquals(NamedApiResource("full-incense", PokeApi.rootUrl + "item/293/"), babyTriggerItem)
            assertEquals(true, chain.isBaby)
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