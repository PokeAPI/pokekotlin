package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.*
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.coroutines.test.runTest

class MoveTest {

  @Test
  fun getMove1() = runTest {
    LocalPokeApi.getMove(34).apply {
      assertEquals(34, id)
      assertEquals("body-slam", name)
      assertEquals(100, accuracy)
      assertEquals(30, effectChance)
      assertEquals(15, pp)
      assertEquals(0, priority)
      assertEquals(85, power)
      assertEquals(null, contestCombos)
      assertEquals(ResourceHandle.of(5, "tough"), contestType)
      assertEquals(ResourceHandle.of(4), contestEffect)
      assertEquals(ResourceHandle.of(5), superContestEffect)
      assertEquals(ResourceHandle.of(2, "physical"), damageClass)
      assertContains(
        effectEntries,
        VerboseEffect(
          effect = "Inflicts regular damage.  Has a 30% chance to paralyze the target.",
          shortEffect = "Has a 30% chance to paralyze the target.",
          language = ResourceHandle.of(9, "en"),
        ),
      )
      assertEquals(emptyList(), effectChanges)
      assertEquals(ResourceHandle.of(1, "generation-i"), generation)
      assertEquals(
        MoveMetaData(
          ailment = ResourceHandle.of(1, "paralysis"),
          category = ResourceHandle.of(4, "damage+ailment"),
          minHits = null,
          maxHits = null,
          minTurns = null,
          maxTurns = null,
          drain = 0,
          healing = 0,
          critRate = 0,
          ailmentChance = 30,
          flinchChance = 0,
          statChance = 0,
        ),
        meta,
      )
      assertContains(names, Name(name = "Body Slam", language = ResourceHandle.of(9, "en")))
      assertEquals(emptyList(), pastValues)
      assertEquals(emptyList(), statChanges)
      assertEquals(ResourceHandle.of(10, "selected-pokemon"), target)
      assertEquals(ResourceHandle.of(1, "normal"), type)
      assertContains(
        machines,
        MachineVersionDetail(
          machine = ResourceHandle.of(142),
          versionGroup = ResourceHandle.of(1, "red-blue"),
        ),
      )
      assertContains(
        flavorTextEntries,
        MoveFlavorText(
          flavorText = "An attack that may\ncause paralysis.",
          language = ResourceHandle.of(9, "en"),
          versionGroup = ResourceHandle.of(3, "gold-silver"),
        ),
      )
    }
  }

  @Test
  fun getMove2() = runTest {
    LocalPokeApi.getMove(400).apply {
      assertEquals(
        ContestComboSets(
          normalSet = ContestComboDetail(null, null),
          superSet = ContestComboDetail(null, listOf(ResourceHandle.of(116, "focus-energy"))),
        ),
        contestCombos,
      )
    }
  }

  @Test
  fun getMove3() = runTest {
    LocalPokeApi.getMove(16).apply {
      assertNotNull(
        effectChanges.find {
          it.versionGroup == ResourceHandle.of<VersionGroup>(3, "gold-silver") &&
            Effect(
              effect = "Does not hit Pokémon under the effects of fly.",
              language = ResourceHandle.of(9, "en"),
            ) in it.effectEntries
        }
      )
    }
  }

  @Test
  fun getMove4() = runTest {
    LocalPokeApi.getMove(14).apply {
      assertContains(statChanges, MoveStatChange(change = 2, stat = ResourceHandle.of(2, "attack")))
    }
  }

  @Test
  fun getMove5() = runTest {
    LocalPokeApi.getMove(2).apply {
      assertContains(
        pastValues,
        PastMoveStatValues(
          accuracy = null,
          power = null,
          pp = null,
          effectChance = null,
          effectEntries = emptyList(),
          type = ResourceHandle.of(1, "normal"),
          versionGroup = ResourceHandle.of(3, "gold-silver"),
        ),
      )
    }
  }

  @Test
  fun getMoveAilment() = runTest {
    LocalPokeApi.getMoveAilment(1).apply {
      assertEquals(1, id)
      assertEquals("paralysis", name)
      assertContains(names, Name(name = "Paralysis", language = ResourceHandle.of(9, "en")))
      assertContains(moves, ResourceHandle.of(78, "stun-spore"))
    }
  }

  @Test
  fun getMoveBattleStyle() = runTest {
    LocalPokeApi.getMoveBattleStyle(1).apply {
      assertEquals(1, id)
      assertEquals("attack", name)
      assertContains(names, Name(name = "Attack", language = ResourceHandle.of(9, "en")))
    }
  }

  @Test
  fun getMoveCategory() = runTest {
    LocalPokeApi.getMoveCategory(1).apply {
      assertEquals(1, id)
      assertEquals("ailment", name)
      assertContains(
        descriptions,
        Description(
          description = "No damage; inflicts status ailment",
          language = ResourceHandle.of(9, "en"),
        ),
      )
      assertContains(moves, ResourceHandle.of(47, "sing"))
    }
  }

  @Test
  fun getMoveDamageClass() = runTest {
    LocalPokeApi.getMoveDamageClass(1).apply {
      assertEquals(1, id)
      assertEquals("status", name)
      assertContains(names, Name(name = "status", language = ResourceHandle.of(9, "en")))
      assertContains(
        descriptions,
        Description(description = "No damage", language = ResourceHandle.of(9, "en")),
      )
      assertContains(moves, ResourceHandle.of(289, "snatch"))
    }
  }

  @Test
  fun getMoveLearnMethod() = runTest {
    LocalPokeApi.getMoveLearnMethod(10).apply {
      assertEquals(10, id)
      assertEquals("form-change", name)
      assertContains(names, Name(name = "Form Change", language = ResourceHandle.of(9, "en")))
      assertContains(
        descriptions,
        Description(
          description =
            "Appears when Rotom or Cosplay Pikachu changes form.  " +
              "Disappears if the Pokémon becomes another form and this move can only " +
              "be learned by form change.",
          language = ResourceHandle.of(9, "en"),
        ),
      )
      assertContains(versionGroups, ResourceHandle.of(15, "x-y"))
    }
  }

  @Test
  fun getMoveTarget() = runTest {
    LocalPokeApi.getMoveTarget(8).apply {
      assertEquals(8, id)
      assertEquals("random-opponent", name)
      assertContains(names, Name(name = "Random opponent", language = ResourceHandle.of(9, "en")))
      assertContains(
        descriptions,
        Description(
          description = "One opposing Pokémon, selected at random.",
          language = ResourceHandle.of(9, "en"),
        ),
      )
      assertContains(moves, ResourceHandle.of(253, "uproar"))
    }
  }
}
