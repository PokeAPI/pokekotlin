package me.sargunvohra.lib.pokekotlin.model

data class Language(
        val id: Int,
        val name: String,
        val official: Boolean,
        val iso639: String,
        val iso3166: String,
        val names: List<Name>
)