package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import me.sargunvohra.lib.pokekotlin.model.Name
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class EncounterTest {

    @Test
    fun getEncounterMethod() {
        MockServer.client.getEncounterMethod(5).apply {
            assertEquals(5, id)
            assertEquals("surf", name)
            assertEquals(14, order)
            assert(
                Name(
                    name = "Surfing",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
        }
    }

    @Test
    fun getEncounterCondition() {
        MockServer.client.getEncounterCondition(5).apply {
            assertEquals(5, id)
            assertEquals("radio", name)
            assert(NamedApiResource("radio-hoenn", "encounter-condition-value", 15) in values)
            assert(
                Name(
                    name = "Radio",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
        }
    }

    @Test
    fun getEncounterConditionValue() {
        MockServer.client.getEncounterConditionValue(5).apply {
            assertEquals(5, id)
            assertEquals("time-night", name)
            assertEquals(NamedApiResource("time", "encounter-condition", 2), condition)
            assert(
                Name(
                    name = "At night",
                    language = NamedApiResource("en", "language", 9)
                ) in names
            )
        }
    }
}
