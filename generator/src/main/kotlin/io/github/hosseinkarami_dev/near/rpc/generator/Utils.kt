package io.github.hosseinkarami_dev.near.rpc.generator

import java.util.Locale


fun toCamelCase(input: String): String {
    val pascal = toPascalCase(input)
    return pascal.replaceFirstChar { it.lowercase(Locale.getDefault()) }
}

fun toPascalCase(input: String): String {
    // normalize separators: any non-alnum -> underscore
    val cleaned = input.replace(Regex("[^A-Za-z0-9]+"), "_")
    val parts = cleaned.split('_').filter { it.isNotEmpty() }


    val transformed = parts.map { part ->
        // special-case EXPERIMENTAL as requested
        if (part.equals("EXPERIMENTAL", ignoreCase = true)) {
            "Experimental"
        } else {
            val hasUpper = part.any { it.isUpperCase() }
            val hasLower = part.any { it.isLowerCase() }

            when {
                // already has internal casing like "JsonRpc" or "httpServer" -> keep internal capitals
                hasUpper && hasLower -> {
                    // ensure first char is uppercase for Pascal
                    part.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                    }
                }
                // all upper (API, ID) or all lower (request) -> normalize to lowercase then uppercase first char
                else -> {
                    val lower = part.lowercase(Locale.getDefault())
                    lower.replaceFirstChar { it.titlecase(Locale.getDefault()) }
                }
            }
        }
    }

    return transformed.joinToString("")
}

fun toEnumConstantName(value: String): String {
    return when {
        //PascalCase or CamelCase
        value.matches(Regex("^[A-Z][a-zA-Z0-9]*$")) || value.matches(Regex("^[a-z][a-zA-Z0-9]*$")) -> {
            value.replace(Regex("([a-z0-9])([A-Z])"), "$1_$2")
                .uppercase(Locale.getDefault())
        }

        else -> {
            var s = value.replace(Regex("[^A-Za-z0-9]+"), "_")
                .replace(Regex("_+"), "_")
                .trim('_')

            if (s.isEmpty()) return "UNKNOWN"

            s = s.uppercase(Locale.getDefault())

            // If starts with digit, prefix underscore
            if (s.first().isDigit()) s = "_$s"
            s
        }
    }
}