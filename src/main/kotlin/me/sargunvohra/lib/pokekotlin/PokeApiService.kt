package me.sargunvohra.lib.pokekotlin

import me.sargunvohra.lib.pokekotlin.json.*
import retrofit2.Call
import retrofit2.http.GET

interface PokeApiService {

    // region Resource Lists

    // region Berries

    @GET("berry")
    fun getBerryList(): Call<List<JsonNamedApiResource<JsonBerry>>>

    @GET("berry-firmness")
    fun getBerryFirmnessList(): Call<List<JsonNamedApiResource<JsonBerryFirmness>>>

    @GET("berry-flavor")
    fun getBerryFlavorList(): Call<List<JsonNamedApiResource<JsonBerryFlavor>>>

    // endregion Berries

    // region Contests

    @GET("contest-type")
    fun getContestTypeList(): Call<List<JsonNamedApiResource<JsonContestType>>>

    @GET("contest-effect")
    fun getContestEffectList(): Call<List<JsonApiResource<JsonContestEffect>>>

    @GET("super-contest-effect")
    fun getSuperContestTypeList(): Call<List<JsonApiResource<JsonSuperContestEffect>>>

    // endregion Contests

    // region Encounters

    @GET("encounter-method")
    fun getEncounterMethodList(): Call<List<JsonNamedApiResource<JsonEncounterMethod>>>

    @GET("encounter-condition")
    fun getEncounterConditionList(): Call<List<JsonNamedApiResource<JsonEncounterCondition>>>

    @GET("encounter-condition-value")
    fun getEncounterConditionValueList(): Call<List<JsonNamedApiResource<JsonEncounterConditionValue>>>

    // endregion

    // region Evolution

    @GET("evolution-chain")
    fun getEvolutionChainList(): Call<List<JsonApiResource<JsonEvolutionChain>>>

    @GET("evolution-trigger")
    fun getEvolutionTriggerList(): Call<List<JsonNamedApiResource<JsonEvolutionTrigger>>>

    // endregion

    //region Games

    @GET("generation")
    fun getGenerationList(): Call<List<JsonNamedApiResource<JsonGeneration>>>

    @GET("pokedex")
    fun getPokedexList(): Call<List<JsonNamedApiResource<JsonPokedex>>>

    @GET("version")
    fun getVersionList(): Call<List<JsonNamedApiResource<JsonVersion>>>

    @GET("version-group")
    fun getVersionGroupList(): Call<List<JsonNamedApiResource<JsonVersionGroup>>>

    // endregion

    // region Items

    @GET("item")
    fun getItemList(): Call<List<JsonNamedApiResource<JsonItem>>>

    @GET("item-attribute")
    fun getItemAttributeList(): Call<List<JsonNamedApiResource<JsonItemAttribute>>>

    @GET("item-category")
    fun getItemCategoryList(): Call<List<JsonNamedApiResource<JsonItemCategory>>>

    @GET("item-fling-effect")
    fun getItemFlingEffectList(): Call<List<JsonNamedApiResourceList<JsonItemFlingEffect>>>

    @GET("item-pocket")
    fun getItemPocketList(): Call<List<JsonNamedApiResource<JsonItemPocket>>>

    // endregion

    //region Moves

    @GET("move")
    fun getMoveList(): Call<List<JsonNamedApiResource<JsonMove>>>

    @GET("move-ailment")
    fun getMoveAilmentList(): Call<List<JsonNamedApiResource<JsonMoveAilment>>>

    @GET("move-battle-style")
    fun getMoveBattleStyleList(): Call<List<JsonNamedApiResource<JsonMoveBattleStyle>>>

    @GET("move-category")
    fun getMoveCategoryList(): Call<List<JsonNamedApiResource<JsonMoveCategory>>>

    @GET("move-damage-class")
    fun getMoveDamageClassList(): Call<List<JsonNamedApiResource<JsonMoveDamageClass>>>

    @GET("move-learn-method")
    fun getMoveLearnMethodList(): Call<List<JsonNamedApiResource<JsonMoveLearnMethod>>>

    @GET("move-target")
    fun getMoveTargetList(): Call<List<JsonNamedApiResource<JsonMoveTarget>>>

    // endregion

    // region Locations

    @GET("location")
    fun getLocationList(): Call<List<JsonNamedApiResource<JsonLocation>>>

    @GET("location-area")
    fun getLocationAreaList(): Call<List<JsonNamedApiResource<JsonLocationArea>>>

    @GET("pal-park-area")
    fun getPalParkAreaList(): Call<List<JsonNamedApiResource<JsonPalParkArea>>>

    @GET("region")
    fun getRegionList(): Call<List<JsonNamedApiResource<JsonRegion>>>

    // endregion

    // region Pokemon

    @GET("ability")
    fun getAbilityList(): Call<List<JsonNamedApiResource<JsonAbility>>>

    @GET("characteristic")
    fun getCharacteristicList(): Call<List<JsonApiResource<JsonCharacteristic>>>

    @GET("egg-group")
    fun getEggGroupList(): Call<List<JsonNamedApiResource<JsonEggGroup>>>

    @GET("gender")
    fun getGenderList(): Call<List<JsonNamedApiResource<JsonGender>>>

    @GET("growth-rate")
    fun getGrowthRateList(): Call<List<JsonNamedApiResource<JsonGrowthRate>>>

    @GET("nature")
    fun getNatureList(): Call<List<JsonNamedApiResource<JsonNature>>>

    @GET("pokeathlon-stat")
    fun getPokeathlonList(): Call<List<JsonNamedApiResource<JsonPokeathlonStat>>>

    @GET("pokemon")
    fun getPokemonList(): Call<List<JsonNamedApiResource<JsonPokemon>>>

    @GET("pokemon-color")
    fun getPokemonColorList(): Call<List<JsonNamedApiResource<JsonPokemonColor>>>

    @GET("pokemon-form")
    fun getPokemonFormList(): Call<List<JsonNamedApiResource<JsonPokemonForm>>>

    @GET("pokemon-habitat")
    fun getPokemonHabitatList(): Call<List<JsonNamedApiResource<JsonPokemonHabitat>>>

    @GET("pokemon-shape")
    fun getPokemonShapeList(): Call<List<JsonNamedApiResource<JsonPokemonShape>>>

    @GET("pokemon-species")
    fun getPokemonSpeciesList(): Call<List<JsonNamedApiResource<JsonPokemonSpecies>>>

    @GET("stat")
    fun getPokemonStatList(): Call<List<JsonNamedApiResource<JsonStat>>>

    @GET("type")
    fun getPokemonTypeList(): Call<List<JsonNamedApiResource<JsonType>>>

    // endregion

    // region Utility

    @GET("language/")
    fun getLanguageList(): Call<List<JsonNamedApiResource<JsonLanguage>>>

    // endregion

    // endregion
}