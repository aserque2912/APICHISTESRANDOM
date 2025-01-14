package com.adrianserranoquero.apichistesrandom.data

import com.adrianserranoquero.apichistesrandom.network.JokeApiService

class JokeRepository(
    private val apiService: JokeApiService = JokeApiService.create()
) {

    suspend fun getJoke(): String {
        val response = apiService.getRandomJoke()
        if (response.isSuccessful) {
            return response.body()?.joke ?: "No se pudo obtener el chiste."
        } else {
            throw Exception("Error al obtener el chiste: ${response.message()}")
        }
    }
}
