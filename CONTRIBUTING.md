# Contributing

## Find or file an issue to work on

If you're looking to add a feature or fix a bug and there's no issue filed yet,
it's good to
[file an issue](https://github.com/pokeapi/pokekotlin/issues/new/choose) first
to have a discussion about the change before you start working on it.

If you're new and looking for things to contribute, see our
[good first issue](https://github.com/pokeapi/pokekotlin/issues?q=is%3Aissue%20state%3Aopen%20label%3A%22good%20first%20issue%22)
label. These issues are usually ready to work on and don't require deep
knowledge of the library's internals.

## Development Environment Setup

### Prerequisites

1. **IDE**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) is recommended.
   VSCode and other editors won't work well, as this is a Kotlin project and
   there's not yet a stable LSP for Kotlin.
2. **Node.js**: Required for running the test server. Instructions can be found
   at [nodejs.org](https://nodejs.org/en/download).
3. **Just** (optional): A command runner that simplifies running common tasks.
   Installation instructions can be found at
   [just.systems](https://just.systems/man/en/).

### Cloning the Repository

This repository uses a Git submodule for test data. When cloning, make sure to
include the `--recurse-submodules` flag:

```bash
git clone --recurse-submodules 'https://github.com/PokeAPI/pokekotlin.git'
```

If you've already cloned the repository without submodules, you can initialize
them with:

```bash
git submodule update --init --recursive
```

### IDE Setup

1. Open the project in IntelliJ IDEA or similar IDE.
2. Make sure you have the Kotlin Multiplatform plugin installed. This should be
   included by default in recent versions of IntelliJ IDEA and Android Studio.
3. For more information on setting up Kotlin Multiplatform, refer to the
   [official Kotlin Multiplatform documentation](https://kotlinlang.org/docs/multiplatform-get-started.html).

## Running Tests

Most tests in this project rely on a local server that serves the PokeAPI data
from static files. The server needs to be running before executing the tests.

### Starting the Test Server

You can start the test server using the provided script:

```bash
./scripts/test-server
```

Or if you have Just installed, you can use:

```bash
just test-server
```

### Running Tests

The project includes tests for various platforms. You can run them using Gradle
directly or through the Just commands. For details on available commands, see
the [`justfile`](./justfile) in the project root or run:

```bash
just
```

## Code Formatting

The project uses Spotless for code formatting. You can apply the formatting
rules with:

```bash
just format
```

Or using Gradle directly:

```bash
./gradlew spotlessApply
```

If you'd prefer to apply automatically on commit, opt in to the pre-commit hook
with:

```bash
./gradlew installGitHooks
```
