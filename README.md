# NEAR JSON-RPC Kotlin Client (Android / JVM)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](#)  
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](#)

A **type-safe**, generated Kotlin client for the NEAR JSON-RPC API. This repository contains:

- `near-rpc-models` — Generated Kotlin `@Serializable` types for OpenAPI schemas.  
- `near-rpc-client` — Ergonomic Kotlin client built on Ktor that exposes NEAR JSON-RPC methods as `suspend` functions.  
- `generator` — CLI tool that parses the NEAR OpenAPI spec and regenerates `models` and `client`.

> **Current status:** This library is published for **Android / JVM**. If the NEAR team or the community requests an official multi-platform release, migration to Kotlin Multiplatform (KMP) for iOS and Desktop will be considered.

---

## Table of contents

- [Why this project](#why-this-project)  
- [Status & Goals](#status--goals)  
- [Packaging & Maven coordinates](#packaging--maven-coordinates)  
- [Installation](#installation)  
- [Quickstart — Android example](#quickstart--android-example)  
- [API design & examples](#api-design--examples)  
- [Generator — reproduce models & client](#generator--reproduce-models--client)  
- [CI / CD & Publishing](#ci--cd--publishing)  
- [Troubleshooting](#troubleshooting)  
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

---

## Installation

Add the repository where you publish your artifacts (Maven Central, GitHub Packages, or local) and the dependency.

`build.gradle.kts`:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
  implementation("io.github.hosseinkarami_dev:near-rpc-client:0.1.0")
  implementation("io.github.hosseinkarami_dev:near-rpc-models:0.1.0")
}
```

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

// Example inside an Activity/Fragment:
lifecycleScope.launch {
    val response = nearClient.gasPrice(RpcGasPriceRequest(blockId = null))

    when (response) {
        is RpcResponse.Failure -> {
            // handle RPC error
            println("Error: ${response.error.code} ${response.error.message}")
        }
        is RpcResponse.Success -> {
            val result = response.result
            println("Gas price: ${result.gasPrice}")
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

Typical steps (local):

1. Run the generator against NEAR's OpenAPI:
```bash
./gradlew :generator:run --args="--openapi-url=https://raw.githubusercontent.com/near/nearcore/<path>/openapi.json --out-dir=."
```

2. Inspect generated files under `models` and `client`. Run tests and lint.

3. Commit generated code or open a PR with the regenerated files.

**Notes**
- The OpenAPI spec uses separate paths per method, but NEAR JSON-RPC expects one path (usually `/`). The generator patches this and emits JSON-RPC wrapper requests.  
- The generator unwraps response wrappers (e.g., `JsonRpcResponse_for_X_and_RpcError`) so methods return `RpcResponse<X>`.

---

## CI / CD & Publishing

Recommended workflows:
- **CI** (`.github/workflows/ci.yml`): run `./gradlew build test` on push / PR.  
- **Generate** (`.github/workflows/generate.yml`): scheduled or on push — fetch OpenAPI, run generator, open PR.  
- **Publish** (`.github/workflows/publish.yml`): runs on version tags `v*`, publishes to GitHub Packages or Maven Central.

Publishing notes:
- GitHub Packages: simpler, can publish on tag using `GITHUB_TOKEN`.  
- Maven Central (OSSRH): requires Sonatype account, PGP signing, and CI secrets (ossrh credentials and PGP key).

---

## Troubleshooting

**Invalid JSON-RPC envelope: Unexpected JSON token at path: $.id**  
- Cause: NEAR node returns `id` as a string but model expected numeric.  
- Fix: update `JsonRpcEnvelope` to use `String` or `JsonElement?` for `id`. Generator uses `String` by default to avoid this.

**Serializer / result wrapper issues**  
- If generator yields `RpcResponse<JsonRpcResponseFor...>` instead of `RpcResponse<X>`, fix generator to unwrap the wrapper and use appropriate serializers (including `ListSerializer` for arrays and non-nullable serializers for nullable patterns).

If you hit a problem, open an issue with the failing JSON and generated model snippet.

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

- NEAR OpenAPI spec: https://github.com/near/nearcore/.../openapi.json  
- Reference implementations:
  - Rust client: https://github.com/PolyProgrammist/near-openapi-client  
  - TypeScript client: https://github.com/near/near-jsonrpc-client-ts

If you want, I can also:
- produce a separate `README.md` for `client/` and `models/` modules, or  
- create the GitHub Actions workflows (`ci.yml`, `generate.yml`, `publish.yml`) for your repo.
