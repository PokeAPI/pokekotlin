package me.sargunvohra.lib.pokekotlin.test

import java.util.LinkedList
import kotlin.reflect.full.memberProperties
import kotlin.test.fail
import me.sargunvohra.lib.pokekotlin.model.ApiResourceList
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import org.junit.Ignore
import org.junit.Test

@Ignore
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
            print("$cat ${i + 1}/$count (id=$id) ... ")
            try {
                val o = getObject(id)
                print("deserialized ... ")
                checkNulls(o)
                print("verified nullability!")
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

    @Test
    fun bulkBerry() {
        runTest1(
            { o, l -> MockServer.client.getBerryList(o, l) },
            { i -> MockServer.client.getBerry(i) })
    }

    @Test
    fun bulkBerryFirmness() {
        runTest1(
            { o, l -> MockServer.client.getBerryFirmnessList(o, l) },
            { i -> MockServer.client.getBerryFirmness(i) })
    }

    @Test
    fun bulkBerryFlavor() {
        runTest1(
            { o, l -> MockServer.client.getBerryFlavorList(o, l) },
            { i -> MockServer.client.getBerryFlavor(i) })
    }

    @Test
    fun bulkContestType() {
        runTest1(
            { o, l -> MockServer.client.getContestTypeList(o, l) },
            { i -> MockServer.client.getContestType(i) })
    }

    @Test
    fun bulkContestEffect() {
        runTest2(
            { o, l -> MockServer.client.getContestEffectList(o, l) },
            { i -> MockServer.client.getContestEffect(i) })
    }

    @Test
    fun bulkSuperContestEffect() {
        runTest2(
            { o, l -> MockServer.client.getSuperContestEffectList(o, l) },
            { i -> MockServer.client.getSuperContestEffect(i) })
    }

    @Test
    fun bulkEncounterMethod() {
        runTest1(
            { o, l -> MockServer.client.getEncounterMethodList(o, l) },
            { i -> MockServer.client.getEncounterMethod(i) })
    }

    @Test
    fun bulkEncounterCondition() {
        runTest1(
            { o, l -> MockServer.client.getEncounterConditionList(o, l) },
            { i -> MockServer.client.getEncounterCondition(i) })
    }

    @Test
    fun bulkEncounterConditionValue() {
        runTest1(
            { o, l -> MockServer.client.getEncounterConditionValueList(o, l) },
            { i -> MockServer.client.getEncounterConditionValue(i) }
        )
    }

    @Test
    fun bulkEvolutionChain() {
        runTest2(
            { o, l -> MockServer.client.getEvolutionChainList(o, l) },
            { i -> MockServer.client.getEvolutionChain(i) })
    }

    @Test
    fun bulkEvolutionTrigger() {
        runTest1(
            { o, l -> MockServer.client.getEvolutionTriggerList(o, l) },
            { i -> MockServer.client.getEvolutionTrigger(i) })
    }

    @Test
    fun bulkGeneration() {
        runTest1(
            { o, l -> MockServer.client.getGenerationList(o, l) },
            { i -> MockServer.client.getGeneration(i) })
    }

    @Test
    fun bulkPokedex() {
        runTest1(
            { o, l -> MockServer.client.getPokedexList(o, l) },
            { i -> MockServer.client.getPokedex(i) })
    }

    @Test
    fun bulkVersion() {
        runTest1(
            { o, l -> MockServer.client.getVersionList(o, l) },
            { i -> MockServer.client.getVersion(i) })
    }

    @Test
    fun bulkVersionGroup() {
        runTest1(
            { o, l -> MockServer.client.getVersionGroupList(o, l) },
            { i -> MockServer.client.getVersionGroup(i) })
    }

    @Test
    fun bulkItem() {
        runTest1(
            { o, l -> MockServer.client.getItemList(o, l) },
            { i -> MockServer.client.getItem(i) })
    }

    @Test
    fun bulkItemAttribute() {
        runTest1(
            { o, l -> MockServer.client.getItemAttributeList(o, l) },
            { i -> MockServer.client.getItemAttribute(i) })
    }

    @Test
    fun bulkItemCategory() {
        runTest1(
            { o, l -> MockServer.client.getItemCategoryList(o, l) },
            { i -> MockServer.client.getItemCategory(i) })
    }

    @Test
    fun bulkItemFlingEffect() {
        runTest1(
            { o, l -> MockServer.client.getItemFlingEffectList(o, l) },
            { i -> MockServer.client.getItemFlingEffect(i) })
    }

    @Test
    fun bulkItemPocket() {
        runTest1(
            { o, l -> MockServer.client.getItemPocketList(o, l) },
            { i -> MockServer.client.getItemPocket(i) })
    }

    @Test
    fun bulkMove() {
        runTest1(
            { o, l -> MockServer.client.getMoveList(o, l) },
            { i -> MockServer.client.getMove(i) })
    }

    @Test
    fun bulkMoveAilment() {
        runTest1(
            { o, l -> MockServer.client.getMoveAilmentList(o, l) },
            { i -> MockServer.client.getMoveAilment(i) })
    }

    @Test
    fun bulkMoveBattleStyle() {
        runTest1(
            { o, l -> MockServer.client.getMoveBattleStyleList(o, l) },
            { i -> MockServer.client.getMoveBattleStyle(i) })
    }

    @Test
    fun bulkMoveCategory() {
        runTest1(
            { o, l -> MockServer.client.getMoveCategoryList(o, l) },
            { i -> MockServer.client.getMoveCategory(i) })
    }

    @Test
    fun bulkMoveDamageClass() {
        runTest1(
            { o, l -> MockServer.client.getMoveDamageClassList(o, l) },
            { i -> MockServer.client.getMoveDamageClass(i) })
    }

    @Test
    fun bulkMoveLearnMethod() {
        runTest1(
            { o, l -> MockServer.client.getMoveLearnMethodList(o, l) },
            { i -> MockServer.client.getMoveLearnMethod(i) })
    }

    @Test
    fun bulkMoveTarget() {
        runTest1(
            { o, l -> MockServer.client.getMoveTargetList(o, l) },
            { i -> MockServer.client.getMoveTarget(i) })
    }

    @Test
    fun bulkLocation() {
        runTest1(
            { o, l -> MockServer.client.getLocationList(o, l) },
            { i -> MockServer.client.getLocation(i) })
    }

    @Test
    fun bulkLocationArea() {
        runTest1(
            { o, l -> MockServer.client.getLocationAreaList(o, l) },
            { i -> MockServer.client.getLocationArea(i) })
    }

    @Test
    fun bulkPalParkArea() {
        runTest1(
            { o, l -> MockServer.client.getPalParkAreaList(o, l) },
            { i -> MockServer.client.getPalParkArea(i) })
    }

    @Test
    fun bulkRegion() {
        runTest1(
            { o, l -> MockServer.client.getRegionList(o, l) },
            { i -> MockServer.client.getRegion(i) })
    }

    @Test
    fun bulkAbility() {
        runTest1(
            { o, l -> MockServer.client.getAbilityList(o, l) },
            { i -> MockServer.client.getAbility(i) })
    }

    @Test
    fun bulkCharacteristic() {
        runTest2(
            { o, l -> MockServer.client.getCharacteristicList(o, l) },
            { i -> MockServer.client.getCharacteristic(i) })
    }

    @Test
    fun bulkEggGroup() {
        runTest1(
            { o, l -> MockServer.client.getEggGroupList(o, l) },
            { i -> MockServer.client.getEggGroup(i) })
    }

    @Test
    fun bulkGender() {
        runTest1(
            { o, l -> MockServer.client.getGenderList(o, l) },
            { i -> MockServer.client.getGender(i) })
    }

    @Test
    fun bulkGrowthRate() {
        runTest1(
            { o, l -> MockServer.client.getGrowthRateList(o, l) },
            { i -> MockServer.client.getGrowthRate(i) })
    }

    @Test
    fun bulkNature() {
        runTest1(
            { o, l -> MockServer.client.getNatureList(o, l) },
            { i -> MockServer.client.getNature(i) })
    }

    @Test
    fun bulkPokeathlonStat() {
        runTest1(
            { o, l -> MockServer.client.getPokeathlonStatList(o, l) },
            { i -> MockServer.client.getPokeathlonStat(i) })
    }

    @Test
    fun bulkPokemon() {
        runTest1(
            { o, l -> MockServer.client.getPokemonList(o, l) },
            { i -> MockServer.client.getPokemon(i) })
    }

    @Test
    fun bulkPokemonEncounters() {
        runTest1(
            { o, l -> MockServer.client.getPokemonList(o, l) },
            { i -> MockServer.client.getPokemonEncounterList(i) })
    }

    @Test
    fun bulkPokemonColor() {
        runTest1(
            { o, l -> MockServer.client.getPokemonColorList(o, l) },
            { i -> MockServer.client.getPokemonColor(i) })
    }

    @Test
    fun bulkPokemonForm() {
        runTest1(
            { o, l -> MockServer.client.getPokemonFormList(o, l) },
            { i -> MockServer.client.getPokemonForm(i) })
    }

    @Test
    fun bulkPokemonHabitat() {
        runTest1(
            { o, l -> MockServer.client.getPokemonHabitatList(o, l) },
            { i -> MockServer.client.getPokemonHabitat(i) })
    }

    @Test
    fun bulkPokemonShape() {
        runTest1(
            { o, l -> MockServer.client.getPokemonShapeList(o, l) },
            { i -> MockServer.client.getPokemonShape(i) })
    }

    @Test
    fun bulkPokemonSpecies() {
        runTest1(
            { o, l -> MockServer.client.getPokemonSpeciesList(o, l) },
            { i -> MockServer.client.getPokemonSpecies(i) })
    }

    @Test
    fun bulkStat() {
        runTest1(
            { o, l -> MockServer.client.getStatList(o, l) },
            { i -> MockServer.client.getStat(i) })
    }

    @Test
    fun bulkType() {
        runTest1(
            { o, l -> MockServer.client.getTypeList(o, l) },
            { i -> MockServer.client.getType(i) })
    }

    @Test
    fun bulkLanguage() {
        runTest1(
            { o, l -> MockServer.client.getLanguageList(o, l) },
            { i -> MockServer.client.getLanguage(i) })
    }
}
