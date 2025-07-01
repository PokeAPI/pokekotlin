package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.Serializable

/**
 * Berries are small fruits that can provide HP and status condition restoration, stat enhancement,
 * and even damage negation when eaten by Pokémon. See: https://pokeapi.co/docs/v2#berries
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param growthTime Time it takes the tree to grow one stage, in hours. Berry trees go through four
 *   of these growth stages before they can be picked.
 * @param maxHarvest The maximum number of these berries that can grow on one tree in Generation IV.
 * @param naturalGiftPower The power of the move "Natural Gift" when used with this Berry.
 * @param size The size of this Berry, in millimeters.
 * @param smoothness The smoothness of this Berry, used in making Pokéblocks or Poffins.
 * @param soilDryness The speed at which this Berry dries out the soil as it grows. A higher rate
 *   means the soil dries more quickly.
 * @param firmness The firmness of this berry, used in making Pokéblocks or Poffins.
 * @param flavors A list of references to each flavor a berry can have and the potency of each of
 *   those flavors in regard to this berry.
 * @param item Berries are actually items. This is a reference to the item specific data for this
 *   berry.
 * @param naturalGiftType The type inherited by "Natural Gift" when used with this Berry.
 */
@Serializable
@JsNonWasmExport
public data class Berry(
  override val id: Int,
  override val name: String,
  val growthTime: Int,
  val maxHarvest: Int,
  val naturalGiftPower: Int,
  val size: Int,
  val smoothness: Int,
  val soilDryness: Int,
  val firmness: Handle.Named<BerryFirmness>,
  val flavors: List<BerryFlavorMap>,
  val item: Handle.Named<Item>,
  val naturalGiftType: Handle.Named<Type>,
) : NamedModel

/**
 * A flavor-to-potency mapping for a berry. See: https://pokeapi.co/docs/v2#berryflavormap
 *
 * @param potency How powerful the referenced flavor is for this berry.
 * @param flavor The referenced berry flavor.
 */
@Serializable
@JsNonWasmExport
public data class BerryFlavorMap(val potency: Int, val flavor: Handle.Named<BerryFlavor>)

/**
 * The firmness of berries, used in making Pokéblocks or Poffins. See:
 * https://pokeapi.co/docs/v2#berry-firmness
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param berries A list of the berries with this firmness.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class BerryFirmness(
  override val id: Int,
  override val name: String,
  val berries: List<Handle.Named<Berry>>,
  val names: List<Name>,
) : NamedModel

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their
 * nature. See: https://pokeapi.co/docs/v2#berry-flavors
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param berries A list of the berries with this flavor.
 * @param contestType The contest type that correlates with this berry flavor.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsNonWasmExport
public data class BerryFlavor(
  override val id: Int,
  override val name: String,
  val berries: List<FlavorBerryMap>,
  val contestType: Handle.Named<ContestType>,
  val names: List<Name>,
) : NamedModel

/**
 * A berry-to-potency mapping for a flavor. See: https://pokeapi.co/docs/v2#flavorberrymap
 *
 * @param potency How powerful the referenced berry is for this flavor.
 * @param berry The referenced berry.
 */
@Serializable
@JsNonWasmExport
public data class FlavorBerryMap(val potency: Int, val berry: Handle.Named<Berry>)
