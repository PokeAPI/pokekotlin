package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.*
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.*
import kotlinx.coroutines.test.runTest

class PokemonTest {

  @Test
  fun getAbility() = runTest {
    LocalPokeApi.getAbility(1).apply {
      assertEquals(1, id)
      assertEquals("stench", name)
      assertEquals(true, isMainSeries)
      assertEquals(NamedApiResource("generation-iii", "generation", 3), generation)
      assertContains(names, Name(name = "Stench", language = NamedApiResource("en", "language", 9)))
      assertContains(
        effectEntries,
        VerboseEffect(
          effect =
            "This Pokémon's damaging moves have a 10% chance to make the target " +
              "flinch with each hit if they do not already cause flinching as a " +
              "secondary effect.\n\nThis ability does not stack with a held item.\n\n" +
              "Overworld: The wild encounter rate is halved while this Pokémon is " +
              "first in the party.",
          shortEffect = "Has a 10% chance of making target Pokémon flinch with each hit.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertNotNull(
        effectChanges.find {
          it.versionGroup == NamedApiResource("black-white", "version-group", 11) &&
            it.effectEntries.contains(
              Effect(
                effect = "Has no effect in battle.",
                language = NamedApiResource("en", "language", 9),
              )
            )
        }
      )
      assertContains(
        pokemon,
        AbilityPokemon(
          isHidden = true,
          slot = 3,
          pokemon = NamedApiResource("gloom", "pokemon", 44),
        ),
      )
    }
  }

  @Test
  fun getCharacteristic() = runTest {
    LocalPokeApi.getCharacteristic(1).apply {
      assertEquals(1, id)
      assertEquals(0, geneModulo)
      assertEquals((0..6).map { it * 5 }.toList(), possibleValues)
      assertContains(
        descriptions,
        Description(description = "Loves to eat", language = NamedApiResource("en", "language", 9)),
      )
    }
  }

  @Test
  fun getEggGroup() = runTest {
    LocalPokeApi.getEggGroup(1).apply {
      assertEquals(1, id)
      assertEquals("monster", name)
      assertContains(
        names,
        Name(name = "Monster", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(pokemonSpecies, NamedApiResource("avalugg", "pokemon-species", 713))
    }
  }

  @Test
  fun getGender() = runTest {
    LocalPokeApi.getGender(1).apply {
      assertEquals(1, id)
      assertEquals("female", name)
      assertContains(
        pokemonSpeciesDetails,
        PokemonSpeciesGender(
          rate = 4,
          pokemonSpecies = NamedApiResource("noivern", "pokemon-species", 715),
        ),
      )
      assertContains(requiredForEvolution, NamedApiResource("froslass", "pokemon-species", 478))
    }
  }

  @Test
  fun getGrowthRate() = runTest {
    LocalPokeApi.getGrowthRate(1).apply {
      assertEquals(1, id)
      assertEquals("slow", name)
      assertEquals("\\frac{5x^3}{4}", formula)
      assertContains(
        descriptions,
        Description(description = "slow", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(levels, GrowthRateExperienceLevel(experience = 1250000, level = 100))
      assertContains(pokemonSpecies, NamedApiResource("volcanion", "pokemon-species", 721))
    }
  }

  @Test
  fun getNature() = runTest {
    LocalPokeApi.getNature(10).apply {
      assertEquals(10, id)
      assertEquals("hasty", name)
      assertEquals(NamedApiResource("speed", "stat", 6), increasedStat)
      assertEquals(NamedApiResource("defense", "stat", 3), decreasedStat)
      assertEquals(NamedApiResource("sweet", "berry-flavor", 3), likesFlavor)
      assertEquals(NamedApiResource("sour", "berry-flavor", 5), hatesFlavor)
      assertContains(
        pokeathlonStatChanges,
        NatureStatChange(
          pokeathlonStat = NamedApiResource("speed", "pokeathlon-stat", 1),
          maxChange = 2,
        ),
      )
      assertContains(
        moveBattleStylePreferences,
        MoveBattleStylePreference(
          highHpPreference = 58,
          lowHpPreference = 88,
          moveBattleStyle = NamedApiResource("attack", "move-battle-style", 1),
        ),
      )
      assertContains(names, Name(name = "Hasty", language = NamedApiResource("en", "language", 9)))
    }
  }

  @Test
  fun getPokeathlonStat() = runTest {
    LocalPokeApi.getPokeathlonStat(1).apply {
      assertEquals(1, id)
      assertEquals("speed", name)
      assertContains(names, Name(name = "Speed", language = NamedApiResource("en", "language", 9)))
      assertContains(
        affectingNatures.decrease,
        NaturePokeathlonStatAffect(nature = NamedApiResource("sassy", "nature", 24), maxChange = -2),
      )
      assertContains(
        affectingNatures.increase,
        NaturePokeathlonStatAffect(
          nature = NamedApiResource("serious", "nature", 25),
          maxChange = 1,
        ),
      )
    }
  }

  @Test
  fun getPokemon1() = runTest {
    LocalPokeApi.getPokemonVariety(1).apply {
      assertEquals(1, id)
      assertEquals("bulbasaur", name)
      assertEquals(64, baseExperience)
      assertEquals(7, height)
      assertEquals(true, isDefault)
      assertEquals(1, order)
      assertEquals(69, weight)
      assertEquals(NamedApiResource("bulbasaur", "pokemon-species", 1), species)
      assertContains(
        abilities,
        PokemonAbility(
          slot = 1,
          isHidden = false,
          ability = NamedApiResource("overgrow", "ability", 65),
        ),
      )
      assertContains(forms, NamedApiResource("bulbasaur", "pokemon-form", 1))
      assertContains(
        gameIndices,
        VersionGameIndex(version = NamedApiResource("white-2", "version", 22), gameIndex = 1),
      )
      assertEquals(emptyList(), heldItems)
      assertNotNull(
        moves.find {
          it.move == NamedApiResource("razor-wind", "move", 13) &&
            PokemonMoveVersion(
              levelLearnedAt = 0,
              versionGroup = NamedApiResource("gold-silver", "version-group", 3),
              moveLearnMethod = NamedApiResource("egg", "move-learn-method", 2),
              order = null,
            ) in it.versionGroupDetails
        }
      )
      assertContains(
        stats,
        PokemonStat(effort = 0, baseStat = 45, stat = NamedApiResource("hp", "stat", 1)),
      )
      assertContains(types, PokemonType(slot = 1, type = NamedApiResource("grass", "type", 12)))
    }
  }

  @Test
  fun getPokemon2() = runTest {
    LocalPokeApi.getPokemonVariety(12).apply {
      assertNotNull(
        heldItems.find {
          it.item == NamedApiResource("silver-powder", "item", 199) &&
            PokemonHeldItemVersion(version = NamedApiResource("ruby", "version", 7), rarity = 5) in
              it.versionDetails
        }
      )
    }
  }

  @Test
  fun getPokemon3() = runTest {
    LocalPokeApi.getPokemonEncounterList(12).apply {
      assertNotNull(
        find { locAreaEncounter ->
          locAreaEncounter.locationArea ==
            NamedApiResource("kanto-route-2-south-towards-viridian-city", "location-area", 296) &&
            locAreaEncounter.versionDetails.find { detail ->
              detail.maxChance == 10
              detail.version == NamedApiResource("heartgold", "version", 15)
              detail.encounterDetails.find { encounter ->
                encounter.minLevel == 8 &&
                  encounter.maxLevel == 8 &&
                  encounter.chance == 5 &&
                  encounter.method == NamedApiResource("walk", "encounter-method", 1) &&
                  NamedApiResource("time-morning", "encounter-condition-value", 3) in
                    encounter.conditionValues
              } != null
            } != null
        }
      )
    }
  }

  @Test
  fun getPokemon4() = runTest {
    LocalPokeApi.getPokemonVariety(399).apply {
      sprites.apply {
        assertTrue(backFemale!!.endsWith("/sprites/pokemon/back/female/399.png"))
        assertTrue(backShinyFemale!!.endsWith("/sprites/pokemon/back/shiny/female/399.png"))
        assertTrue(backDefault!!.endsWith("/sprites/pokemon/back/399.png"))
        assertTrue(frontFemale!!.endsWith("/sprites/pokemon/female/399.png"))
        assertTrue(frontShinyFemale!!.endsWith("/sprites/pokemon/shiny/female/399.png"))
        assertTrue(backShiny!!.endsWith("/sprites/pokemon/back/shiny/399.png"))
        assertTrue(frontDefault!!.endsWith("/sprites/pokemon/399.png"))
        assertTrue(frontShiny!!.endsWith("/sprites/pokemon/shiny/399.png"))
      }
    }
  }

  @Test
  fun getPokemonColor() = runTest {
    LocalPokeApi.getPokemonColor(1).apply {
      assertEquals(1, id)
      assertEquals("black", name)
      assertContains(names, Name(name = "Black", language = NamedApiResource("en", "language", 9)))
      assertContains(pokemonSpecies, NamedApiResource("snorlax", "pokemon-species", 143))
    }
  }

  @Test
  fun getPokemonForm() = runTest {
    LocalPokeApi.getPokemonForm(1).apply {
      assertEquals(1, id)
      assertEquals("bulbasaur", name)
      assertEquals(1, order)
      assertEquals(1, formOrder)
      assertEquals(true, isDefault)
      assertEquals(false, isBattleOnly)
      assertEquals(false, isMega)
      assertEquals("", formName)
      assertEquals(NamedApiResource("bulbasaur", "pokemon", 1), pokemon)
      assertEquals(NamedApiResource("red-blue", "version-group", 1), versionGroup)
      sprites.apply {
        assertTrue(frontDefault!!.endsWith("/sprites/pokemon/1.png"))
        assertTrue(backDefault!!.endsWith("/sprites/pokemon/back/1.png"))
        assertTrue(frontShiny!!.endsWith("/sprites/pokemon/shiny/1.png"))
        assertTrue(backShiny!!.endsWith("/sprites/pokemon/back/shiny/1.png"))
      }
    }
  }

  @Test
  fun getPokemonForm2() = runTest {
    LocalPokeApi.getPokemonForm(10266).apply {
      assertContains(
        formNames,
        Name(name = "Original Color", language = NamedApiResource("en", "language", 9)),
      )
    }
  }

  @Test
  fun getPokemonHabitat() = runTest {
    LocalPokeApi.getPokemonHabitat(1).apply {
      assertEquals(1, id)
      assertEquals("cave", name)
      assertContains(names, Name(name = "cave", language = NamedApiResource("en", "language", 9)))
      assertContains(pokemonSpecies, NamedApiResource("registeel", "pokemon-species", 379))
    }
  }

  @Test
  fun getPokemonShape() = runTest {
    LocalPokeApi.getPokemonShape(1).apply {
      assertEquals(1, id)
      assertEquals("ball", name)
      assertContains(names, Name(name = "Ball", language = NamedApiResource("en", "language", 9)))
      assertContains(
        awesomeNames,
        AwesomeName(awesomeName = "Pomaceous", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(pokemonSpecies, NamedApiResource("shellder", "pokemon-species", 90))
    }
  }

  @Test
  fun getPokemonSpecies1() = runTest {
    LocalPokeApi.getPokemonSpecies(1).apply {
      assertEquals(1, id)
      assertEquals("bulbasaur", name)
      assertEquals(1, order)
      assertEquals(1, genderRate)
      assertEquals(45, captureRate)
      assertEquals(70, baseHappiness)
      assertEquals(false, isBaby)
      assertEquals(false, isMythical)
      assertEquals(false, isLegendary)
      assertEquals(20, hatchCounter)
      assertEquals(false, hasGenderDifferences)
      assertEquals(false, formsSwitchable)
      assertEquals(NamedApiResource("medium-slow", "growth-rate", 4), growthRate)
      assertContains(
        pokedexNumbers,
        PokemonSpeciesDexEntry(
          entryNumber = 80,
          pokedex = NamedApiResource("kalos-central", "pokedex", 12),
        ),
      )
      assertContains(eggGroups, NamedApiResource("plant", "egg-group", 7))
      assertEquals(NamedApiResource("green", "pokemon-color", 5), color)
      assertEquals(NamedApiResource("quadruped", "pokemon-shape", 8), shape)
      assertEquals(null, evolvesFromSpecies)
      assertEquals(ApiResource("evolution-chain", 1), evolutionChain)
      assertEquals(NamedApiResource("grassland", "pokemon-habitat", 3), habitat)
      assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
      assertContains(
        names,
        Name(name = "Bulbasaur", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        palParkEncounters,
        PalParkEncounterArea(
          rate = 30,
          baseScore = 50,
          area = NamedApiResource("field", "pal-park-area", 2),
        ),
      )
      assertEquals(emptyList(), formDescriptions)
      assertContains(
        genera,
        Genus(genus = "Seed Pokémon", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        varieties,
        PokemonSpeciesVariety(
          isDefault = true,
          variety = NamedApiResource("bulbasaur", "pokemon", 1),
        ),
      )
      assertContains(
        flavorTextEntries,
        PokemonSpeciesFlavorText(
          flavorText =
            "Bulbasaur can be seen napping in bright sunlight.\n" +
              "There is a seed on its back. By soaking up the sun’s rays,\n" +
              "the seed grows progressively larger.",
          language = NamedApiResource("en", "language", 9),
          version = NamedApiResource("alpha-sapphire", "version", 26),
        ),
      )
    }
  }

  @Test
  fun getPokemonSpecies2() = runTest {
    LocalPokeApi.getPokemonSpecies(2).apply {
      assertEquals(NamedApiResource("bulbasaur", "pokemon-species", 1), evolvesFromSpecies)
    }
  }

  @Test
  fun getPokemonSpecies3() = runTest {
    LocalPokeApi.getPokemonSpecies(351).apply {
      assertContains(
        formDescriptions,
        Description(
          description =
            "Form changes along with type to match the weather in battle, " +
              "due to forecast.  Castform is always in its normal form outside of " +
              "battle, regardless of weather.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
    }
  }

  @Test
  fun getStat() = runTest {
    LocalPokeApi.getStat(2).apply {
      assertEquals(2, id)
      assertEquals("attack", name)
      assertEquals(2, gameIndex)
      assertEquals(false, isBattleOnly)
      assertContains(
        affectingMoves.increase,
        MoveStatAffect(change = 2, move = NamedApiResource("swords-dance", "move", 14)),
      )
      assertContains(
        affectingMoves.decrease,
        MoveStatAffect(change = -1, move = NamedApiResource("growl", "move", 45)),
      )
      assertContains(affectingNatures.increase, NamedApiResource("lonely", "nature", 6))
      assertContains(affectingNatures.decrease, NamedApiResource("bold", "nature", 2))
      assertEquals(NamedApiResource("physical", "move-damage-class", 2), moveDamageClass)
      assertContains(names, Name(name = "Attack", language = NamedApiResource("en", "language", 9)))
    }
  }

  @Test
  fun getType() = runTest {
    LocalPokeApi.getType(8).apply {
      assertEquals(8, id)
      assertEquals("ghost", name)
      damageRelations.apply {
        assertContains(halfDamageFrom, NamedApiResource("poison", "type", 4))
        assertContains(noDamageFrom, NamedApiResource("normal", "type", 1))
        assertContains(halfDamageTo, NamedApiResource("dark", "type", 17))
        assertContains(doubleDamageFrom, NamedApiResource("ghost", "type", 8))
        assertContains(noDamageTo, NamedApiResource("normal", "type", 1))
        assertContains(doubleDamageTo, NamedApiResource("psychic", "type", 14))
      }
      assertContains(
        gameIndices,
        GenerationGameIndex(
          gameIndex = 7,
          generation = NamedApiResource("generation-vi", "generation", 6),
        ),
      )
      assertEquals(NamedApiResource("physical", "move-damage-class", 2), moveDamageClass)
      assertContains(names, Name(name = "Ghost", language = NamedApiResource("en", "language", 9)))
      assertContains(
        pokemon,
        TypePokemon(slot = 1, pokemon = NamedApiResource("litwick", "pokemon", 607)),
      )
      assertContains(moves, NamedApiResource("hex", "move", 506))
    }
  }
}
