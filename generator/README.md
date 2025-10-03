# Generator

The `:generator` module is responsible for **automatically generating
source code** (models and client classes) from the NEAR RPC OpenAPI
specification.

------------------------------------------------------------------------

## 📦 Responsibilities

-   Fetch the latest OpenAPI specification
-   Generate model classes
-   Generate the RPC client (`NearClient.kt`)
-   Replace old sources with regenerated ones

------------------------------------------------------------------------

## ⚡ How to Run

### 1) Run Locally

To run the generator manually with default settings:

``` bash
./gradlew :generator:run
```

### 2) Run with Parameters

The generator accepts parameters via `--args`. Example:

``` bash
./gradlew :generator:run   --args="--openapi-url https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json --models-out build/generated --client-out build/generated"
```

**Parameters:** - `--openapi-url` → URL of the OpenAPI spec (local file
or remote URL)\
- `--models-out` → Output directory for generated models
- `--client-out` → Output directory for the generated client

------------------------------------------------------------------------

## 🛠️ Output Structure

After running the generator: 
- `:models` → contains all `data classes` and enums for NEAR RPC 
- `:client` → contains the `NearClient` implementation and RPC call functions

If you use `--models-out` or `--client-out`, the generated files will be
placed in those custom directories.

------------------------------------------------------------------------

## ✅ Running Tests

After generating the sources, you can run the test suite to make sure
the generated code compiles and works as expected:

```bash
./gradlew :generator:test

------------------------------------------------------------------------

------------------------------------------------------------------------

## 📖 Development Notes

-   The generator typically uses a custom implementation

------------------------------------------------------------------------

## 🚀 Goal

The goal of this module is to ensure developers always have an
**up-to-date Kotlin client** for the NEAR RPC API that stays in sync
with the official OpenAPI specification.
