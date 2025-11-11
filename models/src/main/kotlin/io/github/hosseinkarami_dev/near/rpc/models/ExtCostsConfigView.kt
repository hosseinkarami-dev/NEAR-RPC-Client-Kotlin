package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Typed view of ExtCostsConfig to preserve JSON output field names in protocol
 * config RPC output.
 */
@Serializable
public data class ExtCostsConfigView(
  /**
   *  * Base cost for multiexp
   */
  @SerialName("alt_bn128_g1_multiexp_base")
  public val altBn128G1MultiexpBase: NearGas,
  /**
   *  * Per element cost for multiexp
   */
  @SerialName("alt_bn128_g1_multiexp_element")
  public val altBn128G1MultiexpElement: NearGas,
  /**
   *  * Base cost for sum
   */
  @SerialName("alt_bn128_g1_sum_base")
  public val altBn128G1SumBase: NearGas,
  /**
   *  * Per element cost for sum
   */
  @SerialName("alt_bn128_g1_sum_element")
  public val altBn128G1SumElement: NearGas,
  /**
   *  * Base cost for pairing check
   */
  @SerialName("alt_bn128_pairing_check_base")
  public val altBn128PairingCheckBase: NearGas,
  /**
   *  * Per element cost for pairing check
   */
  @SerialName("alt_bn128_pairing_check_element")
  public val altBn128PairingCheckElement: NearGas,
  /**
   *  * Base cost for calling a host function.
   */
  @SerialName("base")
  public val base: NearGas,
  @SerialName("bls12381_g1_multiexp_base")
  public val bls12381G1MultiexpBase: NearGas,
  @SerialName("bls12381_g1_multiexp_element")
  public val bls12381G1MultiexpElement: NearGas,
  @SerialName("bls12381_g2_multiexp_base")
  public val bls12381G2MultiexpBase: NearGas,
  @SerialName("bls12381_g2_multiexp_element")
  public val bls12381G2MultiexpElement: NearGas,
  @SerialName("bls12381_map_fp2_to_g2_base")
  public val bls12381MapFp2ToG2Base: NearGas,
  @SerialName("bls12381_map_fp2_to_g2_element")
  public val bls12381MapFp2ToG2Element: NearGas,
  @SerialName("bls12381_map_fp_to_g1_base")
  public val bls12381MapFpToG1Base: NearGas,
  @SerialName("bls12381_map_fp_to_g1_element")
  public val bls12381MapFpToG1Element: NearGas,
  @SerialName("bls12381_p1_decompress_base")
  public val bls12381P1DecompressBase: NearGas,
  @SerialName("bls12381_p1_decompress_element")
  public val bls12381P1DecompressElement: NearGas,
  @SerialName("bls12381_p1_sum_base")
  public val bls12381P1SumBase: NearGas,
  @SerialName("bls12381_p1_sum_element")
  public val bls12381P1SumElement: NearGas,
  @SerialName("bls12381_p2_decompress_base")
  public val bls12381P2DecompressBase: NearGas,
  @SerialName("bls12381_p2_decompress_element")
  public val bls12381P2DecompressElement: NearGas,
  @SerialName("bls12381_p2_sum_base")
  public val bls12381P2SumBase: NearGas,
  @SerialName("bls12381_p2_sum_element")
  public val bls12381P2SumElement: NearGas,
  @SerialName("bls12381_pairing_base")
  public val bls12381PairingBase: NearGas,
  @SerialName("bls12381_pairing_element")
  public val bls12381PairingElement: NearGas,
  @SerialName("contract_compile_base")
  public val contractCompileBase: NearGas,
  @SerialName("contract_compile_bytes")
  public val contractCompileBytes: NearGas,
  /**
   *  * Base cost of loading a pre-compiled contract
   */
  @SerialName("contract_loading_base")
  public val contractLoadingBase: NearGas,
  /**
   *  * Cost per byte of loading a pre-compiled contract
   */
  @SerialName("contract_loading_bytes")
  public val contractLoadingBytes: NearGas,
  /**
   *  * Cost of calling ecrecover
   */
  @SerialName("ecrecover_base")
  public val ecrecoverBase: NearGas,
  /**
   *  * Cost of getting ed25519 base
   */
  @SerialName("ed25519_verify_base")
  public val ed25519VerifyBase: NearGas,
  /**
   *  * Cost of getting ed25519 per byte
   */
  @SerialName("ed25519_verify_byte")
  public val ed25519VerifyByte: NearGas,
  /**
   *  * Cost of getting sha256 base
   */
  @SerialName("keccak256_base")
  public val keccak256Base: NearGas,
  /**
   *  * Cost of getting sha256 per byte
   */
  @SerialName("keccak256_byte")
  public val keccak256Byte: NearGas,
  /**
   *  * Cost of getting sha256 base
   */
  @SerialName("keccak512_base")
  public val keccak512Base: NearGas,
  /**
   *  * Cost of getting sha256 per byte
   */
  @SerialName("keccak512_byte")
  public val keccak512Byte: NearGas,
  /**
   *  * Cost for calling logging.
   */
  @SerialName("log_base")
  public val logBase: NearGas,
  /**
   *  * Cost for logging per byte
   */
  @SerialName("log_byte")
  public val logByte: NearGas,
  /**
   *  * Cost for calling `promise_and`
   */
  @SerialName("promise_and_base")
  public val promiseAndBase: NearGas,
  /**
   *  * Cost for calling `promise_and` for each promise
   */
  @SerialName("promise_and_per_promise")
  public val promiseAndPerPromise: NearGas,
  /**
   *  * Cost for calling `promise_return`
   */
  @SerialName("promise_return")
  public val promiseReturn: NearGas,
  /**
   *  * Cost for reading trie node from memory
   */
  @SerialName("read_cached_trie_node")
  public val readCachedTrieNode: NearGas,
  /**
   *  * Base cost for guest memory read
   */
  @SerialName("read_memory_base")
  public val readMemoryBase: NearGas,
  /**
   *  * Cost for guest memory read
   */
  @SerialName("read_memory_byte")
  public val readMemoryByte: NearGas,
  /**
   *  * Base cost for reading from register
   */
  @SerialName("read_register_base")
  public val readRegisterBase: NearGas,
  /**
   *  * Cost for reading byte from register
   */
  @SerialName("read_register_byte")
  public val readRegisterByte: NearGas,
  /**
   *  * Cost of getting ripemd160 base
   */
  @SerialName("ripemd160_base")
  public val ripemd160Base: NearGas,
  /**
   *  * Cost of getting ripemd160 per message block
   */
  @SerialName("ripemd160_block")
  public val ripemd160Block: NearGas,
  /**
   *  * Cost of getting sha256 base
   */
  @SerialName("sha256_base")
  public val sha256Base: NearGas,
  /**
   *  * Cost of getting sha256 per byte
   */
  @SerialName("sha256_byte")
  public val sha256Byte: NearGas,
  /**
   *  * Storage trie check for key existence cost base
   */
  @SerialName("storage_has_key_base")
  public val storageHasKeyBase: NearGas,
  /**
   *  * Storage trie check for key existence per key byte
   */
  @SerialName("storage_has_key_byte")
  public val storageHasKeyByte: NearGas,
  /**
   *  * Create trie range iterator cost per byte of from key.
   */
  @SerialName("storage_iter_create_from_byte")
  public val storageIterCreateFromByte: NearGas,
  /**
   *  * Create trie prefix iterator cost base
   */
  @SerialName("storage_iter_create_prefix_base")
  public val storageIterCreatePrefixBase: NearGas,
  /**
   *  * Create trie prefix iterator cost per byte.
   */
  @SerialName("storage_iter_create_prefix_byte")
  public val storageIterCreatePrefixByte: NearGas,
  /**
   *  * Create trie range iterator cost base
   */
  @SerialName("storage_iter_create_range_base")
  public val storageIterCreateRangeBase: NearGas,
  /**
   *  * Create trie range iterator cost per byte of to key.
   */
  @SerialName("storage_iter_create_to_byte")
  public val storageIterCreateToByte: NearGas,
  /**
   *  * Trie iterator per key base cost
   */
  @SerialName("storage_iter_next_base")
  public val storageIterNextBase: NearGas,
  /**
   *  * Trie iterator next key byte cost
   */
  @SerialName("storage_iter_next_key_byte")
  public val storageIterNextKeyByte: NearGas,
  /**
   *  * Trie iterator next key byte cost
   */
  @SerialName("storage_iter_next_value_byte")
  public val storageIterNextValueByte: NearGas,
  /**
   *  * Storage trie read key overhead base cost, when doing large reads
   */
  @SerialName("storage_large_read_overhead_base")
  public val storageLargeReadOverheadBase: NearGas,
  /**
   *  * Storage trie read key overhead  per-byte cost, when doing large reads
   */
  @SerialName("storage_large_read_overhead_byte")
  public val storageLargeReadOverheadByte: NearGas,
  /**
   *  * Storage trie read key base cost
   */
  @SerialName("storage_read_base")
  public val storageReadBase: NearGas,
  /**
   *  * Storage trie read key per byte cost
   */
  @SerialName("storage_read_key_byte")
  public val storageReadKeyByte: NearGas,
  /**
   *  * Storage trie read value cost per byte cost
   */
  @SerialName("storage_read_value_byte")
  public val storageReadValueByte: NearGas,
  /**
   *  * Remove key from trie base cost
   */
  @SerialName("storage_remove_base")
  public val storageRemoveBase: NearGas,
  /**
   *  * Remove key from trie per byte cost
   */
  @SerialName("storage_remove_key_byte")
  public val storageRemoveKeyByte: NearGas,
  /**
   *  * Remove key from trie ret value byte cost
   */
  @SerialName("storage_remove_ret_value_byte")
  public val storageRemoveRetValueByte: NearGas,
  /**
   *  * Storage trie write key base cost
   */
  @SerialName("storage_write_base")
  public val storageWriteBase: NearGas,
  /**
   *  * Storage trie write cost per byte of evicted value.
   */
  @SerialName("storage_write_evicted_byte")
  public val storageWriteEvictedByte: NearGas,
  /**
   *  * Storage trie write key per byte cost
   */
  @SerialName("storage_write_key_byte")
  public val storageWriteKeyByte: NearGas,
  /**
   *  * Storage trie write value per byte cost
   */
  @SerialName("storage_write_value_byte")
  public val storageWriteValueByte: NearGas,
  /**
   *  * Cost per reading trie node from DB
   */
  @SerialName("touching_trie_node")
  public val touchingTrieNode: NearGas,
  /**
   *  * Base cost of decoding utf16. It's used for `log_utf16`.
   */
  @SerialName("utf16_decoding_base")
  public val utf16DecodingBase: NearGas,
  /**
   *  * Cost per byte of decoding utf16. It's used for `log_utf16`.
   */
  @SerialName("utf16_decoding_byte")
  public val utf16DecodingByte: NearGas,
  /**
   *  * Base cost of decoding utf8. It's used for `log_utf8` and `panic_utf8`.
   */
  @SerialName("utf8_decoding_base")
  public val utf8DecodingBase: NearGas,
  /**
   *  * Cost per byte of decoding utf8. It's used for `log_utf8` and `panic_utf8`.
   */
  @SerialName("utf8_decoding_byte")
  public val utf8DecodingByte: NearGas,
  /**
   *  * Cost of calling `validator_stake`.
   */
  @SerialName("validator_stake_base")
  public val validatorStakeBase: NearGas,
  /**
   *  * Cost of calling `validator_total_stake`.
   */
  @SerialName("validator_total_stake_base")
  public val validatorTotalStakeBase: NearGas,
  /**
   *  * Base cost for guest memory write
   */
  @SerialName("write_memory_base")
  public val writeMemoryBase: NearGas,
  /**
   *  * Cost for guest memory write per byte
   */
  @SerialName("write_memory_byte")
  public val writeMemoryByte: NearGas,
  /**
   *  * Base cost for writing into register
   */
  @SerialName("write_register_base")
  public val writeRegisterBase: NearGas,
  /**
   *  * Cost for writing byte into register
   */
  @SerialName("write_register_byte")
  public val writeRegisterByte: NearGas,
  /**
   *  * Base cost for creating a yield promise.
   */
  @SerialName("yield_create_base")
  public val yieldCreateBase: NearGas,
  /**
   *  * Per byte cost of arguments and method name.
   */
  @SerialName("yield_create_byte")
  public val yieldCreateByte: NearGas,
  /**
   *  * Base cost for resuming a yield receipt.
   */
  @SerialName("yield_resume_base")
  public val yieldResumeBase: NearGas,
  /**
   *  * Per byte cost of resume payload.
   */
  @SerialName("yield_resume_byte")
  public val yieldResumeByte: NearGas,
)
