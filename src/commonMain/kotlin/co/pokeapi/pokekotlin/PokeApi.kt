package co.pokeapi.pokekotlin

import co.pokeapi.pokekotlin.internal.ResultConverter
import co.pokeapi.pokekotlin.internal.createPokeApiKtorfitBuilder
import co.pokeapi.pokekotlin.internal.getDefaultEngine
import co.pokeapi.pokekotlin.model.*
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.cache.storage.*

public fun createPokeApi(
  baseUrl: String = "https://pokeapi.co/api/v2/",
  cacheStorage: CacheStorage? = null,
  engine: HttpClientEngine = getDefaultEngine(),
  configure: HttpClientConfig<*>.() -> Unit = {},
): PokeApi {
  return createPokeApiKtorfitBuilder(
      baseUrl = baseUrl,
      cacheStorage = cacheStorage,
      engine = engine,
      configure = configure,
    )
    .converterFactories(ResultConverter.Factory)
    .build()
    .createPokeApi()
}

public interface PokeApi {
  public companion object : PokeApi by createPokeApi()

  // region Resource Lists

  // region Berries

  @GET("berry/")
  public suspend fun getBerryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("berry-firmness/")
  public suspend fun getBerryFirmnessList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("berry-flavor/")
  public suspend fun getBerryFlavorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  public suspend fun getContestTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("contest-effect/")
  public suspend fun getContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("super-contest-effect/")
  public suspend fun getSuperContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  public suspend fun getEncounterMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("encounter-condition/")
  public suspend fun getEncounterConditionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("encounter-condition-value/")
  public suspend fun getEncounterConditionValueList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  public suspend fun getEvolutionChainList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("evolution-trigger/")
  public suspend fun getEvolutionTriggerList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Games

  @GET("generation/")
  public suspend fun getGenerationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokedex/")
  public suspend fun getPokedexList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("version/")
  public suspend fun getVersionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("version-group/")
  public suspend fun getVersionGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  public suspend fun getItemList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-attribute/")
  public suspend fun getItemAttributeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-category/")
  public suspend fun getItemCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-fling-effect/")
  public suspend fun getItemFlingEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-pocket/")
  public suspend fun getItemPocketList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Moves

  @GET("move/")
  public suspend fun getMoveList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-ailment/")
  public suspend fun getMoveAilmentList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-battle-style/")
  public suspend fun getMoveBattleStyleList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-category/")
  public suspend fun getMoveCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-damage-class/")
  public suspend fun getMoveDamageClassList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-learn-method/")
  public suspend fun getMoveLearnMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-target/")
  public suspend fun getMoveTargetList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  public suspend fun getLocationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("location-area/")
  public suspend fun getLocationAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pal-park-area/")
  public suspend fun getPalParkAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("region/")
  public suspend fun getRegionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  public suspend fun getMachineList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  public suspend fun getAbilityList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("characteristic/")
  public suspend fun getCharacteristicList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("egg-group/")
  public suspend fun getEggGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("gender/")
  public suspend fun getGenderList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("growth-rate/")
  public suspend fun getGrowthRateList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("nature/")
  public suspend fun getNatureList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  public suspend fun getPokeathlonStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon/")
  public suspend fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-color/")
  public suspend fun getPokemonColorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-form/")
  public suspend fun getPokemonFormList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-habitat/")
  public suspend fun getPokemonHabitatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-shape/")
  public suspend fun getPokemonShapeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-species/")
  public suspend fun getPokemonSpeciesList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("stat/")
  public suspend fun getStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("type/")
  public suspend fun getTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  public suspend fun getLanguageList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") public suspend fun getBerry(@Path("id") id: Int): Result<Berry>

  @GET("berry-firmness/{id}/")
  public suspend fun getBerryFirmness(@Path("id") id: Int): Result<BerryFirmness>

  @GET("berry-flavor/{id}/")
  public suspend fun getBerryFlavor(@Path("id") id: Int): Result<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/")
  public suspend fun getContestType(@Path("id") id: Int): Result<ContestType>

  @GET("contest-effect/{id}/")
  public suspend fun getContestEffect(@Path("id") id: Int): Result<ContestEffect>

  @GET("super-contest-effect/{id}/")
  public suspend fun getSuperContestEffect(@Path("id") id: Int): Result<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  public suspend fun getEncounterMethod(@Path("id") id: Int): Result<EncounterMethod>

