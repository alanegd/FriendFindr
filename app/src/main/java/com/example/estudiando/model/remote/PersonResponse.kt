package com.example.estudiando.model.remote

import com.example.estudiando.model.data.Person
import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("results")
    val people: List<Person>,
)
