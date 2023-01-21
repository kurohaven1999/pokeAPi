package com.example.pokeapi.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeapi.databinding.ActivityInfoPokemonBinding
import com.example.pokeapi.databinding.ActivityInfoPokemonDesignBinding

class infoPokemonDesign : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPokemonDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPokemonDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}