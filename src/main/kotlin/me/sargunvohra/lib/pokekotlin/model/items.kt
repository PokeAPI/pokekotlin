package me.sargunvohra.lib.pokekotlin.model

data class Item(
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
    val machines: List<MachineVersionDetail>
)

data class ItemSprites(
    val default: String?
)

data class ItemHolderPokemon(
    val pokemon: NamedApiResource,
    val versionDetails: List<ItemHolderPokemonVersionDetail>
)

data class ItemHolderPokemonVersionDetail(
    val rarity: Int,
    val version: NamedApiResource
)

data class ItemAttribute(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val descriptions: List<Description>
)

data class ItemCategory(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val pocket: NamedApiResource
)

data class ItemFlingEffect(
    val id: Int,
    val name: String,
    val effectEntries: List<Effect>,
    val items: List<NamedApiResource>
)

data class ItemPocket(
    val id: Int,
    val name: String,
    val categories: List<NamedApiResource>,
    val names: List<Name>
)
