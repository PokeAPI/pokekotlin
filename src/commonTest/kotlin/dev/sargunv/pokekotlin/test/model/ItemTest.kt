package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.ApiResource
import dev.sargunv.pokekotlin.model.Description
import dev.sargunv.pokekotlin.model.Effect
import dev.sargunv.pokekotlin.model.GenerationGameIndex
import dev.sargunv.pokekotlin.model.ItemHolderPokemonVersionDetail
import dev.sargunv.pokekotlin.model.Name
import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.model.VerboseEffect
import dev.sargunv.pokekotlin.model.VersionGroupFlavorText
import dev.sargunv.pokekotlin.test.MockServer
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest

class ItemTest {

  @Test
  fun getItem1() = runTest {
    MockServer.client.getItem(20).apply {
      assertEquals(20, id)
      assertEquals("ice-heal", name)
      assertEquals(100, cost)
      assertEquals(30, flingPower)
      assertContains(attributes, NamedApiResource("holdable", "item-attribute", 5))
      assertEquals(NamedApiResource("status-cures", "item-category", 30), category)
      assertContains(
        effectEntries,
        VerboseEffect(
          effect = "Used on a party Pokémon\n:   Cures freezing.",
          shortEffect = "Cures freezing.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(
        flavorTextEntries,
        VersionGroupFlavorText(
          text = "Defrosts a frozen\nPOKéMON.",
          versionGroup = NamedApiResource("ruby-sapphire", "version-group", 5),
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(
        gameIndices,
        GenerationGameIndex(
          gameIndex = 20,
          generation = NamedApiResource("generation-vi", "generation", 6),
        ),
      )
      assertContains(
        names,
        Name(name = "Ice Heal", language = NamedApiResource("en", "language", 9)),
      )

      assertEquals(emptyList(), heldByPokemon)
      assertEquals(null, flingEffect)
      assertEquals(null, babyTriggerFor)
      assertTrue(sprites.default!!.endsWith("/sprites/items/ice-heal.png"))
    }
  }

  @Test
  fun getItem2() = runTest {
    MockServer.client.getItem(33).apply {
      assertNotEquals(
        null,
        heldByPokemon.find {
          it.pokemon == NamedApiResource("miltank", "pokemon", 241) &&
            it.versionDetails.contains(
              ItemHolderPokemonVersionDetail(
                rarity = 100,
                version = NamedApiResource("y", "version", 24),
              )
            )
        },
      )
    }
  }

  @Test
  fun getItem3() = runTest {
    MockServer.client.getItem(249).apply {
      assertEquals(NamedApiResource("badly-poison", "item-fling-effect", 1), flingEffect)
    }
  }

  @Test
  fun getItem4() = runTest {
    MockServer.client.getItem(231).apply {
      assertEquals(ApiResource("evolution-chain", 90), babyTriggerFor)
    }
  }

  @Test fun getItem5() = runTest { MockServer.client.getItem(967) }

  @Test
  fun getItem6() = runTest {
    MockServer.client.getItem(305).apply {
      assertNotNull(
        machines.find { machineVersionDetail ->
          machineVersionDetail.machine == ApiResource("machine", 1) &&
            machineVersionDetail.versionGroup == NamedApiResource("red-blue", "version-group", 1)
        }
      )
    }
  }

  @Test
  fun getItemAttribute() = runTest {
    MockServer.client.getItemAttribute(3).apply {
      assertEquals(3, id)
      assertEquals("usable-overworld", name)
      assertContains(
        descriptions,
        Description(
          description = "Usable outside battle",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(items, NamedApiResource("potion", "item", 17))
      assertContains(
        names,
        Name(name = "Usable_overworld", language = NamedApiResource("en", "language", 9)),
      )
    }
  }

  @Test
  fun getItemCategory() = runTest {
    MockServer.client.getItemCategory(34).apply {
      assertEquals(34, id)
      assertEquals("standard-balls", name)
      assertEquals(NamedApiResource("pokeballs", "item-pocket", 3), pocket)
      assertContains(items, NamedApiResource("poke-ball", "item", 4))
      assertContains(
        names,
        Name(name = "Standard balls", language = NamedApiResource("en", "language", 9)),
      )
    }
  }

  @Test
  fun getItemFlingEffect() = runTest {
    MockServer.client.getItemFlingEffect(1).apply {
      assertEquals(1, id)
      assertEquals("badly-poison", name)
      assertContains(
        effectEntries,
        Effect(
          effect = "Badly poisons the target.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(items, NamedApiResource("toxic-orb", "item", 249))
    }
  }

  @Test
  fun getItemPocket() = runTest {
    MockServer.client.getItemPocket(4).apply {
      assertEquals(4, id)
      assertEquals("machines", name)
      assertContains(categories, NamedApiResource("all-machines", "item-category", 37))
      assertContains(
        names,
        Name(name = "TMs and HMs", language = NamedApiResource("en", "language", 9)),
      )
    }
  }
}
