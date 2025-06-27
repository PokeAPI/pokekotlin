package co.pokeapi.pokekotlin.java

import co.pokeapi.pokekotlin.internal.CompletableFutureConverter
import co.pokeapi.pokekotlin.internal.createPokeApiKtorfitBuilder
import co.pokeapi.pokekotlin.internal.getDefaultEngine
import co.pokeapi.pokekotlin.model.*
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.cache.storage.*
import java.util.concurrent.CompletableFuture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

public interface PokeApi {

  private companion object {
    @JvmStatic val default: PokeApi by lazy { create() }

    @OptIn(DelicateCoroutinesApi::class)
    @JvmStatic
    @JvmOverloads
    fun create(
      baseUrl: String = "https://pokeapi.co/api/v2/",
      cacheStorage: CacheStorage? = null,
      engine: HttpClientEngine = getDefaultEngine(),
      coroutineScope: CoroutineScope = GlobalScope,
      configure: HttpClientConfig<*>.() -> Unit = {},
    ): PokeApi {
      return createPokeApiKtorfitBuilder(
          baseUrl = baseUrl,
          cacheStorage = cacheStorage,
          engine = engine,
          configure = configure,
        )
        .converterFactories(CompletableFutureConverter.Factory(coroutineScope))
        .build()
        .createPokeApi()
    }
  }

  // region Resource Lists

  // region Berries

  @GET("berry/")
  public fun getBerryListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("berry-firmness/")
  public fun getBerryFirmnessListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("berry-flavor/")
  public fun getBerryFlavorListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  public fun getContestTypeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("contest-effect/")
  public fun getContestEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<ApiResourceList>

  @GET("super-contest-effect/")
  public fun getSuperContestEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  public fun getEncounterMethodListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("encounter-condition/")
  public fun getEncounterConditionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("encounter-condition-value/")
  public fun getEncounterConditionValueListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  public fun getEvolutionChainListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<ApiResourceList>

  @GET("evolution-trigger/")
  public fun getEvolutionTriggerListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Games

  @GET("generation/")
  public fun getGenerationListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokedex/")
  public fun getPokedexListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("version/")
  public fun getVersionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("version-group/")
  public fun getVersionGroupListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  public fun getItemListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("item-attribute/")
  public fun getItemAttributeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("item-category/")
  public fun getItemCategoryListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("item-fling-effect/")
  public fun getItemFlingEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("item-pocket/")
  public fun getItemPocketListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Moves

  @GET("move/")
  public fun getMoveListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-ailment/")
  public fun getMoveAilmentListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-battle-style/")
  public fun getMoveBattleStyleListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-category/")
  public fun getMoveCategoryListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-damage-class/")
  public fun getMoveDamageClassListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-learn-method/")
  public fun getMoveLearnMethodListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("move-target/")
  public fun getMoveTargetListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  public fun getLocationListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("location-area/")
  public fun getLocationAreaListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pal-park-area/")
  public fun getPalParkAreaListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("region/")
  public fun getRegionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  public fun getMachineListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  public fun getAbilityListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("characteristic/")
  public fun getCharacteristicListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<ApiResourceList>

