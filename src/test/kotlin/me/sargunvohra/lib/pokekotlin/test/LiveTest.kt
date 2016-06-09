package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class LiveTest {

    @Test
    fun liveObject() {
        assertEquals(MockClient.getBerry(10), PokeApi.getBerry(10))
    }

    @Test
    fun liveList() {
        assertEquals(PokeApi.getMoveList(0, 50).results[25], PokeApi.getMoveList(25, 50).results[0])
    }
}