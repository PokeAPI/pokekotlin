package me.sargunvohra.lib.pokekotlin.json

internal fun urlToId(url: String): Int {
    return "\\/-?[0-9]*\\/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

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
        val min_level: Int,
        val max_level: Int,
        val condition_values: List<NamedApiResource<EncounterConditionValue>>,
        val integer: Int,
        val method: NamedApiResource<EncounterMethod>
)

data class FlavorText(
        val flavor_text: String,
        val language: NamedApiResource<Language>
)

data class GenerationGameIndex(
        val game_index: Int,
        val generation: NamedApiResource<Generation>
)

data class Name(
        val name: String,
        val language: NamedApiResource<Language>
)

data class NamedApiResource<T>(
        val name: String,
        val url: String
) {
    val id: Int get() = urlToId(url)
}

data class VerboseEffect(
        val effect: String,
        val short_effect: String,
        val language: NamedApiResource<Language>
)

data class VersionEncounterDetail(
        val version: NamedApiResource<Version>,
        val max_chance: Int,
        val encounter_details: List<Encounter>
)

data class VersionGameIndex(
        val game_index: Int,
        val version: NamedApiResource<Version>
)

data class VersionGroupFlavorText(
        val text: String,
        val language: NamedApiResource<Language>,
        val version_group: NamedApiResource<VersionGroup>
)