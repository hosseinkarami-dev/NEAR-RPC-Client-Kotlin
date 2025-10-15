# GitHub Actions Workflows

This README documents the GitHub Actions workflow files present in this repository and the `regenerate-openapi-pr` workflow shared in the conversation.

## Included workflow files

- **release.yaml**
- **test.yaml**
- **create-tag-and-release-on-merge.yml**
- **regenerate-openapi-pr**

---

## Summary

This repository contains CI/CD workflows that handle tasks like releases, testing, tagging & releasing on merge, and regenerating a client from an OpenAPI spec and creating a PR if changes were generated. The workflows are intended to be run on GitHub Actions and use secrets for pushing/publishing (for example `PAT_TOKEN`, `GITHUB_TOKEN`, or other repository secrets).

Each workflow section below includes:
- Purpose and triggers
- Main steps and behavior
- Required secrets and permissions
- Notes, recommendations, and troubleshooting tips

---

## `release.yaml`

**First `name:` line:** `name: release-please`

### Key behaviours (high level)
Detected triggers (raw `on:` block):
```yaml
on:
  push:
    branches: [ main ]
```

_No explicit `permissions:` block detected._

**Secrets referenced in this workflow:**
- `PAT_TOKEN`

### Recommendations & notes
- Review the secrets referenced above and ensure least-privilege scopes (for PATs prefer `repo` with minimal scopes or use `GITHUB_TOKEN` when possible).
- Confirm `actions/checkout` version and `fetch-depth: 0` is used only when needed (it enables full git history).
- Check for any `if:` guard conditions to avoid self-trigger loops when workflows push to default branches.

### Raw file (for reference)
```yaml
name: release-please
on:
  push:
    branches: [ main ]
jobs:
  release:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: google-github-actions/release-please-action@v3
        with:
          token: ${{ secrets.PAT_TOKEN }}
          release-type: simple
```

---

## `test.yaml`

**First `name:` line:** `name: Run Tests with Coverage`

### Key behaviours (high level)
Detected triggers (raw `on:` block):
```yaml
on:
  workflow_run:
    workflows: ["Regenerate NEAR RPC Client (create PR)"]
    types:
      - completed
```

_No explicit `permissions:` block detected._

_No repository secrets referenced by pattern `${{ secrets.X }}` found in the file._

### Recommendations & notes
- Review the secrets referenced above and ensure least-privilege scopes (for PATs prefer `repo` with minimal scopes or use `GITHUB_TOKEN` when possible).
- Confirm `actions/checkout` version and `fetch-depth: 0` is used only when needed (it enables full git history).
- Check for any `if:` guard conditions to avoid self-trigger loops when workflows push to default branches.

### Raw file (for reference)
```yaml
name: Run Tests with Coverage

on:
  workflow_run:
    workflows: ["Regenerate NEAR RPC Client (create PR)"]
    types:
      - completed

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          distribution: temurin
          java-version: 17
      - name: Run tests with Kover
        run: ./gradlew koverHtmlReport koverVerify
```

---

## `create-tag-and-release-on-merge.yml`

**First `name:` line:** `name: Create Tag & Release on merge to main`

### Key behaviours (high level)
Detected triggers (raw `on:` block):
```yaml
on:
  push:
    branches:
      - main
```

Detected `permissions` block (raw):
```yaml
permissions:
  contents: write
  pull-requests: write
```

**Secrets referenced in this workflow:**
- `PAT_TOKEN`

### Recommendations & notes
- Review the secrets referenced above and ensure least-privilege scopes (for PATs prefer `repo` with minimal scopes or use `GITHUB_TOKEN` when possible).
- Confirm `actions/checkout` version and `fetch-depth: 0` is used only when needed (it enables full git history).
- Check for any `if:` guard conditions to avoid self-trigger loops when workflows push to default branches.

