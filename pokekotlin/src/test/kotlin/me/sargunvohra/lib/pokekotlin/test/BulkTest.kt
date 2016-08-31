package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import me.sargunvohra.lib.pokekotlin.test.util.mockClient
import org.junit.Ignore
import org.junit.Test
import java.util.*
import kotlin.reflect.memberProperties
import kotlin.test.fail

class BulkTest {

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
            print("${i + 1}/$count ($id) ... ")
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

    @Ignore
    @Test
    fun bulkBerry() {
        runTest1({ o, l -> mockClient.getBerryList(o, l) }, { i -> mockClient.getBerry(i) })
    }

    @Ignore
    @Test
    fun bulkBerryFirmness() {
        runTest1({ o, l -> mockClient.getBerryFirmnessList(o, l) }, { i -> mockClient.getBerryFirmness(i) })
    }

    @Ignore
    @Test
    fun bulkBerryFlavor() {
        runTest1({ o, l -> mockClient.getBerryFlavorList(o, l) }, { i -> mockClient.getBerryFlavor(i) })
    }

    @Ignore
    @Test
    fun bulkContestType() {
        runTest1({ o, l -> mockClient.getContestTypeList(o, l) }, { i -> mockClient.getContestType(i) })
    }

    @Ignore
    @Test
    fun bulkContestEffect() {
        runTest2({ o, l -> mockClient.getContestEffectList(o, l) }, { i -> mockClient.getContestEffect(i) })
    }

    @Ignore
    @Test
    fun bulkSuperContestEffect() {
        runTest2({ o, l -> mockClient.getSuperContestEffectList(o, l) }, { i -> mockClient.getSuperContestEffect(i) })
    }

    @Ignore
    @Test
    fun bulkEncounterMethod() {
        runTest1({ o, l -> mockClient.getEncounterMethodList(o, l) }, { i -> mockClient.getEncounterMethod(i) })
    }

    @Ignore
    @Test
    fun bulkEncounterCondition() {
        runTest1({ o, l -> mockClient.getEncounterConditionList(o, l) }, { i -> mockClient.getEncounterCondition(i) })
    }

    @Ignore
    @Test
    fun bulkEncounterConditionValue() {
        runTest1({ o, l -> mockClient.getEncounterConditionValueList(o, l) }, { i -> mockClient.getEncounterConditionValue(i) })
    }

    @Ignore
    @Test
    fun bulkEvolutionChain() {
        runTest2({ o, l -> mockClient.getEvolutionChainList(o, l) }, { i -> mockClient.getEvolutionChain(i) })
    }

    @Ignore
    @Test
    fun bulkEvolutionTrigger() {
        runTest1({ o, l -> mockClient.getEvolutionTriggerList(o, l) }, { i -> mockClient.getEvolutionTrigger(i) })
    }

    @Ignore
    @Test
    fun bulkGeneration() {
        runTest1({ o, l -> mockClient.getGenerationList(o, l) }, { i -> mockClient.getGeneration(i) })
    }

    @Ignore
    @Test
    fun bulkPokedex() {
        runTest1({ o, l -> mockClient.getPokedexList(o, l) }, { i -> mockClient.getPokedex(i) })
    }

    @Ignore
    @Test
    fun bulkVersion() {
        runTest1({ o, l -> mockClient.getVersionList(o, l) }, { i -> mockClient.getVersion(i) })
    }

    @Ignore
    @Test
    fun bulkVersionGroup() {
        runTest1({ o, l -> mockClient.getVersionGroupList(o, l) }, { i -> mockClient.getVersionGroup(i) })
    }

    @Ignore
    @Test
    fun bulkItem() {
        runTest1({ o, l -> mockClient.getItemList(o, l) }, { i -> mockClient.getItem(i) })
    }

    @Ignore
    @Test
    fun bulkItemAttribute() {
        runTest1({ o, l -> mockClient.getItemAttributeList(o, l) }, { i -> mockClient.getItemAttribute(i) })
    }

    @Ignore
    @Test
    fun bulkItemCategory() {
        runTest1({ o, l -> mockClient.getItemCategoryList(o, l) }, { i -> mockClient.getItemCategory(i) })
    }

    @Ignore
    @Test
    fun bulkItemFlingEffect() {
        runTest1({ o, l -> mockClient.getItemFlingEffectList(o, l) }, { i -> mockClient.getItemFlingEffect(i) })
    }

    @Ignore
    @Test
    fun bulkItemPocket() {
        runTest1({ o, l -> mockClient.getItemPocketList(o, l) }, { i -> mockClient.getItemPocket(i) })
    }

    @Ignore
    @Test
    fun bulkMove() {
        runTest1({ o, l -> mockClient.getMoveList(o, l) }, { i -> mockClient.getMove(i) })
    }

    @Ignore
    @Test
    fun bulkMoveAilment() {
        runTest1({ o, l -> mockClient.getMoveAilmentList(o, l) }, { i -> mockClient.getMoveAilment(i) })
    }

