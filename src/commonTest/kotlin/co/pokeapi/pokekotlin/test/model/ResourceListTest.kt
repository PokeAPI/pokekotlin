package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.Model
import co.pokeapi.pokekotlin.model.NamedModel
import co.pokeapi.pokekotlin.model.PaginatedList
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.*
import kotlinx.coroutines.test.runTest

class ResourceListTest {

  val pageSize = 50

  private suspend inline fun <reified T : NamedModel> testCase(
    id: Int,
    name: String,
    call: suspend () -> PaginatedList.Named<T>,
  ) {
    call().apply {
      assertTrue(results.size <= pageSize, "Actual count: ${results.size}, pageSize: $pageSize")
      if (pageSize >= count) {
        assertEquals(count, results.size)
        assertEquals(null, next)
      } else {
        assertEquals(pageSize, results.size)
        assertNotEquals(null, next)
      }

      results.forEach {
        assertNotEquals("", it.name)
        assertNotNull(it.id)
      }

      assertContains(results, Handle.of(id, name))
    }
  }

  private suspend inline fun <reified T : Model> testCase(
    id: Int,
    call: suspend () -> PaginatedList.Unnamed<T>,
  ) {
    call().apply {
      assertTrue(results.size <= pageSize)
      if (pageSize >= count) {
        assertEquals(count, results.size)
        assertEquals(null, next)
      } else {
        assertEquals(pageSize, results.size)
        assertNotEquals(null, next)
      }

      results.forEach { assertNotNull(it.id) }

      assertContains(results, Handle.of<T>(id))
    }
  }

  @Test
  fun getBerryList() = runTest { testCase(4, "rawst") { LocalPokeApi.getBerryList(0, pageSize) } }

  @Test
  fun getBerryFirmnessList() = runTest {
    testCase(4, "very-hard") { LocalPokeApi.getBerryFirmnessList(0, pageSize) }
  }

  @Test
  fun getBerryFlavorList() = runTest {
    testCase(4, "bitter") { LocalPokeApi.getBerryFlavorList(0, pageSize) }
  }

  @Test
  fun getContestTypeList() = runTest {
    testCase(4, "smart") { LocalPokeApi.getContestTypeList(0, pageSize) }
  }

  @Test
  fun getContestEffectList() = runTest {
    testCase(4) { LocalPokeApi.getContestEffectList(0, pageSize) }
  }

  @Test
  fun getSuperContestEffectList() = runTest {
    testCase(2) { LocalPokeApi.getSuperContestEffectList(0, pageSize) }
  }

  @Test
  fun getEncounterMethodList() = runTest {
    testCase(5, "surf") { LocalPokeApi.getEncounterMethodList(0, pageSize) }
  }

  @Test
  fun getEncounterConditionList() = runTest {
    testCase(3, "radar") { LocalPokeApi.getEncounterConditionList(0, pageSize) }
  }

  @Test
  fun getEncounterConditionValueList() = runTest {
    testCase(4, "time-day") { LocalPokeApi.getEncounterConditionValueList(0, pageSize) }
  }

  @Test
  fun getEvolutionChainList() = runTest {
    testCase(5) { LocalPokeApi.getEvolutionChainList(0, pageSize) }
  }

  @Test
  fun getEvolutionTriggerList() = runTest {
    testCase(2, "trade") { LocalPokeApi.getEvolutionTriggerList(0, pageSize) }
  }

  @Test
  fun getGenerationList() = runTest {
    testCase(3, "generation-iii") { LocalPokeApi.getGenerationList(0, pageSize) }
  }

  @Test
  fun getPokedexList() = runTest {
    testCase(2, "kanto") { LocalPokeApi.getPokedexList(0, pageSize) }
  }

  @Test
  fun getVersionList() = runTest {
    testCase(4, "gold") { LocalPokeApi.getVersionList(0, pageSize) }
  }

  @Test
  fun getVersionGroupList() = runTest {
    testCase(3, "gold-silver") { LocalPokeApi.getVersionGroupList(0, pageSize) }
  }

  @Test
  fun getItemList() = runTest {
    testCase(16, "cherish-ball") { LocalPokeApi.getItemList(0, pageSize) }
  }

  @Test
  fun getItemAttributeList() = runTest {
    testCase(2, "consumable") { LocalPokeApi.getItemAttributeList(0, pageSize) }
  }

  @Test
  fun getItemCategoryList() = runTest {
    testCase(2, "effort-drop") { LocalPokeApi.getItemCategoryList(0, pageSize) }
  }

  @Test
  fun getItemFlingEffectList() = runTest {
    testCase(4, "herb-effect") { LocalPokeApi.getItemFlingEffectList(0, pageSize) }
  }

