package co.pokeapi.pokekotlin.demoapp

import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

fun main() {
  NSApplication.sharedApplication()
  Window("PokeKotlin Demo") { DemoApp() }
  NSApp!!.run()
}
