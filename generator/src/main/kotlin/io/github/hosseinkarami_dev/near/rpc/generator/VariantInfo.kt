package io.github.hosseinkarami_dev.near.rpc.generator

data class VariantInfo(
    val name: String,
    val kind: Kind,
    val serialName: String,
    val props: List<PropInfo> = emptyList()
) {
    enum class Kind { OBJECT, DATA_CLASS }
}