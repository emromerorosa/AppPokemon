package com.example.apppokemon.data.remote

import com.example.apppokemon.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

// Esta interfaz define los endpoints HTTP
interface ApiService {

    // Solicitud GET a pokemon/{name}, por ejemplo pokemon/pikachu
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): Pokemon
}