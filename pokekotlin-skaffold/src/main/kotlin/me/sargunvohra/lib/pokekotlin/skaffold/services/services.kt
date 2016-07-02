package me.sargunvohra.lib.pokekotlin.skaffold.services

import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.model.*

class BerryService(private val api: PokeApi) : PokeApiService<NamedApiResource, Berry> {
    override fun getResource(id: Int) = api.getBerry(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getBerryList(offset, limit)
}

class BerryFirmnessService(private val api: PokeApi) : PokeApiService<NamedApiResource, BerryFirmness> {
    override fun getResource(id: Int) = api.getBerryFirmness(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getBerryFirmnessList(offset, limit)
}

class BerryFlavorService(private val api: PokeApi) : PokeApiService<NamedApiResource, BerryFlavor> {
    override fun getResource(id: Int) = api.getBerryFlavor(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getBerryFlavorList(offset, limit)
}

class ContestTypeService(private val api: PokeApi) : PokeApiService<NamedApiResource, ContestType> {
    override fun getResource(id: Int) = api.getContestType(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getContestTypeList(offset, limit)
}

class ContestEffectService(private val api: PokeApi) : PokeApiService<ApiResource, ContestEffect> {
    override fun getResource(id: Int) = api.getContestEffect(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getContestEffectList(offset, limit)
}

class SuperContestEffectService(private val api: PokeApi) : PokeApiService<ApiResource, SuperContestEffect> {
    override fun getResource(id: Int) = api.getSuperContestEffect(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getSuperContestEffectList(offset, limit)
}

class EncounterMethodService(private val api: PokeApi) : PokeApiService<NamedApiResource, EncounterMethod> {
    override fun getResource(id: Int) = api.getEncounterMethod(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEncounterMethodList(offset, limit)
}

class EncounterConditionService(private val api: PokeApi) : PokeApiService<NamedApiResource, EncounterCondition> {
    override fun getResource(id: Int) = api.getEncounterCondition(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEncounterConditionList(offset, limit)
}

class EncounterConditionValueService(private val api: PokeApi) : PokeApiService<NamedApiResource, EncounterConditionValue> {
    override fun getResource(id: Int) = api.getEncounterConditionValue(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEncounterConditionValueList(offset, limit)
}

class EvolutionChainService(private val api: PokeApi) : PokeApiService<ApiResource, EvolutionChain> {
    override fun getResource(id: Int) = api.getEvolutionChain(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEvolutionChainList(offset, limit)
}

class EvolutionTriggerService(private val api: PokeApi) : PokeApiService<NamedApiResource, EvolutionTrigger> {
    override fun getResource(id: Int) = api.getEvolutionTrigger(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEvolutionTriggerList(offset, limit)
}

class GenerationService(private val api: PokeApi) : PokeApiService<NamedApiResource, Generation> {
    override fun getResource(id: Int) = api.getGeneration(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getGenerationList(offset, limit)
}

class PokedexService(private val api: PokeApi) : PokeApiService<NamedApiResource, Pokedex> {
    override fun getResource(id: Int) = api.getPokedex(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokedexList(offset, limit)
}

class VersionService(private val api: PokeApi) : PokeApiService<NamedApiResource, Version> {
    override fun getResource(id: Int) = api.getVersion(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getVersionList(offset, limit)
}

class VersionGroupService(private val api: PokeApi) : PokeApiService<NamedApiResource, VersionGroup> {
    override fun getResource(id: Int) = api.getVersionGroup(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getVersionGroupList(offset, limit)
}

class ItemService(private val api: PokeApi) : PokeApiService<NamedApiResource, Item> {
    override fun getResource(id: Int) = api.getItem(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getItemList(offset, limit)
}

class ItemAttributeService(private val api: PokeApi) : PokeApiService<NamedApiResource, ItemAttribute> {
    override fun getResource(id: Int) = api.getItemAttribute(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getItemAttributeList(offset, limit)
}

class ItemCategoryService(private val api: PokeApi) : PokeApiService<NamedApiResource, ItemCategory> {
    override fun getResource(id: Int) = api.getItemCategory(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getItemCategoryList(offset, limit)
}

class ItemFlingEffectService(private val api: PokeApi) : PokeApiService<NamedApiResource, ItemFlingEffect> {
    override fun getResource(id: Int) = api.getItemFlingEffect(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getItemFlingEffectList(offset, limit)
}

class ItemPocketService(private val api: PokeApi) : PokeApiService<NamedApiResource, ItemPocket> {
    override fun getResource(id: Int) = api.getItemPocket(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getItemPocketList(offset, limit)
}

class MoveService(private val api: PokeApi) : PokeApiService<NamedApiResource, Move> {
    override fun getResource(id: Int) = api.getMove(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveList(offset, limit)
}

class MoveAilmentService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveAilment> {
    override fun getResource(id: Int) = api.getMoveAilment(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveAilmentList(offset, limit)
}

class MoveBattleStyleService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveBattleStyle> {
    override fun getResource(id: Int) = api.getMoveBattleStyle(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveBattleStyleList(offset, limit)
}

class MoveCategoryService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveCategory> {
    override fun getResource(id: Int) = api.getMoveCategory(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveCategoryList(offset, limit)
}

class MoveDamageClassService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveDamageClass> {
    override fun getResource(id: Int) = api.getMoveDamageClass(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveDamageClassList(offset, limit)
}

class MoveLearnMethodService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveLearnMethod> {
    override fun getResource(id: Int) = api.getMoveLearnMethod(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveLearnMethodList(offset, limit)
}

class MoveTargetService(private val api: PokeApi) : PokeApiService<NamedApiResource, MoveTarget> {
    override fun getResource(id: Int) = api.getMoveTarget(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getMoveTargetList(offset, limit)
}

class LocationService(private val api: PokeApi) : PokeApiService<NamedApiResource, Location> {
    override fun getResource(id: Int) = api.getLocation(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getLocationList(offset, limit)
}

class LocationAreaService(private val api: PokeApi) : PokeApiService<NamedApiResource, LocationArea> {
    override fun getResource(id: Int) = api.getLocationArea(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getLocationAreaList(offset, limit)
}

class PalParkAreaService(private val api: PokeApi) : PokeApiService<NamedApiResource, PalParkArea> {
    override fun getResource(id: Int) = api.getPalParkArea(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPalParkAreaList(offset, limit)
}

class RegionService(private val api: PokeApi) : PokeApiService<NamedApiResource, Region> {
    override fun getResource(id: Int) = api.getRegion(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getRegionList(offset, limit)
}

class AbilityService(private val api: PokeApi) : PokeApiService<NamedApiResource, Ability> {
    override fun getResource(id: Int) = api.getAbility(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getAbilityList(offset, limit)
}

class CharacteristicService(private val api: PokeApi) : PokeApiService<ApiResource, Characteristic> {
    override fun getResource(id: Int) = api.getCharacteristic(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getCharacteristicList(offset, limit)
}

class EggGroupService(private val api: PokeApi) : PokeApiService<NamedApiResource, EggGroup> {
    override fun getResource(id: Int) = api.getEggGroup(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getEggGroupList(offset, limit)
}

class GenderService(private val api: PokeApi) : PokeApiService<NamedApiResource, Gender> {
    override fun getResource(id: Int) = api.getGender(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getGenderList(offset, limit)
}

class GrowthRateService(private val api: PokeApi) : PokeApiService<NamedApiResource, GrowthRate> {
    override fun getResource(id: Int) = api.getGrowthRate(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getGrowthRateList(offset, limit)
}

class NatureService(private val api: PokeApi) : PokeApiService<NamedApiResource, Nature> {
    override fun getResource(id: Int) = api.getNature(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getNatureList(offset, limit)
}

class PokeathlonStatService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokeathlonStat> {
    override fun getResource(id: Int) = api.getPokeathlonStat(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokeathlonStatList(offset, limit)
}

class PokemonService(private val api: PokeApi) : PokeApiService<NamedApiResource, Pokemon> {
    override fun getResource(id: Int) = api.getPokemon(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonList(offset, limit)
}

class PokemonEncounterListService(private val api: PokeApi) : PokeApiService<NamedApiResource, List<LocationAreaEncounter>> {
    override fun getResource(id: Int) = api.getPokemonEncounterList(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonList(offset, limit)
}

class PokemonColorService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokemonColor> {
    override fun getResource(id: Int) = api.getPokemonColor(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonColorList(offset, limit)
}

class PokemonFormService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokemonForm> {
    override fun getResource(id: Int) = api.getPokemonForm(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonFormList(offset, limit)
}

class PokemonHabitatService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokemonHabitat> {
    override fun getResource(id: Int) = api.getPokemonHabitat(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonHabitatList(offset, limit)
}

class PokemonShapeService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokemonShape> {
    override fun getResource(id: Int) = api.getPokemonShape(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonShapeList(offset, limit)
}

class PokemonSpeciesService(private val api: PokeApi) : PokeApiService<NamedApiResource, PokemonSpecies> {
    override fun getResource(id: Int) = api.getPokemonSpecies(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getPokemonSpeciesList(offset, limit)
}

class StatService(private val api: PokeApi) : PokeApiService<NamedApiResource, Stat> {
    override fun getResource(id: Int) = api.getStat(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getStatList(offset, limit)
}

class TypeService(private val api: PokeApi) : PokeApiService<NamedApiResource, Type> {
    override fun getResource(id: Int) = api.getType(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getTypeList(offset, limit)
}

class LanguageService(private val api: PokeApi) : PokeApiService<NamedApiResource, Language> {
    override fun getResource(id: Int) = api.getLanguage(id)
    override fun getResourceList(offset: Int, limit: Int) = api.getLanguageList(offset, limit)
}