  @GET("egg-group/")
  public fun getEggGroupListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("gender/")
  public fun getGenderListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("growth-rate/")
  public fun getGrowthRateListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("nature/")
  public fun getNatureListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  public fun getPokeathlonStatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon/")
  public fun getPokemonListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon-color/")
  public fun getPokemonColorListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon-form/")
  public fun getPokemonFormListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon-habitat/")
  public fun getPokemonHabitatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon-shape/")
  public fun getPokemonShapeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("pokemon-species/")
  public fun getPokemonSpeciesListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("stat/")
  public fun getStatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  @GET("type/")
  public fun getTypeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  public fun getLanguageListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): CompletableFuture<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") public fun getBerryAsync(@Path("id") id: Int): CompletableFuture<Berry>

  @GET("berry-firmness/{id}/")
  public fun getBerryFirmnessAsync(@Path("id") id: Int): CompletableFuture<BerryFirmness>

  @GET("berry-flavor/{id}/")
  public fun getBerryFlavorAsync(@Path("id") id: Int): CompletableFuture<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/")
  public fun getContestTypeAsync(@Path("id") id: Int): CompletableFuture<ContestType>

  @GET("contest-effect/{id}/")
  public fun getContestEffectAsync(@Path("id") id: Int): CompletableFuture<ContestEffect>

  @GET("super-contest-effect/{id}/")
  public fun getSuperContestEffectAsync(@Path("id") id: Int): CompletableFuture<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  public fun getEncounterMethodAsync(@Path("id") id: Int): CompletableFuture<EncounterMethod>

  @GET("encounter-condition/{id}/")
  public fun getEncounterConditionAsync(@Path("id") id: Int): CompletableFuture<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  public fun getEncounterConditionValueAsync(
    @Path("id") id: Int
  ): CompletableFuture<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  public fun getEvolutionChainAsync(@Path("id") id: Int): CompletableFuture<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  public fun getEvolutionTriggerAsync(@Path("id") id: Int): CompletableFuture<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/")
  public fun getGenerationAsync(@Path("id") id: Int): CompletableFuture<Generation>

  @GET("pokedex/{id}/") public fun getPokedexAsync(@Path("id") id: Int): CompletableFuture<Pokedex>

  @GET("version/{id}/") public fun getVersionAsync(@Path("id") id: Int): CompletableFuture<Version>

  @GET("version-group/{id}/")
  public fun getVersionGroupAsync(@Path("id") id: Int): CompletableFuture<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/") public fun getItemAsync(@Path("id") id: Int): CompletableFuture<Item>

  @GET("item-attribute/{id}/")
  public fun getItemAttributeAsync(@Path("id") id: Int): CompletableFuture<ItemAttribute>

  @GET("item-category/{id}/")
  public fun getItemCategoryAsync(@Path("id") id: Int): CompletableFuture<ItemCategory>

  @GET("item-fling-effect/{id}/")
  public fun getItemFlingEffectAsync(@Path("id") id: Int): CompletableFuture<ItemFlingEffect>

  @GET("item-pocket/{id}/")
  public fun getItemPocketAsync(@Path("id") id: Int): CompletableFuture<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/") public fun getMoveAsync(@Path("id") id: Int): CompletableFuture<Move>

  @GET("move-ailment/{id}/")
  public fun getMoveAilmentAsync(@Path("id") id: Int): CompletableFuture<MoveAilment>

  @GET("move-battle-style/{id}/")
  public fun getMoveBattleStyleAsync(@Path("id") id: Int): CompletableFuture<MoveBattleStyle>

  @GET("move-category/{id}/")
  public fun getMoveCategoryAsync(@Path("id") id: Int): CompletableFuture<MoveCategory>

  @GET("move-damage-class/{id}/")
  public fun getMoveDamageClassAsync(@Path("id") id: Int): CompletableFuture<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  public fun getMoveLearnMethodAsync(@Path("id") id: Int): CompletableFuture<MoveLearnMethod>

  @GET("move-target/{id}/")
  public fun getMoveTargetAsync(@Path("id") id: Int): CompletableFuture<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/")
  public fun getLocationAsync(@Path("id") id: Int): CompletableFuture<Location>

  @GET("location-area/{id}/")
  public fun getLocationAreaAsync(@Path("id") id: Int): CompletableFuture<LocationArea>

  @GET("pal-park-area/{id}/")
  public fun getPalParkAreaAsync(@Path("id") id: Int): CompletableFuture<PalParkArea>

  @GET("region/{id}/") public fun getRegionAsync(@Path("id") id: Int): CompletableFuture<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") public fun getMachineAsync(@Path("id") id: Int): CompletableFuture<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/") public fun getAbilityAsync(@Path("id") id: Int): CompletableFuture<Ability>

  @GET("characteristic/{id}/")
  public fun getCharacteristicAsync(@Path("id") id: Int): CompletableFuture<Characteristic>

  @GET("egg-group/{id}/")
  public fun getEggGroupAsync(@Path("id") id: Int): CompletableFuture<EggGroup>

  @GET("gender/{id}/") public fun getGenderAsync(@Path("id") id: Int): CompletableFuture<Gender>

  @GET("growth-rate/{id}/")
  public fun getGrowthRateAsync(@Path("id") id: Int): CompletableFuture<GrowthRate>

  @GET("nature/{id}/") public fun getNatureAsync(@Path("id") id: Int): CompletableFuture<Nature>

  @GET("pokeathlon-stat/{id}/")
  public fun getPokeathlonStatAsync(@Path("id") id: Int): CompletableFuture<PokeathlonStat>

  @GET("pokemon/{id}/") public fun getPokemonAsync(@Path("id") id: Int): CompletableFuture<Pokemon>

  @GET("pokemon/{id}/encounters/")
  public fun getPokemonEncounterListAsync(
    @Path("id") id: Int
  ): CompletableFuture<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/")
  public fun getPokemonColorAsync(@Path("id") id: Int): CompletableFuture<PokemonColor>

  @GET("pokemon-form/{id}/")
  public fun getPokemonFormAsync(@Path("id") id: Int): CompletableFuture<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  public fun getPokemonHabitatAsync(@Path("id") id: Int): CompletableFuture<PokemonHabitat>

  @GET("pokemon-shape/{id}/")
  public fun getPokemonShapeAsync(@Path("id") id: Int): CompletableFuture<PokemonShape>

  @GET("pokemon-species/{id}/")
  public fun getPokemonSpeciesAsync(@Path("id") id: Int): CompletableFuture<PokemonSpecies>

  @GET("stat/{id}/") public fun getStatAsync(@Path("id") id: Int): CompletableFuture<Stat>

  @GET("type/{id}/") public fun getTypeAsync(@Path("id") id: Int): CompletableFuture<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/")
  public fun getLanguageAsync(@Path("id") id: Int): CompletableFuture<Language>

  // endregion Utility
}
