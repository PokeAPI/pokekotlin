set windows-shell := ["C:\\Program Files\\Git\\bin\\sh.exe", "-c"]

_default:
    just --list

test-server:
    npx -y http-server src/commonTest/resources/data -e json -p 8080 --cors

test-server-background:
    npx -y http-server src/commonTest/resources/data -e json -p 8080 --cors &
