package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.ApiResource
import me.sargunvohra.lib.pokekotlin.json.ApiResourceList
import me.sargunvohra.lib.pokekotlin.json.NamedApiResource
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
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
            TestClient.getBerryList(0, pageSize)
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness", 4, "very-hard") {
            TestClient.getBerryFirmnessList(0, pageSize)
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor", 4, "bitter") {
            TestClient.getBerryFlavorList(0, pageSize)
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type", 4, "smart") {
            TestClient.getContestTypeList(0, pageSize)
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect", 4) {
            TestClient.getContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect", 2) {
            TestClient.getSuperContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method", 5, "surf") {
            TestClient.getEncounterMethodList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition", 3, "radar") {
            TestClient.getEncounterConditionList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value", 4, "time-day") {
            TestClient.getEncounterConditionValueList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain", 5) {
            TestClient.getEvolutionChainList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger", 2, "trade") {
            TestClient.getEvolutionTriggerList(0, pageSize)
        }
    }

    @Test
    fun getGenerationList() {
        test("generation", 3, "generation-iii") {
            TestClient.getGenerationList(0, pageSize)
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex", 2, "kanto") {
            TestClient.getPokedexList(0, pageSize)
        }
    }

    @Test
    fun getVersionList() {
        test("version", 4, "gold") {
            TestClient.getVersionList(0, pageSize)
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group", 3, "gold-silver") {
            TestClient.getVersionGroupList(0, pageSize)
        }
    }

    @Test
    fun getItemList() {
        test("item", 16, "cherish-ball") {
            TestClient.getItemList(0, pageSize)
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute", 2, "consumable") {
            TestClient.getItemAttributeList(0, pageSize)
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category", 2, "effort-drop") {
            TestClient.getItemCategoryList(0, pageSize)
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect", 4, "herb-effect") {
            TestClient.getItemFlingEffectList(0, pageSize)
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket", 3, "pokeballs") {
            TestClient.getItemPocketList(0, pageSize)
        }
    }

    @Test
    fun getMoveList() {
        test("move", 481, "flame-burst") {
            TestClient.getMoveList(450, pageSize)
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment", 5, "poison") {
            TestClient.getMoveAilmentList(0, pageSize)
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style", 2, "defense") {
            TestClient.getMoveBattleStyleList(0, pageSize)
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category", 11, "field-effect") {
            TestClient.getMoveCategoryList(0, pageSize)
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class", 2, "physical") {
            TestClient.getMoveDamageClassList(0, pageSize)
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method", 4, "machine") {
            TestClient.getMoveLearnMethodList(0, pageSize)
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target", 14, "all-pokemon") {
            TestClient.getMoveTargetList(0, pageSize)
        }
    }

    @Test
    fun getLocationList() {
        test("location", 31, "sinnoh-route-201") {
            TestClient.getLocationList(0, pageSize)
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area", 34, "solaceon-ruins-b1f-c") {
            TestClient.getLocationAreaList(0, pageSize)
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area", 3, "mountain") {
            TestClient.getPalParkAreaList(0, pageSize)
        }
    }

    @Test
    fun getRegionList() {
        test("region", 1, "kanto") {
            TestClient.getRegionList(0, pageSize)
        }
    }

    @Test
    fun getAbilityList() {
        test("ability", 5, "sturdy") {
            TestClient.getAbilityList(0, pageSize)
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic", 4) {
            TestClient.getCharacteristicList(0, pageSize)
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group", 1, "monster") {
            TestClient.getEggGroupList(0, pageSize)
        }
    }

    @Test
    fun getGenderList() {
        test("gender", 2, "male") {
            TestClient.getGenderList(0, pageSize)
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate", 3, "fast") {
            TestClient.getGrowthRateList(0, pageSize)
        }
    }

    @Test
    fun getNatureList() {
        test("nature", 5, "timid") {
            TestClient.getNatureList(0, pageSize)
        }
    }

    @Test
    fun getPokeathlonStatList() {
        test("pokeathlon-stat", 5, "jump") {
            TestClient.getPokeathlonStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon", 3, "venusaur") {
            TestClient.getPokemonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color", 8, "red") {
            TestClient.getPokemonColorList(0, pageSize)
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form", 18, "pidgeot") {
            TestClient.getPokemonFormList(0, pageSize)
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat", 8, "urban") {
            TestClient.getPokemonHabitatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape", 13, "bug-wings") {
            TestClient.getPokemonShapeList(0, pageSize)
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species", 179, "mareep") {
            TestClient.getPokemonSpeciesList(150, pageSize)
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat", 6, "speed") {
            TestClient.getStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type", 18, "fairy") {
            TestClient.getTypeList(0, pageSize)
        }
    }

    @Test
    fun getLanguageList() {
        test("language", 9, "en") {
            TestClient.getLanguageList(0, pageSize)
        }
    }
}