package me.sargunvohra.lib.pokekotlin.client

import retrofit2.Call

class PokeApiHttp(
        private val clientConfig: ClientConfig = ClientConfig()
) : PokeApi {

    private val apiDefinition: RetrofitPokeApi = RetrofitPokeApiCaller(clientConfig)

    private fun <T> Call<T>.result(): T {
        return execute().let {
            if (it.isSuccessful) it.body() else throw ErrorResponse(it.code(), it.message())
        }
    }

    // region ResourceList Lists

    // region Berries

    override fun getBerryList(offset: Int, limit: Int) = apiDefinition.getBerryList(offset, limit).result()

    override fun getBerryFirmnessList(offset: Int, limit: Int) = apiDefinition.getBerryFirmnessList(offset, limit).result()

    override fun getBerryFlavorList(offset: Int, limit: Int) = apiDefinition.getBerryFlavorList(offset, limit).result()

    // endregion Berries

    // region Contests

    override fun getContestTypeList(offset: Int, limit: Int) = apiDefinition.getContestTypeList(offset, limit).result()

    override fun getContestEffectList(offset: Int, limit: Int) = apiDefinition.getContestEffectList(offset, limit).result()

    override fun getSuperContestEffectList(offset: Int, limit: Int) = apiDefinition.getSuperContestEffectList(offset, limit).result()

    // endregion Contests

    // region Encounters

    override fun getEncounterMethodList(offset: Int, limit: Int) = apiDefinition.getEncounterMethodList(offset, limit).result()

    override fun getEncounterConditionList(offset: Int, limit: Int) = apiDefinition.getEncounterConditionList(offset, limit).result()

    override fun getEncounterConditionValueList(offset: Int, limit: Int) = apiDefinition.getEncounterConditionValueList(offset, limit).result()

    // endregion

    // region Evolution

    override fun getEvolutionChainList(offset: Int, limit: Int) = apiDefinition.getEvolutionChainList(offset, limit).result()

    override fun getEvolutionTriggerList(offset: Int, limit: Int) = apiDefinition.getEvolutionTriggerList(offset, limit).result()

    // endregion

    //region Games

    override fun getGenerationList(offset: Int, limit: Int) = apiDefinition.getGenerationList(offset, limit).result()

    override fun getPokedexList(offset: Int, limit: Int) = apiDefinition.getPokedexList(offset, limit).result()

    override fun getVersionList(offset: Int, limit: Int) = apiDefinition.getVersionList(offset, limit).result()

    override fun getVersionGroupList(offset: Int, limit: Int) = apiDefinition.getVersionGroupList(offset, limit).result()

    // endregion

    // region Items

    override fun getItemList(offset: Int, limit: Int) = apiDefinition.getItemList(offset, limit).result()

    override fun getItemAttributeList(offset: Int, limit: Int) = apiDefinition.getItemAttributeList(offset, limit).result()

    override fun getItemCategoryList(offset: Int, limit: Int) = apiDefinition.getItemCategoryList(offset, limit).result()

    override fun getItemFlingEffectList(offset: Int, limit: Int) = apiDefinition.getItemFlingEffectList(offset, limit).result()

    override fun getItemPocketList(offset: Int, limit: Int) = apiDefinition.getItemPocketList(offset, limit).result()

    // endregion

    //region Moves

    override fun getMoveList(offset: Int, limit: Int) = apiDefinition.getMoveList(offset, limit).result()

    override fun getMoveAilmentList(offset: Int, limit: Int) = apiDefinition.getMoveAilmentList(offset, limit).result()

    override fun getMoveBattleStyleList(offset: Int, limit: Int) = apiDefinition.getMoveBattleStyleList(offset, limit).result()

    override fun getMoveCategoryList(offset: Int, limit: Int) = apiDefinition.getMoveCategoryList(offset, limit).result()

    override fun getMoveDamageClassList(offset: Int, limit: Int) = apiDefinition.getMoveDamageClassList(offset, limit).result()

    override fun getMoveLearnMethodList(offset: Int, limit: Int) = apiDefinition.getMoveLearnMethodList(offset, limit).result()

    override fun getMoveTargetList(offset: Int, limit: Int) = apiDefinition.getMoveTargetList(offset, limit).result()

    // endregion

    // region Locations

    override fun getLocationList(offset: Int, limit: Int) = apiDefinition.getLocationList(offset, limit).result()

    override fun getLocationAreaList(offset: Int, limit: Int) = apiDefinition.getLocationAreaList(offset, limit).result()

    override fun getPalParkAreaList(offset: Int, limit: Int) = apiDefinition.getPalParkAreaList(offset, limit).result()

    override fun getRegionList(offset: Int, limit: Int) = apiDefinition.getRegionList(offset, limit).result()

    // endregion

    // region Pokemon

    override fun getAbilityList(offset: Int, limit: Int) = apiDefinition.getAbilityList(offset, limit).result()

    override fun getCharacteristicList(offset: Int, limit: Int) = apiDefinition.getCharacteristicList(offset, limit).result()

    override fun getEggGroupList(offset: Int, limit: Int) = apiDefinition.getEggGroupList(offset, limit).result()

    override fun getGenderList(offset: Int, limit: Int) = apiDefinition.getGenderList(offset, limit).result()

    override fun getGrowthRateList(offset: Int, limit: Int) = apiDefinition.getGrowthRateList(offset, limit).result()

    override fun getNatureList(offset: Int, limit: Int) = apiDefinition.getNatureList(offset, limit).result()

    override fun getPokeathlonStatList(offset: Int, limit: Int) = apiDefinition.getPokeathlonStatList(offset, limit).result()

    override fun getPokemonList(offset: Int, limit: Int) = apiDefinition.getPokemonList(offset, limit).result()

    override fun getPokemonColorList(offset: Int, limit: Int) = apiDefinition.getPokemonColorList(offset, limit).result()

    override fun getPokemonFormList(offset: Int, limit: Int) = apiDefinition.getPokemonFormList(offset, limit).result()

    override fun getPokemonHabitatList(offset: Int, limit: Int) = apiDefinition.getPokemonHabitatList(offset, limit).result()

    override fun getPokemonShapeList(offset: Int, limit: Int) = apiDefinition.getPokemonShapeList(offset, limit).result()

    override fun getPokemonSpeciesList(offset: Int, limit: Int) = apiDefinition.getPokemonSpeciesList(offset, limit).result()

    override fun getStatList(offset: Int, limit: Int) = apiDefinition.getStatList(offset, limit).result()

    override fun getTypeList(offset: Int, limit: Int) = apiDefinition.getTypeList(offset, limit).result()

    // endregion

    // region Utility

    override fun getLanguageList(offset: Int, limit: Int) = apiDefinition.getLanguageList(offset, limit).result()

    // endregion

    // endregion

    // region Berries

    override fun getBerry(id: Int) = apiDefinition.getBerry(id).result()

    override fun getBerryFirmness(id: Int) = apiDefinition.getBerryFirmness(id).result()

    override fun getBerryFlavor(id: Int) = apiDefinition.getBerryFlavor(id).result()

    // endregion Berries

    // region Contests

    override fun getContestType(id: Int) = apiDefinition.getContestType(id).result()

    override fun getContestEffect(id: Int) = apiDefinition.getContestEffect(id).result()

    override fun getSuperContestEffect(id: Int) = apiDefinition.getSuperContestEffect(id).result()

    // endregion Contests

    // region Encounters

    override fun getEncounterMethod(id: Int) = apiDefinition.getEncounterMethod(id).result()

    override fun getEncounterCondition(id: Int) = apiDefinition.getEncounterCondition(id).result()

    override fun getEncounterConditionValue(id: Int) = apiDefinition.getEncounterConditionValue(id).result()

    // endregion Contests

    // region Evolution

    override fun getEvolutionChain(id: Int) = apiDefinition.getEvolutionChain(id).result()

    override fun getEvolutionTrigger(id: Int) = apiDefinition.getEvolutionTrigger(id).result()

    // endregion Evolution

    // region Games

    override fun getGeneration(id: Int) = apiDefinition.getGeneration(id).result()

    override fun getPokedex(id: Int) = apiDefinition.getPokedex(id).result()

    override fun getVersion(id: Int) = apiDefinition.getVersion(id).result()

    override fun getVersionGroup(id: Int) = apiDefinition.getVersionGroup(id).result()

    // endregion Games

    // region Items

    override fun getItem(id: Int) = apiDefinition.getItem(id).result()

    override fun getItemAttribute(id: Int) = apiDefinition.getItemAttribute(id).result()

    override fun getItemCategory(id: Int) = apiDefinition.getItemCategory(id).result()

    override fun getItemFlingEffect(id: Int) = apiDefinition.getItemFlingEffect(id).result()

    override fun getItemPocket(id: Int) = apiDefinition.getItemPocket(id).result()

    // endregion Items

    // region Moves

    override fun getMove(id: Int) = apiDefinition.getMove(id).result()

    override fun getMoveAilment(id: Int) = apiDefinition.getMoveAilment(id).result()

    override fun getMoveBattleStyle(id: Int) = apiDefinition.getMoveBattleStyle(id).result()

    override fun getMoveCategory(id: Int) = apiDefinition.getMoveCategory(id).result()

    override fun getMoveDamageClass(id: Int) = apiDefinition.getMoveDamageClass(id).result()

    override fun getMoveLearnMethod(id: Int) = apiDefinition.getMoveLearnMethod(id).result()

    override fun getMoveTarget(id: Int) = apiDefinition.getMoveTarget(id).result()

    // endregion Moves

    // region Locations

    override fun getLocation(id: Int) = apiDefinition.getLocation(id).result()

    override fun getLocationArea(id: Int) = apiDefinition.getLocationArea(id).result()

    override fun getPalParkArea(id: Int) = apiDefinition.getPalParkArea(id).result()

    override fun getRegion(id: Int) = apiDefinition.getRegion(id).result()

    // endregion Locations

    // region Pokemon

    override fun getAbility(id: Int) = apiDefinition.getAbility(id).result()

    override fun getCharacteristic(id: Int) = apiDefinition.getCharacteristic(id).result()

    override fun getEggGroup(id: Int) = apiDefinition.getEggGroup(id).result()

    override fun getGender(id: Int) = apiDefinition.getGender(id).result()

    override fun getGrowthRate(id: Int) = apiDefinition.getGrowthRate(id).result()

    override fun getNature(id: Int) = apiDefinition.getNature(id).result()

    override fun getPokeathlonStat(id: Int) = apiDefinition.getPokeathlonStat(id).result()

    override fun getPokemon(id: Int) = apiDefinition.getPokemon(id).result()

    override fun getPokemonEncounterList(id: Int) = apiDefinition.getPokemonEncounterList(id).result()

    override fun getPokemonColor(id: Int) = apiDefinition.getPokemonColor(id).result()

    override fun getPokemonForm(id: Int) = apiDefinition.getPokemonForm(id).result()

    override fun getPokemonHabitat(id: Int) = apiDefinition.getPokemonHabitat(id).result()

    override fun getPokemonShape(id: Int) = apiDefinition.getPokemonShape(id).result()

    override fun getPokemonSpecies(id: Int) = apiDefinition.getPokemonSpecies(id).result()

    override fun getStat(id: Int) = apiDefinition.getStat(id).result()

    override fun getType(id: Int) = apiDefinition.getType(id).result()

    // endregion Pokemon

    // region Utility

    override fun getLanguage(id: Int) = apiDefinition.getLanguage(id).result()

    // endregion Utility
}

