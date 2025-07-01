package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.ResourceHandle
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class MachineTest {

  @Test
  fun getMachine() = runTest {
    LocalPokeApi.getMachine(18).apply {
      assertEquals(18, id)
      assertEquals(ResourceHandle.of(305, "tm01"), item)
      assertEquals(ResourceHandle.of(526, "work-up"), move)
      assertEquals(ResourceHandle.of(17, "sun-moon"), versionGroup)
    }
  }
}
