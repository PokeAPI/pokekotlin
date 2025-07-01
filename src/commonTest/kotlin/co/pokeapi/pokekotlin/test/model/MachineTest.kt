package co.pokeapi.pokekotlin.test.model

import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class MachineTest {

  @Test
  fun getMachine() = runTest {
    LocalPokeApi.getMachine(18).apply {
      assertEquals(18, id)
      assertEquals(Handle.of(305, "tm01"), item)
      assertEquals(Handle.of(526, "work-up"), move)
      assertEquals(Handle.of(17, "sun-moon"), versionGroup)
    }
  }
}
