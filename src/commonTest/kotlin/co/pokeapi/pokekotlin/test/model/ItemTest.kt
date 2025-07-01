package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.*
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.*
import kotlinx.coroutines.test.runTest

class ItemTest {

  @Test
  fun getItem1() = runTest {
    LocalPokeApi.getItem(20).apply {
      assertEquals(20, id)
      assertEquals("ice-heal", name)
      assertEquals(200, cost)
      assertEquals(30, flingPower)
      assertContains(attributes, Handle.of(5, "holdable"))
      assertEquals(Handle.of(30, "status-cures"), category)
      assertContains(
        effectEntries,
        VerboseEffect(
          effect = "Used on a party Pokémon\n:   Cures freezing.",
          shortEffect = "Cures freezing.",
          language = Handle.of(9, "en"),
        ),
      )
      assertContains(
        flavorTextEntries,
        VersionGroupFlavorText(
          text = "Defrosts a frozen\nPOKéMON.",
          versionGroup = Handle.of(5, "ruby-sapphire"),
          language = Handle.of(9, "en"),
        ),
      )
      assertContains(
        gameIndices,
        GenerationGameIndex(gameIndex = 20, generation = Handle.of(6, "generation-vi")),
      )
      assertContains(names, Name(name = "Ice Heal", language = Handle.of(9, "en")))

      assertEquals(emptyList(), heldByPokemon)
      assertEquals(null, flingEffect)
      assertEquals(null, babyTriggerFor)
      assertTrue(sprites.default!!.endsWith("/sprites/items/ice-heal.png"))
    }
  }

  @Test
  fun getItem2() = runTest {
    LocalPokeApi.getItem(33).apply {
      assertNotEquals(
        null,
        heldByPokemon.find {
          it.pokemon == Handle.of<PokemonVariety>(241, "miltank") &&
            it.versionDetails.contains(
              ItemHolderPokemonVersionDetail(rarity = 100, version = Handle.of(24, "y"))
            )
        },
      )
    }
  }

  @Test
  fun getItem3() = runTest {
    LocalPokeApi.getItem(249).apply { assertEquals(Handle.of(1, "badly-poison"), flingEffect) }
  }

  @Test
  fun getItem4() = runTest {
    LocalPokeApi.getItem(231).apply { assertEquals(Handle.of(90), babyTriggerFor) }
  }

  @Test fun getItem5() = runTest { LocalPokeApi.getItem(967) }

  @Test
  fun getItem6() = runTest {
    LocalPokeApi.getItem(305).apply {
      assertNotNull(
        machines.find { machineVersionDetail ->
          machineVersionDetail.machine == Handle.of<Machine>(2) &&
            machineVersionDetail.versionGroup == Handle.of<VersionGroup>(1, "red-blue")
        }
      )
    }
  }

  @Test
  fun getItemAttribute() = runTest {
    LocalPokeApi.getItemAttribute(3).apply {
      assertEquals(3, id)
      assertEquals("usable-overworld", name)
      assertContains(
        descriptions,
        Description(description = "Usable outside battle", language = Handle.of(9, "en")),
      )
      assertContains(items, Handle.of(17, "potion"))
      assertContains(names, Name(name = "Usable_overworld", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getItemCategory() = runTest {
    LocalPokeApi.getItemCategory(34).apply {
      assertEquals(34, id)
      assertEquals("standard-balls", name)
      assertEquals(Handle.of(3, "pokeballs"), pocket)
      assertContains(items, Handle.of(4, "poke-ball"))
      assertContains(names, Name(name = "Standard balls", language = Handle.of(9, "en")))
    }
  }

  @Test
  fun getItemFlingEffect() = runTest {
    LocalPokeApi.getItemFlingEffect(1).apply {
      assertEquals(1, id)
      assertEquals("badly-poison", name)
      assertContains(
        effectEntries,
        Effect(effect = "Badly poisons the target.", language = Handle.of(9, "en")),
      )
      assertContains(items, Handle.of(249, "toxic-orb"))
    }
  }

  @Test
  fun getItemPocket() = runTest {
    LocalPokeApi.getItemPocket(4).apply {
      assertEquals(4, id)
      assertEquals("machines", name)
      assertContains(categories, Handle.of(37, "all-machines"))
      assertContains(names, Name(name = "TMs and HMs", language = Handle.of(9, "en")))
    }
  }
}
