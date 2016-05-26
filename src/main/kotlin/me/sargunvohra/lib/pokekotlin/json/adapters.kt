package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

private  fun urlToId(url: String): Int {
    return "\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
}

private fun urlToCat(url: String): String {
    return "\\/[a-z\\-]+\\/-?[0-9]+\\/$".toRegex().find(url)!!.value.filter { it.isLetter() || it == '-' }
}

class ApiResourceAdapter {

    data class Json(val url: String)

    @FromJson
    fun fromJson(json: Json): ApiResource = ApiResource(urlToCat(json.url), urlToId(json.url))

    @ToJson
    fun toJson(res: ApiResource): Json = throw UnsupportedOperationException("ApiResource to Json")
}

class NamedApiResourceAdapter {

    data class Json(val name: String, val url: String)

    @FromJson
    fun fromJson(json: Json): NamedApiResource = NamedApiResource(json.name, urlToCat(json.url), urlToId(json.url))

    @ToJson
    fun toJson(res: NamedApiResource): Json = throw UnsupportedOperationException("NamedApiResource to Json")
}