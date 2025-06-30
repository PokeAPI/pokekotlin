package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
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
@JsOnlyExport
public data class Berry(
  val id: Int,
  val name: String,
  val growthTime: Int,
  val maxHarvest: Int,
  val naturalGiftPower: Int,
  val size: Int,
  val smoothness: Int,
  val soilDryness: Int,
  val firmness: NamedApiResource,
  val flavors: List<BerryFlavorMap>,
  val item: NamedApiResource,
  val naturalGiftType: NamedApiResource,
)

/**
 * A flavor-to-potency mapping for a berry. See: https://pokeapi.co/docs/v2#berryflavormap
 *
 * @param potency How powerful the referenced flavor is for this berry.
 * @param flavor The referenced berry flavor.
 */
@Serializable
@JsOnlyExport
public data class BerryFlavorMap(val potency: Int, val flavor: NamedApiResource)

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
@JsOnlyExport
public data class BerryFirmness(
  val id: Int,
  val name: String,
  val berries: List<NamedApiResource>,
  val names: List<Name>,
)

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
@JsOnlyExport
public data class BerryFlavor(
  val id: Int,
  val name: String,
  val berries: List<FlavorBerryMap>,
  val contestType: NamedApiResource,
  val names: List<Name>,
)

/**
 * A berry-to-potency mapping for a flavor. See: https://pokeapi.co/docs/v2#flavorberrymap
 *
 * @param potency How powerful the referenced berry is for this flavor.
 * @param berry The referenced berry.
 */
@Serializable
@JsOnlyExport
public data class FlavorBerryMap(val potency: Int, val berry: NamedApiResource)
