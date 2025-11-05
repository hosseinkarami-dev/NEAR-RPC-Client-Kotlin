package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils

import androidx.annotation.StringRes
import io.github.hosseinkarami_dev.near.rpc.client_app.R

enum class Network(
    val url: String,
    @StringRes val stringResId: Int
) {
    MAINNET("https://rpc.mainnet.near.org", R.string.network_mainnet),
    TESTNET("https://rpc.testnet.near.org", R.string.network_testnet)
}
