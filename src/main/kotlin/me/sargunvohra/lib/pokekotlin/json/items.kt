package me.sargunvohra.lib.pokekotlin.json

data class Item(
        val id: Int,
        val name: String,
        val cost: Int,
        val fling_power: Int,
        val fling_effect: ItemFlingEffect,
        val attributes: List<NamedApiResource<ItemAttribute>>,
        val category: ItemCategory,
        val effect_entries: List<VerboseEffect>,
        val flavor_text_entries: List<VersionGroupFlavorText>,
        val game_indices: List<GenerationGameIndex>,
        val names: List<Name>,
        val held_by_pokemon: List<NamedApiResource<Pokemon>>,
        val baby_trigger_for: List<ApiResource<EvolutionChain>>
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
        val effect_entries: List<Effect>,
        val items: List<NamedApiResource<Item>>
)

data class ItemPocket(
        val id: Int,
        val name: String,
        val categories: List<ItemCategory>,
        val names: List<Name>
)