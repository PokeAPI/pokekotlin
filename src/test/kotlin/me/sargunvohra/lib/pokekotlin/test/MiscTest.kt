package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import org.testng.annotations.Test

class MiscTest {

    @Test
    // TODO remove this test after finishing pokemon tests
    fun issue9Test() {
        PokeApi.getPokemon(100).promise.get()
    }
}