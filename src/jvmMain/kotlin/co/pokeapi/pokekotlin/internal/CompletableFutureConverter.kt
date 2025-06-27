package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.statement.*
import java.util.concurrent.CompletableFuture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.future.future

internal class CompletableFutureConverter(typeData: TypeData, private val scope: CoroutineScope) :
  Converter.ResponseConverter<HttpResponse, CompletableFuture<*>> {

  private val resultConverter = ResultConverter(typeData)

  @OptIn(DelicateCoroutinesApi::class)
  override fun convert(getResponse: suspend () -> HttpResponse): CompletableFuture<*> {
    return scope.future {
      val result =
        try {
          KtorfitResult.Success(getResponse())
        } catch (throwable: Throwable) {
          KtorfitResult.Failure(throwable)
        }
      resultConverter.convert(result).getOrThrow()
    }
  }

  internal class Factory(private val scope: CoroutineScope) : Converter.Factory {
    override fun responseConverter(
      typeData: TypeData,
      ktorfit: Ktorfit,
    ): CompletableFutureConverter? {
      return if (typeData.typeInfo.type != CompletableFuture::class) null
      else CompletableFutureConverter(typeData, scope)
    }
  }
}
