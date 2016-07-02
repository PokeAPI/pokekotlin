package me.sargunvohra.lib.pokekotlin.skaffold

import me.sargunvohra.lib.pokekotlin.client.ErrorResponse
import me.sargunvohra.lib.pokekotlin.model.ResourceSummary
import me.sargunvohra.lib.pokekotlin.skaffold.services.PokeApiService
import me.sargunvohra.skaffold.data.crud.RetrieveDataSource
import me.sargunvohra.skaffold.data.exception.NetworkConnectionException
import me.sargunvohra.skaffold.data.exception.NotFoundException
import rx.Observable
import rx.Single
import rx.lang.kotlin.observable
import rx.lang.kotlin.single
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class PokeApiDataSource<Summary : ResourceSummary, Detail>(
        private val service: PokeApiService<Summary, Detail>
) : RetrieveDataSource<Summary, Detail> {

    private fun mapException(exception: Throwable): Throwable {
        return when (exception) {
            is SocketTimeoutException -> NetworkConnectionException()
            is UnknownHostException -> NetworkConnectionException()
            is ErrorResponse -> when(exception.code) {
                404 -> NotFoundException()
                else -> exception
            }
            else -> throw exception
        }
    }

    override fun retrieve(key: Summary): Single<Detail> {
        return single { subscriber ->
            try {
                subscriber.onSuccess(service.getResource(key.id))
            } catch (e: Throwable) {
                subscriber.onError(mapException(e))
            }
        }
    }

    override fun retrieveAll(): Observable<Summary> {
        return observable { subscriber ->
            try {
                val emptyList = service.getResourceList(0, 0)
                val fullList = service.getResourceList(0, emptyList.count)
                fullList.results.forEach { subscriber.onNext(it) }
                subscriber.onCompleted()
            } catch (e: Throwable) {
                subscriber.onError(mapException(e))
            }
        }
    }
}