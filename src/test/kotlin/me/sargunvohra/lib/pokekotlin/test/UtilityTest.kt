package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class UtilityTest {

    @Test
    fun getLanguage() {
        TestClient.getLanguage(9).apply {
            assertEquals(9, id)
            assertEquals("us", iso3166)
            assertEquals("en", iso639)
            assertEquals("en", name)
            assert(Name(
                    name = "English",
                    language = NamedApiResource("en", "language", 9)
            ) in names)
        }
    }
}