# Workflows — Quick Developer Summary

## Covered workflows
- **release.yaml** — release publishing (verify tags, sign/publish steps).
- **test.yaml** — CI and test matrix.
- **create-tag-and-release-on-merge.yml** — automatic tagging and GitHub Release on merge.
- **regenerate-openapi-pr.yml** — regenerates NEAR RPC client from OpenAPI and opens a PR if changes occur.

## How `regenerate-openapi-pr.yml` works (short)
- Runs daily, on push to `main`, and manually.
- Executes a Gradle generator to regenerate client code from the NEAR OpenAPI spec.
- Builds/tests the project; if changes exist, creates a branch and opens a PR.
- Guard: exits early if `github.actor == 'github-actions[bot]'` to prevent loops.

## Required secrets & permissions
- `PAT_TOKEN` (used to push branches and create PRs) — restrict scope; prefer `GITHUB_TOKEN` when possible.
- Workflow needs `contents: write` and `pull-requests: write`.

## Quick local reproduction
1. Run generation and build:
   ```bash
   ./gradlew :generator:run --args="--openapi-url <OPENAPI_URL>" --no-daemon
   ./gradlew build --no-daemon
   ```
2. If changes, create a branch and push; open a PR via GitHub UI.

## Troubleshooting (fast)
- **No PR created**: logs show `No changes to commit` — generator produced no diffs.
- **Push fails**: check `PAT_TOKEN` validity and scopes.
- **Workflow retriggers**: verify the actor guard and consider `paths-ignore` for generated dirs.

## Tips
- Add auto-formatting in CI to reduce churn.
- Use `peter-evans/create-pull-request` if you want labels/reviewers automatically.
- Keep PAT scopes minimal and rotate tokens regularly.

## Where to look
- Generator module: `:generator` (in repo)
- OpenAPI source: `https://raw.githubusercontent.com/near/nearcore/master/chain/jsonrpc/openapi/openapi.json`
- GitHub Actions docs: https://docs.github.com/actions
