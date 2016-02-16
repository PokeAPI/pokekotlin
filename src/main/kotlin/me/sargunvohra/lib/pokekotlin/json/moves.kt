package me.sargunvohra.lib.pokekotlin.json

data class Move(
        val id: Int,
        val name: String,
        val accuracy: Int,
        val effect_chance: Int,
        val pp: Int,
        val priority: Int,
        val power: Int,
        val contest_combos: List<ContestComboSets>,
        val contest_type: ContestType,
        val contest_effect: NamedApiResource<ContestEffect>,
        val damage_class: NamedApiResource<MoveDamageClass>,
        val effect_entries: List<VerboseEffect>,
        val effect_changes: List<AbilityEffectChange>,
        val generation: NamedApiResource<Generation>,
        val meta: MoveMetaData,
        val names: List<Name>,
        val past_values: List<PastMoveStatValues>,
        val stat_changes: List<MoveStatChange>,
        val target: MoveTarget,
        val type: Type
)

data class ContestComboSets(
        val normal: List<ContestComboDetail>,
        val `super`: List<ContestComboDetail>
)

data class ContestComboDetail(
        val use_before: List<NamedApiResource<Move>>,
        val use_after: List<NamedApiResource<Move>>
)

data class MoveMetaData(
        val ailment: NamedApiResource<MoveAilment>,
        val category: NamedApiResource<Move>,
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

data class MoveStatChange(
        val change: Int,
        val stat: NamedApiResource<Stat>
)

data class PastMoveStatValues(
        val accuracy: Int,
        val effect_chance: Int,
        val power: Int,
        val pp: Int,
        val effect_entries: List<VerboseEffect>,
        val type: Type,
        val version_group: NamedApiResource<VersionGroup>
)

data class MoveAilment(
        val id: Int,
        val name: String,
        val moves: List<NamedApiResource<Move>>,
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
        val moves: List<NamedApiResource<Move>>,
        val descriptions: List<Description>
)

data class MoveDamageClass(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val moves: List<NamedApiResource<Move>>,
        val names: List<Name>
)

data class MoveLearnMethod(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val names: List<Name>,
        val version_groups: List<NamedApiResource<VersionGroup>>
)

data class MoveTarget(
        val id: Int,
        val name: String,
        val descriptions: List<Description>,
        val moves: List<NamedApiResource<Move>>,
        val names: List<Name>
)