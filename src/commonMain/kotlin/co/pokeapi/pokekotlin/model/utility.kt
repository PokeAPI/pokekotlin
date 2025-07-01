package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
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
@JsNonWasmExport
public data class Language(
  override val id: Int,
  override val name: String,
  val official: Boolean,
  val iso639: String,
  val iso3166: String,
  val names: List<Name>,
) : NamedModel

/**
 * The localized description for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#description
 *
 * @param description The localized description for an API resource in a specific language.
 * @param language The language this description is in.
 */
@Serializable
@JsNonWasmExport
public data class Description(val description: String, val language: Handle.Named<Language>)

/**
 * The localized effect text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#effect
 *
 * @param effect The localized effect text.
 * @param language The language this effect is in.
 */
@Serializable
@JsNonWasmExport
public data class Effect(val effect: String, val language: Handle.Named<Language>)

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
@JsNonWasmExport
public data class Encounter(
  val minLevel: Int,
  val maxLevel: Int,
  val conditionValues: List<Handle.Named<EncounterConditionValue>>,
  val chance: Int,
  val method: Handle.Named<EncounterMethod>,
)

/**
 * The localized flavor text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#flavortext
 *
 * @param flavorText The localized flavor text.
 * @param language The language this flavor text is in.
 */
@Serializable
@JsNonWasmExport
public data class FlavorText(val flavorText: String, val language: Handle.Named<Language>)

/**
 * Generation game index for a resource. See: https://pokeapi.co/docs/v2#generationgameindex
 *
 * @param gameIndex The internal id of an API resource within game data.
 * @param generation The generation relevant to this game index.
 */
@Serializable
@JsNonWasmExport
public data class GenerationGameIndex(val gameIndex: Int, val generation: Handle.Named<Generation>)

/**
 * Machine and version group details. See: https://pokeapi.co/docs/v2#machineversiondetail
 *
 * @param machine The machine that teaches a move from an item.
 * @param versionGroup The version group relevant to this machine.
 */
@Serializable
@JsNonWasmExport
public data class MachineVersionDetail(
  val machine: Handle.Unnamed<Machine>,
  val versionGroup: Handle.Named<VersionGroup>,
)

/**
 * The localized name for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#name
 *
 * @param name The localized name for an API resource in a specific language.
 * @param language The language this name is in.
 */
@Serializable
@JsNonWasmExport
public data class Name(val name: String, val language: Handle.Named<Language>)

/**
 * The verbose effect text for an API resource in a specific language. See:
 * https://pokeapi.co/docs/v2#verboseeffect
 *
 * @param effect The localized effect text.
 * @param shortEffect The localized effect text in brief.
 * @param language The language this effect is in.
 */
@Serializable
@JsNonWasmExport
public data class VerboseEffect(
  val effect: String,
  val shortEffect: String,
  val language: Handle.Named<Language>,
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
@JsNonWasmExport
public data class VersionEncounterDetail(
  val version: Handle.Named<Version>,
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
@JsNonWasmExport
public data class VersionGameIndex(val gameIndex: Int, val version: Handle.Named<Version>)

/**
 * The localized flavor text for a version group. See:
 * https://pokeapi.co/docs/v2#versiongroupflavortext
 *
 * @param text The localized flavor text for a version group.
 * @param language The language this flavor text is in.
 * @param versionGroup The version group which uses this flavor text.
 */
@Serializable
@JsNonWasmExport
public data class VersionGroupFlavorText(
  val text: String,
  val language: Handle.Named<Language>,
  val versionGroup: Handle.Named<VersionGroup>,
)
