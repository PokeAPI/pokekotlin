package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class MachineTest {

    @Test
    fun getMachine() {
        MockServer.client.getMachine(18).apply {
            assertEquals(18, id)
            assertEquals(NamedApiResource("tm01", "item", 305), item)
            assertEquals(NamedApiResource("work-up", "move", 526), move)
            assertEquals(
                NamedApiResource("ultra-sun-ultra-moon", "version-group", 18),
                versionGroup
            )
        }
    }
}
