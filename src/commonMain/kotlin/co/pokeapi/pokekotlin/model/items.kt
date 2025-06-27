package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

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

@Serializable @JsOnlyExport public data class ItemSprites(val default: String?)

@Serializable
@JsOnlyExport
public data class ItemHolderPokemon(
  val pokemon: NamedApiResource,
  val versionDetails: List<ItemHolderPokemonVersionDetail>,
)

@Serializable
@JsOnlyExport
public data class ItemHolderPokemonVersionDetail(val rarity: Int, val version: NamedApiResource)

@Serializable
@JsOnlyExport
public data class ItemAttribute(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val descriptions: List<Description>,
)

@Serializable
@JsOnlyExport
public data class ItemCategory(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val pocket: NamedApiResource,
)

@Serializable
@JsOnlyExport
public data class ItemFlingEffect(
  val id: Int,
  val name: String,
  val effectEntries: List<Effect>,
  val items: List<NamedApiResource>,
)

@Serializable
@JsOnlyExport
public data class ItemPocket(
  val id: Int,
  val name: String,
  val categories: List<NamedApiResource>,
  val names: List<Name>,
)
