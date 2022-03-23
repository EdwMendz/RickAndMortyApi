package mx.kodemia.apptherickandmorty.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.RickAndMortyResponse
import mx.kodemia.apptherickandmorty.core.service.ServiceNetworkRickAndMorty
import java.lang.Exception

class RickAndMortyViewModel : ViewModel() {
    private val service = ServiceNetworkRickAndMorty()
    val personaes = MutableLiveData<RickAndMortyResponse>()
    val error = MutableLiveData<String>()
    val cargando = MutableLiveData<Boolean>()

    fun getPersonajes() {
        viewModelScope.launch {
            cargando.postValue(true)
            val respuestaRick = service.obtenerPersonajesR()
            try {
                if (respuestaRick.isSuccessful) {
                    personaes.postValue(respuestaRick.body())
                } else {
                    error.postValue(respuestaRick.errorBody().toString())
                }
                cargando.postValue(false)
            } catch (io: Exception) {
                error.postValue(io.localizedMessage)
                cargando.postValue(false)
            }
        }
    }
}
