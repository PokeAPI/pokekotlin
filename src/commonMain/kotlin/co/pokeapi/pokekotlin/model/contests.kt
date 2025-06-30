package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

/**
 * Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests. See:
 * https://pokeapi.co/docs/v2#contest-types
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param berryFlavor The berry flavor that correlates with this contest type.
 * @param names The name of this resource listed in different languages and colors.
 */
@Serializable
@JsOnlyExport
public data class ContestType(
  val id: Int,
  val name: String,
  val berryFlavor: NamedApiResource,
  val names: List<ContestName>,
)

/**
 * The name of a contest type listed in different languages and colors. See:
 * https://pokeapi.co/docs/v2#contestname
 *
 * @param name The name for this contest type in this language.
 * @param color A detail color value that is used for this contest type in various game UIs.
 * @param language The language that this name is in.
 */
@Serializable
@JsOnlyExport
public data class ContestName(val name: String, val color: String, val language: NamedApiResource)

/**
 * Contest effects refer to the effects of moves when used in contests. See:
 * https://pokeapi.co/docs/v2#contest-effects
 *
 * @param id The identifier for this resource.
 * @param appeal The base number of hearts the user of this move gets.
 * @param jam The base number of hearts the user's opponent loses.
 * @param effectEntries The result of this contest effect listed in different languages.
 * @param flavorTextEntries The flavor text of this contest effect listed in different languages.
 */
@Serializable
@JsOnlyExport
public data class ContestEffect(
  val id: Int,
  val appeal: Int,
  val jam: Int,
  val effectEntries: List<Effect>,
  val flavorTextEntries: List<FlavorText>,
)

/**
 * Super contest effects refer to the effects of moves when used in super contests. See:
 * https://pokeapi.co/docs/v2#super-contest-effects
 *
 * @param id The identifier for this resource.
 * @param appeal The level of appeal this super contest effect has.
 * @param flavorTextEntries The flavor text of this super contest effect listed in different
 *   languages.
 * @param moves A list of moves that have this super contest effect.
 */
@Serializable
@JsOnlyExport
public data class SuperContestEffect(
  val id: Int,
  val appeal: Int,
  val flavorTextEntries: List<FlavorText>,
  val moves: List<NamedApiResource>,
)
