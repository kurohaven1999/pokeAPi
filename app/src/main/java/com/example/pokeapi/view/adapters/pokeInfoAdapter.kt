package com.example.pokeapi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapi.databinding.ActivityInfoPokemonDesignBinding
import com.example.pokeapi.model.Results
import com.example.pokeapi.model.pokeInfo


class pokeInfoAdapter(private val contexto: Context, private val pokeInfo: ArrayList<pokeInfo>, private val nombre: String? ): RecyclerView.Adapter<pokeInfoAdapter.ViewHolder>()  {
    class ViewHolder(view: ActivityInfoPokemonDesignBinding): RecyclerView.ViewHolder(view.root) {
        val nombre = view.tvNombrePoke
        val imgPoke = view.ivPokemon
        val altura = view.tvAltura
        val peso = view.tvPeso
        val xp = view.tvExp
        val tipo = view.tvTipo
        val tipo2 = view.tvTipo2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityInfoPokemonDesignBinding.inflate(LayoutInflater.from(contexto))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = pokeInfo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = nombre
        holder.xp.text = "Exp Base: ${pokeInfo[position].baseExperience.toString()} exp"
        holder.altura.text = "Altura: ${pokeInfo[position].height.toString()} m"
        holder.peso.text = "Peso: ${pokeInfo[position].height.toString()} kg"
        Glide.with(contexto).load(pokeInfo[position].sprites?.other?.officialArtwork?.frontDefault).into(holder.imgPoke)
        holder.tipo.text = "Tipo: ${pokeInfo[position].types[0].type?.name.toString()}"

        if (pokeInfo[position].types.size == 2){
            holder.tipo2.text = "Tipo: ${pokeInfo[position].types[1].type?.name.toString()}"
        }

    }
}