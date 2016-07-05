package me.sargunvohra.lib.pokekotlin.util

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import me.sargunvohra.lib.pokekotlin.model.ApiResource
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import java.lang.reflect.Type

private fun urlToId(url: String): Int {
    return "\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

private fun urlToCat(url: String): String {
    return "\\/[a-z\\-]+\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isLetter() || it == '-' }
}

internal class ApiResourceAdapter : JsonDeserializer<ApiResource> {

    data class Json(val url: String)

    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): ApiResource {
        val temp = context.deserialize<Json>(element, TypeToken.get(Json::class.java).type)
        return ApiResource(category = urlToCat(temp.url), id = urlToId(temp.url))
    }
}

internal class NamedApiResourceAdapter : JsonDeserializer<NamedApiResource> {

    data class Json(val name: String, val url: String)

    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): NamedApiResource {
        val temp = context.deserialize<Json>(element, TypeToken.get(Json::class.java).type)
        return NamedApiResource(name = temp.name, category = urlToCat(temp.url), id = urlToId(temp.url))
    }
}