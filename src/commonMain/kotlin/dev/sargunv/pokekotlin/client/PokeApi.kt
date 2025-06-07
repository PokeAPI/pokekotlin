package dev.sargunv.pokekotlin.client

import de.jensklingenberg.ktorfit.Ktorfit.Builder
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import dev.sargunv.pokekotlin.model.Ability
import dev.sargunv.pokekotlin.model.ApiResourceList
import dev.sargunv.pokekotlin.model.Berry
import dev.sargunv.pokekotlin.model.BerryFirmness
import dev.sargunv.pokekotlin.model.BerryFlavor
import dev.sargunv.pokekotlin.model.Characteristic
import dev.sargunv.pokekotlin.model.ContestEffect
import dev.sargunv.pokekotlin.model.ContestType
import dev.sargunv.pokekotlin.model.EggGroup
import dev.sargunv.pokekotlin.model.EncounterCondition
import dev.sargunv.pokekotlin.model.EncounterConditionValue
import dev.sargunv.pokekotlin.model.EncounterMethod
import dev.sargunv.pokekotlin.model.EvolutionChain
import dev.sargunv.pokekotlin.model.EvolutionTrigger
import dev.sargunv.pokekotlin.model.Gender
import dev.sargunv.pokekotlin.model.Generation
import dev.sargunv.pokekotlin.model.GrowthRate
import dev.sargunv.pokekotlin.model.Item
import dev.sargunv.pokekotlin.model.ItemAttribute
import dev.sargunv.pokekotlin.model.ItemCategory
import dev.sargunv.pokekotlin.model.ItemFlingEffect
import dev.sargunv.pokekotlin.model.ItemPocket
import dev.sargunv.pokekotlin.model.Language
import dev.sargunv.pokekotlin.model.Location
import dev.sargunv.pokekotlin.model.LocationArea
import dev.sargunv.pokekotlin.model.LocationAreaEncounter
import dev.sargunv.pokekotlin.model.Machine
import dev.sargunv.pokekotlin.model.Move
import dev.sargunv.pokekotlin.model.MoveAilment
import dev.sargunv.pokekotlin.model.MoveBattleStyle
import dev.sargunv.pokekotlin.model.MoveCategory
import dev.sargunv.pokekotlin.model.MoveDamageClass
import dev.sargunv.pokekotlin.model.MoveLearnMethod
import dev.sargunv.pokekotlin.model.MoveTarget
import dev.sargunv.pokekotlin.model.NamedApiResourceList
import dev.sargunv.pokekotlin.model.Nature
import dev.sargunv.pokekotlin.model.PalParkArea
import dev.sargunv.pokekotlin.model.PokeathlonStat
import dev.sargunv.pokekotlin.model.Pokedex
import dev.sargunv.pokekotlin.model.Pokemon
import dev.sargunv.pokekotlin.model.PokemonColor
import dev.sargunv.pokekotlin.model.PokemonForm
import dev.sargunv.pokekotlin.model.PokemonHabitat
import dev.sargunv.pokekotlin.model.PokemonShape
import dev.sargunv.pokekotlin.model.PokemonSpecies
import dev.sargunv.pokekotlin.model.Region
import dev.sargunv.pokekotlin.model.Stat
import dev.sargunv.pokekotlin.model.SuperContestEffect
import dev.sargunv.pokekotlin.model.Type
import dev.sargunv.pokekotlin.model.Version
import dev.sargunv.pokekotlin.model.VersionGroup
import dev.sargunv.pokekotlin.util.getDefaultEngine
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.CacheStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

interface PokeApi {

  // region Resource Lists

  // region Berries

