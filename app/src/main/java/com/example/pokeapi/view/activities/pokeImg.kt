package com.example.pokeapi.view.activities

import com.example.pokeapi.model.Sprites
import com.google.gson.annotations.SerializedName

data class pokeImg(
    @SerializedName("sprites"                  ) var sprites                : Sprites?               = Sprites()
)

class Other {
    @SerializedName("official-artwork" ) var officialArtwork : officialArtwork? = null
}

class officialArtwork {
    @SerializedName("front_default" ) var frontDefault : String? = null
}

class Sprites {
    @SerializedName("other"              ) var other            : Other?    = Other()
}
