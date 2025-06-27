package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.statement.HttpResponse
import java.util.concurrent.Future
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

internal class FutureConverter(typeData: TypeData) :
  Converter.ResponseConverter<HttpResponse, Future<*>> {

  private val resultConverter = ResultConverter(typeData)

  @OptIn(DelicateCoroutinesApi::class)
  override fun convert(getResponse: suspend () -> HttpResponse): Future<*> {
    // safe to use GlobalScope as it'll be the Java code's responsibility to handle the future
    return GlobalScope.future {
      val result =
        try {
          KtorfitResult.Success(getResponse())
        } catch (throwable: Throwable) {
          KtorfitResult.Failure(throwable)
        }
      resultConverter.convert(result).getOrThrow()
    }
  }

  internal object Factory : Converter.Factory {
    override fun responseConverter(typeData: TypeData, ktorfit: Ktorfit): FutureConverter? {
      return if (typeData.typeInfo.type != Future::class) null else FutureConverter(typeData)
    }
  }
}
