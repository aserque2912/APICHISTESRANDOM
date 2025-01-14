package com.adrianserranoquero.apichistesrandom.network

import com.adrianserranoquero.apichistesrandom.data.JokeResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeApiService {


    @GET("random")
    suspend fun getRandomJoke(): Response<JokeResponse>


    companion object {
        private const val BASE_URL = "https://api.chucknorris.io/jokes/"

        fun create(): JokeApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(JokeApiService::class.java)
        }
    }
}
