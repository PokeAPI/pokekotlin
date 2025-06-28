package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.internal.PokeApiJson
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class EndpointTest {

  private val httpClient = HttpClient()

  @Test
  fun checkAllEndpoints() = runTest {
    // call the mock API to get a list of resource endpoints
    val json = httpClient.get("http://localhost:8080/api/v2/").bodyAsText()

    // parse the expected resources using the list
    val expectedSingleResources =
      PokeApiJson.decodeFromString<HashMap<String, String>>(json)
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
        .filter { it.isSuspend }
        .map { it.name.removePrefix("get") }
        .groupBy { it.endsWith("List") }

    val actualSingleResources = actualResources.getValue(false).toSet()
    val actualListResources = actualResources.getValue(true).toSet()

    // make sure the resources in the client match the ones in the API
    assertEquals(expectedSingleResources.sorted(), actualSingleResources.sorted())
    assertEquals(expectedListResources.sorted(), actualListResources.sorted())
  }
}
