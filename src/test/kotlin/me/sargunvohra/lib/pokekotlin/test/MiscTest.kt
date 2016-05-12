package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import org.testng.annotations.Test

class MiscTest {

    @Test
    fun issue9Test() {
        PokeApi.getPokemon(100).promise.get()
    }
}