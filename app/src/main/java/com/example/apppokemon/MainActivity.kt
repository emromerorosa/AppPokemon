package com.example.apppokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apppokemon.ui.screens.PokemonScreen
import com.example.apppokemon.ui.theme.AppPokemonTheme
import com.example.apppokemon.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aquí inicia Jetpack Compose
        setContent {
            // Aplicamos el tema Material 3
            AppPokemonTheme {
                // Creamos el ViewModel
                val pokemonViewModel: PokemonViewModel = viewModel()

                // Llamamos a la pantalla principal y le pasamos el ViewModel
                PokemonScreen(viewModel = pokemonViewModel)
            }
        }
    }
}