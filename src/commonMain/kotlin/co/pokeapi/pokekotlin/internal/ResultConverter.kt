package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

internal class ResultConverter(private val typeData: TypeData) :
  Converter.SuspendResponseConverter<HttpResponse, Result<Any>> {

  private suspend fun HttpResponse.toException(): Throwable {
    val exceptionResponseText = runCatching { bodyAsText() }.getOrElse { "<body failed decoding>" }
    return when (status.value) {
      in 300..399 -> RedirectResponseException(this, exceptionResponseText)
      in 400..499 -> ClientRequestException(this, exceptionResponseText)
      in 500..599 -> ServerResponseException(this, exceptionResponseText)
      else -> ResponseException(this, exceptionResponseText)
    }
  }

  override suspend fun convert(result: KtorfitResult): Result<Any> {
    return when (result) {
      is KtorfitResult.Failure -> Result.failure(result.throwable)
      is KtorfitResult.Success -> {
        when {
          result.response.status.isSuccess() ->
            Result.success(result.response.body(typeData.typeArgs.first().typeInfo))
          else -> Result.failure(result.response.toException())
        }
      }
    }
  }

  internal object Factory : Converter.Factory {
    override fun suspendResponseConverter(typeData: TypeData, ktorfit: Ktorfit): ResultConverter? {
      return if (typeData.typeInfo.type != Result::class) null else ResultConverter(typeData)
    }
  }
}
