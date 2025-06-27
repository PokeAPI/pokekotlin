set windows-shell := ["C:\\Program Files\\Git\\bin\\sh.exe", "-c"]

_default:
    just --list

# Serve PokeAPI data from static files
test-server:
    ./scripts/test-server

# Spawn a background job serving PokeAPI data from static files
test-server-background:
    ./scripts/test-server &

format:
    ./gradlew spotlessApply

test-jvm:
    ./gradlew jvmTest

test-js-browser:
    ./gradlew jsBrowserTest

test-js-node:
    ./gradlew jsNodeTest

test-wasm-browser:
    ./gradlew wasmBrowserTest

test-wasm-node:
    ./gradlew wasmNodeTest

native-host-test-task := (
    if os() == "macos" { "macosArm64Test" }
    else if os() == "linux" { "linuxX64Test" }
    else if os() == "windows" { "mingwX64Test" }
    else { error("Unrecognized OS: " + os()) }
)

test-native-host:
    ./gradlew {{ native-host-test-task }}

test-native-ios:
    ./gradlew iosSimulatorArm64Test

test-native-tvos:
    ./gradlew tvosSimulatorArm64Test

test-native-watchos:
    ./gradlew watchosSimulatorArm64Test

run-demo-desktop:
    ./gradlew :demo-app:run

run-demo-android:
    ./gradlew :demo-app:installDebug
    adb shell am start -n co.pokeapi.pokekotlin.demoapp/co.pokeapi.pokekotlin.demoapp.MainActivity

run-demo-js:
    ./gradlew :demo-app:jsBrowserDevelopmentRun

run-demo-wasm:
    ./gradlew :demo-app:wasmBrowserDevelopmentRun

run-demo-macos:
    ./gradlew :demo-app:runDebugExecutableMacosArm64

run-demo-ios:
    echo Not Implemented - Use XCode to run
    exit 1
