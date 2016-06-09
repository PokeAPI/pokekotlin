package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class EncounterTest {

    @Test
    fun getEncounterMethod() {
        MockClient.getEncounterMethod(5).apply {
            assertEquals(5, id)
            assertEquals("surf", name)
            assertEquals(14, order)
            assert(Name(
                    name = "Surfing",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getEncounterCondition() {
        MockClient.getEncounterCondition(5).apply {
            assertEquals(5, id)
            assertEquals("radio", name)
            assert(NamedApiResource("radio-hoenn", "encounter-condition-value", 15) in values)
            assert(Name(
                    name = "Radio",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }

    @Test
    fun getEncounterConditionValue() {
        MockClient.getEncounterConditionValue(5).apply {
            assertEquals(5, id)
            assertEquals("time-night", name)
            assertEquals(NamedApiResource("time", "encounter-condition", 2), condition)
            assert(Name(
                    name = "At night",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }
}
