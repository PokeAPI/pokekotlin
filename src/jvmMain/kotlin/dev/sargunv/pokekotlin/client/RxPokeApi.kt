package dev.sargunv.pokekotlin.client

import dev.sargunv.pokekotlin.model.Ability
import dev.sargunv.pokekotlin.model.ApiResourceList
import dev.sargunv.pokekotlin.model.Berry
import dev.sargunv.pokekotlin.model.BerryFirmness
import dev.sargunv.pokekotlin.model.BerryFlavor
import dev.sargunv.pokekotlin.model.Characteristic
import dev.sargunv.pokekotlin.model.ContestEffect
import dev.sargunv.pokekotlin.model.ContestType
import dev.sargunv.pokekotlin.model.EggGroup
import dev.sargunv.pokekotlin.model.EncounterCondition
import dev.sargunv.pokekotlin.model.EncounterConditionValue
import dev.sargunv.pokekotlin.model.EncounterMethod
import dev.sargunv.pokekotlin.model.EvolutionChain
import dev.sargunv.pokekotlin.model.EvolutionTrigger
import dev.sargunv.pokekotlin.model.Gender
import dev.sargunv.pokekotlin.model.Generation
import dev.sargunv.pokekotlin.model.GrowthRate
import dev.sargunv.pokekotlin.model.Item
import dev.sargunv.pokekotlin.model.ItemAttribute
import dev.sargunv.pokekotlin.model.ItemCategory
import dev.sargunv.pokekotlin.model.ItemFlingEffect
import dev.sargunv.pokekotlin.model.ItemPocket
import dev.sargunv.pokekotlin.model.Language
import dev.sargunv.pokekotlin.model.Location
import dev.sargunv.pokekotlin.model.LocationArea
import dev.sargunv.pokekotlin.model.LocationAreaEncounter
import dev.sargunv.pokekotlin.model.Machine
import dev.sargunv.pokekotlin.model.Move
import dev.sargunv.pokekotlin.model.MoveAilment
import dev.sargunv.pokekotlin.model.MoveBattleStyle
import dev.sargunv.pokekotlin.model.MoveCategory
import dev.sargunv.pokekotlin.model.MoveDamageClass
import dev.sargunv.pokekotlin.model.MoveLearnMethod
import dev.sargunv.pokekotlin.model.MoveTarget
import dev.sargunv.pokekotlin.model.NamedApiResourceList
import dev.sargunv.pokekotlin.model.Nature
import dev.sargunv.pokekotlin.model.PalParkArea
import dev.sargunv.pokekotlin.model.PokeathlonStat
import dev.sargunv.pokekotlin.model.Pokedex
import dev.sargunv.pokekotlin.model.Pokemon
import dev.sargunv.pokekotlin.model.PokemonColor
import dev.sargunv.pokekotlin.model.PokemonForm
import dev.sargunv.pokekotlin.model.PokemonHabitat
import dev.sargunv.pokekotlin.model.PokemonShape
import dev.sargunv.pokekotlin.model.PokemonSpecies
import dev.sargunv.pokekotlin.model.Region
import dev.sargunv.pokekotlin.model.Stat
import dev.sargunv.pokekotlin.model.SuperContestEffect
import dev.sargunv.pokekotlin.model.Type
import dev.sargunv.pokekotlin.model.Version
import dev.sargunv.pokekotlin.model.VersionGroup
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
