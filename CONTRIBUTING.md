# Contributing

## Creating issues

If you notice a discrepancy between PokeAPI's responses and PokeKotlin's object
models, you should create an issue and I'll fix it as soon as possible. You can
also post questions, feature suggestions, general support issues, or anything
else.

## Building

This project written in [Kotlin] and built with
[Kobalt]. To build the project from the command line,
clone the project and run the command `./kobaltw compile` from the project root
directory. You can also open the project in [IntelliJ IDEA] if you have the
Kobalt plugin.

## Submitting changes

Remember to always work in a separate branch, use descriptive commit messages,
and use pull requests to submit your changes. Always create an issue and mention
you're working on something first. Also, make sure that all tests pass. If you
add new fields or types, write the tests to check them against PokeAPI.


[Kotlin]:         https://kotlinlang.org/
[Kobalt]:         http://beust.com/kobalt/
[IntelliJ IDEA]:  https://www.jetbrains.com/idea/
