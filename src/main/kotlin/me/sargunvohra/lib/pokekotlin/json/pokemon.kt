package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Ability(
        val id: Int,
        val name: String,
        @Json(name = "is_main_series")
        val isMainSeries: Boolean,
        val generation: NamedApiResource,
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
        val versionGroup: NamedApiResource
)

data class AbilityFlavorText(
        @Json(name = "flavor_text")
        val flavorText: String,
        val language: NamedApiResource,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource
)

data class AbilityPokemon(
        @Json(name = "is_hidden")
        val isHidden: Boolean,
        val slot: Int,
        val pokemon: NamedApiResource
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
        val pokemonSpecies: List<NamedApiResource>
)

data class Gender(
        val id: Int,
        val name: String,
        @Json(name = "pokemon_species_details")
        val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
        @Json(name = "required_for_evolution")
        val requiredForEvolution: List<NamedApiResource>
)

data class PokemonSpeciesGender(
        val rate: Int,
        @Json(name = "pokemon_species")
        val pokemonSpecies: NamedApiResource
)

data class GrowthRate(
        val id: Int,
        val name: String,
        val formula: String,
        val descriptions: List<Description>,
        val levels: List<GrowthRateExperienceLevel>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource>
)

data class GrowthRateExperienceLevel(
        val level: Int,
        val experience: Int
)

data class Nature(
        val id: Int,
        val name: String,
        @Json(name = "decreased_stat")
        val decreasedStat: NamedApiResource,
        @Json(name = "increased_stat")
        val increasedStat: NamedApiResource,
        @Json(name = "hates_flavor")
        val hatesFlavor: NamedApiResource,
        @Json(name = "likes_flavor")
        val likesFlavor: NamedApiResource,
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
        val pokeathlonStat: NamedApiResource
)

data class MoveBattleStylePreference(
        @Json(name = "low_hp_preference")
        val lowHpPreference: Int,
        @Json(name = "high_hp_preference")
        val highHpPreference: Int,
        @Json(name = "move_battle_style")
        val moveBattleStyle: NamedApiResource
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
        val nature: NamedApiResource
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
        val species: NamedApiResource,
        val abilities: List<PokemonAbility>,
        val forms: List<NamedApiResource>,
        @Json(name = "game_indices")
        val gameIndices: List<VersionGameIndex>,
        @Json(name = "held_items")
        val heldItems: List<PokemonHeldItem>,
        @Json(name = "location_area_encounters")
        val locationAreaEncounters: List<LocationAreaEncounter>,
        val moves: List<PokemonMove>,
        val stats: List<PokemonStat>,
        val types: List<PokemonType>,
        val sprites: PokemonSprites
)

data class PokemonSprites(
        @Json(name = "back_default")
        val backDefault: String,
        @Json(name = "back_shiny")
        val backShiny: String,
        @Json(name = "front_default")
        val frontDefault: String,
        @Json(name = "front_shiny")
        val frontShiny: String,
        @Json(name = "back_female")
        val backFemale: String?,
        @Json(name = "back_shiny_female")
        val backShinyFemale: String?,
        @Json(name = "front_female")
        val frontFemale: String?,
        @Json(name = "front_shiny_female")
        val frontShinyFemale: String?

)

data class PokemonAbility(
        @Json(name = "is_hidden")
        val isHidden: Boolean,
        val slot: Int,
        val ability: NamedApiResource
)

data class PokemonHeldItem(
        val item: NamedApiResource,
        @Json(name = "version_details")
        val versionDetails: List<PokemonHeldItemVersion>
)

data class PokemonHeldItemVersion(
        val version: NamedApiResource,
        val rarity: Int
)

data class PokemonMove(
        val move: NamedApiResource,
        @Json(name = "version_group_details")
        val versionGroupDetails: List<PokemonMoveVersion>
)

data class PokemonMoveVersion(
        @Json(name = "move_learn_method")
        val moveLearnMethod: NamedApiResource,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource,
        @Json(name = "level_learned_at")
        val levelLearnedAt: Int
)

