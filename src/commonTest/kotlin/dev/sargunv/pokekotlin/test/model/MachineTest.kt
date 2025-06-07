package dev.sargunv.pokekotlin.test.model

import dev.sargunv.pokekotlin.model.NamedApiResource
import dev.sargunv.pokekotlin.test.LocalPokeApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class MachineTest {

  @Test
  fun getMachine() = runTest {
    LocalPokeApi.getMachine(18).apply {
      assertEquals(18, id)
      assertEquals(NamedApiResource("tm01", "item", 305), item)
      assertEquals(NamedApiResource("work-up", "move", 526), move)
      assertEquals(NamedApiResource("ultra-sun-ultra-moon", "version-group", 18), versionGroup)
    }
  }
}
