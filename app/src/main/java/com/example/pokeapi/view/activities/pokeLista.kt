package com.example.pokeapi.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeapi.databinding.ActivityMainBinding
import com.example.pokeapi.databinding.ActivityPokeListaBinding

class pokeLista : AppCompatActivity() {

    private lateinit var binding: ActivityPokeListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}