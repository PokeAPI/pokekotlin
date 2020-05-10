package me.sargunvohra.lib.pokekotlin.client

import me.sargunvohra.lib.pokekotlin.model.Ability
import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.Berry
import me.sargunvohra.lib.pokekotlin.model.BerryFirmness
import me.sargunvohra.lib.pokekotlin.model.BerryFlavor
import me.sargunvohra.lib.pokekotlin.model.Characteristic
import me.sargunvohra.lib.pokekotlin.model.ContestEffect
import me.sargunvohra.lib.pokekotlin.model.ContestType
import me.sargunvohra.lib.pokekotlin.model.EggGroup
import me.sargunvohra.lib.pokekotlin.model.EncounterCondition
import me.sargunvohra.lib.pokekotlin.model.EncounterConditionValue
import me.sargunvohra.lib.pokekotlin.model.EncounterMethod
import me.sargunvohra.lib.pokekotlin.model.EvolutionChain
import me.sargunvohra.lib.pokekotlin.model.EvolutionTrigger
import me.sargunvohra.lib.pokekotlin.model.Gender
import me.sargunvohra.lib.pokekotlin.model.Generation
import me.sargunvohra.lib.pokekotlin.model.GrowthRate
import me.sargunvohra.lib.pokekotlin.model.Item
import me.sargunvohra.lib.pokekotlin.model.ItemAttribute
import me.sargunvohra.lib.pokekotlin.model.ItemCategory
import me.sargunvohra.lib.pokekotlin.model.ItemFlingEffect
import me.sargunvohra.lib.pokekotlin.model.ItemPocket
import me.sargunvohra.lib.pokekotlin.model.Language
import me.sargunvohra.lib.pokekotlin.model.Location
import me.sargunvohra.lib.pokekotlin.model.LocationArea
import me.sargunvohra.lib.pokekotlin.model.LocationAreaEncounter
import me.sargunvohra.lib.pokekotlin.model.Machine
import me.sargunvohra.lib.pokekotlin.model.Move
import me.sargunvohra.lib.pokekotlin.model.MoveAilment
import me.sargunvohra.lib.pokekotlin.model.MoveBattleStyle
import me.sargunvohra.lib.pokekotlin.model.MoveCategory
import me.sargunvohra.lib.pokekotlin.model.MoveDamageClass
import me.sargunvohra.lib.pokekotlin.model.MoveLearnMethod
import me.sargunvohra.lib.pokekotlin.model.MoveTarget
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.model.Nature
import me.sargunvohra.lib.pokekotlin.model.PalParkArea
import me.sargunvohra.lib.pokekotlin.model.PokeathlonStat
import me.sargunvohra.lib.pokekotlin.model.Pokedex
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonColor
import me.sargunvohra.lib.pokekotlin.model.PokemonForm
import me.sargunvohra.lib.pokekotlin.model.PokemonHabitat
import me.sargunvohra.lib.pokekotlin.model.PokemonShape
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies
import me.sargunvohra.lib.pokekotlin.model.Region
import me.sargunvohra.lib.pokekotlin.model.Stat
import me.sargunvohra.lib.pokekotlin.model.SuperContestEffect
import me.sargunvohra.lib.pokekotlin.model.Type
import me.sargunvohra.lib.pokekotlin.model.Version
import me.sargunvohra.lib.pokekotlin.model.VersionGroup
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

internal interface RxPokeApiService {

    // region Resource Lists

    // region Berries

    @GET("berry/")
    fun getBerryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("berry-firmness/")
    fun getBerryFirmnessList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("berry-flavor/")
    fun getBerryFlavorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion Berries

    // region Contests

    @GET("contest-type/")
    fun getContestTypeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("contest-effect/")
    fun getContestEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("super-contest-effect/")
    fun getSuperContestEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/")
    fun getEncounterMethodList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("encounter-condition/")
    fun getEncounterConditionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("encounter-condition-value/")
    fun getEncounterConditionValueList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Evolution

    @GET("evolution-chain/")
    fun getEvolutionChainList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("evolution-trigger/")
    fun getEvolutionTriggerList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    //region Games