### Raw file (for reference)
```yaml
name: Create Tag & Release on merge to main

on:
  push:
    branches:
      - main

permissions:
  contents: write
  pull-requests: write

jobs:
  tag-and-release:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository (full history and tags)
        uses: actions/checkout@v4
        with:
          fetch-depth: 0

      - name: Get latest commit info
        id: commit_info
        run: |
          # latest commit subject and author email
          LAST_SUBJECT=$(git log -1 --pretty=format:%s)
          LAST_EMAIL=$(git log -1 --pretty=format:%ae)
          echo "last_subject=${LAST_SUBJECT}" >> $GITHUB_OUTPUT
          echo "last_email=${LAST_EMAIL}" >> $GITHUB_OUTPUT
          echo "Subject: $LAST_SUBJECT"
          echo "Author email: $LAST_EMAIL"

      - name: Check if this is a regenerated commit
        id: should_run
        run: |
          SUBJECT="${{ steps.commit_info.outputs.last_subject }}"
          EMAIL="${{ steps.commit_info.outputs.last_email }}"

          echo "Checking if commit indicates regeneration..."

          if [[ "$EMAIL" == "automation@github.com" ]]; then
            echo "Detected automation author email."
            echo "run_release=true" >> $GITHUB_OUTPUT
            exit 0
          fi

          if echo "$SUBJECT" | grep -qi "regenerate client\|regenerate openapi\|regenerate"; then
            echo "Detected regenerate in commit message."
            echo "run_release=true" >> $GITHUB_OUTPUT
            exit 0
          fi

          echo "No regenerate indicator found. Skipping tag/release."
          echo "run_release=false" >> $GITHUB_OUTPUT

      - name: Stop if not a regenerate commit
        if: ${{ steps.should_run.outputs.run_release == 'false' }}
        run: |
          echo "This push doesn't look like a regenerated commit. Exiting."
          exit 0

      - name: Determine new tag version
        id: tag
        run: |
          # Get last tag, default to v0.0.0
          LAST_TAG=$(git describe --tags --abbrev=0 2>/dev/null || echo "v0.0.0")
          echo "Last tag: $LAST_TAG"

          # increment patch version by 1
          IFS='.' read -r MAJOR MINOR PATCH <<<"${LAST_TAG#v}"
          # ensure numeric fallback
          MAJOR=${MAJOR:-0}
          MINOR=${MINOR:-0}
          PATCH=${PATCH:-0}
          NEW_TAG="v${MAJOR}.${MINOR}.$((PATCH+1))"

          echo "new_tag=${NEW_TAG}" >> $GITHUB_OUTPUT
          echo "New tag determined: ${NEW_TAG}"

      - name: Create and push tag
        env:
          PAT_TOKEN: ${{ secrets.PAT_TOKEN }}
        run: |
          NEW_TAG="${{ steps.tag.outputs.new_tag }}"
          echo "Creating tag ${NEW_TAG} and pushing..."
          git tag "${NEW_TAG}"
          git push "https://x-access-token:${PAT_TOKEN}@github.com/${GITHUB_REPOSITORY}.git" "${NEW_TAG}"

      - name: Create GitHub Release
        uses: softprops/action-gh-release@v1
        with:
          tag_name: ${{ steps.tag.outputs.new_tag }}
          name: "Release ${{ steps.tag.outputs.new_tag }}"
          body: |
            🚀 Automated release generated by workflow.
            This release was created automatically after merging the regenerated client into main.
        env:
          GITHUB_TOKEN: ${{ secrets.PAT_TOKEN }}
```

---

## `regenerate-openapi-pr.yml`

**Summary:** Regenerates the NEAR RPC client (via a Gradle generator), builds and tests the project, and — if changes are produced — creates a branch and opens a Pull Request with the generated changes.

### Triggers
- Manual (`workflow_dispatch`)
- On push to `main`
- Scheduled daily at midnight (cron: `0 0 * * *`)

### Permissions required
- `contents: write` to push branches and commit generated code.
- `pull-requests: write` to create PRs (the workflow uses a `PAT_TOKEN` as provided via secrets).

### Secrets & Env detected
- `PAT_TOKEN` — used to push the branch and authenticate PR creation via `actions/github-script`.

### Important steps and safety guards
- Exits early when `github.actor == 'github-actions[bot]'` to avoid infinite self-triggering loops.
- Uses `fetch-depth: 0` to enable creating branches from the checked-out repo with full history.
- Creates a branch named: `regenerate-openapi-${{ GITHUB_RUN_NUMBER }}-${{ SHORT_SHA }}`
- Checks whether any files are staged/changed before creating a commit and PR; if no changes, it does nothing.

### Recommendations & improvements
- Prefer `GITHUB_TOKEN` for creating PRs if possible (it avoids storing a PAT), but `GITHUB_TOKEN` cannot be used to create a PR in all scenarios or with the same permissions as a PAT. Evaluate whether `GITHUB_TOKEN` suffices.
- Add linting/formatting steps to keep generated code consistent automatically.
- Add labels or reviewers automatically in the PR creation step (via `actions/github-script` or `peter-evans/create-pull-request`).
- Consider gating daily runs behind a check to avoid frequent churn (only regenerate on spec changes or weekly).

