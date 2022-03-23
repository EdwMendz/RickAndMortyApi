package mx.kodemia.apptherickandmorty.core.api

import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiRickAndMorty {
    @GET("character")
    suspend fun obtenerPersonajes(): Response<RickAndMortyResponse>
}