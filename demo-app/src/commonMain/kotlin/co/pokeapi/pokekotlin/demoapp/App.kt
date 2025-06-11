package co.pokeapi.pokekotlin.demoapp

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.model.NamedApiResource

@Composable
fun DemoApp() {
  MaterialTheme(colorScheme = getDefaultColorScheme()) {
    val species = remember { mutableStateListOf<NamedApiResource>() }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
      val list = PokeApi.getPokemonSpeciesList(0, 10000)
      species.clear()
      species.addAll(list.getOrNull()?.results ?: emptyList())
      isLoading = false
    }

    Scaffold(
      topBar = { TopAppBar(title = { Text("PokeKotlin Demo") }) },
      content = { innerPadding ->
        LazyColumn(
          modifier = Modifier.consumeWindowInsets(innerPadding),
          contentPadding = innerPadding,
        ) {
          if (isLoading) {
            item { CircularProgressIndicator() }
          } else {
            items(species) { it -> Text(it.name) }
          }
        }
      },
    )
  }
}

@Composable expect fun getDefaultColorScheme(isDark: Boolean = false): ColorScheme
