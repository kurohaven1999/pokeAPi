package com.example.pokeapi.model

import com.google.gson.annotations.SerializedName

data class pokeInfo(
    @SerializedName("base_experience"          ) var baseExperience         : Int?                   = null,
    @SerializedName("height"                   ) var height                 : Int?                   = null,
    @SerializedName("id"                       ) var id                     : Int?                   = null,
    @SerializedName("name"                     ) var name                   : String?                = null,
    @SerializedName("order"                    ) var order                  : Int?                   = null,
    @SerializedName("sprites"                  ) var sprites                : Sprites?               = Sprites(),
    @SerializedName("types"                    ) var types                  : ArrayList<Types>       = arrayListOf(),
    @SerializedName("weight"                   ) var weight                 : Int?                   = null
)

class Types {
    @SerializedName("slot" ) var slot : Int?  = null
    @SerializedName("type" ) var type : Type? = Type()
}

class Type {
    @SerializedName("name" ) var name : String? = null
    @SerializedName("url"  ) var url  : String? = null
}

class Other {
    @SerializedName("official-artwork" ) var officialArtwork : officialArtwork? = null
}

class officialArtwork {
    @SerializedName("front_default" ) var frontDefault : String? = null
}

class Sprites {
    @SerializedName("other"              ) var other            : Other?    = Other()
}



