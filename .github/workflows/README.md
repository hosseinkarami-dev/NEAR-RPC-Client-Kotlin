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

### Key behaviours
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

---

## `test.yaml`

**First `name:` line:** `name: Run Tests with Coverage`

### Key behaviours
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

---

## `create-tag-and-release-on-merge.yml`

**First `name:` line:** `name: Create Tag & Release on merge to main`

### Key behaviours
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


