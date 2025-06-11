package co.pokeapi.pokekotlin

import co.pokeapi.pokekotlin.internal.PokeApiJson
import co.pokeapi.pokekotlin.internal.ResultConverter
import co.pokeapi.pokekotlin.internal.getDefaultEngine
import co.pokeapi.pokekotlin.model.Ability
import co.pokeapi.pokekotlin.model.ApiResourceList
import co.pokeapi.pokekotlin.model.Berry
import co.pokeapi.pokekotlin.model.BerryFirmness
import co.pokeapi.pokekotlin.model.BerryFlavor
import co.pokeapi.pokekotlin.model.Characteristic
import co.pokeapi.pokekotlin.model.ContestEffect
import co.pokeapi.pokekotlin.model.ContestType
import co.pokeapi.pokekotlin.model.EggGroup
import co.pokeapi.pokekotlin.model.EncounterCondition
import co.pokeapi.pokekotlin.model.EncounterConditionValue
import co.pokeapi.pokekotlin.model.EncounterMethod
import co.pokeapi.pokekotlin.model.EvolutionChain
import co.pokeapi.pokekotlin.model.EvolutionTrigger
import co.pokeapi.pokekotlin.model.Gender
import co.pokeapi.pokekotlin.model.Generation
import co.pokeapi.pokekotlin.model.GrowthRate
import co.pokeapi.pokekotlin.model.Item
import co.pokeapi.pokekotlin.model.ItemAttribute
import co.pokeapi.pokekotlin.model.ItemCategory
import co.pokeapi.pokekotlin.model.ItemFlingEffect
import co.pokeapi.pokekotlin.model.ItemPocket
import co.pokeapi.pokekotlin.model.Language
import co.pokeapi.pokekotlin.model.Location
import co.pokeapi.pokekotlin.model.LocationArea
import co.pokeapi.pokekotlin.model.LocationAreaEncounter
import co.pokeapi.pokekotlin.model.Machine
import co.pokeapi.pokekotlin.model.Move
import co.pokeapi.pokekotlin.model.MoveAilment
import co.pokeapi.pokekotlin.model.MoveBattleStyle
import co.pokeapi.pokekotlin.model.MoveCategory
import co.pokeapi.pokekotlin.model.MoveDamageClass
import co.pokeapi.pokekotlin.model.MoveLearnMethod
import co.pokeapi.pokekotlin.model.MoveTarget
import co.pokeapi.pokekotlin.model.NamedApiResourceList
import co.pokeapi.pokekotlin.model.Nature
import co.pokeapi.pokekotlin.model.PalParkArea
import co.pokeapi.pokekotlin.model.PokeathlonStat
import co.pokeapi.pokekotlin.model.Pokedex
import co.pokeapi.pokekotlin.model.Pokemon
import co.pokeapi.pokekotlin.model.PokemonColor
import co.pokeapi.pokekotlin.model.PokemonForm
import co.pokeapi.pokekotlin.model.PokemonHabitat
import co.pokeapi.pokekotlin.model.PokemonShape
import co.pokeapi.pokekotlin.model.PokemonSpecies
import co.pokeapi.pokekotlin.model.Region
import co.pokeapi.pokekotlin.model.Stat
import co.pokeapi.pokekotlin.model.SuperContestEffect
import co.pokeapi.pokekotlin.model.Type
import co.pokeapi.pokekotlin.model.Version
import co.pokeapi.pokekotlin.model.VersionGroup
import de.jensklingenberg.ktorfit.Ktorfit.Builder
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.CacheStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

interface PokeApi {

  // region Resource Lists

  // region Berries

  @GET("berry/")
  suspend fun getBerryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("berry-firmness/")
  suspend fun getBerryFirmnessList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("berry-flavor/")
  suspend fun getBerryFlavorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  suspend fun getContestTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("contest-effect/")
  suspend fun getContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("super-contest-effect/")
  suspend fun getSuperContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  suspend fun getEncounterMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("encounter-condition/")
  suspend fun getEncounterConditionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("encounter-condition-value/")
  suspend fun getEncounterConditionValueList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  suspend fun getEvolutionChainList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("evolution-trigger/")
  suspend fun getEvolutionTriggerList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Games

