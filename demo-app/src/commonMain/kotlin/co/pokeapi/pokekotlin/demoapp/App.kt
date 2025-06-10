package co.pokeapi.pokekotlin.demoapp

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun DemoApp(navController: NavHostController = rememberNavController()) {
  MaterialTheme(colorScheme = getDefaultColorScheme()) { Text("Hello, PokeKotlin") }
}

@Composable expect fun getDefaultColorScheme(isDark: Boolean = false): ColorScheme