data class PokemonStat(
        val stat: NamedApiResource,
        val effort: Int,
        val baseStat: Int
)

data class PokemonType(
        val slot: Int,
        val type: NamedApiResource
)

data class LocationAreaEncounter(
        @Json(name = "location_area")
        val locationArea: NamedApiResource,
        @Json(name = "version_details")
        val versionDetails: List<VersionEncounterDetail>
)

data class PokemonColor(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource>
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
        val pokemon: NamedApiResource,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource,
        val sprites: PokemonFormSprites
)

data class PokemonFormSprites(
        @Json(name = "back_default")
        val backDefault: String,
        @Json(name = "back_shiny")
        val backShiny: String,
        @Json(name = "front_default")
        val frontDefault: String,
        @Json(name = "front_shiny")
        val frontShiny: String
)

data class PokemonHabitat(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource>
)

data class PokemonShape(
        val id: Int,
        val name: String,
        @Json(name = "awesome_names")
        val awesomeNames: List<AwesomeName>,
        val names: List<Name>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource>
)

data class AwesomeName(
        @Json(name = "awesome_name")
        val awesomeName: String,
        val language: NamedApiResource
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
        val growthRate: NamedApiResource,
        @Json(name = "pokedex_numbers")
        val pokedexNumbers: List<PokemonSpeciesDexEntry>,
        @Json(name = "egg_groups")
        val eggGroups: List<NamedApiResource>,
        val color: NamedApiResource,
        val shape: NamedApiResource,
        @Json(name = "evolves_from_species")
        val evolvesFromSpecies: NamedApiResource?,
        @Json(name = "evolution_chain")
        val evolutionChain: ApiResource,
        val habitat: NamedApiResource,
        val generation: NamedApiResource,
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
        val language: NamedApiResource
)

data class PokemonSpeciesDexEntry(
        @Json(name = "entry_number")
        val entryNumber: Int,
        val pokedex: NamedApiResource
)

data class PalParkEncounterArea(
        @Json(name = "base_score")
        val baseScore: Int,
        val rate: Int,
        val area: NamedApiResource
)

data class PokemonSpeciesVariety(
        @Json(name = "is_default")
        val isDefault: Boolean,
        val pokemon: NamedApiResource
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
        val characteristics: List<ApiResource>,
        @Json(name = "move_damage_class")
        val moveDamageClass: NamedApiResource,
        val names: List<Name>
)

data class MoveStatAffectSets(
        val increase: List<MoveStatAffect>,
        val decrease: List<MoveStatAffect>
)

data class MoveStatAffect(
        val change: Int,
        val move: NamedApiResource
)

data class NatureStatAffectSets(
        val increase: List<NamedApiResource>,
        val decrease: List<NamedApiResource>
)

data class Type(
        val id: Int,
        val name: String,
        @Json(name = "damage_relations")
        val damageRelations: TypeRelations,
        @Json(name = "game_indices")
        val gameIndices: List<GenerationGameIndex>,
        val generation: NamedApiResource,
        @Json(name = "move_damage_class")
        val moveDamageClass: NamedApiResource,
        val names: List<Name>,
        val pokemon: List<TypePokemon>,
        val moves: List<NamedApiResource>
)

data class TypePokemon(
        val slot: Int,
        val pokemon: NamedApiResource
)

data class TypeRelations(
        @Json(name = "no_damage_to")
        val noDamageTo: List<NamedApiResource>,
        @Json(name = "half_damage_to")
        val halfDamageTo: List<NamedApiResource>,
        @Json(name = "double_damage_to")
        val doubleDamageTo: List<NamedApiResource>,
        @Json(name = "no_damage_from")
        val noDamageFrom: List<NamedApiResource>,
        @Json(name = "half_damage_from")
        val halfDamageFrom: List<NamedApiResource>,
        @Json(name = "double_damage_from")
        val doubleDamageFrom: List<NamedApiResource>
)