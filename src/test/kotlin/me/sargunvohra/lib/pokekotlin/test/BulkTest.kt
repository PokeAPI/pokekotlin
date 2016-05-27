package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.PokeApi
import me.sargunvohra.lib.pokekotlin.json.ApiResourceList
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceList
import org.testng.annotations.Test
import kotlin.test.fail

class BulkTest {

    companion object {
        private const val enabled = false
    }

    fun runTest(cat: String, ids: List<Int>, getObject: (Int) -> Any) {
        var pass = true
        val count = ids.size
        println("$cat: $count total")
        ids.forEachIndexed { i, id ->
            print(" ${i+1}/$count ... ")
            try {
                getObject(id)
                println("OK")
            } catch (e: Throwable) {
                println("${e.javaClass.simpleName}: ${e.message}")
                pass = false
            }
        }
        if (!pass) fail()
    }

    fun runTest1(getList: (Int, Int) -> NamedApiResourceList, getObject: (Int) -> Any) {
        val count = getList(0, 0).count
        val list = getList(0, count).results
        runTest(list[0].category, list.map { it.id }, getObject)
    }

    fun runTest2(getList: (Int, Int) -> ApiResourceList, getObject: (Int) -> Any) {
        val list = getList(0, getList(0, 0).count).results
        runTest(list[0].category, list.map { it.id }, getObject)
    }

