package me.sargunvohra.lib.pokekotlin.client

import me.sargunvohra.lib.pokekotlin.json.*
import me.sargunvohra.lib.pokekotlin.retrofit.IPokeApiRetrofit
import me.sargunvohra.lib.pokekotlin.retrofit.PokeApiRetrofit

class PokeApiClient(
        private val retrofitClient: IPokeApiRetrofit = PokeApiRetrofit()
): IPokeApiClient {

    // region ResourceList Lists

    // region Berries

    override fun getBerryList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getBerryList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getBerryFirmnessList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getBerryFirmnessList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getBerryFlavorList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getBerryFlavorList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Berries

    // region Contests

    override fun getContestTypeList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getContestTypeList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getContestEffectList(offset: Int, limit: Int): ApiResourceList {
        val response = retrofitClient.getContestEffectList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getSuperContestEffectList(offset: Int, limit: Int): ApiResourceList {
        val response = retrofitClient.getSuperContestEffectList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Contests

    // region Encounters

    override fun getEncounterMethodList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getEncounterMethodList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEncounterConditionList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getEncounterConditionList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEncounterConditionValueList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getEncounterConditionValueList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // region Evolution

    override fun getEvolutionChainList(offset: Int, limit: Int): ApiResourceList {
        val response = retrofitClient.getEvolutionChainList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEvolutionTriggerList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getEvolutionTriggerList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    //region Games

    override fun getGenerationList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getGenerationList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokedexList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokedexList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getVersionList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getVersionList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getVersionGroupList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getVersionGroupList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // region Items

    override fun getItemList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getItemList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemAttributeList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getItemAttributeList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemCategoryList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getItemCategoryList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemFlingEffectList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getItemFlingEffectList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemPocketList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getItemPocketList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    //region Moves

    override fun getMoveList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveAilmentList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveAilmentList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveBattleStyleList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveBattleStyleList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveCategoryList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveCategoryList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveDamageClassList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveDamageClassList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveLearnMethodList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveLearnMethodList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveTargetList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getMoveTargetList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // region Locations

    override fun getLocationList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getLocationList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getLocationAreaList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getLocationAreaList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPalParkAreaList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPalParkAreaList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getRegionList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getRegionList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // region Pokemon

    override fun getAbilityList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getAbilityList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getCharacteristicList(offset: Int, limit: Int): ApiResourceList {
        val response = retrofitClient.getCharacteristicList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEggGroupList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getEggGroupList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getGenderList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getGenderList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getGrowthRateList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getGrowthRateList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getNatureList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getNatureList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokeathlonStatList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokeathlonStatList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonColorList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonColorList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonFormList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonFormList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonHabitatList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonHabitatList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonShapeList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonShapeList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonSpeciesList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getPokemonSpeciesList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getStatList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getStatList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getTypeList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getTypeList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // region Utility

    override fun getLanguageList(offset: Int, limit: Int): NamedApiResourceList {
        val response = retrofitClient.getLanguageList(offset, limit).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion

    // endregion

    // region Berries

    override fun getBerry(id: Int): Berry {
        val response = retrofitClient.getBerry(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getBerryFirmness(id: Int): BerryFirmness {
        val response = retrofitClient.getBerryFirmness(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getBerryFlavor(id: Int): BerryFlavor {
        val response = retrofitClient.getBerryFlavor(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Berries

    // region Contests

    override fun getContestType(id: Int): ContestType {
        val response = retrofitClient.getContestType(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getContestEffect(id: Int): ContestEffect {
        val response = retrofitClient.getContestEffect(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getSuperContestEffect(id: Int): SuperContestEffect {
        val response = retrofitClient.getSuperContestEffect(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Contests

    // region Encounters

    override fun getEncounterMethod(id: Int): EncounterMethod {
        val response = retrofitClient.getEncounterMethod(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEncounterCondition(id: Int): EncounterCondition {
        val response = retrofitClient.getEncounterCondition(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEncounterConditionValue(id: Int): EncounterConditionValue {
        val response = retrofitClient.getEncounterConditionValue(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Contests

    // region Evolution

    override fun getEvolutionChain(id: Int): EvolutionChain {
        val response = retrofitClient.getEvolutionChain(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEvolutionTrigger(id: Int): EvolutionTrigger {
        val response = retrofitClient.getEvolutionTrigger(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Evolution

    // region Games

    override fun getGeneration(id: Int): Generation {
        val response = retrofitClient.getGeneration(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokedex(id: Int): Pokedex {
        val response = retrofitClient.getPokedex(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getVersion(id: Int): Version {
        val response = retrofitClient.getVersion(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getVersionGroup(id: Int): VersionGroup {
        val response = retrofitClient.getVersionGroup(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Games

    // region Items

    override fun getItem(id: Int): Item {
        val response = retrofitClient.getItem(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemAttribute(id: Int): ItemAttribute {
        val response = retrofitClient.getItemAttribute(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemCategory(id: Int): ItemCategory {
        val response = retrofitClient.getItemCategory(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemFlingEffect(id: Int): ItemFlingEffect {
        val response = retrofitClient.getItemFlingEffect(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getItemPocket(id: Int): ItemPocket {
        val response = retrofitClient.getItemPocket(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Items

    // region Moves

    override fun getMove(id: Int): Move {
        val response = retrofitClient.getMove(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveAilment(id: Int): MoveAilment {
        // TODO workaround for issue #11
        if (id < 0) {
            val newId = getMoveAilmentList(0, getMoveAilmentList(0, 0).count).results.find { it.id == id }?.name
            if (newId != null) {
                @Suppress("DEPRECATION")
                val response = retrofitClient.getMoveAilment(newId).execute()
                if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
            }
        }
        // end workaround
        val response = retrofitClient.getMoveAilment(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveBattleStyle(id: Int): MoveBattleStyle {
        val response = retrofitClient.getMoveBattleStyle(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveCategory(id: Int): MoveCategory {
        val response = retrofitClient.getMoveCategory(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveDamageClass(id: Int): MoveDamageClass {
        val response = retrofitClient.getMoveDamageClass(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveLearnMethod(id: Int): MoveLearnMethod {
        val response = retrofitClient.getMoveLearnMethod(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getMoveTarget(id: Int): MoveTarget {
        val response = retrofitClient.getMoveTarget(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Moves

    // region Locations

    override fun getLocation(id: Int): Location {
        val response = retrofitClient.getLocation(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getLocationArea(id: Int): LocationArea {
        val response = retrofitClient.getLocationArea(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPalParkArea(id: Int): PalParkArea {
        val response = retrofitClient.getPalParkArea(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getRegion(id: Int): Region {
        val response = retrofitClient.getRegion(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Locations

    // region Pokemon

    override fun getAbility(id: Int): Ability {
        val response = retrofitClient.getAbility(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getCharacteristic(id: Int): Characteristic {
        val response = retrofitClient.getCharacteristic(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getEggGroup(id: Int): EggGroup {
        val response = retrofitClient.getEggGroup(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getGender(id: Int): Gender {
        val response = retrofitClient.getGender(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getGrowthRate(id: Int): GrowthRate {
        val response = retrofitClient.getGrowthRate(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getNature(id: Int): Nature {
        val response = retrofitClient.getNature(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokeathlonStat(id: Int): PokeathlonStat {
        val response = retrofitClient.getPokeathlonStat(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemon(id: Int): Pokemon {
        val response = retrofitClient.getPokemon(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonColor(id: Int): PokemonColor {
        val response = retrofitClient.getPokemonColor(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonForm(id: Int): PokemonForm {
        val response = retrofitClient.getPokemonForm(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonHabitat(id: Int): PokemonHabitat {
        val response = retrofitClient.getPokemonHabitat(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonShape(id: Int): PokemonShape {
        val response = retrofitClient.getPokemonShape(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getPokemonSpecies(id: Int): PokemonSpecies {
        val response = retrofitClient.getPokemonSpecies(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getStat(id: Int): Stat {
        val response = retrofitClient.getStat(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    override fun getType(id: Int): Type {
        val response = retrofitClient.getType(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Pokemon

    // region Utility

    override fun getLanguage(id: Int): Language {
        val response = retrofitClient.getLanguage(id).execute()
        if (response.isSuccessful) return response.body() else throw ErrorResponse(response.errorBody())
    }

    // endregion Utility
}

