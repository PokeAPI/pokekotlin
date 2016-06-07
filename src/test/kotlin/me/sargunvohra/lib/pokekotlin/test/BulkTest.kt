package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.json.ApiResourceList
import me.sargunvohra.lib.pokekotlin.json.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.utils.TestClient
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
        runTest1({ o, l -> TestClient.getBerryList(o, l) }, { i -> TestClient.getBerry(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFirmness() {
        runTest1({ o, l -> TestClient.getBerryFirmnessList(o, l) }, { i -> TestClient.getBerryFirmness(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFlavor() {
        runTest1({ o, l -> TestClient.getBerryFlavorList(o, l) }, { i -> TestClient.getBerryFlavor(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestType() {
        runTest1({ o, l -> TestClient.getContestTypeList(o, l) }, { i -> TestClient.getContestType(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestEffect() {
        runTest2({ o, l -> TestClient.getContestEffectList(o, l) }, { i -> TestClient.getContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkSuperContestEffect() {
        runTest2({ o, l -> TestClient.getSuperContestEffectList(o, l) }, { i -> TestClient.getSuperContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterMethod() {
        runTest1({ o, l -> TestClient.getEncounterMethodList(o, l) }, { i -> TestClient.getEncounterMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterCondition() {
        runTest1({ o, l -> TestClient.getEncounterConditionList(o, l) }, { i -> TestClient.getEncounterCondition(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterConditionValue() {
        runTest1({ o, l -> TestClient.getEncounterConditionValueList(o, l) }, { i -> TestClient.getEncounterConditionValue(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionChain() {
        runTest2({ o, l -> TestClient.getEvolutionChainList(o, l) }, { i -> TestClient.getEvolutionChain(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionTrigger() {
        runTest1({ o, l -> TestClient.getEvolutionTriggerList(o, l) }, { i -> TestClient.getEvolutionTrigger(i) })
    }

    @Test(enabled = enabled)
    fun bulkGeneration() {
        runTest1({ o, l -> TestClient.getGenerationList(o, l) }, { i -> TestClient.getGeneration(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokedex() {
        runTest1({ o, l -> TestClient.getPokedexList(o, l) }, { i -> TestClient.getPokedex(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersion() {
        runTest1({ o, l -> TestClient.getVersionList(o, l) }, { i -> TestClient.getVersion(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersionGroup() {
        runTest1({ o, l -> TestClient.getVersionGroupList(o, l) }, { i -> TestClient.getVersionGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkItem() {
        runTest1({ o, l -> TestClient.getItemList(o, l) }, { i -> TestClient.getItem(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemAttribute() {
        runTest1({ o, l -> TestClient.getItemAttributeList(o, l) }, { i -> TestClient.getItemAttribute(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemCategory() {
        runTest1({ o, l -> TestClient.getItemCategoryList(o, l) }, { i -> TestClient.getItemCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemFlingEffect() {
        runTest1({ o, l -> TestClient.getItemFlingEffectList(o, l) }, { i -> TestClient.getItemFlingEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemPocket() {
        runTest1({ o, l -> TestClient.getItemPocketList(o, l) }, { i -> TestClient.getItemPocket(i) })
    }

    @Test(enabled = enabled)
    fun bulkMove() {
        runTest1({ o, l -> TestClient.getMoveList(o, l) }, { i -> TestClient.getMove(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveAilment() {
        runTest1({ o, l -> TestClient.getMoveAilmentList(o, l) }, { i -> TestClient.getMoveAilment(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveBattleStyle() {
        runTest1({ o, l -> TestClient.getMoveBattleStyleList(o, l) }, { i -> TestClient.getMoveBattleStyle(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveCategory() {
        runTest1({ o, l -> TestClient.getMoveCategoryList(o, l) }, { i -> TestClient.getMoveCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveDamageClass() {
        runTest1({ o, l -> TestClient.getMoveDamageClassList(o, l) }, { i -> TestClient.getMoveDamageClass(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveLearnMethod() {
        runTest1({ o, l -> TestClient.getMoveLearnMethodList(o, l) }, { i -> TestClient.getMoveLearnMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveTarget() {
        runTest1({ o, l -> TestClient.getMoveTargetList(o, l) }, { i -> TestClient.getMoveTarget(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocation() {
        runTest1({ o, l -> TestClient.getLocationList(o, l) }, { i -> TestClient.getLocation(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocationArea() {
        runTest1({ o, l -> TestClient.getLocationAreaList(o, l) }, { i -> TestClient.getLocationArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkPalParkArea() {
        runTest1({ o, l -> TestClient.getPalParkAreaList(o, l) }, { i -> TestClient.getPalParkArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkRegion() {
        runTest1({ o, l -> TestClient.getRegionList(o, l) }, { i -> TestClient.getRegion(i) })
    }

    @Test(enabled = enabled)
    fun bulkAbility() {
        runTest1({ o, l -> TestClient.getAbilityList(o, l) }, { i -> TestClient.getAbility(i) })
    }

    @Test(enabled = enabled)
    fun bulkCharacteristic() {
        runTest2({ o, l -> TestClient.getCharacteristicList(o, l) }, { i -> TestClient.getCharacteristic(i) })
    }

    @Test(enabled = enabled)
    fun bulkEggGroup() {
        runTest1({ o, l -> TestClient.getEggGroupList(o, l) }, { i -> TestClient.getEggGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkGender() {
        runTest1({ o, l -> TestClient.getGenderList(o, l) }, { i -> TestClient.getGender(i) })
    }

    @Test(enabled = enabled)
    fun bulkGrowthRate() {
        runTest1({ o, l -> TestClient.getGrowthRateList(o, l) }, { i -> TestClient.getGrowthRate(i) })
    }

    @Test(enabled = enabled)
    fun bulkNature() {
        runTest1({ o, l -> TestClient.getNatureList(o, l) }, { i -> TestClient.getNature(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokeathlonStat() {
        runTest1({ o, l -> TestClient.getPokeathlonStatList(o, l) }, { i -> TestClient.getPokeathlonStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemon() {
        runTest1({ o, l -> TestClient.getPokemonList(o, l) }, { i -> TestClient.getPokemon(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonEncounters() {
        runTest1({ o, l -> TestClient.getPokemonList(o, l) }, { i -> TestClient.getPokemonEncounters(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonColor() {
        runTest1({ o, l -> TestClient.getPokemonColorList(o, l) }, { i -> TestClient.getPokemonColor(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonForm() {
        runTest1({ o, l -> TestClient.getPokemonFormList(o, l) }, { i -> TestClient.getPokemonForm(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonHabitat() {
        runTest1({ o, l -> TestClient.getPokemonHabitatList(o, l) }, { i -> TestClient.getPokemonHabitat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonShape() {
        runTest1({ o, l -> TestClient.getPokemonShapeList(o, l) }, { i -> TestClient.getPokemonShape(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonSpecies() {
        runTest1({ o, l -> TestClient.getPokemonSpeciesList(o, l) }, { i -> TestClient.getPokemonSpecies(i) })
    }

    @Test(enabled = enabled)
    fun bulkStat() {
        runTest1({ o, l -> TestClient.getStatList(o, l) }, { i -> TestClient.getStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkType() {
        runTest1({ o, l -> TestClient.getTypeList(o, l) }, { i -> TestClient.getType(i) })
    }

    @Test(enabled = enabled)
    fun bulkLanguage() {
        runTest1({ o, l -> TestClient.getLanguageList(o, l) }, { i -> TestClient.getLanguage(i) })
    }
}