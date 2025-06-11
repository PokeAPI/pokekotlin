package co.pokeapi.pokekotlin.test

/** Stub annotation to act as a typealias destination for non-applied Ignores. */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION) annotation class NoOpIgnore()

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION) expect annotation class IgnoreOnJvm()
