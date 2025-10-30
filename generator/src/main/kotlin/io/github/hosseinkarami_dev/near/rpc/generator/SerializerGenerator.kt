package io.github.hosseinkarami_dev.near.rpc.generator

import java.io.File
import java.lang.StringBuilder

object SerializerGenerator {
    @JvmStatic
    fun generateFromSealedInfos(
        sealedInfos: List<SealedInfo>,
        serializerPackage: String,
        output: File
    ) {
        if (sealedInfos.isEmpty()) return

        for (info in sealedInfos) {
            try {
                val (fileName, content) = generateSealedClassSerializerContent(info, serializerPackage)
                val packagePath = serializerPackage.replace('.', File.separatorChar)
                val dir = File(output, packagePath)
                if (!dir.exists()) dir.mkdirs()

                val outFile = File(dir, fileName)
                outFile.writeText(content)

            } catch (ex: Exception) {
                System.err.println("Failed generating serializer for ${info.className}: ${ex.message}")
                throw RuntimeException("Generation failed for ${info.className}", ex)
            }
        }
    }

    private fun generateSealedClassSerializerContent(info: SealedInfo, serializerPackage: String): Pair<String, String> {
        val modelsPkg = info.packageName
        val clsName = info.className
        val serializerName = "${clsName}Serializer"
        val fileName = "$serializerName.kt"

        val imports = mutableSetOf<String>().apply {
            add("kotlinx.serialization.KSerializer")
            add("kotlinx.serialization.encoding.Decoder")
            add("kotlinx.serialization.encoding.Encoder")
            add("kotlinx.serialization.descriptors.SerialDescriptor")
            add("kotlinx.serialization.descriptors.buildClassSerialDescriptor")
            add("kotlinx.serialization.json.JsonDecoder")
            add("kotlinx.serialization.json.JsonEncoder")
            add("kotlinx.serialization.json.JsonElement")
            add("kotlinx.serialization.json.JsonObject")
            add("kotlinx.serialization.json.JsonPrimitive")
            add("kotlinx.serialization.json.JsonArray")
            add("kotlinx.serialization.json.jsonPrimitive")
            add("kotlinx.serialization.json.contentOrNull")
            add("kotlinx.serialization.json.jsonArray")
            add("kotlinx.serialization.serializer")
            add("kotlinx.serialization.builtins.ListSerializer")
            add("kotlinx.serialization.builtins.MapSerializer")
            add("kotlinx.serialization.SerializationException")
        }

        val sb = StringBuilder()
        sb.appendLine("package $serializerPackage")
        sb.appendLine()
        imports.sorted().forEach { sb.appendLine("import $it") }
        sb.appendLine("import $modelsPkg.$clsName")
        sb.appendLine("import kotlinx.serialization.json.*")
        sb.appendLine()

        sb.appendLine("object $serializerName : KSerializer<$clsName> {")
        sb.appendLine()
        // descriptor
        sb.appendLine("    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(\"$modelsPkg.$clsName\") {")
        for (v in info.variants) {
            sb.appendLine("        element(\"${v.serialName}\", serializer<JsonElement>().descriptor)")
        }
        sb.appendLine("    }")
        sb.appendLine()

        // serialize
        sb.appendLine("    override fun serialize(encoder: Encoder, value: $clsName) {")
        sb.appendLine("         if (encoder is JsonEncoder) {")
        sb.appendLine("            val jsonEncoder = encoder")
        sb.appendLine("            when (value) {")
        for (v in info.variants) {
            val variantClass = "$modelsPkg.$clsName.${v.name}"
            sb.appendLine("                is $variantClass -> {")
            if (v.kind == VariantInfo.Kind.OBJECT && v.props.isEmpty()) {
                // pure singleton -> primitive string
                sb.appendLine("                    jsonEncoder.encodeJsonElement(JsonPrimitive(\"${v.serialName}\"))")
            } else if (v.props.size == 1 && v.props[0].name == "value") {
                val p = v.props[0]
                val serExpr = serializerExpr(p.type, modelsPkg, clsName, v.name)
                sb.appendLine("                    val innerElem = jsonEncoder.json.encodeToJsonElement($serExpr, value.${p.name})")
                sb.appendLine("                    jsonEncoder.encodeJsonElement(innerElem)")
            } else if (v.kind == VariantInfo.Kind.DATA_CLASS) {
                sb.appendLine("                    val map = mutableMapOf<String, JsonElement>()")
                for (p in v.props) {
                    val serExpr = serializerExpr(p.type, modelsPkg, clsName, v.name)
                    val nullable = p.type.trim().endsWith("?")
                    if (nullable) {
                        sb.appendLine("                    if (value.${p.name} != null) {")
                        sb.appendLine("                        map[\"${p.serialName}\"] = jsonEncoder.json.encodeToJsonElement($serExpr, value.${p.name})")
                        sb.appendLine("                    }")
                    } else {
                        sb.appendLine("                    map[\"${p.serialName}\"] = jsonEncoder.json.encodeToJsonElement($serExpr, value.${p.name})")
                    }
                }
                sb.appendLine("                    val payload = JsonObject(map)")
                sb.appendLine("                    jsonEncoder.encodeJsonElement(payload)")
            } else {
                sb.appendLine("                    jsonEncoder.encodeJsonElement(JsonObject(mapOf()))")
            }
            sb.appendLine("                }")
        }
        sb.appendLine("            }")
        sb.appendLine("            return")
        sb.appendLine("        }")
        sb.appendLine("        val out = encoder.beginStructure(descriptor)")
        sb.appendLine("        when (value) {")
        var idx = 0
        for (v in info.variants) {
            val variantClass = "$modelsPkg.$clsName.${v.name}"
            sb.appendLine("            is $variantClass -> out.encodeSerializableElement(descriptor, $idx, serializer<$variantClass>(), value)")
            idx++
        }
        sb.appendLine("        }")
        sb.appendLine("        out.endStructure(descriptor)")
        sb.appendLine("    }")
        sb.appendLine()

        // deserialize
        sb.appendLine("    override fun deserialize(decoder: Decoder): $clsName {")
        sb.appendLine("        if (decoder is JsonDecoder) {")
        sb.appendLine("            val element = decoder.decodeJsonElement()")
        sb.appendLine("            when (element) {")
        // primitive
        sb.appendLine("                is JsonPrimitive -> {")
        sb.appendLine("                    if (element.isString) {")
        sb.appendLine("                        val s = element.content")
        val objectSingleValueVariants = info.variants.filter { it.kind == VariantInfo.Kind.OBJECT && it.props.size == 1 && it.props[0].name == "value" }
        for (v in objectSingleValueVariants) {
            sb.appendLine("                        if (s == \"${v.serialName}\") return $modelsPkg.$clsName.${v.name}")
        }
        val pureObjectSingletons = info.variants.filter { it.kind == VariantInfo.Kind.OBJECT && it.props.isEmpty() }
        for (v in pureObjectSingletons) {
            sb.appendLine("                        if (s == \"${v.serialName}\") return $modelsPkg.$clsName.${v.name}")
        }
        sb.appendLine("                    }")
        val singleValueVariants = info.variants.filter { it.props.size == 1 && it.props[0].name == "value" }
        for (v in singleValueVariants) {
            val serExpr = serializerExpr(v.props[0].type, modelsPkg, clsName, v.name)
            sb.appendLine("                    try {")
            sb.appendLine("                        val payload = decoder.json.decodeFromJsonElement($serExpr, element)")
            sb.appendLine("                        return $modelsPkg.$clsName.${v.name}(payload)")
            sb.appendLine("                    } catch (_: Exception) { }")
        }
        sb.appendLine("                    throw SerializationException(\"Unknown discriminator (primitive) for $clsName\")")
        sb.appendLine("                }")
        sb.appendLine()
        // array
        sb.appendLine("                is JsonArray -> throw SerializationException(\"Unexpected JSON array while deserializing $clsName\")")
        sb.appendLine()
        // object
        sb.appendLine("                is JsonObject -> {")
        sb.appendLine("                    val jobj = element")
        // unique-key detection for data-class variants
        val dataVariants = info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS }
        if (dataVariants.isNotEmpty()) {
            // compute unique keys at generation time
            val keyToVariants = mutableMapOf<String, MutableList<Int>>()
            val dvList = dataVariants
            dvList.forEachIndexed { i, v -> v.props.forEach { p -> keyToVariants.computeIfAbsent(p.serialName) { mutableListOf() }.add(i) } }
            val uniqueKeyByVariantName = mutableMapOf<String, String?>()
            dvList.forEach { v ->
                val unique = v.props.firstOrNull { p -> keyToVariants[p.serialName]?.size == 1 }?.serialName
                uniqueKeyByVariantName[v.name] = unique
            }
            for ((idxV, v) in dvList.withIndex()) {
                val unique = uniqueKeyByVariantName[v.name]
                if (!unique.isNullOrBlank()) {
                    sb.appendLine("                    if (jobj[\"$unique\"] != null) {")
                    if (v.props.size == 1) {
                        val ser = serializerExpr(v.props[0].type, modelsPkg, clsName, v.name)
                        sb.appendLine("                        return $modelsPkg.$clsName.${v.name}(decoder.json.decodeFromJsonElement($ser, jobj[\"$unique\"]!!))")
                    } else {
                        val ctorArgs = mutableListOf<String>()
                        for (p in v.props) {
                            val ser = serializerExpr(p.type, modelsPkg, clsName, v.name)
                            val varName = "${p.name}Val"
                            if (p.type.trim().endsWith("?")) {
                                sb.appendLine("                        val $varName = jobj[\"${p.serialName}\"]?.let { decoder.json.decodeFromJsonElement($ser, it) }")
                            } else {
                                sb.appendLine("                        val $varName = decoder.json.decodeFromJsonElement($ser, jobj[\"${p.serialName}\"] ?: throw SerializationException(\"Missing field '${p.serialName}' for variant ${v.name}\"))")
                            }
                            ctorArgs.add(varName)
                        }
                        sb.appendLine("                        return $modelsPkg.$clsName.${v.name}(${ctorArgs.joinToString(", ")})")
                    }
                    sb.appendLine("                    }")
                }
            }
        }

