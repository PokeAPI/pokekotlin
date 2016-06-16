package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.model.ApiResource
import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
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
            mockClient.getBerryList(0, pageSize)
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness", 4, "very-hard") {
            mockClient.getBerryFirmnessList(0, pageSize)
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor", 4, "bitter") {
            mockClient.getBerryFlavorList(0, pageSize)
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type", 4, "smart") {
            mockClient.getContestTypeList(0, pageSize)
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect", 4) {
            mockClient.getContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect", 2) {
            mockClient.getSuperContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method", 5, "surf") {
            mockClient.getEncounterMethodList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition", 3, "radar") {
            mockClient.getEncounterConditionList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value", 4, "time-day") {
            mockClient.getEncounterConditionValueList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain", 5) {
            mockClient.getEvolutionChainList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger", 2, "trade") {
            mockClient.getEvolutionTriggerList(0, pageSize)
        }
    }

    @Test
    fun getGenerationList() {
        test("generation", 3, "generation-iii") {
            mockClient.getGenerationList(0, pageSize)
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex", 2, "kanto") {
            mockClient.getPokedexList(0, pageSize)
        }
    }

    @Test
    fun getVersionList() {
        test("version", 4, "gold") {
            mockClient.getVersionList(0, pageSize)
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group", 3, "gold-silver") {
            mockClient.getVersionGroupList(0, pageSize)
        }
    }

    @Test
    fun getItemList() {
        test("item", 16, "cherish-ball") {
            mockClient.getItemList(0, pageSize)
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute", 2, "consumable") {
            mockClient.getItemAttributeList(0, pageSize)
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category", 2, "effort-drop") {
            mockClient.getItemCategoryList(0, pageSize)
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect", 4, "herb-effect") {
            mockClient.getItemFlingEffectList(0, pageSize)
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket", 3, "pokeballs") {
            mockClient.getItemPocketList(0, pageSize)
        }
    }

    @Test
    fun getMoveList() {
        test("move", 17, "wing-attack") {
            mockClient.getMoveList(0, pageSize)
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment", 5, "poison") {
            mockClient.getMoveAilmentList(0, pageSize)
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style", 2, "defense") {
            mockClient.getMoveBattleStyleList(0, pageSize)
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category", 11, "field-effect") {
            mockClient.getMoveCategoryList(0, pageSize)
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class", 2, "physical") {
            mockClient.getMoveDamageClassList(0, pageSize)
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method", 4, "machine") {
            mockClient.getMoveLearnMethodList(0, pageSize)
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target", 14, "all-pokemon") {
            mockClient.getMoveTargetList(0, pageSize)
        }
    }

    @Test
    fun getLocationList() {
        test("location", 31, "sinnoh-route-201") {
            mockClient.getLocationList(0, pageSize)
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area", 34, "solaceon-ruins-b1f-c") {
            mockClient.getLocationAreaList(0, pageSize)
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area", 3, "mountain") {
            mockClient.getPalParkAreaList(0, pageSize)
        }
    }

    @Test
    fun getRegionList() {
        test("region", 1, "kanto") {
            mockClient.getRegionList(0, pageSize)
        }
    }

    @Test
    fun getAbilityList() {
        test("ability", 5, "sturdy") {
            mockClient.getAbilityList(0, pageSize)
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic", 4) {
            mockClient.getCharacteristicList(0, pageSize)
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group", 1, "monster") {
            mockClient.getEggGroupList(0, pageSize)
        }
    }

    @Test
    fun getGenderList() {
        test("gender", 2, "male") {
            mockClient.getGenderList(0, pageSize)
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate", 3, "fast") {
            mockClient.getGrowthRateList(0, pageSize)
        }
    }

    @Test
    fun getNatureList() {
        test("nature", 5, "timid") {
            mockClient.getNatureList(0, pageSize)
        }
    }

    @Test
    fun getPokeathlonStatList() {
        test("pokeathlon-stat", 5, "jump") {
            mockClient.getPokeathlonStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon", 3, "venusaur") {
            mockClient.getPokemonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color", 8, "red") {
            mockClient.getPokemonColorList(0, pageSize)
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form", 18, "pidgeot") {
            mockClient.getPokemonFormList(0, pageSize)
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat", 8, "urban") {
            mockClient.getPokemonHabitatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape", 13, "bug-wings") {
            mockClient.getPokemonShapeList(0, pageSize)
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species", 20, "raticate") {
            mockClient.getPokemonSpeciesList(0, pageSize)
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat", 6, "speed") {
            mockClient.getStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type", 18, "fairy") {
            mockClient.getTypeList(0, pageSize)
        }
    }

    @Test
    fun getLanguageList() {
        test("language", 9, "en") {
            mockClient.getLanguageList(0, pageSize)
        }
    }
}