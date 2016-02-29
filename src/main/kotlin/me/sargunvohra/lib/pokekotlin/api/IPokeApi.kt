package me.sargunvohra.lib.pokekotlin.api

import me.sargunvohra.lib.pokekotlin.json.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface IPokeApi {

    // region Resource Lists

    // region Berries

    @GET("berry/")
    fun getBerryList(): Call<List<NamedApiResource<Berry>>>

    @GET("berry-firmness/")
    fun getBerryFirmnessList(): Call<List<NamedApiResource<BerryFirmness>>>

    @GET("berry-flavor/")
    fun getBerryFlavorList(): Call<List<NamedApiResource<BerryFlavor>>>

    // endregion Berries

    // region Contests

    @GET("contest-type/")
    fun getContestTypeList(): Call<List<NamedApiResource<ContestType>>>

    @GET("contest-effect/")
    fun getContestEffectList(): Call<List<ApiResource<ContestEffect>>>

    @GET("super-contest-effect/")
    fun getSuperContestEffectList(): Call<List<ApiResource<SuperContestEffect>>>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/")
    fun getEncounterMethodList(): Call<List<NamedApiResource<EncounterMethod>>>

    @GET("encounter-condition/")
    fun getEncounterConditionList(): Call<List<NamedApiResource<EncounterCondition>>>

    @GET("encounter-condition-value/")
    fun getEncounterConditionValueList(): Call<List<NamedApiResource<EncounterConditionValue>>>

    // endregion

    // region Evolution

    @GET("evolution-chain/")
    fun getEvolutionChainList(): Call<List<ApiResource<EvolutionChain>>>

    @GET("evolution-trigger/")
    fun getEvolutionTriggerList(): Call<List<NamedApiResource<EvolutionTrigger>>>

    // endregion

    //region Games

    @GET("generation/")
    fun getGenerationList(): Call<List<NamedApiResource<Generation>>>

    @GET("pokedex/")
    fun getPokedexList(): Call<List<NamedApiResource<Pokedex>>>

    @GET("version/")
    fun getVersionList(): Call<List<NamedApiResource<Version>>>

    @GET("version-group/")
    fun getVersionGroupList(): Call<List<NamedApiResource<VersionGroup>>>

    // endregion

    // region Items

    @GET("item/")
    fun getItemList(): Call<List<NamedApiResource<Item>>>

    @GET("item-attribute/")
    fun getItemAttributeList(): Call<List<NamedApiResource<ItemAttribute>>>

    @GET("item-category/")
    fun getItemCategoryList(): Call<List<NamedApiResource<ItemCategory>>>

    @GET("item-fling-effect/")
    fun getItemFlingEffectList(): Call<List<NamedApiResource<ItemFlingEffect>>>

    @GET("item-pocket/")
    fun getItemPocketList(): Call<List<NamedApiResource<ItemPocket>>>

    // endregion

    //region Moves

    @GET("move/")
    fun getMoveList(): Call<List<NamedApiResource<Move>>>

    @GET("move-ailment/")
    fun getMoveAilmentList(): Call<List<NamedApiResource<MoveAilment>>>

    @GET("move-battle-style/")
    fun getMoveBattleStyleList(): Call<List<NamedApiResource<MoveBattleStyle>>>

    @GET("move-category/")
    fun getMoveCategoryList(): Call<List<NamedApiResource<MoveCategory>>>

    @GET("move-damage-class/")
    fun getMoveDamageClassList(): Call<List<NamedApiResource<MoveDamageClass>>>

    @GET("move-learn-method/")
    fun getMoveLearnMethodList(): Call<List<NamedApiResource<MoveLearnMethod>>>

    @GET("move-target/")
    fun getMoveTargetList(): Call<List<NamedApiResource<MoveTarget>>>

    // endregion

    // region Locations

    @GET("location/")
    fun getLocationList(): Call<List<NamedApiResource<Location>>>

    @GET("location-area/")
    fun getLocationAreaList(): Call<List<NamedApiResource<LocationArea>>>

    @GET("pal-park-area/")
    fun getPalParkAreaList(): Call<List<NamedApiResource<PalParkArea>>>

    @GET("region/")
    fun getRegionList(): Call<List<NamedApiResource<Region>>>

    // endregion

    // region Pokemon

    @GET("ability/")
    fun getAbilityList(): Call<List<NamedApiResource<Ability>>>

    @GET("characteristic/")
    fun getCharacteristicList(): Call<List<ApiResource<Characteristic>>>

    @GET("egg-group/")
    fun getEggGroupList(): Call<List<NamedApiResource<EggGroup>>>

    @GET("gender/")
    fun getGenderList(): Call<List<NamedApiResource<Gender>>>

    @GET("growth-rate/")
    fun getGrowthRateList(): Call<List<NamedApiResource<GrowthRate>>>

    @GET("nature/")
    fun getNatureList(): Call<List<NamedApiResource<Nature>>>

    @GET("pokeathlon-stat/")
    fun getPokeathlonList(): Call<List<NamedApiResource<PokeathlonStat>>>

    @GET("pokemon/")
    fun getPokemonList(): Call<List<NamedApiResource<Pokemon>>>

    @GET("pokemon-color/")
    fun getPokemonColorList(): Call<List<NamedApiResource<PokemonColor>>>

    @GET("pokemon-form/")
    fun getPokemonFormList(): Call<List<NamedApiResource<PokemonForm>>>

    @GET("pokemon-habitat/")
    fun getPokemonHabitatList(): Call<List<NamedApiResource<PokemonHabitat>>>

    @GET("pokemon-shape/")
    fun getPokemonShapeList(): Call<List<NamedApiResource<PokemonShape>>>

    @GET("pokemon-species/")
    fun getPokemonSpeciesList(): Call<List<NamedApiResource<PokemonSpecies>>>

    @GET("stat/")
    fun getPokemonStatList(): Call<List<NamedApiResource<Stat>>>

    @GET("type/")
    fun getPokemonTypeList(): Call<List<NamedApiResource<Type>>>

    // endregion

    // region Utility

    @GET("language/")
    fun getLanguageList(): Call<List<NamedApiResource<Language>>>

    // endregion

    // endregion

    // region Berries

    @GET("berry/{id}/")
    fun getBerry(@Path("id") id: Int): Call<Berry>

    @GET("berry-firmness/{id}/")
    fun getBerryFirmness(@Path("id") id: Int): Call<BerryFirmness>

    @GET("berry-flavor/{id}/")
    fun getBerryFlavor(@Path("id") id: Int): Call<BerryFlavor>

    // endregion Berries

    // region Contests

    @GET("contest-type/{id}/")
    fun getContestType(@Path("id") id: Int): Call<ContestType>

    @GET("contest-effect/{id}/")
    fun getContestEffect(@Path("id") id: Int): Call<ContestEffect>

    @GET("super-contest-effect/{id}/")
    fun getSuperContestEffect(@Path("id") id: Int): Call<SuperContestEffect>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/{id}/")
    fun getEncounterMethod(@Path("id") id: Int): Call<EncounterMethod>

    @GET("encounter-condition/{id}/")
    fun getEncounterCondition(@Path("id") id: Int): Call<EncounterCondition>

    @GET("encounter-condition-value/{id}/")
    fun getEncounterConditionValue(@Path("id") id: Int): Call<EncounterConditionValue>

    // endregion Contests
}