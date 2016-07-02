package me.sargunvohra.lib.pokekotlin.skaffold

import me.sargunvohra.lib.pokekotlin.model.ResourceSummary
import me.sargunvohra.lib.pokekotlin.skaffold.services.PokeApiService
import me.sargunvohra.skaffold.data.cache.Cache
import me.sargunvohra.skaffold.data.cache.MemoryCache
import me.sargunvohra.skaffold.data.cache.SingleCache
import me.sargunvohra.skaffold.data.cache.SingleMemoryCache
import me.sargunvohra.skaffold.data.crud.RetrieveDataSource
import me.sargunvohra.skaffold.data.repository.CachingRepository

class PokeApiRepository<Summary : ResourceSummary, Detail>(
        service: PokeApiService<Summary, Detail>,
        itemCache: Cache<Summary, Detail> = MemoryCache(),
        itemListCache: SingleCache<List<Summary>> = SingleMemoryCache()
) : RetrieveDataSource<Summary, Detail> by CachingRepository(PokeApiDataSource(service), itemCache, itemListCache)