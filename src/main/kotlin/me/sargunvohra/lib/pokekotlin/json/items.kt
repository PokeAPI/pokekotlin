package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Item(
        val id: Int,
        val name: String,
        val cost: Int,
        @Json(name = "fling_power")
        val flingPower: Int,
        @Json(name = "fling_effect")
        val flingEffect: NamedApiResource<ItemFlingEffect>?,
        val attributes: List<NamedApiResource<ItemAttribute>>,
        val category: NamedApiResource<ItemCategory>,
        @Json(name = "effect_entries")
        val effectEntries: List<VerboseEffect>,
        @Json(name = "flavor_text_entries")
        val flavorTextEntries: List<VersionGroupFlavorText>,
        @Json(name = "game_indices")
        val gameIndices: List<GenerationGameIndex>,
        val names: List<Name>,
        @Json(name = "held_by_pokemon")
        val heldByPokemon: List<ItemHolderPokemon>,
        @Json(name = "baby_trigger_for")
        val babyTriggerFor: ApiResource<EvolutionChain>?
)

data class ItemHolderPokemon(
        val pokemon: NamedApiResource<Pokemon>,
        @Json(name = "version_details")
        val versionDetails: List<ItemHolderPokemonVersionDetail>
)

data class ItemHolderPokemonVersionDetail(
        val rarity: Int,
        val version: NamedApiResource<Version>
)

data class ItemAttribute(
        val id: Int,
        val name: String,
        val items: List<NamedApiResource<Item>>,
        val names: List<Name>,
        val descriptions: List<Description>
)

data class ItemCategory(
        val id: Int,
        val name: String,
        val items: List<NamedApiResource<Item>>,
        val names: List<Name>,
        val pocket: NamedApiResource<ItemPocket>
)

data class ItemFlingEffect(
        val id: Int,
        val name: String,
        @Json(name = "effect_entries")
        val effectEntries: List<Effect>,
        val items: List<NamedApiResource<Item>>
)

data class ItemPocket(
        val id: Int,
        val name: String,
        val categories: List<NamedApiResource<ItemCategory>>,
        val names: List<Name>
)