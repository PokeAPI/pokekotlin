package co.pokeapi.pokekotlin.internal

import kotlin.annotation.AnnotationTarget.*
import kotlin.js.ExperimentalJsExport

@ExperimentalJsExport
@Retention(AnnotationRetention.BINARY)
@Target(CLASS, PROPERTY, FUNCTION, FILE)
internal expect annotation class JsOnlyExport()

@Retention(AnnotationRetention.BINARY)
@Target(CLASS, PROPERTY, FUNCTION, FILE)
internal annotation class NoOpExport()
