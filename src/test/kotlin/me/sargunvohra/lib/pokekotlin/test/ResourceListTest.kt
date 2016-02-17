package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.*
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.*
import kotlin.test.*

class ResourceListTest {

    @Test
    fun named() {
        val list = PokeApi.getPokemonList().promise.get()
        assert(list) {
            elementAtShouldBe(2, NamedApiResource("venusaur", "http://pokeapi.co/api/v2/pokemon/3/"))
        }
    }

    @Test
    fun unnamed() {
        val list = PokeApi.getEvolutionChainList().promise.get()
        assert(list) {
            elementAtShouldBe(2, ApiResource("http://pokeapi.co/api/v2/evolution-chain/3/"))
        }
    }

    @Test
    fun dummy() {
        // temporary test to force fail
        fail()
    }
}