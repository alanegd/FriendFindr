package com.example.estudiando.model.remote
import retrofit2.Call
import retrofit2.http.GET

interface PersonService {
    @GET("people")
    fun getAll(): Call<PersonResponse>
}