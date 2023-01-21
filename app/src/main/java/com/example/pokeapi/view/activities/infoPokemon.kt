package com.example.pokeapi.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapi.databinding.ActivityInfoPokemonBinding
import com.example.pokeapi.databinding.ActivityPokeListaBinding
import com.example.pokeapi.model.pokeApi
import com.example.pokeapi.model.pokeInfo
import com.example.pokeapi.model.pokeList
import com.example.pokeapi.view.adapters.pokeInfoAdapter
import com.example.pokeapi.view.adapters.pokeListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class infoPokemon : AppCompatActivity() {
    private lateinit var binding: ActivityInfoPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundles = intent.extras
        val position = bundles?.getInt("position")
        val nombre = bundles?.getString("nombre")

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val call = retrofit.create(pokeApi::class.java).getPokeInfo("pokemon/${position}/")

            call.enqueue(object: Callback<pokeInfo> {
                override fun onResponse(call: Call<pokeInfo>, response: Response<pokeInfo>) {
                    val arraylist = ArrayList<pokeInfo>()

                    arraylist.add(pokeInfo(response.body()!!.baseExperience,response.body()!!.height,response.body()!!.id,
                        response.body()!!.name,response.body()!!.order,response.body()!!.sprites,response.body()!!.types,response.body()!!.weight))
                    binding.rvPokemon.layoutManager = LinearLayoutManager(this@infoPokemon)
                    binding.rvPokemon.adapter = pokeInfoAdapter(this@infoPokemon,arraylist,nombre)
                    binding.barraCarga.visibility = View.GONE
                }
                override fun onFailure(call: Call<pokeInfo>, t: Throwable) {
                    binding.barraCarga.visibility = View.GONE
                    Toast.makeText(this@infoPokemon,"Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
}