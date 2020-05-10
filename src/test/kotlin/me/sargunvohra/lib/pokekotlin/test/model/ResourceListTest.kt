package me.sargunvohra.lib.pokekotlin.test.model

import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import me.sargunvohra.lib.pokekotlin.model.ApiResource
import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.MockServer
import org.junit.Test

class ResourceListTest {

    val pageSize = 50

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
            MockServer.client.getBerryList(0, pageSize)
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness", 4, "very-hard") {
            MockServer.client.getBerryFirmnessList(0, pageSize)
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor", 4, "bitter") {
            MockServer.client.getBerryFlavorList(0, pageSize)
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type", 4, "smart") {
            MockServer.client.getContestTypeList(0, pageSize)
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect", 4) {
            MockServer.client.getContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect", 2) {
            MockServer.client.getSuperContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method", 5, "surf") {
            MockServer.client.getEncounterMethodList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition", 3, "radar") {
            MockServer.client.getEncounterConditionList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value", 4, "time-day") {
            MockServer.client.getEncounterConditionValueList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain", 5) {
            MockServer.client.getEvolutionChainList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger", 2, "trade") {
            MockServer.client.getEvolutionTriggerList(0, pageSize)
        }
    }

    @Test
    fun getGenerationList() {
        test("generation", 3, "generation-iii") {
            MockServer.client.getGenerationList(0, pageSize)
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex", 2, "kanto") {
            MockServer.client.getPokedexList(0, pageSize)
        }
    }

    @Test
    fun getVersionList() {
        test("version", 4, "gold") {
            MockServer.client.getVersionList(0, pageSize)
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group", 3, "gold-silver") {
            MockServer.client.getVersionGroupList(0, pageSize)
        }
    }

    @Test
    fun getItemList() {
        test("item", 16, "cherish-ball") {
            MockServer.client.getItemList(0, pageSize)
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute", 2, "consumable") {
            MockServer.client.getItemAttributeList(0, pageSize)
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category", 2, "effort-drop") {
            MockServer.client.getItemCategoryList(0, pageSize)
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect", 4, "herb-effect") {
            MockServer.client.getItemFlingEffectList(0, pageSize)
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket", 3, "pokeballs") {
            MockServer.client.getItemPocketList(0, pageSize)
        }
    }

    @Test
    fun getMoveList() {
        test("move", 17, "wing-attack") {
            MockServer.client.getMoveList(0, pageSize)
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment", 5, "poison") {
            MockServer.client.getMoveAilmentList(0, pageSize)
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style", 2, "defense") {
            MockServer.client.getMoveBattleStyleList(0, pageSize)
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category", 11, "field-effect") {
            MockServer.client.getMoveCategoryList(0, pageSize)
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class", 2, "physical") {
            MockServer.client.getMoveDamageClassList(0, pageSize)
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method", 4, "machine") {
            MockServer.client.getMoveLearnMethodList(0, pageSize)
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target", 14, "all-pokemon") {
            MockServer.client.getMoveTargetList(0, pageSize)
        }
    }

    @Test
    fun getLocationList() {
        test("location", 31, "sinnoh-route-201") {
            MockServer.client.getLocationList(0, pageSize)
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area", 34, "solaceon-ruins-b1f-c") {
            MockServer.client.getLocationAreaList(0, pageSize)
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area", 3, "mountain") {
            MockServer.client.getPalParkAreaList(0, pageSize)
        }
    }

    @Test
    fun getRegionList() {
        test("region", 1, "kanto") {
            MockServer.client.getRegionList(0, pageSize)
        }
    }

    @Test
    fun getAbilityList() {
        test("ability", 5, "sturdy") {
            MockServer.client.getAbilityList(0, pageSize)
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic", 4) {
            MockServer.client.getCharacteristicList(0, pageSize)
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group", 1, "monster") {
            MockServer.client.getEggGroupList(0, pageSize)
        }
    }

    @Test
    fun getGenderList() {
        test("gender", 2, "male") {
            MockServer.client.getGenderList(0, pageSize)
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate", 3, "fast") {
            MockServer.client.getGrowthRateList(0, pageSize)
        }
    }

    @Test
    fun getNatureList() {
        test("nature", 5, "timid") {
            MockServer.client.getNatureList(0, pageSize)
        }
    }

    @Test
    fun getPokeathlonStatList() {
        test("pokeathlon-stat", 5, "jump") {
            MockServer.client.getPokeathlonStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon", 3, "venusaur") {
            MockServer.client.getPokemonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color", 8, "red") {
            MockServer.client.getPokemonColorList(0, pageSize)
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form", 18, "pidgeot") {
            MockServer.client.getPokemonFormList(0, pageSize)
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat", 8, "urban") {
            MockServer.client.getPokemonHabitatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape", 13, "bug-wings") {
            MockServer.client.getPokemonShapeList(0, pageSize)
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species", 20, "raticate") {
            MockServer.client.getPokemonSpeciesList(0, pageSize)
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat", 6, "speed") {
            MockServer.client.getStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type", 18, "fairy") {
            MockServer.client.getTypeList(0, pageSize)
        }
    }

    @Test
    fun getLanguageList() {
        test("language", 9, "en") {
            MockServer.client.getLanguageList(0, pageSize)
        }
    }
}
