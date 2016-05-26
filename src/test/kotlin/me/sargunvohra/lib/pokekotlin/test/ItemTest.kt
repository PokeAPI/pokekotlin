package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ItemTest {

    @Test
    fun getItem1() {
        PokeApi.getItem(20).apply {
            assertEquals(20, id)
            assertEquals("ice-heal", name)
            assertEquals(250, cost)
            assertEquals(30, flingPower)
            assert(NamedApiResource("holdable", "item-attribute", 5) in attributes)
            assertEquals(NamedApiResource("status-cures", "item-category", 30), category)
            assert(VerboseEffect(
                    effect = "Used on a party Pokémon\n:   Cures freezing.",
                    shortEffect = "Cures freezing.",
                    language = NamedApiResource("en", "language", 9)
            ) in effectEntries)
            assert(VersionGroupFlavorText(
                    text = "Defrosts a frozen\nPOKéMON.",
                    versionGroup = NamedApiResource("ruby-sapphire", "version-group", 5),
                    language = NamedApiResource("en", "language", 9)
            ) in flavorTextEntries)
            assert(GenerationGameIndex(
                    gameIndex = 20,
                    generation = NamedApiResource("generation-vi", "generation", 6)
            ) in gameIndices)
            assert(Name(
                    name = "Ice Heal",
                    language = NamedApiResource("en", "language", 9)
            ) in names)

            assertEquals(emptyList(), heldByPokemon)
            assertEquals(null, flingEffect)
            assertEquals(null, babyTriggerFor)
        }
    }

    @Test
    fun getItem2() {
        PokeApi.getItem(33).apply {
            assertNotEquals(null, heldByPokemon.find {
                it.pokemon == NamedApiResource("miltank", "pokemon", 241) &&
                        it.versionDetails.contains(ItemHolderPokemonVersionDetail(
                                rarity = 100,
                                version = NamedApiResource("y", "version", 24)
                        ))
            })
        }
    }

    @Test
    fun getItem3() {
        PokeApi.getItem(249).apply {
            assertEquals(NamedApiResource("badly-poison", "item-fling-effect", 1), flingEffect)
        }
    }

    @Test
    fun getItem4() {
        PokeApi.getItem(231).apply {
            assertEquals(ApiResource("evolution-chain", 90), babyTriggerFor)
        }
    }

    @Test
    fun getItemAttribute() {
        PokeApi.getItemAttribute(3).apply {
            assertEquals(3, id)
            assertEquals("usable-overworld", name)
            assert(Description(
                    description = "Usable outside battle",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(NamedApiResource("potion", "item", 17) in items)
            assert(Name(
                    name = "Usable_overworld",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getItemCategory() {
        PokeApi.getItemCategory(34).apply {
            assertEquals(34, id)
            assertEquals("standard-balls", name)
            assertEquals(NamedApiResource("pokeballs", "item-pocket", 3), pocket)
            assert(NamedApiResource("poke-ball", "item", 4) in items)
            assert(Name(
                    name = "Standard balls",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getItemFlingEffect() {
        PokeApi.getItemFlingEffect(1).apply {
            assertEquals(1, id)
            assertEquals("badly-poison", name)
            assert(Effect(
                    effect = "Badly poisons the target.",
                    language = NamedApiResource("en", "language", 9)
            ) in effectEntries)
            assert(NamedApiResource("toxic-orb", "item", 249) in items)
        }
    }

    @Test
    fun getItemPocket() {
        PokeApi.getItemPocket(4).apply {
            assertEquals(4, id)
            assertEquals("machines", name)
            assert(NamedApiResource("all-machines", "item-category", 37) in categories)
            assert(Name(
                    name = "TMs and HMs",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }
}