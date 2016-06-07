package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class EncounterTest {

    @Test
    fun getEncounterMethod() {
        TestClient.getEncounterMethod(5).apply {
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
        TestClient.getEncounterCondition(5).apply {
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
        TestClient.getEncounterConditionValue(5).apply {
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
