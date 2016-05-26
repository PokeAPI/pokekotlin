package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class ApiResource(
        val category: String,
        val id: Int
)

data class Description(
        val description: String,
        val language: NamedApiResource
)

data class Effect(
        val effect: String,
        val language: NamedApiResource
)

data class Encounter(
        @Json(name = "min_level")
        val minLevel: Int,
        @Json(name = "max_level")
        val maxLevel: Int,
        @Json(name = "condition_values")
        val conditionValues: List<NamedApiResource>,
        val chance: Int,
        val method: NamedApiResource
)

data class FlavorText(
        @Json(name = "flavor_text")
        val flavorText: String,
        val language: NamedApiResource
)

data class GenerationGameIndex(
        @Json(name = "game_index")
        val gameIndex: Int,
        val generation: NamedApiResource
)

data class Name(
        val name: String,
        val language: NamedApiResource
)

data class NamedApiResource(
        val name: String,
        val category: String,
        val id: Int
)

data class VerboseEffect(
        val effect: String,
        @Json(name = "short_effect")
        val shortEffect: String,
        val language: NamedApiResource
)

data class VersionEncounterDetail(
        val version: NamedApiResource,
        @Json(name = "max_chance")
        val maxChance: Int,
        @Json(name = "encounter_details")
        val encounterDetails: List<Encounter>
)

data class VersionGameIndex(
        @Json(name = "game_index")
        val gameIndex: Int,
        val version: NamedApiResource
)

data class VersionGroupFlavorText(
        val text: String,
        val language: NamedApiResource,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource
)