  @GET("generation/")
  suspend fun getGenerationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokedex/")
  suspend fun getPokedexList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("version/")
  suspend fun getVersionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("version-group/")
  suspend fun getVersionGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  suspend fun getItemList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-attribute/")
  suspend fun getItemAttributeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-category/")
  suspend fun getItemCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-fling-effect/")
  suspend fun getItemFlingEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("item-pocket/")
  suspend fun getItemPocketList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Moves

  @GET("move/")
  suspend fun getMoveList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-ailment/")
  suspend fun getMoveAilmentList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-battle-style/")
  suspend fun getMoveBattleStyleList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-category/")
  suspend fun getMoveCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-damage-class/")
  suspend fun getMoveDamageClassList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-learn-method/")
  suspend fun getMoveLearnMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("move-target/")
  suspend fun getMoveTargetList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  suspend fun getLocationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("location-area/")
  suspend fun getLocationAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pal-park-area/")
  suspend fun getPalParkAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("region/")
  suspend fun getRegionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  suspend fun getMachineList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  suspend fun getAbilityList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("characteristic/")
  suspend fun getCharacteristicList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<ApiResourceList>

  @GET("egg-group/")
  suspend fun getEggGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("gender/")
  suspend fun getGenderList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("growth-rate/")
  suspend fun getGrowthRateList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("nature/")
  suspend fun getNatureList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  suspend fun getPokeathlonStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon/")
  suspend fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-color/")
  suspend fun getPokemonColorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-form/")
  suspend fun getPokemonFormList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-habitat/")
  suspend fun getPokemonHabitatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-shape/")
  suspend fun getPokemonShapeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("pokemon-species/")
  suspend fun getPokemonSpeciesList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("stat/")
  suspend fun getStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  @GET("type/")
  suspend fun getTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  suspend fun getLanguageList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Result<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") suspend fun getBerry(@Path("id") id: Int): Result<Berry>

  @GET("berry-firmness/{id}/")
  suspend fun getBerryFirmness(@Path("id") id: Int): Result<BerryFirmness>

  @GET("berry-flavor/{id}/") suspend fun getBerryFlavor(@Path("id") id: Int): Result<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/") suspend fun getContestType(@Path("id") id: Int): Result<ContestType>

  @GET("contest-effect/{id}/")
  suspend fun getContestEffect(@Path("id") id: Int): Result<ContestEffect>

  @GET("super-contest-effect/{id}/")
  suspend fun getSuperContestEffect(@Path("id") id: Int): Result<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  suspend fun getEncounterMethod(@Path("id") id: Int): Result<EncounterMethod>

  @GET("encounter-condition/{id}/")
  suspend fun getEncounterCondition(@Path("id") id: Int): Result<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  suspend fun getEncounterConditionValue(@Path("id") id: Int): Result<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  suspend fun getEvolutionChain(@Path("id") id: Int): Result<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  suspend fun getEvolutionTrigger(@Path("id") id: Int): Result<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/") suspend fun getGeneration(@Path("id") id: Int): Result<Generation>

  @GET("pokedex/{id}/") suspend fun getPokedex(@Path("id") id: Int): Result<Pokedex>

  @GET("version/{id}/") suspend fun getVersion(@Path("id") id: Int): Result<Version>

  @GET("version-group/{id}/") suspend fun getVersionGroup(@Path("id") id: Int): Result<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/") suspend fun getItem(@Path("id") id: Int): Result<Item>

  @GET("item-attribute/{id}/")
  suspend fun getItemAttribute(@Path("id") id: Int): Result<ItemAttribute>

  @GET("item-category/{id}/") suspend fun getItemCategory(@Path("id") id: Int): Result<ItemCategory>

  @GET("item-fling-effect/{id}/")
  suspend fun getItemFlingEffect(@Path("id") id: Int): Result<ItemFlingEffect>

