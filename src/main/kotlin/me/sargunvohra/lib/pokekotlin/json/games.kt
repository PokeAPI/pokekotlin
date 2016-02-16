package me.sargunvohra.lib.pokekotlin.json

data class Generation(
        val id: Int,
        val name: String,
        val abilities: List<Ability>,
        val names: List<Name>,
        val main_region: NamedApiResource<Region>,
        val moves: List<NamedApiResource<Move>>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>,
        val types: List<NamedApiResource<Type>>,
        val version_groups: List<NamedApiResource<VersionGroup>>
)

data class Pokedex(
        val id: Int,
        val name: String,
        val is_main_series: Boolean,
        val descriptions: List<Description>,
        val names: List<Name>,
        val pokemon_entries: List<PokemonEntry>,
        val region: NamedApiResource<Region>,
        val version_groups: List<NamedApiResource<VersionGroup>>
)

data class PokemonEntry(
        val entry_number: Int,
        val pokemon_species: NamedApiResource<PokemonSpecies>
)

data class Version(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val version_group: NamedApiResource<VersionGroup>
)

data class VersionGroup(
        val id: Int,
        val name: String,
        val order: Int,
        val generation: NamedApiResource<Generation>,
        val move_learn_methods: List<NamedApiResource<MoveLearnMethod>>,
        val names: List<Name>,
        val pokedexes: List<NamedApiResource<Pokedex>>,
        val regions: List<NamedApiResource<Region>>,
        val versions: List<NamedApiResource<Version>>
)