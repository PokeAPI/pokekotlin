package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Move(
        val id: Int,
        val name: String,
        val accuracy: Int?,
        @Json(name = "effect_chance")
        val effectChance: Int?,
        val pp: Int?,
        val priority: Int,
        val power: Int?,
        @Json(name = "contest_combos")
        val contestCombos: ContestComboSets?,
        @Json(name = "contest_type")
        val contestType: NamedApiResource?,
        @Json(name = "contest_effect")
        val contestEffect: ApiResource?,
        @Json(name = "super_contest_effect")
        val superContestEffect: ApiResource?,
        @Json(name = "damage_class")
        val damageClass: NamedApiResource,
        @Json(name = "effect_entries")
        val effectEntries: List<VerboseEffect>,
        @Json(name = "effect_changes")
        val effectChanges: List<AbilityEffectChange>,
        val generation: NamedApiResource,
        val meta: MoveMetaData?,
        val names: List<Name>,
        @Json(name = "past_values")
        val pastValues: List<PastMoveStatValues>,
        @Json(name = "stat_changes")
        val statChanges: List<MoveStatChange>,
        val target: NamedApiResource,
        val type: NamedApiResource
)

data class ContestComboSets(
        @Json(name = "normal")
        val normalSet: ContestComboDetail,
        @Json(name = "super")
        val superSet: ContestComboDetail
)

data class ContestComboDetail(
        @Json(name = "use_before")
        val useBefore: List<NamedApiResource>?,
        @Json(name = "use_after")
        val useAfter: List<NamedApiResource>?
)

data class MoveMetaData(
        val ailment: NamedApiResource,
        val category: NamedApiResource,
        @Json(name = "min_hits")
        val minHits: Int?,
        @Json(name = "max_hits")
        val maxHits: Int?,
        @Json(name = "min_turns")
        val minTurns: Int?,
        @Json(name = "max_turns")
        val maxTurns: Int?,
        val drain: Int,
        val healing: Int,
        @Json(name = "crit_rate")
        val critRate: Int,
        @Json(name = "ailment_chance")
        val ailmentChance: Int,
        @Json(name = "flinch_chance")
        val flinchChance: Int,
        @Json(name = "stat_chance")
        val statChance: Int
)

data class MoveStatChange(
        val change: Int,
        val stat: NamedApiResource
)

data class PastMoveStatValues(
        val accuracy: Int?,
        @Json(name = "effect_chance")
        val effectChance: Int?,
        val power: Int?,
        val pp: Int?,
        @Json(name = "effect_entries")
        val effectEntries: List<VerboseEffect>,
        val type: NamedApiResource?,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource
)

data class MoveAilment(
        val id: Int,
        val name: String,
        val moves: List<NamedApiResource>,
        val names: List<Name>
)

data class MoveBattleStyle(
        val id: Int,
        val name: String,
        val names: List<Name>
)

data class MoveCategory(
        val id: Int,
        val name: String,
        val moves: List<NamedApiResource>,
        val descriptions: List<Description>
)

data class MoveDamageClass(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val moves: List<NamedApiResource>,
        val names: List<Name>
)

data class MoveLearnMethod(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val names: List<Name>,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource>
)

data class MoveTarget(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val moves: List<NamedApiResource>,
        val names: List<Name>
)