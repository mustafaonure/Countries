package com.example.countries.model


import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class CountryModel(

    @SerializedName("code")
    val code: String? = null,
    @SerializedName("currencyCodes")
    val currencyCodes: ArrayList<String>? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("wikiDataId")
    val wikiDataId: String? = null,
)
