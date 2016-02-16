package me.sargunvohra.lib.pokekotlin

import me.sargunvohra.lib.pokekotlin.api.*

fun main(vararg args: String) {

    val p = PokeApi.getPokemonList().promise

    p success {
        println("Success: $it")
    } fail {
        println("Failure: $it")
    }
}