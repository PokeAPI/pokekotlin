package me.sargunvohra.lib.pokekotlin.model

data class ApiResource(
        val category: String,
        val id: Int
)

data class NamedApiResource(
        val name: String,
        val category: String,
        val id: Int
)