    @Test(enabled = enabled)
    fun bulkBerry() {
        runTest1({ o, l -> PokeApi.getBerryList(o, l) }, { i -> PokeApi.getBerry(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFirmness() {
        runTest1({ o, l -> PokeApi.getBerryFirmnessList(o, l) }, { i -> PokeApi.getBerryFirmness(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFlavor() {
        runTest1({ o, l -> PokeApi.getBerryFlavorList(o, l) }, { i -> PokeApi.getBerryFlavor(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestType() {
        runTest1({ o, l -> PokeApi.getContestTypeList(o, l) }, { i -> PokeApi.getContestType(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestEffect() {
        runTest2({ o, l -> PokeApi.getContestEffectList(o, l) }, { i -> PokeApi.getContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkSuperContestEffect() {
        runTest2({ o, l -> PokeApi.getSuperContestEffectList(o, l) }, { i -> PokeApi.getSuperContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterMethod() {
        runTest1({ o, l -> PokeApi.getEncounterMethodList(o, l) }, { i -> PokeApi.getEncounterMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterCondition() {
        runTest1({ o, l -> PokeApi.getEncounterConditionList(o, l) }, { i -> PokeApi.getEncounterCondition(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterConditionValue() {
        runTest1({ o, l -> PokeApi.getEncounterConditionValueList(o, l) }, { i -> PokeApi.getEncounterConditionValue(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionChain() {
        runTest2({ o, l -> PokeApi.getEvolutionChainList(o, l) }, { i -> PokeApi.getEvolutionChain(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionTrigger() {
        runTest1({ o, l -> PokeApi.getEvolutionTriggerList(o, l) }, { i -> PokeApi.getEvolutionTrigger(i) })
    }

    @Test(enabled = enabled)
    fun bulkGeneration() {
        runTest1({ o, l -> PokeApi.getGenerationList(o, l) }, { i -> PokeApi.getGeneration(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokedex() {
        runTest1({ o, l -> PokeApi.getPokedexList(o, l) }, { i -> PokeApi.getPokedex(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersion() {
        runTest1({ o, l -> PokeApi.getVersionList(o, l) }, { i -> PokeApi.getVersion(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersionGroup() {
        runTest1({ o, l -> PokeApi.getVersionGroupList(o, l) }, { i -> PokeApi.getVersionGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkItem() {
        runTest1({ o, l -> PokeApi.getItemList(o, l) }, { i -> PokeApi.getItem(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemAttribute() {
        runTest1({ o, l -> PokeApi.getItemAttributeList(o, l) }, { i -> PokeApi.getItemAttribute(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemCategory() {
        runTest1({ o, l -> PokeApi.getItemCategoryList(o, l) }, { i -> PokeApi.getItemCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemFlingEffect() {
        runTest1({ o, l -> PokeApi.getItemFlingEffectList(o, l) }, { i -> PokeApi.getItemFlingEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemPocket() {
        runTest1({ o, l -> PokeApi.getItemPocketList(o, l) }, { i -> PokeApi.getItemPocket(i) })
    }

    @Test(enabled = enabled)
    fun bulkMove() {
        runTest1({ o, l -> PokeApi.getMoveList(o, l) }, { i -> PokeApi.getMove(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveAilment() {
        runTest1({ o, l -> PokeApi.getMoveAilmentList(o, l) }, { i -> PokeApi.getMoveAilment(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveBattleStyle() {
        runTest1({ o, l -> PokeApi.getMoveBattleStyleList(o, l) }, { i -> PokeApi.getMoveBattleStyle(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveCategory() {
        runTest1({ o, l -> PokeApi.getMoveCategoryList(o, l) }, { i -> PokeApi.getMoveCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveDamageClass() {
        runTest1({ o, l -> PokeApi.getMoveDamageClassList(o, l) }, { i -> PokeApi.getMoveDamageClass(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveLearnMethod() {
        runTest1({ o, l -> PokeApi.getMoveLearnMethodList(o, l) }, { i -> PokeApi.getMoveLearnMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveTarget() {
        runTest1({ o, l -> PokeApi.getMoveTargetList(o, l) }, { i -> PokeApi.getMoveTarget(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocation() {
        runTest1({ o, l -> PokeApi.getLocationList(o, l) }, { i -> PokeApi.getLocation(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocationArea() {
        runTest1({ o, l -> PokeApi.getLocationAreaList(o, l) }, { i -> PokeApi.getLocationArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkPalParkArea() {
        runTest1({ o, l -> PokeApi.getPalParkAreaList(o, l) }, { i -> PokeApi.getPalParkArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkRegion() {
        runTest1({ o, l -> PokeApi.getRegionList(o, l) }, { i -> PokeApi.getRegion(i) })
    }

    @Test(enabled = enabled)
    fun bulkAbility() {
        runTest1({ o, l -> PokeApi.getAbilityList(o, l) }, { i -> PokeApi.getAbility(i) })
    }

    @Test(enabled = enabled)
    fun bulkCharacteristic() {
        runTest2({ o, l -> PokeApi.getCharacteristicList(o, l) }, { i -> PokeApi.getCharacteristic(i) })
    }

    @Test(enabled = enabled)
    fun bulkEggGroup() {
        runTest1({ o, l -> PokeApi.getEggGroupList(o, l) }, { i -> PokeApi.getEggGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkGender() {
        runTest1({ o, l -> PokeApi.getGenderList(o, l) }, { i -> PokeApi.getGender(i) })
    }

    @Test(enabled = enabled)
    fun bulkGrowthRate() {
        runTest1({ o, l -> PokeApi.getGrowthRateList(o, l) }, { i -> PokeApi.getGrowthRate(i) })
    }

    @Test(enabled = enabled)
    fun bulkNature() {
        runTest1({ o, l -> PokeApi.getNatureList(o, l) }, { i -> PokeApi.getNature(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokeathlonStat() {
        runTest1({ o, l -> PokeApi.getPokeathlonStatList(o, l) }, { i -> PokeApi.getPokeathlonStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemon() {
        runTest1({ o, l -> PokeApi.getPokemonList(o, l) }, { i -> PokeApi.getPokemon(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonColor() {
        runTest1({ o, l -> PokeApi.getPokemonColorList(o, l) }, { i -> PokeApi.getPokemonColor(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonForm() {
        runTest1({ o, l -> PokeApi.getPokemonFormList(o, l) }, { i -> PokeApi.getPokemonForm(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonHabitat() {
        runTest1({ o, l -> PokeApi.getPokemonHabitatList(o, l) }, { i -> PokeApi.getPokemonHabitat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonShape() {
        runTest1({ o, l -> PokeApi.getPokemonShapeList(o, l) }, { i -> PokeApi.getPokemonShape(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonSpecies() {
        runTest1({ o, l -> PokeApi.getPokemonSpeciesList(o, l) }, { i -> PokeApi.getPokemonSpecies(i) })
    }

    @Test(enabled = enabled)
    fun bulkStat() {
        runTest1({ o, l -> PokeApi.getStatList(o, l) }, { i -> PokeApi.getStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkType() {
        runTest1({ o, l -> PokeApi.getTypeList(o, l) }, { i -> PokeApi.getType(i) })
    }

    @Test(enabled = enabled)
    fun bulkLanguage() {
        runTest1({ o, l -> PokeApi.getLanguageList(o, l) }, { i -> PokeApi.getLanguage(i) })
    }
}