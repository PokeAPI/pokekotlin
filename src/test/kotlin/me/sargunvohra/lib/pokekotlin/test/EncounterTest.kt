package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.Test
import kotlin.test.*

class EncounterTest {

    @Test
    fun getEncounterMethod() {
        PokeApi.getEncounterMethod(5).promise.get().apply {
            assertEquals(5, id)
            assertEquals("surf", name)
            assertEquals(14, order)
            assert(Name(
                    name = "Surfing",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in names)
        }
    }

    @Test
    fun getEncounterCondition() {
        PokeApi.getEncounterCondition(5).promise.get().apply {
            assertEquals(5, id)
            assertEquals("radio", name)
            assert(NamedApiResource(
                    name = "radio-hoenn",
                    url = PokeApi.rootUrl + "encounter-condition-value/15/"
            ) in values)
            assert(Name(
                    name = "Radio",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in names)
        }
    }

    @Test
    fun getEncounterConditionValue() {
        PokeApi.getEncounterConditionValue(5).promise.get().apply {
            assertEquals(5, id)
            assertEquals("time-night", name)
            condition.apply {
                assertEquals("time", name)
                assertEquals(PokeApi.rootUrl + "encounter-condition/2/", url)
            }
            assert(Name(
                    name = "At night",
                    language = NamedApiResource(
                            name = "en",
                            url = PokeApi.rootUrl + "language/9/"
                    )
            ) in names)
        }
    }
}
