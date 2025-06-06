_default:
    just --list

test-server:
    npx -y http-server src/commonTest/resources/data -e json -p 8080
