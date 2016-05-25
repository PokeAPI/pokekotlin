package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import org.testng.annotations.Test

class PokemonTest {

    @Test
    fun getAbility() {
        PokeApi.getAbility(1).promise.get().apply {

        }
    }

    @Test
    fun getCharacteristic() {
        PokeApi.getCharacteristic(1).promise.get().apply {

        }
    }

    @Test
    fun getEggGroup() {
        PokeApi.getEggGroup(1).promise.get().apply {

        }
    }

    @Test
    fun getGender() {
        PokeApi.getGender(1).promise.get().apply {

        }
    }

    @Test
    fun getGrowthRate() {
        PokeApi.getGrowthRate(1).promise.get().apply {

        }
    }

    @Test
    fun getNature() {
        PokeApi.getNature(1).promise.get().apply {

        }
    }

    @Test
    fun getPokeathlonStat() {
        PokeApi.getPokeathlonStat(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemon() {
        PokeApi.getPokemon(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemonColor() {
        PokeApi.getPokemonColor(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemonForm() {
        PokeApi.getPokemonForm(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemonHabitat() {
        PokeApi.getPokemonHabitat(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemonShape() {
        PokeApi.getPokemonShape(1).promise.get().apply {

        }
    }

    @Test
    fun getPokemonSpecies() {
        PokeApi.getPokemonSpecies(1).promise.get().apply {

        }
    }

    @Test
    fun getStat() {
        PokeApi.getStat(1).promise.get().apply {

        }
    }

    @Test
    fun getType() {
        PokeApi.getType(1).promise.get().apply {

        }
    }
}