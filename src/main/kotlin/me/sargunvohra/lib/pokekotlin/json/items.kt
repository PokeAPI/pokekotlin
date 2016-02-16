package me.sargunvohra.lib.pokekotlin.json

data class JsonItem(
        val id: Int,
        val name: String,
        val cost: Int,
        val fling_power: Int,
        val fling_effect: JsonItemFlingEffect,
        val attributes: List<JsonNamedApiResource<JsonItemAttribute>>,
        val category: JsonItemCategory,
        val effect_entries: List<JsonVerboseEffect>,
        val flavor_text_entries: List<JsonVersionGroupFlavorText>,
        val game_indices: List<JsonGenerationGameIndex>,
        val names: List<JsonName>,
        val held_by_pokemon: List<JsonNamedApiResource<JsonPokemon>>,
        val baby_trigger_for: List<JsonApiResource<JsonEvolutionChain>>
)

data class JsonItemAttribute(
        val id: Int,
        val name: String,
        val items: List<JsonNamedApiResource<JsonItem>>,
        val names: List<JsonName>,
        val descriptions: List<JsonDescription>
)

data class JsonItemCategory(
        val id: Int,
        val name: String,
        val items: List<JsonNamedApiResource<JsonItem>>,
        val names: List<JsonName>,
        val pocket: JsonNamedApiResource<JsonItemPocket>
)

data class JsonItemFlingEffect(
        val id: Int,
        val name: String,
        val effect_entries: List<JsonEffect>,
        val items: List<JsonNamedApiResource<JsonItem>>
)

data class JsonItemPocket(
        val id: Int,
        val name: String,
        val categories: List<JsonItemCategory>,
        val names: List<JsonName>
)