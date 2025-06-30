package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

/**
 * An item is an object in the games which the player can pick up, keep in their bag, and use in
 * some manner. They have various uses, including healing, powering up, helping catch Pokémon, or to
 * access a new area. See: https://pokeapi.co/docs/v2#items
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param cost The price of this item in stores.
 * @param flingPower The power of the move Fling when used with this item.
 * @param flingEffect The effect of the move Fling when used with this item.
 * @param attributes A list of attributes this item has.
 * @param category The category of items this item falls into.
 * @param effectEntries The effect of this item listed in different languages.
 * @param flavorTextEntries The flavor text of this item listed in different languages.
 * @param gameIndices A list of game indices relevent to this item by generation.
 * @param names The name of this item listed in different languages.
 * @param heldByPokemon A list of Pokémon that might be found in the wild holding this item.
 * @param babyTriggerFor An evolution chain this item requires to produce a baby during mating.
 * @param sprites A set of sprites used to depict this item in the game.
 * @param machines A list of the machines related to this item.
 */
@Serializable
@JsOnlyExport
public data class Item(
  val id: Int,
  val name: String,
  val cost: Int,
  val flingPower: Int?,
  val flingEffect: NamedApiResource?,
  val attributes: List<NamedApiResource>,
  val category: NamedApiResource,
  val effectEntries: List<VerboseEffect>,
  val flavorTextEntries: List<VersionGroupFlavorText>,
  val gameIndices: List<GenerationGameIndex>,
  val names: List<Name>,
  val heldByPokemon: List<ItemHolderPokemon>,
  val babyTriggerFor: ApiResource?,
  val sprites: ItemSprites,
  val machines: List<MachineVersionDetail>,
)

/**
 * The sprites used to depict an item in the game. See: https://pokeapi.co/docs/v2#itemsprites
 *
 * @param default The default depiction of this item.
 */
@Serializable @JsOnlyExport public data class ItemSprites(val default: String?)

/**
 * A Pokémon that may be found in the wild holding an item. See:
 * https://pokeapi.co/docs/v2#itemholderpokemon
 *
 * @param pokemon The Pokémon that holds this item.
 * @param versionDetails The details for the version that this item is held in by the Pokémon.
 */
@Serializable
@JsOnlyExport
public data class ItemHolderPokemon(
  val pokemon: NamedApiResource,
  val versionDetails: List<ItemHolderPokemonVersionDetail>,
)

/**
 * The details of the version in which a Pokémon holds an item. See:
 * https://pokeapi.co/docs/v2#itemholderpokemonversiondetail
 *
 * @param rarity How often this Pokémon holds this item in the wild.
 * @param version The version in which the Pokémon holds the item.
 */
@Serializable
@JsOnlyExport
public data class ItemHolderPokemonVersionDetail(val rarity: Int, val version: NamedApiResource)

/**
 * Natural attributes of items, such as being countable or being usable in battle. See:
 * https://pokeapi.co/docs/v2#item-attributes
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param items A list of items that have this attribute.
 * @param names The name of this resource listed in different languages.
 * @param descriptions The description of this resource listed in different languages.
 */
@Serializable
@JsOnlyExport
public data class ItemAttribute(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val descriptions: List<Description>,
)

/**
 * Item categories determine where items will be placed in the players bag. See:
 * https://pokeapi.co/docs/v2#item-categories
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param items A list of items that are a part of this category.
 * @param names The name of this resource listed in different languages.
 * @param pocket The pocket items in this category are put into.
 */
@Serializable
@JsOnlyExport
public data class ItemCategory(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val pocket: NamedApiResource,
)

/**
 * The various effects of the move "Fling" when used with different items. See:
 * https://pokeapi.co/docs/v2#item-fling-effects
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param effectEntries The result of this fling effect listed in different languages.
 * @param items A list of items that have this fling effect.
 */
@Serializable
@JsOnlyExport
public data class ItemFlingEffect(
  val id: Int,
  val name: String,
  val effectEntries: List<Effect>,
  val items: List<NamedApiResource>,
)

/**
 * Pockets within the players bag used for storing items by category. See:
 * https://pokeapi.co/docs/v2#item-pockets
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param categories A list of item categories that are relevant to this item pocket.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsOnlyExport
public data class ItemPocket(
  val id: Int,
  val name: String,
  val categories: List<NamedApiResource>,
  val names: List<Name>,
)
