package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcQueryRequest {
  @Serializable
  public class ViewAccountByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public class ViewCodeByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public class ViewStateByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean?,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public class ViewAccessKeyByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public class ViewAccessKeyListByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public class CallFunctionByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeByAccountIdByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }

  @Serializable
  public class ViewAccountByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public class ViewCodeByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public class ViewStateByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean?,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public class ViewAccessKeyByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public class ViewAccessKeyListByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public class CallFunctionByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeByAccountIdByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }

  @Serializable
  public class ViewAccountBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public class ViewCodeBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public class ViewStateBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean?,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public class ViewAccessKeyBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public class ViewAccessKeyListBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public class CallFunctionBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public class ViewGlobalContractCodeByAccountIdBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }
}
