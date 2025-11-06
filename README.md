# Kotlin JSON-RPC Kotlin Client

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](#)  
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](#)

A **type-safe**, Kotlin client for the NEAR JSON-RPC API. This repository contains:

- `models`: Generated Kotlin `@Serializable` types for OpenAPI schemas.  
- `client`: Ergonomic Kotlin client built on Ktor that exposes NEAR JSON-RPC methods as `suspend` functions.  
- `generator`: CLI tool that parses the NEAR OpenAPI spec and regenerates `models` and `client`.
---

## Table of contents

- [Overview](#-overview)  
- [Features](#-features)
- [Requirements](#-requirements)
- [Quickstart - Examples](#-quickstart)  
- [Error Handling](#-error-handling)  
- [Generator - Reproduce models & client](#-generator---reproduce-models--client)
- [Testing](#-testing)
- [Contributing](#-contributing)
- [License](#-license)  
- [Contact & References](#-contact--references)

---

## 📖 Overview

- A type-safe, coroutine-powered Kotlin client for interacting with the NEAR Protocol JSON-RPC API.

- Built using `Kotlin Multiplatform` and `kotlinx.serialization`, with models and API bindings automatically generated from NEAR’s official OpenAPI specification.

| Module       | Description                                                                      |
|--------------|----------------------------------------------------------------------------------|
| `client`     | Coroutine-powered JSON-RPC client with full NEAR RPC method wrappers (auto-generated) |
| `models`     | Kotlin `@Serializable` RPC request and response types (auto-generated)            |
| `generator`  | Tooling for generating Kotlin models and client APIs from NEAR’s OpenAPI spec     |

---

## ✨ Features

🎯 Type-Safe Design: Kotlin data class and sealed class models generated directly from NEAR’s OpenAPI specification for compile-time safety

⚡ Coroutine-First API: All network calls are suspend functions, designed for Kotlin Coroutines (structured concurrency)

🔐 Thread-Safe Concurrency: Client internals are safe for concurrent use (coroutine-friendly synchronization; optional actor model for high concurrency)

🛡️ Comprehensive Type System: kotlinx.serialization @Serializable models for all RPC requests and responses, including nullable and optional fields

📦 Minimal Official Dependencies: Small, explicit dependencies on well-known Kotlin libraries (e.g. kotlinx.serialization, ktor); no heavy frameworks required

🧪 Extensive Tests: Unit and integration tests (JUnit + MockK or kotlin.test) with mock responses and fixtures generated from OpenAPI examples

🔄 Auto-Generated Core: Models, request builders, and baseline tests are generated from NEAR’s OpenAPI spec

📱 Kotlin Multiplatform Friendly: Designed so common modules can be compiled for JVM/Android, iOS (via Kotlin/Native), JS and Desktop using Kotlin Multiplatform (KMP)

---

## ⚙️ Requirements

This library is built on top of [Ktor](https://ktor.io/) and [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization).  
So you must add the following Ktor dependencies to your project:

```kotlin
implementation("io.ktor:ktor-client-core:<ktor_version>")
implementation("io.ktor:ktor-client-cio:<ktor_version>") // or another engine (OkHttp, Darwin, etc.)
implementation("io.ktor:ktor-client-content-negotiation:<ktor_version>")
implementation("io.ktor:ktor-serialization-kotlinx-json:<ktor_version>")
```

---


## 🚀 Quickstart


You can easily add **NEAR-RPC-Client-Kotlin** to your project using JitPack.

### Step 1: Add the JitPack repository

In your **project-level** `build.gradle.kts`:

```kotlin

repositories { 
    maven { url = uri("https://jitpack.io") }
}

```

### Step 2: Add the dependency
In your **module-level** `build.gradle.kts`:

```kotlin

dependencies {
  implementation("com.github.hosseinkarami-dev.NEAR-RPC-Client-Kotlin:client:<Version>")
  implementation("com.github.hosseinkarami-dev.NEAR-RPC-Client-Kotlin:models:<Version>")
}

```

---

## 🛠️ Generator - Reproduce models & client

The `generator` module is a CLI that parses NEAR's OpenAPI spec and writes generated Kotlin types and the `NearClient` implementation.

Run the generator against NEAR's OpenAPI:
```bash
./gradlew :generator:run --args="--openapi-url https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json --models-out build/generated --client-out build/generated"
```

---

## 💡 Basic Usage

Use a single `HttpClient` instance for the app and call `NearClient` methods from a coroutine scope (e.g., `lifecycleScope`).

### Android example:
```kotlin
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.github.hosseinkarami_dev.near_rpc_client.NearClient
import io.github.hosseinkarami_dev.near_rpc_models.*

val httpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}

val nearClient = NearClient(
    httpClient = httpClient,
    baseUrl = "https://rpc.mainnet.near.org" // or "https://rpc.testnet.near.org"
)

lifecycleScope.launch {
  val response = nearClient.block(
    RpcBlockRequest.BlockId(BlockId.BlockHeight(167440515.toULong()))
  )

  when (response) {
    is RpcResponse.Failure -> {
      println("Error: ${response.error}")
    }

    is RpcResponse.Success -> {
      val result = response.getResultOrNull<RpcBlockResponse>()
      println("Result: $result")

    }
  }
}
```

**Broadcast tx example:**
```kotlin
val signedTx = SignedTransaction("BASE64_SIGNED_TX")
val req = RpcSendTransactionRequest(signedTxBase64 = signedTx, waitUntil = null)

when (val r = nearClient.broadcastTxAsync(req)) {
  is RpcResponse.Success -> println("tx hash: ${r.result}")
  is RpcResponse.Failure -> println("send failed: ${r.error}")
}
```

**Notes**
- You can use `getResultOrNull<T>()` directly on `RpcResponse`.  
  If the response is `Success`, it returns the typed model (e.g., `RpcBlockResponse`).  
  If it's `Failure`, it safely returns `null`.
- Prefer a single application-wide `HttpClient` (don't recreate per request).
- Close the client (`httpClient.close()`) when your app terminates.

---

## 🛠 Error Handling

This client leverages Kotlin's `sealed class` pattern to represent both successful and failed RPC responses in a type-safe and expressive way.

Each RPC call returns an instance of `RpcResponse<T>`:

```kotlin
sealed class RpcResponse<out T> {
    data class Success<T>(val result: T): RpcResponse<T>()
    data class Failure(val error: ErrorResult): RpcResponse<Nothing>()
}
```

### ✅ Success Response

On success, the response is of type `RpcResponse.Success` and contains the expected result:

```kotlin
val result = (response as RpcResponse.Success).result
```

### ❌ Failure Response

On failure, the response is of type `RpcResponse.Failure`, which wraps an `ErrorResult` instance describing the type of error.

The `ErrorResult` is a sealed class representing different error categories that can occur while performing an RPC call:

```kotlin
sealed class ErrorResult {
    data class Rpc(val error: RpcError): ErrorResult()                  // JSON-RPC level errors
    data class RpcRuntime(val error: String): ErrorResult()             // RPC runtime-related errors
    data class Http(val statusCode: Int, val body: String? = null): ErrorResult() // Non-2xx HTTP responses
    data class Timeout(val cause: Throwable? = null): ErrorResult()     // Request timed out
    data class Network(val cause: Throwable): ErrorResult()             // Network issues (e.g., UnknownHostException)
    data class Deserialization(val cause: Throwable, val rawBody: String? = null): ErrorResult() // JSON parsing issues
    data class Cancellation(val cause: Throwable? = null): ErrorResult() // Request was cancelled
    data class Unknown(val message: String? = null, val cause: Throwable? = null): ErrorResult() // Catch-all for unexpected errors
}
```

---

### 📌 Example Usage

Here’s how to handle both success and different types of errors in an RPC response:

```kotlin
val response = rpcClient.callSomeRpcMethod(params)

when (response) {
    is RpcResponse.Success -> {
        val result = response.result
        println("✅ RPC call succeeded: $result")
    }
    is RpcResponse.Failure -> {
        when (val error = response.error) {
            is ErrorResult.Rpc -> {
                println("❌ RPC Error: ${error.error.message} (code: ${error.error.code})")
            }
            is ErrorResult.Http -> {
                println("❌ HTTP Error: Status ${error.statusCode}, body: ${error.body}")
            }
            is ErrorResult.Timeout -> {
                println("⏳ Timeout Error: ${error.cause?.message}")
            }
            is ErrorResult.Network -> {
                println("🌐 Network Error: ${error.cause.message}")
            }
            is ErrorResult.Deserialization -> {
                println("🔄 Deserialization Error: ${error.cause.message}, raw body: ${error.rawBody}")
            }
            is ErrorResult.Cancellation -> {
                println("🚫 Request Cancelled: ${error.cause?.message}")
            }
            is ErrorResult.Unknown -> {
                println("❓ Unknown Error: ${error.message}, cause: ${error.cause?.message}")
            }
            is ErrorResult.RpcRuntime -> {
                println("⚠️ Runtime RPC Error: ${error.error}")
            }
        }
    }
}
```


This structured approach to error handling makes it easy to differentiate between expected JSON-RPC errors, HTTP/network issues, and unexpected failures — providing a clean and maintainable way to handle failures gracefully in your application.

---

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./gradlew test
```

### Test Structure

- **Unit Tests:** Validate the behavior of models and functions in isolation, including helpers, utilities, and serialization logic.
- **Integration Tests:** Validate end-to-end behavior of the client using a mock RPC engine, simulating actual RPC calls without requiring a live network connection.
- **Decoding Tests:** Ensure all `@Serializable` models correctly parse and map data from mock JSON responses.


---

## 🤝 Contributing

Contributions welcome!

1. Fork and create a branch.  
2. If you modify generator, include resulting generated files or open a separate PR to regenerate.  
3. Add tests for new behaviors.  
4. Run:
```bash
./gradlew build
./gradlew :generator:test
./gradlew :client:test
```
5. Open a PR with clear description.

---

## 📜 License

This project is licensed under the **Apache-2.0 License**. See [LICENSE](./LICENSE) for details.

---

## 📬 Contact & References

- JSON-RPC interface: https://docs.near.org/api/rpc/introduction  
- Other References:
  - Rust client: https://github.com/PolyProgrammist/near-openapi-client  
  - TypeScript client: https://github.com/near/near-jsonrpc-client-ts
  - Swift client: https://github.com/near/near-jsonrpc-client-swift
