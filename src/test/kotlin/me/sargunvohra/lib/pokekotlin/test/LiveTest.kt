package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class LiveTest {

    val liveClient = PokeApiClient()

    @Ignore
    @Test
    fun liveObject() {
        assertEquals(mockClient.getBerry(10), liveClient.getBerry(10))
    }

    @Ignore
    @Test
    fun liveList() {
        assertEquals(liveClient.getMoveList(0, 50).results[25], liveClient.getMoveList(25, 50).results[0])
    }
}