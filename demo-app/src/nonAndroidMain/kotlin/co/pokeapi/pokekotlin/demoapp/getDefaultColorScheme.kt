package co.pokeapi.pokekotlin.demoapp

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
actual fun getDefaultColorScheme(isDark: Boolean): ColorScheme {
  return if (isDark) darkColorScheme() else lightColorScheme()
}
