package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

@Serializable
@JsOnlyExport
public data class Language(
  val id: Int,
  val name: String,
  val official: Boolean,
  val iso639: String,
  val iso3166: String,
  val names: List<Name>,
)

@Serializable
@JsOnlyExport
public data class Description(val description: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class Effect(val effect: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class Encounter(
  val minLevel: Int,
  val maxLevel: Int,
  val conditionValues: List<NamedApiResource>,
  val chance: Int,
  val method: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class FlavorText(val flavorText: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class GenerationGameIndex(val gameIndex: Int, val generation: NamedApiResource)

@Serializable
@JsOnlyExport
public data class MachineVersionDetail(
  val machine: ApiResource,
  val versionGroup: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class Name(val name: String, val language: NamedApiResource)

@Serializable
@JsOnlyExport
public data class VerboseEffect(
  val effect: String,
  val shortEffect: String,
  val language: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class VersionEncounterDetail(
  val version: NamedApiResource,
  val maxChance: Int,
  val encounterDetails: List<Encounter>,
)

@Serializable
@JsOnlyExport
public data class VersionGameIndex(val gameIndex: Int, val version: NamedApiResource)

@Serializable
@JsOnlyExport
public data class VersionGroupFlavorText(
  val text: String,
  val language: NamedApiResource,
  val versionGroup: NamedApiResource,
)
