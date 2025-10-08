# NEAR JSON-RPC Kotlin Client (Android / JVM)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](#)  
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](#)

A **type-safe**, generated Kotlin client for the NEAR JSON-RPC API. This repository contains:

- `near-rpc-models` — Generated Kotlin `@Serializable` types for OpenAPI schemas.  
- `near-rpc-client` — Ergonomic Kotlin client built on Ktor that exposes NEAR JSON-RPC methods as `suspend` functions.  
- `generator` — CLI tool that parses the NEAR OpenAPI spec and regenerates `models` and `client`.

> **Current status:** This library is published for **Android / JVM**. The base code is written entirely in Kotlinx Serialization and Ktor, so it can be easily ported to Kotlin MultiPlatform (with some minor changes, of course). If the NEAR team or the community requests an official multi-platform release, migration to KMP for iOS and Desktop will be considered.

---

## Table of contents

- [Why this project](#why-this-project)  
- [Status & Goals](#status--goals)  
- [Requirements](#requirements)  

[//]: # (- [Installation]&#40;#installation&#41;  )
- [Quickstart — Android example](#quickstart--android-example)  
- [API design & examples](#api-design--examples)  
- [Generator — reproduce models & client](#generator--reproduce-models--client)
- [Contributing](#contributing)  
- [License](#license)  
- [Contact & References](#contact--references)

---

## Why this project

NEAR provides an OpenAPI specification for its JSON-RPC interface, but a high-quality Kotlin client optimized for Android developers was missing. This project:

- Auto-generates Kotlin models + a typed client from NEAR's OpenAPI spec.
- Uses `kotlinx.serialization` and Ktor for serialization and HTTP.  
- Splits types and client so consumers can depend only on what they need.

---

## Status & Goals

- ✅ Generator that parses the OpenAPI spec and produces Kotlin `data class` models.  
- ✅ JVM / Android client built on Ktor (suspend functions, `RpcResponse<T>` wrapper).
- 🚧 Future: optional migration to Kotlin Multiplatform on request.

---

## Requirements

This library is built on top of [Ktor](https://ktor.io/) and [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization).  
When using `near-rpc-client`, you must add the following Ktor dependencies to your project:

```kotlin
implementation("io.ktor:ktor-client-core:<ktor_version>")
implementation("io.ktor:ktor-client-cio:<ktor_version>") // or another engine (OkHttp, Darwin, etc.)
implementation("io.ktor:ktor-client-content-negotiation:<ktor_version>")
implementation("io.ktor:ktor-serialization-kotlinx-json:<ktor_version>")
```

[//]: # (---)

[//]: # ()
[//]: # (## Installation)

[//]: # ()
[//]: # (Add the repository where you publish your artifacts &#40;Maven Central, GitHub Packages, or local&#41; and the dependency.)

[//]: # ()
[//]: # (`build.gradle.kts`:)

[//]: # ()
[//]: # (```kotlin)

[//]: # (repositories {)

[//]: # (    mavenCentral&#40;&#41;)

[//]: # (})

[//]: # ()
[//]: # (dependencies {)

[//]: # (  implementation&#40;"io.github.hosseinkarami_dev:near-rpc-client:0.1.0"&#41;)

[//]: # (  implementation&#40;"io.github.hosseinkarami_dev:near-rpc-models:0.1.0"&#41;)

[//]: # (})

[//]: # (```)

For local testing:
```bash
./gradlew :models:publishToMavenLocal
./gradlew :client:publishToMavenLocal
```

---

## Quickstart — Android example

Use a single `HttpClient` instance for the app and call `NearClient` methods from a coroutine scope (e.g., `lifecycleScope`).

```kotlin
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
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

// Block Details Example:
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

// Status Example:
lifecycleScope.launch {
    val response = nearClient.status()

    when (response) {
        is RpcResponse.Failure -> {
            println("Error: ${response.error}")
        }

        is RpcResponse.Success -> {
            val result = response.getResultOrNull<RpcStatusResponse>()
            println("Result: $result")

        }
    }
}
```

**Notes**
- Prefer a single application-wide `HttpClient` (don't recreate per request).  
- Close the client (`httpClient.close()`) when your app terminates.  
- Use `Json { ignoreUnknownKeys = true }` — NEAR nodes may return extra fields.

---

## API design & examples

- RPC methods are `suspend` functions on `NearClient`.  
- Each method returns `RpcResponse<T>` (sealed): `Success(result)` or `Failure(error)`.  
- `query`-style RPCs accept typed request objects (generated models).

**Status example**
```kotlin
val resp = nearClient.status()
when (resp) {
  is RpcResponse.Success -> println("chainId = ${resp.result.chainId}")
  is RpcResponse.Failure -> println("error: ${resp.error}")
}
```

**Broadcast tx example**
```kotlin
val signedTx = SignedTransaction("BASE64_SIGNED_TX")
val req = RpcSendTransactionRequest(signedTxBase64 = signedTx, waitUntil = null)

when (val r = nearClient.broadcastTxAsync(req)) {
  is RpcResponse.Success -> println("tx hash: ${r.result}")
  is RpcResponse.Failure -> println("send failed: ${r.error}")
}
```

---

## Generator — reproduce models & client

The `generator` module is a CLI that parses NEAR's OpenAPI spec and writes generated Kotlin types and the `NearClient` implementation.

Run the generator against NEAR's OpenAPI:
```bash
./gradlew :generator:run --args="--openapi-url https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json --models-out build/generated --client-out build/generated
```

---

## Contributing

Contributions welcome!

1. Fork and create a branch.  
2. If you modify generator, include resulting generated files or open a separate PR to regenerate.  
3. Add tests for new behaviors.  
4. Run:
```bash
./gradlew build
./gradlew :models:test
./gradlew :client:test
```
5. Open a PR with clear description.

---

## License

This project is licensed under the **Apache-2.0 License**. See [LICENSE](./LICENSE) for details.

---

## Contact & References

- JSON-RPC interface: https://docs.near.org/api/rpc/introduction  
- Other References:
  - Rust client: https://github.com/PolyProgrammist/near-openapi-client  
  - TypeScript client: https://github.com/near/near-jsonrpc-client-ts
