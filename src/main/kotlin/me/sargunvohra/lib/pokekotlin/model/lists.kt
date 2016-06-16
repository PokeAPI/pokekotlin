package me.sargunvohra.lib.pokekotlin.model

data class ApiResourceList(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<ApiResource>
)

data class NamedApiResourceList(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<NamedApiResource>
)