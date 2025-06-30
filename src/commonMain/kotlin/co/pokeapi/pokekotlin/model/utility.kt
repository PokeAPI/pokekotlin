package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

/**
 * Languages are resources for translating API resource information into different languages. They
 * have an identifier and several codes for different language standards. See:
 * https://pokeapi.co/docs/v2#languages
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param official Whether or not the language is official.
 * @param iso639 The two-letter code of the language as per ISO 639.
 * @param iso3166 The two-letter code of the country as per ISO 3166.
 * @param names The localized names for this language resource.
 */
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

/**
 * The localized description for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#description
 *
 * @param description The localized description for an API resource in a specific language.
 * @param language The language this description is in.
 */
@Serializable
@JsOnlyExport
public data class Description(val description: String, val language: NamedApiResource)

/**
 * The localized effect text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#effect
 *
 * @param effect The localized effect text.
 * @param language The language this effect is in.
 */
@Serializable
@JsOnlyExport
public data class Effect(val effect: String, val language: NamedApiResource)

/**
 * Encounter details for a Pokémon in a specific location area. See:
 * https://pokeapi.co/docs/v2#encounter
 *
 * @param minLevel The lowest level the Pokémon could be encountered at.
 * @param maxLevel The highest level the Pokémon could be encountered at.
 * @param conditionValues A list of condition values affecting this encounter.
 * @param chance The chance of the encounter.
 * @param method The method by which the encounter happens.
 */
@Serializable
@JsOnlyExport
public data class Encounter(
  val minLevel: Int,
  val maxLevel: Int,
  val conditionValues: List<NamedApiResource>,
  val chance: Int,
  val method: NamedApiResource,
)

/**
 * The localized flavor text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#flavortext
 *
 * @param flavorText The localized flavor text.
 * @param language The language this flavor text is in.
 */
@Serializable
@JsOnlyExport
public data class FlavorText(val flavorText: String, val language: NamedApiResource)

/**
 * Generation game index for a resource. See: https://pokeapi.co/docs/v2#generationgameindex
 *
 * @param gameIndex The internal id of an API resource within game data.
 * @param generation The generation relevant to this game index.
 */
@Serializable
@JsOnlyExport
public data class GenerationGameIndex(val gameIndex: Int, val generation: NamedApiResource)

/**
 * Machine and version group details. See: https://pokeapi.co/docs/v2#machineversiondetail
 *
 * @param machine The machine that teaches a move from an item.
 * @param versionGroup The version group relevant to this machine.
 */
@Serializable
@JsOnlyExport
public data class MachineVersionDetail(
  val machine: ApiResource,
  val versionGroup: NamedApiResource,
)

/**
 * The localized name for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#name
 *
 * @param name The localized name for an API resource in a specific language.
 * @param language The language this name is in.
 */
@Serializable
@JsOnlyExport
public data class Name(val name: String, val language: NamedApiResource)

/**
 * The verbose effect text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#verboseeffect
 *
 * @param effect The localized effect text.
 * @param shortEffect The localized effect text in brief.
 * @param language The language this effect is in.
 */
@Serializable
@JsOnlyExport
public data class VerboseEffect(
  val effect: String,
  val shortEffect: String,
  val language: NamedApiResource,
)

/**
 * Version encounter details for a Pokémon in a specific version. See:
 * https://pokeapi.co/docs/v2#versionencounterdetail
 *
 * @param version The version relevant to this encounter detail.
 * @param maxChance The total chance of all encounter details.
 * @param encounterDetails A list of encounters and their specifics.
 */
@Serializable
@JsOnlyExport
public data class VersionEncounterDetail(
  val version: NamedApiResource,
  val maxChance: Int,
  val encounterDetails: List<Encounter>,
)

/**
 * Game index for a resource in a specific version. See: https://pokeapi.co/docs/v2#versiongameindex
 *
 * @param gameIndex The internal id of an API resource within game data.
 * @param version The version relevant to this game index.
 */
@Serializable
@JsOnlyExport
public data class VersionGameIndex(val gameIndex: Int, val version: NamedApiResource)

/**
 * The localized flavor text for a version group. See:
 * https://pokeapi.co/docs/v2#versiongroupflavortext
 *
 * @param text The localized flavor text for a version group.
 * @param language The language this flavor text is in.
 * @param versionGroup The version group which uses this flavor text.
 */
@Serializable
@JsOnlyExport
public data class VersionGroupFlavorText(
  val text: String,
  val language: NamedApiResource,
  val versionGroup: NamedApiResource,
)
