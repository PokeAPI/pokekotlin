package dev.sargunv.pokekotlin.auth

public class ApiKeyAuth(private val location: String, public val paramName: String) : Authentication {
    public var apiKey: String? = null
    public var apiKeyPrefix: String? = null

    override fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>) {
        val key: String = apiKey ?: return
        val prefix: String? = apiKeyPrefix
        val value: String = if (prefix != null) "$prefix $key" else key
        when (location) {
            "query" -> query[paramName] = listOf(value)
            "header" -> headers[paramName] = value
        }
    }
}
