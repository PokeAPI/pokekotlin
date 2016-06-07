package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.*
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PokemonTest {

    @Test
    fun getAbility() {
        TestClient.getAbility(1).apply {
            assertEquals(1, id)
            assertEquals("stench", name)
            assertEquals(true, isMainSeries)
            assertEquals(NamedApiResource("generation-iii", "generation", 3), generation)
            assert(Name(
                    name = "Stench",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(VerboseEffect(
                    effect = "This Pokémon's damaging moves have a 10% chance to make the target flinch with each hit if they do not already cause flinching as a secondary effect.\n\nThis ability does not stack with a held item.\n\nOverworld: The wild encounter rate is halved while this Pokémon is first in the party.",
                    shortEffect = "Has a 10% chance of making target Pokémon flinch with each hit.",
                    language = NamedApiResource("en", "language", 9)
            ) in effectEntries)
            assert(AbilityEffectChange(
                    versionGroup = NamedApiResource("black-white", "version-group", 11),
                    effectEntries = listOf(Effect(
                            effect = "Has no effect in battle.",
                            language = NamedApiResource("en", "language", 9)
                    ))
            ) in effectChanges)
            assert(AbilityPokemon(
                    isHidden = true,
                    slot = 3,
                    pokemon = NamedApiResource("gloom", "pokemon", 44)
            ) in pokemon)
        }
    }

    @Test
    fun getCharacteristic() {
        TestClient.getCharacteristic(1).apply {
            assertEquals(1, id)
            assertEquals(0, geneModulo)
            assertEquals((0..6).map { it * 5 }.toList(), possibleValues)
            assert(Description(
                    description = "Loves to eat",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
        }
    }

    @Test
    fun getEggGroup() {
        TestClient.getEggGroup(1).apply {
            assertEquals(1, id)
            assertEquals("monster", name)
            assert(Name(
                    name = "Monster",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NamedApiResource("avalugg", "pokemon-species", 713) in pokemonSpecies)

        }
    }

    @Test
    fun getGender() {
        TestClient.getGender(1).apply {
            assertEquals(1, id)
            assertEquals("female", name)
            assert(PokemonSpeciesGender(
                    rate = 4,
                    pokemonSpecies = NamedApiResource("noivern", "pokemon-species", 715)
            ) in pokemonSpeciesDetails)
            assert(NamedApiResource("froslass", "pokemon-species", 478) in requiredForEvolution)
        }
    }

    @Test
    fun getGrowthRate() {
        TestClient.getGrowthRate(1).apply {
            assertEquals(1, id)
            assertEquals("slow", name)
            assertEquals("\\frac{5x^3}{4}", formula)
            assert(Description(
                    description = "slow",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(GrowthRateExperienceLevel(
                    experience = 1250000,
                    level = 100
            ) in levels)
            assert(NamedApiResource("volcanion", "pokemon-species", 721) in pokemonSpecies)
        }
    }

    @Test
    fun getNature() {
        TestClient.getNature(10).apply {
            assertEquals(10, id)
            assertEquals("hasty", name)
            assertEquals(NamedApiResource("speed", "stat", 6), increasedStat)
            assertEquals(NamedApiResource("defense", "stat", 3), decreasedStat)
            assertEquals(NamedApiResource("sweet", "berry-flavor", 3), likesFlavor)
            assertEquals(NamedApiResource("sour", "berry-flavor", 5), hatesFlavor)
            assert(NatureStatChange(
                    pokeathlonStat = NamedApiResource("speed", "pokeathlon-stat", 1),
                    maxChange = 2
            ) in pokeathlonStatChanges)
            assert(MoveBattleStylePreference(
                    highHpPreference = 58,
                    lowHpPreference = 88,
                    moveBattleStyle = NamedApiResource("attack", "move-battle-style", 1)
            ) in moveBattleStylePreferences)
            assert(Name(
                    name = "Hasty",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getPokeathlonStat() {
        TestClient.getPokeathlonStat(1).apply {
            assertEquals(1, id)
            assertEquals("speed", name)
            assert(Name(
                    name = "Speed",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NaturePokeathlonStatAffect(
                    nature = NamedApiResource("sassy", "nature", 24),
                    maxChange = -2
            ) in affectingNatures.decrease)
            assert(NaturePokeathlonStatAffect(
                    nature = NamedApiResource("serious", "nature", 25),
                    maxChange = 1
            ) in affectingNatures.increase)
        }
    }

    @Test
    fun getPokemon1() {
        TestClient.getPokemon(1).apply {
            assertEquals(1, id)
            assertEquals("bulbasaur", name)
            assertEquals(64, baseExperience)
            assertEquals(7, height)
            assertEquals(true, isDefault)
            assertEquals(1, order)
            assertEquals(69, weight)
            assertEquals(NamedApiResource("bulbasaur", "pokemon-species", 1), species)
            assert(PokemonAbility(
                    slot = 1,
                    isHidden = false,
                    ability = NamedApiResource("overgrow", "ability", 65)
            ) in abilities)
            assert(NamedApiResource("bulbasaur", "pokemon-form", 1) in forms)
            assert(VersionGameIndex(
                    version = NamedApiResource("white-2", "version", 22),
                    gameIndex = 1
            ) in gameIndices)
            assertEquals(emptyList(), heldItems)
            assert(moves.find {
                it.move == NamedApiResource("razor-wind", "move", 13) &&
                        PokemonMoveVersion(
                                levelLearnedAt = 0,
                                versionGroup = NamedApiResource("gold-silver", "version-group", 3),
                                moveLearnMethod = NamedApiResource("egg", "move-learn-method", 2)
                        ) in it.versionGroupDetails
            } != null)
            assert(PokemonStat(
                    effort = 0,
                    baseStat = 45,
                    stat = NamedApiResource("hp", "stat", 1)
            ) in stats)
            assert(PokemonType(
                    slot = 1,
                    type = NamedApiResource("grass", "type", 12)
            ) in types)
        }
    }

    @Test
    fun getPokemon2() {
        TestClient.getPokemon(12).apply {
            assert(heldItems.find {
                it.item == NamedApiResource("silver-powder", "item", 199) &&
                        PokemonHeldItemVersion(
                                version = NamedApiResource("ruby", "version", 7),
                                rarity = 5
                        ) in it.versionDetails
            } != null)
        }
    }

    @Test
    fun getPokemon3() {
        TestClient.getPokemonEncounters(12).apply {
            assert(find {
                it.locationArea == NamedApiResource("kanto-route-2-south-towards-viridian-city", "location-area", 296) &&
                        it.versionDetails.find {
                            it.maxChance == 10
                            it.version == NamedApiResource("heartgold", "version", 15)
                            it.encounterDetails.find {
                                it.minLevel == 8 &&
                                        it.maxLevel == 8 &&
                                        it.chance == 5 &&
                                        it.method == NamedApiResource("walk", "encounter-method", 1) &&
                                        NamedApiResource("time-morning", "encounter-condition-value", 3) in it.conditionValues
                            } != null
                        } != null
            } != null)
        }
    }

    @Test
    fun getPokemon4() {
        TestClient.getPokemon(399).apply {
            sprites.apply {
                assert(backFemale!!.endsWith("/media/sprites/pokemon/back/female/399.png"))
                assert(backShinyFemale!!.endsWith("/media/sprites/pokemon/back/shiny/female/399.png"))
                assert(backDefault!!.endsWith("/media/sprites/pokemon/back/399.png"))
                assert(frontFemale!!.endsWith("/media/sprites/pokemon/female/399.png"))
                assert(frontShinyFemale!!.endsWith("/media/sprites/pokemon/shiny/female/399.png"))
                assert(backShiny!!.endsWith("/media/sprites/pokemon/back/shiny/399.png"))
                assert(frontDefault!!.endsWith("/media/sprites/pokemon/399.png"))
                assert(frontShiny!!.endsWith("/media/sprites/pokemon/shiny/399.png"))
            }
        }
    }

    @Test
    fun getPokemonColor() {
        TestClient.getPokemonColor(1).apply {
            assertEquals(1, id)
            assertEquals("black", name)
            assert(Name(
                    name = "Black",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NamedApiResource("vivillon", "pokemon-species", 666) in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonForm() {
        TestClient.getPokemonForm(1).apply {
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
                assert(frontDefault!!.endsWith("/media/sprites/pokemon/1.png"))
                assert(backDefault!!.endsWith("/media/sprites/pokemon/back/1.png"))
                assert(frontShiny!!.endsWith("/media/sprites/pokemon/shiny/1.png"))
                assert(backShiny!!.endsWith("/media/sprites/pokemon/back/shiny/1.png"))
            }
        }
    }

    @Test
    fun getPokemonHabitat() {
        TestClient.getPokemonHabitat(1).apply {
            assertEquals(1, id)
            assertEquals("cave", name)
            assert(Name(
                    name = "cave",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NamedApiResource("registeel", "pokemon-species", 379) in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonShape() {
        TestClient.getPokemonShape(1).apply {
            assertEquals(1, id)
            assertEquals("ball", name)
            assert(Name(
                    name = "Ball",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(AwesomeName(
                    awesomeName = "Pomaceous",
                    language = NamedApiResource("en", "language", 9)
            ) in awesomeNames)
            assert(NamedApiResource("volcanion", "pokemon-species", 721) in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonSpecies1() {
        TestClient.getPokemonSpecies(1).apply {
            assertEquals(1, id)
            assertEquals("bulbasaur", name)
            assertEquals(1, order)
            assertEquals(1, genderRate)
            assertEquals(45, captureRate)
            assertEquals(70, baseHappiness)
            assertEquals(false, isBaby)
            assertEquals(20, hatchCounter)
            assertEquals(false, hasGenderDifferences)
            assertEquals(false, formsSwitchable)
            assertEquals(NamedApiResource("medium-slow", "growth-rate", 4), growthRate)
            assert(PokemonSpeciesDexEntry(
                    entryNumber = 80,
                    pokedex = NamedApiResource("kalos-central", "pokedex", 12)
            ) in pokedexNumbers)
            assert(NamedApiResource("plant", "egg-group", 7) in eggGroups)
            assertEquals(NamedApiResource("green", "pokemon-color", 5), color)
            assertEquals(NamedApiResource("quadruped", "pokemon-shape", 8), shape)
            assertEquals(null, evolvesFromSpecies)
            assertEquals(ApiResource("evolution-chain", 1), evolutionChain)
            assertEquals(NamedApiResource("grassland", "pokemon-habitat", 3), habitat)
            assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
            assert(Name(
                    name = "Bulbasaur",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(PalParkEncounterArea(
                    rate = 30,
                    baseScore = 50,
                    area = NamedApiResource("field", "pal-park-area", 2)
            ) in palParkEncounters)
            assertEquals(emptyList(), formDescriptions)
            assert(Genus(
                    genus = "Seed",
                    language = NamedApiResource("en", "language", 9)
            ) in genera)
            assert(PokemonSpeciesVariety(
                    isDefault = true,
                    pokemon = NamedApiResource("bulbasaur", "pokemon", 1)
            ) in varieties)
        }
    }

    @Test
    fun getPokemonSpecies2() {
        TestClient.getPokemonSpecies(2).apply {
            assertEquals(NamedApiResource("bulbasaur", "pokemon-species", 1), evolvesFromSpecies)
        }
    }

    @Test
    fun getPokemonSpecies3() {
        TestClient.getPokemonSpecies(351).apply {
            assert(Description(
                    description = "Form changes along with type to match the weather in battle, due to forecast.  Castform is always in its normal form outside of battle, regardless of weather.",
                    language = NamedApiResource("en", "language", 9)
            ) in formDescriptions)
        }
    }

    @Test
    fun getStat() {
        TestClient.getStat(2).apply {
            assertEquals(2, id)
            assertEquals("attack", name)
            assertEquals(2, gameIndex)
            assertEquals(false, isBattleOnly)
            assert(MoveStatAffect(
                    change = 2,
                    move = NamedApiResource("swords-dance", "move", 14)
            ) in affectingMoves.increase)
            assert(MoveStatAffect(
                    change = -1,
                    move = NamedApiResource("growl", "move", 45)
            ) in affectingMoves.decrease)
            assert(NamedApiResource("lonely", "nature", 6) in affectingNatures.increase)
            assert(NamedApiResource("bold", "nature", 2) in affectingNatures.decrease)
            assertEquals(NamedApiResource("physical", "move-damage-class", 2), moveDamageClass)
            assert(Name(
                    name = "Attack",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getType() {
        TestClient.getType(8).apply {
            assertEquals(8, id)
            assertEquals("ghost", name)
            damageRelations.apply {
                assert(NamedApiResource("poison", "type", 4) in halfDamageFrom)
                assert(NamedApiResource("normal", "type", 1) in noDamageFrom)
                assert(NamedApiResource("dark", "type", 17) in halfDamageTo)
                assert(NamedApiResource("ghost", "type", 8) in doubleDamageFrom)
                assert(NamedApiResource("normal", "type", 1) in noDamageTo)
                assert(NamedApiResource("psychic", "type", 14) in doubleDamageTo)
            }
            assert(GenerationGameIndex(
                    gameIndex = 7,
                    generation = NamedApiResource("generation-vi", "generation", 6)
            ) in gameIndices)
            assertEquals(NamedApiResource("physical", "move-damage-class", 2), moveDamageClass)
            assert(Name(
                    name = "Ghost",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(TypePokemon(
                    slot = 1,
                    pokemon = NamedApiResource("litwick", "pokemon", 607)
            ) in pokemon)
            assert(NamedApiResource("hex", "move", 506) in moves)
        }
    }
}