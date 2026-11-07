package com.example.apppokemon.repository

import com.example.apppokemon.data.model.Pokemon
import com.example.apppokemon.data.remote.RetrofitInstance

// Este repositorio se encarga de pedir los datos a la API usando Retrofit
class PokemonRepository {

    // Función que obtiene un pokemon por su nombre
    suspend fun getPokemon(name: String): Pokemon {
        return RetrofitInstance.api.getPokemon(name)
    }
}