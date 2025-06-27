package co.pokeapi.pokekotlin.java

import co.pokeapi.pokekotlin.internal.FutureConverter
import co.pokeapi.pokekotlin.internal.createPokeApiKtorfitBuilder
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
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.cache.storage.CacheStorage
import java.util.concurrent.Future

public interface PokeApi {

  private companion object {
    @JvmStatic val default: PokeApi by lazy { create() }

    @JvmStatic
    @JvmOverloads
    fun create(
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
        .converterFactories(FutureConverter.Factory)
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
  ): Future<NamedApiResourceList>

  @GET("berry-firmness/")
  public fun getBerryFirmnessListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("berry-flavor/")
  public fun getBerryFlavorListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion Berries

  // region Contests

  @GET("contest-type/")
  public fun getContestTypeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("contest-effect/")
  public fun getContestEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<ApiResourceList>

  @GET("super-contest-effect/")
  public fun getSuperContestEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<ApiResourceList>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/")
  public fun getEncounterMethodListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("encounter-condition/")
  public fun getEncounterConditionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("encounter-condition-value/")
  public fun getEncounterConditionValueListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Evolution

  @GET("evolution-chain/")
  public fun getEvolutionChainListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<ApiResourceList>

  @GET("evolution-trigger/")
  public fun getEvolutionTriggerListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Games

  @GET("generation/")
  public fun getGenerationListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokedex/")
  public fun getPokedexListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("version/")
  public fun getVersionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("version-group/")
  public fun getVersionGroupListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Items

  @GET("item/")
  public fun getItemListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("item-attribute/")
  public fun getItemAttributeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("item-category/")
  public fun getItemCategoryListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("item-fling-effect/")
  public fun getItemFlingEffectListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("item-pocket/")
  public fun getItemPocketListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Moves

  @GET("move/")
  public fun getMoveListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-ailment/")
  public fun getMoveAilmentListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-battle-style/")
  public fun getMoveBattleStyleListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-category/")
  public fun getMoveCategoryListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-damage-class/")
  public fun getMoveDamageClassListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-learn-method/")
  public fun getMoveLearnMethodListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("move-target/")
  public fun getMoveTargetListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Locations

  @GET("location/")
  public fun getLocationListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("location-area/")
  public fun getLocationAreaListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pal-park-area/")
  public fun getPalParkAreaListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("region/")
  public fun getRegionListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Machines

  @GET("machine/")
  public fun getMachineListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<ApiResourceList>

  // endregion

  // region Pokemon

  @GET("ability/")
  public fun getAbilityListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("characteristic/")
  public fun getCharacteristicListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<ApiResourceList>

  @GET("egg-group/")
  public fun getEggGroupListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("gender/")
  public fun getGenderListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("growth-rate/")
  public fun getGrowthRateListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("nature/")
  public fun getNatureListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokeathlon-stat/")
  public fun getPokeathlonStatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon/")
  public fun getPokemonListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon-color/")
  public fun getPokemonColorListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon-form/")
  public fun getPokemonFormListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon-habitat/")
  public fun getPokemonHabitatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon-shape/")
  public fun getPokemonShapeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("pokemon-species/")
  public fun getPokemonSpeciesListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("stat/")
  public fun getStatListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  @GET("type/")
  public fun getTypeListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // region Utility

  @GET("language/")
  public fun getLanguageListAsync(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Future<NamedApiResourceList>

  // endregion

  // endregion

  // region Berries

  @GET("berry/{id}/") public fun getBerryAsync(@Path("id") id: Int): Future<Berry>

  @GET("berry-firmness/{id}/")
  public fun getBerryFirmnessAsync(@Path("id") id: Int): Future<BerryFirmness>

  @GET("berry-flavor/{id}/")
  public fun getBerryFlavorAsync(@Path("id") id: Int): Future<BerryFlavor>

  // endregion Berries

  // region Contests

  @GET("contest-type/{id}/")
  public fun getContestTypeAsync(@Path("id") id: Int): Future<ContestType>

  @GET("contest-effect/{id}/")
  public fun getContestEffectAsync(@Path("id") id: Int): Future<ContestEffect>

  @GET("super-contest-effect/{id}/")
  public fun getSuperContestEffectAsync(@Path("id") id: Int): Future<SuperContestEffect>

  // endregion Contests

  // region Encounters

  @GET("encounter-method/{id}/")
  public fun getEncounterMethodAsync(@Path("id") id: Int): Future<EncounterMethod>

  @GET("encounter-condition/{id}/")
  public fun getEncounterConditionAsync(@Path("id") id: Int): Future<EncounterCondition>

  @GET("encounter-condition-value/{id}/")
  public fun getEncounterConditionValueAsync(@Path("id") id: Int): Future<EncounterConditionValue>

  // endregion Contests

  // region Evolution

  @GET("evolution-chain/{id}/")
  public fun getEvolutionChainAsync(@Path("id") id: Int): Future<EvolutionChain>

  @GET("evolution-trigger/{id}/")
  public fun getEvolutionTriggerAsync(@Path("id") id: Int): Future<EvolutionTrigger>

  // endregion Evolution

  // region Games

  @GET("generation/{id}/") public fun getGenerationAsync(@Path("id") id: Int): Future<Generation>

  @GET("pokedex/{id}/") public fun getPokedexAsync(@Path("id") id: Int): Future<Pokedex>

  @GET("version/{id}/") public fun getVersionAsync(@Path("id") id: Int): Future<Version>

  @GET("version-group/{id}/")
  public fun getVersionGroupAsync(@Path("id") id: Int): Future<VersionGroup>

  // endregion Games

  // region Items

  @GET("item/{id}/") public fun getItemAsync(@Path("id") id: Int): Future<Item>

  @GET("item-attribute/{id}/")
  public fun getItemAttributeAsync(@Path("id") id: Int): Future<ItemAttribute>

  @GET("item-category/{id}/")
  public fun getItemCategoryAsync(@Path("id") id: Int): Future<ItemCategory>

  @GET("item-fling-effect/{id}/")
  public fun getItemFlingEffectAsync(@Path("id") id: Int): Future<ItemFlingEffect>

  @GET("item-pocket/{id}/") public fun getItemPocketAsync(@Path("id") id: Int): Future<ItemPocket>

  // endregion Items

  // region Moves

  @GET("move/{id}/") public fun getMoveAsync(@Path("id") id: Int): Future<Move>

  @GET("move-ailment/{id}/")
  public fun getMoveAilmentAsync(@Path("id") id: Int): Future<MoveAilment>

  @GET("move-battle-style/{id}/")
  public fun getMoveBattleStyleAsync(@Path("id") id: Int): Future<MoveBattleStyle>

  @GET("move-category/{id}/")
  public fun getMoveCategoryAsync(@Path("id") id: Int): Future<MoveCategory>

  @GET("move-damage-class/{id}/")
  public fun getMoveDamageClassAsync(@Path("id") id: Int): Future<MoveDamageClass>

  @GET("move-learn-method/{id}/")
  public fun getMoveLearnMethodAsync(@Path("id") id: Int): Future<MoveLearnMethod>

  @GET("move-target/{id}/") public fun getMoveTargetAsync(@Path("id") id: Int): Future<MoveTarget>

  // endregion Moves

  // region Locations

  @GET("location/{id}/") public fun getLocationAsync(@Path("id") id: Int): Future<Location>

  @GET("location-area/{id}/")
  public fun getLocationAreaAsync(@Path("id") id: Int): Future<LocationArea>

  @GET("pal-park-area/{id}/")
  public fun getPalParkAreaAsync(@Path("id") id: Int): Future<PalParkArea>

  @GET("region/{id}/") public fun getRegionAsync(@Path("id") id: Int): Future<Region>

  // endregion Locations

  // region Machines

  @GET("machine/{id}/") public fun getMachineAsync(@Path("id") id: Int): Future<Machine>

  // endregion

  // region Pokemon

  @GET("ability/{id}/") public fun getAbilityAsync(@Path("id") id: Int): Future<Ability>

  @GET("characteristic/{id}/")
  public fun getCharacteristicAsync(@Path("id") id: Int): Future<Characteristic>

  @GET("egg-group/{id}/") public fun getEggGroupAsync(@Path("id") id: Int): Future<EggGroup>

  @GET("gender/{id}/") public fun getGenderAsync(@Path("id") id: Int): Future<Gender>

  @GET("growth-rate/{id}/") public fun getGrowthRateAsync(@Path("id") id: Int): Future<GrowthRate>

  @GET("nature/{id}/") public fun getNatureAsync(@Path("id") id: Int): Future<Nature>

  @GET("pokeathlon-stat/{id}/")
  public fun getPokeathlonStatAsync(@Path("id") id: Int): Future<PokeathlonStat>

  @GET("pokemon/{id}/") public fun getPokemonAsync(@Path("id") id: Int): Future<Pokemon>

  @GET("pokemon/{id}/encounters/")
  public fun getPokemonEncounterListAsync(@Path("id") id: Int): Future<List<LocationAreaEncounter>>

  @GET("pokemon-color/{id}/")
  public fun getPokemonColorAsync(@Path("id") id: Int): Future<PokemonColor>

  @GET("pokemon-form/{id}/")
  public fun getPokemonFormAsync(@Path("id") id: Int): Future<PokemonForm>

  @GET("pokemon-habitat/{id}/")
  public fun getPokemonHabitatAsync(@Path("id") id: Int): Future<PokemonHabitat>

  @GET("pokemon-shape/{id}/")
  public fun getPokemonShapeAsync(@Path("id") id: Int): Future<PokemonShape>

  @GET("pokemon-species/{id}/")
  public fun getPokemonSpeciesAsync(@Path("id") id: Int): Future<PokemonSpecies>

  @GET("stat/{id}/") public fun getStatAsync(@Path("id") id: Int): Future<Stat>

  @GET("type/{id}/") public fun getTypeAsync(@Path("id") id: Int): Future<Type>

  // endregion Pokemon

  // region Utility

  @GET("language/{id}/") public fun getLanguageAsync(@Path("id") id: Int): Future<Language>

  // endregion Utility
}
