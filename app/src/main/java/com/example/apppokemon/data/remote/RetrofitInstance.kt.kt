package com.example.apppokemon.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton que contiene la configuración de Retrofit
object RetrofitInstance {

    // Se crea el servicio de la API una sola vez
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/") // URL base de PokeAPI (debe terminar en /)
            .addConverterFactory(GsonConverterFactory.create()) // Convierte el JSON a objetos
            .build()
            .create(ApiService::class.java) // Implementa la interfaz ApiService
    }
}