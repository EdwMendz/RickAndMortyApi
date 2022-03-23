package mx.kodemia.apptherickandmorty.core.model.RickAndMorty

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("info")
    var info: Info? = Info(),
    @SerializedName("results")
    var results: ArrayList<Results> = arrayListOf()
)
