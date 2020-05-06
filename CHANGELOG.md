# Changelog

## 2.3.1

 - Update dependencies
 - Publish on GitHub Packages since Bintray can't be relied on

## 2.3.0

 - Add model `PokemonSpeciesFlavorText`
 - Add property `flavorTextEntries` to model `PokemonSpecies`

## 2.2.4

 - Update Kobalt to fix an issue with the POM

## 2.2.3

 - Fix pokekotlin-skaffold to pokekotlin dependency

## 2.2.2

 - Switch to GSON because Jackson was bloating the method count

## 2.2.1

 - Fix a dependency typo

## 2.2.0

 - Support for [Skaffold](https://github.com/pokesource/skaffold) data sources

## 2.1.0

 - `ApiResource` and `NamedApiResource` implement `ResourceSummary`
 - `ApiResourceList` and `NamedApiResourceList` implement `ResourceSummaryList`

## 2.0.0

 - Changed how the client instance is obtained
 - Changed some class names and package structure
 - Stopped exposing some internal implementation details

## 1.2.1

 - Removed workaround for negative IDs since it's now fixed on PokeApi's end

## 1.2.0

 - Removed `Pokemon.locationAreaEncounters: List<LocationAreaEncounter>`
 - Added `getPokemonEncounters(id: Int): List<LocationAreaEncounter>`

## 1.1.1

 - Fixed some fields that should be nullable but were not
 - Changed the default client to use https

## 1.1.0

 - Added support for sprite fields on `Item`, `Pokemon`, and `PokemonForm`

## 1.0.0

 - Initial stable release

## 0.x.y

 - Buggy development releases
