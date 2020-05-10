package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import me.sargunvohra.lib.pokekotlin.model.ChainLink
import me.sargunvohra.lib.pokekotlin.model.EvolutionDetail
import me.sargunvohra.lib.pokekotlin.model.Name
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class EvolutionTest {

    @Test
    fun getEvolutionChain1() {
        MockServer.client.getEvolutionChain(1).apply {
            assertEquals(1, id)
            assertEquals(null, babyTriggerItem)
            assertEquals(
                ChainLink(
                    isBaby = false,
                    species = NamedApiResource("bulbasaur", "pokemon-species", 1),
                    evolutionDetails = emptyList(),
                    evolvesTo = listOf(
                        ChainLink(
                            isBaby = false,
                            species = NamedApiResource("ivysaur", "pokemon-species", 2),
                            evolutionDetails = listOf(
                                EvolutionDetail(
                                    trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                                    minLevel = 16
                                )
                            ),
                            evolvesTo = listOf(
                                ChainLink(
                                    isBaby = false,
                                    species = NamedApiResource("venusaur", "pokemon-species", 3),
                                    evolutionDetails = listOf(
                                        EvolutionDetail(
                                            trigger = NamedApiResource(
                                                "level-up",
                                                "evolution-trigger",
                                                1
                                            ),
                                            minLevel = 32
                                        )
                                    ),
                                    evolvesTo = emptyList()
                                )
                            )
                        )
                    )
                ), chain
            )
        }
    }

    @Test
    fun getEvolutionChain2() {
        MockServer.client.getEvolutionChain(109).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        heldItem = NamedApiResource("razor-claw", "item", 303),
                        timeOfDay = "night"
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain3() {
        MockServer.client.getEvolutionChain(67).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("use-item", "evolution-trigger", 3),
                        item = NamedApiResource("water-stone", "item", 84)
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain4() {
        MockServer.client.getEvolutionChain(67).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        location = NamedApiResource("eterna-forest", "location", 8)
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain5() {
        MockServer.client.getEvolutionChain(67).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minHappiness = 220,
                        timeOfDay = "day"
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain6() {
        MockServer.client.getEvolutionChain(67).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        knownMoveType = NamedApiResource("fairy", "type", 18),
                        minAffection = 2
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain7() {
        MockServer.client.getEvolutionChain(112).apply {
            assert(
                chain.evolvesTo[0].evolvesTo[0].evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        knownMove = NamedApiResource("ancient-power", "move", 246)
                    )
                )
            )
        }
    }

    @Test
    fun getEvolutionChain8() {
        MockServer.client.getEvolutionChain(213).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        gender = 1,
                        minLevel = 20
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain9() {
        MockServer.client.getEvolutionChain(178).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minBeauty = 171
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain10() {
        MockServer.client.getEvolutionChain(346).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minLevel = 32,
                        partyType = NamedApiResource("dark", "type", 17)
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain11() {
        MockServer.client.getEvolutionChain(47).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minLevel = 20,
                        relativePhysicalStats = 1
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain12() {
        MockServer.client.getEvolutionChain(362).apply {
            assertNotNull(chain.evolvesTo[0].evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minLevel = 50,
                        needsOverworldRain = true
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain13() {
        MockServer.client.getEvolutionChain(352).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        minLevel = 30,
                        turnUpsideDown = true
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain14() {
        MockServer.client.getEvolutionChain(116).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                        partySpecies = NamedApiResource("remoraid", "pokemon-species", 223)
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain15() {
        MockServer.client.getEvolutionChain(312).apply {
            assertNotNull(chain.evolvesTo.find {
                it.evolutionDetails.contains(
                    EvolutionDetail(
                        trigger = NamedApiResource("trade", "evolution-trigger", 2),
                        tradeSpecies = NamedApiResource("karrablast", "pokemon-species", 588)
                    )
                )
            })
        }
    }

    @Test
    fun getEvolutionChain16() {
        MockServer.client.getEvolutionChain(72).apply {
            assertEquals(NamedApiResource("full-incense", "item", 293), babyTriggerItem)
            assertEquals(true, chain.isBaby)
        }
    }

    @Test
    fun getEvolutionTrigger() {
        MockServer.client.getEvolutionTrigger(1).apply {
            assertEquals(1, id)
            assertEquals("level-up", name)
            assert(
                Name(
                    name = "Level up",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
            assert(NamedApiResource("fletchinder", "pokemon-species", 662) in pokemonSpecies)
        }
    }
}
