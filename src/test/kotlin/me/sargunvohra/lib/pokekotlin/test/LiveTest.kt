package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.client.PokeApiHttp
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class LiveTest {

    val liveClient = PokeApiHttp()

    @Test(enabled = false)
    fun liveObject() {
        assertEquals(mockClient.getBerry(10), liveClient.getBerry(10))
    }

    @Test(enabled = false)
    fun liveList() {
        assertEquals(liveClient.getMoveList(0, 50).results[25], liveClient.getMoveList(25, 50).results[0])
    }
}