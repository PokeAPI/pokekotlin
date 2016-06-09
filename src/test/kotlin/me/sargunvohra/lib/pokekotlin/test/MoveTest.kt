package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.*
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MoveTest {

    @Test
    fun getMove1() {
        MockClient.getMove(34).apply {
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
            assert(VerboseEffect(
                    effect = "Inflicts regular damage.  Has a \$effect_chance% chance to paralyze the target.",
                    shortEffect = "Has a \$effect_chance% chance to paralyze the target.",
                    language = NamedApiResource("en", "language", 9)
            ) in effectEntries)
            assertEquals(emptyList(), effectChanges)
            assertEquals(NamedApiResource("generation-i", "generation", 1), generation)
            assertEquals(MoveMetaData(
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
                    statChance = 0
            ), meta)
            assert(Name(
                    name = "Body Slam",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assertEquals(emptyList(), pastValues)
            assertEquals(emptyList(), statChanges)
            assertEquals(NamedApiResource("selected-pokemon", "move-target", 10), target)
            assertEquals(NamedApiResource("normal", "type", 1), type)
        }
    }

    @Test
    fun getMove2() {
        MockClient.getMove(400).apply {
            assertEquals(ContestComboSets(
                    normalSet = ContestComboDetail(null, null),
                    superSet = ContestComboDetail(null, listOf(NamedApiResource("focus-energy", "move", 116)))
            ), contestCombos)
        }
    }

    @Test
    fun getMove3() {
        MockClient.getMove(16).apply {
            assertNotNull(effectChanges.find {
                it.versionGroup == NamedApiResource("gold-silver", "version-group", 3) &&
                        Effect(
                                effect = "Does not hit Pokémon under the effects of fly.",
                                language = NamedApiResource("en", "language", 9)
                        ) in it.effectEntries
            })
        }
    }

    @Test
    fun getMove4() {
        MockClient.getMove(14).apply {
            assert(MoveStatChange(
                    change = 2,
                    stat = NamedApiResource("attack", "stat", 2)
            ) in statChanges)
        }
    }

    @Test
    fun getMove5() {
        MockClient.getMove(2).apply {
            assert(PastMoveStatValues(
                    accuracy = null,
                    power = null,
                    pp = null,
                    effectChance = null,
                    effectEntries = emptyList(),
                    type = NamedApiResource("normal", "type", 1),
                    versionGroup = NamedApiResource("gold-silver", "version-group", 3)
            ) in pastValues)
        }
    }

    @Test
    fun getMoveAilment() {
        MockClient.getMoveAilment(1).apply {
            assertEquals(1, id)
            assertEquals("paralysis", name)
            assert(Name(
                    name = "Paralysis",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(NamedApiResource("stun-spore", "move", 78) in moves)
        }
    }

    @Test
    fun getMoveBattleStyle() {
        MockClient.getMoveBattleStyle(1).apply {
            assertEquals(1, id)
            assertEquals("attack", name)
            assert(Name(
                    name = "Attack",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getMoveCategory() {
        MockClient.getMoveCategory(1).apply {
            assertEquals(1, id)
            assertEquals("ailment", name)
            assert(Description(
                    description = "No damage; inflicts status ailment",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(NamedApiResource("sing", "move", 47) in moves)
        }
    }

    @Test
    fun getMoveDamageClass() {
        MockClient.getMoveDamageClass(1).apply {
            assertEquals(1, id)
            assertEquals("status", name)
            assert(Name(
                    name = "status",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(Description(
                    description = "No damage",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(NamedApiResource("snatch", "move", 289) in moves)
        }
    }

    @Test
    fun getMoveLearnMethod() {
        MockClient.getMoveLearnMethod(10).apply {
            assertEquals(10, id)
            assertEquals("form-change", name)
            assert(Name(
                    name = "Rotom Form",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(Description(
                    description = "Appears when Rotom changes to this form.  Disappears if Rotom becomes another form and this move can only be learned by form change.",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(NamedApiResource("x-y", "version-group", 15) in versionGroups)
        }
    }

    @Test
    fun getMoveTarget() {
        MockClient.getMoveTarget(8).apply {
            assertEquals(8, id)
            assertEquals("random-opponent", name)
            assert(Name(
                    name = "Random opponent",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
            assert(Description(
                    description = "One opposing Pokémon, selected at random.",
                    language = NamedApiResource("en", "language", 9)
            ) in descriptions)
            assert(NamedApiResource("uproar", "move", 253) in moves)
        }
    }
}