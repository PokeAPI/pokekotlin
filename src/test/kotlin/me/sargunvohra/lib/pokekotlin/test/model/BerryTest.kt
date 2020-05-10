package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import me.sargunvohra.lib.pokekotlin.model.FlavorBerryMap
import me.sargunvohra.lib.pokekotlin.model.Name
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class BerryTest {

    @Test
    fun getBerry() {
        MockServer.client.getBerry(34).apply {
            assertEquals(34, id)
            assertEquals("durin", name)
            assertEquals(15, growthTime)
            assertEquals(15, maxHarvest)
            assertEquals(80, naturalGiftPower)
            assertEquals(280, size)
            assertEquals(35, smoothness)
            assertEquals(8, soilDryness)
            assertEquals(NamedApiResource("hard", "berry-firmness", 3), firmness)
            assert(flavors.isNotEmpty())
            assertEquals(NamedApiResource("durin-berry", "item", 159), item)
            assertEquals(NamedApiResource("water", "type", 11), naturalGiftType)
        }
    }

    @Test
    fun getBerryFirmness() {
        MockServer.client.getBerryFirmness(3).apply {
            assertEquals(3, id)
            assertEquals("hard", name)
            assert(NamedApiResource("rawst", "berry", 4) in berries)
            assert(
                Name(
                    name = "Hard",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
        }
    }

    @Test
    fun getBerryFlavor() {
        MockServer.client.getBerryFlavor(3).apply {
            assertEquals(3, id)
            assertEquals("sweet", name)
            assertEquals(NamedApiResource("cute", "contest-type", 3), contestType)
            assert(
                FlavorBerryMap(
                    potency = 10,
                    berry = NamedApiResource("leppa", "berry", 6)
                ) in berries
            )
            assert(
                Name(
                    name = "Sweet",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
        }
    }
}
