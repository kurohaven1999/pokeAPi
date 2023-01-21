package com.example.pokeapi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.pokeapi.databinding.ActivityPokeListaBinding
import com.example.pokeapi.model.Results
import com.example.pokeapi.model.pokeInfo
import com.example.pokeapi.model.pokeList
import com.example.pokeapi.view.activities.MainActivity

class pokeListAdapter(private val contexto: Context, private val pokeList: ArrayList<Results>): RecyclerView.Adapter<pokeListAdapter.ViewHolder>() {

    class ViewHolder(view: ActivityPokeListaBinding): RecyclerView.ViewHolder(view.root) {
        val nombre = view.tvNombre
        val numero = view.tvNumero
        val imgPoke = view.ivPoke
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityPokeListaBinding.inflate(LayoutInflater.from(contexto))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = pokeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = pokeList[position].name
        holder.numero.text = "# ${(position+1).toString()}"
        //Glide.with(contexto).load(pokeInfo[position].sprites?.other?.officialArtwork?.frontDefault).into(holder.imgPoke)
        Glide.with(contexto).load("https://pm1.narvii.com/6403/40bb2493d650f0075371fea97d5bb4e6b1f61c89_hq.jpg").into(holder.imgPoke)

        holder.itemView.setOnClickListener{
            if (contexto is MainActivity) contexto.pokeSelection(pokeList[position], (position+1))
        }

    }



}