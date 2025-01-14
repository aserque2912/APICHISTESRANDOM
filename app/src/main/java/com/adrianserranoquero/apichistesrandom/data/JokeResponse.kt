package com.adrianserranoquero.apichistesrandom.data

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("id") val id: String,
    @SerializedName("value") val joke: String,
    @SerializedName("url") val url: String
)





