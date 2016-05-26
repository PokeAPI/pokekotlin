package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.json.ContestName
import me.sargunvohra.lib.pokekotlin.json.Effect
import me.sargunvohra.lib.pokekotlin.json.FlavorText
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import org.testng.annotations.Test
import kotlin.test.assertEquals

class ContestTest {

    @Test
    fun getContestType() {
        PokeApi.getContestType(4).apply {
            assertEquals(4, id)
            assertEquals("smart", name)
            berryFlavor.apply {
                assertEquals("bitter", name)
                assertEquals(PokeApi.rootUrl + "berry-flavor/4/", url)
            }
            assert(ContestName(
                    name = "Smart",
                    color = "Green",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in names)
        }
    }

    @Test
    fun getContestEffect() {
        PokeApi.getContestEffect(27).apply {
            assertEquals(27, id)
            assertEquals(2, appeal)
            assertEquals(0, jam)
            assert(Effect(
                    effect = "If user appeals first this turn, earns six points instead of two.",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in effectEntries)
            assert(FlavorText(
                    flavorText = "The appeal works great if performed first.",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in flavorTextEntries)
        }
    }

    @Test
    fun getSuperContestEffect() {
        PokeApi.getSuperContestEffect(14).apply {
            assertEquals(14, id)
            assertEquals(2, appeal)
            assert(FlavorText(
                    flavorText = "Makes the order of contestants random in the next turn.",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in flavorTextEntries)
            assert(NamedApiResource(
                    name = "assist",
                    url = PokeApi.rootUrl + "move/274/"
            ) in moves)
        }
    }
}