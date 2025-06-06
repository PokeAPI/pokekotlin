package dev.sargunv.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
data class Language(
  val id: Int,
  val name: String,
  val official: Boolean,
  val iso639: String,
  val iso3166: String,
  val names: List<Name>,
)

@Serializable data class Description(val description: String, val language: NamedApiResource)

@Serializable data class Effect(val effect: String, val language: NamedApiResource)

@Serializable
data class Encounter(
  val minLevel: Int,
  val maxLevel: Int,
  val conditionValues: List<NamedApiResource>,
  val chance: Int,
  val method: NamedApiResource,
)

@Serializable data class FlavorText(val flavorText: String, val language: NamedApiResource)

@Serializable data class GenerationGameIndex(val gameIndex: Int, val generation: NamedApiResource)

@Serializable
data class MachineVersionDetail(val machine: ApiResource, val versionGroup: NamedApiResource)

@Serializable data class Name(val name: String, val language: NamedApiResource)

@Serializable
data class VerboseEffect(
  val effect: String,
  val shortEffect: String,
  val language: NamedApiResource,
)

@Serializable
data class VersionEncounterDetail(
  val version: NamedApiResource,
  val maxChance: Int,
  val encounterDetails: List<Encounter>,
)

@Serializable data class VersionGameIndex(val gameIndex: Int, val version: NamedApiResource)

@Serializable
data class VersionGroupFlavorText(
  val text: String,
  val language: NamedApiResource,
  val versionGroup: NamedApiResource,
)
