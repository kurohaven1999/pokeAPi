package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

data class pokeList(
    @SerializedName("count"    ) var count    : Int?               = null,
    @SerializedName("next"     ) var next     : String?            = null,
    @SerializedName("previous" ) var previous : String?            = null,
    @SerializedName("results"  ) var results  : ArrayList<Results> = arrayListOf()
)

class Results {
    @SerializedName("name" ) var name : String? = null
    @SerializedName("url"  ) var url  : String? = null
}
