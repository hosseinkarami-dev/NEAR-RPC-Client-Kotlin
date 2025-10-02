package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExtCostsConfigView(
  @SerialName("alt_bn128_g1_multiexp_base")
  public val altBn128G1MultiexpBase: NearGas,
  @SerialName("alt_bn128_g1_multiexp_element")
  public val altBn128G1MultiexpElement: NearGas,
  @SerialName("alt_bn128_g1_sum_base")
  public val altBn128G1SumBase: NearGas,
  @SerialName("alt_bn128_g1_sum_element")
  public val altBn128G1SumElement: NearGas,
  @SerialName("alt_bn128_pairing_check_base")
  public val altBn128PairingCheckBase: NearGas,
  @SerialName("alt_bn128_pairing_check_element")
  public val altBn128PairingCheckElement: NearGas,
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
  @SerialName("contract_loading_base")
  public val contractLoadingBase: NearGas,
  @SerialName("contract_loading_bytes")
  public val contractLoadingBytes: NearGas,
  @SerialName("ecrecover_base")
  public val ecrecoverBase: NearGas,
  @SerialName("ed25519_verify_base")
  public val ed25519VerifyBase: NearGas,
  @SerialName("ed25519_verify_byte")
  public val ed25519VerifyByte: NearGas,
  @SerialName("keccak256_base")
  public val keccak256Base: NearGas,
  @SerialName("keccak256_byte")
  public val keccak256Byte: NearGas,
  @SerialName("keccak512_base")
  public val keccak512Base: NearGas,
  @SerialName("keccak512_byte")
  public val keccak512Byte: NearGas,
  @SerialName("log_base")
  public val logBase: NearGas,
  @SerialName("log_byte")
  public val logByte: NearGas,
  @SerialName("promise_and_base")
  public val promiseAndBase: NearGas,
  @SerialName("promise_and_per_promise")
  public val promiseAndPerPromise: NearGas,
  @SerialName("promise_return")
  public val promiseReturn: NearGas,
  @SerialName("read_cached_trie_node")
  public val readCachedTrieNode: NearGas,
  @SerialName("read_memory_base")
  public val readMemoryBase: NearGas,
  @SerialName("read_memory_byte")
  public val readMemoryByte: NearGas,
  @SerialName("read_register_base")
  public val readRegisterBase: NearGas,
  @SerialName("read_register_byte")
  public val readRegisterByte: NearGas,
  @SerialName("ripemd160_base")
  public val ripemd160Base: NearGas,
  @SerialName("ripemd160_block")
  public val ripemd160Block: NearGas,
  @SerialName("sha256_base")
  public val sha256Base: NearGas,
  @SerialName("sha256_byte")
  public val sha256Byte: NearGas,
  @SerialName("storage_has_key_base")
  public val storageHasKeyBase: NearGas,
  @SerialName("storage_has_key_byte")
  public val storageHasKeyByte: NearGas,
  @SerialName("storage_iter_create_from_byte")
  public val storageIterCreateFromByte: NearGas,
  @SerialName("storage_iter_create_prefix_base")
  public val storageIterCreatePrefixBase: NearGas,
  @SerialName("storage_iter_create_prefix_byte")
  public val storageIterCreatePrefixByte: NearGas,
  @SerialName("storage_iter_create_range_base")
  public val storageIterCreateRangeBase: NearGas,
  @SerialName("storage_iter_create_to_byte")
  public val storageIterCreateToByte: NearGas,
  @SerialName("storage_iter_next_base")
  public val storageIterNextBase: NearGas,
  @SerialName("storage_iter_next_key_byte")
  public val storageIterNextKeyByte: NearGas,
  @SerialName("storage_iter_next_value_byte")
  public val storageIterNextValueByte: NearGas,
  @SerialName("storage_large_read_overhead_base")
  public val storageLargeReadOverheadBase: NearGas,
  @SerialName("storage_large_read_overhead_byte")
  public val storageLargeReadOverheadByte: NearGas,
  @SerialName("storage_read_base")
  public val storageReadBase: NearGas,
  @SerialName("storage_read_key_byte")
  public val storageReadKeyByte: NearGas,
  @SerialName("storage_read_value_byte")
  public val storageReadValueByte: NearGas,
  @SerialName("storage_remove_base")
  public val storageRemoveBase: NearGas,
  @SerialName("storage_remove_key_byte")
  public val storageRemoveKeyByte: NearGas,
  @SerialName("storage_remove_ret_value_byte")
  public val storageRemoveRetValueByte: NearGas,
  @SerialName("storage_write_base")
  public val storageWriteBase: NearGas,
  @SerialName("storage_write_evicted_byte")
  public val storageWriteEvictedByte: NearGas,
  @SerialName("storage_write_key_byte")
  public val storageWriteKeyByte: NearGas,
  @SerialName("storage_write_value_byte")
  public val storageWriteValueByte: NearGas,
  @SerialName("touching_trie_node")
  public val touchingTrieNode: NearGas,
  @SerialName("utf16_decoding_base")
  public val utf16DecodingBase: NearGas,
  @SerialName("utf16_decoding_byte")
  public val utf16DecodingByte: NearGas,
  @SerialName("utf8_decoding_base")
  public val utf8DecodingBase: NearGas,
  @SerialName("utf8_decoding_byte")
  public val utf8DecodingByte: NearGas,
  @SerialName("validator_stake_base")
  public val validatorStakeBase: NearGas,
  @SerialName("validator_total_stake_base")
  public val validatorTotalStakeBase: NearGas,
  @SerialName("write_memory_base")
  public val writeMemoryBase: NearGas,
  @SerialName("write_memory_byte")
  public val writeMemoryByte: NearGas,
  @SerialName("write_register_base")
  public val writeRegisterBase: NearGas,
  @SerialName("write_register_byte")
  public val writeRegisterByte: NearGas,
  @SerialName("yield_create_base")
  public val yieldCreateBase: NearGas,
  @SerialName("yield_create_byte")
  public val yieldCreateByte: NearGas,
  @SerialName("yield_resume_base")
  public val yieldResumeBase: NearGas,
  @SerialName("yield_resume_byte")
  public val yieldResumeByte: NearGas,
)
