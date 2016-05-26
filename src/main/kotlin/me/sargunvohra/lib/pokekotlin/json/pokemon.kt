package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Ability(
        val id: Int,
        val name: String,
        @Json(name = "is_main_series")
        val isMainSeries: Boolean,
        val generation: NamedApiResource<Generation>,
        val names: List<Name>,
        @Json(name = "effect_entries")
        val effectEntries: List<VerboseEffect>,
        @Json(name = "effect_changes")
        val effectChanges: List<AbilityEffectChange>,
        @Json(name = "flavor_text_entries")
        val flavorTextEntries: List<AbilityFlavorText>,
        val pokemon: List<AbilityPokemon>
)

data class AbilityEffectChange(
        @Json(name = "effect_entries")
        val effectEntries: List<Effect>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>
)

data class AbilityFlavorText(
        @Json(name = "flavor_text")
        val flavorText: String,
        val language: NamedApiResource<Language>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>
)

data class AbilityPokemon(
        @Json(name = "is_hidden")
        val isHidden: Boolean,
        val slot: Int,
        val pokemon: NamedApiResource<Pokemon>
)

data class Characteristic(
        val id: Int,
        @Json(name = "gene_modulo")
        val geneModulo: Int,
        @Json(name = "possible_values")
        val possibleValues: List<Int>,
        val descriptions: List<Description>
)

data class EggGroup(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)

data class Gender(
        val id: Int,
        val name: String,
        @Json(name = "pokemon_species_details")
        val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
        @Json(name = "required_for_evolution")
        val requiredForEvolution: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonSpeciesGender(
        val rate: Int,
        @Json(name = "pokemon_species")
        val pokemonSpecies: NamedApiResource<PokemonSpecies>
)

data class GrowthRate(
        val id: Int,
        val name: String,
        val formula: String,
        val descriptions: List<Description>,
        val levels: List<GrowthRateExperienceLevel>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)

data class GrowthRateExperienceLevel(
        val level: Int,
        val experience: Int
)

data class Nature(
        val id: Int,
        val name: String,
        @Json(name = "decreased_stat")
        val decreasedStat: NamedApiResource<Stat>,
        @Json(name = "increased_stat")
        val increasedStat: NamedApiResource<Stat>,
        @Json(name = "hates_flavor")
        val hatesFlavor: NamedApiResource<BerryFlavor>,
        @Json(name = "likes_flavor")
        val likesFlavor: NamedApiResource<BerryFlavor>,
        @Json(name = "pokeathlon_stat_changes")
        val pokeathlonStatChanges: List<NatureStatChange>,
        @Json(name = "move_battle_style_preferences")
        val moveBattleStylePreferences: List<MoveBattleStylePreference>,
        val names: List<Name>
)

data class NatureStatChange(
        @Json(name = "max_change")
        val maxChange: Int,
        @Json(name = "pokeathlon_stat")
        val pokeathlonStat: NamedApiResource<PokeathlonStat>
)

data class MoveBattleStylePreference(
        @Json(name = "low_hp_preference")
        val lowHpPreference: Int,
        @Json(name = "high_hp_preference")
        val highHpPreference: Int,
        @Json(name = "move_battle_style")
        val moveBattleStyle: NamedApiResource<MoveBattleStyle>
)

data class PokeathlonStat(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "affecting_natures")
        val affectingNatures: NaturePokeathlonStatAffectSets
)

data class NaturePokeathlonStatAffectSets(
        val increase: List<NaturePokeathlonStatAffect>,
        val decrease: List<NaturePokeathlonStatAffect>
)

data class NaturePokeathlonStatAffect(
        @Json(name = "max_change")
        val maxChange: Int,
        val nature: NamedApiResource<Nature>
)

data class Pokemon(
        val id: Int,
        val name: String,
        @Json(name = "base_experience")
        val baseExperience: Int,
        val height: Int,
        @Json(name = "is_default")
        val isDefault: Boolean,
        val order: Int,
        val weight: Int,
        val species: NamedApiResource<PokemonSpecies>,
        val abilities: List<PokemonAbility>,
        val forms: List<NamedApiResource<PokemonForm>>,
        @Json(name = "game_indices")
        val gameIndices: List<VersionGameIndex>,
        @Json(name = "held_items")
        val heldItems: List<PokemonHeldItem>,
        @Json(name = "location_area_encounters")
        val locationAreaEncounters: List<LocationAreaEncounter>,
        val moves: List<PokemonMove>,
        val stats: List<PokemonStat>,
        val types: List<PokemonType>
)

data class PokemonAbility(
        @Json(name = "is_hidden")
        val isHidden: Boolean,
        val slot: Int,
        val ability: NamedApiResource<Ability>
)

data class PokemonHeldItem(
        val item: NamedApiResource<Item>,
        @Json(name = "version_details")
        val versionDetails: List<PokemonHeldItemVersion>
)

data class PokemonHeldItemVersion(
        val version: NamedApiResource<Version>,
        val rarity: Int
)

data class PokemonMove(
        val move: NamedApiResource<Move>,
        @Json(name = "version_group_details")
        val versionGroupDetails: List<PokemonMoveVersion>
)

data class PokemonMoveVersion(
        @Json(name = "move_learn_method")
        val moveLearnMethod: NamedApiResource<MoveLearnMethod>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>,
        @Json(name = "level_learned_at")
        val levelLearnedAt: Int
)

data class PokemonStat(
        val stat: NamedApiResource<Stat>,
        val effort: Int,
        val baseStat: Int
)

data class PokemonType(
        val slot: Int,
        val type: NamedApiResource<Type>
)

