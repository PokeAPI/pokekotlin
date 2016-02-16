package me.sargunvohra.lib.pokekotlin.api

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task
import retrofit2.Call

val <T> Call<T>.promise: Promise<T, Exception>
    get() = task {
        this.execute().body()
    }