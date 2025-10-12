package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.models.ShardLayout
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ShardLayoutTest {

    private val json = Json { encodeDefaults = true }

    @Test
    fun `test ShardLayout V0 serialization`() {
        val layout: ShardLayout = ShardLayout.V0(
            ShardLayoutV0(
                numShards = 4uL,
                version = 0u
            )
        )

        val serialized = json.encodeToString(layout)
        println("Serialized V0: $serialized")

        val deserialized = json.decodeFromString<ShardLayout>(serialized)
        assertEquals(layout, deserialized)
    }
}