package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PokemonTest {

    @Test
    fun getAbility() {
        PokeApi.getAbility(1).promise.get().apply {
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
        PokeApi.getCharacteristic(1).promise.get().apply {
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
        PokeApi.getEggGroup(1).promise.get().apply {
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
        PokeApi.getGender(1).promise.get().apply {
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
        PokeApi.getGrowthRate(1).promise.get().apply {
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
        PokeApi.getNature(10).promise.get().apply {
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
        PokeApi.getPokeathlonStat(1).promise.get().apply {
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
    fun getPokemon() {
        PokeApi.getPokemon(1).promise.get().apply {
            // TODO
        }
    }

    @Test
    fun getPokemonColor() {
        PokeApi.getPokemonColor(1).promise.get().apply {
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
        PokeApi.getPokemonForm(1).promise.get().apply {
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
        PokeApi.getPokemonHabitat(1).promise.get().apply {
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
        PokeApi.getPokemonShape(1).promise.get().apply {
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
    fun getPokemonSpecies() {
        PokeApi.getPokemonSpecies(1).promise.get().apply {
            // TODO
        }
    }

    @Test
    fun getStat() {
        PokeApi.getStat(2).promise.get().apply {
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
        PokeApi.getType(8).promise.get().apply {
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