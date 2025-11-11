# 🧩 Project Structure & Overview

This project — **NEAR RPC Client Kotlin** — is an automated Kotlin client generator designed to interact with the [NEAR Protocol RPC API](https://docs.near.org/api/rpc/introduction).  
It uses the official **OpenAPI specification** from the NEAR core repository to generate strongly-typed Kotlin models and a complete RPC client automatically.

The goal is to provide a reliable, up-to-date, and fully automated Kotlin client for developers building tools, SDKs, or integrations on top of NEAR.

---

## 📁 Project Structure

```
NEAR-RPC-Client-Kotlin/
├── generator/                # Generates Kotlin sources (client + models) from NEAR OpenAPI spec
│   ├── src/main/kotlin/...
│   ├── build.gradle.kts
│   └── resources/
│
├── client/                   # Core RPC client implementation
│   ├── src/main/kotlin/...
│   ├── build.gradle.kts
│   └── README.md
│
├── models/                   # Generated data models for NEAR RPC methods
│   ├── src/main/kotlin/...
│   ├── build.gradle.kts
│   └── README.md
│
├── .github/
│   └── workflows/
│       └── ci-cd.yml         # Full CI/CD pipeline for generation, build, and release
│
├── build.gradle.kts          # Root Gradle build file
├── settings.gradle.kts       # Gradle module definitions
├── DEPLOYMENT.md             # Deployment guide (this document)
└── README.md                 # Project introduction and usage examples
```

## ⚙️ Module Overview

| Module | Description |
|--------|--------------|
| **generator** | Runs the OpenAPI code generation. It fetches the latest NEAR RPC spec and regenerates Kotlin client + model sources. |
| **client** | Contains the RPC client logic. Handles HTTP requests, serialization/deserialization, and API calls to NEAR nodes. |
| **models** | Includes all generated Kotlin data classes that represent NEAR RPC request and response objects. |

---

## 🧠 How It Works (High-Level)

1. The **generator module** downloads the official NEAR RPC OpenAPI specification.
2. It automatically generates updated Kotlin models and the RPC client.
3. The CI/CD pipeline detects changes, commits them to a new branch, merges automatically, and creates a new semantic versioned release.
4. The release is published under a new tag (`vx.x.x`), ensuring the client always stays synced with the latest NEAR RPC changes.

---

## ⚙️ CI/CD Workflow & Versioning

### Overview
The repository uses a fully automated **CI/CD pipeline** powered by GitHub Actions.
This workflow runs either **manually** or **on a daily schedule**, automatically regenerating the NEAR RPC Client from the latest OpenAPI specification, committing changes, merging them into `main`, and publishing a new tagged release.

### Workflow Triggers
- **`workflow_dispatch`** — Manual trigger (run on demand)
- **`schedule`** — Automatic daily run at **00:00 UTC**

### Pipeline Steps (Simplified Flow)
1. **Checkout repository** → Fetches the full repository including tags and history.
2. **Setup JDK 21** → Installs the required JDK for building the Kotlin project.
3. **Generate client** → Runs `:generator:run` with the latest NEAR OpenAPI spec.
4. **Build project** → Compiles all modules (tests are skipped for speed).
5. **Commit & Push changes** → If differences are found, a new branch is created and pushed.
6. **Auto Pull Request & Merge** → Automatically opens and merges a PR into `main`.
7. **Version bump** → Determines the latest tag and increments the **patch** version automatically.
8. **Tag & Release** → Creates a new Git tag and publishes a GitHub release.

### Automatic Versioning Logic
- The workflow fetches all remote tags from `origin`.
- Version tags follow the **semantic versioning** format: `vMAJOR.MINOR.PATCH` (e.g., `v1.0.3`).
- On each successful regeneration and merge, the **PATCH** component is incremented.
- If the generated tag already exists (e.g., due to concurrent workflows), it automatically increments further until a unique tag is found.

### Example of Version Progression
| Previous Tag | New Tag | Change Type | Notes |
|---------------|---------|-------------|-------|
| v1.0.0       | v1.0.1 | Patch       | First regeneration and release |
| v1.0.1       | v1.1.0 | Minor       | New feature added in OpenAPI spec |
| v1.1.0       | v2.0.0 | Major       | Breaking changes in API contract |
### Commit Convention & Tagging Rules
This project follows **Conventional Commits** for commit messages:
- **`feat:`** → New features (increments minor version)
- **`fix:`** → Bug fixes (increments patch version)
- **`chore:`** → Maintenance tasks, build or generator changes (no version bump)
- **`docs:`** → Documentation updates (no version bump)
- **`refactor:`** → Code refactoring without functional change (no version bump)
- **`test:`** → Adding or updating tests (no version bump)

Following these rules ensures semantic versioning is consistent and releases reflect the type of changes applied.

---

## 🛠 Environment / Prerequisites
- **JDK 21** installed (Temurin recommended)
- **Gradle 8+** (wrapper included)
- Internet access to fetch dependencies and OpenAPI spec
- Linux / macOS / Windows supported (CI tested on Ubuntu runners)

---

## 🚀 Deployment / Publishing Instructions
1. After CI/CD runs successfully, a new **GitHub release** is created with the corresponding version tag.
2. Generated client (`client/`) and models (`models/`) can be included in other Kotlin projects via Gradle:
   ```kotlin
   implementation("com.github.hosseinkarami-dev.NEAR-RPC-Client-Kotlin:models:<VERSION>")
   implementation("com.github.hosseinkarami-dev.NEAR-RPC-Client-Kotlin:client:<VERSION>")
   ```
3. Always use the **latest release tag** in your consuming projects to ensure compatibility.

---

## ⚠️ Troubleshooting / Common Issues
- **Generator fails** → Check OpenAPI spec URL and network access.
- **Build fails** → Verify JDK version and Gradle wrapper; clean build may help:
  ```bash
  ./gradlew clean build
  ```
- **Tag conflicts** → Occurs if multiple workflows run concurrently. Workflow automatically retries with next patch number.

---

## 📖 Changelog / Release Notes Policy
- Every release should reference the **commits included** following conventional commits.
- Example format in GitHub Release description:
  ```
  🚀 Automated release generated by workflow.
  Includes:
    - feat: Added new method xyz
    - fix: Corrected response parsing for abc
    - chore: Regenerated client from OpenAPI
  ```

---

## 📞 Contact / Support
- For CI/CD issues, generator problems, or publishing questions, open an issue in the repository or contact **maintainers via GitHub**.