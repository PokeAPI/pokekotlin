package me.sargunvohra.lib.pokekotlin.json

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