package me.sargunvohra.lib.pokekotlin.test.model

import me.sargunvohra.lib.pokekotlin.model.Name
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals

class UtilityTest {

    @Test
    fun getLanguage() {
        mockClient.getLanguage(9).apply {
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