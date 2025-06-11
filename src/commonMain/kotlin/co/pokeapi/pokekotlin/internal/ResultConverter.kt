package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

internal class ResultConverter(private val typeData: TypeData) :
  Converter.SuspendResponseConverter<HttpResponse, Result<Any>> {

  override suspend fun convert(result: KtorfitResult): Result<Any> {
    return when (result) {
      is KtorfitResult.Failure -> Result.failure(result.throwable)
      is KtorfitResult.Success -> {
        when {
          result.response.status.isSuccess() ->
            Result.success(result.response.body(typeData.typeArgs.first().typeInfo))
          // we configure the client with expectSuccess
          else -> error("impossible: " + result.response)
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
