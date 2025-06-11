package co.pokeapi.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
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

@Serializable public data class BerryFlavorMap(val potency: Int, val flavor: NamedApiResource)

@Serializable
public data class BerryFirmness(
  val id: Int,
  val name: String,
  val berries: List<NamedApiResource>,
  val names: List<Name>,
)

@Serializable
public data class BerryFlavor(
  val id: Int,
  val name: String,
  val berries: List<FlavorBerryMap>,
  val contestType: NamedApiResource,
  val names: List<Name>,
)

@Serializable public data class FlavorBerryMap(val potency: Int, val berry: NamedApiResource)
