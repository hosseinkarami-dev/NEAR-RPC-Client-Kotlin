package io.github.hosseinkarami_dev.near.rpc.generator

data class SealedInfo(
    val packageName: String,
    val className: String,
    val variants: List<VariantInfo>
)