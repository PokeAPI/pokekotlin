package co.pokeapi.pokekotlin.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Move(
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
  val machines: List<MachineVersionDetail>,
  val flavorTextEntries: List<MoveFlavorText>,
)

@Serializable
public data class ContestComboSets(
  @SerialName("normal") val normalSet: ContestComboDetail,
  @SerialName("super") val superSet: ContestComboDetail,
)

@Serializable
public data class ContestComboDetail(
  val useBefore: List<NamedApiResource>?,
  val useAfter: List<NamedApiResource>?,
)

@Serializable
public data class MoveMetaData(
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
  val statChance: Int,
)

@Serializable public data class MoveStatChange(val change: Int, val stat: NamedApiResource)

@Serializable
public data class PastMoveStatValues(
  val accuracy: Int?,
  val effectChance: Int?,
  val power: Int?,
  val pp: Int?,
  val effectEntries: List<VerboseEffect>,
  val type: NamedApiResource?,
  val versionGroup: NamedApiResource,
)

@Serializable
public data class MoveAilment(
  val id: Int,
  val name: String,
  val moves: List<NamedApiResource>,
  val names: List<Name>,
)

@Serializable
public data class MoveBattleStyle(val id: Int, val name: String, val names: List<Name>)

@Serializable
public data class MoveCategory(
  val id: Int,
  val name: String,
  val moves: List<NamedApiResource>,
  val descriptions: List<Description>,
)

@Serializable
public data class MoveDamageClass(
  val id: Int,
  val name: String,
  val descriptions: List<Description>,
  val moves: List<NamedApiResource>,
  val names: List<Name>,
)

@Serializable
public data class MoveLearnMethod(
  val id: Int,
  val name: String,
  val descriptions: List<Description>,
  val names: List<Name>,
  val versionGroups: List<NamedApiResource>,
)

@Serializable
public data class MoveTarget(
  val id: Int,
  val name: String,
  val descriptions: List<Description>,
  val moves: List<NamedApiResource>,
  val names: List<Name>,
)

@Serializable
public data class MoveFlavorText(
  val flavorText: String,
  val language: NamedApiResource,
  val versionGroup: NamedApiResource,
)
