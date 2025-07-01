package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Moves are the skills of Pokémon in battle. In battle, a Pokémon uses one move each turn. Some
 * moves (including those learned by Hidden Machine) can be used outside of battle as well, usually
 * for the purpose of removing obstacles or exploring new areas. See:
 * https://pokeapi.co/docs/v2#moves
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param accuracy The percent value of how likely this move is to be successful.
 * @param effectChance The percent value of how likely it is this move's effect will happen.
 * @param pp Power points. The number of times this move can be used.
 * @param priority A value between -8 and 8. Sets the order in which moves are executed during
 *   battle.
 * @param power The base power of this move with a value of 0 if it does not have a base power.
 * @param contestCombos A detail of normal and super contest combos that require this move.
 * @param contestType The type of appeal this move gives a Pokémon when used in a contest.
 * @param contestEffect The effect the move has when used in a contest.
 * @param superContestEffect The effect the move has when used in a super contest.
 * @param damageClass The type of damage the move inflicts on the target, e.g. physical.
 * @param effectEntries The list of previous effects this move has had across version groups of the
 *   games.
 * @param effectChanges The list of changes that have been made to the move's effect.
 * @param generation The generation in which this move was introduced.
 * @param learnedByPokemon List of Pokémon that can learn this move.
 * @param meta Metadata about this move.
 * @param names The name of this resource listed in different languages.
 * @param pastValues A list of move resource value changes across version groups of the game.
 * @param statChanges List of stat changes this move causes.
 * @param target The type of target that this move is directed at.
 * @param type The elemental type of this move.
 * @param machines A list of the machines that teach this move.
 * @param flavorTextEntries The flavor text of this move listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class Move(
  override val id: Int,
  override val name: String,
  val accuracy: Int?,
  val effectChance: Int?,
  val pp: Int?,
  val priority: Int,
  val power: Int?,
  val contestCombos: ContestComboSets?,
  val contestType: Handle.Named<ContestType>?,
  val contestEffect: Handle.Unnamed<ContestEffect>?,
  val superContestEffect: Handle.Unnamed<SuperContestEffect>?,
  val damageClass: Handle.Named<MoveDamageClass>,
  val effectEntries: List<VerboseEffect>,
  val effectChanges: List<AbilityEffectChange>,
  val generation: Handle.Named<Generation>,
  val learnedByPokemon: List<Handle.Named<PokemonVariety>>,
  val meta: MoveMetaData?,
  val names: List<Name>,
  val pastValues: List<PastMoveStatValues>,
  val statChanges: List<MoveStatChange>,
  val target: Handle.Named<MoveTarget>,
  val type: Handle.Named<Type>,
  val machines: List<MachineVersionDetail>,
  val flavorTextEntries: List<MoveFlavorText>,
) : NamedModel

/**
 * Information about normal and super contest combos for moves. See:
 * https://pokeapi.co/docs/v2#contestcombosets
 *
 * @param normalSet The normal contest combo detail.
 * @param superSet The super contest combo detail.
 */
@Serializable
@JsNonWasmExport
public data class ContestComboSets(
  @SerialName("normal") val normalSet: ContestComboDetail,
  @SerialName("super") val superSet: ContestComboDetail,
)

/**
 * Information about moves that can be used before or after this move in contests. See:
 * https://pokeapi.co/docs/v2#contestcombodetail
 *
 * @param useBefore A list of moves that can be used before this move.
 * @param useAfter A list of moves that can be used after this move.
 */
@Serializable
@JsNonWasmExport
public data class ContestComboDetail(
  val useBefore: List<Handle.Named<Move>>?,
  val useAfter: List<Handle.Named<Move>>?,
)

/**
 * Additional metadata and statistics for a move. See: https://pokeapi.co/docs/v2#movemetadata
 *
 * @param ailment The status ailment this move inflicts on its target.
 * @param category The category of move this move falls under, e.g. damage or ailment.
 * @param minHits The minimum number of times this move hits. Null if it always hits once.
 * @param maxHits The maximum number of times this move hits. Null if it always hits once.
 * @param minTurns The minimum number of turns this move continues to take effect. Null if it always
 *   lasts one turn.
 * @param maxTurns The maximum number of turns this move continues to take effect. Null if it always
 *   lasts one turn.
 * @param drain HP drain (if positive) or Recoil damage (if negative), in percent of damage dealt.
 * @param healing The amount of hp gained by the attacking Pokemon, in percent of it's maximum HP.
 * @param critRate Critical hit rate bonus.
 * @param ailmentChance The likelihood this attack will cause an ailment.
 * @param flinchChance The likelihood this attack will cause the target Pokémon to flinch.
 * @param statChance The likelihood this attack will cause a stat change in the target Pokémon.
 */
