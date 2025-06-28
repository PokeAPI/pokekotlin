package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.ApiResource
import co.pokeapi.pokekotlin.model.ApiResourceList
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.model.NamedApiResourceList
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.*
import kotlinx.coroutines.test.runTest

class ResourceListTest {

  val pageSize = 50

  private suspend fun testCase(
    category: String,
    id: Int,
    name: String,
    call: suspend () -> NamedApiResourceList,
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
        assertNotEquals("", it.category)
        it.id
      }

      assertContains(results, NamedApiResource(name, category, id))
    }
  }

  private suspend fun testCase(category: String, id: Int, call: suspend () -> ApiResourceList) {
    call().apply {
      assertTrue(results.size <= pageSize)
      if (pageSize >= count) {
        assertEquals(count, results.size)
        assertEquals(null, next)
      } else {
        assertEquals(pageSize, results.size)
        assertNotEquals(null, next)
      }

      results.forEach {
        assertNotEquals("", it.category)
        it.id
      }

      assertContains(results, ApiResource(category, id))
    }
  }

  @Test
  fun getBerryList() = runTest {
    testCase("berry", 4, "rawst") { LocalPokeApi.getBerryList(0, pageSize) }
  }

  @Test
  fun getBerryFirmnessList() = runTest {
    testCase("berry-firmness", 4, "very-hard") { LocalPokeApi.getBerryFirmnessList(0, pageSize) }
  }

  @Test
  fun getBerryFlavorList() = runTest {
    testCase("berry-flavor", 4, "bitter") { LocalPokeApi.getBerryFlavorList(0, pageSize) }
  }

  @Test
  fun getContestTypeList() = runTest {
    testCase("contest-type", 4, "smart") { LocalPokeApi.getContestTypeList(0, pageSize) }
  }

  @Test
  fun getContestEffectList() = runTest {
    testCase("contest-effect", 4) { LocalPokeApi.getContestEffectList(0, pageSize) }
  }

  @Test
  fun getSuperContestEffectList() = runTest {
    testCase("super-contest-effect", 2) { LocalPokeApi.getSuperContestEffectList(0, pageSize) }
  }

  @Test
  fun getEncounterMethodList() = runTest {
    testCase("encounter-method", 5, "surf") { LocalPokeApi.getEncounterMethodList(0, pageSize) }
  }

  @Test
  fun getEncounterConditionList() = runTest {
    testCase("encounter-condition", 3, "radar") {
      LocalPokeApi.getEncounterConditionList(0, pageSize)
    }
  }

  @Test
  fun getEncounterConditionValueList() = runTest {
    testCase("encounter-condition-value", 4, "time-day") {
      LocalPokeApi.getEncounterConditionValueList(0, pageSize)
    }
  }

  @Test
  fun getEvolutionChainList() = runTest {
    testCase("evolution-chain", 5) { LocalPokeApi.getEvolutionChainList(0, pageSize) }
  }

  @Test
  fun getEvolutionTriggerList() = runTest {
    testCase("evolution-trigger", 2, "trade") { LocalPokeApi.getEvolutionTriggerList(0, pageSize) }
  }

  @Test
  fun getGenerationList() = runTest {
    testCase("generation", 3, "generation-iii") { LocalPokeApi.getGenerationList(0, pageSize) }
  }

  @Test
  fun getPokedexList() = runTest {
    testCase("pokedex", 2, "kanto") { LocalPokeApi.getPokedexList(0, pageSize) }
  }

  @Test
  fun getVersionList() = runTest {
    testCase("version", 4, "gold") { LocalPokeApi.getVersionList(0, pageSize) }
  }

  @Test
  fun getVersionGroupList() = runTest {
    testCase("version-group", 3, "gold-silver") { LocalPokeApi.getVersionGroupList(0, pageSize) }
  }

  @Test
  fun getItemList() = runTest {
    testCase("item", 16, "cherish-ball") { LocalPokeApi.getItemList(0, pageSize) }
  }

  @Test
  fun getItemAttributeList() = runTest {
    testCase("item-attribute", 2, "consumable") { LocalPokeApi.getItemAttributeList(0, pageSize) }
  }

  @Test
  fun getItemCategoryList() = runTest {
    testCase("item-category", 2, "effort-drop") { LocalPokeApi.getItemCategoryList(0, pageSize) }
  }

  @Test
  fun getItemFlingEffectList() = runTest {
    testCase("item-fling-effect", 4, "herb-effect") {
      LocalPokeApi.getItemFlingEffectList(0, pageSize)
    }
  }

  @Test
  fun getItemPocketList() = runTest {
    testCase("item-pocket", 3, "pokeballs") { LocalPokeApi.getItemPocketList(0, pageSize) }
  }

  @Test
  fun getMoveList() = runTest {
    testCase("move", 17, "wing-attack") { LocalPokeApi.getMoveList(0, pageSize) }
  }

  @Test
  fun getMoveAilmentList() = runTest {
    testCase("move-ailment", 5, "poison") { LocalPokeApi.getMoveAilmentList(0, pageSize) }
  }

  @Test
  fun getMoveBattleStyleList() = runTest {
    testCase("move-battle-style", 2, "defense") { LocalPokeApi.getMoveBattleStyleList(0, pageSize) }
  }

  @Test
  fun getMoveCategoryList() = runTest {
    testCase("move-category", 11, "field-effect") { LocalPokeApi.getMoveCategoryList(0, pageSize) }
  }

  @Test
  fun getMoveDamageClassList() = runTest {
    testCase("move-damage-class", 2, "physical") {
      LocalPokeApi.getMoveDamageClassList(0, pageSize)
    }
  }

  @Test
  fun getMoveLearnMethodList() = runTest {
    testCase("move-learn-method", 4, "machine") { LocalPokeApi.getMoveLearnMethodList(0, pageSize) }
  }

  @Test
  fun getMoveTargetList() = runTest {
    testCase("move-target", 14, "all-pokemon") { LocalPokeApi.getMoveTargetList(0, pageSize) }
  }

  @Test
  fun getLocationList() = runTest {
    testCase("location", 31, "sinnoh-route-201") { LocalPokeApi.getLocationList(0, pageSize) }
  }

  @Test
  fun getLocationAreaList() = runTest {
    testCase("location-area", 34, "solaceon-ruins-b1f-c") {
      LocalPokeApi.getLocationAreaList(0, pageSize)
    }
  }

  @Test
  fun getPalParkAreaList() = runTest {
    testCase("pal-park-area", 3, "mountain") { LocalPokeApi.getPalParkAreaList(0, pageSize) }
  }

  @Test
  fun getRegionList() = runTest {
    testCase("region", 1, "kanto") { LocalPokeApi.getRegionList(0, pageSize) }
  }

  @Test
  fun getAbilityList() = runTest {
    testCase("ability", 5, "sturdy") { LocalPokeApi.getAbilityList(0, pageSize) }
  }

  @Test
  fun getCharacteristicList() = runTest {
    testCase("characteristic", 4) { LocalPokeApi.getCharacteristicList(0, pageSize) }
  }

  @Test
  fun getEggGroupList() = runTest {
    testCase("egg-group", 1, "monster") { LocalPokeApi.getEggGroupList(0, pageSize) }
  }

  @Test
  fun getGenderList() = runTest {
    testCase("gender", 2, "male") { LocalPokeApi.getGenderList(0, pageSize) }
  }

  @Test
  fun getGrowthRateList() = runTest {
    testCase("growth-rate", 3, "fast") { LocalPokeApi.getGrowthRateList(0, pageSize) }
  }

  @Test
  fun getNatureList() = runTest {
    testCase("nature", 5, "timid") { LocalPokeApi.getNatureList(0, pageSize) }
  }

  @Test
  fun getPokeathlonStatList() = runTest {
    testCase("pokeathlon-stat", 5, "jump") { LocalPokeApi.getPokeathlonStatList(0, pageSize) }
  }

  @Test
  fun getPokemonList() = runTest {
    testCase("pokemon", 3, "venusaur") { LocalPokeApi.getPokemonList(0, pageSize) }
  }

  @Test
  fun getPokemonColorList() = runTest {
    testCase("pokemon-color", 8, "red") { LocalPokeApi.getPokemonColorList(0, pageSize) }
  }

  @Test
  fun getPokemonFormList() = runTest {
    testCase("pokemon-form", 18, "pidgeot") { LocalPokeApi.getPokemonFormList(0, pageSize) }
  }

  @Test
  fun getPokemonHabitatList() = runTest {
    testCase("pokemon-habitat", 8, "urban") { LocalPokeApi.getPokemonHabitatList(0, pageSize) }
  }

  @Test
  fun getPokemonShapeList() = runTest {
    testCase("pokemon-shape", 13, "bug-wings") { LocalPokeApi.getPokemonShapeList(0, pageSize) }
  }

  @Test
  fun getPokemonSpeciesList() = runTest {
    testCase("pokemon-species", 20, "raticate") { LocalPokeApi.getPokemonSpeciesList(0, pageSize) }
  }

  @Test
  fun getPokemonStatList() = runTest {
    testCase("stat", 6, "speed") { LocalPokeApi.getStatList(0, pageSize) }
  }

  @Test
  fun getPokemonTypeList() = runTest {
    testCase("type", 18, "fairy") { LocalPokeApi.getTypeList(0, pageSize) }
  }

  @Test
  fun getLanguageList() = runTest {
    testCase("language", 9, "en") { LocalPokeApi.getLanguageList(0, pageSize) }
  }
}
