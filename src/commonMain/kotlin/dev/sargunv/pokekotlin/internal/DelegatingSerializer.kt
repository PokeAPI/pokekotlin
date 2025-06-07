package dev.sargunv.pokekotlin.internal

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class DelegatingSerializer<T : Any, D>(
  serialName: String,
  private val delegate: KSerializer<D>,
  private val fromDelegate: (D) -> T,
  private val toDelegate: (T) -> D,
) : KSerializer<T> {

  override val descriptor = SerialDescriptor(serialName, delegate.descriptor)

  override fun serialize(encoder: Encoder, value: T) =
    encoder.encodeSerializableValue(delegate, toDelegate(value))

  override fun deserialize(decoder: Decoder): T =
    fromDelegate(decoder.decodeSerializableValue(delegate))
}
