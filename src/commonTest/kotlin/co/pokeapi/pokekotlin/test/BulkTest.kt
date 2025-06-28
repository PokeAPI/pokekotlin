package co.pokeapi.pokekotlin.test

import co.pokeapi.pokekotlin.model.ResourceSummary
import co.pokeapi.pokekotlin.model.ResourceSummaryList
import kotlin.test.Test
import kotlin.test.fail
import kotlinx.coroutines.test.runTest

@IgnoreOnJvm // Should work on JVM but it's OOMing.
class BulkTest {

  private suspend fun testCase(cat: String, id: Int, getObject: suspend (Int) -> Any) {
    println("$cat (id=$id)")
    try {
      getObject(id)
    } catch (e: Throwable) {
      println("ERROR: ${e::class.simpleName}: ${e.message}")
      fail()
    }
  }

  private suspend fun <S : ResourceSummary, O : Any> testEach(
    getList: suspend (Int, Int) -> ResourceSummaryList<S>,
    getObject: suspend (Int) -> O,
  ) {
    val list = getList(0, getList(0, 0).count).results
    list.forEach { testCase(list[0].category, it.id, getObject) }
  }

  @Test
  fun bulkBerry() = runTest {
    testEach({ o, l -> LocalPokeApi.getBerryList(o, l) }, { i -> LocalPokeApi.getBerry(i) })
  }

