package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

internal fun urlToId(url: String): Int {
    return "\\/-?[0-9]*\\/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

@Suppress("unused")
data class ApiResource<T>(
        val url: String
) {
    val id: Int get() = urlToId(url)
}

data class Description(
        val description: String,
        val language: NamedApiResource<Language>
)

data class Effect(
        val effect: String,
        val language: NamedApiResource<Language>
)

data class Encounter(
        @Json(name = "min_level")
        val minLevel: Int,
        @Json(name = "max_level")
        val maxLevel: Int,
        @Json(name = "condition_values")
        val conditionValues: List<NamedApiResource<EncounterConditionValue>>,
        val integer: Int,
        val method: NamedApiResource<EncounterMethod>
)

data class FlavorText(
        @Json(name = "flavor_text")
        val flavorText: String,
        val language: NamedApiResource<Language>
)

data class GenerationGameIndex(
        @Json(name = "game_index")
        val gameIndex: Int,
        val generation: NamedApiResource<Generation>
)

data class Name(
        val name: String,
        val language: NamedApiResource<Language>
)

@Suppress("unused")
data class NamedApiResource<T>(
        val name: String,
        val url: String
) {
    val id: Int get() = urlToId(url)
}

data class VerboseEffect(
        val effect: String,
        @Json(name = "short_effect")
        val shortEffect: String,
        val language: NamedApiResource<Language>
)

data class VersionEncounterDetail(
        val version: NamedApiResource<Version>,
        @Json(name = "max_chance")
        val maxChance: Int,
        @Json(name = "encounter_details")
        val encounterDetails: List<Encounter>
)

data class VersionGameIndex(
        @Json(name = "game_index")
        val gameIndex: Int,
        val version: NamedApiResource<Version>
)

data class VersionGroupFlavorText(
        val text: String,
        val language: NamedApiResource<Language>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>
)