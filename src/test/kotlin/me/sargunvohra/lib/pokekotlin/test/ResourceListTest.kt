package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.*
import me.sargunvohra.lib.pokekotlin.json.*
import org.testng.annotations.*
import retrofit2.Call
import kotlin.test.*

class ResourceListTest {

    fun <T> test(path: String, name: String, call: () -> Call<List<NamedApiResource<T>>>) {
        assert(call().promise.get()) {
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
        }
    }

    fun <T> test(path: String, call: () -> Call<List<ApiResource<T>>>) {
        assert(call().promise.get()) {
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
        }
    }

    @Test
    fun getBerryList() {
        test("berry/21/", "pomeg") {
            PokeApi.getBerryList()
        }
    }

    @Test
    fun getBerryFirmnessList() {
        test("berry-firmness/4/", "very-hard") {
            PokeApi.getBerryFirmnessList()
        }
    }

    @Test
    fun getBerryFlavorList() {
        test("berry-flavor/4/", "bitter") {
            PokeApi.getBerryFlavorList()
        }
    }

    @Test
    fun getContestTypeList() {
        test("contest-type/4/", "smart") {
            PokeApi.getContestTypeList()
        }
    }

    @Test
    fun getContestEffectList() {
        test("contest-effect/4/") {
            PokeApi.getContestEffectList()
        }
    }

    @Test
    fun getSuperContestEffectList() {
        test("super-contest-effect/2/") {
            PokeApi.getSuperContestEffectList()
        }
    }

    @Test
    fun getEncounterMethodList() {
        test("encounter-method/5/", "surf") {
            PokeApi.getEncounterMethodList()
        }
    }

    @Test
    fun getEncounterConditionList() {
        test("encounter-condition/3/", "radar") {
            PokeApi.getEncounterConditionList()
        }
    }

    @Test
    fun getEncounterConditionValueList() {
        test("encounter-condition-value/4/", "time-day") {
            PokeApi.getEncounterConditionValueList()
        }
    }

    @Test
    fun getEvolutionChainList() {
        test("evolution-chain/5/") {
            PokeApi.getEvolutionChainList()
        }
    }

    @Test
    fun getEvolutionTriggerList() {
        test("evolution-trigger/2/", "trade") {
            PokeApi.getEvolutionTriggerList()
        }
    }

    @Test
    fun getGenerationList() {
        test("generation/6/", "generation-vi") {
            PokeApi.getGenerationList()
        }
    }

    @Test
    fun getPokedexList() {
        test("pokedex/8/", "original-unova") {
            PokeApi.getPokedexList()
        }
    }

    @Test
    fun getVersionList() {
        test("version/4/", "gold") {
            PokeApi.getVersionList()
        }
    }

    @Test
    fun getVersionGroupList() {
        test("version-group/3/", "gold-silver") {
            PokeApi.getVersionGroupList()
        }
    }

    @Test
    fun getItemList() {
        test("item/16/", "cherish-ball") {
            PokeApi.getItemList()
        }
    }

    @Test
    fun getItemAttributeList() {
        test("item-attribute/7/", "holdable-active") {
            PokeApi.getItemAttributeList()
        }
    }

    @Test
    fun getItemCategoryList() {
        test("item-category/7/", "type-protection") {
            PokeApi.getItemCategoryList()
        }
    }

    @Test
    fun getItemFlingEffectList() {
        test("item-fling-effect/4/", "herb-effect") {
            PokeApi.getItemFlingEffectList()
        }
    }

    @Test
    fun getItemPocketList() {
        test("item-pocket/3/", "pokeballs") {
            PokeApi.getItemPocketList()
        }
    }

    @Test
    fun getMoveList() {
        test("move/481/", "flame-burst") {
            PokeApi.getMoveList()
        }
    }

    @Test
    fun getMoveAilmentList() {
        test("move-ailment/5/", "poison") {
            PokeApi.getMoveAilmentList()
        }
    }

    @Test
    fun getMoveBattleStyleList() {
        test("move-battle-style/2/", "defense") {
            PokeApi.getMoveBattleStyleList()
        }
    }

    @Test
    fun getMoveCategoryList() {
        test("move-category/11/", "field-effect") {
            PokeApi.getMoveCategoryList()
        }
    }

    @Test
    fun getMoveDamageClassList() {
        test("move-damage-class/2/", "physical") {
            PokeApi.getMoveDamageClassList()
        }
    }

    @Test
    fun getMoveLearnMethodList() {
        test("move-learn-method/4/", "machine") {
            PokeApi.getMoveLearnMethodList()
        }
    }

    @Test
    fun getMoveTargetList() {
        test("move-target/14/", "all-pokemon") {
            PokeApi.getMoveTargetList()
        }
    }

    @Test
    fun getLocationList() {
        test("location/31/", "sinnoh-route-201") {
            PokeApi.getLocationList()
        }
    }

    @Test
    fun getLocationAreaList() {
        test("location-area/34/", "solaceon-ruins-b1f-c") {
            PokeApi.getLocationAreaList()
        }
    }

    @Test
    fun getPalParkAreaList() {
        test("pal-park-area/3/", "mountain") {
            PokeApi.getPalParkAreaList()
        }
    }

    @Test
    fun getRegionList() {
        test("region/1/", "kanto") {
            PokeApi.getRegionList()
        }
    }

    @Test
    fun getAbilityList() {
        test("ability/5/", "sturdy") {
            PokeApi.getAbilityList()
        }
    }

    @Test
    fun getCharacteristicList() {
        test("characteristic/30/") {
            PokeApi.getCharacteristicList()
        }
    }

    @Test
    fun getEggGroupList() {
        test("egg-group/14/", "dragon") {
            PokeApi.getEggGroupList()
        }
    }

    @Test
    fun getGenderList() {
        test("gender/2/", "male") {
            PokeApi.getGenderList()
        }
    }

    @Test
    fun getGrowthRateList() {
        test("growth-rate/3/", "fast") {
            PokeApi.getGrowthRateList()
        }
    }

    @Test
    fun getNatureList() {
        test("nature/12/", "impish") {
            PokeApi.getNatureList()
        }
    }

    @Test
    fun getPokeathlonList() {
        test("pokeathlon-stat/5/", "jump") {
            PokeApi.getPokeathlonList()
        }
    }

    @Test
    fun getPokemonList() {
        test("pokemon/217/", "ursaring") {
            PokeApi.getPokemonList()
        }
    }

    @Test
    fun getPokemonColorList() {
        test("pokemon-color/8/", "red") {
            PokeApi.getPokemonColorList()
        }
    }

    @Test
    fun getPokemonFormList() {
        test("pokemon-form/18/", "pidgeot") {
            PokeApi.getPokemonFormList()
        }
    }

    @Test
    fun getPokemonHabitatList() {
        test("pokemon-habitat/8/", "urban") {
            PokeApi.getPokemonHabitatList()
        }
    }

    @Test
    fun getPokemonShapeList() {
        test("pokemon-shape/13/", "bug-wings") {
            PokeApi.getPokemonShapeList()
        }
    }

    @Test
    fun getPokemonSpeciesList() {
        test("pokemon-species/179/", "mareep") {
            PokeApi.getPokemonSpeciesList()
        }
    }

    @Test
    fun getPokemonStatList() {
        test("stat/6/", "speed") {
            PokeApi.getPokemonStatList()
        }
    }

    @Test
    fun getPokemonTypeList() {
        test("type/18/", "fairy") {
            PokeApi.getPokemonTypeList()
        }
    }

    @Test
    fun getLanguageList() {
        test("language/9/", "en") {
            PokeApi.getLanguageList()
        }
    }
}