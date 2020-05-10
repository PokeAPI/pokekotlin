package me.sargunvohra.lib.pokekotlin.model

data class Machine(
    val id: Int,
    val item: NamedApiResource,
    val move: NamedApiResource,
    val versionGroup: NamedApiResource
)
