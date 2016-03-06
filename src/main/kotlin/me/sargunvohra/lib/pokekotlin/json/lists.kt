package me.sargunvohra.lib.pokekotlin.json

data class ApiResourceList<T>(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<ApiResource<T>>
)

data class NamedApiResourceList<T>(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<NamedApiResource<T>>
)