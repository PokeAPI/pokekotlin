package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.ApiResource
import me.sargunvohra.lib.pokekotlin.json.ApiResourceList
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ResourceListTest {

    final val pageSize = 50

    fun test(category: String, id: Int, name: String, call: () -> NamedApiResourceList) {
        call().apply {
            assert(results.count() <= pageSize)
            if (pageSize >= count) {
                assertEquals(count, results.count())
                assertEquals(null, next)
            } else {
                assertEquals(pageSize, results.count())
                assertNotEquals(null, next)
            }

            results.forEach {
                assert(it.name.isNotEmpty())
                assert(it.category.isNotEmpty())
                it.id
            }

            assert(NamedApiResource(name, category, id) in results)
        }
    }

    fun test(category: String, id: Int, call: () -> ApiResourceList) {
        call().apply {
            assert(results.count() <= pageSize)
            if (pageSize >= count) {
                assertEquals(count, results.count())
                assertEquals(null, next)
            } else {
                assertEquals(pageSize, results.count())
                assertNotEquals(null, next)
            }

            results.forEach {
                assert(it.category.isNotEmpty())
                it.id
            }

            assert(ApiResource(category, id) in results)
        }
    }

    @Test
    fun getBerryList() {
        test("berry", 4, "rawst") {
            MockClient.getBerryList(0, pageSize)
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness", 4, "very-hard") {
            MockClient.getBerryFirmnessList(0, pageSize)
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor", 4, "bitter") {
            MockClient.getBerryFlavorList(0, pageSize)
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type", 4, "smart") {
            MockClient.getContestTypeList(0, pageSize)
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect", 4) {
            MockClient.getContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect", 2) {
            MockClient.getSuperContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method", 5, "surf") {
            MockClient.getEncounterMethodList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition", 3, "radar") {
            MockClient.getEncounterConditionList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value", 4, "time-day") {
            MockClient.getEncounterConditionValueList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain", 5) {
            MockClient.getEvolutionChainList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger", 2, "trade") {
            MockClient.getEvolutionTriggerList(0, pageSize)
        }
    }

    @Test
    fun getGenerationList() {
        test("generation", 3, "generation-iii") {
            MockClient.getGenerationList(0, pageSize)
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex", 2, "kanto") {
            MockClient.getPokedexList(0, pageSize)
        }
    }

    @Test
    fun getVersionList() {
        test("version", 4, "gold") {
            MockClient.getVersionList(0, pageSize)
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group", 3, "gold-silver") {
            MockClient.getVersionGroupList(0, pageSize)
        }
    }

    @Test
    fun getItemList() {
        test("item", 16, "cherish-ball") {
            MockClient.getItemList(0, pageSize)
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute", 2, "consumable") {
            MockClient.getItemAttributeList(0, pageSize)
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category", 2, "effort-drop") {
            MockClient.getItemCategoryList(0, pageSize)
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect", 4, "herb-effect") {
            MockClient.getItemFlingEffectList(0, pageSize)
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket", 3, "pokeballs") {
            MockClient.getItemPocketList(0, pageSize)
        }
    }

    @Test
    fun getMoveList() {
        test("move", 17, "wing-attack") {
            MockClient.getMoveList(0, pageSize)
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment", 5, "poison") {
            MockClient.getMoveAilmentList(0, pageSize)
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style", 2, "defense") {
            MockClient.getMoveBattleStyleList(0, pageSize)
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category", 11, "field-effect") {
            MockClient.getMoveCategoryList(0, pageSize)
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class", 2, "physical") {
            MockClient.getMoveDamageClassList(0, pageSize)
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method", 4, "machine") {
            MockClient.getMoveLearnMethodList(0, pageSize)
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target", 14, "all-pokemon") {
            MockClient.getMoveTargetList(0, pageSize)
        }
    }

    @Test
    fun getLocationList() {
        test("location", 31, "sinnoh-route-201") {
            MockClient.getLocationList(0, pageSize)
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area", 34, "solaceon-ruins-b1f-c") {
            MockClient.getLocationAreaList(0, pageSize)
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area", 3, "mountain") {
            MockClient.getPalParkAreaList(0, pageSize)
        }
    }

    @Test
    fun getRegionList() {
        test("region", 1, "kanto") {
            MockClient.getRegionList(0, pageSize)
        }
    }

    @Test
    fun getAbilityList() {
        test("ability", 5, "sturdy") {
            MockClient.getAbilityList(0, pageSize)
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic", 4) {
            MockClient.getCharacteristicList(0, pageSize)
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group", 1, "monster") {
            MockClient.getEggGroupList(0, pageSize)
        }
    }

    @Test
    fun getGenderList() {
        test("gender", 2, "male") {
            MockClient.getGenderList(0, pageSize)
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate", 3, "fast") {
            MockClient.getGrowthRateList(0, pageSize)
        }
    }

    @Test
    fun getNatureList() {
        test("nature", 5, "timid") {
            MockClient.getNatureList(0, pageSize)
        }
    }

    @Test
    fun getPokeathlonStatList() {
        test("pokeathlon-stat", 5, "jump") {
            MockClient.getPokeathlonStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon", 3, "venusaur") {
            MockClient.getPokemonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color", 8, "red") {
            MockClient.getPokemonColorList(0, pageSize)
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form", 18, "pidgeot") {
            MockClient.getPokemonFormList(0, pageSize)
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat", 8, "urban") {
            MockClient.getPokemonHabitatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape", 13, "bug-wings") {
            MockClient.getPokemonShapeList(0, pageSize)
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species", 20, "raticate") {
            MockClient.getPokemonSpeciesList(0, pageSize)
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat", 6, "speed") {
            MockClient.getStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type", 18, "fairy") {
            MockClient.getTypeList(0, pageSize)
        }
    }

    @Test
    fun getLanguageList() {
        test("language", 9, "en") {
            MockClient.getLanguageList(0, pageSize)
        }
    }
}