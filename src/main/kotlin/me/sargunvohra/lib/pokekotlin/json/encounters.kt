package me.sargunvohra.lib.pokekotlin.json

data class JsonEncounterMethod(
        val id: Int,
        val name: String,
        val order: Int,
        val names: List<JsonName>
)

data class JsonEncounterCondition(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val values: List<JsonNamedApiResource<JsonEncounterConditionValue>>
)

data class JsonEncounterConditionValue(
        val id: Int,
        val name: String,
        val condition: JsonNamedApiResource<JsonEncounterCondition>,
        val names: List<JsonName>
)