package me.sargunvohra.lib.pokekotlin.json

data class ApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<ApiResource<T>>
)

data class NamedApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<NamedApiResourceList<T>>
)