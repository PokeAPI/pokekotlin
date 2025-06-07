package dev.sargunv.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import dev.sargunv.pokekotlin.PokeApiException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

internal class PokeApiConverter(private val typeData: TypeData) :
  Converter.SuspendResponseConverter<HttpResponse, Any> {
  override suspend fun convert(result: KtorfitResult): Any {
    return when (result) {
      is KtorfitResult.Failure -> throw PokeApiException.UnknownException(result.throwable)
      is KtorfitResult.Success -> {
        val status = result.response.status
        when {
          status.isSuccess() -> result.response.body<Any>(typeData.typeInfo)
          else -> throw PokeApiException.HttpStatus(status)
        }
      }
    }
  }

  internal object Factory : Converter.Factory {
    override fun suspendResponseConverter(
      typeData: TypeData,
      ktorfit: Ktorfit,
    ): Converter.SuspendResponseConverter<HttpResponse, Any> = PokeApiConverter(typeData)
  }
}
