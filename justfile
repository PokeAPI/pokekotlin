set windows-shell := ["C:\\Program Files\\Git\\bin\\sh.exe", "-c"]

_default:
    just --list

test-server-cmd := "npx -y http-server src/commonTest/resources/data -e json -p 8080 --cors"

# Serve PokeAPI data from static files
test-server:
    {{ test-server-cmd }}

# Spawn a background job serving PokeAPI data from static files
test-server-background:
    {{ test-server-cmd }} &
