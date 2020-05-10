package me.sargunvohra.lib.pokekotlin.client

class RxPokeApiClient(
    clientConfig: ClientConfig = ClientConfig()
) : RxPokeApi {

    private val service = RxPokeApiServiceImpl(clientConfig)

    // region ResourceList Lists

    // region Berries

    override fun getBerryList(offset: Int, limit: Int) = service.getBerryList(offset, limit)

    override fun getBerryFirmnessList(offset: Int, limit: Int) =
        service.getBerryFirmnessList(offset, limit)

    override fun getBerryFlavorList(offset: Int, limit: Int) =
        service.getBerryFlavorList(offset, limit)

    // endregion Berries

    // region Contests

    override fun getContestTypeList(offset: Int, limit: Int) =
        service.getContestTypeList(offset, limit)

    override fun getContestEffectList(offset: Int, limit: Int) =
        service.getContestEffectList(offset, limit)

    override fun getSuperContestEffectList(offset: Int, limit: Int) =
        service.getSuperContestEffectList(offset, limit)

    // endregion Contests

    // region Encounters

    override fun getEncounterMethodList(offset: Int, limit: Int) =
        service.getEncounterMethodList(offset, limit)

    override fun getEncounterConditionList(offset: Int, limit: Int) =
        service.getEncounterConditionList(offset, limit)

    override fun getEncounterConditionValueList(offset: Int, limit: Int) =
        service.getEncounterConditionValueList(offset, limit)

    // endregion

    // region Evolution

    override fun getEvolutionChainList(offset: Int, limit: Int) =
        service.getEvolutionChainList(offset, limit)

    override fun getEvolutionTriggerList(offset: Int, limit: Int) =
        service.getEvolutionTriggerList(offset, limit)

    // endregion

    //region Games

    override fun getGenerationList(offset: Int, limit: Int) =
        service.getGenerationList(offset, limit)

    override fun getPokedexList(offset: Int, limit: Int) = service.getPokedexList(offset, limit)

    override fun getVersionList(offset: Int, limit: Int) = service.getVersionList(offset, limit)

    override fun getVersionGroupList(offset: Int, limit: Int) =
        service.getVersionGroupList(offset, limit)

    // endregion

    // region Items

    override fun getItemList(offset: Int, limit: Int) = service.getItemList(offset, limit)

    override fun getItemAttributeList(offset: Int, limit: Int) =
        service.getItemAttributeList(offset, limit)

    override fun getItemCategoryList(offset: Int, limit: Int) =
        service.getItemCategoryList(offset, limit)

    override fun getItemFlingEffectList(offset: Int, limit: Int) =
        service.getItemFlingEffectList(offset, limit)

    override fun getItemPocketList(offset: Int, limit: Int) =
        service.getItemPocketList(offset, limit)

    // endregion

    //region Moves

    override fun getMoveList(offset: Int, limit: Int) = service.getMoveList(offset, limit)

    override fun getMoveAilmentList(offset: Int, limit: Int) =
        service.getMoveAilmentList(offset, limit)

    override fun getMoveBattleStyleList(offset: Int, limit: Int) =
        service.getMoveBattleStyleList(offset, limit)

    override fun getMoveCategoryList(offset: Int, limit: Int) =
        service.getMoveCategoryList(offset, limit)

    override fun getMoveDamageClassList(offset: Int, limit: Int) =
        service.getMoveDamageClassList(offset, limit)

    override fun getMoveLearnMethodList(offset: Int, limit: Int) =
        service.getMoveLearnMethodList(offset, limit)

    override fun getMoveTargetList(offset: Int, limit: Int) =
        service.getMoveTargetList(offset, limit)

    // endregion

    // region Locations

    override fun getLocationList(offset: Int, limit: Int) = service.getLocationList(offset, limit)

    override fun getLocationAreaList(offset: Int, limit: Int) =
        service.getLocationAreaList(offset, limit)

    override fun getPalParkAreaList(offset: Int, limit: Int) =
        service.getPalParkAreaList(offset, limit)

    override fun getRegionList(offset: Int, limit: Int) = service.getRegionList(offset, limit)

    // endregion

    // region Machines

    override fun getMachineList(offset: Int, limit: Int) = service.getMachineList(offset, limit)

    // endregion

    // region Pokemon

    override fun getAbilityList(offset: Int, limit: Int) = service.getAbilityList(offset, limit)

    override fun getCharacteristicList(offset: Int, limit: Int) =
        service.getCharacteristicList(offset, limit)

    override fun getEggGroupList(offset: Int, limit: Int) = service.getEggGroupList(offset, limit)

    override fun getGenderList(offset: Int, limit: Int) = service.getGenderList(offset, limit)

    override fun getGrowthRateList(offset: Int, limit: Int) =
        service.getGrowthRateList(offset, limit)

    override fun getNatureList(offset: Int, limit: Int) = service.getNatureList(offset, limit)

    override fun getPokeathlonStatList(offset: Int, limit: Int) =
        service.getPokeathlonStatList(offset, limit)

    override fun getPokemonList(offset: Int, limit: Int) = service.getPokemonList(offset, limit)

    override fun getPokemonColorList(offset: Int, limit: Int) =
        service.getPokemonColorList(offset, limit)

    override fun getPokemonFormList(offset: Int, limit: Int) =
        service.getPokemonFormList(offset, limit)

    override fun getPokemonHabitatList(offset: Int, limit: Int) =
        service.getPokemonHabitatList(offset, limit)

    override fun getPokemonShapeList(offset: Int, limit: Int) =
        service.getPokemonShapeList(offset, limit)

    override fun getPokemonSpeciesList(offset: Int, limit: Int) =
        service.getPokemonSpeciesList(offset, limit)

    override fun getStatList(offset: Int, limit: Int) = service.getStatList(offset, limit)

    override fun getTypeList(offset: Int, limit: Int) = service.getTypeList(offset, limit)

    // endregion

    // region Utility

    override fun getLanguageList(offset: Int, limit: Int) = service.getLanguageList(offset, limit)

    // endregion

    // endregion

    // region Berries

    override fun getBerry(id: Int) = service.getBerry(id)

    override fun getBerryFirmness(id: Int) = service.getBerryFirmness(id)

    override fun getBerryFlavor(id: Int) = service.getBerryFlavor(id)

    // endregion Berries

    // region Contests

    override fun getContestType(id: Int) = service.getContestType(id)

    override fun getContestEffect(id: Int) = service.getContestEffect(id)

    override fun getSuperContestEffect(id: Int) = service.getSuperContestEffect(id)

    // endregion Contests

    // region Encounters

    override fun getEncounterMethod(id: Int) = service.getEncounterMethod(id)

    override fun getEncounterCondition(id: Int) = service.getEncounterCondition(id)

    override fun getEncounterConditionValue(id: Int) = service.getEncounterConditionValue(id)

    // endregion Contests

    // region Evolution

    override fun getEvolutionChain(id: Int) = service.getEvolutionChain(id)

    override fun getEvolutionTrigger(id: Int) = service.getEvolutionTrigger(id)

    // endregion Evolution

    // region Games

    override fun getGeneration(id: Int) = service.getGeneration(id)

    override fun getPokedex(id: Int) = service.getPokedex(id)

    override fun getVersion(id: Int) = service.getVersion(id)

    override fun getVersionGroup(id: Int) = service.getVersionGroup(id)

    // endregion Games

    // region Items

    override fun getItem(id: Int) = service.getItem(id)

    override fun getItemAttribute(id: Int) = service.getItemAttribute(id)

    override fun getItemCategory(id: Int) = service.getItemCategory(id)

    override fun getItemFlingEffect(id: Int) = service.getItemFlingEffect(id)

    override fun getItemPocket(id: Int) = service.getItemPocket(id)

    // endregion Items

    // region Moves

    override fun getMove(id: Int) = service.getMove(id)

    override fun getMoveAilment(id: Int) = service.getMoveAilment(id)

    override fun getMoveBattleStyle(id: Int) = service.getMoveBattleStyle(id)

    override fun getMoveCategory(id: Int) = service.getMoveCategory(id)

    override fun getMoveDamageClass(id: Int) = service.getMoveDamageClass(id)

    override fun getMoveLearnMethod(id: Int) = service.getMoveLearnMethod(id)

    override fun getMoveTarget(id: Int) = service.getMoveTarget(id)

    // endregion Moves

    // region Locations

    override fun getLocation(id: Int) = service.getLocation(id)

    override fun getLocationArea(id: Int) = service.getLocationArea(id)

    override fun getPalParkArea(id: Int) = service.getPalParkArea(id)

    override fun getRegion(id: Int) = service.getRegion(id)

    // endregion Locations

    // region Machines

    override fun getMachine(id: Int) = service.getMachine(id)

    // endregion Machines

    // region Pokemon

    override fun getAbility(id: Int) = service.getAbility(id)

    override fun getCharacteristic(id: Int) = service.getCharacteristic(id)

    override fun getEggGroup(id: Int) = service.getEggGroup(id)

    override fun getGender(id: Int) = service.getGender(id)

    override fun getGrowthRate(id: Int) = service.getGrowthRate(id)

    override fun getNature(id: Int) = service.getNature(id)

    override fun getPokeathlonStat(id: Int) = service.getPokeathlonStat(id)

    override fun getPokemon(id: Int) = service.getPokemon(id)

    override fun getPokemonEncounterList(id: Int) = service.getPokemonEncounterList(id)

    override fun getPokemonColor(id: Int) = service.getPokemonColor(id)

    override fun getPokemonForm(id: Int) = service.getPokemonForm(id)

    override fun getPokemonHabitat(id: Int) = service.getPokemonHabitat(id)

    override fun getPokemonShape(id: Int) = service.getPokemonShape(id)

    override fun getPokemonSpecies(id: Int) = service.getPokemonSpecies(id)

    override fun getStat(id: Int) = service.getStat(id)

    override fun getType(id: Int) = service.getType(id)

    // endregion Pokemon

    // region Utility

    override fun getLanguage(id: Int) = service.getLanguage(id)

    // endregion Utility
}
