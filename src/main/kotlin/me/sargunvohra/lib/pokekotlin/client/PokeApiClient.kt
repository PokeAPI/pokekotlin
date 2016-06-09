package me.sargunvohra.lib.pokekotlin.client

import me.sargunvohra.lib.pokekotlin.json.*
import me.sargunvohra.lib.pokekotlin.retrofit.IPokeApiRetrofit
import me.sargunvohra.lib.pokekotlin.retrofit.PokeApiRetrofit
import retrofit2.Call

class PokeApiClient(
        private val retrofitClient: IPokeApiRetrofit = PokeApiRetrofit()
): IPokeApiClient {

    private fun <T> Call<T>.result(): T {
        return execute().let {
            if (it.isSuccessful) it.body() else throw ErrorResponse(it.code(), it.message())
        }
    }

    // region ResourceList Lists

    // region Berries

    override fun getBerryList(offset: Int, limit: Int) = retrofitClient.getBerryList(offset, limit).result()

    override fun getBerryFirmnessList(offset: Int, limit: Int) = retrofitClient.getBerryFirmnessList(offset, limit).result()

    override fun getBerryFlavorList(offset: Int, limit: Int) = retrofitClient.getBerryFlavorList(offset, limit).result()

    // endregion Berries

    // region Contests

    override fun getContestTypeList(offset: Int, limit: Int) = retrofitClient.getContestTypeList(offset, limit).result()

    override fun getContestEffectList(offset: Int, limit: Int) = retrofitClient.getContestEffectList(offset, limit).result()

    override fun getSuperContestEffectList(offset: Int, limit: Int) = retrofitClient.getSuperContestEffectList(offset, limit).result()

    // endregion Contests

    // region Encounters

    override fun getEncounterMethodList(offset: Int, limit: Int) = retrofitClient.getEncounterMethodList(offset, limit).result()

    override fun getEncounterConditionList(offset: Int, limit: Int) = retrofitClient.getEncounterConditionList(offset, limit).result()

    override fun getEncounterConditionValueList(offset: Int, limit: Int) = retrofitClient.getEncounterConditionValueList(offset, limit).result()

    // endregion

    // region Evolution

    override fun getEvolutionChainList(offset: Int, limit: Int) = retrofitClient.getEvolutionChainList(offset, limit).result()

    override fun getEvolutionTriggerList(offset: Int, limit: Int) = retrofitClient.getEvolutionTriggerList(offset, limit).result()

    // endregion

    //region Games

    override fun getGenerationList(offset: Int, limit: Int) = retrofitClient.getGenerationList(offset, limit).result()

    override fun getPokedexList(offset: Int, limit: Int) = retrofitClient.getPokedexList(offset, limit).result()

    override fun getVersionList(offset: Int, limit: Int) = retrofitClient.getVersionList(offset, limit).result()

    override fun getVersionGroupList(offset: Int, limit: Int) = retrofitClient.getVersionGroupList(offset, limit).result()

    // endregion

    // region Items

    override fun getItemList(offset: Int, limit: Int) = retrofitClient.getItemList(offset, limit).result()

    override fun getItemAttributeList(offset: Int, limit: Int) = retrofitClient.getItemAttributeList(offset, limit).result()

    override fun getItemCategoryList(offset: Int, limit: Int) = retrofitClient.getItemCategoryList(offset, limit).result()

    override fun getItemFlingEffectList(offset: Int, limit: Int) = retrofitClient.getItemFlingEffectList(offset, limit).result()

    override fun getItemPocketList(offset: Int, limit: Int) = retrofitClient.getItemPocketList(offset, limit).result()

    // endregion

    //region Moves

    override fun getMoveList(offset: Int, limit: Int) = retrofitClient.getMoveList(offset, limit).result()

    override fun getMoveAilmentList(offset: Int, limit: Int) = retrofitClient.getMoveAilmentList(offset, limit).result()

    override fun getMoveBattleStyleList(offset: Int, limit: Int) = retrofitClient.getMoveBattleStyleList(offset, limit).result()

    override fun getMoveCategoryList(offset: Int, limit: Int) = retrofitClient.getMoveCategoryList(offset, limit).result()

    override fun getMoveDamageClassList(offset: Int, limit: Int) = retrofitClient.getMoveDamageClassList(offset, limit).result()

    override fun getMoveLearnMethodList(offset: Int, limit: Int) = retrofitClient.getMoveLearnMethodList(offset, limit).result()

    override fun getMoveTargetList(offset: Int, limit: Int) = retrofitClient.getMoveTargetList(offset, limit).result()

    // endregion

    // region Locations

    override fun getLocationList(offset: Int, limit: Int) = retrofitClient.getLocationList(offset, limit).result()

    override fun getLocationAreaList(offset: Int, limit: Int) = retrofitClient.getLocationAreaList(offset, limit).result()

    override fun getPalParkAreaList(offset: Int, limit: Int) = retrofitClient.getPalParkAreaList(offset, limit).result()

    override fun getRegionList(offset: Int, limit: Int) = retrofitClient.getRegionList(offset, limit).result()

    // endregion

    // region Pokemon

    override fun getAbilityList(offset: Int, limit: Int) = retrofitClient.getAbilityList(offset, limit).result()

    override fun getCharacteristicList(offset: Int, limit: Int) = retrofitClient.getCharacteristicList(offset, limit).result()

    override fun getEggGroupList(offset: Int, limit: Int) = retrofitClient.getEggGroupList(offset, limit).result()

    override fun getGenderList(offset: Int, limit: Int) = retrofitClient.getGenderList(offset, limit).result()

    override fun getGrowthRateList(offset: Int, limit: Int) = retrofitClient.getGrowthRateList(offset, limit).result()

    override fun getNatureList(offset: Int, limit: Int) = retrofitClient.getNatureList(offset, limit).result()

    override fun getPokeathlonStatList(offset: Int, limit: Int) = retrofitClient.getPokeathlonStatList(offset, limit).result()

    override fun getPokemonList(offset: Int, limit: Int) = retrofitClient.getPokemonList(offset, limit).result()

    override fun getPokemonColorList(offset: Int, limit: Int) = retrofitClient.getPokemonColorList(offset, limit).result()

    override fun getPokemonFormList(offset: Int, limit: Int) = retrofitClient.getPokemonFormList(offset, limit).result()

    override fun getPokemonHabitatList(offset: Int, limit: Int) = retrofitClient.getPokemonHabitatList(offset, limit).result()

    override fun getPokemonShapeList(offset: Int, limit: Int) = retrofitClient.getPokemonShapeList(offset, limit).result()

    override fun getPokemonSpeciesList(offset: Int, limit: Int) = retrofitClient.getPokemonSpeciesList(offset, limit).result()

    override fun getStatList(offset: Int, limit: Int) = retrofitClient.getStatList(offset, limit).result()

    override fun getTypeList(offset: Int, limit: Int) = retrofitClient.getTypeList(offset, limit).result()

    // endregion

    // region Utility

    override fun getLanguageList(offset: Int, limit: Int) = retrofitClient.getLanguageList(offset, limit).result()

    // endregion

    // endregion

    // region Berries

    override fun getBerry(id: Int) = retrofitClient.getBerry(id).result()

    override fun getBerryFirmness(id: Int) = retrofitClient.getBerryFirmness(id).result()

    override fun getBerryFlavor(id: Int) = retrofitClient.getBerryFlavor(id).result()

    // endregion Berries

    // region Contests

    override fun getContestType(id: Int) = retrofitClient.getContestType(id).result()

    override fun getContestEffect(id: Int) = retrofitClient.getContestEffect(id).result()

    override fun getSuperContestEffect(id: Int) = retrofitClient.getSuperContestEffect(id).result()

    // endregion Contests

    // region Encounters

    override fun getEncounterMethod(id: Int) = retrofitClient.getEncounterMethod(id).result()

    override fun getEncounterCondition(id: Int) = retrofitClient.getEncounterCondition(id).result()

    override fun getEncounterConditionValue(id: Int) = retrofitClient.getEncounterConditionValue(id).result()

    // endregion Contests

    // region Evolution

    override fun getEvolutionChain(id: Int) = retrofitClient.getEvolutionChain(id).result()

    override fun getEvolutionTrigger(id: Int) = retrofitClient.getEvolutionTrigger(id).result()

    // endregion Evolution

    // region Games

    override fun getGeneration(id: Int) = retrofitClient.getGeneration(id).result()

    override fun getPokedex(id: Int) = retrofitClient.getPokedex(id).result()

    override fun getVersion(id: Int) = retrofitClient.getVersion(id).result()

    override fun getVersionGroup(id: Int) = retrofitClient.getVersionGroup(id).result()

    // endregion Games

    // region Items

    override fun getItem(id: Int) = retrofitClient.getItem(id).result()

    override fun getItemAttribute(id: Int) = retrofitClient.getItemAttribute(id).result()

    override fun getItemCategory(id: Int) = retrofitClient.getItemCategory(id).result()

    override fun getItemFlingEffect(id: Int) = retrofitClient.getItemFlingEffect(id).result()

    override fun getItemPocket(id: Int) = retrofitClient.getItemPocket(id).result()

    // endregion Items

    // region Moves

    override fun getMove(id: Int) = retrofitClient.getMove(id).result()

    override fun getMoveAilment(id: Int) = retrofitClient.getMoveAilment(id).result()

    override fun getMoveBattleStyle(id: Int) = retrofitClient.getMoveBattleStyle(id).result()

    override fun getMoveCategory(id: Int) = retrofitClient.getMoveCategory(id).result()

    override fun getMoveDamageClass(id: Int) = retrofitClient.getMoveDamageClass(id).result()

    override fun getMoveLearnMethod(id: Int) = retrofitClient.getMoveLearnMethod(id).result()

    override fun getMoveTarget(id: Int) = retrofitClient.getMoveTarget(id).result()

    // endregion Moves

    // region Locations

    override fun getLocation(id: Int) = retrofitClient.getLocation(id).result()

    override fun getLocationArea(id: Int) = retrofitClient.getLocationArea(id).result()

    override fun getPalParkArea(id: Int) = retrofitClient.getPalParkArea(id).result()

    override fun getRegion(id: Int) = retrofitClient.getRegion(id).result()

    // endregion Locations

    // region Pokemon

    override fun getAbility(id: Int) = retrofitClient.getAbility(id).result()

    override fun getCharacteristic(id: Int) = retrofitClient.getCharacteristic(id).result()

    override fun getEggGroup(id: Int) = retrofitClient.getEggGroup(id).result()

    override fun getGender(id: Int) = retrofitClient.getGender(id).result()

    override fun getGrowthRate(id: Int) = retrofitClient.getGrowthRate(id).result()

    override fun getNature(id: Int) = retrofitClient.getNature(id).result()

    override fun getPokeathlonStat(id: Int) = retrofitClient.getPokeathlonStat(id).result()

    override fun getPokemon(id: Int) = retrofitClient.getPokemon(id).result()

    override fun getPokemonEncounters(id: Int) = retrofitClient.getPokemonEncounters(id).result()

    override fun getPokemonColor(id: Int) = retrofitClient.getPokemonColor(id).result()

    override fun getPokemonForm(id: Int) = retrofitClient.getPokemonForm(id).result()

    override fun getPokemonHabitat(id: Int) = retrofitClient.getPokemonHabitat(id).result()

    override fun getPokemonShape(id: Int) = retrofitClient.getPokemonShape(id).result()

    override fun getPokemonSpecies(id: Int) = retrofitClient.getPokemonSpecies(id).result()

    override fun getStat(id: Int) = retrofitClient.getStat(id).result()

    override fun getType(id: Int) = retrofitClient.getType(id).result()

    // endregion Pokemon

    // region Utility

    override fun getLanguage(id: Int) = retrofitClient.getLanguage(id).result()

    // endregion Utility
}

