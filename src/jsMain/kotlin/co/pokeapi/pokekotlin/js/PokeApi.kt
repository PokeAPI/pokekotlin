package co.pokeapi.pokekotlin.js

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import co.pokeapi.pokekotlin.internal.PromiseConverter
import co.pokeapi.pokekotlin.internal.createPokeApiKtorfitBuilder
import co.pokeapi.pokekotlin.internal.getDefaultEngine
import co.pokeapi.pokekotlin.model.*
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlin.js.Promise
import kotlinx.coroutines.GlobalScope

@JsOnlyExport
@JsName("createPokeApi")
public fun createPokeApiJs(baseUrl: String = "https://pokeapi.co/api/v2/"): PokeApiJs {

  return createPokeApiKtorfitBuilder(
      baseUrl = baseUrl,
      cacheStorage = null,
      engine = getDefaultEngine(),
      configure = {},
    )
    .converterFactories(PromiseConverter.Factory(@Suppress("OPT_IN_USAGE") GlobalScope))
    .build()
    .createPokeApiJs()
}

@JsOnlyExport
@JsName("PokeApi")
public interface PokeApiJs {

  // region Resource Lists

  // region Berries

  @GET("berry/")
  public fun getBerryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("berry-firmness/")
  public fun getBerryFirmnessList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("berry-flavor/")
  public fun getBerryFlavorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  public fun getContestTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("contest-effect/")
  public fun getContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<ApiResourceList>

  @GET("super-contest-effect/")
  public fun getSuperContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  public fun getEncounterMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("encounter-condition/")
  public fun getEncounterConditionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("encounter-condition-value/")
  public fun getEncounterConditionValueList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  public fun getEvolutionChainList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<ApiResourceList>

  @GET("evolution-trigger/")
  public fun getEvolutionTriggerList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Games

  @GET("generation/")
  public fun getGenerationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokedex/")
  public fun getPokedexList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("version/")
  public fun getVersionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("version-group/")
  public fun getVersionGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  public fun getItemList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("item-attribute/")
  public fun getItemAttributeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("item-category/")
  public fun getItemCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("item-fling-effect/")
  public fun getItemFlingEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("item-pocket/")
  public fun getItemPocketList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Moves

  @GET("move/")
  public fun getMoveList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-ailment/")
  public fun getMoveAilmentList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-battle-style/")
  public fun getMoveBattleStyleList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-category/")
  public fun getMoveCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-damage-class/")
  public fun getMoveDamageClassList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-learn-method/")
  public fun getMoveLearnMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("move-target/")
  public fun getMoveTargetList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  public fun getLocationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("location-area/")
  public fun getLocationAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pal-park-area/")
  public fun getPalParkAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("region/")
  public fun getRegionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  public fun getMachineList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  public fun getAbilityList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("characteristic/")
  public fun getCharacteristicList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<ApiResourceList>

  @GET("egg-group/")
  public fun getEggGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("gender/")
  public fun getGenderList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("growth-rate/")
  public fun getGrowthRateList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("nature/")
  public fun getNatureList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  public fun getPokeathlonStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon/")
  public fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon-color/")
  public fun getPokemonColorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon-form/")
  public fun getPokemonFormList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon-habitat/")
  public fun getPokemonHabitatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon-shape/")
  public fun getPokemonShapeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("pokemon-species/")
  public fun getPokemonSpeciesList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("stat/")
  public fun getStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  @GET("type/")
  public fun getTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  public fun getLanguageList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Promise<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") public fun getBerry(@Path("id") id: Int): Promise<Berry>

  @GET("berry-firmness/{id}/")
  public fun getBerryFirmness(@Path("id") id: Int): Promise<BerryFirmness>

  @GET("berry-flavor/{id}/") public fun getBerryFlavor(@Path("id") id: Int): Promise<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/") public fun getContestType(@Path("id") id: Int): Promise<ContestType>

  @GET("contest-effect/{id}/")
  public fun getContestEffect(@Path("id") id: Int): Promise<ContestEffect>

  @GET("super-contest-effect/{id}/")
  public fun getSuperContestEffect(@Path("id") id: Int): Promise<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  public fun getEncounterMethod(@Path("id") id: Int): Promise<EncounterMethod>

