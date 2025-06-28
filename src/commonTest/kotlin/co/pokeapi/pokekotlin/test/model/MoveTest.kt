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
      assertEquals(NamedApiResource("tough", "contest-type", 5), contestType)
      assertEquals(ApiResource("contest-effect", 4), contestEffect)
      assertEquals(ApiResource("super-contest-effect", 5), superContestEffect)
      assertEquals(NamedApiResource("physical", "move-damage-class", 2), damageClass)
      assertContains(
        effectEntries,
        VerboseEffect(
          effect = "Inflicts regular damage.  Has a 30% chance to paralyze the target.",
          shortEffect = "Has a 30% chance to paralyze the target.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertEquals(emptyList(), effectChanges)
      assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
      assertEquals(
        MoveMetaData(
          ailment = NamedApiResource("paralysis", "move-ailment", 1),
          category = NamedApiResource("damage+ailment", "move-category", 4),
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
      assertContains(
        names,
        Name(name = "Body Slam", language = NamedApiResource("en", "language", 9)),
      )
      assertEquals(emptyList(), pastValues)
      assertEquals(emptyList(), statChanges)
      assertEquals(NamedApiResource("selected-pokemon", "move-target", 10), target)
      assertEquals(NamedApiResource("normal", "type", 1), type)
      assertContains(
        machines,
        MachineVersionDetail(
          machine = ApiResource("machine", 142),
          versionGroup = NamedApiResource("red-blue", "version-group", 1),
        ),
      )
      assertContains(
        flavorTextEntries,
        MoveFlavorText(
          flavorText = "An attack that may\ncause paralysis.",
          language = NamedApiResource("en", "language", 9),
          versionGroup = NamedApiResource("gold-silver", "version-group", 3),
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
          superSet = ContestComboDetail(null, listOf(NamedApiResource("focus-energy", "move", 116))),
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
          it.versionGroup == NamedApiResource("gold-silver", "version-group", 3) &&
            Effect(
              effect = "Does not hit Pokémon under the effects of fly.",
              language = NamedApiResource("en", "language", 9),
            ) in it.effectEntries
        }
      )
    }
  }

  @Test
  fun getMove4() = runTest {
    LocalPokeApi.getMove(14).apply {
      assertContains(
        statChanges,
        MoveStatChange(change = 2, stat = NamedApiResource("attack", "stat", 2)),
      )
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
          type = NamedApiResource("normal", "type", 1),
          versionGroup = NamedApiResource("gold-silver", "version-group", 3),
        ),
      )
    }
  }

  @Test
  fun getMoveAilment() = runTest {
    LocalPokeApi.getMoveAilment(1).apply {
      assertEquals(1, id)
      assertEquals("paralysis", name)
      assertContains(
        names,
        Name(name = "Paralysis", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(moves, NamedApiResource("stun-spore", "move", 78))
    }
  }

  @Test
  fun getMoveBattleStyle() = runTest {
    LocalPokeApi.getMoveBattleStyle(1).apply {
      assertEquals(1, id)
      assertEquals("attack", name)
      assertContains(names, Name(name = "Attack", language = NamedApiResource("en", "language", 9)))
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
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(moves, NamedApiResource("sing", "move", 47))
    }
  }

  @Test
  fun getMoveDamageClass() = runTest {
    LocalPokeApi.getMoveDamageClass(1).apply {
      assertEquals(1, id)
      assertEquals("status", name)
      assertContains(names, Name(name = "status", language = NamedApiResource("en", "language", 9)))
      assertContains(
        descriptions,
        Description(description = "No damage", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(moves, NamedApiResource("snatch", "move", 289))
    }
  }

  @Test
  fun getMoveLearnMethod() = runTest {
    LocalPokeApi.getMoveLearnMethod(10).apply {
      assertEquals(10, id)
      assertEquals("form-change", name)
      assertContains(
        names,
        Name(name = "Form Change", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        descriptions,
        Description(
          description =
            "Appears when Rotom or Cosplay Pikachu changes form.  " +
              "Disappears if the Pokémon becomes another form and this move can only " +
              "be learned by form change.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(versionGroups, NamedApiResource("x-y", "version-group", 15))
    }
  }

  @Test
  fun getMoveTarget() = runTest {
    LocalPokeApi.getMoveTarget(8).apply {
      assertEquals(8, id)
      assertEquals("random-opponent", name)
      assertContains(
        names,
        Name(name = "Random opponent", language = NamedApiResource("en", "language", 9)),
      )
      assertContains(
        descriptions,
        Description(
          description = "One opposing Pokémon, selected at random.",
          language = NamedApiResource("en", "language", 9),
        ),
      )
      assertContains(moves, NamedApiResource("uproar", "move", 253))
    }
  }
}
