package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.ApiResourceList
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.utils.MockClient
import org.testng.annotations.Test
import java.util.*
import kotlin.reflect.memberProperties
import kotlin.test.fail

class BulkTest {

    companion object {
        private const val enabled = false
    }

    private fun checkNulls(obj: Any) {
        if (obj is Collection<*>) {
            obj.forEach { checkNulls(it!!) }
            return
        }

        val cls = obj.javaClass.kotlin
        if (cls.javaPrimitiveType != null || cls == String::class) {
            return
        }

        val names = LinkedList<String>()

        cls.memberProperties.forEach {
            val o = it.get(obj)
            if (o == null) {
                if (!it.returnType.isMarkedNullable)
                    names += it.name
            } else {
                checkNulls(o)
            }
        }

        assert(names.isEmpty()) { "nullable errors: $names" }
    }

    private fun runTest(cat: String, ids: List<Int>, getObject: (Int) -> Any) {
        var pass = true
        val count = ids.size
        println("$cat: $count total")
        ids.forEachIndexed { i, id ->
            print("${i+1}/$count ($id) ... ")
            try {
                val o = getObject(id)
                print("deserialized ... ")
                checkNulls(o)
                print("checked!")
                println()
            } catch (e: Throwable) {
                println("ERROR: ${e.javaClass.simpleName}: ${e.message}")
                pass = false
            }
        }
        if (!pass) fail()
    }

    private fun runTest1(getList: (Int, Int) -> NamedApiResourceList, getObject: (Int) -> Any) {
        val count = getList(0, 0).count
        val list = getList(0, count).results
        runTest(list[0].category, list.map { it.id }, getObject)
    }

    private fun runTest2(getList: (Int, Int) -> ApiResourceList, getObject: (Int) -> Any) {
        val list = getList(0, getList(0, 0).count).results
        runTest(list[0].category, list.map { it.id }, getObject)
    }