@Serializable
@JsNonWasmExport
public data class MoveMetaData(
  val ailment: Handle.Named<MoveAilment>,
  val category: Handle.Named<MoveCategory>,
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

/**
 * A stat change that can be caused by a move. See: https://pokeapi.co/docs/v2#movestatchange
 *
 * @param change The amount of change.
 * @param stat The stat being affected.
 */
@Serializable
@JsNonWasmExport
public data class MoveStatChange(val change: Int, val stat: Handle.Named<Stat>)

/**
 * The stat values of a move in previous versions of the games. See:
 * https://pokeapi.co/docs/v2#pastmovestatvalues
 *
 * @param accuracy The percent value of how likely this move is to be successful.
 * @param effectChance The percent value of how likely it is this move's effect will happen.
 * @param power The base power of this move with a value of 0 if it does not have a base power.
 * @param pp Power points. The number of times this move can be used.
 * @param effectEntries The previous effects of this move listed in different languages.
 * @param type The elemental type of this move.
 * @param versionGroup The version group in which these move stat values were in effect.
 */
@Serializable
@JsNonWasmExport
public data class PastMoveStatValues(
  val accuracy: Int?,
  val effectChance: Int?,
  val power: Int?,
  val pp: Int?,
  val effectEntries: List<VerboseEffect>,
  val type: Handle.Named<Type>?,
  val versionGroup: Handle.Named<VersionGroup>,
)

/**
 * Status conditions that can be inflicted on a Pokémon by using certain moves. See:
 * https://pokeapi.co/docs/v2#move-ailments
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param moves A list of moves that cause this ailment.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class MoveAilment(
  override val id: Int,
  override val name: String,
  val moves: List<Handle.Named<Move>>,
  val names: List<Name>,
) : NamedModel

/**
 * Styles of moves when used in the Battle Palace. See the bulbapedia article for greater detail.
 * See: https://pokeapi.co/docs/v2#move-battle-styles
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class MoveBattleStyle(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
) : NamedModel

/**
 * Very general categories that loosely group move effects. See:
 * https://pokeapi.co/docs/v2#move-categories
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param moves A list of moves that fall into this category.
 * @param descriptions The description of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class MoveCategory(
  override val id: Int,
  override val name: String,
  val moves: List<Handle.Named<Move>>,
  val descriptions: List<Description>,
) : NamedModel

/**
 * Damage classes moves can have, e.g. physical, special, or non-damaging. See:
 * https://pokeapi.co/docs/v2#move-damage-classes
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param descriptions The description of this resource listed in different languages.
 * @param moves A list of moves that fall into this damage class.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class MoveDamageClass(
  override val id: Int,
  override val name: String,
  val descriptions: List<Description>,
  val moves: List<Handle.Named<Move>>,
  val names: List<Name>,
) : NamedModel

/**
 * Methods by which Pokémon can learn moves. See: https://pokeapi.co/docs/v2#move-learn-methods
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param descriptions The description of this resource listed in different languages.
 * @param names The name of this resource listed in different languages.
 * @param versionGroups A list of version groups where this learn method is available.
 */
@Serializable
@JsNonWasmExport
public data class MoveLearnMethod(
  override val id: Int,
  override val name: String,
  val descriptions: List<Description>,
  val names: List<Name>,
  val versionGroups: List<Handle.Named<VersionGroup>>,
) : NamedModel

/**
 * Information about different types of targets that moves can be directed at during battle. Targets
 * can be Pokémon, environments or even other moves. See: https://pokeapi.co/docs/v2#move-targets
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param descriptions The description of this resource listed in different languages.
 * @param moves A list of moves that are directed at this target.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class MoveTarget(
  override val id: Int,
  override val name: String,
  val descriptions: List<Description>,
  val moves: List<Handle.Named<Move>>,
  val names: List<Name>,
) : NamedModel

/**
 * The flavor text of a move listed in different languages and version groups. See:
 * https://pokeapi.co/docs/v2#moveflavortext
 *
 * @param flavorText The localized flavor text for an API resource in a specific language.
 * @param language The language this name is in.
 * @param versionGroup The version group that uses this flavor text.
 */
@Serializable
@JsNonWasmExport
public data class MoveFlavorText(
  val flavorText: String,
  val language: Handle.Named<Language>,
  val versionGroup: Handle.Named<VersionGroup>,
)