    @GET("generation/")
    fun getGenerationList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokedex/")
    fun getPokedexList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("version/")
    fun getVersionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("version-group/")
    fun getVersionGroupList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Items

    @GET("item/")
    fun getItemList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-attribute/")
    fun getItemAttributeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-category/")
    fun getItemCategoryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-fling-effect/")
    fun getItemFlingEffectList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("item-pocket/")
    fun getItemPocketList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    //region Moves

    @GET("move/")
    fun getMoveList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-ailment/")
    fun getMoveAilmentList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-battle-style/")
    fun getMoveBattleStyleList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-category/")
    fun getMoveCategoryList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-damage-class/")
    fun getMoveDamageClassList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-learn-method/")
    fun getMoveLearnMethodList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("move-target/")
    fun getMoveTargetList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Locations

    @GET("location/")
    fun getLocationList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("location-area/")
    fun getLocationAreaList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pal-park-area/")
    fun getPalParkAreaList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("region/")
    fun getRegionList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Machines

    @GET("machine/")
    fun getMachineList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    // endregion

    // region Pokemon

    @GET("ability/")
    fun getAbilityList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("characteristic/")
    fun getCharacteristicList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("egg-group/")
    fun getEggGroupList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("gender/")
    fun getGenderList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("growth-rate/")
    fun getGrowthRateList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("nature/")
    fun getNatureList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokeathlon-stat/")
    fun getPokeathlonStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon/")
    fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-color/")
    fun getPokemonColorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-form/")
    fun getPokemonFormList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-habitat/")
    fun getPokemonHabitatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-shape/")
    fun getPokemonShapeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-species/")
    fun getPokemonSpeciesList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("stat/")
    fun getStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("type/")
    fun getTypeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // region Utility

    @GET("language/")
    fun getLanguageList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    // endregion

    // endregion

    // region Berries

    @GET("berry/{id}/")
    fun getBerry(@Path("id") id: Int): Observable<Berry>

    @GET("berry-firmness/{id}/")
    fun getBerryFirmness(@Path("id") id: Int): Observable<BerryFirmness>

    @GET("berry-flavor/{id}/")
    fun getBerryFlavor(@Path("id") id: Int): Observable<BerryFlavor>

    // endregion Berries

    // region Contests

    @GET("contest-type/{id}/")
    fun getContestType(@Path("id") id: Int): Observable<ContestType>

    @GET("contest-effect/{id}/")
    fun getContestEffect(@Path("id") id: Int): Observable<ContestEffect>

    @GET("super-contest-effect/{id}/")
    fun getSuperContestEffect(@Path("id") id: Int): Observable<SuperContestEffect>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/{id}/")
    fun getEncounterMethod(@Path("id") id: Int): Observable<EncounterMethod>

    @GET("encounter-condition/{id}/")
    fun getEncounterCondition(@Path("id") id: Int): Observable<EncounterCondition>

    @GET("encounter-condition-value/{id}/")
    fun getEncounterConditionValue(@Path("id") id: Int): Observable<EncounterConditionValue>

    // endregion Contests

    // region Evolution

    @GET("evolution-chain/{id}/")
    fun getEvolutionChain(@Path("id") id: Int): Observable<EvolutionChain>

    @GET("evolution-trigger/{id}/")
    fun getEvolutionTrigger(@Path("id") id: Int): Observable<EvolutionTrigger>

    // endregion Evolution

    // region Games

    @GET("generation/{id}/")
    fun getGeneration(@Path("id") id: Int): Observable<Generation>

    @GET("pokedex/{id}/")
    fun getPokedex(@Path("id") id: Int): Observable<Pokedex>

    @GET("version/{id}/")
    fun getVersion(@Path("id") id: Int): Observable<Version>

    @GET("version-group/{id}/")
    fun getVersionGroup(@Path("id") id: Int): Observable<VersionGroup>

    // endregion Games

    // region Items

    @GET("item/{id}/")
    fun getItem(@Path("id") id: Int): Observable<Item>

