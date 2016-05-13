package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.Name
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import org.testng.annotations.Test
import kotlin.test.*

class UtilityTest {

    @Test
    fun getLanguage() {
        PokeApi.getLanguage(9).promise.get().apply {
            assertEquals(9, id)
            assertEquals("us", iso3166)
            assertEquals("en", iso639)
            assertEquals("en", name)
            assert(Name(
                    name = "English",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in names)
        }
    }
}