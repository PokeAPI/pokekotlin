package me.sargunvohra.lib.pokekotlin.client

import me.sargunvohra.lib.pokekotlin.json.*

interface IPokeApiClient {

    // region Resource Lists

    // region Berries

    fun getBerryList(offset: Int, limit: Int): NamedApiResourceList

    fun getBerryFirmnessList(offset: Int, limit: Int): NamedApiResourceList

    fun getBerryFlavorList(offset: Int, limit: Int): NamedApiResourceList

    // endregion Berries

    // region Contests

    fun getContestTypeList(offset: Int, limit: Int): NamedApiResourceList

    fun getContestEffectList(offset: Int, limit: Int): ApiResourceList

    fun getSuperContestEffectList(offset: Int, limit: Int): ApiResourceList

    // endregion Contests

    // region Encounters

    fun getEncounterMethodList(offset: Int, limit: Int): NamedApiResourceList

    fun getEncounterConditionList(offset: Int, limit: Int): NamedApiResourceList

    fun getEncounterConditionValueList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // region Evolution

    fun getEvolutionChainList(offset: Int, limit: Int): ApiResourceList

    fun getEvolutionTriggerList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    //region Games

    fun getGenerationList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokedexList(offset: Int, limit: Int): NamedApiResourceList

    fun getVersionList(offset: Int, limit: Int): NamedApiResourceList

    fun getVersionGroupList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // region Items

    fun getItemList(offset: Int, limit: Int): NamedApiResourceList

    fun getItemAttributeList(offset: Int, limit: Int): NamedApiResourceList

    fun getItemCategoryList(offset: Int, limit: Int): NamedApiResourceList

    fun getItemFlingEffectList(offset: Int, limit: Int): NamedApiResourceList

    fun getItemPocketList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    //region Moves

    fun getMoveList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveAilmentList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveBattleStyleList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveCategoryList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveDamageClassList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveLearnMethodList(offset: Int, limit: Int): NamedApiResourceList

    fun getMoveTargetList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // region Locations

    fun getLocationList(offset: Int, limit: Int): NamedApiResourceList

    fun getLocationAreaList(offset: Int, limit: Int): NamedApiResourceList

    fun getPalParkAreaList(offset: Int, limit: Int): NamedApiResourceList

    fun getRegionList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // region Pokemon

    fun getAbilityList(offset: Int, limit: Int): NamedApiResourceList

    fun getCharacteristicList(offset: Int, limit: Int): ApiResourceList

    fun getEggGroupList(offset: Int, limit: Int): NamedApiResourceList

    fun getGenderList(offset: Int, limit: Int): NamedApiResourceList

    fun getGrowthRateList(offset: Int, limit: Int): NamedApiResourceList

    fun getNatureList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokeathlonList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonColorList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonFormList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonHabitatList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonShapeList(offset: Int, limit: Int): NamedApiResourceList

    fun getPokemonSpeciesList(offset: Int, limit: Int): NamedApiResourceList

    fun getStatList(offset: Int, limit: Int): NamedApiResourceList

    fun getTypeList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // region Utility

    fun getLanguageList(offset: Int, limit: Int): NamedApiResourceList

    // endregion

    // endregion

    // region Berries

    fun getBerry(id: Int): Berry

    fun getBerryFirmness(id: Int): BerryFirmness

    fun getBerryFlavor(id: Int): BerryFlavor

    // endregion Berries

    // region Contests

    fun getContestType(id: Int): ContestType

    fun getContestEffect(id: Int): ContestEffect

    fun getSuperContestEffect(id: Int): SuperContestEffect

    // endregion Contests

    // region Encounters

    fun getEncounterMethod(id: Int): EncounterMethod

    fun getEncounterCondition(id: Int): EncounterCondition

    fun getEncounterConditionValue(id: Int): EncounterConditionValue

    // endregion Contests

    // region Evolution

    fun getEvolutionChain(id: Int): EvolutionChain

    fun getEvolutionTrigger(id: Int): EvolutionTrigger

    // endregion Evolution

    // region Games

    fun getGeneration(id: Int): Generation

    fun getPokedex(id: Int): Pokedex

    fun getVersion(id: Int): Version

    fun getVersionGroup(id: Int): VersionGroup

    // endregion Games

    // region Items

    fun getItem(id: Int): Item

    fun getItemAttribute(id: Int): ItemAttribute

    fun getItemCategory(id: Int): ItemCategory

    fun getItemFlingEffect(id: Int): ItemFlingEffect

    fun getItemPocket(id: Int): ItemPocket

    // endregion Items

    // region Moves

    fun getMove(id: Int): Move

    fun getMoveAilment(id: Int): MoveAilment

    fun getMoveBattleStyle(id: Int): MoveBattleStyle

    fun getMoveCategory(id: Int): MoveCategory

    fun getMoveDamageClass(id: Int): MoveDamageClass

    fun getMoveLearnMethod(id: Int): MoveLearnMethod

    fun getMoveTarget(id: Int): MoveTarget

    // endregion Moves

    // region Locations

    fun getLocation(id: Int): Location

    fun getLocationArea(id: Int): LocationArea

    fun getPalParkArea(id: Int): PalParkArea

    fun getRegion(id: Int): Region

    // endregion Locations

    // region Pokemon

    fun getAbility(id: Int): Ability

    fun getCharacteristic(id: Int): Characteristic

    fun getEggGroup(id: Int): EggGroup

    fun getGender(id: Int): Gender

    fun getGrowthRate(id: Int): GrowthRate

    fun getNature(id: Int): Nature

    fun getPokeathlonStat(id: Int): PokeathlonStat

    fun getPokemon(id: Int): Pokemon

    fun getPokemonColor(id: Int): PokemonColor

    fun getPokemonForm(id: Int): PokemonForm

    fun getPokemonHabitat(id: Int): PokemonHabitat

    fun getPokemonShape(id: Int): PokemonShape

    fun getPokemonSpecies(id: Int): PokemonSpecies

    fun getStat(id: Int): Stat

    fun getType(id: Int): Type

    // endregion Pokemon

    // region Utility

    fun getLanguage(id: Int): Language

    // endregion Utility
}