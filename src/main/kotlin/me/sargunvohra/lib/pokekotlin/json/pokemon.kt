package me.sargunvohra.lib.pokekotlin.json

data class JsonAbility(
        val id: Int,
        val name: String,
        val is_main_series: Boolean,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val names: List<JsonName>,
        val effect_entries: List<JsonVerboseEffect>,
        val effect_changes: List<JsonAbilityEffectChange>,
        val flavor_text_entries: List<JsonVersionGroupFlavorText>,
        val pokemon: List<JsonAbilityPokemon>
)

data class JsonAbilityEffectChange(
        val effect_entries: List<JsonEffect>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonAbilityFlavorText(
        val flavor_text: String,
        val language: JsonNamedApiResource<JsonLanguage>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonAbilityPokemon(
        val is_hidden: Boolean,
        val slot: Int,
        val pokemon: JsonNamedApiResource<JsonPokemon>
)

data class JsonCharacteristic(
        val id: Int,
        val gene_modulo: Int,
        val possible_values: List<Int>,
        val descriptions: List<JsonDescription>
)

data class JsonEggGroup(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonGender(
        val id: Int,
        val name: String,
        val pokemon_species_details: List<JsonPokemonSpeciesGender>,
        val required_for_evolution: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

data class JsonPokemonSpeciesGender(
        val rate: Int,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonGrowthRate(
        val id: Int,
        val name: String,
        val formula: String,
        val descriptions: List<JsonDescription>,
        val leves: List<JsonGrowthRateExperienceLevel>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

data class JsonGrowthRateExperienceLevel(
        val level: Int,
        val experience: Int
)

data class JsonNature(
        val id: Int,
        val name: String,
        val decreased_stat: JsonNamedApiResource<JsonStat>,
        val increased_stat: JsonNamedApiResource<JsonStat>,
        val hates_flavor: JsonNamedApiResource<JsonBerryFlavor>,
        val likes_flavor: JsonNamedApiResource<JsonBerryFlavor>,
        val pokeathlon_stat_changes: List<JsonNatureStatChange>,
        val move_battle_style_preferences: List<JsonMoveBattleStylePreference>,
        val names: List<JsonName>
)

data class JsonNatureStatChange(
        val change: Int,
        val stat: JsonNamedApiResource<JsonPokeathlonStat>
)

data class JsonMoveBattleStylePreference(
        val low_hp_preference: Int,
        val high_hp_preference: Int,
        val move_battle_style: JsonNamedApiResource<JsonMoveBattleStyle>
)

data class JsonPokeathlonStat(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val affecting_natures: JsonNaturePokeathlonStatAffectSets
)

data class JsonNaturePokeathlonStatAffectSets(
        val increase: List<JsonNaturePokeathlonStatAffect>,
        val decrease: List<JsonNaturePokeathlonStatAffect>
)

data class JsonNaturePokeathlonStatAffect(
        val max_change: Int,
        val nature: JsonNamedApiResource<JsonNature>
)

data class JsonPokemon(
        val id: Int,
        val name: String,
        val base_experience: Int,
        val height: Int,
        val is_default: Boolean,
        val order: Int,
        val weight: Int,
        val abilities: List<JsonPokemonAbility>,
        val forms: List<JsonNamedApiResource<JsonPokemonForm>>,
        val game_indices: List<JsonVersionGameIndex>,
        val held_items: List<JsonNamedApiResource<JsonItem>>,
        val location_area_encounters: List<JsonLocationAreaEncounter>,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val stats: List<JsonNamedApiResource<JsonStat>>,
        val types: List<JsonPokemonType>
)

data class JsonPokemonAbility(
        val is_hidden: Boolean,
        val slot: Int,
        val ability: JsonNamedApiResource<JsonAbility>
)

data class JsonPokemonType(
        val slot: Int,
        val type: String
)

data class JsonLocationAreaEncounter(
        val location_area: JsonApiResource<JsonLocationArea>,
        val version_details: List<JsonVersionEncounterDetail>
)

data class JsonPokemonColor(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

data class JsonPokemonForm(
        val id: Int,
        val name: String,
        val order: Int,
        val form_order: Int,
        val is_default: Boolean,
        val is_battle_only: Boolean,
        val is_mega: Boolean,
        val form_name: String,
        val pokemon: JsonNamedApiResource<JsonPokemon>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonPokemonHabitat(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

data class JsonPokemonShape(
        val id: Int,
        val name: String,
        val awesome_names: List<JsonAwesomeName>,
        val names: List<JsonName>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

data class JsonAwesomeName(
        val awesome_name: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonPokemonSpecies(
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
        val growth_rate: JsonNamedApiResource<JsonGrowthRate>,
        val pokedex_numbers: List<JsonPokemonSpeciesDexEntry>,
        val egg_groups: List<JsonNamedApiResource<JsonEggGroup>>,
        val color: List<JsonNamedApiResource<JsonPokemonColor>>,
        val shape: List<JsonNamedApiResource<JsonPokemonShape>>,
        val evolves_from_species: JsonNamedApiResource<JsonPokemonSpecies>,
        val evolution_chain: JsonApiResource<JsonEvolutionChain>,
        val habitat: JsonNamedApiResource<JsonPokemonHabitat>,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val names: List<JsonName>,
        val pal_park_encounters: List<JsonPalParkEncounterArea>,
        val form_description: List<JsonDescription>,
        val genera: JsonGenus,
        val varieties: List<JsonNamedApiResource<JsonPokemon>>
)

data class JsonGenus(
        val genus: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonPokemonSpeciesDexEntry(
        val entry_number: Int,
        val name: JsonNamedApiResource<JsonPokedex>
)

data class JsonPalParkEncounterArea(
        val base_score: Int,
        val rate: Int,
        val area: JsonNamedApiResource<JsonPalParkArea>
)

data class JsonStat(
        val id: Int,
        val name: String,
        val game_index: Int,
        val is_battle_only: Boolean,
        val affecting_moves: JsonMoveStatAffectSets,
        val affecting_natures: JsonNatureStatAffectSets,
        val characteristics: List<JsonApiResource<JsonCharacteristic>>,
        val move_damage_class: JsonNamedApiResource<JsonMoveDamageClass>,
        val names: List<JsonName>
)

data class JsonMoveStatAffectSets(
        val increase: List<JsonMoveStatAffect>,
        val decrease: List<JsonMoveStatAffect>
)

data class JsonMoveStatAffect(
        val max_change: Int,
        val move: JsonNamedApiResource<JsonMove>
)

data class JsonNatureStatAffectSets(
        val increase: List<JsonNatureStatAffect>,
        val decrease: List<JsonNatureStatAffect>
)

data class JsonNatureStatAffect(
        val max_change: Int,
        val nature: JsonNamedApiResource<JsonNature>
)

data class JsonType(
        val id: Int,
        val name: String,
        val damage_relations: JsonTypeRelations,
        val game_indices: List<JsonGenerationGameIndex>,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val move_damage_class: JsonNamedApiResource<JsonMoveDamageClass>,
        val names: List<JsonName>,
        val pokemon: JsonTypePokemon,
        val moves: List<JsonNamedApiResource<JsonMove>>
)

data class JsonTypePokemon(
        val slot: Int,
        val pokemon: JsonNamedApiResource<JsonPokemon>
)

data class JsonTypeRelations(
        val no_damage_to: List<JsonNamedApiResource<JsonType>>,
        val half_damage_to: List<JsonNamedApiResource<JsonType>>,
        val double_damage_to: List<JsonNamedApiResource<JsonType>>,
        val no_damage_from: List<JsonNamedApiResource<JsonType>>,
        val half_damage_from: List<JsonNamedApiResource<JsonType>>,
        val double_damage_from: List<JsonNamedApiResource<JsonType>>
)