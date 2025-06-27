package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.statement.*
import kotlin.js.Promise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.promise

internal class PromiseConverter(typeData: TypeData, private val scope: CoroutineScope) :
  Converter.ResponseConverter<HttpResponse, Promise<*>> {

  private val resultConverter = ResultConverter(typeData)

  @OptIn(DelicateCoroutinesApi::class)
  override fun convert(getResponse: suspend () -> HttpResponse): Promise<*> {
    return scope.promise {
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
    override fun responseConverter(typeData: TypeData, ktorfit: Ktorfit): PromiseConverter? {
      return PromiseConverter(typeData, scope)
    }
  }
}
