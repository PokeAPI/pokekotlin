package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.*
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.*
import retrofit2.Call
import kotlin.test.*

class ResourceListTest {

    final val pageSize = 50

    fun <T> test(path: String, name: String, call: () -> Call<NamedApiResourceList<T>>) {
        assert(call().promise.get().results) {
            collection.indices.forEach {
                elementAtShouldComply(it, "it should have a name") {
                    it.name.isNotEmpty()
                }
                elementAtShouldComply(it, "it should have a url") {
                    it.url.isNotEmpty()
                }
                elementAtShouldComply(it, "it should be able to parse id") {
                    it.url.contains("/${it.id}/")
                }
            }
            assert(collection.contains(NamedApiResource(name, PokeApi.rootUrl + path))) {
                "list should contain a specific element"
            }
            assert(collection.count() <= pageSize) {
                "collection should be limited to $pageSize elements"
            }
        }
    }

    fun <T> test(path: String, call: () -> Call<ApiResourceList<T>>) {
        assert(call().promise.get().results) {
            collection.indices.forEach {
                elementAtShouldComply(it, "it should have a url") {
                    it.url.isNotEmpty()
                }
                elementAtShouldComply(it, "it should be able to parse id") {
                    it.url.contains("/${it.id}/")
                }
            }
            assert(collection.contains(ApiResource("http://pokeapi.co/api/v2/$path"))) {
                "list should contain a specific element"
            }
            assert(collection.count() <= pageSize) {
                "collection should be limited to $pageSize elements"
            }
        }
    }

    @Test
    fun getBerryList() {
        test("berry/4/", "rawst") {
            PokeApi.getBerryList(0, pageSize)
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness/4/", "very-hard") {
            PokeApi.getBerryFirmnessList(0, pageSize)
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor/4/", "bitter") {
            PokeApi.getBerryFlavorList(0, pageSize)
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type/4/", "smart") {
            PokeApi.getContestTypeList(0, pageSize)
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect/4/") {
            PokeApi.getContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect/2/") {
            PokeApi.getSuperContestEffectList(0, pageSize)
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method/5/", "surf") {
            PokeApi.getEncounterMethodList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition/3/", "radar") {
            PokeApi.getEncounterConditionList(0, pageSize)
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value/4/", "time-day") {
            PokeApi.getEncounterConditionValueList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain/5/") {
            PokeApi.getEvolutionChainList(0, pageSize)
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger/2/", "trade") {
            PokeApi.getEvolutionTriggerList(0, pageSize)
        }
    }

    @Test
    fun getGenerationList() {
        test("generation/3/", "generation-iii") {
            PokeApi.getGenerationList(0, pageSize)
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex/2/", "kanto") {
            PokeApi.getPokedexList(0, pageSize)
        }
    }

    @Test
    fun getVersionList() {
        test("version/4/", "gold") {
            PokeApi.getVersionList(0, pageSize)
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group/3/", "gold-silver") {
            PokeApi.getVersionGroupList(0, pageSize)
        }
    }

    @Test
    fun getItemList() {
        test("item/16/", "cherish-ball") {
            PokeApi.getItemList(0, pageSize)
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute/2/", "consumable") {
            PokeApi.getItemAttributeList(0, pageSize)
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category/2/", "effort-drop") {
            PokeApi.getItemCategoryList(0, pageSize)
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect/4/", "herb-effect") {
            PokeApi.getItemFlingEffectList(0, pageSize)
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket/3/", "pokeballs") {
            PokeApi.getItemPocketList(0, pageSize)
        }
    }

    @Test
    fun getMoveList() {
        test("move/481/", "flame-burst") {
            PokeApi.getMoveList(450, pageSize)
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment/5/", "poison") {
            PokeApi.getMoveAilmentList(0, pageSize)
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style/2/", "defense") {
            PokeApi.getMoveBattleStyleList(0, pageSize)
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category/11/", "field-effect") {
            PokeApi.getMoveCategoryList(0, pageSize)
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class/2/", "physical") {
            PokeApi.getMoveDamageClassList(0, pageSize)
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method/4/", "machine") {
            PokeApi.getMoveLearnMethodList(0, pageSize)
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target/14/", "all-pokemon") {
            PokeApi.getMoveTargetList(0, pageSize)
        }
    }

    @Test
    fun getLocationList() {
        test("location/31/", "sinnoh-route-201") {
            PokeApi.getLocationList(0, pageSize)
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area/34/", "solaceon-ruins-b1f-c") {
            PokeApi.getLocationAreaList(0, pageSize)
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area/3/", "mountain") {
            PokeApi.getPalParkAreaList(0, pageSize)
        }
    }

    @Test
    fun getRegionList() {
        test("region/1/", "kanto") {
            PokeApi.getRegionList(0, pageSize)
        }
    }

    @Test
    fun getAbilityList() {
        test("ability/5/", "sturdy") {
            PokeApi.getAbilityList(0, pageSize)
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic/4/") {
            PokeApi.getCharacteristicList(0, pageSize)
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group/1/", "monster") {
            PokeApi.getEggGroupList(0, pageSize)
        }
    }

    @Test
    fun getGenderList() {
        test("gender/2/", "male") {
            PokeApi.getGenderList(0, pageSize)
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate/3/", "fast") {
            PokeApi.getGrowthRateList(0, pageSize)
        }
    }

    @Test
    fun getNatureList() {
        test("nature/5/", "timid") {
            PokeApi.getNatureList(0, pageSize)
        }
    }

    @Test
    fun getPokeathlonList() {
        test("pokeathlon-stat/5/", "jump") {
            PokeApi.getPokeathlonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon/3/", "venusaur") {
            PokeApi.getPokemonList(0, pageSize)
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color/8/", "red") {
            PokeApi.getPokemonColorList(0, pageSize)
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form/18/", "pidgeot") {
            PokeApi.getPokemonFormList(0, pageSize)
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat/8/", "urban") {
            PokeApi.getPokemonHabitatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape/13/", "bug-wings") {
            PokeApi.getPokemonShapeList(0, pageSize)
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species/179/", "mareep") {
            PokeApi.getPokemonSpeciesList(150, pageSize)
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat/6/", "speed") {
            PokeApi.getStatList(0, pageSize)
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type/18/", "fairy") {
            PokeApi.getTypeList(0, pageSize)
        }
    }

    @Test
    fun getLanguageList() {
        test("language/9/", "en") {
            PokeApi.getLanguageList(0, pageSize)
        }
    }
}