    @GET("item-attribute/{id}/")
    fun getItemAttribute(@Path("id") id: Int): Observable<ItemAttribute>

    @GET("item-category/{id}/")
    fun getItemCategory(@Path("id") id: Int): Observable<ItemCategory>

    @GET("item-fling-effect/{id}/")
    fun getItemFlingEffect(@Path("id") id: Int): Observable<ItemFlingEffect>

    @GET("item-pocket/{id}/")
    fun getItemPocket(@Path("id") id: Int): Observable<ItemPocket>

    // endregion Items

    // region Moves

    @GET("move/{id}/")
    fun getMove(@Path("id") id: Int): Observable<Move>

    @GET("move-ailment/{id}/")
    fun getMoveAilment(@Path("id") id: Int): Observable<MoveAilment>

    @GET("move-battle-style/{id}/")
    fun getMoveBattleStyle(@Path("id") id: Int): Observable<MoveBattleStyle>

    @GET("move-category/{id}/")
    fun getMoveCategory(@Path("id") id: Int): Observable<MoveCategory>

    @GET("move-damage-class/{id}/")
    fun getMoveDamageClass(@Path("id") id: Int): Observable<MoveDamageClass>

    @GET("move-learn-method/{id}/")
    fun getMoveLearnMethod(@Path("id") id: Int): Observable<MoveLearnMethod>

    @GET("move-target/{id}/")
    fun getMoveTarget(@Path("id") id: Int): Observable<MoveTarget>

    // endregion Moves

    // region Locations

    @GET("location/{id}/")
    fun getLocation(@Path("id") id: Int): Observable<Location>

    @GET("location-area/{id}/")
    fun getLocationArea(@Path("id") id: Int): Observable<LocationArea>

    @GET("pal-park-area/{id}/")
    fun getPalParkArea(@Path("id") id: Int): Observable<PalParkArea>

    @GET("region/{id}/")
    fun getRegion(@Path("id") id: Int): Observable<Region>

    // endregion Locations

    // region Machines

    @GET("machine/{id}/")
    fun getMachine(@Path("id") id: Int): Observable<Machine>

    // endregion

    // region Pokemon

    @GET("ability/{id}/")
    fun getAbility(@Path("id") id: Int): Observable<Ability>

    @GET("characteristic/{id}/")
    fun getCharacteristic(@Path("id") id: Int): Observable<Characteristic>

    @GET("egg-group/{id}/")
    fun getEggGroup(@Path("id") id: Int): Observable<EggGroup>

    @GET("gender/{id}/")
    fun getGender(@Path("id") id: Int): Observable<Gender>

    @GET("growth-rate/{id}/")
    fun getGrowthRate(@Path("id") id: Int): Observable<GrowthRate>

    @GET("nature/{id}/")
    fun getNature(@Path("id") id: Int): Observable<Nature>

    @GET("pokeathlon-stat/{id}/")
    fun getPokeathlonStat(@Path("id") id: Int): Observable<PokeathlonStat>

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Observable<Pokemon>

    @GET("pokemon/{id}/encounters/")
    fun getPokemonEncounterList(@Path("id") id: Int): Observable<List<LocationAreaEncounter>>

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): Observable<PokemonColor>

    @GET("pokemon-form/{id}/")
    fun getPokemonForm(@Path("id") id: Int): Observable<PokemonForm>

    @GET("pokemon-habitat/{id}/")
    fun getPokemonHabitat(@Path("id") id: Int): Observable<PokemonHabitat>

    @GET("pokemon-shape/{id}/")
    fun getPokemonShape(@Path("id") id: Int): Observable<PokemonShape>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): Observable<PokemonSpecies>

    @GET("stat/{id}/")
    fun getStat(@Path("id") id: Int): Observable<Stat>

    @GET("type/{id}/")
    fun getType(@Path("id") id: Int): Observable<Type>

    // endregion Pokemon

    // region Utility

    @GET("language/{id}/")
    fun getLanguage(@Path("id") id: Int): Observable<Language>

    // endregion Utility
}
