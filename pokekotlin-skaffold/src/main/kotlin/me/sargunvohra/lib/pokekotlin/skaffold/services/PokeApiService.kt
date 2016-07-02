package me.sargunvohra.lib.pokekotlin.skaffold.services

import me.sargunvohra.lib.pokekotlin.model.ResourceSummary
import me.sargunvohra.lib.pokekotlin.model.ResourceSummaryList

interface PokeApiService<S : ResourceSummary, out D> {

    fun getResource(id: Int): D

    fun getResourceList(offset: Int, limit: Int): ResourceSummaryList<S>
}