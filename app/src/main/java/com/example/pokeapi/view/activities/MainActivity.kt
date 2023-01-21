package com.example.pokeapi.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapi.databinding.ActivityMainBinding
import com.example.pokeapi.model.Results
import com.example.pokeapi.model.pokeApi
import com.example.pokeapi.model.pokeList
import com.example.pokeapi.view.adapters.pokeListAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val call = retrofit.create(pokeApi::class.java).getpokeLista("pokemon?limit=151")

            call.enqueue(object: Callback<pokeList>{
                override fun onResponse(
                    call: Call<pokeList>,
                    response: Response<pokeList>){
                    binding.rvPokemon.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvPokemon.adapter = pokeListAdapter(this@MainActivity,response.body()!!.results)
                    binding.barraCarga.visibility = View.GONE
                }

                override fun onFailure(call: Call<pokeList>, t: Throwable) {
                    binding.barraCarga.visibility = View.GONE
                    Toast.makeText(this@MainActivity,"Error de conexión: ${t.message}",Toast.LENGTH_SHORT).show()
                }
            })
        }


    }

    fun pokeSelection(pokeLista: Results, position: Int){
        var parametrso = Bundle()
        parametrso.apply {
            putString("nombre", pokeLista.name)
            putString("pokemon",pokeLista.url)
            putInt("position",position)
        }

        val intent = Intent(this@MainActivity,infoPokemon::class.java)
        intent.putExtras(parametrso)
        startActivity(intent)
    }

}