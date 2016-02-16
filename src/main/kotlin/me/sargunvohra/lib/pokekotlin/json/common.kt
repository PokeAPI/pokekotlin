package me.sargunvohra.lib.pokekotlin.json

data class JsonApiResource<T>(
        val url: String
)

data class JsonDescription(
        val description: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonEffect(
        val effect: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonEncounter(
        val min_level: Int,
        val max_level: Int,
        val condition_values: List<JsonNamedApiResource<JsonEncounterConditionValue>>,
        val integer: Int,
        val method: JsonNamedApiResource<JsonEncounterMethod>
)

data class JsonFlavorText(
        val flavor_text: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonGenerationGameIndex(
        val game_index: Int,
        val generation: JsonNamedApiResource<JsonGeneration>
)

data class JsonName(
        val name: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonNamedApiResource<T>(
        val name: String,
        val url: String
)

data class JsonVerboseEffect(
        val effect: String,
        val short_effect: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonVersionEncounterDetail(
        val version: JsonNamedApiResource<JsonVersion>,
        val max_chance: Int,
        val encounter_details: List<JsonEncounter>
)

data class JsonVersionGameIndex(
        val game_index: Int,
        val version: JsonNamedApiResource<JsonVersion>
)

data class JsonVersionGroupFlavorText(
        val text: String,
        val language: JsonNamedApiResource<JsonLanguage>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)