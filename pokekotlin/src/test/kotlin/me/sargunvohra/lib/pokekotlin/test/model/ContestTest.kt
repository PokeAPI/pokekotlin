package me.sargunvohra.lib.pokekotlin.test.model

import me.sargunvohra.lib.pokekotlin.model.ContestName
import me.sargunvohra.lib.pokekotlin.model.Effect
import me.sargunvohra.lib.pokekotlin.model.FlavorText
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.junit.Test
import kotlin.test.assertEquals

class ContestTest {

    @Test
    fun getContestType() {
        mockClient.getContestType(4).apply {
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
        mockClient.getContestEffect(27).apply {
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
        mockClient.getSuperContestEffect(14).apply {
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