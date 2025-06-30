package co.pokeapi.pokekotlin.demoapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.demoapp.screens.PokemonListScreen
import co.pokeapi.pokekotlin.demoapp.screens.PokemonListScreenViewModel
import org.koin.compose.KoinApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val appModule = module {
  single<PokeApi> { PokeApi.Default }
  viewModel { PokemonListScreenViewModel(get()) }
}

@Composable
fun DemoApp() {
  KoinApplication(application = { modules(appModule) }) {
    MaterialTheme(
      colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
      // TODO nav
      PokemonListScreen()
    }
  }
}
