package me.sargunvohra.lib.pokekotlin.json

data class EvolutionChain(
        val id: Int,
        val baby_trigger_item: NamedApiResource<Item>,
        val chain: ChainLink
)

data class ChainLink(
        val is_baby: Boolean,
        val species: NamedApiResource<PokemonSpecies>,
        val evolution_details: EvolutionDetail,
        val evolves_to: ChainLink
)

data class EvolutionDetail(
        val item: NamedApiResource<Item>?,
        val trigger: NamedApiResource<EvolutionTrigger>,
        val gender: NamedApiResource<Gender>?,
        val held_item: NamedApiResource<Item>?,
        val known_move: NamedApiResource<Move>?,
        val known_move_type: NamedApiResource<Move>?,
        val location: NamedApiResource<Location>?,
        val min_level: Int?,
        val min_happiness: Int?,
        val min_beauty: Int?,
        val min_affection: Int?,
        val needs_overworld_rain: Boolean,
        val part_species: NamedApiResource<PokemonSpecies>,
        val party_type: NamedApiResource<Type>,
        val relative_physical_stats: Int,
        val time_of_day: String,
        val trade_species: NamedApiResource<PokemonSpecies>,
        val turn_upside_down: Boolean
)

data class EvolutionTrigger(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>
)