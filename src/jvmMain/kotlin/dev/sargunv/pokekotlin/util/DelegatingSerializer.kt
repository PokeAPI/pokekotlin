package dev.sargunv.pokekotlin.util

import kotlin.reflect.KClass
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class DelegatingSerializer<T : Any, D>(
  clazz: KClass<T>,
  private val delegate: KSerializer<D>,
  private val fromDelegate: (D) -> T,
  private val toDelegate: (T) -> D,
) : KSerializer<T> {

  override val descriptor = SerialDescriptor(clazz.qualifiedName!!, delegate.descriptor)

  override fun serialize(encoder: Encoder, value: T) =
    encoder.encodeSerializableValue(delegate, toDelegate(value))

  override fun deserialize(decoder: Decoder): T =
    fromDelegate(decoder.decodeSerializableValue(delegate))
}
