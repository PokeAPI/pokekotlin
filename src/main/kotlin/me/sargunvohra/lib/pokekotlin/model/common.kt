package me.sargunvohra.lib.pokekotlin.model

data class Description(
        val description: String,
        val language: NamedApiResource
)

data class Effect(
        val effect: String,
        val language: NamedApiResource
)

data class Encounter(
        val minLevel: Int,
        val maxLevel: Int,
        val conditionValues: List<NamedApiResource>,
        val chance: Int,
        val method: NamedApiResource
)

data class FlavorText(
        val flavorText: String,
        val language: NamedApiResource
)

data class GenerationGameIndex(
        val gameIndex: Int,
        val generation: NamedApiResource
)

data class Name(
        val name: String,
        val language: NamedApiResource
)

data class VerboseEffect(
        val effect: String,
        val shortEffect: String,
        val language: NamedApiResource
)

data class VersionEncounterDetail(
        val version: NamedApiResource,
        val maxChance: Int,
        val encounterDetails: List<Encounter>
)

data class VersionGameIndex(
        val gameIndex: Int,
        val version: NamedApiResource
)

data class VersionGroupFlavorText(
        val text: String,
        val language: NamedApiResource,
        val versionGroup: NamedApiResource
)