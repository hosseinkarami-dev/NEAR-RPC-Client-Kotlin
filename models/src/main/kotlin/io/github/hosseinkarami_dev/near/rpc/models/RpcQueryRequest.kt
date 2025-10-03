package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class RpcQueryRequest {
  @Serializable
  public data class ViewAccountByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_account
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_account
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public data class ViewCodeByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public data class ViewStateByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    /**
     *  * Possible values: view_state
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_state
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public data class ViewAccessKeyByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    /**
     *  * Possible values: view_access_key
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public data class ViewAccessKeyListByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_access_key_list
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key_list
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public data class CallFunctionByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Possible values: call_function
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: call_function
     */
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    /**
     *  * Possible values: view_global_contract_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeByAccountIdByBlockId(
    @SerialName("block_id")
    public val blockId: BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }

  @Serializable
  public data class ViewAccountByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_account
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_account
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public data class ViewCodeByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public data class ViewStateByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    /**
     *  * Possible values: view_state
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_state
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public data class ViewAccessKeyByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    /**
     *  * Possible values: view_access_key
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public data class ViewAccessKeyListByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_access_key_list
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key_list
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public data class CallFunctionByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Possible values: call_function
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: call_function
     */
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    /**
     *  * Possible values: view_global_contract_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeByAccountIdByFinality(
    @SerialName("finality")
    public val finality: Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }

  @Serializable
  public data class ViewAccountBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_account
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_account
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_account")
      VIEW_ACCOUNT,
    }
  }

  @Serializable
  public data class ViewCodeBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_code")
      VIEW_CODE,
    }
  }

  @Serializable
  public data class ViewStateBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("include_proof")
    public val includeProof: Boolean? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
    /**
     *  * Possible values: view_state
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_state
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_state")
      VIEW_STATE,
    }
  }

  @Serializable
  public data class ViewAccessKeyBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    /**
     *  * Possible values: view_access_key
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key")
      VIEW_ACCESS_KEY,
    }
  }

  @Serializable
  public data class ViewAccessKeyListBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_access_key_list
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_access_key_list
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_access_key_list")
      VIEW_ACCESS_KEY_LIST,
    }
  }

  @Serializable
  public data class CallFunctionBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Possible values: call_function
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: call_function
     */
    @Serializable
    public enum class RequestType {
      @SerialName("call_function")
      CALL_FUNCTION,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("code_hash")
    public val codeHash: CryptoHash,
    /**
     *  * Possible values: view_global_contract_code
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code")
      VIEW_GLOBAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public data class ViewGlobalContractCodeByAccountIdBySyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @SerialName("request_type")
    public val requestType: RequestType,
  ) : RpcQueryRequest() {
    /**
     *  * Possible values: view_global_contract_code_by_account_id
     */
    @Serializable
    public enum class RequestType {
      @SerialName("view_global_contract_code_by_account_id")
      VIEW_GLOBAL_CONTRACT_CODE_BY_ACCOUNT_ID,
    }
  }
}