  @GET("item-pocket/{id}/") suspend fun getItemPocket(@Path("id") id: Int): Result<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/") suspend fun getMove(@Path("id") id: Int): Result<Move>

  @GET("move-ailment/{id}/") suspend fun getMoveAilment(@Path("id") id: Int): Result<MoveAilment>

  @GET("move-battle-style/{id}/")
  suspend fun getMoveBattleStyle(@Path("id") id: Int): Result<MoveBattleStyle>

  @GET("move-category/{id}/") suspend fun getMoveCategory(@Path("id") id: Int): Result<MoveCategory>

  @GET("move-damage-class/{id}/")
  suspend fun getMoveDamageClass(@Path("id") id: Int): Result<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  suspend fun getMoveLearnMethod(@Path("id") id: Int): Result<MoveLearnMethod>

  @GET("move-target/{id}/") suspend fun getMoveTarget(@Path("id") id: Int): Result<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/") suspend fun getLocation(@Path("id") id: Int): Result<Location>

  @GET("location-area/{id}/") suspend fun getLocationArea(@Path("id") id: Int): Result<LocationArea>

  @GET("pal-park-area/{id}/") suspend fun getPalParkArea(@Path("id") id: Int): Result<PalParkArea>

  @GET("region/{id}/") suspend fun getRegion(@Path("id") id: Int): Result<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") suspend fun getMachine(@Path("id") id: Int): Result<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/") suspend fun getAbility(@Path("id") id: Int): Result<Ability>

  @GET("characteristic/{id}/")
  suspend fun getCharacteristic(@Path("id") id: Int): Result<Characteristic>

  @GET("egg-group/{id}/") suspend fun getEggGroup(@Path("id") id: Int): Result<EggGroup>

  @GET("gender/{id}/") suspend fun getGender(@Path("id") id: Int): Result<Gender>

  @GET("growth-rate/{id}/") suspend fun getGrowthRate(@Path("id") id: Int): Result<GrowthRate>

  @GET("nature/{id}/") suspend fun getNature(@Path("id") id: Int): Result<Nature>

  @GET("pokeathlon-stat/{id}/")
  suspend fun getPokeathlonStat(@Path("id") id: Int): Result<PokeathlonStat>

  @GET("pokemon/{id}/") suspend fun getPokemon(@Path("id") id: Int): Result<Pokemon>

  @GET("pokemon/{id}/encounters/")
  suspend fun getPokemonEncounterList(@Path("id") id: Int): Result<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/") suspend fun getPokemonColor(@Path("id") id: Int): Result<PokemonColor>

  @GET("pokemon-form/{id}/") suspend fun getPokemonForm(@Path("id") id: Int): Result<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  suspend fun getPokemonHabitat(@Path("id") id: Int): Result<PokemonHabitat>

  @GET("pokemon-shape/{id}/") suspend fun getPokemonShape(@Path("id") id: Int): Result<PokemonShape>

  @GET("pokemon-species/{id}/")
  suspend fun getPokemonSpecies(@Path("id") id: Int): Result<PokemonSpecies>

  @GET("stat/{id}/") suspend fun getStat(@Path("id") id: Int): Result<Stat>

  @GET("type/{id}/") suspend fun getType(@Path("id") id: Int): Result<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/") suspend fun getLanguage(@Path("id") id: Int): Result<Language>

  // endregion Utility

  companion object : PokeApi by PokeApi()
}

fun PokeApi(
  baseUrl: String = "https://pokeapi.co/api/v2/",
  engine: HttpClientEngine = getDefaultEngine(),
  cacheStorage: CacheStorage? = null,
  configure: HttpClientConfig<*>.() -> Unit = {},
) =
  Builder()
    .baseUrl(baseUrl)
    .httpClient(
      HttpClient(engine) {
        configure()
        install(HttpCache) { cacheStorage?.let { privateStorage(it) } }
        install(ContentNegotiation) { json(PokeApiJson, ContentType.Any) }
      }
    )
    .converterFactories(ResultConverter.Factory)
    .build()
    .createPokeApi()
