package io.github.hosseinkarami_dev.near.rpc.generator.models

data class SealedInfo(
    val packageName: String,
    val className: String,
    val variants: List<VariantInfo>
)