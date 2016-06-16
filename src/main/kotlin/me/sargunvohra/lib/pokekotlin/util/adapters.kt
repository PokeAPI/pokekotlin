package me.sargunvohra.lib.pokekotlin.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import me.sargunvohra.lib.pokekotlin.model.ApiResource
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource

private fun urlToId(url: String): Int {
    return "\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

private fun urlToCat(url: String): String {
    return "\\/[a-z\\-]+\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isLetter() || it == '-' }
}

class ApiResourceAdapter : JsonDeserializer<ApiResource>() {

    data class Json(val url: String)

    override fun deserialize(parser: JsonParser, ctx: DeserializationContext): ApiResource {
        val temp = parser.readValueAs(Json::class.java)
        return ApiResource(category = urlToCat(temp.url), id = urlToId(temp.url))
    }
}

class NamedApiResourceAdapter : JsonDeserializer<NamedApiResource>() {

    data class Json(val name: String, val url: String)

    override fun deserialize(parser: JsonParser, ctx: DeserializationContext): NamedApiResource {
        val temp = parser.readValueAs(Json::class.java)
        return NamedApiResource(name = temp.name, category = urlToCat(temp.url), id = urlToId(temp.url))
    }
}