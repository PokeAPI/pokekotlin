package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Berry(
        val id: Int,
        val name: String,
        @Json(name = "growth_time")
        val growthTime: Int,
        @Json(name = "max_harvest")
        val maxHarvest: Int,
        @Json(name = "natural_gift_power")
        val naturalGiftPower: Int,
        val size: Int,
        val smoothness: Int,
        @Json(name = "soil_dryness")
        val soilDryness: Int,
        val firmness: NamedApiResource<BerryFirmness>,
        val flavors: List<BerryFlavorMap>,
        val item: NamedApiResource<Item>,
        @Json(name = "natural_gift_type")
        val naturalGiftType: NamedApiResource<Type>
)

data class BerryFlavorMap(
        val potency: Int,
        val flavor: NamedApiResource<BerryFlavor>
)

data class BerryFirmness(
        val id: Int,
        val name: String,
        val berries: List<NamedApiResource<Berry>>,
        val names: List<Name>
)

data class BerryFlavor(
        val id: Int,
        val name: String,
        val berries: List<FlavorBerryMap>,
        val contest_type: NamedApiResource<ContestType>,
        val names: List<Name>
)

data class FlavorBerryMap(
        val potency: Int,
        val berry: NamedApiResource<Berry>
)