### Full workflow content (as provided):
```yaml
name: Regenerate NEAR RPC Client (create PR)

on:
  workflow_dispatch:
  push:
    branches:
      - main
  schedule:
    - cron: "0 0 * * *" # daily run (every day at midnight)

permissions:
  contents: write
  pull-requests: write

jobs:
  regenerate-and-pr:
    runs-on: ubuntu-latest

    steps:
      # Avoid infinite loop triggered by GitHub Actions
      - name: Exit if triggered by GitHub Actions bot
        if: github.actor == 'github-actions[bot]'
        run: |
          echo "Triggered by GitHub Actions bot; exiting to avoid loop."
          exit 0

      # Checkout repo
      - name: Checkout repository
        uses: actions/checkout@v3
        with:
          fetch-depth: 0
          persist-credentials: true

      # Setup JDK
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          distribution: temurin
          java-version: 21

      # Grant execute permission for Gradle
      - name: Grant execute permission for gradlew
        run: chmod +x ./gradlew

      # Run Generator (regenerates client + models)
      - name: Run Generator
        run: ./gradlew :generator:run --args="--openapi-url https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json" --no-daemon

      # Build and run tests
      - name: Build project (and run tests)
        run: ./gradlew build --stacktrace --no-daemon

      # Prepare branch, commit changes, push
      - name: Prepare branch, commit regenerated sources
        id: commit
        env:
          PAT_TOKEN: ${{ secrets.PAT_TOKEN }}
        run: |
          set -euo pipefail

          git config --local user.email "automation@github.com"
          git config --local user.name "GitHub Actions Bot"

          # create unique branch
          SHORT_SHA=${GITHUB_SHA:0:8}
          BRANCH="regenerate-openapi-${GITHUB_RUN_NUMBER}-${SHORT_SHA}"

          git checkout -b "$BRANCH"

          git add .

          # check if any changes
          if git diff --staged --quiet; then
            echo "No changes to commit"
            echo "pr_required=false" >> "$GITHUB_OUTPUT"
            exit 0
          fi

          git commit -m "fix: regenerate client from OpenAPI"
          git push https://x-access-token:${PAT_TOKEN}@github.com/${GITHUB_REPOSITORY}.git "$BRANCH"

          echo "pr_required=true" >> "$GITHUB_OUTPUT"
          echo "branch=$BRANCH" >> "$GITHUB_OUTPUT"

      # Create Pull Request if changes exist
      - name: Create Pull Request for regenerated sources
        if: steps.commit.outputs.pr_required == 'true'
        uses: actions/github-script@v6
        with:
          github-token: ${{ secrets.PAT_TOKEN }}
          script: |
            const branch = '${{ steps.commit.outputs.branch }}';
            const title = `chore: regenerate client from OpenAPI (${branch})`;
            const body = `This PR regenerates the NEAR RPC client and models from the latest OpenAPI spec.\n\nPlease review the generated code and run CI checks.`;

            const pr = await github.rest.pulls.create({
              owner: context.repo.owner,
              repo: context.repo.repo,
              title,
              head: branch,
              base: "main",
              body
            });

            return { pr_number: pr.data.number, pr_url: pr.data.html_url };

      # Output when no changes
      - name: Output when no changes
        if: steps.commit.outputs.pr_required != 'true'
        run: echo "No regenerated changes — nothing to create a PR for."
```

---

## Troubleshooting & FAQ

**Q: No PR is created even though I expect changes. What to check?**
- Ensure `PAT_TOKEN` (or whichever token the workflow uses) is valid and has `repo` or equivalent scopes to push branches and create PRs.
- Check workflow logs: the `Prepare branch` step prints `No changes to commit` when generator produced no diffs.
- Confirm the generator command ran successfully (look for `Run Generator` step logs).

**Q: Workflow is retriggering itself causing a loop.**
- Make sure to keep the `if: github.actor == 'github-actions[bot]'` guard or add `paths-ignore`/`paths` rules to `on: push` to avoid triggering on commits made by the workflow itself.
- Alternatively, use a dedicated bot account and guard by actor name, or use `pull_request_target` carefully with limited steps.

**Q: How to run any workflow manually?**
- Use the `Actions` tab in GitHub, pick the workflow, and click `Run workflow` (if `workflow_dispatch` is declared).

## Security notes
- Keep PATs and any tokens in repository secrets, never hard-code them in workflows.
- Restrict PAT scopes to the minimum necessary for the workflow to operate.
- Avoid exposing secrets in logs (don't `echo` secret values).

## Contributing
If you want to improve these workflows, consider:
- Adding tests or dry-run modes for generation steps.
- Including `paths` filters to make triggers more targeted.
- Using reusable workflows for common steps (checkout, setup-java, build).

## File location
The workflows are expected to live under `.github/workflows/` in your repository.

---


