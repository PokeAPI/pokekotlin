package me.sargunvohra.lib.pokekotlin.json

data class EncounterMethod(
        val id: Int,
        val name: String,
        val order: Int,
        val names: List<Name>
)

data class EncounterCondition(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val values: List<NamedApiResource<EncounterConditionValue>>
)

data class EncounterConditionValue(
        val id: Int,
        val name: String,
        val condition: NamedApiResource<EncounterCondition>,
        val names: List<Name>
)