    @Test(enabled = enabled)
    fun bulkBerry() {
        runTest1({ o, l -> MockClient.getBerryList(o, l) }, { i -> MockClient.getBerry(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFirmness() {
        runTest1({ o, l -> MockClient.getBerryFirmnessList(o, l) }, { i -> MockClient.getBerryFirmness(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFlavor() {
        runTest1({ o, l -> MockClient.getBerryFlavorList(o, l) }, { i -> MockClient.getBerryFlavor(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestType() {
        runTest1({ o, l -> MockClient.getContestTypeList(o, l) }, { i -> MockClient.getContestType(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestEffect() {
        runTest2({ o, l -> MockClient.getContestEffectList(o, l) }, { i -> MockClient.getContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkSuperContestEffect() {
        runTest2({ o, l -> MockClient.getSuperContestEffectList(o, l) }, { i -> MockClient.getSuperContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterMethod() {
        runTest1({ o, l -> MockClient.getEncounterMethodList(o, l) }, { i -> MockClient.getEncounterMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterCondition() {
        runTest1({ o, l -> MockClient.getEncounterConditionList(o, l) }, { i -> MockClient.getEncounterCondition(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterConditionValue() {
        runTest1({ o, l -> MockClient.getEncounterConditionValueList(o, l) }, { i -> MockClient.getEncounterConditionValue(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionChain() {
        runTest2({ o, l -> MockClient.getEvolutionChainList(o, l) }, { i -> MockClient.getEvolutionChain(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionTrigger() {
        runTest1({ o, l -> MockClient.getEvolutionTriggerList(o, l) }, { i -> MockClient.getEvolutionTrigger(i) })
    }

    @Test(enabled = enabled)
    fun bulkGeneration() {
        runTest1({ o, l -> MockClient.getGenerationList(o, l) }, { i -> MockClient.getGeneration(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokedex() {
        runTest1({ o, l -> MockClient.getPokedexList(o, l) }, { i -> MockClient.getPokedex(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersion() {
        runTest1({ o, l -> MockClient.getVersionList(o, l) }, { i -> MockClient.getVersion(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersionGroup() {
        runTest1({ o, l -> MockClient.getVersionGroupList(o, l) }, { i -> MockClient.getVersionGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkItem() {
        runTest1({ o, l -> MockClient.getItemList(o, l) }, { i -> MockClient.getItem(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemAttribute() {
        runTest1({ o, l -> MockClient.getItemAttributeList(o, l) }, { i -> MockClient.getItemAttribute(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemCategory() {
        runTest1({ o, l -> MockClient.getItemCategoryList(o, l) }, { i -> MockClient.getItemCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemFlingEffect() {
        runTest1({ o, l -> MockClient.getItemFlingEffectList(o, l) }, { i -> MockClient.getItemFlingEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemPocket() {
        runTest1({ o, l -> MockClient.getItemPocketList(o, l) }, { i -> MockClient.getItemPocket(i) })
    }

    @Test(enabled = enabled)
    fun bulkMove() {
        runTest1({ o, l -> MockClient.getMoveList(o, l) }, { i -> MockClient.getMove(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveAilment() {
        runTest1({ o, l -> MockClient.getMoveAilmentList(o, l) }, { i -> MockClient.getMoveAilment(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveBattleStyle() {
        runTest1({ o, l -> MockClient.getMoveBattleStyleList(o, l) }, { i -> MockClient.getMoveBattleStyle(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveCategory() {
        runTest1({ o, l -> MockClient.getMoveCategoryList(o, l) }, { i -> MockClient.getMoveCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveDamageClass() {
        runTest1({ o, l -> MockClient.getMoveDamageClassList(o, l) }, { i -> MockClient.getMoveDamageClass(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveLearnMethod() {
        runTest1({ o, l -> MockClient.getMoveLearnMethodList(o, l) }, { i -> MockClient.getMoveLearnMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveTarget() {
        runTest1({ o, l -> MockClient.getMoveTargetList(o, l) }, { i -> MockClient.getMoveTarget(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocation() {
        runTest1({ o, l -> MockClient.getLocationList(o, l) }, { i -> MockClient.getLocation(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocationArea() {
        runTest1({ o, l -> MockClient.getLocationAreaList(o, l) }, { i -> MockClient.getLocationArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkPalParkArea() {
        runTest1({ o, l -> MockClient.getPalParkAreaList(o, l) }, { i -> MockClient.getPalParkArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkRegion() {
        runTest1({ o, l -> MockClient.getRegionList(o, l) }, { i -> MockClient.getRegion(i) })
    }

    @Test(enabled = enabled)
    fun bulkAbility() {
        runTest1({ o, l -> MockClient.getAbilityList(o, l) }, { i -> MockClient.getAbility(i) })
    }

    @Test(enabled = enabled)
    fun bulkCharacteristic() {
        runTest2({ o, l -> MockClient.getCharacteristicList(o, l) }, { i -> MockClient.getCharacteristic(i) })
    }

    @Test(enabled = enabled)
    fun bulkEggGroup() {
        runTest1({ o, l -> MockClient.getEggGroupList(o, l) }, { i -> MockClient.getEggGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkGender() {
        runTest1({ o, l -> MockClient.getGenderList(o, l) }, { i -> MockClient.getGender(i) })
    }

    @Test(enabled = enabled)
    fun bulkGrowthRate() {
        runTest1({ o, l -> MockClient.getGrowthRateList(o, l) }, { i -> MockClient.getGrowthRate(i) })
    }

    @Test(enabled = enabled)
    fun bulkNature() {
        runTest1({ o, l -> MockClient.getNatureList(o, l) }, { i -> MockClient.getNature(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokeathlonStat() {
        runTest1({ o, l -> MockClient.getPokeathlonStatList(o, l) }, { i -> MockClient.getPokeathlonStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemon() {
        runTest1({ o, l -> MockClient.getPokemonList(o, l) }, { i -> MockClient.getPokemon(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonEncounters() {
        runTest1({ o, l -> MockClient.getPokemonList(o, l) }, { i -> MockClient.getPokemonEncounters(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonColor() {
        runTest1({ o, l -> MockClient.getPokemonColorList(o, l) }, { i -> MockClient.getPokemonColor(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonForm() {
        runTest1({ o, l -> MockClient.getPokemonFormList(o, l) }, { i -> MockClient.getPokemonForm(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonHabitat() {
        runTest1({ o, l -> MockClient.getPokemonHabitatList(o, l) }, { i -> MockClient.getPokemonHabitat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonShape() {
        runTest1({ o, l -> MockClient.getPokemonShapeList(o, l) }, { i -> MockClient.getPokemonShape(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonSpecies() {
        runTest1({ o, l -> MockClient.getPokemonSpeciesList(o, l) }, { i -> MockClient.getPokemonSpecies(i) })
    }

    @Test(enabled = enabled)
    fun bulkStat() {
        runTest1({ o, l -> MockClient.getStatList(o, l) }, { i -> MockClient.getStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkType() {
        runTest1({ o, l -> MockClient.getTypeList(o, l) }, { i -> MockClient.getType(i) })
    }

    @Test(enabled = enabled)
    fun bulkLanguage() {
        runTest1({ o, l -> MockClient.getLanguageList(o, l) }, { i -> MockClient.getLanguage(i) })
    }
}