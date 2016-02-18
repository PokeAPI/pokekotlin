package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.FlavorBerryMap
import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import org.testng.annotations.Test
import kotlin.test.*

class BerryTest {

    @Test
    fun getBerry() {
        PokeApi.getBerry(34).promise.get().apply {
            assertEquals(34, id)
            assertEquals("durin", name)
            assertEquals(15, growthTime)
            assertEquals(15, maxHarvest)
            assertEquals(80, naturalGiftPower)
            assertEquals(280, size)
            assertEquals(35, smoothness)
            assertEquals(8, soilDryness)
            firmness.apply {
                assertEquals("hard", name)
                assertEquals(PokeApi.rootUrl + "berry-firmness/3/", url)
            }
            assert(flavors.isNotEmpty())
            item.apply {
                assertEquals("durin-berry", name)
                assertEquals(PokeApi.rootUrl + "item/159/", url)
            }
            naturalGiftType.apply {
                assertEquals("water", name)
                assertEquals(PokeApi.rootUrl + "type/11/", url)
            }
        }
    }

    @Test
    fun getBerryFirmness() {
        PokeApi.getBerryFirmness(3).promise.get().apply {
            assertEquals(3, id)
            assertEquals("hard", name)
            assert(berries) {
                containsAll(
                        NamedApiResource(
                                name = "rawst",
                                url = PokeApi.rootUrl + "berry/4/"
                        )
                )
            }
            assert(names) {
                containsAll(
                        Name(
                                name = "Hard",
                                language = NamedApiResource(
                                        name = "en",
                                        url = PokeApi.rootUrl + "language/9/"
                                )
                        )
                )
            }
        }
    }

    @Test
    fun getBerryFlavor() {
        PokeApi.getBerryFlavor(3).promise.get().apply {
            assertEquals(3, id)
            assertEquals("sweet", name)
            contestType.apply {
                assertEquals("cute", name)
                assertEquals(PokeApi.rootUrl + "contest-type/3/", url)
            }
            assert(berries) {
                containsAll(
                        FlavorBerryMap(
                                potency = 10,
                                berry = NamedApiResource(
                                        "leppa",
                                        PokeApi.rootUrl + "berry/6/"
                                )
                        )
                )
            }
            assert(names) {
                containsAll(
                        Name(
                                name = "Sweet",
                                language = NamedApiResource(
                                        name = "en",
                                        url = PokeApi.rootUrl + "language/9/"
                                )
                        )
                )
            }
        }
    }
}