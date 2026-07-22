package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.internal.PokeApiJson
import co.pokeapi.pokekotlin.model.ChainLink
import co.pokeapi.pokekotlin.model.EvolutionChain
import co.pokeapi.pokekotlin.model.EvolutionDetail
import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.Name
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest

// Real `/api/v2/evolution-chain/96` (Wooper) response fetched live from pokeapi.co. The pinned
// api-data submodule predates the `region`/`base_form`/`version_group` fields this fixture
// exercises, so this is embedded directly rather than served by the local test server.
private val wooperEvolutionChainJson =
  """
  {
      "baby_trigger_item": null,
      "chain": {
          "evolution_details": [],
          "evolves_to": [
              {
                  "evolution_details": [
                      {
                          "base_form": null,
                          "evolved_form": null,
                          "gender": null,
                          "held_item": null,
                          "is_default": true,
                          "item": null,
                          "known_move": null,
                          "known_move_type": null,
                          "location": null,
                          "min_affection": null,
                          "min_beauty": null,
                          "min_damage_taken": null,
                          "min_happiness": null,
                          "min_level": 20,
                          "min_move_count": null,
                          "min_steps": null,
                          "near_special_rock": false,
                          "needs_multiplayer": false,
                          "needs_overworld_rain": false,
                          "party_species": null,
                          "party_type": null,
                          "region": null,
                          "relative_physical_stats": null,
                          "time_of_day": "",
                          "trade_species": null,
                          "trigger": {
                              "name": "level-up",
                              "url": "/api/v2/evolution-trigger/1/"
                          },
                          "turn_upside_down": false,
                          "used_move": null,
                          "version_group": {
                              "name": "gold-silver",
                              "url": "/api/v2/version-group/3/"
                          }
                      }
                  ],
                  "evolves_to": [],
                  "is_baby": false,
                  "species": {
                      "name": "quagsire",
                      "url": "/api/v2/pokemon-species/195/"
                  }
              },
              {
                  "evolution_details": [
                      {
                          "base_form": {
                              "name": "wooper-paldea",
                              "url": "/api/v2/pokemon/10253/"
                          },
                          "evolved_form": null,
                          "gender": null,
                          "held_item": null,
                          "is_default": true,
                          "item": null,
                          "known_move": null,
                          "known_move_type": null,
                          "location": null,
                          "min_affection": null,
                          "min_beauty": null,
                          "min_damage_taken": null,
                          "min_happiness": null,
                          "min_level": 20,
                          "min_move_count": null,
                          "min_steps": null,
                          "near_special_rock": false,
                          "needs_multiplayer": false,
                          "needs_overworld_rain": false,
                          "party_species": null,
                          "party_type": null,
                          "region": null,
                          "relative_physical_stats": null,
                          "time_of_day": "",
                          "trade_species": null,
                          "trigger": {
                              "name": "level-up",
                              "url": "/api/v2/evolution-trigger/1/"
                          },
                          "turn_upside_down": false,
                          "used_move": null,
                          "version_group": {
                              "name": "scarlet-violet",
                              "url": "/api/v2/version-group/25/"
                          }
                      }
                  ],
                  "evolves_to": [],
                  "is_baby": false,
                  "species": {
                      "name": "clodsire",
                      "url": "/api/v2/pokemon-species/980/"
                  }
              }
          ],
          "is_baby": false,
          "species": {
              "name": "wooper",
              "url": "/api/v2/pokemon-species/194/"
          }
      },
      "id": 96
  }
  """
    .trimIndent()

class EvolutionTest {

