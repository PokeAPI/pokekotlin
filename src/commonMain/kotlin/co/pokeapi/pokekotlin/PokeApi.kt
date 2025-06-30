package co.pokeapi.pokekotlin

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import co.pokeapi.pokekotlin.internal.PokeApiJson
import co.pokeapi.pokekotlin.internal.getDefaultEngine
import co.pokeapi.pokekotlin.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlin.js.ExperimentalJsStatic
import kotlin.js.JsExport
import kotlin.js.JsName
import love.forte.plugin.suspendtrans.annotation.JsPromise
import love.forte.plugin.suspendtrans.annotation.JvmAsync
import love.forte.plugin.suspendtrans.annotation.JvmBlocking

private suspend inline fun <reified T> HttpClient.getBodyWithOffsetAndLimit(
  path: String,
  offset: Int,
  limit: Int,
): T =
  get(path) {
      parameter("offset", offset)
      parameter("limit", limit)
    }
    .body()

private suspend inline fun <reified T> HttpClient.getBody(path: String): T = get(path).body()

@JsOnlyExport
public sealed class PokeApi
@JsExport.Ignore
constructor(
  baseUrl: String,
  engine: HttpClientEngine,
  cacheStorage: CacheStorage?,
  configure: HttpClientConfig<*>.() -> Unit,
) {
  private val client =
    HttpClient(engine) {
      configure()
      defaultRequest { url(baseUrl) }
      install(HttpCache) { cacheStorage?.let { privateStorage(it) } }
      install(ContentNegotiation) { json(PokeApiJson, ContentType.Any) }
      expectSuccess = true
    }

  public class Custom
  @JsExport.Ignore
  public constructor(
    baseUrl: String = "https://pokeapi.co/",
    engine: HttpClientEngine = getDefaultEngine(),
    cacheStorage: CacheStorage? = null,
    configure: HttpClientConfig<*>.() -> Unit = {},
  ) : PokeApi(baseUrl, engine, cacheStorage, configure) {
    @JsName("create")
    public constructor(baseUrl: String = "https://pokeapi.co/") : this(baseUrl, configure = {})
  }

  @OptIn(ExperimentalJsStatic::class)
  public companion object Default :
    PokeApi(
      baseUrl = "https://pokeapi.co/",
      engine = getDefaultEngine(),
      cacheStorage = null,
      configure = {},
    )

  // region Resource Lists

  // region Berries

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerryList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/berry", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerryFirmnessList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/berry-firmness", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerryFlavorList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/berry-flavor", offset, limit)

  // endregion Berries

  // region Contests

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getContestTypeList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/contest-type", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getContestEffectList(offset: Int, limit: Int): ApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/contest-effect", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getSuperContestEffectList(offset: Int, limit: Int): ApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/super-contest-effect", offset, limit)

  // endregion Contests

  // region Encounters

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterMethodList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/encounter-method", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterConditionList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/encounter-condition", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterConditionValueList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/encounter-condition-value", offset, limit)

  // endregion

  // region Evolution

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEvolutionChainList(offset: Int, limit: Int): ApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/evolution-chain", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEvolutionTriggerList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/evolution-trigger", offset, limit)

  // endregion

  // region Games

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGenerationList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/generation", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokedexList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokedex", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getVersionList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/version", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getVersionGroupList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/version-group", offset, limit)

  // endregion

  // region Items

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/item", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemAttributeList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/item-attribute", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemCategoryList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/item-category", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemFlingEffectList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/item-fling-effect", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemPocketList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/item-pocket", offset, limit)

  // endregion

  // region Moves

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveAilmentList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-ailment", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveBattleStyleList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-battle-style", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveCategoryList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-category", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveDamageClassList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-damage-class", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveLearnMethodList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-learn-method", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveTargetList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/move-target", offset, limit)

  // endregion

  // region Locations

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLocationList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/location", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLocationAreaList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/location-area", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPalParkAreaList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pal-park-area", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getRegionList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/region", offset, limit)

  // endregion

  // region Machines

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMachineList(offset: Int, limit: Int): ApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/machine", offset, limit)

  // endregion

  // region Pokemon

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getAbilityList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/ability", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getCharacteristicList(offset: Int, limit: Int): ApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/characteristic", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEggGroupList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/egg-group", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGenderList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/gender", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGrowthRateList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/growth-rate", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getNatureList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/nature", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokeathlonStatList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokeathlon-stat", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonVarietyList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonColorList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon-color", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonFormList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon-form", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonHabitatList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon-habitat", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonShapeList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon-shape", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonSpeciesList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/pokemon-species", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getStatList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/stat", offset, limit)

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getTypeList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/type", offset, limit)

  // endregion

  // region Utility

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLanguageList(offset: Int, limit: Int): NamedApiResourceList =
    client.getBodyWithOffsetAndLimit("/api/v2/language", offset, limit)

  // endregion

  // endregion

  // region Berries

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerry(id: Int): Berry = client.getBody("${"/api/v2/berry"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerryFirmness(id: Int): BerryFirmness =
    client.getBody("${"/api/v2/berry-firmness"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getBerryFlavor(id: Int): BerryFlavor =
    client.getBody("${"/api/v2/berry-flavor"}/$id")

  // endregion Berries

  // region Contests

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getContestType(id: Int): ContestType =
    client.getBody("${"/api/v2/contest-type"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getContestEffect(id: Int): ContestEffect =
    client.getBody("${"/api/v2/contest-effect"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getSuperContestEffect(id: Int): SuperContestEffect =
    client.getBody("${"/api/v2/super-contest-effect"}/$id")

  // endregion Contests

  // region Encounters

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterMethod(id: Int): EncounterMethod =
    client.getBody("${"/api/v2/encounter-method"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterCondition(id: Int): EncounterCondition =
    client.getBody("${"/api/v2/encounter-condition"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEncounterConditionValue(id: Int): EncounterConditionValue =
    client.getBody("${"/api/v2/encounter-condition-value"}/$id")

  // endregion

  // region Evolution

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEvolutionChain(id: Int): EvolutionChain =
    client.getBody("${"/api/v2/evolution-chain"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEvolutionTrigger(id: Int): EvolutionTrigger =
    client.getBody("${"/api/v2/evolution-trigger"}/$id")

  // endregion Evolution

  // region Games

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGeneration(id: Int): Generation =
    client.getBody("${"/api/v2/generation"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokedex(id: Int): Pokedex = client.getBody("${"/api/v2/pokedex"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getVersion(id: Int): Version = client.getBody("${"/api/v2/version"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getVersionGroup(id: Int): VersionGroup =
    client.getBody("${"/api/v2/version-group"}/$id")

  // endregion Games

  // region Items

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItem(id: Int): Item = client.getBody("${"/api/v2/item"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemAttribute(id: Int): ItemAttribute =
    client.getBody("${"/api/v2/item-attribute"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemCategory(id: Int): ItemCategory =
    client.getBody("${"/api/v2/item-category"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemFlingEffect(id: Int): ItemFlingEffect =
    client.getBody("${"/api/v2/item-fling-effect"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getItemPocket(id: Int): ItemPocket =
    client.getBody("${"/api/v2/item-pocket"}/$id")

  // endregion Items

  // region Moves

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMove(id: Int): Move = client.getBody("${"/api/v2/move"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveAilment(id: Int): MoveAilment =
    client.getBody("${"/api/v2/move-ailment"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveBattleStyle(id: Int): MoveBattleStyle =
    client.getBody("${"/api/v2/move-battle-style"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveCategory(id: Int): MoveCategory =
    client.getBody("${"/api/v2/move-category"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveDamageClass(id: Int): MoveDamageClass =
    client.getBody("${"/api/v2/move-damage-class"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveLearnMethod(id: Int): MoveLearnMethod =
    client.getBody("${"/api/v2/move-learn-method"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMoveTarget(id: Int): MoveTarget =
    client.getBody("${"/api/v2/move-target"}/$id")

  // endregion Moves

  // region Locations

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLocation(id: Int): Location = client.getBody("${"/api/v2/location"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLocationArea(id: Int): LocationArea =
    client.getBody("${"/api/v2/location-area"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPalParkArea(id: Int): PalParkArea =
    client.getBody("${"/api/v2/pal-park-area"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getRegion(id: Int): Region = client.getBody("${"/api/v2/region"}/$id")

  // endregion Locations

  // region Machines

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getMachine(id: Int): Machine = client.getBody("${"/api/v2/machine"}/$id")

  // endregion

  // region Pokemon

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getAbility(id: Int): Ability = client.getBody("${"/api/v2/ability"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getCharacteristic(id: Int): Characteristic =
    client.getBody("${"/api/v2/characteristic"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getEggGroup(id: Int): EggGroup = client.getBody("${"/api/v2/egg-group"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGender(id: Int): Gender = client.getBody("${"/api/v2/gender"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getGrowthRate(id: Int): GrowthRate =
    client.getBody("${"/api/v2/growth-rate"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getNature(id: Int): Nature = client.getBody("${"/api/v2/nature"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokeathlonStat(id: Int): PokeathlonStat =
    client.getBody("${"/api/v2/pokeathlon-stat"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonVariety(id: Int): PokemonVariety =
    client.getBody("${"/api/v2/pokemon"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonEncounterList(id: Int): List<LocationAreaEncounter> =
    client.getBody("/api/v2/pokemon/$id/encounters")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonColor(id: Int): PokemonColor =
    client.getBody("${"/api/v2/pokemon-color"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonForm(id: Int): PokemonForm =
    client.getBody("${"/api/v2/pokemon-form"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonHabitat(id: Int): PokemonHabitat =
    client.getBody("${"/api/v2/pokemon-habitat"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonShape(id: Int): PokemonShape =
    client.getBody("${"/api/v2/pokemon-shape"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getPokemonSpecies(id: Int): PokemonSpecies =
    client.getBody("${"/api/v2/pokemon-species"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getStat(id: Int): Stat = client.getBody("${"/api/v2/stat"}/$id")

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getType(id: Int): Type = client.getBody("${"/api/v2/type"}/$id")

  // endregion Pokemon

  // region Utility

  @JvmBlocking
  @JvmAsync
  @JsPromise
  @JsExport.Ignore
  public suspend fun getLanguage(id: Int): Language = client.getBody("${"/api/v2/language"}/$id")

  // endregion Utility
}
