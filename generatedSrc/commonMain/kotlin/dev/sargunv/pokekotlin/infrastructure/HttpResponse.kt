package dev.sargunv.pokekotlin.infrastructure

import io.ktor.http.Headers
import io.ktor.http.isSuccess
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.typeInfo

public open class HttpResponse<T : Any>(public val response: io.ktor.client.statement.HttpResponse, public val provider: BodyProvider<T>) {
    public val status: Int = response.status.value
    public val success: Boolean = response.status.isSuccess()
    public val headers: Map<String, List<String>> = response.headers.mapEntries()
    public suspend fun body(): T = provider.body(response)
    public suspend fun <V : Any> typedBody(type: TypeInfo): V = provider.typedBody(response, type)

    public companion object {
        private fun Headers.mapEntries(): Map<String, List<String>> {
            val result = mutableMapOf<String, List<String>>()
            entries().forEach { result[it.key] = it.value }
            return result
        }
    }
}

public interface BodyProvider<T : Any> {
    public suspend fun body(response: io.ktor.client.statement.HttpResponse): T
    public suspend fun <V : Any> typedBody(response: io.ktor.client.statement.HttpResponse, type: TypeInfo): V
}

public class TypedBodyProvider<T : Any>(private val type: TypeInfo) : BodyProvider<T> {
    @Suppress("UNCHECKED_CAST")
    override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
            response.call.body(type) as T

    @Suppress("UNCHECKED_CAST")
    override suspend fun <V : Any> typedBody(response: io.ktor.client.statement.HttpResponse, type: TypeInfo): V =
            response.call.body(type) as V
}

public class MappedBodyProvider<S : Any, T : Any>(private val provider: BodyProvider<S>, private val block: S.() -> T) : BodyProvider<T> {
    override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
            block(provider.body(response))

    override suspend fun <V : Any> typedBody(response: io.ktor.client.statement.HttpResponse, type: TypeInfo): V =
            provider.typedBody(response, type)
}

public inline fun <reified T : Any> io.ktor.client.statement.HttpResponse.wrap(): HttpResponse<T> =
        HttpResponse(this, TypedBodyProvider(typeInfo<T>()))

public fun <T : Any, V : Any> HttpResponse<T>.map(block: T.() -> V): HttpResponse<V> =
        HttpResponse(response, MappedBodyProvider(provider, block))
