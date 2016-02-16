package me.sargunvohra.lib.pokekotlin.json

data class JsonApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<JsonApiResource<T>>
)

data class JsonNamedApiResourceList<T>(
        val count: Int,
        val next: String,
        val previous: Boolean,
        val results: List<JsonNamedApiResourceList<T>>
)