        // wrapper-style { "VariantName": payload }
        sb.appendLine("                    if (jobj.size == 1) {")
        sb.appendLine("                        val entry = jobj.entries.first()")
        sb.appendLine("                        val key = entry.key")
        sb.appendLine("                        val valueElem = entry.value")
        sb.appendLine("                        when (key) {")
        val dataOrSingle = info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS || (it.props.size == 1 && it.props[0].name == "value") }
        for (v in dataOrSingle) {
            sb.appendLine("                            \"${v.serialName}\" -> {")
            if (v.props.size == 1 && v.props[0].name == "value") {
                if (v.kind == VariantInfo.Kind.OBJECT) {
                    sb.appendLine("                                if (valueElem is JsonPrimitive && valueElem.isString) {")
                    sb.appendLine("                                    if ((valueElem as JsonPrimitive).content == \"${v.serialName}\") return $modelsPkg.$clsName.${v.name}()")
                    sb.appendLine("                                }")
                }
                val ser = serializerExpr(v.props[0].type, modelsPkg, clsName, v.name)
                sb.appendLine("                                return $modelsPkg.$clsName.${v.name}(decoder.json.decodeFromJsonElement($ser, valueElem))")
            } else {
                sb.appendLine("                                val obj = valueElem as? JsonObject ?: throw SerializationException(\"Expected object payload for variant ${v.serialName}: \" + key)")
                val variantSer = "serializer<${modelsPkg}.${clsName}.${v.name}>()"
                sb.appendLine("                                return decoder.json.decodeFromJsonElement($variantSer, obj)")
            }
            sb.appendLine("                            }")
        }
        for (v in pureObjectSingletons) {
            sb.appendLine("                            \"${v.serialName}\" -> return $modelsPkg.$clsName.${v.name}")
        }
        sb.appendLine("                            else -> throw SerializationException(\"Unknown discriminator key for $clsName: \" + key)")
        sb.appendLine("                        }")
        sb.appendLine("                    }") // end wrapper-style

        // --- dynamic discriminator detection (no hardcode) ---
        val discCandidates = findDiscCandidates(info) // list of candidate field names inferred
        val discListLiteral = if (discCandidates.isEmpty()) "" else discCandidates.joinToString(", ") { "\"$it\"" }
        sb.appendLine("                    var typeField: String? = null")
        if (discCandidates.isNotEmpty()) {
            sb.appendLine("                    val discriminatorCandidates = listOf($discListLiteral)")
            sb.appendLine("                    for (cand in discriminatorCandidates) {")
            sb.appendLine("                        val candElem = jobj[cand]")
            sb.appendLine("                        if (candElem is JsonPrimitive) {")
            sb.appendLine("                            typeField = candElem.contentOrNull")
            sb.appendLine("                            if (typeField != null) break")
            sb.appendLine("                        }")
            sb.appendLine("                    }")
        } else {
            sb.appendLine("                    val discriminatorCandidates = emptyList<String>()")
        }
        sb.appendLine("                    if (typeField == null) {")
        sb.appendLine("                        val knownVariantNames = setOf(${info.variants.joinToString(", ") { "\"${it.serialName}\"" }})")
        sb.appendLine("                        for ((k, v) in jobj.entries) {")
        sb.appendLine("                            if (v is JsonPrimitive && v.isString) {")
        sb.appendLine("                                val s = v.content")
        sb.appendLine("                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }")
        sb.appendLine("                            }")
        sb.appendLine("                        }")
        sb.appendLine("                    }")
        // IMPORTANT CHANGE: Do NOT throw here. proceed to other heuristics even if typeField == null
        sb.appendLine()

        // try exact match first (only if we have typeField)
        sb.appendLine("                    if (typeField != null) {")
        sb.appendLine("                        val tf = typeField.trim()")
        sb.appendLine("                        // try exact match of full variant name first")
        sb.appendLine("                        when (tf) {")
        for (v in info.variants) {
            sb.appendLine("                            \"${v.serialName}\" -> return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj)")
        }
        sb.appendLine("                            else -> { /* fallthrough to grouped handling */ }")
        sb.appendLine("                        }")
        sb.appendLine("                        // grouped handling by tf content (if any)")
        sb.appendLine("                        val tfLower = tf.lowercase()")
        sb.appendLine("                        var chosenGroupKey: String? = null")
        val grouped = info.variants.groupBy { v ->
            val s = v.serialName
            if (s.contains("_by_")) s.substringBefore("_by_") else s
        }
        for (k in grouped.keys) {
            sb.appendLine("                        if (chosenGroupKey == null && (${escapeForStringLiteral(k)}.lowercase() == tfLower || tfLower.contains(${escapeForStringLiteral(k)}.lowercase()) || ${escapeForStringLiteral(k)}.lowercase().contains(tfLower))) { chosenGroupKey = ${escapeForStringLiteral(k)} }")
        }
        sb.appendLine("                        if (chosenGroupKey != null) {")
        sb.appendLine("                            when (chosenGroupKey) {")
        for ((groupKey, variantsInGroup) in grouped) {
            sb.appendLine("                                ${escapeForStringLiteral(groupKey)} -> {")
            val byBlock = variantsInGroup.filter { it.serialName.endsWith("_by_block_id") }
            val byFinality = variantsInGroup.filter { it.serialName.endsWith("_by_finality") }
            val bySync = variantsInGroup.filter { it.serialName.endsWith("_by_sync_checkpoint") }
            if (byBlock.isNotEmpty()) {
                sb.appendLine("                                    if (jobj[\"block_id\"] != null) {")
                for (v in byBlock) {
                    sb.appendLine("                                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                                    }")
            }
            if (byFinality.isNotEmpty()) {
                sb.appendLine("                                    if (jobj[\"finality\"] != null) {")
                for (v in byFinality) {
                    sb.appendLine("                                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                                    }")
            }
            if (bySync.isNotEmpty()) {
                sb.appendLine("                                    if (jobj[\"sync_checkpoint\"] != null) {")
                for (v in bySync) {
                    sb.appendLine("                                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                                    }")
            }
            for (v in variantsInGroup) {
                sb.appendLine("                                    try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
            }
            sb.appendLine("                                    throw SerializationException(\"Cannot disambiguate variant for base token '${groupKey}' and tf='\$tf'\")")
            sb.appendLine("                                }")
        }
        sb.appendLine("                                else -> { /* no group matched */ }")
        sb.appendLine("                            }")
        sb.appendLine("                        }")
        sb.appendLine("                    }") // end if typeField != null

        // If we reached here (either no typeField or typeField handling didn't return), continue with heuristics:

        // Grouped handling by presence of distinguishing keys (even without tf)
        sb.appendLine("                    // grouped handling by presence of distinguishing keys (no discriminator value available)")
        for ((groupKey, variantsInGroup) in grouped) {
            sb.appendLine("                    // group: ${groupKey}")
            val byBlock = variantsInGroup.filter { it.serialName.endsWith("_by_block_id") }
            val byFinality = variantsInGroup.filter { it.serialName.endsWith("_by_finality") }
            val bySync = variantsInGroup.filter { it.serialName.endsWith("_by_sync_checkpoint") }
            if (byBlock.isNotEmpty()) {
                sb.appendLine("                    if (jobj[\"block_id\"] != null) {")
                for (v in byBlock) {
                    sb.appendLine("                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                    }")
            }
            if (byFinality.isNotEmpty()) {
                sb.appendLine("                    if (jobj[\"finality\"] != null) {")
                for (v in byFinality) {
                    sb.appendLine("                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                    }")
            }
            if (bySync.isNotEmpty()) {
                sb.appendLine("                    if (jobj[\"sync_checkpoint\"] != null) {")
                for (v in bySync) {
                    sb.appendLine("                        try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
                }
                sb.appendLine("                    }")
            }
        }
        sb.appendLine()

        // fallback: required-field matching
        sb.appendLine("                    val requiredMatches = mutableListOf<Int>()")
        for ((idxV, v) in info.variants.withIndex()) {
            val requiredProps = v.props.filter { !it.type.trim().endsWith("?") }.map { it.serialName }
            if (requiredProps.isNotEmpty()) {
                val cond = requiredProps.joinToString(" && ") { "jobj.containsKey(\"$it\")" }
                sb.appendLine("                    if ($cond) requiredMatches.add($idxV)")
            }
        }
        sb.appendLine("                    if (requiredMatches.size == 1) {")
        sb.appendLine("                        when (requiredMatches[0]) {")
        for ((idxV, _) in info.variants.withIndex()) {
            sb.appendLine("                            $idxV -> return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${info.variants[idxV].name}>(), jobj)")
        }
        sb.appendLine("                            else -> throw SerializationException(\"Internal required-match dispatch error\")")
        sb.appendLine("                        }")
        sb.appendLine("                    }")

        // scoring by matched properties
        sb.appendLine("                    var bestIdx: Int? = null")
        sb.appendLine("                    var bestScore = -1.0")
        for ((idxV, v) in info.variants.withIndex()) {
            val propsCount = v.props.size
            if (propsCount == 0) {
                sb.appendLine("                    if (bestScore < 0.0) { bestScore = 0.0; bestIdx = $idxV }")
            } else {
                sb.appendLine("                    run {")
                sb.appendLine("                        var matchCount = 0")
                for (p in v.props) {
                    sb.appendLine("                        if (jobj[\"${p.serialName}\"] != null) matchCount++")
                }
                sb.appendLine("                        val score = matchCount.toDouble() / $propsCount.toDouble()")
                sb.appendLine("                        if (score > bestScore) { bestScore = score; bestIdx = $idxV } else if (score == bestScore) { bestIdx = null }")
                sb.appendLine("                    }")
            }
        }
        sb.appendLine("                    if (bestIdx != null && bestScore > 0.0) {")
        sb.appendLine("                        when (bestIdx) {")
        for ((idxV, _) in info.variants.withIndex()) {
            sb.appendLine("                            $idxV -> return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${info.variants[idxV].name}>(), jobj)")
        }
        sb.appendLine("                            else -> throw SerializationException(\"Internal scoring dispatch error\")")
        sb.appendLine("                        }")
        sb.appendLine("                    }")

        // try decode each candidate variant as last resort
        val dataVariantsList = info.variants.filter { it.kind == VariantInfo.Kind.DATA_CLASS || (it.props.size == 1 && it.props[0].name == "value") }
        for (v in dataVariantsList) {
            sb.appendLine("                    try { return decoder.json.decodeFromJsonElement(serializer<${modelsPkg}.${clsName}.${v.name}>(), jobj) } catch (_: Exception) { }")
        }

        sb.appendLine("                    throw SerializationException(\"Missing discriminator or recognizable variant in $clsName\")")

        sb.appendLine("                }") // end JsonObject
        sb.appendLine("            }") // end when (element)
        sb.appendLine("        }") // end if decoder is JsonDecoder
        sb.appendLine("        throw SerializationException(\"Cannot deserialize $clsName with non-JSON decoder\")")
        sb.appendLine("    }")
        sb.appendLine("}") // end object

        val content = sb.toString()
        return Pair(fileName, content)
    }

    // infer discriminator candidates from the variants' properties
    private fun findDiscCandidates(info: SealedInfo): List<String> {
        val n = info.variants.size
        if (n == 0) return emptyList()

        val freq = mutableMapOf<String, Int>()
        val stringLike = setOf("String", "kotlin.String")
        for (v in info.variants) {
            for (p in v.props) {
                val raw = sanitizeType(p.type)
                val isString = stringLike.any { it.equals(raw, ignoreCase = true) }
                val isEnumLike = raw.endsWith("Enum") || raw.contains("Enum") || raw.matches(Regex("^[A-Z][A-Za-z0-9_]*\$"))
                val isSimpleToken = raw.matches(Regex("^[A-Za-z_][A-Za-z0-9_]*\$"))
                // prefer explicit names that look like discriminators
                if (isString || isEnumLike || isSimpleToken) {
                    // ignore common noise names that are often not discriminators
                    if (p.serialName.equals("message", ignoreCase = true) || p.serialName.equals("error", ignoreCase = true)) continue
                    freq[p.serialName] = (freq[p.serialName] ?: 0) + 1
                }
            }
        }
        if (freq.isEmpty()) return emptyList()
        // threshold: at least half of variants (rounded up)
        val threshold = (n + 1) / 2
        val candidates = freq.filter { it.value >= threshold }.keys.toList()
        // if none reached threshold, still return top-1 candidate (best-effort)
        return if (candidates.isEmpty()) {
            freq.entries.sortedByDescending { it.value }.take(1).map { it.key }
        } else candidates
    }

    // produce serializer expression string for embedding in generated code
    private fun serializerExpr(typeStr: String?, modelsPkg: String, clsName: String, ownerVariant: String?): String {
        val raw = sanitizeType(typeStr)
        val isNullable = (typeStr ?: "").trim().endsWith("?")
        val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
        val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")
        listRegex.matchEntire(raw)?.let { m ->
            val inner = m.groups[1]!!.value
            val innerExpr = serializerExpr(inner, modelsPkg, clsName, ownerVariant)
            return if (isNullable) "serializer<kotlin.collections.List<${fqType(inner, modelsPkg, clsName, ownerVariant)}>?>()" else "ListSerializer($innerExpr)"
        }
        mapRegex.matchEntire(raw)?.let { m ->
            val k = m.groups[1]!!.value
            val v = m.groups[2]!!.value
            val ks = serializerExpr(k, modelsPkg, clsName, ownerVariant)
            val vs = serializerExpr(v, modelsPkg, clsName, ownerVariant)
            return if (isNullable) "serializer<kotlin.collections.Map<${fqType(k, modelsPkg, clsName, ownerVariant)}, ${fqType(v, modelsPkg, clsName, ownerVariant)}>?>()" else "MapSerializer($ks, $vs)"
        }
        val primitives = mapOf(
            "String" to "kotlin.String",
            "Int" to "kotlin.Int",
            "Long" to "kotlin.Long",
            "Double" to "kotlin.Double",
            "Float" to "kotlin.Float",
            "Boolean" to "kotlin.Boolean",
            "Byte" to "kotlin.Byte",
            "Short" to "kotlin.Short",
            "Char" to "kotlin.Char",
            "Any" to "kotlin.Any"
        )
        if (primitives.containsKey(raw)) {
            val t = primitives[raw]!!
            return "serializer<${t}${if (isNullable) "?" else ""}>()"
        }
        if (raw.contains('.')) {
            return "serializer<${raw}${if (isNullable) "?" else ""}>()"
        }
        if (!ownerVariant.isNullOrBlank()) {
            val nested = "${modelsPkg}.${clsName}.${ownerVariant}.${raw}"
            return "serializer<${nested}${if (isNullable) "?" else ""}>()"
        }
        val cn = "${modelsPkg}.${raw}"
        return "serializer<${cn}${if (isNullable) "?" else ""}>()"
    }

    private fun fqType(typeStr: String?, modelsPkg: String, clsName: String, ownerVariant: String?): String {
        val raw = sanitizeType(typeStr)
        val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
        val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")
        listRegex.matchEntire(raw)?.let { m ->
            val inner = fqType(m.groups[1]!!.value, modelsPkg, clsName, ownerVariant)
            return "kotlin.collections.List<$inner>"
        }
        mapRegex.matchEntire(raw)?.let { m ->
            val k = fqType(m.groups[1]!!.value, modelsPkg, clsName, ownerVariant)
            val v = fqType(m.groups[2]!!.value, modelsPkg, clsName, ownerVariant)
            return "kotlin.collections.Map<$k, $v>"
        }
        val primitives = setOf("String","Int","Long","Double","Float","Boolean","Byte","Short","Char","Any")
        if (primitives.contains(raw)) return "kotlin.$raw"
        if (raw.contains('.')) return raw
        if (!ownerVariant.isNullOrBlank()) {
            return "${modelsPkg}.${clsName}.${ownerVariant}.${raw}"
        }
        return "${modelsPkg}.${raw}"
    }

    private fun sanitizeType(raw: String?): String {
        if (raw == null) return ""
        var s = raw.trim()
        val eqIndex = s.indexOf('=')
        if (eqIndex >= 0) s = s.substring(0, eqIndex).trimEnd()
        s = s.trimEnd { it == ',' || it == ')' || it == ']' }
        while (s.endsWith("?")) s = s.dropLast(1).trimEnd()
        if (s.startsWith("`") && s.endsWith("`") && s.length > 1) s = s.substring(1, s.length - 1)
        return s.trim()
    }

    private fun escapeForStringLiteral(s: String): String {
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\""
    }
}
