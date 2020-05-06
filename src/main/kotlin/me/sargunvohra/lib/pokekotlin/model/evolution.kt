package me.sargunvohra.lib.pokekotlin.model

data class EvolutionChain(
    val id: Int,
    val babyTriggerItem: NamedApiResource?,
    val chain: ChainLink
)

data class ChainLink(
    val isBaby: Boolean,
    val species: NamedApiResource,
    val evolutionDetails: List<EvolutionDetail>,
    val evolvesTo: List<ChainLink>
)

data class EvolutionDetail(
    val trigger: NamedApiResource,
    val item: NamedApiResource? = null,
    val gender: Int? = null,
    val heldItem: NamedApiResource? = null,
    val knownMove: NamedApiResource? = null,
    val knownMoveType: NamedApiResource? = null,
    val location: NamedApiResource? = null,
    val minLevel: Int? = null,
    val minHappiness: Int? = null,
    val minBeauty: Int? = null,
    val minAffection: Int? = null,
    val partySpecies: NamedApiResource? = null,
    val partyType: NamedApiResource? = null,
    val relativePhysicalStats: Int? = null,
    val timeOfDay: String = "",
    val tradeSpecies: NamedApiResource? = null,
    val needsOverworldRain: Boolean = false,
    val turnUpsideDown: Boolean = false
)

data class EvolutionTrigger(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val pokemonSpecies: List<NamedApiResource>
)
