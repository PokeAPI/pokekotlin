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