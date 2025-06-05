package dev.sargunv.pokekotlin.auth

import io.ktor.util.encodeBase64

public class HttpBasicAuth : Authentication {
    public var username: String? = null
    public var password: String? = null

    override fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>) {
        if (username == null && password == null) return
        val str = (username ?: "") + ":" + (password ?: "")
        val auth = str.encodeBase64()
        headers["Authorization"] = "Basic $auth"
    }
}
