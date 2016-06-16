# Changelog

## 2.0.0

 - Redesigned how the client instance is obtained
 - Changed packaging structure

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