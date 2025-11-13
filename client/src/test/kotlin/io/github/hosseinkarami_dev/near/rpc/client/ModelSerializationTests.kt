package io.github.hosseinkarami_dev.near.rpc.client

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.io.File

/**
 * Generated model (de)serialization tests.
 * For each schema we try to load `src/test/resources/mock/<SchemaName>.json`
 * If the file does not exist the test will fail and indicate which file is missing
 */
class ModelSerializationTests {

    private val json = Json { ignoreUnknownKeys = true }

    private fun loadMockJson(filename: String): String? {
        val f = File("src/test/resources/mock/$filename")
        return if (f.exists()) f.readText() else null
    }

    @Test
    fun testAccessKeyEncodeDecode() {
        val data = loadMockJson("AccessKey.json")
        assertNotNull(data, "Mock file AccessKey.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKey.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKey.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKey.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKey: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyCreationConfigViewEncodeDecode() {
        val data = loadMockJson("AccessKeyCreationConfigView.json")
        assertNotNull(data, "Mock file AccessKeyCreationConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyCreationConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyCreationConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyCreationConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyCreationConfigView: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyInfoViewEncodeDecode() {
        val data = loadMockJson("AccessKeyInfoView.json")
        assertNotNull(data, "Mock file AccessKeyInfoView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyInfoView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyInfoView: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyListEncodeDecode() {
        val data = loadMockJson("AccessKeyList.json")
        assertNotNull(data, "Mock file AccessKeyList.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyList.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyList.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyList.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyList: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyPermissionEncodeDecode() {
        val data = loadMockJson("AccessKeyPermission.json")
        assertNotNull(data, "Mock file AccessKeyPermission.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyPermission: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyPermissionViewEncodeDecode() {
        val data = loadMockJson("AccessKeyPermissionView.json")
        assertNotNull(data, "Mock file AccessKeyPermissionView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyPermissionView: ${e.message}")
        }
    }

    @Test
    fun testAccessKeyViewEncodeDecode() {
        val data = loadMockJson("AccessKeyView.json")
        assertNotNull(data, "Mock file AccessKeyView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccessKeyView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccessKeyView: ${e.message}")
        }
    }

    @Test
    fun testAccountCreationConfigViewEncodeDecode() {
        val data = loadMockJson("AccountCreationConfigView.json")
        assertNotNull(data, "Mock file AccountCreationConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountCreationConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountCreationConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountCreationConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountCreationConfigView: ${e.message}")
        }
    }

    @Test
    fun testAccountDataViewEncodeDecode() {
        val data = loadMockJson("AccountDataView.json")
        assertNotNull(data, "Mock file AccountDataView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountDataView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountDataView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountDataView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountDataView: ${e.message}")
        }
    }

    @Test
    fun testAccountIdEncodeDecode() {
        val data = loadMockJson("AccountId.json")
        assertNotNull(data, "Mock file AccountId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountId: ${e.message}")
        }
    }

