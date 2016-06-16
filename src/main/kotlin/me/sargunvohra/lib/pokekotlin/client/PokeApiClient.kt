package me.sargunvohra.lib.pokekotlin.client

import retrofit2.Call

class PokeApiClient(
        private val apiCaller: ApiCaller = RetrofitApiCaller()
) {
    private fun <T> Call<T>.result(): T {
        return execute().let {
            if (it.isSuccessful) it.body() else throw ErrorResponse(it.code(), it.message())
        }
    }

    // region ResourceList Lists

    // region Berries

    fun getBerryList(offset: Int, limit: Int) = apiCaller.getBerryList(offset, limit).result()

    fun getBerryFirmnessList(offset: Int, limit: Int) = apiCaller.getBerryFirmnessList(offset, limit).result()

    fun getBerryFlavorList(offset: Int, limit: Int) = apiCaller.getBerryFlavorList(offset, limit).result()

    // endregion Berries

    // region Contests

    fun getContestTypeList(offset: Int, limit: Int) = apiCaller.getContestTypeList(offset, limit).result()

    fun getContestEffectList(offset: Int, limit: Int) = apiCaller.getContestEffectList(offset, limit).result()

    fun getSuperContestEffectList(offset: Int, limit: Int) = apiCaller.getSuperContestEffectList(offset, limit).result()

    // endregion Contests

    // region Encounters

    fun getEncounterMethodList(offset: Int, limit: Int) = apiCaller.getEncounterMethodList(offset, limit).result()

    fun getEncounterConditionList(offset: Int, limit: Int) = apiCaller.getEncounterConditionList(offset, limit).result()

    fun getEncounterConditionValueList(offset: Int, limit: Int) = apiCaller.getEncounterConditionValueList(offset, limit).result()

    // endregion

    // region Evolution

    fun getEvolutionChainList(offset: Int, limit: Int) = apiCaller.getEvolutionChainList(offset, limit).result()

    fun getEvolutionTriggerList(offset: Int, limit: Int) = apiCaller.getEvolutionTriggerList(offset, limit).result()

    // endregion

    //region Games

    fun getGenerationList(offset: Int, limit: Int) = apiCaller.getGenerationList(offset, limit).result()

    fun getPokedexList(offset: Int, limit: Int) = apiCaller.getPokedexList(offset, limit).result()

    fun getVersionList(offset: Int, limit: Int) = apiCaller.getVersionList(offset, limit).result()

    fun getVersionGroupList(offset: Int, limit: Int) = apiCaller.getVersionGroupList(offset, limit).result()

    // endregion

    // region Items

    fun getItemList(offset: Int, limit: Int) = apiCaller.getItemList(offset, limit).result()

    fun getItemAttributeList(offset: Int, limit: Int) = apiCaller.getItemAttributeList(offset, limit).result()

    fun getItemCategoryList(offset: Int, limit: Int) = apiCaller.getItemCategoryList(offset, limit).result()

    fun getItemFlingEffectList(offset: Int, limit: Int) = apiCaller.getItemFlingEffectList(offset, limit).result()

    fun getItemPocketList(offset: Int, limit: Int) = apiCaller.getItemPocketList(offset, limit).result()

    // endregion

    //region Moves

    fun getMoveList(offset: Int, limit: Int) = apiCaller.getMoveList(offset, limit).result()

    fun getMoveAilmentList(offset: Int, limit: Int) = apiCaller.getMoveAilmentList(offset, limit).result()

    fun getMoveBattleStyleList(offset: Int, limit: Int) = apiCaller.getMoveBattleStyleList(offset, limit).result()

    fun getMoveCategoryList(offset: Int, limit: Int) = apiCaller.getMoveCategoryList(offset, limit).result()

    fun getMoveDamageClassList(offset: Int, limit: Int) = apiCaller.getMoveDamageClassList(offset, limit).result()

    fun getMoveLearnMethodList(offset: Int, limit: Int) = apiCaller.getMoveLearnMethodList(offset, limit).result()

    fun getMoveTargetList(offset: Int, limit: Int) = apiCaller.getMoveTargetList(offset, limit).result()

    // endregion

    // region Locations

    fun getLocationList(offset: Int, limit: Int) = apiCaller.getLocationList(offset, limit).result()

    fun getLocationAreaList(offset: Int, limit: Int) = apiCaller.getLocationAreaList(offset, limit).result()

    fun getPalParkAreaList(offset: Int, limit: Int) = apiCaller.getPalParkAreaList(offset, limit).result()

    fun getRegionList(offset: Int, limit: Int) = apiCaller.getRegionList(offset, limit).result()

    // endregion

    // region Pokemon

    fun getAbilityList(offset: Int, limit: Int) = apiCaller.getAbilityList(offset, limit).result()

    fun getCharacteristicList(offset: Int, limit: Int) = apiCaller.getCharacteristicList(offset, limit).result()

    fun getEggGroupList(offset: Int, limit: Int) = apiCaller.getEggGroupList(offset, limit).result()

    fun getGenderList(offset: Int, limit: Int) = apiCaller.getGenderList(offset, limit).result()

    fun getGrowthRateList(offset: Int, limit: Int) = apiCaller.getGrowthRateList(offset, limit).result()

    fun getNatureList(offset: Int, limit: Int) = apiCaller.getNatureList(offset, limit).result()

    fun getPokeathlonStatList(offset: Int, limit: Int) = apiCaller.getPokeathlonStatList(offset, limit).result()

    fun getPokemonList(offset: Int, limit: Int) = apiCaller.getPokemonList(offset, limit).result()

    fun getPokemonColorList(offset: Int, limit: Int) = apiCaller.getPokemonColorList(offset, limit).result()

    fun getPokemonFormList(offset: Int, limit: Int) = apiCaller.getPokemonFormList(offset, limit).result()

    fun getPokemonHabitatList(offset: Int, limit: Int) = apiCaller.getPokemonHabitatList(offset, limit).result()

    fun getPokemonShapeList(offset: Int, limit: Int) = apiCaller.getPokemonShapeList(offset, limit).result()

    fun getPokemonSpeciesList(offset: Int, limit: Int) = apiCaller.getPokemonSpeciesList(offset, limit).result()

    fun getStatList(offset: Int, limit: Int) = apiCaller.getStatList(offset, limit).result()

    fun getTypeList(offset: Int, limit: Int) = apiCaller.getTypeList(offset, limit).result()

    // endregion

    // region Utility

    fun getLanguageList(offset: Int, limit: Int) = apiCaller.getLanguageList(offset, limit).result()

    // endregion

    // endregion

    // region Berries

    fun getBerry(id: Int) = apiCaller.getBerry(id).result()

    fun getBerryFirmness(id: Int) = apiCaller.getBerryFirmness(id).result()

    fun getBerryFlavor(id: Int) = apiCaller.getBerryFlavor(id).result()

    // endregion Berries

    // region Contests

    fun getContestType(id: Int) = apiCaller.getContestType(id).result()

    fun getContestEffect(id: Int) = apiCaller.getContestEffect(id).result()

    fun getSuperContestEffect(id: Int) = apiCaller.getSuperContestEffect(id).result()

    // endregion Contests

    // region Encounters

    fun getEncounterMethod(id: Int) = apiCaller.getEncounterMethod(id).result()

    fun getEncounterCondition(id: Int) = apiCaller.getEncounterCondition(id).result()

    fun getEncounterConditionValue(id: Int) = apiCaller.getEncounterConditionValue(id).result()

    // endregion Contests

    // region Evolution

    fun getEvolutionChain(id: Int) = apiCaller.getEvolutionChain(id).result()

    fun getEvolutionTrigger(id: Int) = apiCaller.getEvolutionTrigger(id).result()

    // endregion Evolution

    // region Games

    fun getGeneration(id: Int) = apiCaller.getGeneration(id).result()

    fun getPokedex(id: Int) = apiCaller.getPokedex(id).result()

    fun getVersion(id: Int) = apiCaller.getVersion(id).result()

    fun getVersionGroup(id: Int) = apiCaller.getVersionGroup(id).result()

    // endregion Games

    // region Items

    fun getItem(id: Int) = apiCaller.getItem(id).result()

    fun getItemAttribute(id: Int) = apiCaller.getItemAttribute(id).result()

    fun getItemCategory(id: Int) = apiCaller.getItemCategory(id).result()

    fun getItemFlingEffect(id: Int) = apiCaller.getItemFlingEffect(id).result()

    fun getItemPocket(id: Int) = apiCaller.getItemPocket(id).result()

    // endregion Items

    // region Moves

    fun getMove(id: Int) = apiCaller.getMove(id).result()

    fun getMoveAilment(id: Int) = apiCaller.getMoveAilment(id).result()

    fun getMoveBattleStyle(id: Int) = apiCaller.getMoveBattleStyle(id).result()

    fun getMoveCategory(id: Int) = apiCaller.getMoveCategory(id).result()

    fun getMoveDamageClass(id: Int) = apiCaller.getMoveDamageClass(id).result()

    fun getMoveLearnMethod(id: Int) = apiCaller.getMoveLearnMethod(id).result()

    fun getMoveTarget(id: Int) = apiCaller.getMoveTarget(id).result()

    // endregion Moves

    // region Locations

    fun getLocation(id: Int) = apiCaller.getLocation(id).result()

    fun getLocationArea(id: Int) = apiCaller.getLocationArea(id).result()

    fun getPalParkArea(id: Int) = apiCaller.getPalParkArea(id).result()

    fun getRegion(id: Int) = apiCaller.getRegion(id).result()

    // endregion Locations

    // region Pokemon

    fun getAbility(id: Int) = apiCaller.getAbility(id).result()

    fun getCharacteristic(id: Int) = apiCaller.getCharacteristic(id).result()

    fun getEggGroup(id: Int) = apiCaller.getEggGroup(id).result()

    fun getGender(id: Int) = apiCaller.getGender(id).result()

    fun getGrowthRate(id: Int) = apiCaller.getGrowthRate(id).result()

    fun getNature(id: Int) = apiCaller.getNature(id).result()

    fun getPokeathlonStat(id: Int) = apiCaller.getPokeathlonStat(id).result()

    fun getPokemon(id: Int) = apiCaller.getPokemon(id).result()

    fun getPokemonEncounters(id: Int) = apiCaller.getPokemonEncounters(id).result()

    fun getPokemonColor(id: Int) = apiCaller.getPokemonColor(id).result()

    fun getPokemonForm(id: Int) = apiCaller.getPokemonForm(id).result()

    fun getPokemonHabitat(id: Int) = apiCaller.getPokemonHabitat(id).result()

    fun getPokemonShape(id: Int) = apiCaller.getPokemonShape(id).result()

    fun getPokemonSpecies(id: Int) = apiCaller.getPokemonSpecies(id).result()

    fun getStat(id: Int) = apiCaller.getStat(id).result()

    fun getType(id: Int) = apiCaller.getType(id).result()

    // endregion Pokemon

    // region Utility

    fun getLanguage(id: Int) = apiCaller.getLanguage(id).result()

    // endregion Utility
}