  @Test
  fun getEvolutionChain1() = runTest {
    LocalPokeApi.getEvolutionChain(1).apply {
      assertEquals(1, id)
      assertEquals(null, babyTriggerItem)
      assertEquals(
        ChainLink(
          isBaby = false,
          species = Handle.of(1, "bulbasaur"),
          evolutionDetails = emptyList(),
          evolvesTo =
            listOf(
              ChainLink(
                isBaby = false,
                species = Handle.of(2, "ivysaur"),
                evolutionDetails =
                  listOf(EvolutionDetail(trigger = Handle.of(1, "level-up"), minLevel = 16)),
                evolvesTo =
                  listOf(
                    ChainLink(
                      isBaby = false,
                      species = Handle.of(3, "venusaur"),
                      evolutionDetails =
                        listOf(EvolutionDetail(trigger = Handle.of(1, "level-up"), minLevel = 32)),
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
              trigger = Handle.of(1, "level-up"),
              heldItem = Handle.of(303, "razor-claw"),
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
            EvolutionDetail(trigger = Handle.of(3, "use-item"), item = Handle.of(84, "water-stone"))
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
              trigger = Handle.of(1, "level-up"),
              location = Handle.of(8, "eterna-forest"),
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
              trigger = Handle.of(1, "level-up"),
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
              trigger = Handle.of(1, "level-up"),
              knownMoveType = Handle.of(18, "fairy"),
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
          trigger = Handle.of(1, "level-up"),
          knownMove = Handle.of(246, "ancient-power"),
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
            EvolutionDetail(trigger = Handle.of(1, "level-up"), gender = 1, minLevel = 20)
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
            EvolutionDetail(trigger = Handle.of(1, "level-up"), minBeauty = 171)
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
              trigger = Handle.of(1, "level-up"),
              minLevel = 32,
              partyType = Handle.of(17, "dark"),
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
              trigger = Handle.of(1, "level-up"),
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
              trigger = Handle.of(1, "level-up"),
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
              trigger = Handle.of(1, "level-up"),
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
              trigger = Handle.of(1, "level-up"),
              partySpecies = Handle.of(223, "remoraid"),
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
              trigger = Handle.of(2, "trade"),
              tradeSpecies = Handle.of(588, "karrablast"),
            )
          )
        }
      )
    }
  }

  @Test
  fun getEvolutionChain16() = runTest {
    LocalPokeApi.getEvolutionChain(72).apply {
      assertEquals(Handle.of(293, "full-incense"), babyTriggerItem)
      assertEquals(true, chain.isBaby)
    }
  }

  // Wooper (species 194, chain 96) evolves into Quagsire in most games but into the
  // Paldean-exclusive Clodsire in Scarlet/Violet. The two are only distinguishable via
  // `versionGroup`/`baseForm` - without those fields both branches decode to the exact same
  // EvolutionDetail, silently discarding the distinction.
  @Test
  fun decodeEvolutionChainWooperRegionalVariant() {
    val chain = PokeApiJson.decodeFromString<EvolutionChain>(wooperEvolutionChainJson)
    val quagsireDetail =
      chain.chain.evolvesTo.single { it.species.name == "quagsire" }.evolutionDetails.single()
    val clodsireDetail =
      chain.chain.evolvesTo.single { it.species.name == "clodsire" }.evolutionDetails.single()

    assertEquals(
      EvolutionDetail(
        trigger = Handle.of(1, "level-up"),
        minLevel = 20,
        isDefault = true,
        versionGroup = Handle.of(3, "gold-silver"),
      ),
      quagsireDetail,
    )
    assertEquals(
      EvolutionDetail(
        trigger = Handle.of(1, "level-up"),
        minLevel = 20,
        isDefault = true,
        baseForm = Handle.of(10253, "wooper-paldea"),
        versionGroup = Handle.of(25, "scarlet-violet"),
      ),
      clodsireDetail,
    )
    assertNotEquals(quagsireDetail, clodsireDetail)
  }

  @Test
  fun getEvolutionTrigger() = runTest {
    LocalPokeApi.getEvolutionTrigger(1).apply {
      assertEquals(1, id)
      assertEquals("level-up", name)
      assertContains(names, Name(name = "Level up", language = Handle.of(9, "en")))
      assertContains(pokemonSpecies, Handle.of(662, "fletchinder"))
    }
  }
}
