package me.sargunvohra.lib.pokekotlin.retrofit

import me.sargunvohra.lib.pokekotlin.json.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokeApiRetrofit {

    // region Resource Lists

    // region Berries

    @GET("berry/")
    fun getBerryList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("berry-firmness/")
    fun getBerryFirmnessList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("berry-flavor/")
    fun getBerryFlavorList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion Berries

    // region Contests

    @GET("contest-type/")
    fun getContestTypeList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("contest-effect/")
    fun getContestEffectList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<ApiResourceList>

    @GET("super-contest-effect/")
    fun getSuperContestEffectList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<ApiResourceList>

    // endregion Contests

    // region Encounters

    @GET("encounter-method/")
    fun getEncounterMethodList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("encounter-condition/")
    fun getEncounterConditionList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("encounter-condition-value/")
    fun getEncounterConditionValueList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    // region Evolution

    @GET("evolution-chain/")
    fun getEvolutionChainList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<ApiResourceList>

    @GET("evolution-trigger/")
    fun getEvolutionTriggerList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    //region Games

    @GET("generation/")
    fun getGenerationList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokedex/")
    fun getPokedexList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("version/")
    fun getVersionList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("version-group/")
    fun getVersionGroupList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    // region Items

    @GET("item/")
    fun getItemList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("item-attribute/")
    fun getItemAttributeList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("item-category/")
    fun getItemCategoryList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("item-fling-effect/")
    fun getItemFlingEffectList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("item-pocket/")
    fun getItemPocketList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    //region Moves

    @GET("move/")
    fun getMoveList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-ailment/")
    fun getMoveAilmentList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-battle-style/")
    fun getMoveBattleStyleList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-category/")
    fun getMoveCategoryList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-damage-class/")
    fun getMoveDamageClassList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-learn-method/")
    fun getMoveLearnMethodList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("move-target/")
    fun getMoveTargetList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    // region Locations

    @GET("location/")
    fun getLocationList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("location-area/")
    fun getLocationAreaList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pal-park-area/")
    fun getPalParkAreaList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("region/")
    fun getRegionList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    // region Pokemon

    @GET("ability/")
    fun getAbilityList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("characteristic/")
    fun getCharacteristicList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<ApiResourceList>

    @GET("egg-group/")
    fun getEggGroupList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("gender/")
    fun getGenderList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("growth-rate/")
    fun getGrowthRateList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("nature/")
    fun getNatureList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokeathlon-stat/")
    fun getPokeathlonStatList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon/")
    fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon-color/")
    fun getPokemonColorList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon-form/")
    fun getPokemonFormList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon-habitat/")
    fun getPokemonHabitatList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon-shape/")
    fun getPokemonShapeList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("pokemon-species/")
    fun getPokemonSpeciesList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("stat/")
    fun getStatList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    @GET("type/")
    fun getTypeList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

    // endregion

    // region Utility

    @GET("language/")
    fun getLanguageList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<NamedApiResourceList>

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

    // region Evolution

    @GET("evolution-chain/{id}/")
    fun getEvolutionChain(@Path("id") id: Int): Call<EvolutionChain>

    @GET("evolution-trigger/{id}/")
    fun getEvolutionTrigger(@Path("id") id: Int): Call<EvolutionTrigger>

    // endregion Evolution

    // region Games

    @GET("generation/{id}/")
    fun getGeneration(@Path("id") id: Int): Call<Generation>

    @GET("pokedex/{id}/")
    fun getPokedex(@Path("id") id: Int): Call<Pokedex>

    @GET("version/{id}/")
    fun getVersion(@Path("id") id: Int): Call<Version>

    @GET("version-group/{id}/")
    fun getVersionGroup(@Path("id") id: Int): Call<VersionGroup>

    // endregion Games

    // region Items

    @GET("item/{id}/")
    fun getItem(@Path("id") id: Int): Call<Item>

    @GET("item-attribute/{id}/")
    fun getItemAttribute(@Path("id") id: Int): Call<ItemAttribute>

    @GET("item-category/{id}/")
    fun getItemCategory(@Path("id") id: Int): Call<ItemCategory>

    @GET("item-fling-effect/{id}/")
    fun getItemFlingEffect(@Path("id") id: Int): Call<ItemFlingEffect>

    @GET("item-pocket/{id}/")
    fun getItemPocket(@Path("id") id: Int): Call<ItemPocket>

    // endregion Items

    // region Moves

    @GET("move/{id}/")
    fun getMove(@Path("id") id: Int): Call<Move>

    @GET("move-ailment/{id}/")
    fun getMoveAilment(@Path("id") id: Int): Call<MoveAilment>

    @GET("move-battle-style/{id}/")
    fun getMoveBattleStyle(@Path("id") id: Int): Call<MoveBattleStyle>

    @GET("move-category/{id}/")
    fun getMoveCategory(@Path("id") id: Int): Call<MoveCategory>

    @GET("move-damage-class/{id}/")
    fun getMoveDamageClass(@Path("id") id: Int): Call<MoveDamageClass>

    @GET("move-learn-method/{id}/")
    fun getMoveLearnMethod(@Path("id") id: Int): Call<MoveLearnMethod>

    @GET("move-target/{id}/")
    fun getMoveTarget(@Path("id") id: Int): Call<MoveTarget>

    // endregion Moves

    // region Locations

    @GET("location/{id}/")
    fun getLocation(@Path("id") id: Int): Call<Location>

    @GET("location-area/{id}/")
    fun getLocationArea(@Path("id") id: Int): Call<LocationArea>

    @GET("pal-park-area/{id}/")
    fun getPalParkArea(@Path("id") id: Int): Call<PalParkArea>

    @GET("region/{id}/")
    fun getRegion(@Path("id") id: Int): Call<Region>

    // endregion Locations

    // region Pokemon

    @GET("ability/{id}/")
    fun getAbility(@Path("id") id: Int): Call<Ability>

    @GET("characteristic/{id}/")
    fun getCharacteristic(@Path("id") id: Int): Call<Characteristic>

    @GET("egg-group/{id}/")
    fun getEggGroup(@Path("id") id: Int): Call<EggGroup>

    @GET("gender/{id}/")
    fun getGender(@Path("id") id: Int): Call<Gender>

    @GET("growth-rate/{id}/")
    fun getGrowthRate(@Path("id") id: Int): Call<GrowthRate>

    @GET("nature/{id}/")
    fun getNature(@Path("id") id: Int): Call<Nature>

    @GET("pokeathlon-stat/{id}/")
    fun getPokeathlonStat(@Path("id") id: Int): Call<PokeathlonStat>

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>

    @GET("pokemon/{id}/encounters/")
    fun getPokemonEncounters(@Path("id") id: Int): Call<List<LocationAreaEncounter>>

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): Call<PokemonColor>

    @GET("pokemon-form/{id}/")
    fun getPokemonForm(@Path("id") id: Int): Call<PokemonForm>

    @GET("pokemon-habitat/{id}/")
    fun getPokemonHabitat(@Path("id") id: Int): Call<PokemonHabitat>

    @GET("pokemon-shape/{id}/")
    fun getPokemonShape(@Path("id") id: Int): Call<PokemonShape>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): Call<PokemonSpecies>

    @GET("stat/{id}/")
    fun getStat(@Path("id") id: Int): Call<Stat>

    @GET("type/{id}/")
    fun getType(@Path("id") id: Int): Call<Type>

    // endregion Pokemon

    // region Utility

    @GET("language/{id}/")
    fun getLanguage(@Path("id") id: Int): Call<Language>

    // endregion Utility
}