    @Ignore
    @Test
    fun bulkMoveBattleStyle() {
        runTest1({ o, l -> mockClient.getMoveBattleStyleList(o, l) }, { i -> mockClient.getMoveBattleStyle(i) })
    }

    @Ignore
    @Test
    fun bulkMoveCategory() {
        runTest1({ o, l -> mockClient.getMoveCategoryList(o, l) }, { i -> mockClient.getMoveCategory(i) })
    }

    @Ignore
    @Test
    fun bulkMoveDamageClass() {
        runTest1({ o, l -> mockClient.getMoveDamageClassList(o, l) }, { i -> mockClient.getMoveDamageClass(i) })
    }

    @Ignore
    @Test
    fun bulkMoveLearnMethod() {
        runTest1({ o, l -> mockClient.getMoveLearnMethodList(o, l) }, { i -> mockClient.getMoveLearnMethod(i) })
    }

    @Ignore
    @Test
    fun bulkMoveTarget() {
        runTest1({ o, l -> mockClient.getMoveTargetList(o, l) }, { i -> mockClient.getMoveTarget(i) })
    }

    @Ignore
    @Test
    fun bulkLocation() {
        runTest1({ o, l -> mockClient.getLocationList(o, l) }, { i -> mockClient.getLocation(i) })
    }

    @Ignore
    @Test
    fun bulkLocationArea() {
        runTest1({ o, l -> mockClient.getLocationAreaList(o, l) }, { i -> mockClient.getLocationArea(i) })
    }

    @Ignore
    @Test
    fun bulkPalParkArea() {
        runTest1({ o, l -> mockClient.getPalParkAreaList(o, l) }, { i -> mockClient.getPalParkArea(i) })
    }

    @Ignore
    @Test
    fun bulkRegion() {
        runTest1({ o, l -> mockClient.getRegionList(o, l) }, { i -> mockClient.getRegion(i) })
    }

    @Ignore
    @Test
    fun bulkAbility() {
        runTest1({ o, l -> mockClient.getAbilityList(o, l) }, { i -> mockClient.getAbility(i) })
    }

    @Ignore
    @Test
    fun bulkCharacteristic() {
        runTest2({ o, l -> mockClient.getCharacteristicList(o, l) }, { i -> mockClient.getCharacteristic(i) })
    }

    @Ignore
    @Test
    fun bulkEggGroup() {
        runTest1({ o, l -> mockClient.getEggGroupList(o, l) }, { i -> mockClient.getEggGroup(i) })
    }

    @Ignore
    @Test
    fun bulkGender() {
        runTest1({ o, l -> mockClient.getGenderList(o, l) }, { i -> mockClient.getGender(i) })
    }

    @Ignore
    @Test
    fun bulkGrowthRate() {
        runTest1({ o, l -> mockClient.getGrowthRateList(o, l) }, { i -> mockClient.getGrowthRate(i) })
    }

    @Ignore
    @Test
    fun bulkNature() {
        runTest1({ o, l -> mockClient.getNatureList(o, l) }, { i -> mockClient.getNature(i) })
    }

    @Ignore
    @Test
    fun bulkPokeathlonStat() {
        runTest1({ o, l -> mockClient.getPokeathlonStatList(o, l) }, { i -> mockClient.getPokeathlonStat(i) })
    }

    @Ignore
    @Test
    fun bulkPokemon() {
        runTest1({ o, l -> mockClient.getPokemonList(o, l) }, { i -> mockClient.getPokemon(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonEncounters() {
        runTest1({ o, l -> mockClient.getPokemonList(o, l) }, { i -> mockClient.getPokemonEncounterList(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonColor() {
        runTest1({ o, l -> mockClient.getPokemonColorList(o, l) }, { i -> mockClient.getPokemonColor(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonForm() {
        runTest1({ o, l -> mockClient.getPokemonFormList(o, l) }, { i -> mockClient.getPokemonForm(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonHabitat() {
        runTest1({ o, l -> mockClient.getPokemonHabitatList(o, l) }, { i -> mockClient.getPokemonHabitat(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonShape() {
        runTest1({ o, l -> mockClient.getPokemonShapeList(o, l) }, { i -> mockClient.getPokemonShape(i) })
    }

    @Ignore
    @Test
    fun bulkPokemonSpecies() {
        runTest1({ o, l -> mockClient.getPokemonSpeciesList(o, l) }, { i -> mockClient.getPokemonSpecies(i) })
    }

    @Ignore
    @Test
    fun bulkStat() {
        runTest1({ o, l -> mockClient.getStatList(o, l) }, { i -> mockClient.getStat(i) })
    }

    @Ignore
    @Test
    fun bulkType() {
        runTest1({ o, l -> mockClient.getTypeList(o, l) }, { i -> mockClient.getType(i) })
    }

    @Ignore
    @Test
    fun bulkLanguage() {
        runTest1({ o, l -> mockClient.getLanguageList(o, l) }, { i -> mockClient.getLanguage(i) })
    }
}