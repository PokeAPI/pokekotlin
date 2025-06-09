package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.ChainLink
import co.pokeapi.pokekotlin.model.EvolutionDetail
import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest

class EvolutionTest {

  @Test
  fun getEvolutionChain1() = runTest {
    LocalPokeApi.getEvolutionChain(1).apply {
      assertEquals(1, id)
      assertEquals(null, babyTriggerItem)
      assertEquals(
        ChainLink(
          isBaby = false,
          species = NamedApiResource("bulbasaur", "pokemon-species", 1),
          evolutionDetails = emptyList(),
          evolvesTo =
            listOf(
              ChainLink(
                isBaby = false,
                species = NamedApiResource("ivysaur", "pokemon-species", 2),
                evolutionDetails =
                  listOf(
                    EvolutionDetail(
                      trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                      minLevel = 16,
                    )
                  ),
                evolvesTo =
                  listOf(
                    ChainLink(
                      isBaby = false,
                      species = NamedApiResource("venusaur", "pokemon-species", 3),
                      evolutionDetails =
                        listOf(
                          EvolutionDetail(
                            trigger = NamedApiResource("level-up", "evolution-trigger", 1),
                            minLevel = 32,
                          )
                        ),
                      evolvesTo = emptyList(),
                    )
                  ),
              )
            ),
        ),
        chain,
      )
    }
  }

  @Test
  fun getEvolutionChain2() = runTest {
    LocalPokeApi.getEvolutionChain(109).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              heldItem = NamedApiResource("razor-claw", "item", 303),
              timeOfDay = "night",
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain3() = runTest {
    LocalPokeApi.getEvolutionChain(67).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("use-item", "evolution-trigger", 3),
              item = NamedApiResource("water-stone", "item", 84),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain4() = runTest {
    LocalPokeApi.getEvolutionChain(67).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              location = NamedApiResource("eterna-forest", "location", 8),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain5() = runTest {
    LocalPokeApi.getEvolutionChain(67).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minHappiness = 160,
              timeOfDay = "day",
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain6() = runTest {
    LocalPokeApi.getEvolutionChain(67).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              knownMoveType = NamedApiResource("fairy", "type", 18),
              minAffection = 2,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain7() = runTest {
    LocalPokeApi.getEvolutionChain(112).apply {
      assertContains(
        chain.evolvesTo[0].evolvesTo[0].evolutionDetails,
        EvolutionDetail(
          trigger = NamedApiResource("level-up", "evolution-trigger", 1),
          knownMove = NamedApiResource("ancient-power", "move", 246),
        ),
      )
    }
  }

  @Test
  fun getEvolutionChain8() = runTest {
    LocalPokeApi.getEvolutionChain(213).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              gender = 1,
              minLevel = 20,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain9() = runTest {
    LocalPokeApi.getEvolutionChain(178).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minBeauty = 171,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain10() = runTest {
    LocalPokeApi.getEvolutionChain(346).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minLevel = 32,
              partyType = NamedApiResource("dark", "type", 17),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain11() = runTest {
    LocalPokeApi.getEvolutionChain(47).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minLevel = 20,
              relativePhysicalStats = 1,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain12() = runTest {
    LocalPokeApi.getEvolutionChain(362).apply {
      assertNotNull(
        chain.evolvesTo[0].evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minLevel = 50,
              needsOverworldRain = true,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain13() = runTest {
    LocalPokeApi.getEvolutionChain(352).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              minLevel = 30,
              turnUpsideDown = true,
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain14() = runTest {
    LocalPokeApi.getEvolutionChain(116).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("level-up", "evolution-trigger", 1),
              partySpecies = NamedApiResource("remoraid", "pokemon-species", 223),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain15() = runTest {
    LocalPokeApi.getEvolutionChain(312).apply {
      assertNotNull(
        chain.evolvesTo.find {
          it.evolutionDetails.contains(
            EvolutionDetail(
              trigger = NamedApiResource("trade", "evolution-trigger", 2),
              tradeSpecies = NamedApiResource("karrablast", "pokemon-species", 588),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain16() = runTest {
    LocalPokeApi.getEvolutionChain(72).apply {
      assertEquals(NamedApiResource("full-incense", "item", 293), babyTriggerItem)
      assertEquals(true, chain.isBaby)
    }
  }

  @Test
  fun getEvolutionTrigger() = runTest {
    LocalPokeApi.getEvolutionTrigger(1).apply {
      assertEquals(1, id)
      assertEquals("level-up", name)
      assertContains(
        names,
        Name(name = "Level up", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(pokemonSpecies, NamedApiResource("fletchinder", "pokemon-species", 662))
    }
  }
}
