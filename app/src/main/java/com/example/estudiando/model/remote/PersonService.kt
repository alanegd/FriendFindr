package com.example.estudiando.model.remote

import com.example.estudiando.model.data.PeopleWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonService {

    @GET("?results={number}")
    fun getAll(@Path("number") number: Int): Call<PeopleWrapper>
}