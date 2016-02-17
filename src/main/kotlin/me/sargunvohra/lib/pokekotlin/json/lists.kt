package me.sargunvohra.lib.pokekotlin.json

// TODO use these when PokeApi fixes issue #94

@Suppress("unused")
data class ApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<ApiResource<T>>
)

@Suppress("unused")
data class NamedApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<NamedApiResourceList<T>>
)