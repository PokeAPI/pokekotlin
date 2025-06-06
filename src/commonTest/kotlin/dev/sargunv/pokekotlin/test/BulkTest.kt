package dev.sargunv.pokekotlin.test

import dev.sargunv.pokekotlin.model.ResourceSummary
import dev.sargunv.pokekotlin.model.ResourceSummaryList
import kotlin.test.Test
import kotlin.test.fail
import kotlinx.coroutines.test.runTest

class BulkTest {

  private suspend fun testCase(cat: String, ids: List<Int>, getObject: suspend (Int) -> Any) {
    var pass = true
    val count = ids.size
    println("$cat: $count total")
    ids.forEachIndexed { i, id ->
      print("$cat ${i + 1}/$count (id=$id) ... ")
      try {
        getObject(id)
        println("deserialized!")
      } catch (e: Throwable) {
        println("ERROR: ${e::class.simpleName}: ${e.message}")
        pass = false
      }
    }
    if (!pass) fail()
  }

  private suspend fun <T : ResourceSummary> testEach(
    getList: suspend (Int, Int) -> ResourceSummaryList<T>,
    getObject: suspend (Int) -> Any,
  ) {
    val list = getList(0, getList(0, 0).count).results
    testCase(list[0].category, list.map { it.id }, getObject)
  }

  @Test
  fun bulkBerry() = runTest {
    testEach(
      { o, l -> MockServer.client.getBerryList(o, l) },
      { i -> MockServer.client.getBerry(i) },
    )
  }

  @Test
  fun bulkBerryFirmness() = runTest {
    testEach(
      { o, l -> MockServer.client.getBerryFirmnessList(o, l) },
      { i -> MockServer.client.getBerryFirmness(i) },
    )
  }

  @Test
  fun bulkBerryFlavor() = runTest {
    testEach(
      { o, l -> MockServer.client.getBerryFlavorList(o, l) },
      { i -> MockServer.client.getBerryFlavor(i) },
    )
  }

  @Test
  fun bulkContestType() = runTest {
    testEach(
      { o, l -> MockServer.client.getContestTypeList(o, l) },
      { i -> MockServer.client.getContestType(i) },
    )
  }

  @Test
  fun bulkContestEffect() = runTest {
    testEach(
      { o, l -> MockServer.client.getContestEffectList(o, l) },
      { i -> MockServer.client.getContestEffect(i) },
    )
  }

  @Test
  fun bulkSuperContestEffect() = runTest {
    testEach(
      { o, l -> MockServer.client.getSuperContestEffectList(o, l) },
      { i -> MockServer.client.getSuperContestEffect(i) },
    )
  }

  @Test
  fun bulkEncounterMethod() = runTest {
    testEach(
      { o, l -> MockServer.client.getEncounterMethodList(o, l) },
      { i -> MockServer.client.getEncounterMethod(i) },
    )
  }

  @Test
  fun bulkEncounterCondition() = runTest {
    testEach(
      { o, l -> MockServer.client.getEncounterConditionList(o, l) },
      { i -> MockServer.client.getEncounterCondition(i) },
    )
  }

  @Test
  fun bulkEncounterConditionValue() = runTest {
    testEach(
      { o, l -> MockServer.client.getEncounterConditionValueList(o, l) },
      { i -> MockServer.client.getEncounterConditionValue(i) },
    )
  }

  @Test
  fun bulkEvolutionChain() = runTest {
    testEach(
      { o, l -> MockServer.client.getEvolutionChainList(o, l) },
      { i -> MockServer.client.getEvolutionChain(i) },
    )
  }

  @Test
  fun bulkEvolutionTrigger() = runTest {
    testEach(
      { o, l -> MockServer.client.getEvolutionTriggerList(o, l) },
      { i -> MockServer.client.getEvolutionTrigger(i) },
    )
  }

  @Test
  fun bulkGeneration() = runTest {
    testEach(
      { o, l -> MockServer.client.getGenerationList(o, l) },
      { i -> MockServer.client.getGeneration(i) },
    )
  }

