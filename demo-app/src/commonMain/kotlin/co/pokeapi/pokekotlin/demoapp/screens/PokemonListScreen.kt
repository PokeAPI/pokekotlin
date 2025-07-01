package co.pokeapi.pokekotlin.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.demoapp.util.ioDispatcher
import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.PokemonVariety
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.compose.viewmodel.koinViewModel

sealed interface LoadingStatus<out T> {
  data class Success<T>(val value: T) : LoadingStatus<T>

  data class Error(val throwable: Throwable) : LoadingStatus<Nothing>

  data object Loading : LoadingStatus<Nothing>
}

typealias PokemonListStatus = LoadingStatus<List<Handle.Named<PokemonVariety>>>

typealias PokemonListItemStatus = LoadingStatus<PokemonVariety>

class PokemonListScreenViewModel(private val api: PokeApi) : ViewModel() {
  val summaries = mutableStateOf<PokemonListStatus>(LoadingStatus.Loading)
  val details = mutableStateMapOf<Handle<PokemonVariety>, PokemonListItemStatus>()

  init {
    loadPokemonList()
  }

  private fun loadPokemonList() {
    viewModelScope.launch {
      withContext(ioDispatcher) {
        try {
          val emptyList = api.getPokemonVarietyList(0, 0)
          val pokemonList = api.getPokemonVarietyList(0, emptyList.count)
          summaries.value = LoadingStatus.Success(pokemonList.results)

          // Start loading details for the first few Pokemon
          pokemonList.results.take(20).forEach { pokemon -> loadPokemonDetails(pokemon) }
        } catch (e: Exception) {
          summaries.value = LoadingStatus.Error(e)
        }
      }
    }
  }

  fun loadPokemonDetails(pokemon: Handle<PokemonVariety>) {
    if (details[pokemon] == LoadingStatus.Loading || details[pokemon] is LoadingStatus.Success)
      return // Already loading or loaded

    details[pokemon] = LoadingStatus.Loading
    viewModelScope.launch {
      withContext(ioDispatcher) {
        try {
          val pokemonDetails = api.getPokemonVariety(pokemon.id)
          details[pokemon] = LoadingStatus.Success(pokemonDetails)
        } catch (e: Exception) {
          details[pokemon] = LoadingStatus.Error(e)
        }
      }
    }
  }
}

@Composable
fun PokemonListScreen(viewModel: PokemonListScreenViewModel = koinViewModel()) {
  // Use a fixed number of columns for simplicity
  // In a real app, we would use windowSizeClass to determine the number of columns
  val columns = 2

  val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      LargeTopAppBar(
        title = { Text("Pokedex") },
        scrollBehavior = scrollBehavior,
        collapsedHeight = 0.dp,
      )
    },
  ) { paddingValues ->
    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
      when (val summariesStatus = viewModel.summaries.value) {
        is LoadingStatus.Loading -> {
          CircularProgressIndicator(modifier = Modifier.size(48.dp).align(Alignment.Center))
        }
        is LoadingStatus.Error -> {
          Text(
            text = "Error loading Pokemon list",
            modifier = Modifier.padding(16.dp).align(Alignment.Center),
          )
        }
        is LoadingStatus.Success -> {
          LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize(),
          ) {
            items(summariesStatus.value) { pokemon -> PokemonListItem(viewModel, pokemon) }
          }
        }
      }
    }
  }
}

@Composable
private fun PokemonListItem(
  viewModel: PokemonListScreenViewModel,
  item: Handle.Named<PokemonVariety>,
) {
  LaunchedEffect(item) { viewModel.loadPokemonDetails(item) }

  Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
    when (val detailStatus = viewModel.details[item]) {
      null,
      is LoadingStatus.Loading -> {
        Column(modifier = Modifier.padding(16.dp)) {
          // Placeholder for image
          Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.LightGray))

          // Placeholder for name
          Text(
            text = item.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp),
          )

          // Placeholder for types
          Row(modifier = Modifier.padding(top = 4.dp)) {
            Box(
              modifier =
                Modifier.size(width = 60.dp, height = 24.dp)
                  .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
            )
          }
        }
      }
      is LoadingStatus.Error -> {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = item.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.titleMedium,
          )
          Text(
            text = "Error loading details",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error,
          )
        }
      }
      is LoadingStatus.Success -> {
        val pokemon = detailStatus.value
        Column(modifier = Modifier.padding(16.dp)) {
          // Pokemon sprite - using AsyncImage to load the sprite
          val imageUrl =
            pokemon.sprites.other.officialArtwork.frontDefault ?: pokemon.sprites.frontDefault

          if (imageUrl != null) {
            AsyncImage(
              model = imageUrl,
              contentDescription = "Sprite of ${pokemon.name}",
              modifier = Modifier.fillMaxWidth().height(100.dp),
              contentScale = ContentScale.Fit,
            )
          } else {
            // Fallback if no image URL is available
            Box(
              modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.LightGray),
              contentAlignment = Alignment.Center,
            ) {
              Text(text = "No sprite available", style = MaterialTheme.typography.bodySmall)
            }
          }

          // Pokemon name
          Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp),
          )

          // Pokemon types
          Row(
            modifier = Modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
          ) {
            pokemon.types
              .sortedBy { it.slot }
              .forEach { pokemonType -> PokemonTypeBadge(pokemonType.type.name) }
          }
        }
      }
    }
  }
}

@Composable
private fun PokemonTypeBadge(type: String) {
  val backgroundColor =
    when (type) {
      "normal" -> Color(0xFFA8A878)
      "fire" -> Color(0xFFF08030)
      "water" -> Color(0xFF6890F0)
      "electric" -> Color(0xFFF8D030)
      "grass" -> Color(0xFF78C850)
      "ice" -> Color(0xFF98D8D8)
      "fighting" -> Color(0xFFC03028)
      "poison" -> Color(0xFFA040A0)
      "ground" -> Color(0xFFE0C068)
      "flying" -> Color(0xFFA890F0)
      "psychic" -> Color(0xFFF85888)
      "bug" -> Color(0xFFA8B820)
      "rock" -> Color(0xFFB8A038)
      "ghost" -> Color(0xFF705898)
      "dragon" -> Color(0xFF7038F8)
      "dark" -> Color(0xFF705848)
      "steel" -> Color(0xFFB8B8D0)
      "fairy" -> Color(0xFFEE99AC)
      else -> Color.Gray
    }

  Surface(
    color = backgroundColor,
    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
    modifier = Modifier.height(24.dp),
  ) {
    Text(
      text = type.replaceFirstChar { it.uppercase() },
      color = Color.White,
      style = MaterialTheme.typography.bodySmall,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
    )
  }
}