    @Test
    fun testAccountIdValidityRulesVersionEncodeDecode() {
        val data = loadMockJson("AccountIdValidityRulesVersion.json")
        assertNotNull(data, "Mock file AccountIdValidityRulesVersion.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountIdValidityRulesVersion.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountIdValidityRulesVersion.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountIdValidityRulesVersion.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountIdValidityRulesVersion: ${e.message}")
        }
    }

    @Test
    fun testAccountInfoEncodeDecode() {
        val data = loadMockJson("AccountInfo.json")
        assertNotNull(data, "Mock file AccountInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountInfo: ${e.message}")
        }
    }

    @Test
    fun testAccountViewEncodeDecode() {
        val data = loadMockJson("AccountView.json")
        assertNotNull(data, "Mock file AccountView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountView: ${e.message}")
        }
    }

    @Test
    fun testAccountWithPublicKeyEncodeDecode() {
        val data = loadMockJson("AccountWithPublicKey.json")
        assertNotNull(data, "Mock file AccountWithPublicKey.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AccountWithPublicKey.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AccountWithPublicKey: ${e.message}")
        }
    }

    @Test
    fun testActionCreationConfigViewEncodeDecode() {
        val data = loadMockJson("ActionCreationConfigView.json")
        assertNotNull(data, "Mock file ActionCreationConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionCreationConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ActionCreationConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionCreationConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ActionCreationConfigView: ${e.message}")
        }
    }

    @Test
    fun testActionErrorEncodeDecode() {
        val data = loadMockJson("ActionError.json")
        assertNotNull(data, "Mock file ActionError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ActionError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ActionError: ${e.message}")
        }
    }

    @Test
    fun testActionErrorKindEncodeDecode() {
        val data = loadMockJson("ActionErrorKind.json")
        assertNotNull(data, "Mock file ActionErrorKind.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionErrorKind.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ActionErrorKind: ${e.message}")
        }
    }

    @Test
    fun testActionViewEncodeDecode() {
        val data = loadMockJson("ActionView.json")
        assertNotNull(data, "Mock file ActionView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ActionView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ActionView: ${e.message}")
        }
    }

    @Test
    fun testActionsValidationErrorEncodeDecode() {
        val data = loadMockJson("ActionsValidationError.json")
        assertNotNull(data, "Mock file ActionsValidationError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ActionsValidationError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ActionsValidationError: ${e.message}")
        }
    }

    @Test
    fun testAddKeyActionEncodeDecode() {
        val data = loadMockJson("AddKeyAction.json")
        assertNotNull(data, "Mock file AddKeyAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.AddKeyAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for AddKeyAction: ${e.message}")
        }
    }

    @Test
    fun testBandwidthRequestEncodeDecode() {
        val data = loadMockJson("BandwidthRequest.json")
        assertNotNull(data, "Mock file BandwidthRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BandwidthRequest: ${e.message}")
        }
    }

    @Test
    fun testBandwidthRequestBitmapEncodeDecode() {
        val data = loadMockJson("BandwidthRequestBitmap.json")
        assertNotNull(data, "Mock file BandwidthRequestBitmap.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestBitmap.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestBitmap.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestBitmap.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BandwidthRequestBitmap: ${e.message}")
        }
    }

    @Test
    fun testBandwidthRequestsEncodeDecode() {
        val data = loadMockJson("BandwidthRequests.json")
        assertNotNull(data, "Mock file BandwidthRequests.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequests.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequests.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequests.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BandwidthRequests: ${e.message}")
        }
    }

    @Test
    fun testBandwidthRequestsV1EncodeDecode() {
        val data = loadMockJson("BandwidthRequestsV1.json")
        assertNotNull(data, "Mock file BandwidthRequestsV1.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestsV1.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestsV1.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BandwidthRequestsV1.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BandwidthRequestsV1: ${e.message}")
        }
    }

    @Test
    fun testBlockHeaderInnerLiteViewEncodeDecode() {
        val data = loadMockJson("BlockHeaderInnerLiteView.json")
        assertNotNull(data, "Mock file BlockHeaderInnerLiteView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderInnerLiteView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BlockHeaderInnerLiteView: ${e.message}")
        }
    }

    @Test
    fun testBlockHeaderViewEncodeDecode() {
        val data = loadMockJson("BlockHeaderView.json")
        assertNotNull(data, "Mock file BlockHeaderView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockHeaderView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BlockHeaderView: ${e.message}")
        }
    }

    @Test
    fun testBlockIdEncodeDecode() {
        val data = loadMockJson("BlockId.json")
        assertNotNull(data, "Mock file BlockId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BlockId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BlockId: ${e.message}")
        }
    }

    @Test
    fun testBlockStatusViewEncodeDecode() {
        val data = loadMockJson("BlockStatusView.json")
        assertNotNull(data, "Mock file BlockStatusView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockStatusView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.BlockStatusView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.BlockStatusView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for BlockStatusView: ${e.message}")
        }
    }

    @Test
    fun testCallResultEncodeDecode() {
        val data = loadMockJson("CallResult.json")
        assertNotNull(data, "Mock file CallResult.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CallResult.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CallResult.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CallResult.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CallResult: ${e.message}")
        }
    }

    @Test
    fun testCatchupStatusViewEncodeDecode() {
        val data = loadMockJson("CatchupStatusView.json")
        assertNotNull(data, "Mock file CatchupStatusView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CatchupStatusView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CatchupStatusView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CatchupStatusView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CatchupStatusView: ${e.message}")
        }
    }

    @Test
    fun testChunkDistributionNetworkConfigEncodeDecode() {
        val data = loadMockJson("ChunkDistributionNetworkConfig.json")
        assertNotNull(data, "Mock file ChunkDistributionNetworkConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionNetworkConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionNetworkConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionNetworkConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ChunkDistributionNetworkConfig: ${e.message}")
        }
    }

    @Test
    fun testChunkDistributionUrisEncodeDecode() {
        val data = loadMockJson("ChunkDistributionUris.json")
        assertNotNull(data, "Mock file ChunkDistributionUris.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionUris.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionUris.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkDistributionUris.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ChunkDistributionUris: ${e.message}")
        }
    }

    @Test
    fun testChunkHeaderViewEncodeDecode() {
        val data = loadMockJson("ChunkHeaderView.json")
        assertNotNull(data, "Mock file ChunkHeaderView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkHeaderView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ChunkHeaderView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ChunkHeaderView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ChunkHeaderView: ${e.message}")
        }
    }

    @Test
    fun testCloudArchivalWriterConfigEncodeDecode() {
        val data = loadMockJson("CloudArchivalWriterConfig.json")
        assertNotNull(data, "Mock file CloudArchivalWriterConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CloudArchivalWriterConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CloudArchivalWriterConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CloudArchivalWriterConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CloudArchivalWriterConfig: ${e.message}")
        }
    }

    @Test
    fun testCompilationErrorEncodeDecode() {
        val data = loadMockJson("CompilationError.json")
        assertNotNull(data, "Mock file CompilationError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CompilationError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CompilationError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CompilationError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CompilationError: ${e.message}")
        }
    }

    @Test
    fun testCongestionControlConfigViewEncodeDecode() {
        val data = loadMockJson("CongestionControlConfigView.json")
        assertNotNull(data, "Mock file CongestionControlConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CongestionControlConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CongestionControlConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CongestionControlConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CongestionControlConfigView: ${e.message}")
        }
    }

    @Test
    fun testCongestionInfoViewEncodeDecode() {
        val data = loadMockJson("CongestionInfoView.json")
        assertNotNull(data, "Mock file CongestionInfoView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CongestionInfoView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CongestionInfoView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CongestionInfoView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CongestionInfoView: ${e.message}")
        }
    }

    @Test
    fun testContractCodeViewEncodeDecode() {
        val data = loadMockJson("ContractCodeView.json")
        assertNotNull(data, "Mock file ContractCodeView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ContractCodeView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ContractCodeView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ContractCodeView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ContractCodeView: ${e.message}")
        }
    }

    @Test
    fun testCostGasUsedEncodeDecode() {
        val data = loadMockJson("CostGasUsed.json")
        assertNotNull(data, "Mock file CostGasUsed.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CostGasUsed.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CostGasUsed.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CostGasUsed.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CostGasUsed: ${e.message}")
        }
    }

    @Test
    fun testCreateAccountActionEncodeDecode() {
        val data = loadMockJson("CreateAccountAction.json")
        assertNotNull(data, "Mock file CreateAccountAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CreateAccountAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CreateAccountAction: ${e.message}")
        }
    }

    @Test
    fun testCryptoHashEncodeDecode() {
        val data = loadMockJson("CryptoHash.json")
        assertNotNull(data, "Mock file CryptoHash.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CryptoHash.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CryptoHash.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CryptoHash.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CryptoHash: ${e.message}")
        }
    }

    @Test
    fun testCurrentEpochValidatorInfoEncodeDecode() {
        val data = loadMockJson("CurrentEpochValidatorInfo.json")
        assertNotNull(data, "Mock file CurrentEpochValidatorInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CurrentEpochValidatorInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.CurrentEpochValidatorInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.CurrentEpochValidatorInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for CurrentEpochValidatorInfo: ${e.message}")
        }
    }

    @Test
    fun testDataReceiptCreationConfigViewEncodeDecode() {
        val data = loadMockJson("DataReceiptCreationConfigView.json")
        assertNotNull(data, "Mock file DataReceiptCreationConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiptCreationConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiptCreationConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiptCreationConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DataReceiptCreationConfigView: ${e.message}")
        }
    }

    @Test
    fun testDataReceiverViewEncodeDecode() {
        val data = loadMockJson("DataReceiverView.json")
        assertNotNull(data, "Mock file DataReceiverView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiverView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiverView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DataReceiverView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DataReceiverView: ${e.message}")
        }
    }

    @Test
    fun testDelegateActionEncodeDecode() {
        val data = loadMockJson("DelegateAction.json")
        assertNotNull(data, "Mock file DelegateAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DelegateAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DelegateAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DelegateAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DelegateAction: ${e.message}")
        }
    }

    @Test
    fun testDeleteAccountActionEncodeDecode() {
        val data = loadMockJson("DeleteAccountAction.json")
        assertNotNull(data, "Mock file DeleteAccountAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeleteAccountAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeleteAccountAction: ${e.message}")
        }
    }

    @Test
    fun testDeleteKeyActionEncodeDecode() {
        val data = loadMockJson("DeleteKeyAction.json")
        assertNotNull(data, "Mock file DeleteKeyAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeleteKeyAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeleteKeyAction: ${e.message}")
        }
    }

    @Test
    fun testDeployContractActionEncodeDecode() {
        val data = loadMockJson("DeployContractAction.json")
        assertNotNull(data, "Mock file DeployContractAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeployContractAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeployContractAction: ${e.message}")
        }
    }

    @Test
    fun testDeployGlobalContractActionEncodeDecode() {
        val data = loadMockJson("DeployGlobalContractAction.json")
        assertNotNull(data, "Mock file DeployGlobalContractAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeployGlobalContractAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeployGlobalContractAction: ${e.message}")
        }
    }

    @Test
    fun testDetailedDebugStatusEncodeDecode() {
        val data = loadMockJson("DetailedDebugStatus.json")
        assertNotNull(data, "Mock file DetailedDebugStatus.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DetailedDebugStatus.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DetailedDebugStatus.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DetailedDebugStatus.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DetailedDebugStatus: ${e.message}")
        }
    }

    @Test
    fun testDeterministicAccountStateInitEncodeDecode() {
        val data = loadMockJson("DeterministicAccountStateInit.json")
        assertNotNull(data, "Mock file DeterministicAccountStateInit.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInit.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInit.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInit.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeterministicAccountStateInit: ${e.message}")
        }
    }

    @Test
    fun testDeterministicAccountStateInitV1EncodeDecode() {
        val data = loadMockJson("DeterministicAccountStateInitV1.json")
        assertNotNull(data, "Mock file DeterministicAccountStateInitV1.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInitV1.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInitV1.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicAccountStateInitV1.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeterministicAccountStateInitV1: ${e.message}")
        }
    }

    @Test
    fun testDeterministicStateInitActionEncodeDecode() {
        val data = loadMockJson("DeterministicStateInitAction.json")
        assertNotNull(data, "Mock file DeterministicStateInitAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DeterministicStateInitAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DeterministicStateInitAction: ${e.message}")
        }
    }

    @Test
    fun testDirectionEncodeDecode() {
        val data = loadMockJson("Direction.json")
        assertNotNull(data, "Mock file Direction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Direction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Direction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Direction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Direction: ${e.message}")
        }
    }

    @Test
    fun testDumpConfigEncodeDecode() {
        val data = loadMockJson("DumpConfig.json")
        assertNotNull(data, "Mock file DumpConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DumpConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DumpConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DumpConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DumpConfig: ${e.message}")
        }
    }

    @Test
    fun testDurationAsStdSchemaProviderEncodeDecode() {
        val data = loadMockJson("DurationAsStdSchemaProvider.json")
        assertNotNull(data, "Mock file DurationAsStdSchemaProvider.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DurationAsStdSchemaProvider.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.DurationAsStdSchemaProvider.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.DurationAsStdSchemaProvider.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for DurationAsStdSchemaProvider: ${e.message}")
        }
    }

    @Test
    fun testEpochIdEncodeDecode() {
        val data = loadMockJson("EpochId.json")
        assertNotNull(data, "Mock file EpochId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.EpochId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.EpochId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.EpochId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for EpochId: ${e.message}")
        }
    }

    @Test
    fun testEpochSyncConfigEncodeDecode() {
        val data = loadMockJson("EpochSyncConfig.json")
        assertNotNull(data, "Mock file EpochSyncConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.EpochSyncConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.EpochSyncConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.EpochSyncConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for EpochSyncConfig: ${e.message}")
        }
    }

    @Test
    fun testExecutionMetadataViewEncodeDecode() {
        val data = loadMockJson("ExecutionMetadataView.json")
        assertNotNull(data, "Mock file ExecutionMetadataView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionMetadataView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionMetadataView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionMetadataView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExecutionMetadataView: ${e.message}")
        }
    }

    @Test
    fun testExecutionOutcomeViewEncodeDecode() {
        val data = loadMockJson("ExecutionOutcomeView.json")
        assertNotNull(data, "Mock file ExecutionOutcomeView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExecutionOutcomeView: ${e.message}")
        }
    }

    @Test
    fun testExecutionOutcomeWithIdViewEncodeDecode() {
        val data = loadMockJson("ExecutionOutcomeWithIdView.json")
        assertNotNull(data, "Mock file ExecutionOutcomeWithIdView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionOutcomeWithIdView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExecutionOutcomeWithIdView: ${e.message}")
        }
    }

    @Test
    fun testExecutionStatusViewEncodeDecode() {
        val data = loadMockJson("ExecutionStatusView.json")
        assertNotNull(data, "Mock file ExecutionStatusView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExecutionStatusView: ${e.message}")
        }
    }

    @Test
    fun testExtCostsConfigViewEncodeDecode() {
        val data = loadMockJson("ExtCostsConfigView.json")
        assertNotNull(data, "Mock file ExtCostsConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExtCostsConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExtCostsConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExtCostsConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExtCostsConfigView: ${e.message}")
        }
    }

    @Test
    fun testExternalStorageConfigEncodeDecode() {
        val data = loadMockJson("ExternalStorageConfig.json")
        assertNotNull(data, "Mock file ExternalStorageConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExternalStorageConfig: ${e.message}")
        }
    }

    @Test
    fun testExternalStorageLocationEncodeDecode() {
        val data = loadMockJson("ExternalStorageLocation.json")
        assertNotNull(data, "Mock file ExternalStorageLocation.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ExternalStorageLocation: ${e.message}")
        }
    }

    @Test
    fun testFeeEncodeDecode() {
        val data = loadMockJson("Fee.json")
        assertNotNull(data, "Mock file Fee.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Fee.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Fee.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Fee.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Fee: ${e.message}")
        }
    }

    @Test
    fun testFinalExecutionOutcomeViewEncodeDecode() {
        val data = loadMockJson("FinalExecutionOutcomeView.json")
        assertNotNull(data, "Mock file FinalExecutionOutcomeView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FinalExecutionOutcomeView: ${e.message}")
        }
    }

    @Test
    fun testFinalExecutionOutcomeWithReceiptViewEncodeDecode() {
        val data = loadMockJson("FinalExecutionOutcomeWithReceiptView.json")
        assertNotNull(data, "Mock file FinalExecutionOutcomeWithReceiptView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeWithReceiptView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeWithReceiptView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionOutcomeWithReceiptView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FinalExecutionOutcomeWithReceiptView: ${e.message}")
        }
    }

    @Test
    fun testFinalExecutionStatusEncodeDecode() {
        val data = loadMockJson("FinalExecutionStatus.json")
        assertNotNull(data, "Mock file FinalExecutionStatus.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FinalExecutionStatus: ${e.message}")
        }
    }

    @Test
    fun testFinalityEncodeDecode() {
        val data = loadMockJson("Finality.json")
        assertNotNull(data, "Mock file Finality.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Finality.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Finality.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Finality.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Finality: ${e.message}")
        }
    }

    @Test
    fun testFunctionArgsEncodeDecode() {
        val data = loadMockJson("FunctionArgs.json")
        assertNotNull(data, "Mock file FunctionArgs.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FunctionArgs: ${e.message}")
        }
    }

    @Test
    fun testFunctionCallActionEncodeDecode() {
        val data = loadMockJson("FunctionCallAction.json")
        assertNotNull(data, "Mock file FunctionCallAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FunctionCallAction: ${e.message}")
        }
    }

    @Test
    fun testFunctionCallErrorEncodeDecode() {
        val data = loadMockJson("FunctionCallError.json")
        assertNotNull(data, "Mock file FunctionCallError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FunctionCallError: ${e.message}")
        }
    }

    @Test
    fun testFunctionCallPermissionEncodeDecode() {
        val data = loadMockJson("FunctionCallPermission.json")
        assertNotNull(data, "Mock file FunctionCallPermission.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for FunctionCallPermission: ${e.message}")
        }
    }

    @Test
    fun testGCConfigEncodeDecode() {
        val data = loadMockJson("GCConfig.json")
        assertNotNull(data, "Mock file GCConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GCConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GCConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GCConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GCConfig: ${e.message}")
        }
    }

    @Test
    fun testGasKeyViewEncodeDecode() {
        val data = loadMockJson("GasKeyView.json")
        assertNotNull(data, "Mock file GasKeyView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GasKeyView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GasKeyView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GasKeyView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GasKeyView: ${e.message}")
        }
    }

    @Test
    fun testGenesisConfigEncodeDecode() {
        val data = loadMockJson("GenesisConfig.json")
        assertNotNull(data, "Mock file GenesisConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GenesisConfig: ${e.message}")
        }
    }

    @Test
    fun testGenesisConfigRequestEncodeDecode() {
        val data = loadMockJson("GenesisConfigRequest.json")
        assertNotNull(data, "Mock file GenesisConfigRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfigRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfigRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GenesisConfigRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GenesisConfigRequest: ${e.message}")
        }
    }

    @Test
    fun testGlobalContractDeployModeEncodeDecode() {
        val data = loadMockJson("GlobalContractDeployMode.json")
        assertNotNull(data, "Mock file GlobalContractDeployMode.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GlobalContractDeployMode: ${e.message}")
        }
    }

    @Test
    fun testGlobalContractIdentifierEncodeDecode() {
        val data = loadMockJson("GlobalContractIdentifier.json")
        assertNotNull(data, "Mock file GlobalContractIdentifier.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GlobalContractIdentifier: ${e.message}")
        }
    }

    @Test
    fun testGlobalContractIdentifierViewEncodeDecode() {
        val data = loadMockJson("GlobalContractIdentifierView.json")
        assertNotNull(data, "Mock file GlobalContractIdentifierView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for GlobalContractIdentifierView: ${e.message}")
        }
    }

    @Test
    fun testHostErrorEncodeDecode() {
        val data = loadMockJson("HostError.json")
        assertNotNull(data, "Mock file HostError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.HostError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.HostError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.HostError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for HostError: ${e.message}")
        }
    }

    @Test
    fun testInvalidAccessKeyErrorEncodeDecode() {
        val data = loadMockJson("InvalidAccessKeyError.json")
        assertNotNull(data, "Mock file InvalidAccessKeyError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for InvalidAccessKeyError: ${e.message}")
        }
    }

    @Test
    fun testInvalidTxErrorEncodeDecode() {
        val data = loadMockJson("InvalidTxError.json")
        assertNotNull(data, "Mock file InvalidTxError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for InvalidTxError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalChangesEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalChanges.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalChanges.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalChanges: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalChangesInBlockEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalChangesInBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalChangesInBlock.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalChangesInBlock: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalCongestionLevelEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalCongestionLevel.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalCongestionLevel.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalCongestionLevel: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalGenesisConfigEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalGenesisConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalGenesisConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalGenesisConfig: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalLightClientBlockProofEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalLightClientBlockProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalLightClientBlockProof.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalLightClientBlockProof: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalLightClientProofEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalLightClientProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalLightClientProof.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalLightClientProof: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalMaintenanceWindowsEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalMaintenanceWindows.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalMaintenanceWindows.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalMaintenanceWindows: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalProtocolConfigEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalProtocolConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalProtocolConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalProtocolConfig: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalReceiptEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalReceipt.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalReceipt.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalReceipt: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalSplitStorageInfoEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalSplitStorageInfo.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalSplitStorageInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalSplitStorageInfo: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalTxStatusEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalTxStatus.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalTxStatus.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalTxStatus: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForExperimentalValidatorsOrderedEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForExperimentalValidatorsOrdered.json")
        assertNotNull(data, "Mock file JsonRpcRequestForExperimentalValidatorsOrdered.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForExperimentalValidatorsOrdered: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForBlockEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBlock.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForBlock: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForBlockEffectsEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForBlockEffects.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBlockEffects.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForBlockEffects: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForBroadcastTxAsyncEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForBroadcastTxAsync.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBroadcastTxAsync.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForBroadcastTxAsync: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForBroadcastTxCommitEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForBroadcastTxCommit.json")
        assertNotNull(data, "Mock file JsonRpcRequestForBroadcastTxCommit.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForBroadcastTxCommit: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForChangesEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForChanges.json")
        assertNotNull(data, "Mock file JsonRpcRequestForChanges.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForChanges: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForChunkEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForChunk.json")
        assertNotNull(data, "Mock file JsonRpcRequestForChunk.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForChunk: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForClientConfigEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForClientConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForClientConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForClientConfig: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForGasPriceEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForGasPrice.json")
        assertNotNull(data, "Mock file JsonRpcRequestForGasPrice.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForGasPrice: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForGenesisConfigEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForGenesisConfig.json")
        assertNotNull(data, "Mock file JsonRpcRequestForGenesisConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForGenesisConfig: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForHealthEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForHealth.json")
        assertNotNull(data, "Mock file JsonRpcRequestForHealth.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForHealth: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForLightClientProofEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForLightClientProof.json")
        assertNotNull(data, "Mock file JsonRpcRequestForLightClientProof.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForLightClientProof: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForMaintenanceWindowsEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForMaintenanceWindows.json")
        assertNotNull(data, "Mock file JsonRpcRequestForMaintenanceWindows.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForMaintenanceWindows: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForNetworkInfoEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForNetworkInfo.json")
        assertNotNull(data, "Mock file JsonRpcRequestForNetworkInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForNetworkInfo: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForNextLightClientBlockEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForNextLightClientBlock.json")
        assertNotNull(data, "Mock file JsonRpcRequestForNextLightClientBlock.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForNextLightClientBlock: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForQueryEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForQuery.json")
        assertNotNull(data, "Mock file JsonRpcRequestForQuery.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForQuery: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForSendTxEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForSendTx.json")
        assertNotNull(data, "Mock file JsonRpcRequestForSendTx.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForSendTx: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForStatusEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForStatus.json")
        assertNotNull(data, "Mock file JsonRpcRequestForStatus.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForStatus: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForTxEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForTx.json")
        assertNotNull(data, "Mock file JsonRpcRequestForTx.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForTx: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcRequestForValidatorsEncodeDecode() {
        val data = loadMockJson("JsonRpcRequestForValidators.json")
        assertNotNull(data, "Mock file JsonRpcRequestForValidators.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcRequestForValidators: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForArrayOfRangeOfUint64AndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForArrayOfRangeOfUint64AndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForArrayOfRangeOfUint64AndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForArrayOfRangeOfUint64AndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForArrayOfValidatorStakeViewAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForArrayOfValidatorStakeViewAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForCryptoHashAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForCryptoHashAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForCryptoHashAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForCryptoHashAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForCryptoHashAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForCryptoHashAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForCryptoHashAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForGenesisConfigAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForGenesisConfigAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForGenesisConfigAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForGenesisConfigAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForGenesisConfigAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForGenesisConfigAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForGenesisConfigAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForNullableRpcHealthResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForNullableRpcHealthResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForNullableRpcHealthResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForNullableRpcHealthResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForNullableRpcHealthResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForNullableRpcHealthResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForNullableRpcHealthResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcBlockResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcBlockResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcBlockResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcBlockResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcBlockResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcBlockResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcBlockResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcChunkResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcChunkResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcChunkResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcChunkResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcChunkResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcChunkResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcChunkResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcClientConfigResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcClientConfigResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcClientConfigResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcClientConfigResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcClientConfigResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcClientConfigResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcClientConfigResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcCongestionLevelResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcCongestionLevelResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcCongestionLevelResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcCongestionLevelResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcGasPriceResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcGasPriceResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcGasPriceResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcGasPriceResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcGasPriceResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcGasPriceResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcGasPriceResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcLightClientBlockProofResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcLightClientNextBlockResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcNetworkInfoResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcNetworkInfoResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcNetworkInfoResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcNetworkInfoResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcProtocolConfigResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcProtocolConfigResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcProtocolConfigResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcProtocolConfigResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcQueryResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcQueryResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcQueryResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcQueryResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcQueryResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcQueryResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcQueryResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcReceiptResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcReceiptResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcReceiptResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcReceiptResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcSplitStorageInfoResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcStateChangesInBlockResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcStatusResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcStatusResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcStatusResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStatusResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStatusResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStatusResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcStatusResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcTransactionResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcTransactionResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcTransactionResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcTransactionResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testJsonRpcResponseForRpcValidatorResponseAndRpcErrorEncodeDecode() {
        val data = loadMockJson("JsonRpcResponseForRpcValidatorResponseAndRpcError.json")
        assertNotNull(data, "Mock file JsonRpcResponseForRpcValidatorResponseAndRpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for JsonRpcResponseForRpcValidatorResponseAndRpcError: ${e.message}")
        }
    }

    @Test
    fun testKnownProducerViewEncodeDecode() {
        val data = loadMockJson("KnownProducerView.json")
        assertNotNull(data, "Mock file KnownProducerView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.KnownProducerView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.KnownProducerView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.KnownProducerView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for KnownProducerView: ${e.message}")
        }
    }

    @Test
    fun testLightClientBlockLiteViewEncodeDecode() {
        val data = loadMockJson("LightClientBlockLiteView.json")
        assertNotNull(data, "Mock file LightClientBlockLiteView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LightClientBlockLiteView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.LightClientBlockLiteView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LightClientBlockLiteView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for LightClientBlockLiteView: ${e.message}")
        }
    }

    @Test
    fun testLimitConfigEncodeDecode() {
        val data = loadMockJson("LimitConfig.json")
        assertNotNull(data, "Mock file LimitConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LimitConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.LimitConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LimitConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for LimitConfig: ${e.message}")
        }
    }

    @Test
    fun testLogSummaryStyleEncodeDecode() {
        val data = loadMockJson("LogSummaryStyle.json")
        assertNotNull(data, "Mock file LogSummaryStyle.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LogSummaryStyle.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.LogSummaryStyle.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.LogSummaryStyle.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for LogSummaryStyle: ${e.message}")
        }
    }

    @Test
    fun testMerklePathItemEncodeDecode() {
        val data = loadMockJson("MerklePathItem.json")
        assertNotNull(data, "Mock file MerklePathItem.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MerklePathItem.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.MerklePathItem.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MerklePathItem.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for MerklePathItem: ${e.message}")
        }
    }

    @Test
    fun testMethodResolveErrorEncodeDecode() {
        val data = loadMockJson("MethodResolveError.json")
        assertNotNull(data, "Mock file MethodResolveError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for MethodResolveError: ${e.message}")
        }
    }

    @Test
    fun testMissingTrieValueEncodeDecode() {
        val data = loadMockJson("MissingTrieValue.json")
        assertNotNull(data, "Mock file MissingTrieValue.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for MissingTrieValue: ${e.message}")
        }
    }

    @Test
    fun testMissingTrieValueContextEncodeDecode() {
        val data = loadMockJson("MissingTrieValueContext.json")
        assertNotNull(data, "Mock file MissingTrieValueContext.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for MissingTrieValueContext: ${e.message}")
        }
    }

    @Test
    fun testMutableConfigValueEncodeDecode() {
        val data = loadMockJson("MutableConfigValue.json")
        assertNotNull(data, "Mock file MutableConfigValue.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MutableConfigValue.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.MutableConfigValue.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.MutableConfigValue.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for MutableConfigValue: ${e.message}")
        }
    }

    @Test
    fun testNearGasEncodeDecode() {
        val data = loadMockJson("NearGas.json")
        assertNotNull(data, "Mock file NearGas.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NearGas.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.NearGas.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NearGas.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for NearGas: ${e.message}")
        }
    }

    @Test
    fun testNearTokenEncodeDecode() {
        val data = loadMockJson("NearToken.json")
        assertNotNull(data, "Mock file NearToken.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NearToken.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.NearToken.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NearToken.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for NearToken: ${e.message}")
        }
    }

    @Test
    fun testNetworkInfoViewEncodeDecode() {
        val data = loadMockJson("NetworkInfoView.json")
        assertNotNull(data, "Mock file NetworkInfoView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NetworkInfoView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.NetworkInfoView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NetworkInfoView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for NetworkInfoView: ${e.message}")
        }
    }

    @Test
    fun testNextEpochValidatorInfoEncodeDecode() {
        val data = loadMockJson("NextEpochValidatorInfo.json")
        assertNotNull(data, "Mock file NextEpochValidatorInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NextEpochValidatorInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.NextEpochValidatorInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NextEpochValidatorInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for NextEpochValidatorInfo: ${e.message}")
        }
    }

    @Test
    fun testNonDelegateActionEncodeDecode() {
        val data = loadMockJson("NonDelegateAction.json")
        assertNotNull(data, "Mock file NonDelegateAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.NonDelegateAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for NonDelegateAction: ${e.message}")
        }
    }

    @Test
    fun testPeerIdEncodeDecode() {
        val data = loadMockJson("PeerId.json")
        assertNotNull(data, "Mock file PeerId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PeerId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.PeerId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PeerId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for PeerId: ${e.message}")
        }
    }

    @Test
    fun testPeerInfoViewEncodeDecode() {
        val data = loadMockJson("PeerInfoView.json")
        assertNotNull(data, "Mock file PeerInfoView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PeerInfoView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.PeerInfoView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PeerInfoView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for PeerInfoView: ${e.message}")
        }
    }

    @Test
    fun testPrepareErrorEncodeDecode() {
        val data = loadMockJson("PrepareError.json")
        assertNotNull(data, "Mock file PrepareError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PrepareError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.PrepareError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PrepareError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for PrepareError: ${e.message}")
        }
    }

    @Test
    fun testProtocolVersionCheckConfigEncodeDecode() {
        val data = loadMockJson("ProtocolVersionCheckConfig.json")
        assertNotNull(data, "Mock file ProtocolVersionCheckConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ProtocolVersionCheckConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ProtocolVersionCheckConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ProtocolVersionCheckConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ProtocolVersionCheckConfig: ${e.message}")
        }
    }

    @Test
    fun testPublicKeyEncodeDecode() {
        val data = loadMockJson("PublicKey.json")
        assertNotNull(data, "Mock file PublicKey.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PublicKey.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.PublicKey.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.PublicKey.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for PublicKey: ${e.message}")
        }
    }

    @Test
    fun testRangeOfUint64EncodeDecode() {
        val data = loadMockJson("RangeOfUint64.json")
        assertNotNull(data, "Mock file RangeOfUint64.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RangeOfUint64: ${e.message}")
        }
    }

    @Test
    fun testReceiptEnumViewEncodeDecode() {
        val data = loadMockJson("ReceiptEnumView.json")
        assertNotNull(data, "Mock file ReceiptEnumView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ReceiptEnumView: ${e.message}")
        }
    }

    @Test
    fun testReceiptValidationErrorEncodeDecode() {
        val data = loadMockJson("ReceiptValidationError.json")
        assertNotNull(data, "Mock file ReceiptValidationError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptValidationError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ReceiptValidationError: ${e.message}")
        }
    }

    @Test
    fun testReceiptViewEncodeDecode() {
        val data = loadMockJson("ReceiptView.json")
        assertNotNull(data, "Mock file ReceiptView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ReceiptView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ReceiptView: ${e.message}")
        }
    }

    @Test
    fun testRpcBlockRequestEncodeDecode() {
        val data = loadMockJson("RpcBlockRequest.json")
        assertNotNull(data, "Mock file RpcBlockRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcBlockRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcBlockResponseEncodeDecode() {
        val data = loadMockJson("RpcBlockResponse.json")
        assertNotNull(data, "Mock file RpcBlockResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcBlockResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcChunkRequestEncodeDecode() {
        val data = loadMockJson("RpcChunkRequest.json")
        assertNotNull(data, "Mock file RpcChunkRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcChunkRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcChunkResponseEncodeDecode() {
        val data = loadMockJson("RpcChunkResponse.json")
        assertNotNull(data, "Mock file RpcChunkResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcChunkResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcClientConfigRequestEncodeDecode() {
        val data = loadMockJson("RpcClientConfigRequest.json")
        assertNotNull(data, "Mock file RpcClientConfigRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcClientConfigRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcClientConfigResponseEncodeDecode() {
        val data = loadMockJson("RpcClientConfigResponse.json")
        assertNotNull(data, "Mock file RpcClientConfigResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcClientConfigResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcCongestionLevelRequestEncodeDecode() {
        val data = loadMockJson("RpcCongestionLevelRequest.json")
        assertNotNull(data, "Mock file RpcCongestionLevelRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcCongestionLevelRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcCongestionLevelResponseEncodeDecode() {
        val data = loadMockJson("RpcCongestionLevelResponse.json")
        assertNotNull(data, "Mock file RpcCongestionLevelResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcCongestionLevelResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcErrorEncodeDecode() {
        val data = loadMockJson("RpcError.json")
        assertNotNull(data, "Mock file RpcError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcError: ${e.message}")
        }
    }

    @Test
    fun testRpcGasPriceRequestEncodeDecode() {
        val data = loadMockJson("RpcGasPriceRequest.json")
        assertNotNull(data, "Mock file RpcGasPriceRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcGasPriceRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcGasPriceResponseEncodeDecode() {
        val data = loadMockJson("RpcGasPriceResponse.json")
        assertNotNull(data, "Mock file RpcGasPriceResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcGasPriceResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcHealthRequestEncodeDecode() {
        val data = loadMockJson("RpcHealthRequest.json")
        assertNotNull(data, "Mock file RpcHealthRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcHealthRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcHealthResponseEncodeDecode() {
        val data = loadMockJson("RpcHealthResponse.json")
        assertNotNull(data, "Mock file RpcHealthResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcHealthResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcHealthResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcKnownProducerEncodeDecode() {
        val data = loadMockJson("RpcKnownProducer.json")
        assertNotNull(data, "Mock file RpcKnownProducer.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcKnownProducer.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcKnownProducer.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcKnownProducer.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcKnownProducer: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientBlockProofRequestEncodeDecode() {
        val data = loadMockJson("RpcLightClientBlockProofRequest.json")
        assertNotNull(data, "Mock file RpcLightClientBlockProofRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientBlockProofRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientBlockProofResponseEncodeDecode() {
        val data = loadMockJson("RpcLightClientBlockProofResponse.json")
        assertNotNull(data, "Mock file RpcLightClientBlockProofResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientBlockProofResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientExecutionProofRequestEncodeDecode() {
        val data = loadMockJson("RpcLightClientExecutionProofRequest.json")
        assertNotNull(data, "Mock file RpcLightClientExecutionProofRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientExecutionProofRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientExecutionProofResponseEncodeDecode() {
        val data = loadMockJson("RpcLightClientExecutionProofResponse.json")
        assertNotNull(data, "Mock file RpcLightClientExecutionProofResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientExecutionProofResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientNextBlockRequestEncodeDecode() {
        val data = loadMockJson("RpcLightClientNextBlockRequest.json")
        assertNotNull(data, "Mock file RpcLightClientNextBlockRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientNextBlockRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcLightClientNextBlockResponseEncodeDecode() {
        val data = loadMockJson("RpcLightClientNextBlockResponse.json")
        assertNotNull(data, "Mock file RpcLightClientNextBlockResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcLightClientNextBlockResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcMaintenanceWindowsRequestEncodeDecode() {
        val data = loadMockJson("RpcMaintenanceWindowsRequest.json")
        assertNotNull(data, "Mock file RpcMaintenanceWindowsRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcMaintenanceWindowsRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcNetworkInfoRequestEncodeDecode() {
        val data = loadMockJson("RpcNetworkInfoRequest.json")
        assertNotNull(data, "Mock file RpcNetworkInfoRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcNetworkInfoRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcNetworkInfoResponseEncodeDecode() {
        val data = loadMockJson("RpcNetworkInfoResponse.json")
        assertNotNull(data, "Mock file RpcNetworkInfoResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcNetworkInfoResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcPeerInfoEncodeDecode() {
        val data = loadMockJson("RpcPeerInfo.json")
        assertNotNull(data, "Mock file RpcPeerInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcPeerInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcPeerInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcPeerInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcPeerInfo: ${e.message}")
        }
    }

    @Test
    fun testRpcProtocolConfigRequestEncodeDecode() {
        val data = loadMockJson("RpcProtocolConfigRequest.json")
        assertNotNull(data, "Mock file RpcProtocolConfigRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcProtocolConfigRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcProtocolConfigResponseEncodeDecode() {
        val data = loadMockJson("RpcProtocolConfigResponse.json")
        assertNotNull(data, "Mock file RpcProtocolConfigResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcProtocolConfigResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcQueryRequestEncodeDecode() {
        val data = loadMockJson("RpcQueryRequest.json")
        assertNotNull(data, "Mock file RpcQueryRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcQueryRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcQueryResponseEncodeDecode() {
        val data = loadMockJson("RpcQueryResponse.json")
        assertNotNull(data, "Mock file RpcQueryResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcQueryResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcReceiptRequestEncodeDecode() {
        val data = loadMockJson("RpcReceiptRequest.json")
        assertNotNull(data, "Mock file RpcReceiptRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcReceiptRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcReceiptResponseEncodeDecode() {
        val data = loadMockJson("RpcReceiptResponse.json")
        assertNotNull(data, "Mock file RpcReceiptResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcReceiptResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcRequestValidationErrorKindEncodeDecode() {
        val data = loadMockJson("RpcRequestValidationErrorKind.json")
        assertNotNull(data, "Mock file RpcRequestValidationErrorKind.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcRequestValidationErrorKind: ${e.message}")
        }
    }

    @Test
    fun testRpcSendTransactionRequestEncodeDecode() {
        val data = loadMockJson("RpcSendTransactionRequest.json")
        assertNotNull(data, "Mock file RpcSendTransactionRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcSendTransactionRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcSplitStorageInfoRequestEncodeDecode() {
        val data = loadMockJson("RpcSplitStorageInfoRequest.json")
        assertNotNull(data, "Mock file RpcSplitStorageInfoRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcSplitStorageInfoRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcSplitStorageInfoResponseEncodeDecode() {
        val data = loadMockJson("RpcSplitStorageInfoResponse.json")
        assertNotNull(data, "Mock file RpcSplitStorageInfoResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcSplitStorageInfoResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcStateChangesInBlockByTypeRequestEncodeDecode() {
        val data = loadMockJson("RpcStateChangesInBlockByTypeRequest.json")
        assertNotNull(data, "Mock file RpcStateChangesInBlockByTypeRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStateChangesInBlockByTypeRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcStateChangesInBlockByTypeResponseEncodeDecode() {
        val data = loadMockJson("RpcStateChangesInBlockByTypeResponse.json")
        assertNotNull(data, "Mock file RpcStateChangesInBlockByTypeResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStateChangesInBlockByTypeResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcStateChangesInBlockRequestEncodeDecode() {
        val data = loadMockJson("RpcStateChangesInBlockRequest.json")
        assertNotNull(data, "Mock file RpcStateChangesInBlockRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStateChangesInBlockRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcStateChangesInBlockResponseEncodeDecode() {
        val data = loadMockJson("RpcStateChangesInBlockResponse.json")
        assertNotNull(data, "Mock file RpcStateChangesInBlockResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStateChangesInBlockResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcStatusRequestEncodeDecode() {
        val data = loadMockJson("RpcStatusRequest.json")
        assertNotNull(data, "Mock file RpcStatusRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStatusRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcStatusResponseEncodeDecode() {
        val data = loadMockJson("RpcStatusResponse.json")
        assertNotNull(data, "Mock file RpcStatusResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcStatusResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcTransactionResponseEncodeDecode() {
        val data = loadMockJson("RpcTransactionResponse.json")
        assertNotNull(data, "Mock file RpcTransactionResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcTransactionResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcTransactionStatusRequestEncodeDecode() {
        val data = loadMockJson("RpcTransactionStatusRequest.json")
        assertNotNull(data, "Mock file RpcTransactionStatusRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcTransactionStatusRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcValidatorRequestEncodeDecode() {
        val data = loadMockJson("RpcValidatorRequest.json")
        assertNotNull(data, "Mock file RpcValidatorRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcValidatorRequest: ${e.message}")
        }
    }

    @Test
    fun testRpcValidatorResponseEncodeDecode() {
        val data = loadMockJson("RpcValidatorResponse.json")
        assertNotNull(data, "Mock file RpcValidatorResponse.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcValidatorResponse: ${e.message}")
        }
    }

    @Test
    fun testRpcValidatorsOrderedRequestEncodeDecode() {
        val data = loadMockJson("RpcValidatorsOrderedRequest.json")
        assertNotNull(data, "Mock file RpcValidatorsOrderedRequest.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RpcValidatorsOrderedRequest: ${e.message}")
        }
    }

    @Test
    fun testRuntimeConfigViewEncodeDecode() {
        val data = loadMockJson("RuntimeConfigView.json")
        assertNotNull(data, "Mock file RuntimeConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RuntimeConfigView: ${e.message}")
        }
    }

    @Test
    fun testRuntimeFeesConfigViewEncodeDecode() {
        val data = loadMockJson("RuntimeFeesConfigView.json")
        assertNotNull(data, "Mock file RuntimeFeesConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeFeesConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeFeesConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.RuntimeFeesConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for RuntimeFeesConfigView: ${e.message}")
        }
    }

    @Test
    fun testShardIdEncodeDecode() {
        val data = loadMockJson("ShardId.json")
        assertNotNull(data, "Mock file ShardId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardId: ${e.message}")
        }
    }

    @Test
    fun testShardLayoutEncodeDecode() {
        val data = loadMockJson("ShardLayout.json")
        assertNotNull(data, "Mock file ShardLayout.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardLayout: ${e.message}")
        }
    }

    @Test
    fun testShardLayoutV0EncodeDecode() {
        val data = loadMockJson("ShardLayoutV0.json")
        assertNotNull(data, "Mock file ShardLayoutV0.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardLayoutV0: ${e.message}")
        }
    }

    @Test
    fun testShardLayoutV1EncodeDecode() {
        val data = loadMockJson("ShardLayoutV1.json")
        assertNotNull(data, "Mock file ShardLayoutV1.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardLayoutV1: ${e.message}")
        }
    }

    @Test
    fun testShardLayoutV2EncodeDecode() {
        val data = loadMockJson("ShardLayoutV2.json")
        assertNotNull(data, "Mock file ShardLayoutV2.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardLayoutV2: ${e.message}")
        }
    }

    @Test
    fun testShardUIdEncodeDecode() {
        val data = loadMockJson("ShardUId.json")
        assertNotNull(data, "Mock file ShardUId.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardUId.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ShardUId.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ShardUId.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ShardUId: ${e.message}")
        }
    }

    @Test
    fun testSignatureEncodeDecode() {
        val data = loadMockJson("Signature.json")
        assertNotNull(data, "Mock file Signature.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Signature.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Signature.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Signature.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Signature: ${e.message}")
        }
    }

    @Test
    fun testSignedDelegateActionEncodeDecode() {
        val data = loadMockJson("SignedDelegateAction.json")
        assertNotNull(data, "Mock file SignedDelegateAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedDelegateAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SignedDelegateAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedDelegateAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SignedDelegateAction: ${e.message}")
        }
    }

    @Test
    fun testSignedTransactionEncodeDecode() {
        val data = loadMockJson("SignedTransaction.json")
        assertNotNull(data, "Mock file SignedTransaction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransaction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SignedTransaction: ${e.message}")
        }
    }

    @Test
    fun testSignedTransactionViewEncodeDecode() {
        val data = loadMockJson("SignedTransactionView.json")
        assertNotNull(data, "Mock file SignedTransactionView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SignedTransactionView: ${e.message}")
        }
    }

    @Test
    fun testSlashedValidatorEncodeDecode() {
        val data = loadMockJson("SlashedValidator.json")
        assertNotNull(data, "Mock file SlashedValidator.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SlashedValidator.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SlashedValidator.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SlashedValidator.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SlashedValidator: ${e.message}")
        }
    }

    @Test
    fun testStakeActionEncodeDecode() {
        val data = loadMockJson("StakeAction.json")
        assertNotNull(data, "Mock file StakeAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StakeAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StakeAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StakeAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StakeAction: ${e.message}")
        }
    }

    @Test
    fun testStateChangeCauseViewEncodeDecode() {
        val data = loadMockJson("StateChangeCauseView.json")
        assertNotNull(data, "Mock file StateChangeCauseView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StateChangeCauseView: ${e.message}")
        }
    }

    @Test
    fun testStateChangeKindViewEncodeDecode() {
        val data = loadMockJson("StateChangeKindView.json")
        assertNotNull(data, "Mock file StateChangeKindView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StateChangeKindView: ${e.message}")
        }
    }

    @Test
    fun testStateChangeWithCauseViewEncodeDecode() {
        val data = loadMockJson("StateChangeWithCauseView.json")
        assertNotNull(data, "Mock file StateChangeWithCauseView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StateChangeWithCauseView: ${e.message}")
        }
    }

    @Test
    fun testStateItemEncodeDecode() {
        val data = loadMockJson("StateItem.json")
        assertNotNull(data, "Mock file StateItem.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateItem.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StateItem.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateItem.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StateItem: ${e.message}")
        }
    }

    @Test
    fun testStateSyncConfigEncodeDecode() {
        val data = loadMockJson("StateSyncConfig.json")
        assertNotNull(data, "Mock file StateSyncConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateSyncConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StateSyncConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StateSyncConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StateSyncConfig: ${e.message}")
        }
    }

    @Test
    fun testStatusSyncInfoEncodeDecode() {
        val data = loadMockJson("StatusSyncInfo.json")
        assertNotNull(data, "Mock file StatusSyncInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StatusSyncInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StatusSyncInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StatusSyncInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StatusSyncInfo: ${e.message}")
        }
    }

    @Test
    fun testStorageErrorEncodeDecode() {
        val data = loadMockJson("StorageError.json")
        assertNotNull(data, "Mock file StorageError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StorageError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StorageError: ${e.message}")
        }
    }

    @Test
    fun testStorageGetModeEncodeDecode() {
        val data = loadMockJson("StorageGetMode.json")
        assertNotNull(data, "Mock file StorageGetMode.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageGetMode.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StorageGetMode.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageGetMode.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StorageGetMode: ${e.message}")
        }
    }

    @Test
    fun testStorageUsageConfigViewEncodeDecode() {
        val data = loadMockJson("StorageUsageConfigView.json")
        assertNotNull(data, "Mock file StorageUsageConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageUsageConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StorageUsageConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StorageUsageConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StorageUsageConfigView: ${e.message}")
        }
    }

    @Test
    fun testStoreKeyEncodeDecode() {
        val data = loadMockJson("StoreKey.json")
        assertNotNull(data, "Mock file StoreKey.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StoreKey.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StoreKey.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StoreKey.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StoreKey: ${e.message}")
        }
    }

    @Test
    fun testStoreValueEncodeDecode() {
        val data = loadMockJson("StoreValue.json")
        assertNotNull(data, "Mock file StoreValue.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StoreValue.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.StoreValue.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.StoreValue.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for StoreValue: ${e.message}")
        }
    }

    @Test
    fun testSyncCheckpointEncodeDecode() {
        val data = loadMockJson("SyncCheckpoint.json")
        assertNotNull(data, "Mock file SyncCheckpoint.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SyncCheckpoint: ${e.message}")
        }
    }

    @Test
    fun testSyncConcurrencyEncodeDecode() {
        val data = loadMockJson("SyncConcurrency.json")
        assertNotNull(data, "Mock file SyncConcurrency.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncConcurrency.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SyncConcurrency.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncConcurrency.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SyncConcurrency: ${e.message}")
        }
    }

    @Test
    fun testSyncConfigEncodeDecode() {
        val data = loadMockJson("SyncConfig.json")
        assertNotNull(data, "Mock file SyncConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for SyncConfig: ${e.message}")
        }
    }

    @Test
    fun testTier1ProxyViewEncodeDecode() {
        val data = loadMockJson("Tier1ProxyView.json")
        assertNotNull(data, "Mock file Tier1ProxyView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Tier1ProxyView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Tier1ProxyView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Tier1ProxyView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Tier1ProxyView: ${e.message}")
        }
    }

    @Test
    fun testTrackedShardsConfigEncodeDecode() {
        val data = loadMockJson("TrackedShardsConfig.json")
        assertNotNull(data, "Mock file TrackedShardsConfig.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for TrackedShardsConfig: ${e.message}")
        }
    }

    @Test
    fun testTransferActionEncodeDecode() {
        val data = loadMockJson("TransferAction.json")
        assertNotNull(data, "Mock file TransferAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TransferAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.TransferAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TransferAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for TransferAction: ${e.message}")
        }
    }

    @Test
    fun testTxExecutionErrorEncodeDecode() {
        val data = loadMockJson("TxExecutionError.json")
        assertNotNull(data, "Mock file TxExecutionError.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for TxExecutionError: ${e.message}")
        }
    }

    @Test
    fun testTxExecutionStatusEncodeDecode() {
        val data = loadMockJson("TxExecutionStatus.json")
        assertNotNull(data, "Mock file TxExecutionStatus.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for TxExecutionStatus: ${e.message}")
        }
    }

    @Test
    fun testUseGlobalContractActionEncodeDecode() {
        val data = loadMockJson("UseGlobalContractAction.json")
        assertNotNull(data, "Mock file UseGlobalContractAction.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.UseGlobalContractAction.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for UseGlobalContractAction: ${e.message}")
        }
    }

    @Test
    fun testVMConfigViewEncodeDecode() {
        val data = loadMockJson("VMConfigView.json")
        assertNotNull(data, "Mock file VMConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.VMConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.VMConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.VMConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for VMConfigView: ${e.message}")
        }
    }

    @Test
    fun testVMKindEncodeDecode() {
        val data = loadMockJson("VMKind.json")
        assertNotNull(data, "Mock file VMKind.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.VMKind.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.VMKind.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.VMKind.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for VMKind: ${e.message}")
        }
    }

    @Test
    fun testValidatorInfoEncodeDecode() {
        val data = loadMockJson("ValidatorInfo.json")
        assertNotNull(data, "Mock file ValidatorInfo.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorInfo.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorInfo.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorInfo.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ValidatorInfo: ${e.message}")
        }
    }

    @Test
    fun testValidatorKickoutReasonEncodeDecode() {
        val data = loadMockJson("ValidatorKickoutReason.json")
        assertNotNull(data, "Mock file ValidatorKickoutReason.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutReason.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ValidatorKickoutReason: ${e.message}")
        }
    }

    @Test
    fun testValidatorKickoutViewEncodeDecode() {
        val data = loadMockJson("ValidatorKickoutView.json")
        assertNotNull(data, "Mock file ValidatorKickoutView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorKickoutView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ValidatorKickoutView: ${e.message}")
        }
    }

    @Test
    fun testValidatorStakeViewEncodeDecode() {
        val data = loadMockJson("ValidatorStakeView.json")
        assertNotNull(data, "Mock file ValidatorStakeView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ValidatorStakeView: ${e.message}")
        }
    }

    @Test
    fun testValidatorStakeViewV1EncodeDecode() {
        val data = loadMockJson("ValidatorStakeViewV1.json")
        assertNotNull(data, "Mock file ValidatorStakeViewV1.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeViewV1.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeViewV1.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeViewV1.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ValidatorStakeViewV1: ${e.message}")
        }
    }

    @Test
    fun testVersionEncodeDecode() {
        val data = loadMockJson("Version.json")
        assertNotNull(data, "Mock file Version.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Version.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.Version.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.Version.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for Version: ${e.message}")
        }
    }

    @Test
    fun testViewStateResultEncodeDecode() {
        val data = loadMockJson("ViewStateResult.json")
        assertNotNull(data, "Mock file ViewStateResult.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ViewStateResult.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.ViewStateResult.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.ViewStateResult.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for ViewStateResult: ${e.message}")
        }
    }

    @Test
    fun testWasmTrapEncodeDecode() {
        val data = loadMockJson("WasmTrap.json")
        assertNotNull(data, "Mock file WasmTrap.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for WasmTrap: ${e.message}")
        }
    }

    @Test
    fun testWitnessConfigViewEncodeDecode() {
        val data = loadMockJson("WitnessConfigView.json")
        assertNotNull(data, "Mock file WitnessConfigView.json does not exist!")

        try {
            val decoded = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.WitnessConfigView.serializer(), data)
            val encoded = json.encodeToString(io.github.hosseinkarami_dev.near.rpc.models.WitnessConfigView.serializer(), decoded)
            val decoded2 = json.decodeFromString(io.github.hosseinkarami_dev.near.rpc.models.WitnessConfigView.serializer(), encoded)
            assertEquals(decoded, decoded2)
        } catch (e: Exception) {
            e.printStackTrace()
            fail("Serialization test failed for WitnessConfigView: ${e.message}")
        }
    }

}
