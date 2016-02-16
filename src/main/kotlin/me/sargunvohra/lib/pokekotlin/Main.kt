package me.sargunvohra.lib.pokekotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

fun main(vararg args: String) {
    val service = Retrofit.Builder()
            .baseUrl("http://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiService::class.java)

//    println(service.getLanguage(1).execute().body())
}

interface PokeApiService {
}

// berries

data class JsonBerry(
        val id: Int,
        val name: String,
        val growth_time: Int,
        val max_harvest: Int,
        val natural_gift_power: Int,
        val size: Int,
        val smoothness: Int,
        val soil_dryness: Int,
        val firmness: JsonNamedApiResource<JsonBerryFirmness>,
        val flavors: List<JsonBerryFlavorMap>,
        val item: JsonNamedApiResource<JsonItem>,
        val natural_gift_type: JsonNamedApiResource<JsonType>
)

data class JsonBerryFlavorMap(
        val potency: Int,
        val flavor: JsonNamedApiResource<JsonBerryFlavor>
)

data class JsonBerryFirmness(
        val id: Int,
        val name: String,
        val berries: List<JsonNamedApiResource<JsonBerry>>,
        val names: List<JsonName>
)

data class JsonBerryFlavor(
        val id: Int,
        val name: String,
        val berries: List<JsonFlavorBerryMap>,
        val contest_type: JsonNamedApiResource<JsonContestType>,
        val names: List<JsonName>
)

data class JsonFlavorBerryMap(
        val potency: Int,
        val berry: JsonNamedApiResource<JsonBerry>
)

// contests

data class JsonContestType(
        val id: Int,
        val name: String,
        val berry_flavor: JsonNamedApiResource<JsonBerryFlavor>,
        val names: List<JsonName>
)

data class JsonContestEffect(
        val id: Int,
        val appeal: String,
        val jam: Int,
        val effect_entries: List<JsonEffect>,
        val flavor_text_entries: List<JsonFlavorText>
)

data class JsonSuperContestEffect(
        val id: Int,
        val appeal: String,
        val flavor_text_entries: List<JsonFlavorText>,
        val moves: List<JsonNamedApiResource<JsonMove>>
)

// encounters

data class JsonEncounterMethod(
        val id: Int,
        val name: String,
        val order: Int,
        val names: List<JsonName>
)

data class JsonEncounterCondition(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val values: List<JsonNamedApiResource<JsonEncounterConditionValue>>
)

data class JsonEncounterConditionValue(
        val id: Int,
        val name: String,
        val condition: JsonNamedApiResource<JsonEncounterCondition>,
        val names: List<JsonName>
)

// evolution

data class JsonEvolutionChain(
        val id: Int,
        val baby_trigger_item: JsonNamedApiResource<JsonItem>,
        val chain: JsonChainLink
)

data class JsonChainLink(
        val is_baby: Boolean,
        val species: JsonNamedApiResource<JsonPokemonSpecies>,
        val evolution_details: JsonEvolutionDetail,
        val evolves_to: JsonChainLink
)

data class JsonEvolutionDetail(
        val item: JsonNamedApiResource<JsonItem>?,
        val trigger: JsonNamedApiResource<JsonEvolutionTrigger>,
        val gender: JsonNamedApiResource<JsonGender>?,
        val held_item: JsonNamedApiResource<JsonItem>?,
        val known_move: JsonNamedApiResource<JsonMove>?,
        val known_move_type: JsonNamedApiResource<JsonMove>?,
        val location: JsonNamedApiResource<JsonLocation>?,
        val min_level: Int?,
        val min_happiness: Int?,
        val min_beauty: Int?,
        val min_affection: Int?,
        val needs_overworld_rain: Boolean,
        val part_species: JsonNamedApiResource<JsonPokemonSpecies>,
        val party_type: JsonNamedApiResource<JsonType>,
        val relative_physical_stats: Int,
        val time_of_day: String,
        val trade_species: JsonNamedApiResource<JsonPokemonSpecies>,
        val turn_upside_down: Boolean
)

data class JsonEvolutionTrigger(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)

// games

data class JsonGeneration(
        val id: Int,
        val name: String,
        val abilities: List<JsonAbility>,
        val names: List<JsonName>,
        val main_region: JsonNamedApiResource<JsonRegion>,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>,
        val types: List<JsonNamedApiResource<JsonType>>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

data class JsonPokedex(
        val id: Int,
        val name: String,
        val is_main_series: Boolean,
        val descriptions: List<JsonDescription>,
        val names: List<JsonName>,
        val pokemon_entries: List<JsonPokemonEntry>,
        val region: JsonNamedApiResource<JsonRegion>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

data class JsonPokemonEntry(
        val entry_number: Int,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonVersion(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonVersionGroup(
        val id: Int,
        val name: String,
        val order: Int,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val move_learn_methods: List<JsonNamedApiResource<JsonMoveLearnMethod>>,
        val names: List<JsonName>,
        val pokedexes: List<JsonNamedApiResource<JsonPokedex>>,
        val regions: List<JsonNamedApiResource<JsonRegion>>,
        val versions: List<JsonNamedApiResource<JsonVersion>>
)

// items

data class JsonItem(
        val id: Int,
        val name: String,
        val cost: Int,
        val fling_power: Int,
        val fling_effect: JsonItemFlingEffect,
        val attributes: List<JsonNamedApiResource<JsonItemAttribute>>,
        val category: JsonItemCategory,
        val effect_entries: List<JsonVerboseEffect>,
        val flavor_text_entries: List<JsonVersionGroupFlavorText>,
        val game_indices: List<JsonGenerationGameIndex>,
        val names: List<JsonName>,
        val held_by_pokemon: List<JsonNamedApiResource<JsonPokemon>>,
        val baby_trigger_for: List<JsonApiResource<JsonEvolutionChain>>
)

data class JsonItemAttribute(
        val id: Int,
        val name: String,
        val items: List<JsonNamedApiResource<JsonItem>>,
        val names: List<JsonName>,
        val descriptions: List<JsonDescription>
)

data class JsonItemCategory(
        val id: Int,
        val name: String,
        val items: List<JsonNamedApiResource<JsonItem>>,
        val names: List<JsonName>,
        val pocket: JsonNamedApiResource<JsonItemPocket>
)

data class JsonItemFlingEffect(
        val id: Int,
        val name: String,
        val effect_entries: List<JsonEffect>,
        val items: List<JsonNamedApiResource<JsonItem>>
)

data class JsonItemPocket(
        val id: Int,
        val name: String,
        val categories: List<JsonItemCategory>,
        val names: List<JsonName>
)

// moves

data class JsonMove(
        val id: Int,
        val name: String,
        val accuracy: Int,
        val effect_chance: Int,
        val pp: Int,
        val priority: Int,
        val power: Int,
        val contest_combos: List<JsonContestComboSets>,
        val contest_type: JsonContestType,
        val contest_effect: JsonNamedApiResource<JsonContestEffect>,
        val damage_class: JsonNamedApiResource<JsonMoveDamageClass>,
        val effect_entries: List<JsonVerboseEffect>,
        val effect_changes: List<JsonAbilityEffectChange>,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val meta: JsonMoveMetaData,
        val names: List<JsonName>,
        val past_values: List<JsonPastMoveStatValues>,
        val stat_changes: List<JsonMoveStatChange>,
        val target: JsonMoveTarget,
        val type: JsonType
)

data class JsonContestComboSets(
        val normal: List<JsonContestComboDetail>,
        val `super`: List<JsonContestComboDetail>
)

data class JsonContestComboDetail(
        val use_before: List<JsonNamedApiResource<JsonMove>>,
        val use_after: List<JsonNamedApiResource<JsonMove>>
)

data class JsonMoveMetaData(
        val ailment: JsonNamedApiResource<JsonMoveAilment>,
        val category: JsonNamedApiResource<JsonMove>,
        val min_hits: Int,
        val max_hits: Int,
        val min_turns: Int,
        val max_turns: Int,
        val drain: Int,
        val healing: Int,
        val crit_rate: Int,
        val ailment_chance: Int,
        val flinch_chance: Int,
        val stat_chance: Int
)

data class JsonMoveStatChange(
        val change: Int,
        val stat: JsonNamedApiResource<JsonStat>
)

data class JsonPastMoveStatValues(
        val accuracy: Int,
        val effect_chance: Int,
        val power: Int,
        val pp: Int,
        val effect_entries: List<JsonVerboseEffect>,
        val type: JsonType,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonMoveAilment(
        val id: Int,
        val name: String,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val names: List<JsonName>
)

data class JsonMoveBattleStyle(
        val id: Int,
        val name: String,
        val names: List<JsonName>
)

data class JsonMoveCategory(
        val id: Int,
        val name: String,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val descriptions: List<JsonDescription>
)

data class JsonMoveDamageClass(
        val id: Int,
        val name: String,
        val descriptions: List<JsonDescription>,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val names: List<JsonName>
)

data class JsonMoveLearnMethod(
        val id: Int,
        val name: String,
        val descriptions: List<JsonDescription>,
        val names: List<JsonName>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

data class JsonMoveTarget(
        val id: Int,
        val name: String,
        val descriptions: List<JsonDescription>,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val names: List<JsonName>
)

// locations

data class JsonLocation(
        val id: Int,
        val name: String,
        val region: JsonNamedApiResource<JsonRegion>,
        val names: List<JsonName>,
        val game_indices: List<JsonGenerationGameIndex>,
        val areas: JsonApiResource<JsonLocationArea>
)

data class JsonLocationArea(
        val id: Int,
        val name: String,
        val game_index: Int,
        val encounter_method_rates: List<JsonEncounterMethodRate>,
        val location: JsonNamedApiResource<JsonRegion>,
        val names: List<JsonName>,
        val pokemon_encounters: List<JsonPokemonEncounter>
)

data class JsonEncounterMethodRate(
        val encounter_method: JsonNamedApiResource<JsonEncounterMethod>,
        val version_details: List<JsonVersionEncounterDetail>
)

data class JsonPokemonEncounter(
        val pokemon: JsonNamedApiResource<JsonPokemon>,
        val version_details: List<JsonVersionEncounterDetail>
)

data class JsonPalParkArea(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_encounters: List<JsonPalParkEncounterSpecies>
)

data class JsonPalParkEncounterSpecies(
        val base_score: Int,
        val rate: Int,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonRegion(
        val id: Int,
        val name: String,
        val locations: List<JsonLocation>,
        val main_generation: JsonNamedApiResource<JsonGeneration>,
        val names: List<JsonName>,
        val pokedexes: List<JsonNamedApiResource<JsonPokedex>>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

// pokemon

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

// utility

data class JsonLanguage(
        val id: Int,
        val name: String,
        val official: Boolean,
        val iso639: String,
        val iso3166: String,
        val names: List<JsonName>
)

// common models

data class JsonApiResource<T>(
        val url: String
)

data class JsonDescription(
        val description: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonEffect(
        val effect: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonEncounter(
        val min_level: Int,
        val max_level: Int,
        val condition_values: List<JsonNamedApiResource<JsonEncounterConditionValue>>,
        val integer: Int,
        val method: JsonNamedApiResource<JsonEncounterMethod>
)

data class JsonFlavorText(
        val flavor_text: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonGenerationGameIndex(
        val game_index: Int,
        val generation: JsonNamedApiResource<JsonGeneration>
)

data class JsonName(
        val name: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonNamedApiResource<T>(
        val name: String,
        val url: String
)

data class JsonVerboseEffect(
        val effect: String,
        val short_effect: String,
        val language: JsonNamedApiResource<JsonLanguage>
)

data class JsonVersionEncounterDetail(
        val version: JsonNamedApiResource<JsonVersion>,
        val max_chance: Int,
        val encounter_details: List<JsonEncounter>
)

data class JsonVersionGameIndex(
        val game_index: Int,
        val version: JsonNamedApiResource<JsonVersion>
)

data class JsonVersionGroupFlavorText(
        val text: String,
        val language: JsonNamedApiResource<JsonLanguage>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)