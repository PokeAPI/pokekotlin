package me.sargunvohra.lib.pokekotlin.json

data class Ability(
        val id: Int,
        val name: String,
        val is_main_series: Boolean,
        val generation: NamedApiResource<Generation>,
        val names: List<Name>,
        val effect_entries: List<VerboseEffect>,
        val effect_changes: List<AbilityEffectChange>,
        val flavor_text_entries: List<VersionGroupFlavorText>,
        val pokemon: List<AbilityPokemon>
)

data class AbilityEffectChange(
        val effect_entries: List<Effect>,
        val version_group: NamedApiResource<VersionGroup>
)

data class AbilityFlavorText(
        val flavor_text: String,
        val language: NamedApiResource<Language>,
        val version_group: NamedApiResource<VersionGroup>
)

data class AbilityPokemon(
        val is_hidden: Boolean,
        val slot: Int,
        val pokemon: NamedApiResource<Pokemon>
)

data class Characteristic(
        val id: Int,
        val gene_modulo: Int,
        val possible_values: List<Int>,
        val descriptions: List<Description>
)

data class EggGroup(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val pokemon_species: NamedApiResource<PokemonSpecies>
)

data class Gender(
        val id: Int,
        val name: String,
        val pokemon_species_details: List<PokemonSpeciesGender>,
        val required_for_evolution: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonSpeciesGender(
        val rate: Int,
        val pokemon_species: NamedApiResource<PokemonSpecies>
)

data class GrowthRate(
        val id: Int,
        val name: String,
        val formula: String,
        val descriptions: List<Description>,
        val leves: List<GrowthRateExperienceLevel>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>
)

data class GrowthRateExperienceLevel(
        val level: Int,
        val experience: Int
)

data class Nature(
        val id: Int,
        val name: String,
        val decreased_stat: NamedApiResource<Stat>,
        val increased_stat: NamedApiResource<Stat>,
        val hates_flavor: NamedApiResource<BerryFlavor>,
        val likes_flavor: NamedApiResource<BerryFlavor>,
        val pokeathlon_stat_changes: List<NatureStatChange>,
        val move_battle_style_preferences: List<MoveBattleStylePreference>,
        val names: List<Name>
)

data class NatureStatChange(
        val change: Int,
        val stat: NamedApiResource<PokeathlonStat>
)

data class MoveBattleStylePreference(
        val low_hp_preference: Int,
        val high_hp_preference: Int,
        val move_battle_style: NamedApiResource<MoveBattleStyle>
)

data class PokeathlonStat(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val affecting_natures: NaturePokeathlonStatAffectSets
)

data class NaturePokeathlonStatAffectSets(
        val increase: List<NaturePokeathlonStatAffect>,
        val decrease: List<NaturePokeathlonStatAffect>
)

data class NaturePokeathlonStatAffect(
        val max_change: Int,
        val nature: NamedApiResource<Nature>
)

data class Pokemon(
        val id: Int,
        val name: String,
        val base_experience: Int,
        val height: Int,
        val is_default: Boolean,
        val order: Int,
        val weight: Int,
        val abilities: List<PokemonAbility>,
        val forms: List<NamedApiResource<PokemonForm>>,
        val game_indices: List<VersionGameIndex>,
        val held_items: List<NamedApiResource<Item>>,
        val location_area_encounters: List<LocationAreaEncounter>,
        val moves: List<NamedApiResource<Move>>,
        val stats: List<NamedApiResource<Stat>>,
        val types: List<PokemonType>
)

data class PokemonAbility(
        val is_hidden: Boolean,
        val slot: Int,
        val ability: NamedApiResource<Ability>
)

data class PokemonType(
        val slot: Int,
        val type: String
)

data class LocationAreaEncounter(
        val location_area: ApiResource<LocationArea>,
        val version_details: List<VersionEncounterDetail>
)

data class PokemonColor(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonForm(
        val id: Int,
        val name: String,
        val order: Int,
        val form_order: Int,
        val is_default: Boolean,
        val is_battle_only: Boolean,
        val is_mega: Boolean,
        val form_name: String,
        val pokemon: NamedApiResource<Pokemon>,
        val version_group: NamedApiResource<VersionGroup>
)

data class PokemonHabitat(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonShape(
        val id: Int,
        val name: String,
        val awesome_names: List<AwesomeName>,
        val names: List<Name>,
        val pokemon_species: List<NamedApiResource<PokemonSpecies>>
)

data class AwesomeName(
        val awesome_name: String,
        val language: NamedApiResource<Language>
)

data class PokemonSpecies(
        val id: Int,
        val name: String,
        val order: Int,
        val gender_rate: Int,
        val capture_rate: Int,
        val base_happiness: Int,
        val is_baby: Boolean,
        val hatch_counter: Int,
        val has_gender_differences: Boolean,
        val forms_switchable: Boolean,
        val growth_rate: NamedApiResource<GrowthRate>,
        val pokedex_numbers: List<PokemonSpeciesDexEntry>,
        val egg_groups: List<NamedApiResource<EggGroup>>,
        val color: List<NamedApiResource<PokemonColor>>,
        val shape: List<NamedApiResource<PokemonShape>>,
        val evolves_from_species: NamedApiResource<PokemonSpecies>,
        val evolution_chain: ApiResource<EvolutionChain>,
        val habitat: NamedApiResource<PokemonHabitat>,
        val generation: NamedApiResource<Generation>,
        val names: List<Name>,
        val pal_park_encounters: List<PalParkEncounterArea>,
        val form_description: List<Description>,
        val genera: Genus,
        val varieties: List<NamedApiResource<Pokemon>>
)

data class Genus(
        val genus: String,
        val language: NamedApiResource<Language>
)

data class PokemonSpeciesDexEntry(
        val entry_number: Int,
        val name: NamedApiResource<Pokedex>
)

data class PalParkEncounterArea(
        val base_score: Int,
        val rate: Int,
        val area: NamedApiResource<PalParkArea>
)

data class Stat(
        val id: Int,
        val name: String,
        val game_index: Int,
        val is_battle_only: Boolean,
        val affecting_moves: MoveStatAffectSets,
        val affecting_natures: NatureStatAffectSets,
        val characteristics: List<ApiResource<Characteristic>>,
        val move_damage_class: NamedApiResource<MoveDamageClass>,
        val names: List<Name>
)

data class MoveStatAffectSets(
        val increase: List<MoveStatAffect>,
        val decrease: List<MoveStatAffect>
)

data class MoveStatAffect(
        val max_change: Int,
        val move: NamedApiResource<Move>
)

data class NatureStatAffectSets(
        val increase: List<NatureStatAffect>,
        val decrease: List<NatureStatAffect>
)

data class NatureStatAffect(
        val max_change: Int,
        val nature: NamedApiResource<Nature>
)

data class Type(
        val id: Int,
        val name: String,
        val damage_relations: TypeRelations,
        val game_indices: List<GenerationGameIndex>,
        val generation: NamedApiResource<Generation>,
        val move_damage_class: NamedApiResource<MoveDamageClass>,
        val names: List<Name>,
        val pokemon: TypePokemon,
        val moves: List<NamedApiResource<Move>>
)

data class TypePokemon(
        val slot: Int,
        val pokemon: NamedApiResource<Pokemon>
)

data class TypeRelations(
        val no_damage_to: List<NamedApiResource<Type>>,
        val half_damage_to: List<NamedApiResource<Type>>,
        val double_damage_to: List<NamedApiResource<Type>>,
        val no_damage_from: List<NamedApiResource<Type>>,
        val half_damage_from: List<NamedApiResource<Type>>,
        val double_damage_from: List<NamedApiResource<Type>>
)