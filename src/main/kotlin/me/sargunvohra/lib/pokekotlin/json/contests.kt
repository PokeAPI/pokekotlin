package me.sargunvohra.lib.pokekotlin.json

data class ContestType(
        val id: Int,
        val name: String,
        val berry_flavor: NamedApiResource<BerryFlavor>,
        val names: List<Name>
)

data class ContestEffect(
        val id: Int,
        val appeal: String,
        val jam: Int,
        val effect_entries: List<Effect>,
        val flavor_text_entries: List<FlavorText>
)

data class SuperContestEffect(
        val id: Int,
        val appeal: String,
        val flavor_text_entries: List<FlavorText>,
        val moves: List<NamedApiResource<Move>>
)