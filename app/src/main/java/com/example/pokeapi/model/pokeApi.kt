package com.example.pokeapi.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface pokeApi {
    @GET()
        fun getpokeLista(
            @Url url: String?
        ): Call<pokeList>

    @GET()
        fun getPokeInfo(
            @Url url: String?
        ): Call<pokeInfo>


}