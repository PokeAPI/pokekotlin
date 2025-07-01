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
      assertEquals(Handle.of(3, "generation-iii"), generation)
      assertContains(names, Name(name = "Stench", language = Handle.of(9, "en")))
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
          language = Handle.of(9, "en"),
        ),
      )
      assertNotNull(
        effectChanges.find {
          it.versionGroup == Handle.of<VersionGroup>(11, "black-white") &&
            it.effectEntries.contains(
              Effect(effect = "Has no effect in battle.", language = Handle.of(9, "en"))
            )
        }
      )
      assertContains(
        pokemon,
        AbilityPokemon(isHidden = true, slot = 3, pokemon = Handle.of(44, "gloom")),
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
        Description(description = "Loves to eat", language = Handle.of(9, "en")),
      )
    }
  }

  @Test
  fun getEggGroup() = runTest {
    LocalPokeApi.getEggGroup(1).apply {
      assertEquals(1, id)
      assertEquals("monster", name)
      assertContains(names, Name(name = "Monster", language = Handle.of(9, "en")))
      assertContains(pokemonSpecies, Handle.of(713, "avalugg"))
    }
  }

  @Test
  fun getGender() = runTest {
    LocalPokeApi.getGender(1).apply {
      assertEquals(1, id)
      assertEquals("female", name)
      assertContains(
        pokemonSpeciesDetails,
        PokemonSpeciesGender(rate = 4, pokemonSpecies = Handle.of(715, "noivern")),
      )
      assertContains(requiredForEvolution, Handle.of(478, "froslass"))
    }
  }

  @Test
  fun getGrowthRate() = runTest {
    LocalPokeApi.getGrowthRate(1).apply {
      assertEquals(1, id)
      assertEquals("slow", name)
      assertEquals("\\frac{5x^3}{4}", formula)
      assertContains(descriptions, Description(description = "slow", language = Handle.of(9, "en")))
      assertContains(levels, GrowthRateExperienceLevel(experience = 1250000, level = 100))
      assertContains(pokemonSpecies, Handle.of(721, "volcanion"))
    }
  }

  @Test
  fun getNature() = runTest {
    LocalPokeApi.getNature(10).apply {
      assertEquals(10, id)
      assertEquals("hasty", name)
      assertEquals(Handle.of(6, "speed"), increasedStat)
      assertEquals(Handle.of(3, "defense"), decreasedStat)
      assertEquals(Handle.of(3, "sweet"), likesFlavor)
      assertEquals(Handle.of(5, "sour"), hatesFlavor)
      assertContains(
        pokeathlonStatChanges,
        NatureStatChange(pokeathlonStat = Handle.of(1, "speed"), maxChange = 2),
      )
      assertContains(
        moveBattleStylePreferences,
        MoveBattleStylePreference(
          highHpPreference = 58,
          lowHpPreference = 88,
          moveBattleStyle = Handle.of(1, "attack"),
        ),
      )
      assertContains(names, Name(name = "Hasty", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getPokeathlonStat() = runTest {
    LocalPokeApi.getPokeathlonStat(1).apply {
      assertEquals(1, id)
      assertEquals("speed", name)
      assertContains(names, Name(name = "Speed", language = Handle.of(9, "en")))
      assertContains(
        affectingNatures.decrease,
        NaturePokeathlonStatEffect(nature = Handle.of(24, "sassy"), maxChange = -2),
      )
      assertContains(
        affectingNatures.increase,
        NaturePokeathlonStatEffect(nature = Handle.of(25, "serious"), maxChange = 1),
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
      assertEquals(Handle.of(1, "bulbasaur"), species)
      assertContains(
        abilities,
        PokemonAbility(slot = 1, isHidden = false, ability = Handle.of(65, "overgrow")),
      )
      assertContains(forms, Handle.of(1, "bulbasaur"))
      assertContains(
        gameIndices,
        VersionGameIndex(version = Handle.of(22, "white-2"), gameIndex = 1),
      )
      assertEquals(emptyList(), heldItems)
      assertNotNull(
        moves.find {
          it.move == Handle.of<Move>(13, "razor-wind") &&
            PokemonMoveVersion(
              levelLearnedAt = 0,
              versionGroup = Handle.of(3, "gold-silver"),
              moveLearnMethod = Handle.of(2, "egg"),
              order = null,
            ) in it.versionGroupDetails
        }
      )
      assertContains(stats, PokemonStat(effort = 0, baseStat = 45, stat = Handle.of(1, "hp")))
      assertContains(types, PokemonType(slot = 1, type = Handle.of(12, "grass")))
    }
  }

  @Test
  fun getPokemon2() = runTest {
    LocalPokeApi.getPokemonVariety(12).apply {
      assertNotNull(
        heldItems.find {
          it.item == Handle.of<Item>(199, "silver-powder") &&
            PokemonHeldItemVersion(version = Handle.of(7, "ruby"), rarity = 5) in it.versionDetails
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
            Handle.of<LocationArea>(296, "kanto-route-2-south-towards-viridian-city") &&
            locAreaEncounter.versionDetails.find { detail ->
              detail.maxChance == 10
              detail.version == Handle.of<Version>(15, "heartgold")
              detail.encounterDetails.find { encounter ->
                encounter.minLevel == 8 &&
                  encounter.maxLevel == 8 &&
                  encounter.chance == 5 &&
                  encounter.method == Handle.of<EncounterMethod>(1, "walk") &&
                  Handle.of(3, "time-morning") in encounter.conditionValues
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
      assertContains(names, Name(name = "Black", language = Handle.of(9, "en")))
      assertContains(pokemonSpecies, Handle.of(143, "snorlax"))
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
      assertEquals(Handle.of(1, "bulbasaur"), pokemon)
      assertEquals(Handle.of(1, "red-blue"), versionGroup)
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
      assertContains(formNames, Name(name = "Original Color", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getPokemonHabitat() = runTest {
    LocalPokeApi.getPokemonHabitat(1).apply {
      assertEquals(1, id)
      assertEquals("cave", name)
      assertContains(names, Name(name = "cave", language = Handle.of(9, "en")))
      assertContains(pokemonSpecies, Handle.of(379, "registeel"))
    }
  }

  @Test
  fun getPokemonShape() = runTest {
    LocalPokeApi.getPokemonShape(1).apply {
      assertEquals(1, id)
      assertEquals("ball", name)
      assertContains(names, Name(name = "Ball", language = Handle.of(9, "en")))
      assertContains(
        awesomeNames,
        AwesomeName(awesomeName = "Pomaceous", language = Handle.of(9, "en")),
      )
      assertContains(pokemonSpecies, Handle.of(90, "shellder"))
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
      assertEquals(Handle.of(4, "medium-slow"), growthRate)
      assertContains(
        pokedexNumbers,
        PokemonSpeciesDexEntry(entryNumber = 80, pokedex = Handle.of(12, "kalos-central")),
      )
      assertContains(eggGroups, Handle.of(7, "plant"))
      assertEquals(Handle.of(5, "green"), color)
      assertEquals(Handle.of(8, "quadruped"), shape)
      assertEquals(null, evolvesFromSpecies)
      assertEquals(Handle.of(1), evolutionChain)
      assertEquals(Handle.of(3, "grassland"), habitat)
      assertEquals(Handle.of(1, "generation-i"), generation)
      assertContains(names, Name(name = "Bulbasaur", language = Handle.of(9, "en")))
      assertContains(
        palParkEncounters,
        PalParkEncounterArea(rate = 30, baseScore = 50, area = Handle.of(2, "field")),
      )
      assertEquals(emptyList(), formDescriptions)
      assertContains(genera, Genus(genus = "Seed Pokémon", language = Handle.of(9, "en")))
      assertContains(
        varieties,
        PokemonSpeciesVariety(isDefault = true, variety = Handle.of(1, "bulbasaur")),
      )
      assertContains(
        flavorTextEntries,
        PokemonSpeciesFlavorText(
          flavorText =
            "Bulbasaur can be seen napping in bright sunlight.\n" +
              "There is a seed on its back. By soaking up the sun’s rays,\n" +
              "the seed grows progressively larger.",
          language = Handle.of(9, "en"),
          version = Handle.of(26, "alpha-sapphire"),
        ),
      )
    }
  }

  @Test
  fun getPokemonSpecies2() = runTest {
    LocalPokeApi.getPokemonSpecies(2).apply {
      assertEquals(Handle.of(1, "bulbasaur"), evolvesFromSpecies)
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
          language = Handle.of(9, "en"),
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
        MoveStatAffect(change = 2, move = Handle.of(14, "swords-dance")),
      )
      assertContains(
        affectingMoves.decrease,
        MoveStatAffect(change = -1, move = Handle.of(45, "growl")),
      )
      assertContains(affectingNatures.increase, Handle.of(6, "lonely"))
      assertContains(affectingNatures.decrease, Handle.of(2, "bold"))
      assertEquals(Handle.of(2, "physical"), moveDamageClass)
      assertContains(names, Name(name = "Attack", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getType() = runTest {
    LocalPokeApi.getType(8).apply {
      assertEquals(8, id)
      assertEquals("ghost", name)
      damageRelations.apply {
        assertContains(halfDamageFrom, Handle.of(4, "poison"))
        assertContains(noDamageFrom, Handle.of(1, "normal"))
        assertContains(halfDamageTo, Handle.of(17, "dark"))
        assertContains(doubleDamageFrom, Handle.of(8, "ghost"))
        assertContains(noDamageTo, Handle.of(1, "normal"))
        assertContains(doubleDamageTo, Handle.of(14, "psychic"))
      }
      assertContains(
        gameIndices,
        GenerationGameIndex(gameIndex = 7, generation = Handle.of(6, "generation-vi")),
      )
      assertEquals(Handle.of(2, "physical"), moveDamageClass)
      assertContains(names, Name(name = "Ghost", language = Handle.of(9, "en")))
      assertContains(pokemon, TypePokemon(slot = 1, pokemon = Handle.of(607, "litwick")))
      assertContains(moves, Handle.of(506, "hex"))
    }
  }
}
