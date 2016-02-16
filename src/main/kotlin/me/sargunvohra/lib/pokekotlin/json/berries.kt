package me.sargunvohra.lib.pokekotlin.json

data class Berry(
        val id: Int,
        val name: String,
        val growth_time: Int,
        val max_harvest: Int,
        val natural_gift_power: Int,
        val size: Int,
        val smoothness: Int,
        val soil_dryness: Int,
        val firmness: NamedApiResource<BerryFirmness>,
        val flavors: List<BerryFlavorMap>,
        val item: NamedApiResource<Item>,
        val natural_gift_type: NamedApiResource<Type>
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