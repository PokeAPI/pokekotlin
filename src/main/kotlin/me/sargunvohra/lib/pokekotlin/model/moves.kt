package me.sargunvohra.lib.pokekotlin.model

import com.google.gson.annotations.SerializedName

data class Move(
    val id: Int,
    val name: String,
    val accuracy: Int?,
    val effectChance: Int?,
    val pp: Int?,
    val priority: Int,
    val power: Int?,
    val contestCombos: ContestComboSets?,
    val contestType: NamedApiResource?,
    val contestEffect: ApiResource?,
    val superContestEffect: ApiResource?,
    val damageClass: NamedApiResource,
    val effectEntries: List<VerboseEffect>,
    val effectChanges: List<AbilityEffectChange>,
    val generation: NamedApiResource,
    val meta: MoveMetaData?,
    val names: List<Name>,
    val pastValues: List<PastMoveStatValues>,
    val statChanges: List<MoveStatChange>,
    val target: NamedApiResource,
    val type: NamedApiResource,
    val machines: List<MachineVersionDetail>
)

data class ContestComboSets(
    @SerializedName("normal")
    val normalSet: ContestComboDetail,
    @SerializedName("super")
    val superSet: ContestComboDetail
)

data class ContestComboDetail(
    val useBefore: List<NamedApiResource>?,
    val useAfter: List<NamedApiResource>?
)

data class MoveMetaData(
    val ailment: NamedApiResource,
    val category: NamedApiResource,
    val minHits: Int?,
    val maxHits: Int?,
    val minTurns: Int?,
    val maxTurns: Int?,
    val drain: Int,
    val healing: Int,
    val critRate: Int,
    val ailmentChance: Int,
    val flinchChance: Int,
    val statChance: Int
)

data class MoveStatChange(
    val change: Int,
    val stat: NamedApiResource
)

data class PastMoveStatValues(
    val accuracy: Int?,
    val effectChance: Int?,
    val power: Int?,
    val pp: Int?,
    val effectEntries: List<VerboseEffect>,
    val type: NamedApiResource?,
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
    val versionGroups: List<NamedApiResource>
)

data class MoveTarget(
    val id: Int,
    val name: String,
    val descriptions: List<Description>,
    val moves: List<NamedApiResource>,
    val names: List<Name>
)
