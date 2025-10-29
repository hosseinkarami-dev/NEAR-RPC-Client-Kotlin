package io.github.hosseinkarami_dev.near.rpc.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.VMKind
import kotlinx.serialization.json.*

object VMKindSerializer : KSerializer<VMKind> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.VMKind") {
        element("Wasmer0", serializer<JsonElement>().descriptor)
        element("Wasmtime", serializer<JsonElement>().descriptor)
        element("Wasmer2", serializer<JsonElement>().descriptor)
        element("NearVm", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: VMKind) {
        if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0 -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmer0"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmtime"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2 -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("Wasmer2"))
                }
                is io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm -> {
                    jsonEncoder.encodeJsonElement(JsonPrimitive("NearVm"))
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0 -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2 -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): VMKind {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                        if (s == "Wasmer0") return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0
                        if (s == "Wasmtime") return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime
                        if (s == "Wasmer2") return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2
                        if (s == "NearVm") return io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm
                    }
                    throw SerializationException("Unknown discriminator (primitive) for VMKind")
                }
                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing VMKind")
                is JsonObject -> {
                    val jobj = element
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        when (key) {
                            "Wasmer0" -> return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0
                            "Wasmtime" -> return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime
                            "Wasmer2" -> return io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2
                            "NearVm" -> return io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm
                            else -> throw SerializationException("Unknown discriminator key for VMKind: " + key)
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("changes_type")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
                    if (typeField == null) {
                        val knownVariantNames = setOf("Wasmer0", "Wasmtime", "Wasmer2", "NearVm")
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }
                    if (typeField == null) throw SerializationException("Missing discriminator (one of changes_type) or recognizable variant in VMKind")
                    val tf = typeField.trim()

                    // try exact match of full variant name first
                    val tfFull = tf
                    when (tfFull) {
                        "Wasmer0" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>(), jobj)
                        "Wasmtime" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>(), jobj)
                        "Wasmer2" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>(), jobj)
                        "NearVm" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>(), jobj)
                        else -> { /* fallthrough to grouped handling */ }
                    }

                    // grouped handling by base token (e.g. account_changes -> ...by_block_id / ...by_finality / ...by_sync_checkpoint)
                    val tfLower = tf.lowercase()
                    // select candidate group based on contains/equals heuristics
                    var chosenGroupKey: String? = null
                    if (chosenGroupKey == null && ("Wasmer0".lowercase() == tfLower || tfLower.contains("Wasmer0".lowercase()) || "Wasmer0".lowercase().contains(tfLower))) { chosenGroupKey = "Wasmer0" }
                    if (chosenGroupKey == null && ("Wasmtime".lowercase() == tfLower || tfLower.contains("Wasmtime".lowercase()) || "Wasmtime".lowercase().contains(tfLower))) { chosenGroupKey = "Wasmtime" }
                    if (chosenGroupKey == null && ("Wasmer2".lowercase() == tfLower || tfLower.contains("Wasmer2".lowercase()) || "Wasmer2".lowercase().contains(tfLower))) { chosenGroupKey = "Wasmer2" }
                    if (chosenGroupKey == null && ("NearVm".lowercase() == tfLower || tfLower.contains("NearVm".lowercase()) || "NearVm".lowercase().contains(tfLower))) { chosenGroupKey = "NearVm" }
                    if (chosenGroupKey != null) {
                        when (chosenGroupKey) {
                            "Wasmer0" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'Wasmer0' and tf='$tf'")
                            }
                            "Wasmtime" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'Wasmtime' and tf='$tf'")
                            }
                            "Wasmer2" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'Wasmer2' and tf='$tf'")
                            }
                            "NearVm" -> {
                                try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>(), jobj) } catch (_: Exception) { }
                                throw SerializationException("Cannot disambiguate variant for base token 'NearVm' and tf='$tf'")
                            }
                            else -> { /* no group matched */ }
                        }
                    }

                    // fallback: try required-field matching and scoring heuristics
                    val requiredMatches = mutableListOf<Int>()
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 0 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 1 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 2 }
                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = 3 }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    // last resort: try decoding each data-class variant
                    throw SerializationException("Missing discriminator or recognizable variant in VMKind")
                }
            }
        }
        throw SerializationException("Cannot deserialize VMKind with non-JSON decoder")
    }
}