  @GET("berry/")
  suspend fun getBerryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("berry-firmness/")
  suspend fun getBerryFirmnessList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("berry-flavor/")
  suspend fun getBerryFlavorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  suspend fun getContestTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("contest-effect/")
  suspend fun getContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): ApiResourceList

  @GET("super-contest-effect/")
  suspend fun getSuperContestEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): ApiResourceList

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  suspend fun getEncounterMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("encounter-condition/")
  suspend fun getEncounterConditionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("encounter-condition-value/")
  suspend fun getEncounterConditionValueList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  suspend fun getEvolutionChainList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): ApiResourceList

  @GET("evolution-trigger/")
  suspend fun getEvolutionTriggerList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Games

  @GET("generation/")
  suspend fun getGenerationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokedex/")
  suspend fun getPokedexList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("version/")
  suspend fun getVersionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("version-group/")
  suspend fun getVersionGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Items

  @GET("item/")
  suspend fun getItemList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("item-attribute/")
  suspend fun getItemAttributeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("item-category/")
  suspend fun getItemCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("item-fling-effect/")
  suspend fun getItemFlingEffectList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("item-pocket/")
  suspend fun getItemPocketList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Moves

  @GET("move/")
  suspend fun getMoveList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-ailment/")
  suspend fun getMoveAilmentList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-battle-style/")
  suspend fun getMoveBattleStyleList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-category/")
  suspend fun getMoveCategoryList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-damage-class/")
  suspend fun getMoveDamageClassList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-learn-method/")
  suspend fun getMoveLearnMethodList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("move-target/")
  suspend fun getMoveTargetList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Locations

  @GET("location/")
  suspend fun getLocationList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("location-area/")
  suspend fun getLocationAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pal-park-area/")
  suspend fun getPalParkAreaList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("region/")
  suspend fun getRegionList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Machines

  @GET("machine/")
  suspend fun getMachineList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): ApiResourceList

  // endregion

  // region Pokemon

  @GET("ability/")
  suspend fun getAbilityList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("characteristic/")
  suspend fun getCharacteristicList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): ApiResourceList

  @GET("egg-group/")
  suspend fun getEggGroupList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("gender/")
  suspend fun getGenderList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("growth-rate/")
  suspend fun getGrowthRateList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("nature/")
  suspend fun getNatureList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokeathlon-stat/")
  suspend fun getPokeathlonStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon/")
  suspend fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon-color/")
  suspend fun getPokemonColorList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon-form/")
  suspend fun getPokemonFormList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon-habitat/")
  suspend fun getPokemonHabitatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon-shape/")
  suspend fun getPokemonShapeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("pokemon-species/")
  suspend fun getPokemonSpeciesList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("stat/")
  suspend fun getStatList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  @GET("type/")
  suspend fun getTypeList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // region Utility

  @GET("language/")
  suspend fun getLanguageList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): NamedApiResourceList

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") suspend fun getBerry(@Path("id") id: Int): Berry

  @GET("berry-firmness/{id}/") suspend fun getBerryFirmness(@Path("id") id: Int): BerryFirmness

  @GET("berry-flavor/{id}/") suspend fun getBerryFlavor(@Path("id") id: Int): BerryFlavor

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/") suspend fun getContestType(@Path("id") id: Int): ContestType

  @GET("contest-effect/{id}/") suspend fun getContestEffect(@Path("id") id: Int): ContestEffect

  @GET("super-contest-effect/{id}/")
  suspend fun getSuperContestEffect(@Path("id") id: Int): SuperContestEffect

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  suspend fun getEncounterMethod(@Path("id") id: Int): EncounterMethod

  @GET("encounter-condition/{id}/")
  suspend fun getEncounterCondition(@Path("id") id: Int): EncounterCondition

  @GET("encounter-condition-value/{id}/")
  suspend fun getEncounterConditionValue(@Path("id") id: Int): EncounterConditionValue

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/") suspend fun getEvolutionChain(@Path("id") id: Int): EvolutionChain

  @GET("evolution-trigger/{id}/")
  suspend fun getEvolutionTrigger(@Path("id") id: Int): EvolutionTrigger

  // endregion Evolution

  // region Games

  @GET("generation/{id}/") suspend fun getGeneration(@Path("id") id: Int): Generation

  @GET("pokedex/{id}/") suspend fun getPokedex(@Path("id") id: Int): Pokedex

  @GET("version/{id}/") suspend fun getVersion(@Path("id") id: Int): Version

  @GET("version-group/{id}/") suspend fun getVersionGroup(@Path("id") id: Int): VersionGroup

  // endregion Games

  // region Items

  @GET("item/{id}/") suspend fun getItem(@Path("id") id: Int): Item

  @GET("item-attribute/{id}/") suspend fun getItemAttribute(@Path("id") id: Int): ItemAttribute

  @GET("item-category/{id}/") suspend fun getItemCategory(@Path("id") id: Int): ItemCategory

  @GET("item-fling-effect/{id}/")
  suspend fun getItemFlingEffect(@Path("id") id: Int): ItemFlingEffect

  @GET("item-pocket/{id}/") suspend fun getItemPocket(@Path("id") id: Int): ItemPocket

  // endregion Items

  // region Moves

  @GET("move/{id}/") suspend fun getMove(@Path("id") id: Int): Move

  @GET("move-ailment/{id}/") suspend fun getMoveAilment(@Path("id") id: Int): MoveAilment

  @GET("move-battle-style/{id}/")
  suspend fun getMoveBattleStyle(@Path("id") id: Int): MoveBattleStyle

  @GET("move-category/{id}/") suspend fun getMoveCategory(@Path("id") id: Int): MoveCategory

  @GET("move-damage-class/{id}/")
  suspend fun getMoveDamageClass(@Path("id") id: Int): MoveDamageClass

  @GET("move-learn-method/{id}/")
  suspend fun getMoveLearnMethod(@Path("id") id: Int): MoveLearnMethod

  @GET("move-target/{id}/") suspend fun getMoveTarget(@Path("id") id: Int): MoveTarget

  // endregion Moves

  // region Locations

  @GET("location/{id}/") suspend fun getLocation(@Path("id") id: Int): Location

  @GET("location-area/{id}/") suspend fun getLocationArea(@Path("id") id: Int): LocationArea

  @GET("pal-park-area/{id}/") suspend fun getPalParkArea(@Path("id") id: Int): PalParkArea

  @GET("region/{id}/") suspend fun getRegion(@Path("id") id: Int): Region

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") suspend fun getMachine(@Path("id") id: Int): Machine

  // endregion

  // region Pokemon

  @GET("ability/{id}/") suspend fun getAbility(@Path("id") id: Int): Ability

  @GET("characteristic/{id}/") suspend fun getCharacteristic(@Path("id") id: Int): Characteristic

  @GET("egg-group/{id}/") suspend fun getEggGroup(@Path("id") id: Int): EggGroup

  @GET("gender/{id}/") suspend fun getGender(@Path("id") id: Int): Gender

  @GET("growth-rate/{id}/") suspend fun getGrowthRate(@Path("id") id: Int): GrowthRate

  @GET("nature/{id}/") suspend fun getNature(@Path("id") id: Int): Nature

  @GET("pokeathlon-stat/{id}/") suspend fun getPokeathlonStat(@Path("id") id: Int): PokeathlonStat

  @GET("pokemon/{id}/") suspend fun getPokemon(@Path("id") id: Int): Pokemon

  @GET("pokemon/{id}/encounters/")
  suspend fun getPokemonEncounterList(@Path("id") id: Int): List<LocationAreaEncounter>

  @GET("pokemon-color/{id}/") suspend fun getPokemonColor(@Path("id") id: Int): PokemonColor

  @GET("pokemon-form/{id}/") suspend fun getPokemonForm(@Path("id") id: Int): PokemonForm

  @GET("pokemon-habitat/{id}/") suspend fun getPokemonHabitat(@Path("id") id: Int): PokemonHabitat

  @GET("pokemon-shape/{id}/") suspend fun getPokemonShape(@Path("id") id: Int): PokemonShape

  @GET("pokemon-species/{id}/") suspend fun getPokemonSpecies(@Path("id") id: Int): PokemonSpecies

  @GET("stat/{id}/") suspend fun getStat(@Path("id") id: Int): Stat

  @GET("type/{id}/") suspend fun getType(@Path("id") id: Int): Type

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/") suspend fun getLanguage(@Path("id") id: Int): Language

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
        this.configure()
        this.install(HttpCache) { cacheStorage?.let { privateStorage(it) } }
        this.install(ContentNegotiation) { json(PokeApiJson) }
      }
    )
    .build()
    .createPokeApi()
