# 🛰️ NEAR RPC Client

This module provides a **fully typed Kotlin client** for interacting with the [NEAR JSON-RPC API](https://docs.near.org/api/rpc/introduction).  
It’s designed to be **auto-generated** from the official OpenAPI specification, ensuring strong type safety, consistency, and automatic synchronization with NEAR core updates.

---

## 🚀 Overview

The `client` module contains the core RPC communication layer for NEAR.  
At its heart is the [`NearClient.kt`](./src/main/kotlin/io/github/hosseinkarami_dev/near/rpc/NearClient.kt) file, which acts as the main entry point for all JSON-RPC requests.

The client automatically handles:
- ✅ JSON-RPC request/response encoding and decoding
- ✅ Strongly-typed data models (auto-generated from OpenAPI)
- ✅ Automatic serialization via `kotlinx.serialization`
- ✅ Support for Kotlin coroutines and suspending requests
- ✅ Error handling and RPC status responses

---

## 🧩 Module Structure