data class LocationAreaEncounter(
        @Json(name = "location_area")
        val locationArea: NamedApiResource<LocationArea>,
        @Json(name = "version_details")
        val versionDetails: List<VersionEncounterDetail>
)

data class PokemonColor(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonForm(
        val id: Int,
        val name: String,
        val order: Int,
        @Json(name = "form_order")
        val formOrder: Int,
        @Json(name = "is_default")
        val isDefault: Boolean,
        @Json(name = "is_battle_only")
        val isBattleOnly: Boolean,
        @Json(name = "is_mega")
        val isMega: Boolean,
        @Json(name = "form_name")
        val formName: String,
        val pokemon: NamedApiResource<Pokemon>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>
)

data class PokemonHabitat(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)

data class PokemonShape(
        val id: Int,
        val name: String,
        @Json(name = "awesome_names")
        val awesomeNames: List<AwesomeName>,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>
)

data class AwesomeName(
        @Json(name = "awesome_name")
        val awesomeName: String,
        val language: NamedApiResource<Language>
)

data class PokemonSpecies(
        val id: Int,
        val name: String,
        val order: Int,
        @Json(name = "gender_rate")
        val genderRate: Int,
        @Json(name = "capture_rate")
        val captureRate: Int,
        @Json(name = "base_happiness")
        val baseHappiness: Int,
        @Json(name = "is_baby")
        val isBaby: Boolean,
        @Json(name = "hatch_counter")
        val hatchCounter: Int,
        @Json(name = "has_gender_differences")
        val hasGenderDifferences: Boolean,
        @Json(name = "forms_switchable")
        val formsSwitchable: Boolean,
        @Json(name = "growth_rate")
        val growthRate: NamedApiResource<GrowthRate>,
        @Json(name = "pokedex_numbers")
        val pokedexNumbers: List<PokemonSpeciesDexEntry>,
        @Json(name = "egg_groups")
        val eggGroups: List<NamedApiResource<EggGroup>>,
        val color: NamedApiResource<PokemonColor>,
        val shape: NamedApiResource<PokemonShape>,
        @Json(name = "evolves_from_species")
        val evolvesFromSpecies: NamedApiResource<PokemonSpecies>?,
        @Json(name = "evolution_chain")
        val evolutionChain: ApiResource<EvolutionChain>,
        val habitat: NamedApiResource<PokemonHabitat>,
        val generation: NamedApiResource<Generation>,
        val names: List<Name>,
        @Json(name = "pal_park_encounters")
        val palParkEncounters: List<PalParkEncounterArea>,
        @Json(name = "form_descriptions")
        val formDescriptions: List<Description>,
        val genera: List<Genus>,
        val varieties: List<PokemonSpeciesVariety>
)

data class Genus(
        val genus: String,
        val language: NamedApiResource<Language>
)

data class PokemonSpeciesDexEntry(
        @Json(name = "entry_number")
        val entryNumber: Int,
        val pokedex: NamedApiResource<Pokedex>
)

data class PalParkEncounterArea(
        @Json(name = "base_score")
        val baseScore: Int,
        val rate: Int,
        val area: NamedApiResource<PalParkArea>
)

data class PokemonSpeciesVariety(
        @Json(name = "is_default")
        val isDefault: Boolean,
        val pokemon: NamedApiResource<Pokemon>
)

data class Stat(
        val id: Int,
        val name: String,
        @Json(name = "game_index")
        val gameIndex: Int,
        @Json(name = "is_battle_only")
        val isBattleOnly: Boolean,
        @Json(name = "affecting_moves")
        val affectingMoves: MoveStatAffectSets,
        @Json(name = "affecting_natures")
        val affectingNatures: NatureStatAffectSets,
        val characteristics: List<ApiResource<Characteristic>>,
        @Json(name = "move_damage_class")
        val moveDamageClass: NamedApiResource<MoveDamageClass>,
        val names: List<Name>
)

data class MoveStatAffectSets(
        val increase: List<MoveStatAffect>,
        val decrease: List<MoveStatAffect>
)

data class MoveStatAffect(
        val change: Int,
        val move: NamedApiResource<Move>
)

data class NatureStatAffectSets(
        val increase: List<NamedApiResource<Nature>>,
        val decrease: List<NamedApiResource<Nature>>
)

data class Type(
        val id: Int,
        val name: String,
        @Json(name = "damage_relations")
        val damageRelations: TypeRelations,
        @Json(name = "game_indices")
        val gameIndices: List<GenerationGameIndex>,
        val generation: NamedApiResource<Generation>,
        @Json(name = "move_damage_class")
        val moveDamageClass: NamedApiResource<MoveDamageClass>,
        val names: List<Name>,
        val pokemon: List<TypePokemon>,
        val moves: List<NamedApiResource<Move>>
)

data class TypePokemon(
        val slot: Int,
        val pokemon: NamedApiResource<Pokemon>
)

data class TypeRelations(
        @Json(name = "no_damage_to")
        val noDamageTo: List<NamedApiResource<Type>>,
        @Json(name = "half_damage_to")
        val halfDamageTo: List<NamedApiResource<Type>>,
        @Json(name = "double_damage_to")
        val doubleDamageTo: List<NamedApiResource<Type>>,
        @Json(name = "no_damage_from")
        val noDamageFrom: List<NamedApiResource<Type>>,
        @Json(name = "half_damage_from")
        val halfDamageFrom: List<NamedApiResource<Type>>,
        @Json(name = "double_damage_from")
        val doubleDamageFrom: List<NamedApiResource<Type>>
)