  @Test
  fun bulkPokedex() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokedexList(o, l) },
      { i -> MockServer.client.getPokedex(i) },
    )
  }

  @Test
  fun bulkVersion() = runTest {
    testEach(
      { o, l -> MockServer.client.getVersionList(o, l) },
      { i -> MockServer.client.getVersion(i) },
    )
  }

  @Test
  fun bulkVersionGroup() = runTest {
    testEach(
      { o, l -> MockServer.client.getVersionGroupList(o, l) },
      { i -> MockServer.client.getVersionGroup(i) },
    )
  }

  @Test
  fun bulkItem() = runTest {
    testEach({ o, l -> MockServer.client.getItemList(o, l) }, { i -> MockServer.client.getItem(i) })
  }

  @Test
  fun bulkItemAttribute() = runTest {
    testEach(
      { o, l -> MockServer.client.getItemAttributeList(o, l) },
      { i -> MockServer.client.getItemAttribute(i) },
    )
  }

  @Test
  fun bulkItemCategory() = runTest {
    testEach(
      { o, l -> MockServer.client.getItemCategoryList(o, l) },
      { i -> MockServer.client.getItemCategory(i) },
    )
  }

  @Test
  fun bulkItemFlingEffect() = runTest {
    testEach(
      { o, l -> MockServer.client.getItemFlingEffectList(o, l) },
      { i -> MockServer.client.getItemFlingEffect(i) },
    )
  }

  @Test
  fun bulkItemPocket() = runTest {
    testEach(
      { o, l -> MockServer.client.getItemPocketList(o, l) },
      { i -> MockServer.client.getItemPocket(i) },
    )
  }

  @Test
  fun bulkMove() = runTest {
    testEach({ o, l -> MockServer.client.getMoveList(o, l) }, { i -> MockServer.client.getMove(i) })
  }

  @Test
  fun bulkMoveAilment() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveAilmentList(o, l) },
      { i -> MockServer.client.getMoveAilment(i) },
    )
  }

  @Test
  fun bulkMoveBattleStyle() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveBattleStyleList(o, l) },
      { i -> MockServer.client.getMoveBattleStyle(i) },
    )
  }

  @Test
  fun bulkMoveCategory() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveCategoryList(o, l) },
      { i -> MockServer.client.getMoveCategory(i) },
    )
  }

  @Test
  fun bulkMoveDamageClass() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveDamageClassList(o, l) },
      { i -> MockServer.client.getMoveDamageClass(i) },
    )
  }

  @Test
  fun bulkMoveLearnMethod() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveLearnMethodList(o, l) },
      { i -> MockServer.client.getMoveLearnMethod(i) },
    )
  }

  @Test
  fun bulkMoveTarget() = runTest {
    testEach(
      { o, l -> MockServer.client.getMoveTargetList(o, l) },
      { i -> MockServer.client.getMoveTarget(i) },
    )
  }

  @Test
  fun bulkLocation() = runTest {
    testEach(
      { o, l -> MockServer.client.getLocationList(o, l) },
      { i -> MockServer.client.getLocation(i) },
    )
  }

  @Test
  fun bulkLocationArea() = runTest {
    testEach(
      { o, l -> MockServer.client.getLocationAreaList(o, l) },
      { i -> MockServer.client.getLocationArea(i) },
    )
  }

  @Test
  fun bulkPalParkArea() = runTest {
    testEach(
      { o, l -> MockServer.client.getPalParkAreaList(o, l) },
      { i -> MockServer.client.getPalParkArea(i) },
    )
  }

  @Test
  fun bulkRegion() = runTest {
    testEach(
      { o, l -> MockServer.client.getRegionList(o, l) },
      { i -> MockServer.client.getRegion(i) },
    )
  }

  @Test
  fun bulkMachine() = runTest {
    testEach(
      { o, l -> MockServer.client.getMachineList(o, l) },
      { i -> MockServer.client.getMachine(i) },
    )
  }

  @Test
  fun bulkAbility() = runTest {
    testEach(
      { o, l -> MockServer.client.getAbilityList(o, l) },
      { i -> MockServer.client.getAbility(i) },
    )
  }

  @Test
  fun bulkCharacteristic() = runTest {
    testEach(
      { o, l -> MockServer.client.getCharacteristicList(o, l) },
      { i -> MockServer.client.getCharacteristic(i) },
    )
  }

  @Test
  fun bulkEggGroup() = runTest {
    testEach(
      { o, l -> MockServer.client.getEggGroupList(o, l) },
      { i -> MockServer.client.getEggGroup(i) },
    )
  }

  @Test
  fun bulkGender() = runTest {
    testEach(
      { o, l -> MockServer.client.getGenderList(o, l) },
      { i -> MockServer.client.getGender(i) },
    )
  }

  @Test
  fun bulkGrowthRate() = runTest {
    testEach(
      { o, l -> MockServer.client.getGrowthRateList(o, l) },
      { i -> MockServer.client.getGrowthRate(i) },
    )
  }

  @Test
  fun bulkNature() = runTest {
    testEach(
      { o, l -> MockServer.client.getNatureList(o, l) },
      { i -> MockServer.client.getNature(i) },
    )
  }

  @Test
  fun bulkPokeathlonStat() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokeathlonStatList(o, l) },
      { i -> MockServer.client.getPokeathlonStat(i) },
    )
  }

  @Test
  fun bulkPokemon() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonList(o, l) },
      { i -> MockServer.client.getPokemon(i) },
    )
  }

  @Test
  fun bulkPokemonEncounters() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonList(o, l) },
      { i -> MockServer.client.getPokemonEncounterList(i) },
    )
  }

  @Test
  fun bulkPokemonColor() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonColorList(o, l) },
      { i -> MockServer.client.getPokemonColor(i) },
    )
  }

  @Test
  fun bulkPokemonForm() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonFormList(o, l) },
      { i -> MockServer.client.getPokemonForm(i) },
    )
  }

  @Test
  fun bulkPokemonHabitat() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonHabitatList(o, l) },
      { i -> MockServer.client.getPokemonHabitat(i) },
    )
  }

  @Test
  fun bulkPokemonShape() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonShapeList(o, l) },
      { i -> MockServer.client.getPokemonShape(i) },
    )
  }

  @Test
  fun bulkPokemonSpecies() = runTest {
    testEach(
      { o, l -> MockServer.client.getPokemonSpeciesList(o, l) },
      { i -> MockServer.client.getPokemonSpecies(i) },
    )
  }

  @Test
  fun bulkStat() = runTest {
    testEach({ o, l -> MockServer.client.getStatList(o, l) }, { i -> MockServer.client.getStat(i) })
  }

  @Test
  fun bulkType() = runTest {
    testEach({ o, l -> MockServer.client.getTypeList(o, l) }, { i -> MockServer.client.getType(i) })
  }

  @Test
  fun bulkLanguage() = runTest {
    testEach(
      { o, l -> MockServer.client.getLanguageList(o, l) },
      { i -> MockServer.client.getLanguage(i) },
    )
  }
}
