package dev.sargunv.pokekotlin.test

import com.google.gson.Gson
import dev.sargunv.pokekotlin.client.PokeApi
import kotlin.collections.HashMap
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.test.Test
import kotlin.test.assertEquals
import okhttp3.OkHttpClient
import okhttp3.Request

class EndpointTest {

  private val httpClient = OkHttpClient()

  private val gson = Gson()

  @Test
  fun checkAllEndpoints() {
    // call the mock API to get a list of resource endpoints

    val json =
      httpClient
        .newCall(Request.Builder().get().url(MockServer.url).build())
        .execute()
        .body()!!
        .string()

    // parse the expected resources using the list
    val expectedSingleResources =
      gson
        .fromJson<HashMap<String, String>>(json, HashMap::class.java)
        .keys
        .map { endpointName ->
          endpointName.split('-').joinToString(separator = "") {
            it.replaceFirstChar(Char::uppercase)
          }
        }
        .toSet()

    val expectedListResources =
      expectedSingleResources.map { it + "List" }.toSet() + "PokemonEncounterList"

    // use reflection to determine the actual resources in the client

    val actualResources =
      PokeApi::class
        .declaredMemberFunctions
        .map { it.name.removePrefix("get") }
        .groupBy { it.endsWith("List") }

    val actualSingleResources = actualResources.getValue(false).toSet()

    val actualListResources = actualResources.getValue(true).toSet()

    // make sure the resources in the client match the ones in the API

    assertEquals(expectedSingleResources.sorted(), actualSingleResources.sorted())
    assertEquals(expectedListResources.sorted(), actualListResources.sorted())
  }
}
