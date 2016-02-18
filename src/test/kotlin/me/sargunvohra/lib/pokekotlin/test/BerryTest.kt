package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import org.testng.annotations.Test
import kotlin.test.assertEquals

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
}