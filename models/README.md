# NEAR RPC Models

This module contains all **data models** and **serialization definitions** used by the [NEAR JSON-RPC Kotlin Client](../near-rpc-client).

It is **fully generated** from NEAR’s official [OpenAPI specification](https://github.com/near/nearcore/tree/master/chain/jsonrpc/openapi), providing a **type-safe**, `kotlinx.serialization`-based representation of every request and response type.

---

## Overview

- ✅ Auto-generated Kotlin `data class`es from NEAR’s JSON-RPC OpenAPI spec.
- ✅ Uses [`kotlinx.serialization`](https://github.com/Kotlin/kotlinx.serialization) for cross-platform JSON parsing.
- ⚙️ Independent from HTTP or networking code — can be used standalone in any project.
- 🧩 Used internally by [`near-rpc-client`](../near-rpc-client) but may also be consumed directly.

---