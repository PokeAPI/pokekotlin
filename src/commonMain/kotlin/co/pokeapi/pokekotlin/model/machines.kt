package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.Serializable

/**
 * Machines are the representation of items that teach moves to Pokémon. They vary from version to
 * version, so it is not certain that one specific TM or TR works in every game. See:
 * https://pokeapi.co/docs/v2#machines
 *
 * @param id The identifier for this resource.
 * @param item The TM or HM item that corresponds to this machine.
 * @param move The move that is taught by this machine.
 * @param versionGroup The version group that this machine applies to.
 */
@Serializable
@JsNonWasmExport
public data class Machine(
  override val id: Int,
  val item: Handle.Named<Item>,
  val move: Handle.Named<Move>,
  val versionGroup: Handle.Named<VersionGroup>,
) : Model
