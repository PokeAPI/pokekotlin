package co.pokeapi.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
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

@Serializable public data class ItemSprites(val default: String?)

@Serializable
public data class ItemHolderPokemon(
  val pokemon: NamedApiResource,
  val versionDetails: List<ItemHolderPokemonVersionDetail>,
)

@Serializable
public data class ItemHolderPokemonVersionDetail(val rarity: Int, val version: NamedApiResource)

@Serializable
public data class ItemAttribute(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val descriptions: List<Description>,
)

@Serializable
public data class ItemCategory(
  val id: Int,
  val name: String,
  val items: List<NamedApiResource>,
  val names: List<Name>,
  val pocket: NamedApiResource,
)

@Serializable
public data class ItemFlingEffect(
  val id: Int,
  val name: String,
  val effectEntries: List<Effect>,
  val items: List<NamedApiResource>,
)

@Serializable
public data class ItemPocket(
  val id: Int,
  val name: String,
  val categories: List<NamedApiResource>,
  val names: List<Name>,
)
