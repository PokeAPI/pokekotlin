package me.sargunvohra.lib.pokekotlin.test

import com.google.gson.Gson
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.test.util.MockServer
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Test
import java.util.*
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.test.assertEquals

class EndpointTest {

    private val httpClient = OkHttpClient()

    private val objectMapper = Gson()

    @Test
    fun checkAllEndpoints() {
        // call the mock API to get a list of resource endpoints

        val json = httpClient
                .newCall(Request.Builder()
                        .get()
                        .url(MockServer.url)
                        .build())
                .execute()
                .body()!!
                .string()

        // parse the expected resources using the list

        val expectedSingleResources = with(objectMapper) {
            @Suppress("UNCHECKED_CAST")
            (fromJson(json, HashMap::class.java) as HashMap<String, String>)
                    .keys
                    .map { endpoint ->
                        endpoint.split('-')
                                .joinToString(separator = "") { it.capitalize() }
                    }
                    .toSet()
        }

        val expectedListResources = expectedSingleResources
                .map { it + "List" }
                .toSet() + "PokemonEncounterList"

        // use reflection to determine the actual resources in the client

        val actualResources = PokeApi::class
                .declaredMemberFunctions
                .map { it.name.removePrefix("get") }
                .groupBy { it.endsWith("List") }

        val actualSingleResources = actualResources.getValue(false).toSet()

        val actualListResources = actualResources.getValue(true).toSet()

        // make sure the resources in the client match the ones in the API

        assertEquals(expectedSingleResources, actualSingleResources)
        assertEquals(expectedListResources, actualListResources)
    }
}