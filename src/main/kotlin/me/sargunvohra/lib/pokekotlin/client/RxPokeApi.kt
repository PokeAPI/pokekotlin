package me.sargunvohra.lib.pokekotlin.client

import me.sargunvohra.lib.pokekotlin.model.Ability
import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.Berry
import me.sargunvohra.lib.pokekotlin.model.BerryFirmness
import me.sargunvohra.lib.pokekotlin.model.BerryFlavor
import me.sargunvohra.lib.pokekotlin.model.Characteristic
import me.sargunvohra.lib.pokekotlin.model.ContestEffect
import me.sargunvohra.lib.pokekotlin.model.ContestType
import me.sargunvohra.lib.pokekotlin.model.EggGroup
import me.sargunvohra.lib.pokekotlin.model.EncounterCondition
import me.sargunvohra.lib.pokekotlin.model.EncounterConditionValue
import me.sargunvohra.lib.pokekotlin.model.EncounterMethod
import me.sargunvohra.lib.pokekotlin.model.EvolutionChain
import me.sargunvohra.lib.pokekotlin.model.EvolutionTrigger
import me.sargunvohra.lib.pokekotlin.model.Gender
import me.sargunvohra.lib.pokekotlin.model.Generation
import me.sargunvohra.lib.pokekotlin.model.GrowthRate
import me.sargunvohra.lib.pokekotlin.model.Item
import me.sargunvohra.lib.pokekotlin.model.ItemAttribute
import me.sargunvohra.lib.pokekotlin.model.ItemCategory
import me.sargunvohra.lib.pokekotlin.model.ItemFlingEffect
import me.sargunvohra.lib.pokekotlin.model.ItemPocket
import me.sargunvohra.lib.pokekotlin.model.Language
import me.sargunvohra.lib.pokekotlin.model.Location
import me.sargunvohra.lib.pokekotlin.model.LocationArea
import me.sargunvohra.lib.pokekotlin.model.LocationAreaEncounter
import me.sargunvohra.lib.pokekotlin.model.Machine
import me.sargunvohra.lib.pokekotlin.model.Move
import me.sargunvohra.lib.pokekotlin.model.MoveAilment
import me.sargunvohra.lib.pokekotlin.model.MoveBattleStyle
import me.sargunvohra.lib.pokekotlin.model.MoveCategory
import me.sargunvohra.lib.pokekotlin.model.MoveDamageClass
import me.sargunvohra.lib.pokekotlin.model.MoveLearnMethod
import me.sargunvohra.lib.pokekotlin.model.MoveTarget
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.model.Nature
import me.sargunvohra.lib.pokekotlin.model.PalParkArea
import me.sargunvohra.lib.pokekotlin.model.PokeathlonStat
import me.sargunvohra.lib.pokekotlin.model.Pokedex
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonColor
import me.sargunvohra.lib.pokekotlin.model.PokemonForm
import me.sargunvohra.lib.pokekotlin.model.PokemonHabitat
import me.sargunvohra.lib.pokekotlin.model.PokemonShape
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies
import me.sargunvohra.lib.pokekotlin.model.Region
import me.sargunvohra.lib.pokekotlin.model.Stat
import me.sargunvohra.lib.pokekotlin.model.SuperContestEffect
import me.sargunvohra.lib.pokekotlin.model.Type
import me.sargunvohra.lib.pokekotlin.model.Version
import me.sargunvohra.lib.pokekotlin.model.VersionGroup
import rx.Observable

interface RxPokeApi {

    fun getBerryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getBerryFirmnessList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getBerryFlavorList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getContestTypeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getContestEffectList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getSuperContestEffectList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEncounterMethodList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEncounterConditionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEncounterConditionValueList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getEvolutionChainList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEvolutionTriggerList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGenerationList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokedexList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getVersionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getVersionGroupList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemAttributeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemCategoryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemFlingEffectList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getItemPocketList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveAilmentList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveBattleStyleList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveCategoryList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveDamageClassList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveLearnMethodList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMoveTargetList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLocationList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLocationAreaList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPalParkAreaList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getRegionList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getMachineList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getAbilityList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getCharacteristicList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEggGroupList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGenderList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGrowthRateList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getNatureList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokeathlonStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonColorList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonFormList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonHabitatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonShapeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonSpeciesList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getTypeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getLanguageList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getBerry(id: Int): Observable<Berry>

    fun getBerryFirmness(id: Int): Observable<BerryFirmness>

    fun getBerryFlavor(id: Int): Observable<BerryFlavor>

    fun getContestType(id: Int): Observable<ContestType>

    fun getContestEffect(id: Int): Observable<ContestEffect>

    fun getSuperContestEffect(id: Int): Observable<SuperContestEffect>

    fun getEncounterMethod(id: Int): Observable<EncounterMethod>

    fun getEncounterCondition(id: Int): Observable<EncounterCondition>

    fun getEncounterConditionValue(id: Int): Observable<EncounterConditionValue>

    fun getEvolutionChain(id: Int): Observable<EvolutionChain>

    fun getEvolutionTrigger(id: Int): Observable<EvolutionTrigger>

    fun getGeneration(id: Int): Observable<Generation>

    fun getPokedex(id: Int): Observable<Pokedex>

    fun getVersion(id: Int): Observable<Version>

    fun getVersionGroup(id: Int): Observable<VersionGroup>

    fun getItem(id: Int): Observable<Item>

    fun getItemAttribute(id: Int): Observable<ItemAttribute>

    fun getItemCategory(id: Int): Observable<ItemCategory>

    fun getItemFlingEffect(id: Int): Observable<ItemFlingEffect>

    fun getItemPocket(id: Int): Observable<ItemPocket>

    fun getMove(id: Int): Observable<Move>

    fun getMoveAilment(id: Int): Observable<MoveAilment>

    fun getMoveBattleStyle(id: Int): Observable<MoveBattleStyle>

    fun getMoveCategory(id: Int): Observable<MoveCategory>

    fun getMoveDamageClass(id: Int): Observable<MoveDamageClass>

    fun getMoveLearnMethod(id: Int): Observable<MoveLearnMethod>

    fun getMoveTarget(id: Int): Observable<MoveTarget>

    fun getLocation(id: Int): Observable<Location>

    fun getLocationArea(id: Int): Observable<LocationArea>

    fun getPalParkArea(id: Int): Observable<PalParkArea>

    fun getRegion(id: Int): Observable<Region>

    fun getMachine(id: Int): Observable<Machine>

    fun getAbility(id: Int): Observable<Ability>

    fun getCharacteristic(id: Int): Observable<Characteristic>

    fun getEggGroup(id: Int): Observable<EggGroup>

    fun getGender(id: Int): Observable<Gender>

    fun getGrowthRate(id: Int): Observable<GrowthRate>

    fun getNature(id: Int): Observable<Nature>

    fun getPokeathlonStat(id: Int): Observable<PokeathlonStat>

    fun getPokemon(id: Int): Observable<Pokemon>

    fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounter>>

    fun getPokemonColor(id: Int): Observable<PokemonColor>

    fun getPokemonForm(id: Int): Observable<PokemonForm>

    fun getPokemonHabitat(id: Int): Observable<PokemonHabitat>

    fun getPokemonShape(id: Int): Observable<PokemonShape>

    fun getPokemonSpecies(id: Int): Observable<PokemonSpecies>

    fun getStat(id: Int): Observable<Stat>

    fun getType(id: Int): Observable<Type>

    fun getLanguage(id: Int): Observable<Language>
}
