package mx.kodemia.apptherickandmorty.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.kodemia.apptherickandmorty.core.model.RickAndMorty.RickAndMortyResponse
import mx.kodemia.apptherickandmorty.databinding.ActivityMainBinding
import mx.kodemia.apptherickandmorty.ui.viewModel.RickAndMortyViewModel

class RickAndMorthyView : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewmodel: RickAndMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observadores()
        viewmodel.getPersonajes()
    }

    private fun observadores() {
        viewmodel.personaes.observe(this){personajes->
            llenarReciclerView(personajes)
        }
        viewmodel.cargando.observe(this) { cargando ->
            cargando(cargando)
        }
    }

    private fun cargando(cargando: Boolean) {
        binding.apply {
            if (cargando){
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        }

    }

    private fun llenarReciclerView(personajes: RickAndMortyResponse) {
        val adapter = RickAndMorthyAdapter(personajes.results)
        binding.apply {
            rvRickAndMorthyPersonajes.hasFixedSize()
            rvRickAndMorthyPersonajes.layoutManager = LinearLayoutManager(this@RickAndMorthyView)
            rvRickAndMorthyPersonajes.adapter = adapter

        }
    }


}