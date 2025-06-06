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
      println("$cat ${i + 1}/$count (id=$id)")
      try {
        getObject(id)
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
    testEach({ o, l -> StaticPokeApi.getBerryList(o, l) }, { i -> StaticPokeApi.getBerry(i) })
  }

  @Test
  fun bulkBerryFirmness() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getBerryFirmnessList(o, l) },
      { i -> StaticPokeApi.getBerryFirmness(i) },
    )
  }

  @Test
  fun bulkBerryFlavor() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getBerryFlavorList(o, l) },
      { i -> StaticPokeApi.getBerryFlavor(i) },
    )
  }

  @Test
  fun bulkContestType() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getContestTypeList(o, l) },
      { i -> StaticPokeApi.getContestType(i) },
    )
  }

  @Test
  fun bulkContestEffect() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getContestEffectList(o, l) },
      { i -> StaticPokeApi.getContestEffect(i) },
    )
  }

  @Test
  fun bulkSuperContestEffect() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getSuperContestEffectList(o, l) },
      { i -> StaticPokeApi.getSuperContestEffect(i) },
    )
  }

  @Test
  fun bulkEncounterMethod() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getEncounterMethodList(o, l) },
      { i -> StaticPokeApi.getEncounterMethod(i) },
    )
  }

  @Test
  fun bulkEncounterCondition() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getEncounterConditionList(o, l) },
      { i -> StaticPokeApi.getEncounterCondition(i) },
    )
  }

  @Test
  fun bulkEncounterConditionValue() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getEncounterConditionValueList(o, l) },
      { i -> StaticPokeApi.getEncounterConditionValue(i) },
    )
  }

  @Test
  fun bulkEvolutionChain() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getEvolutionChainList(o, l) },
      { i -> StaticPokeApi.getEvolutionChain(i) },
    )
  }

  @Test
  fun bulkEvolutionTrigger() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getEvolutionTriggerList(o, l) },
      { i -> StaticPokeApi.getEvolutionTrigger(i) },
    )
  }

  @Test
  fun bulkGeneration() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getGenerationList(o, l) },
      { i -> StaticPokeApi.getGeneration(i) },
    )
  }

  @Test
  fun bulkPokedex() = runTest {
    testEach({ o, l -> StaticPokeApi.getPokedexList(o, l) }, { i -> StaticPokeApi.getPokedex(i) })
  }

  @Test
  fun bulkVersion() = runTest {
    testEach({ o, l -> StaticPokeApi.getVersionList(o, l) }, { i -> StaticPokeApi.getVersion(i) })
  }

  @Test
  fun bulkVersionGroup() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getVersionGroupList(o, l) },
      { i -> StaticPokeApi.getVersionGroup(i) },
    )
  }

  @Test
  fun bulkItem() = runTest {
    testEach({ o, l -> StaticPokeApi.getItemList(o, l) }, { i -> StaticPokeApi.getItem(i) })
  }

  @Test
  fun bulkItemAttribute() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getItemAttributeList(o, l) },
      { i -> StaticPokeApi.getItemAttribute(i) },
    )
  }

  @Test
  fun bulkItemCategory() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getItemCategoryList(o, l) },
      { i -> StaticPokeApi.getItemCategory(i) },
    )
  }

  @Test
  fun bulkItemFlingEffect() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getItemFlingEffectList(o, l) },
      { i -> StaticPokeApi.getItemFlingEffect(i) },
    )
  }

  @Test
  fun bulkItemPocket() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getItemPocketList(o, l) },
      { i -> StaticPokeApi.getItemPocket(i) },
    )
  }

  @Test
  fun bulkMove() = runTest {
    testEach({ o, l -> StaticPokeApi.getMoveList(o, l) }, { i -> StaticPokeApi.getMove(i) })
  }

  @Test
  fun bulkMoveAilment() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveAilmentList(o, l) },
      { i -> StaticPokeApi.getMoveAilment(i) },
    )
  }

  @Test
  fun bulkMoveBattleStyle() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveBattleStyleList(o, l) },
      { i -> StaticPokeApi.getMoveBattleStyle(i) },
    )
  }

  @Test
  fun bulkMoveCategory() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveCategoryList(o, l) },
      { i -> StaticPokeApi.getMoveCategory(i) },
    )
  }

  @Test
  fun bulkMoveDamageClass() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveDamageClassList(o, l) },
      { i -> StaticPokeApi.getMoveDamageClass(i) },
    )
  }

  @Test
  fun bulkMoveLearnMethod() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveLearnMethodList(o, l) },
      { i -> StaticPokeApi.getMoveLearnMethod(i) },
    )
  }

  @Test
  fun bulkMoveTarget() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getMoveTargetList(o, l) },
      { i -> StaticPokeApi.getMoveTarget(i) },
    )
  }

  @Test
  fun bulkLocation() = runTest {
    testEach({ o, l -> StaticPokeApi.getLocationList(o, l) }, { i -> StaticPokeApi.getLocation(i) })
  }

  @Test
  fun bulkLocationArea() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getLocationAreaList(o, l) },
      { i -> StaticPokeApi.getLocationArea(i) },
    )
  }

  @Test
  fun bulkPalParkArea() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPalParkAreaList(o, l) },
      { i -> StaticPokeApi.getPalParkArea(i) },
    )
  }

  @Test
  fun bulkRegion() = runTest {
    testEach({ o, l -> StaticPokeApi.getRegionList(o, l) }, { i -> StaticPokeApi.getRegion(i) })
  }

  @Test
  fun bulkMachine() = runTest {
    testEach({ o, l -> StaticPokeApi.getMachineList(o, l) }, { i -> StaticPokeApi.getMachine(i) })
  }

  @Test
  fun bulkAbility() = runTest {
    testEach({ o, l -> StaticPokeApi.getAbilityList(o, l) }, { i -> StaticPokeApi.getAbility(i) })
  }

  @Test
  fun bulkCharacteristic() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getCharacteristicList(o, l) },
      { i -> StaticPokeApi.getCharacteristic(i) },
    )
  }

  @Test
  fun bulkEggGroup() = runTest {
    testEach({ o, l -> StaticPokeApi.getEggGroupList(o, l) }, { i -> StaticPokeApi.getEggGroup(i) })
  }

  @Test
  fun bulkGender() = runTest {
    testEach({ o, l -> StaticPokeApi.getGenderList(o, l) }, { i -> StaticPokeApi.getGender(i) })
  }

  @Test
  fun bulkGrowthRate() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getGrowthRateList(o, l) },
      { i -> StaticPokeApi.getGrowthRate(i) },
    )
  }

  @Test
  fun bulkNature() = runTest {
    testEach({ o, l -> StaticPokeApi.getNatureList(o, l) }, { i -> StaticPokeApi.getNature(i) })
  }

  @Test
  fun bulkPokeathlonStat() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokeathlonStatList(o, l) },
      { i -> StaticPokeApi.getPokeathlonStat(i) },
    )
  }

  @Test
  fun bulkPokemon() = runTest {
    testEach({ o, l -> StaticPokeApi.getPokemonList(o, l) }, { i -> StaticPokeApi.getPokemon(i) })
  }

  @Test
  fun bulkPokemonEncounters() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonList(o, l) },
      { i -> StaticPokeApi.getPokemonEncounterList(i) },
    )
  }

  @Test
  fun bulkPokemonColor() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonColorList(o, l) },
      { i -> StaticPokeApi.getPokemonColor(i) },
    )
  }

  @Test
  fun bulkPokemonForm() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonFormList(o, l) },
      { i -> StaticPokeApi.getPokemonForm(i) },
    )
  }

  @Test
  fun bulkPokemonHabitat() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonHabitatList(o, l) },
      { i -> StaticPokeApi.getPokemonHabitat(i) },
    )
  }

  @Test
  fun bulkPokemonShape() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonShapeList(o, l) },
      { i -> StaticPokeApi.getPokemonShape(i) },
    )
  }

  @Test
  fun bulkPokemonSpecies() = runTest {
    testEach(
      { o, l -> StaticPokeApi.getPokemonSpeciesList(o, l) },
      { i -> StaticPokeApi.getPokemonSpecies(i) },
    )
  }

  @Test
  fun bulkStat() = runTest {
    testEach({ o, l -> StaticPokeApi.getStatList(o, l) }, { i -> StaticPokeApi.getStat(i) })
  }

  @Test
  fun bulkType() = runTest {
    testEach({ o, l -> StaticPokeApi.getTypeList(o, l) }, { i -> StaticPokeApi.getType(i) })
  }

  @Test
  fun bulkLanguage() = runTest {
    testEach({ o, l -> StaticPokeApi.getLanguageList(o, l) }, { i -> StaticPokeApi.getLanguage(i) })
  }
}
