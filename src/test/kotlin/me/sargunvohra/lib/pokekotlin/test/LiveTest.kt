package me.sargunvohra.lib.pokekotlin.test

import kotlin.test.assertEquals
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import org.junit.Ignore
import org.junit.Test

@Ignore
class LiveTest {

    private val liveClient = PokeApiClient()

    @Test
    fun liveObject() {
        assertEquals(MockServer.client.getBerry(10), liveClient.getBerry(10))
    }

    @Test
    fun liveList() {
        assertEquals(
            liveClient.getMoveList(0, 50).results[25],
            liveClient.getMoveList(25, 50).results[0]
        )
    }
}
