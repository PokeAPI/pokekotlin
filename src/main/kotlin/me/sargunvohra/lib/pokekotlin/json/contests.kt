package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class ContestType(
        val id: Int,
        val name: String,
        @Json(name = "berry_flavor")
        val berryFlavor: NamedApiResource,
        val names: List<ContestName>
)

data class ContestName(
        val name: String,
        val color: String,
        val language: NamedApiResource
)

data class ContestEffect(
        val id: Int,
        val appeal: Int,
        val jam: Int,
        @Json(name = "effect_entries")
        val effectEntries: List<Effect>,
        @Json(name = "flavor_text_entries")
        val flavorTextEntries: List<FlavorText>
)

data class SuperContestEffect(
        val id: Int,
        val appeal: Int,
        @Json(name = "flavor_text_entries")
        val flavorTextEntries: List<FlavorText>,
        val moves: List<NamedApiResource>
)