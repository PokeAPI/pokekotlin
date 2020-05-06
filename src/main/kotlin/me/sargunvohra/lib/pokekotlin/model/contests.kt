package me.sargunvohra.lib.pokekotlin.model

data class ContestType(
    val id: Int,
    val name: String,
    val berryFlavor: NamedApiResource,
    val names: List<ContestName>
)

data class ContestName(
    val name: String,
    val color: String,
    val language: NamedApiResource
)

data class ContestEffect(
    val id: Int,
    val appeal: Int,
    val jam: Int,
    val effectEntries: List<Effect>,
    val flavorTextEntries: List<FlavorText>
)

data class SuperContestEffect(
    val id: Int,
    val appeal: Int,
    val flavorTextEntries: List<FlavorText>,
    val moves: List<NamedApiResource>
)
