package com.example.apppokemon.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.apppokemon.viewmodel.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {

    // Observamos el pokemon que guarda el ViewModel
    val pokemon = viewModel.pokemon.collectAsState().value

    // Scaffold con barra superior
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Pokémon") }
            )
        }
    ) { innerPadding ->

        // Aplicamos el padding para no quedar bajo la barra
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (pokemon == null) {
                // Mientras llegan los datos de la API
                Text("Cargando...")
            } else {
                // Tarjeta con los datos del pokemon
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Imagen del pokemon, descargada desde internet con Coil
                        AsyncImage(
                            model = pokemon.sprites.front_default,
                            contentDescription = pokemon.name,
                            modifier = Modifier.size(200.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Nombre: ${pokemon.name}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Número: ${pokemon.id}")
                        Text(text = "Altura: ${pokemon.height}")
                        Text(text = "Peso: ${pokemon.weight}")
                    }
                }
            }
        }
    }
}