  @GET("encounter-condition/{id}/")
  public suspend fun getEncounterCondition(@Path("id") id: Int): Result<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  public suspend fun getEncounterConditionValue(
    @Path("id") id: Int
  ): Result<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  public suspend fun getEvolutionChain(@Path("id") id: Int): Result<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  public suspend fun getEvolutionTrigger(@Path("id") id: Int): Result<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/") public suspend fun getGeneration(@Path("id") id: Int): Result<Generation>

  @GET("pokedex/{id}/") public suspend fun getPokedex(@Path("id") id: Int): Result<Pokedex>

  @GET("version/{id}/") public suspend fun getVersion(@Path("id") id: Int): Result<Version>

  @GET("version-group/{id}/")
  public suspend fun getVersionGroup(@Path("id") id: Int): Result<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/") public suspend fun getItem(@Path("id") id: Int): Result<Item>

  @GET("item-attribute/{id}/")
  public suspend fun getItemAttribute(@Path("id") id: Int): Result<ItemAttribute>

  @GET("item-category/{id}/")
  public suspend fun getItemCategory(@Path("id") id: Int): Result<ItemCategory>

  @GET("item-fling-effect/{id}/")
  public suspend fun getItemFlingEffect(@Path("id") id: Int): Result<ItemFlingEffect>

  @GET("item-pocket/{id}/")
  public suspend fun getItemPocket(@Path("id") id: Int): Result<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/") public suspend fun getMove(@Path("id") id: Int): Result<Move>

  @GET("move-ailment/{id}/")
  public suspend fun getMoveAilment(@Path("id") id: Int): Result<MoveAilment>

  @GET("move-battle-style/{id}/")
  public suspend fun getMoveBattleStyle(@Path("id") id: Int): Result<MoveBattleStyle>

  @GET("move-category/{id}/")
  public suspend fun getMoveCategory(@Path("id") id: Int): Result<MoveCategory>

  @GET("move-damage-class/{id}/")
  public suspend fun getMoveDamageClass(@Path("id") id: Int): Result<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  public suspend fun getMoveLearnMethod(@Path("id") id: Int): Result<MoveLearnMethod>

  @GET("move-target/{id}/")
  public suspend fun getMoveTarget(@Path("id") id: Int): Result<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/") public suspend fun getLocation(@Path("id") id: Int): Result<Location>

  @GET("location-area/{id}/")
  public suspend fun getLocationArea(@Path("id") id: Int): Result<LocationArea>

  @GET("pal-park-area/{id}/")
  public suspend fun getPalParkArea(@Path("id") id: Int): Result<PalParkArea>

  @GET("region/{id}/") public suspend fun getRegion(@Path("id") id: Int): Result<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") public suspend fun getMachine(@Path("id") id: Int): Result<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/") public suspend fun getAbility(@Path("id") id: Int): Result<Ability>

  @GET("characteristic/{id}/")
  public suspend fun getCharacteristic(@Path("id") id: Int): Result<Characteristic>

  @GET("egg-group/{id}/") public suspend fun getEggGroup(@Path("id") id: Int): Result<EggGroup>

  @GET("gender/{id}/") public suspend fun getGender(@Path("id") id: Int): Result<Gender>

  @GET("growth-rate/{id}/")
  public suspend fun getGrowthRate(@Path("id") id: Int): Result<GrowthRate>

  @GET("nature/{id}/") public suspend fun getNature(@Path("id") id: Int): Result<Nature>

  @GET("pokeathlon-stat/{id}/")
  public suspend fun getPokeathlonStat(@Path("id") id: Int): Result<PokeathlonStat>

  @GET("pokemon/{id}/") public suspend fun getPokemon(@Path("id") id: Int): Result<Pokemon>

  @GET("pokemon/{id}/encounters/")
  public suspend fun getPokemonEncounterList(
    @Path("id") id: Int
  ): Result<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/")
  public suspend fun getPokemonColor(@Path("id") id: Int): Result<PokemonColor>

  @GET("pokemon-form/{id}/")
  public suspend fun getPokemonForm(@Path("id") id: Int): Result<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  public suspend fun getPokemonHabitat(@Path("id") id: Int): Result<PokemonHabitat>

  @GET("pokemon-shape/{id}/")
  public suspend fun getPokemonShape(@Path("id") id: Int): Result<PokemonShape>

  @GET("pokemon-species/{id}/")
  public suspend fun getPokemonSpecies(@Path("id") id: Int): Result<PokemonSpecies>

  @GET("stat/{id}/") public suspend fun getStat(@Path("id") id: Int): Result<Stat>

  @GET("type/{id}/") public suspend fun getType(@Path("id") id: Int): Result<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/") public suspend fun getLanguage(@Path("id") id: Int): Result<Language>

  // endregion Utility
}
