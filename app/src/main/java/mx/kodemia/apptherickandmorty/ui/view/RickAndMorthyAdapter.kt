package mx.kodemia.apptherickandmorty.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import mx.kodemia.apptherickandmorty.R
import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.Results
import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.RickAndMortyResponse
import mx.kodemia.apptherickandmorty.databinding.CardRickandmorthyBinding

class RickAndMorthyAdapter(val personajes: ArrayList<Results>):RecyclerView.Adapter<RickAndMorthyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_rickandmorthy,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = personajes.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.apply {
                tvNombre.text = personajes[position].name
                tvEstatus.text = personajes[position].status
                tvGender.text = personajes[position].gender
                ivRickMorty.load(personajes[position].image)
            }
        }

    }


    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val binding = CardRickandmorthyBinding.bind(view)
    }
}