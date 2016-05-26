package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PokemonTest {

    @Test
    fun getAbility() {
        PokeApi.getAbility(1).apply {
            assertEquals(1, id)
            assertEquals("stench", name)
            assertEquals(true, isMainSeries)
            assertEquals(NamedApiResource("generation-iii", PokeApi.rootUrl + "generation/3/"), generation)
            assert(Name(
                    name = "Stench",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(VerboseEffect(
                    effect = "This Pokémon's damaging moves have a 10% chance to make the target flinch with each hit if they do not already cause flinching as a secondary effect.\n\nThis ability does not stack with a held item.\n\nOverworld: The wild encounter rate is halved while this Pokémon is first in the party.",
                    shortEffect = "Has a 10% chance of making target Pokémon flinch with each hit.",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in effectEntries)
            assert(AbilityEffectChange(
                    versionGroup = NamedApiResource("black-white", PokeApi.rootUrl + "version-group/11/"),
                    effectEntries = listOf(Effect(
                            effect = "Has no effect in battle.",
                            language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
                    ))
            ) in effectChanges)
            assert(AbilityPokemon(
                    isHidden = true,
                    slot = 3,
                    pokemon = NamedApiResource("gloom", PokeApi.rootUrl + "pokemon/44/")
            ) in pokemon)
        }
    }

    @Test
    fun getCharacteristic() {
        PokeApi.getCharacteristic(1).apply {
            assertEquals(1, id)
            assertEquals(0, geneModulo)
            assertEquals((0..6).map { it * 5 }.toList(), possibleValues)
            assert(Description(
                    description = "Loves to eat",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in descriptions)
        }
    }

    @Test
    fun getEggGroup() {
        PokeApi.getEggGroup(1).apply {
            assertEquals(1, id)
            assertEquals("monster", name)
            assert(Name(
                    name = "Monster",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NamedApiResource("avalugg", PokeApi.rootUrl + "pokemon-species/713/") in pokemonSpecies)

        }
    }

    @Test
    fun getGender() {
        PokeApi.getGender(1).apply {
            assertEquals(1, id)
            assertEquals("female", name)
            assert(PokemonSpeciesGender(
                    rate = 4,
                    pokemonSpecies = NamedApiResource("noivern", PokeApi.rootUrl + "pokemon-species/715/")
            ) in pokemonSpeciesDetails)
            assert(NamedApiResource("froslass", PokeApi.rootUrl + "pokemon-species/478/") in requiredForEvolution)
        }
    }

    @Test
    fun getGrowthRate() {
        PokeApi.getGrowthRate(1).apply {
            assertEquals(1, id)
            assertEquals("slow", name)
            assertEquals("\\frac{5x^3}{4}", formula)
            assert(Description(
                    description = "slow",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in descriptions)
            assert(GrowthRateExperienceLevel(
                    experience = 1250000,
                    level = 100
            ) in levels)
            assert(NamedApiResource("volcanion", PokeApi.rootUrl + "pokemon-species/721/") in pokemonSpecies)
        }
    }

    @Test
    fun getNature() {
        PokeApi.getNature(10).apply {
            assertEquals(10, id)
            assertEquals("hasty", name)
            assertEquals(NamedApiResource("speed", PokeApi.rootUrl + "stat/6/"), increasedStat)
            assertEquals(NamedApiResource("defense", PokeApi.rootUrl + "stat/3/"), decreasedStat)
            assertEquals(NamedApiResource("sweet", PokeApi.rootUrl + "berry-flavor/3/"), likesFlavor)
            assertEquals(NamedApiResource("sour", PokeApi.rootUrl + "berry-flavor/5/"), hatesFlavor)
            assert(NatureStatChange(
                    pokeathlonStat = NamedApiResource("speed", PokeApi.rootUrl + "pokeathlon-stat/1/"),
                    maxChange = 2
            ) in pokeathlonStatChanges)
            assert(MoveBattleStylePreference(
                    highHpPreference = 58,
                    lowHpPreference = 88,
                    moveBattleStyle = NamedApiResource("attack", PokeApi.rootUrl + "move-battle-style/1/")
            ) in moveBattleStylePreferences)
            assert(Name(
                    name = "Hasty",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
        }
    }

    @Test
    fun getPokeathlonStat() {
        PokeApi.getPokeathlonStat(1).apply {
            assertEquals(1, id)
            assertEquals("speed", name)
            assert(Name(
                    name = "Speed",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NaturePokeathlonStatAffect(
                    nature = NamedApiResource("sassy", PokeApi.rootUrl + "nature/24/"),
                    maxChange = -2
            ) in affectingNatures.decrease)
            assert(NaturePokeathlonStatAffect(
                    nature = NamedApiResource("serious", PokeApi.rootUrl + "nature/25/"),
                    maxChange = 1
            ) in affectingNatures.increase)
        }
    }

    @Test
    fun getPokemon1() {
        PokeApi.getPokemon(1).apply {
            assertEquals(1, id)
            assertEquals("bulbasaur", name)
            assertEquals(64, baseExperience)
            assertEquals(7, height)
            assertEquals(true, isDefault)
            assertEquals(1, order)
            assertEquals(69, weight)
            assertEquals(NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon-species/1/"), species)
            assert(PokemonAbility(
                    slot = 1,
                    isHidden = false,
                    ability = NamedApiResource("overgrow", PokeApi.rootUrl + "ability/65/")
            ) in abilities)
            assert(NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon-form/1/") in forms)
            assert(VersionGameIndex(
                    version = NamedApiResource("white-2", PokeApi.rootUrl + "version/22/"),
                    gameIndex = 1
            ) in gameIndices)
            assertEquals(emptyList(), heldItems)
            assertEquals(emptyList(), locationAreaEncounters)
            assert(moves.find {
                it.move == NamedApiResource<Move>("razor-wind", PokeApi.rootUrl + "move/13/") &&
                        PokemonMoveVersion(
                                levelLearnedAt = 0,
                                versionGroup = NamedApiResource("gold-silver", PokeApi.rootUrl + "version-group/3/"),
                                moveLearnMethod = NamedApiResource("egg", PokeApi.rootUrl + "move-learn-method/2/")
                        ) in it.versionGroupDetails
            } != null)
            assert(PokemonStat(
                    effort = 0,
                    baseStat = 0,
                    stat = NamedApiResource("hp", PokeApi.rootUrl + "stat/1/")
            ) in stats)
            assert(PokemonType(
                    slot = 1,
                    type = NamedApiResource("grass", PokeApi.rootUrl + "type/12/")
            ) in types)
        }
    }

    @Test
    fun getPokemon2() {
        PokeApi.getPokemon(12).apply {
            assert(heldItems.find {
                it.item == NamedApiResource<Item>("silver-powder", PokeApi.rootUrl + "item/199/") &&
                        PokemonHeldItemVersion(
                                version = NamedApiResource("ruby", PokeApi.rootUrl + "version/7/"),
                                rarity = 5
                        ) in it.versionDetails
            } != null)
        }
    }

    @Test
    fun getPokemon3() {
        PokeApi.getPokemon(12).apply {
            assert(locationAreaEncounters.find {
                it.locationArea == NamedApiResource<LocationArea>("kanto-route-2-south-towards-viridian-city", PokeApi.rootUrl + "location-area/296/") &&
                        it.versionDetails.find {
                            it.maxChance == 10
                            it.version == NamedApiResource<Version>("heartgold", PokeApi.rootUrl + "version/15/")
                            it.encounterDetails.find {
                                it.minLevel == 8 &&
                                        it.maxLevel == 8 &&
                                        it.chance == 5 &&
                                        it.method == NamedApiResource<EncounterMethod>("walk", PokeApi.rootUrl + "encounter-method/1/") &&
                                        NamedApiResource("time-morning", PokeApi.rootUrl + "encounter-condition-value/3/") in it.conditionValues
                            } != null
                        } != null
            } != null)
        }
    }

    @Test
    fun getPokemonColor() {
        PokeApi.getPokemonColor(1).apply {
            assertEquals(1, id)
            assertEquals("black", name)
            assert(Name(
                    name = "Black",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NamedApiResource("vivillon", PokeApi.rootUrl + "pokemon-species/666/") in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonForm() {
        PokeApi.getPokemonForm(1).apply {
            assertEquals(1, id)
            assertEquals("bulbasaur", name)
            assertEquals(1, order)
            assertEquals(1, formOrder)
            assertEquals(true, isDefault)
            assertEquals(false, isBattleOnly)
            assertEquals(false, isMega)
            assertEquals("", formName)
            assertEquals(NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon/1/"), pokemon)
            assertEquals(NamedApiResource("red-blue", PokeApi.rootUrl + "version-group/1/"), versionGroup)
        }
    }

    @Test
    fun getPokemonHabitat() {
        PokeApi.getPokemonHabitat(1).apply {
            assertEquals(1, id)
            assertEquals("cave", name)
            assert(Name(
                    name = "cave",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(NamedApiResource("registeel", PokeApi.rootUrl + "pokemon-species/379/") in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonShape() {
        PokeApi.getPokemonShape(1).apply {
            assertEquals(1, id)
            assertEquals("ball", name)
            assert(Name(
                    name = "Ball",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(AwesomeName(
                    awesomeName = "Pomaceous",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in awesomeNames)
            assert(NamedApiResource("volcanion", PokeApi.rootUrl + "pokemon-species/721/") in pokemonSpecies)
        }
    }

    @Test
    fun getPokemonSpecies1() {
        PokeApi.getPokemonSpecies(1).apply {
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
            assertEquals(NamedApiResource("medium-slow", PokeApi.rootUrl + "growth-rate/4/"), growthRate)
            assert(PokemonSpeciesDexEntry(
                    entryNumber = 80,
                    pokedex = NamedApiResource("kalos-central", PokeApi.rootUrl + "pokedex/12/")
            ) in pokedexNumbers)
            assert(NamedApiResource("plant", PokeApi.rootUrl + "egg-group/7/") in eggGroups)
            assertEquals(NamedApiResource("green", PokeApi.rootUrl + "pokemon-color/5/"), color)
            assertEquals(NamedApiResource("quadruped", PokeApi.rootUrl + "pokemon-shape/8/"), shape)
            assertEquals(null, evolvesFromSpecies)
            assertEquals(ApiResource(PokeApi.rootUrl + "evolution-chain/1/"), evolutionChain)
            assertEquals(NamedApiResource("grassland", PokeApi.rootUrl + "pokemon-habitat/3/"), habitat)
            assertEquals(NamedApiResource("generation-i", PokeApi.rootUrl + "generation/1/"), generation)
            assert(Name(
                    name = "Bulbasaur",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(PalParkEncounterArea(
                    rate = 30,
                    baseScore = 50,
                    area = NamedApiResource("field", PokeApi.rootUrl + "pal-park-area/2/")
            ) in palParkEncounters)
            assertEquals(emptyList(), formDescriptions)
            assert(Genus(
                    genus = "Seed",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in genera)
            assert(PokemonSpeciesVariety(
                    isDefault = true,
                    pokemon = NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon/1/")
            ) in varieties)
        }
    }

    @Test
    fun getPokemonSpecies2() {
        PokeApi.getPokemonSpecies(2).apply {
            assertEquals(NamedApiResource("bulbasaur", PokeApi.rootUrl + "pokemon-species/1/"), evolvesFromSpecies)
        }
    }

    @Test
    fun getPokemonSpecies3() {
        PokeApi.getPokemonSpecies(351).apply {
            assert(Description(
                    description = "Form changes along with type to match the weather in battle, due to forecast.  Castform is always in its normal form outside of battle, regardless of weather.",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in formDescriptions)
        }
    }

    @Test
    fun getStat() {
        PokeApi.getStat(2).apply {
            assertEquals(2, id)
            assertEquals("attack", name)
            assertEquals(2, gameIndex)
            assertEquals(false, isBattleOnly)
            assert(MoveStatAffect(
                    change = 2,
                    move = NamedApiResource("swords-dance", PokeApi.rootUrl + "move/14/")
            ) in affectingMoves.increase)
            assert(MoveStatAffect(
                    change = -1,
                    move = NamedApiResource("growl", PokeApi.rootUrl + "move/45/")
            ) in affectingMoves.decrease)
            assert(NamedApiResource("lonely", PokeApi.rootUrl + "nature/6/") in affectingNatures.increase)
            assert(NamedApiResource("bold", PokeApi.rootUrl + "nature/2/") in affectingNatures.decrease)
            assertEquals(NamedApiResource("physical", PokeApi.rootUrl + "move-damage-class/2/"), moveDamageClass)
            assert(Name(
                    name = "Attack",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
        }
    }

    @Test
    fun getType() {
        PokeApi.getType(8).apply {
            assertEquals(8, id)
            assertEquals("ghost", name)
            damageRelations.apply {
                assert(NamedApiResource("poison", PokeApi.rootUrl + "type/4/") in halfDamageFrom)
                assert(NamedApiResource("normal", PokeApi.rootUrl + "type/1/") in noDamageFrom)
                assert(NamedApiResource("dark", PokeApi.rootUrl + "type/17/") in halfDamageTo)
                assert(NamedApiResource("ghost", PokeApi.rootUrl + "type/8/") in doubleDamageFrom)
                assert(NamedApiResource("normal", PokeApi.rootUrl + "type/1/") in noDamageTo)
                assert(NamedApiResource("psychic", PokeApi.rootUrl + "type/14/") in doubleDamageTo)
            }
            assert(GenerationGameIndex(
                    gameIndex = 7,
                    generation = NamedApiResource("generation-vi", PokeApi.rootUrl + "generation/6/")
            ) in gameIndices)
            assertEquals(NamedApiResource("physical", PokeApi.rootUrl + "move-damage-class/2/"), moveDamageClass)
            assert(Name(
                    name = "Ghost",
                    language = NamedApiResource("en", PokeApi.rootUrl + "language/9/")
            ) in names)
            assert(TypePokemon(
                    slot = 1,
                    pokemon = NamedApiResource("litwick", PokeApi.rootUrl + "pokemon/607/")
            ) in pokemon)
            assert(NamedApiResource("hex", PokeApi.rootUrl + "move/506/") in moves)
        }
    }
}