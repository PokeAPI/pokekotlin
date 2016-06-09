package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class LiveTest {

    @Test
    fun liveOne() {
        assertEquals(MockClient.getBerry(10), PokeApi.getBerry(10))
    }

    @Test
    fun liveTwo() {
        assertEquals(MockClient.getMove(100), PokeApi.getMove(100))
    }

    @Test
    fun liveFour() {
        assertEquals(PokeApi.getMoveList(0, 50).results[25], PokeApi.getMoveList(25, 50).results[0])
    }
}