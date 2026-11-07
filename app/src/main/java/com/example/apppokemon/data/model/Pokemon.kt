package com.example.apppokemon.data.model

// Representa las imágenes del pokemon
// (el nombre front_default debe ser igual al que usa la API)
data class Sprites(
    val front_default: String?  // Dirección (URL) de la imagen de frente
)

// Representa un pokemon obtenido desde PokeAPI
// (la API trae muchos más datos, pero Gson ignora los que no declaramos)
data class Pokemon(
    val id: Int,            // Número del pokemon
    val name: String,       // Nombre
    val height: Int,        // Altura
    val weight: Int,        // Peso
    val sprites: Sprites    // Imágenes del pokemon
)