package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
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
        runTest1({ o, l -> mockClient.getBerryList(o, l) }, { i -> mockClient.getBerry(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFirmness() {
        runTest1({ o, l -> mockClient.getBerryFirmnessList(o, l) }, { i -> mockClient.getBerryFirmness(i) })
    }

    @Test(enabled = enabled)
    fun bulkBerryFlavor() {
        runTest1({ o, l -> mockClient.getBerryFlavorList(o, l) }, { i -> mockClient.getBerryFlavor(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestType() {
        runTest1({ o, l -> mockClient.getContestTypeList(o, l) }, { i -> mockClient.getContestType(i) })
    }

    @Test(enabled = enabled)
    fun bulkContestEffect() {
        runTest2({ o, l -> mockClient.getContestEffectList(o, l) }, { i -> mockClient.getContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkSuperContestEffect() {
        runTest2({ o, l -> mockClient.getSuperContestEffectList(o, l) }, { i -> mockClient.getSuperContestEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterMethod() {
        runTest1({ o, l -> mockClient.getEncounterMethodList(o, l) }, { i -> mockClient.getEncounterMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterCondition() {
        runTest1({ o, l -> mockClient.getEncounterConditionList(o, l) }, { i -> mockClient.getEncounterCondition(i) })
    }

    @Test(enabled = enabled)
    fun bulkEncounterConditionValue() {
        runTest1({ o, l -> mockClient.getEncounterConditionValueList(o, l) }, { i -> mockClient.getEncounterConditionValue(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionChain() {
        runTest2({ o, l -> mockClient.getEvolutionChainList(o, l) }, { i -> mockClient.getEvolutionChain(i) })
    }

    @Test(enabled = enabled)
    fun bulkEvolutionTrigger() {
        runTest1({ o, l -> mockClient.getEvolutionTriggerList(o, l) }, { i -> mockClient.getEvolutionTrigger(i) })
    }

    @Test(enabled = enabled)
    fun bulkGeneration() {
        runTest1({ o, l -> mockClient.getGenerationList(o, l) }, { i -> mockClient.getGeneration(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokedex() {
        runTest1({ o, l -> mockClient.getPokedexList(o, l) }, { i -> mockClient.getPokedex(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersion() {
        runTest1({ o, l -> mockClient.getVersionList(o, l) }, { i -> mockClient.getVersion(i) })
    }

    @Test(enabled = enabled)
    fun bulkVersionGroup() {
        runTest1({ o, l -> mockClient.getVersionGroupList(o, l) }, { i -> mockClient.getVersionGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkItem() {
        runTest1({ o, l -> mockClient.getItemList(o, l) }, { i -> mockClient.getItem(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemAttribute() {
        runTest1({ o, l -> mockClient.getItemAttributeList(o, l) }, { i -> mockClient.getItemAttribute(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemCategory() {
        runTest1({ o, l -> mockClient.getItemCategoryList(o, l) }, { i -> mockClient.getItemCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemFlingEffect() {
        runTest1({ o, l -> mockClient.getItemFlingEffectList(o, l) }, { i -> mockClient.getItemFlingEffect(i) })
    }

    @Test(enabled = enabled)
    fun bulkItemPocket() {
        runTest1({ o, l -> mockClient.getItemPocketList(o, l) }, { i -> mockClient.getItemPocket(i) })
    }

    @Test(enabled = enabled)
    fun bulkMove() {
        runTest1({ o, l -> mockClient.getMoveList(o, l) }, { i -> mockClient.getMove(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveAilment() {
        runTest1({ o, l -> mockClient.getMoveAilmentList(o, l) }, { i -> mockClient.getMoveAilment(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveBattleStyle() {
        runTest1({ o, l -> mockClient.getMoveBattleStyleList(o, l) }, { i -> mockClient.getMoveBattleStyle(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveCategory() {
        runTest1({ o, l -> mockClient.getMoveCategoryList(o, l) }, { i -> mockClient.getMoveCategory(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveDamageClass() {
        runTest1({ o, l -> mockClient.getMoveDamageClassList(o, l) }, { i -> mockClient.getMoveDamageClass(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveLearnMethod() {
        runTest1({ o, l -> mockClient.getMoveLearnMethodList(o, l) }, { i -> mockClient.getMoveLearnMethod(i) })
    }

    @Test(enabled = enabled)
    fun bulkMoveTarget() {
        runTest1({ o, l -> mockClient.getMoveTargetList(o, l) }, { i -> mockClient.getMoveTarget(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocation() {
        runTest1({ o, l -> mockClient.getLocationList(o, l) }, { i -> mockClient.getLocation(i) })
    }

    @Test(enabled = enabled)
    fun bulkLocationArea() {
        runTest1({ o, l -> mockClient.getLocationAreaList(o, l) }, { i -> mockClient.getLocationArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkPalParkArea() {
        runTest1({ o, l -> mockClient.getPalParkAreaList(o, l) }, { i -> mockClient.getPalParkArea(i) })
    }

    @Test(enabled = enabled)
    fun bulkRegion() {
        runTest1({ o, l -> mockClient.getRegionList(o, l) }, { i -> mockClient.getRegion(i) })
    }

    @Test(enabled = enabled)
    fun bulkAbility() {
        runTest1({ o, l -> mockClient.getAbilityList(o, l) }, { i -> mockClient.getAbility(i) })
    }

    @Test(enabled = enabled)
    fun bulkCharacteristic() {
        runTest2({ o, l -> mockClient.getCharacteristicList(o, l) }, { i -> mockClient.getCharacteristic(i) })
    }

    @Test(enabled = enabled)
    fun bulkEggGroup() {
        runTest1({ o, l -> mockClient.getEggGroupList(o, l) }, { i -> mockClient.getEggGroup(i) })
    }

    @Test(enabled = enabled)
    fun bulkGender() {
        runTest1({ o, l -> mockClient.getGenderList(o, l) }, { i -> mockClient.getGender(i) })
    }

    @Test(enabled = enabled)
    fun bulkGrowthRate() {
        runTest1({ o, l -> mockClient.getGrowthRateList(o, l) }, { i -> mockClient.getGrowthRate(i) })
    }

    @Test(enabled = enabled)
    fun bulkNature() {
        runTest1({ o, l -> mockClient.getNatureList(o, l) }, { i -> mockClient.getNature(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokeathlonStat() {
        runTest1({ o, l -> mockClient.getPokeathlonStatList(o, l) }, { i -> mockClient.getPokeathlonStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemon() {
        runTest1({ o, l -> mockClient.getPokemonList(o, l) }, { i -> mockClient.getPokemon(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonEncounters() {
        runTest1({ o, l -> mockClient.getPokemonList(o, l) }, { i -> mockClient.getPokemonEncounters(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonColor() {
        runTest1({ o, l -> mockClient.getPokemonColorList(o, l) }, { i -> mockClient.getPokemonColor(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonForm() {
        runTest1({ o, l -> mockClient.getPokemonFormList(o, l) }, { i -> mockClient.getPokemonForm(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonHabitat() {
        runTest1({ o, l -> mockClient.getPokemonHabitatList(o, l) }, { i -> mockClient.getPokemonHabitat(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonShape() {
        runTest1({ o, l -> mockClient.getPokemonShapeList(o, l) }, { i -> mockClient.getPokemonShape(i) })
    }

    @Test(enabled = enabled)
    fun bulkPokemonSpecies() {
        runTest1({ o, l -> mockClient.getPokemonSpeciesList(o, l) }, { i -> mockClient.getPokemonSpecies(i) })
    }

    @Test(enabled = enabled)
    fun bulkStat() {
        runTest1({ o, l -> mockClient.getStatList(o, l) }, { i -> mockClient.getStat(i) })
    }

    @Test(enabled = enabled)
    fun bulkType() {
        runTest1({ o, l -> mockClient.getTypeList(o, l) }, { i -> mockClient.getType(i) })
    }

    @Test(enabled = enabled)
    fun bulkLanguage() {
        runTest1({ o, l -> mockClient.getLanguageList(o, l) }, { i -> mockClient.getLanguage(i) })
    }
}