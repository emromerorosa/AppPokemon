package com.example.apppokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppokemon.data.model.Pokemon
import com.example.apppokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel que mantiene el estado de los datos obtenidos
class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    // Flujo mutable que guarda el pokemon (null mientras carga)
    private val _pokemon = MutableStateFlow<Pokemon?>(null)

    // Flujo público de solo lectura, lo usa la pantalla
    val pokemon: StateFlow<Pokemon?> = _pokemon

    // Se llama automáticamente al iniciar el ViewModel
    init {
        fetchPokemon("pikachu")
    }

    // Función que obtiene los datos en segundo plano
    private fun fetchPokemon(name: String) {
        viewModelScope.launch {
            try {
                _pokemon.value = repository.getPokemon(name)
            } catch (e: Exception) {
                println("Error al obtener datos: ${e.localizedMessage}")
            }
        }
    }
}