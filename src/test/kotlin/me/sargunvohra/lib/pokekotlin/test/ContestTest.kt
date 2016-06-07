package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.ContestName
import me.sargunvohra.lib.pokekotlin.json.Effect
import me.sargunvohra.lib.pokekotlin.json.FlavorText
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class ContestTest {

    @Test
    fun getContestType() {
        TestClient.getContestType(4).apply {
            assertEquals(4, id)
            assertEquals("smart", name)
            assertEquals(NamedApiResource("bitter", "berry-flavor", 4), berryFlavor)
            assert(ContestName(
                    name = "Smart",
                    color = "Green",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getContestEffect() {
        TestClient.getContestEffect(27).apply {
            assertEquals(27, id)
            assertEquals(2, appeal)
            assertEquals(0, jam)
            assert(Effect(
                    effect = "If user appeals first this turn, earns six points instead of two.",
                    language = NamedApiResource("en", "language", 9)
            ) in effectEntries)
            assert(FlavorText(
                    flavorText = "The appeal works great if performed first.",
                    language = NamedApiResource("en", "language", 9)
            ) in flavorTextEntries)
        }
    }

    @Test
    fun getSuperContestEffect() {
        TestClient.getSuperContestEffect(14).apply {
            assertEquals(14, id)
            assertEquals(2, appeal)
            assert(FlavorText(
                    flavorText = "Makes the order of contestants random in the next turn.",
                    language = NamedApiResource("en", "language", 9)
            ) in flavorTextEntries)
            assert(NamedApiResource("assist", "move", 274) in moves)
        }
    }
}