package me.sargunvohra.lib.pokekotlin.json

data class JsonBerry(
        val id: Int,
        val name: String,
        val growth_time: Int,
        val max_harvest: Int,
        val natural_gift_power: Int,
        val size: Int,
        val smoothness: Int,
        val soil_dryness: Int,
        val firmness: JsonNamedApiResource<JsonBerryFirmness>,
        val flavors: List<JsonBerryFlavorMap>,
        val item: JsonNamedApiResource<JsonItem>,
        val natural_gift_type: JsonNamedApiResource<JsonType>
)

data class JsonBerryFlavorMap(
        val potency: Int,
        val flavor: JsonNamedApiResource<JsonBerryFlavor>
)

data class JsonBerryFirmness(
        val id: Int,
        val name: String,
        val berries: List<JsonNamedApiResource<JsonBerry>>,
        val names: List<JsonName>
)

data class JsonBerryFlavor(
        val id: Int,
        val name: String,
        val berries: List<JsonFlavorBerryMap>,
        val contest_type: JsonNamedApiResource<JsonContestType>,
        val names: List<JsonName>
)

data class JsonFlavorBerryMap(
        val potency: Int,
        val berry: JsonNamedApiResource<JsonBerry>
)