  @Test
  fun getItemPocketList() = runTest {
    testCase(3, "pokeballs") { LocalPokeApi.getItemPocketList(0, pageSize) }
  }

  @Test
  fun getMoveList() = runTest {
    testCase(17, "wing-attack") { LocalPokeApi.getMoveList(0, pageSize) }
  }

  @Test
  fun getMoveAilmentList() = runTest {
    testCase(5, "poison") { LocalPokeApi.getMoveAilmentList(0, pageSize) }
  }

  @Test
  fun getMoveBattleStyleList() = runTest {
    testCase(2, "defense") { LocalPokeApi.getMoveBattleStyleList(0, pageSize) }
  }

  @Test
  fun getMoveCategoryList() = runTest {
    testCase(11, "field-effect") { LocalPokeApi.getMoveCategoryList(0, pageSize) }
  }

  @Test
  fun getMoveDamageClassList() = runTest {
    testCase(2, "physical") { LocalPokeApi.getMoveDamageClassList(0, pageSize) }
  }

  @Test
  fun getMoveLearnMethodList() = runTest {
    testCase(4, "machine") { LocalPokeApi.getMoveLearnMethodList(0, pageSize) }
  }

  @Test
  fun getMoveTargetList() = runTest {
    testCase(14, "all-pokemon") { LocalPokeApi.getMoveTargetList(0, pageSize) }
  }

  @Test
  fun getLocationList() = runTest {
    testCase(31, "sinnoh-route-201") { LocalPokeApi.getLocationList(0, pageSize) }
  }

  @Test
  fun getLocationAreaList() = runTest {
    testCase(34, "solaceon-ruins-b1f-c") { LocalPokeApi.getLocationAreaList(0, pageSize) }
  }

  @Test
  fun getPalParkAreaList() = runTest {
    testCase(3, "mountain") { LocalPokeApi.getPalParkAreaList(0, pageSize) }
  }

  @Test
  fun getRegionList() = runTest { testCase(1, "kanto") { LocalPokeApi.getRegionList(0, pageSize) } }

  @Test
  fun getAbilityList() = runTest {
    testCase(5, "sturdy") { LocalPokeApi.getAbilityList(0, pageSize) }
  }

  @Test
  fun getCharacteristicList() = runTest {
    testCase(4) { LocalPokeApi.getCharacteristicList(0, pageSize) }
  }

  @Test
  fun getEggGroupList() = runTest {
    testCase(1, "monster") { LocalPokeApi.getEggGroupList(0, pageSize) }
  }

  @Test
  fun getGenderList() = runTest { testCase(2, "male") { LocalPokeApi.getGenderList(0, pageSize) } }

  @Test
  fun getGrowthRateList() = runTest {
    testCase(3, "fast") { LocalPokeApi.getGrowthRateList(0, pageSize) }
  }

  @Test
  fun getNatureList() = runTest { testCase(5, "timid") { LocalPokeApi.getNatureList(0, pageSize) } }

  @Test
  fun getPokeathlonStatList() = runTest {
    testCase(5, "jump") { LocalPokeApi.getPokeathlonStatList(0, pageSize) }
  }

  @Test
  fun getPokemonList() = runTest {
    testCase(3, "venusaur") { LocalPokeApi.getPokemonVarietyList(0, pageSize) }
  }

  @Test
  fun getPokemonColorList() = runTest {
    testCase(8, "red") { LocalPokeApi.getPokemonColorList(0, pageSize) }
  }

  @Test
  fun getPokemonFormList() = runTest {
    testCase(18, "pidgeot") { LocalPokeApi.getPokemonFormList(0, pageSize) }
  }

  @Test
  fun getPokemonHabitatList() = runTest {
    testCase(8, "urban") { LocalPokeApi.getPokemonHabitatList(0, pageSize) }
  }

  @Test
  fun getPokemonShapeList() = runTest {
    testCase(13, "bug-wings") { LocalPokeApi.getPokemonShapeList(0, pageSize) }
  }

  @Test
  fun getPokemonSpeciesList() = runTest {
    testCase(20, "raticate") { LocalPokeApi.getPokemonSpeciesList(0, pageSize) }
  }

  @Test
  fun getPokemonStatList() = runTest {
    testCase(6, "speed") { LocalPokeApi.getStatList(0, pageSize) }
  }

  @Test
  fun getPokemonTypeList() = runTest {
    testCase(18, "fairy") { LocalPokeApi.getTypeList(0, pageSize) }
  }

  @Test
  fun getLanguageList() = runTest {
    testCase(9, "en") { LocalPokeApi.getLanguageList(0, pageSize) }
  }
}
