package com.example.pokeapi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapi.databinding.ActivityPokeListaBinding
import com.example.pokeapi.model.pokeInfo

class pokeImgAdapter(private val contexto: Context, private val pokeInfo: ArrayList<pokeInfo>): RecyclerView.Adapter<pokeImgAdapter.ViewHolder>(){
    class ViewHolder(view: ActivityPokeListaBinding): RecyclerView.ViewHolder(view.root) {
        val imgpoke = view.ivPoke
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pokeImgAdapter.ViewHolder {
        val binding = ActivityPokeListaBinding.inflate(LayoutInflater.from(contexto))
        return pokeImgAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(contexto).load(pokeInfo[position].sprites?.other?.officialArtwork?.frontDefault).into(holder.imgpoke)
    }

    override fun getItemCount(): Int = pokeInfo.size


}