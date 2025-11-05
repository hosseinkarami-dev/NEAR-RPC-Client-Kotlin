package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils

import java.util.Locale

object StringHelper {

    fun String.formatLabel(): String {
        return this.split('_').joinToString(" ") { word ->
            word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    }
}