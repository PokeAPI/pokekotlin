package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.Serializable

@JsNonWasmExport
@Serializable
public sealed interface Model {
  public val id: Int
}

@JsNonWasmExport
@Serializable
public sealed interface NamedModel : Model {
  public val name: String
}
