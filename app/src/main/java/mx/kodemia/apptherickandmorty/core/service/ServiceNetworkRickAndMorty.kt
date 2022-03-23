package mx.kodemia.apptherickandmorty.core.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.kodemia.apptherickandmorty.core.api.ApiRickAndMorty
import mx.kodemia.apptherickandmorty.core.api.RetrofitInstance
import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.RickAndMortyResponse
import retrofit2.Response

class ServiceNetworkRickAndMorty {
    private val retrofit = RetrofitInstance.getRetrofit().create(ApiRickAndMorty::class.java)
    suspend fun obtenerPersonajesR():Response<RickAndMortyResponse>{
        return withContext(Dispatchers.IO){
            val respuesta = retrofit.obtenerPersonajes()
            respuesta
        }
    }
}