  @Test
  fun bulkBerryFirmness() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getBerryFirmnessList(o, l) },
      { i -> LocalPokeApi.getBerryFirmness(i) },
    )
  }

  @Test
  fun bulkBerryFlavor() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getBerryFlavorList(o, l) },
      { i -> LocalPokeApi.getBerryFlavor(i) },
    )
  }

  @Test
  fun bulkContestType() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getContestTypeList(o, l) },
      { i -> LocalPokeApi.getContestType(i) },
    )
  }

  @Test
  fun bulkContestEffect() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getContestEffectList(o, l) },
      { i -> LocalPokeApi.getContestEffect(i) },
    )
  }

  @Test
  fun bulkSuperContestEffect() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getSuperContestEffectList(o, l) },
      { i -> LocalPokeApi.getSuperContestEffect(i) },
    )
  }

  @Test
  fun bulkEncounterMethod() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getEncounterMethodList(o, l) },
      { i -> LocalPokeApi.getEncounterMethod(i) },
    )
  }

  @Test
  fun bulkEncounterCondition() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getEncounterConditionList(o, l) },
      { i -> LocalPokeApi.getEncounterCondition(i) },
    )
  }

  @Test
  fun bulkEncounterConditionValue() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getEncounterConditionValueList(o, l) },
      { i -> LocalPokeApi.getEncounterConditionValue(i) },
    )
  }

  @Test
  fun bulkEvolutionChain() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getEvolutionChainList(o, l) },
      { i -> LocalPokeApi.getEvolutionChain(i) },
    )
  }

  @Test
  fun bulkEvolutionTrigger() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getEvolutionTriggerList(o, l) },
      { i -> LocalPokeApi.getEvolutionTrigger(i) },
    )
  }

  @Test
  fun bulkGeneration() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getGenerationList(o, l) },
      { i -> LocalPokeApi.getGeneration(i) },
    )
  }

  @Test
  fun bulkPokedex() = runTest {
    testEach({ o, l -> LocalPokeApi.getPokedexList(o, l) }, { i -> LocalPokeApi.getPokedex(i) })
  }

  @Test
  fun bulkVersion() = runTest {
    testEach({ o, l -> LocalPokeApi.getVersionList(o, l) }, { i -> LocalPokeApi.getVersion(i) })
  }

  @Test
  fun bulkVersionGroup() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getVersionGroupList(o, l) },
      { i -> LocalPokeApi.getVersionGroup(i) },
    )
  }

  @Test
  fun bulkItem() = runTest {
    testEach({ o, l -> LocalPokeApi.getItemList(o, l) }, { i -> LocalPokeApi.getItem(i) })
  }

  @Test
  fun bulkItemAttribute() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getItemAttributeList(o, l) },
      { i -> LocalPokeApi.getItemAttribute(i) },
    )
  }

  @Test
  fun bulkItemCategory() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getItemCategoryList(o, l) },
      { i -> LocalPokeApi.getItemCategory(i) },
    )
  }

  @Test
  fun bulkItemFlingEffect() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getItemFlingEffectList(o, l) },
      { i -> LocalPokeApi.getItemFlingEffect(i) },
    )
  }

  @Test
  fun bulkItemPocket() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getItemPocketList(o, l) },
      { i -> LocalPokeApi.getItemPocket(i) },
    )
  }

  @Test
  fun bulkMove() = runTest {
    testEach({ o, l -> LocalPokeApi.getMoveList(o, l) }, { i -> LocalPokeApi.getMove(i) })
  }

  @Test
  fun bulkMoveAilment() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveAilmentList(o, l) },
      { i -> LocalPokeApi.getMoveAilment(i) },
    )
  }

  @Test
  fun bulkMoveBattleStyle() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveBattleStyleList(o, l) },
      { i -> LocalPokeApi.getMoveBattleStyle(i) },
    )
  }

  @Test
  fun bulkMoveCategory() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveCategoryList(o, l) },
      { i -> LocalPokeApi.getMoveCategory(i) },
    )
  }

  @Test
  fun bulkMoveDamageClass() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveDamageClassList(o, l) },
      { i -> LocalPokeApi.getMoveDamageClass(i) },
    )
  }

  @Test
  fun bulkMoveLearnMethod() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveLearnMethodList(o, l) },
      { i -> LocalPokeApi.getMoveLearnMethod(i) },
    )
  }

  @Test
  fun bulkMoveTarget() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getMoveTargetList(o, l) },
      { i -> LocalPokeApi.getMoveTarget(i) },
    )
  }

  @Test
  fun bulkLocation() = runTest {
    testEach({ o, l -> LocalPokeApi.getLocationList(o, l) }, { i -> LocalPokeApi.getLocation(i) })
  }

  @Test
  fun bulkLocationArea() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getLocationAreaList(o, l) },
      { i -> LocalPokeApi.getLocationArea(i) },
    )
  }

  @Test
  fun bulkPalParkArea() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPalParkAreaList(o, l) },
      { i -> LocalPokeApi.getPalParkArea(i) },
    )
  }

  @Test
  fun bulkRegion() = runTest {
    testEach({ o, l -> LocalPokeApi.getRegionList(o, l) }, { i -> LocalPokeApi.getRegion(i) })
  }

  @Test
  fun bulkMachine() = runTest {
    testEach({ o, l -> LocalPokeApi.getMachineList(o, l) }, { i -> LocalPokeApi.getMachine(i) })
  }

  @Test
  fun bulkAbility() = runTest {
    testEach({ o, l -> LocalPokeApi.getAbilityList(o, l) }, { i -> LocalPokeApi.getAbility(i) })
  }

  @Test
  fun bulkCharacteristic() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getCharacteristicList(o, l) },
      { i -> LocalPokeApi.getCharacteristic(i) },
    )
  }

  @Test
  fun bulkEggGroup() = runTest {
    testEach({ o, l -> LocalPokeApi.getEggGroupList(o, l) }, { i -> LocalPokeApi.getEggGroup(i) })
  }

  @Test
  fun bulkGender() = runTest {
    testEach({ o, l -> LocalPokeApi.getGenderList(o, l) }, { i -> LocalPokeApi.getGender(i) })
  }

  @Test
  fun bulkGrowthRate() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getGrowthRateList(o, l) },
      { i -> LocalPokeApi.getGrowthRate(i) },
    )
  }

  @Test
  fun bulkNature() = runTest {
    testEach({ o, l -> LocalPokeApi.getNatureList(o, l) }, { i -> LocalPokeApi.getNature(i) })
  }

  @Test
  fun bulkPokeathlonStat() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokeathlonStatList(o, l) },
      { i -> LocalPokeApi.getPokeathlonStat(i) },
    )
  }

  @Test
  fun bulkPokemon() = runTest {
    testEach({ o, l -> LocalPokeApi.getPokemonList(o, l) }, { i -> LocalPokeApi.getPokemon(i) })
  }

  @Test
  fun bulkPokemonEncounters() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonList(o, l) },
      { i -> LocalPokeApi.getPokemonEncounterList(i) },
    )
  }

  @Test
  fun bulkPokemonColor() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonColorList(o, l) },
      { i -> LocalPokeApi.getPokemonColor(i) },
    )
  }

  @Test
  fun bulkPokemonForm() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonFormList(o, l) },
      { i -> LocalPokeApi.getPokemonForm(i) },
    )
  }

  @Test
  fun bulkPokemonHabitat() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonHabitatList(o, l) },
      { i -> LocalPokeApi.getPokemonHabitat(i) },
    )
  }

  @Test
  fun bulkPokemonShape() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonShapeList(o, l) },
      { i -> LocalPokeApi.getPokemonShape(i) },
    )
  }

  @Test
  fun bulkPokemonSpecies() = runTest {
    testEach(
      { o, l -> LocalPokeApi.getPokemonSpeciesList(o, l) },
      { i -> LocalPokeApi.getPokemonSpecies(i) },
    )
  }

  @Test
  fun bulkStat() = runTest {
    testEach({ o, l -> LocalPokeApi.getStatList(o, l) }, { i -> LocalPokeApi.getStat(i) })
  }

  @Test
  fun bulkType() = runTest {
    testEach({ o, l -> LocalPokeApi.getTypeList(o, l) }, { i -> LocalPokeApi.getType(i) })
  }

  @Test
  fun bulkLanguage() = runTest {
    testEach({ o, l -> LocalPokeApi.getLanguageList(o, l) }, { i -> LocalPokeApi.getLanguage(i) })
  }
}
