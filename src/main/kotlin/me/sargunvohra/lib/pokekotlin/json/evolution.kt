package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class EvolutionChain(
        val id: Int,
        @Json(name = "baby_trigger_item")
        val babyTriggerItem: NamedApiResource<Item>?,
        val chain: ChainLink
)

data class ChainLink(
        @Json(name = "is_baby")
        val isBaby: Boolean,
        val species: NamedApiResource<PokemonSpecies>,
        @Json(name = "evolution_details")
        val evolutionDetails: EvolutionDetail?,
        @Json(name = "evolves_to")
        val evolvesTo: List<ChainLink>
)

data class EvolutionDetail(
        val item: NamedApiResource<Item>?,
        val trigger: NamedApiResource<EvolutionTrigger>,
        val gender: NamedApiResource<Gender>?,
        @Json(name = "held_item")
        val heldItem: NamedApiResource<Item>?,
        @Json(name = "known_move")
        val knownMove: NamedApiResource<Move>?,
        @Json(name = "known_move_type")
        val knownMoveType: NamedApiResource<Move>?,
        val location: NamedApiResource<Location>?,
        @Json(name = "min_level")
        val minLevel: Int?,
        @Json(name = "min_happiness")
        val minHappiness: Int?,
        @Json(name = "min_beauty")
        val minBeauty: Int?,
        @Json(name = "min_affection")
        val minAffection: Int?,
        @Json(name = "needs_overworld_rain")
        val needsOverworldRain: Boolean,
        @Json(name = "party_species")
        val partySpecies: NamedApiResource<PokemonSpecies>?,
        @Json(name = "party_type")
        val partyType: NamedApiResource<Type>?,
        @Json(name = "relative_physical_stats")
        val relativePhysicalStats: Int?,
        @Json(name = "time_of_day")
        val timeOfDay: String?,
        @Json(name = "trade_species")
        val tradeSpecies: NamedApiResource<PokemonSpecies>?,
        @Json(name = "turn_upside_down")
        val turnUpsideDown: Boolean
)

data class EvolutionTrigger(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)