  @GET("encounter-condition/{id}/")
  public fun getEncounterCondition(@Path("id") id: Int): Promise<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  public fun getEncounterConditionValue(@Path("id") id: Int): Promise<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  public fun getEvolutionChain(@Path("id") id: Int): Promise<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  public fun getEvolutionTrigger(@Path("id") id: Int): Promise<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/") public fun getGeneration(@Path("id") id: Int): Promise<Generation>

  @GET("pokedex/{id}/") public fun getPokedex(@Path("id") id: Int): Promise<Pokedex>

  @GET("version/{id}/") public fun getVersion(@Path("id") id: Int): Promise<Version>

  @GET("version-group/{id}/") public fun getVersionGroup(@Path("id") id: Int): Promise<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/") public fun getItem(@Path("id") id: Int): Promise<Item>

  @GET("item-attribute/{id}/")
  public fun getItemAttribute(@Path("id") id: Int): Promise<ItemAttribute>

  @GET("item-category/{id}/") public fun getItemCategory(@Path("id") id: Int): Promise<ItemCategory>

  @GET("item-fling-effect/{id}/")
  public fun getItemFlingEffect(@Path("id") id: Int): Promise<ItemFlingEffect>

  @GET("item-pocket/{id}/") public fun getItemPocket(@Path("id") id: Int): Promise<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/") public fun getMove(@Path("id") id: Int): Promise<Move>

  @GET("move-ailment/{id}/") public fun getMoveAilment(@Path("id") id: Int): Promise<MoveAilment>

  @GET("move-battle-style/{id}/")
  public fun getMoveBattleStyle(@Path("id") id: Int): Promise<MoveBattleStyle>

  @GET("move-category/{id}/") public fun getMoveCategory(@Path("id") id: Int): Promise<MoveCategory>

  @GET("move-damage-class/{id}/")
  public fun getMoveDamageClass(@Path("id") id: Int): Promise<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  public fun getMoveLearnMethod(@Path("id") id: Int): Promise<MoveLearnMethod>

  @GET("move-target/{id}/") public fun getMoveTarget(@Path("id") id: Int): Promise<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/") public fun getLocation(@Path("id") id: Int): Promise<Location>

  @GET("location-area/{id}/") public fun getLocationArea(@Path("id") id: Int): Promise<LocationArea>

  @GET("pal-park-area/{id}/") public fun getPalParkArea(@Path("id") id: Int): Promise<PalParkArea>

  @GET("region/{id}/") public fun getRegion(@Path("id") id: Int): Promise<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") public fun getMachine(@Path("id") id: Int): Promise<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/") public fun getAbility(@Path("id") id: Int): Promise<Ability>

  @GET("characteristic/{id}/")
  public fun getCharacteristic(@Path("id") id: Int): Promise<Characteristic>

  @GET("egg-group/{id}/") public fun getEggGroup(@Path("id") id: Int): Promise<EggGroup>

  @GET("gender/{id}/") public fun getGender(@Path("id") id: Int): Promise<Gender>

  @GET("growth-rate/{id}/") public fun getGrowthRate(@Path("id") id: Int): Promise<GrowthRate>

  @GET("nature/{id}/") public fun getNature(@Path("id") id: Int): Promise<Nature>

  @GET("pokeathlon-stat/{id}/")
  public fun getPokeathlonStat(@Path("id") id: Int): Promise<PokeathlonStat>

  @GET("pokemon/{id}/") public fun getPokemon(@Path("id") id: Int): Promise<Pokemon>

  @GET("pokemon/{id}/encounters/")
  public fun getPokemonEncounterList(@Path("id") id: Int): Promise<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/") public fun getPokemonColor(@Path("id") id: Int): Promise<PokemonColor>

  @GET("pokemon-form/{id}/") public fun getPokemonForm(@Path("id") id: Int): Promise<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  public fun getPokemonHabitat(@Path("id") id: Int): Promise<PokemonHabitat>

  @GET("pokemon-shape/{id}/") public fun getPokemonShape(@Path("id") id: Int): Promise<PokemonShape>

  @GET("pokemon-species/{id}/")
  public fun getPokemonSpecies(@Path("id") id: Int): Promise<PokemonSpecies>

  @GET("stat/{id}/") public fun getStat(@Path("id") id: Int): Promise<Stat>

  @GET("type/{id}/") public fun getType(@Path("id") id: Int): Promise<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/") public fun getLanguage(@Path("id") id: Int): Promise<Language>

  // endregion Utility
}
