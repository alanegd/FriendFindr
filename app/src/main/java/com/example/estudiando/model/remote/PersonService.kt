package com.example.estudiando.model.remote

import com.example.estudiando.model.data.PersonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonService {
    @GET("api/")
    fun getPersons(@Query("results") results: Int): Call<PersonResponse>
}