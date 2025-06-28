package co.pokeapi.pokekotlin.demoapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.model.NamedApiResource
import co.pokeapi.pokekotlin.model.NamedApiResourceList
import co.pokeapi.pokekotlin.model.PokemonSpecies

@Composable
fun PokemonListItem(pokemon: PokemonSpecies) {
  ListItem(
    modifier = Modifier.clickable(onClick = {}),
    headlineContent = { Text(pokemon.names.first { it.language.name == "en" }.name) },
    supportingContent = {
      Text(
        pokemon.flavorTextEntries
          .filter { it.language.name == "en" }
          .maxBy { it.version.id }
          .flavorText
          .replace(Regex("\\s"), " "),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
      )
    },
  )
}

@Composable
fun PokemonListItemPlaceholder(summary: NamedApiResource) {
  ListItem(headlineContent = { Text("Loading: ${summary.name}") })
}

@Composable
fun PokemonListItemError(summary: NamedApiResource, message: String) {
  ListItem(
    headlineContent = { Text("Failed to load: ${summary.name}") },
    supportingContent = { Text(message) },
  )
}

@Composable
fun PokemonList(padding: PaddingValues, pokemon: NamedApiResourceList) {
  Box(Modifier.consumeWindowInsets(padding).fillMaxSize()) {
    LazyColumn(contentPadding = padding) {
      items(pokemon.results) { summary ->
        var result by remember { mutableStateOf<Result<PokemonSpecies>?>(null) }
        LaunchedEffect(Unit) { result = runCatching { PokeApi.getPokemonSpecies(summary.id) } }
        result
          ?.onSuccess { PokemonListItem(it) }
          ?.onFailure { PokemonListItemError(summary, it.message ?: "Unknown error") }
          ?: PokemonListItemPlaceholder(summary)
      }
    }
  }
}

@Composable
fun CenteredLoading(padding: PaddingValues) {
  Box(
    Modifier.consumeWindowInsets(padding).padding(padding).fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    CircularProgressIndicator()
  }
}

@Composable
fun ErrorMessage(padding: PaddingValues, message: String) {
  Box(
    Modifier.consumeWindowInsets(padding).padding(padding).fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    Text(message)
  }
}

@Composable
fun DemoApp() {
  MaterialTheme(colorScheme = getDefaultColorScheme()) {
    Scaffold(
      topBar = { TopAppBar(title = { Text("PokeKotlin Demo") }) },
      content = { innerPadding ->
        var result by remember { mutableStateOf<Result<NamedApiResourceList>?>(null) }
        LaunchedEffect(Unit) { result = runCatching { PokeApi.getPokemonSpeciesList(0, 100000) } }
        result
          ?.onSuccess { PokemonList(innerPadding, it) }
          ?.onFailure {
            ErrorMessage(
              padding = innerPadding,
              message = result!!.exceptionOrNull()!!.message ?: "Unknown error",
            )
          } ?: CenteredLoading(innerPadding)
      },
    )
  }
}

@Composable expect fun getDefaultColorScheme(isDark: Boolean = false): ColorScheme
