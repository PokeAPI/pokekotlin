package me.sargunvohra.lib.pokekotlin.json

data class JsonContestType(
        val id: Int,
        val name: String,
        val berry_flavor: JsonNamedApiResource<JsonBerryFlavor>,
        val names: List<JsonName>
)

data class JsonContestEffect(
        val id: Int,
        val appeal: String,
        val jam: Int,
        val effect_entries: List<JsonEffect>,
        val flavor_text_entries: List<JsonFlavorText>
)

data class JsonSuperContestEffect(
        val id: Int,
        val appeal: String,
        val flavor_text_entries: List<JsonFlavorText>,
        val moves: List<JsonNamedApiResource<JsonMove>>
)