package io.github.hosseinkarami_dev.near.rpc.generator.serializers

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import io.github.hosseinkarami_dev.near.rpc.generator.Schema

object AdditionalPropertiesSerializer : KSerializer<Any?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("AdditionalProperties", PrimitiveKind.STRING)

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Any?) {
        when (value) {
            is Boolean -> encoder.encodeBoolean(value)
            is Schema -> encoder.encodeSerializableValue(Schema.serializer(), value)
            else -> encoder.encodeNull()
        }
    }

    override fun deserialize(decoder: Decoder): Any? {
        val jsonDecoder = decoder as? JsonDecoder
        return jsonDecoder?.decodeJsonElement()?.let { element ->
            when (element) {
                is JsonNull -> null
                is JsonObject -> Json.decodeFromJsonElement<Schema>(element)
                else -> false
            }
        } ?: false
    }
}