package com.example.estudiando.repositories

import android.util.Log
import com.example.estudiando.model.data.Person
import com.example.estudiando.model.data.PersonResponse
import com.example.estudiando.factories.PersonServiceFactory
import com.example.estudiando.model.remote.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {
    private val personService: PersonService = PersonServiceFactory.getPersonService()

    fun getPersons(numberOfPersons: Int, callback: (List<Person>) -> Unit) {
        val call = personService.getPersons(numberOfPersons)
        call.enqueue(object : Callback<PersonResponse> {
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                if (response.isSuccessful) {
                    val people = response.body()?.results ?: emptyList()
                    callback(people)
                } else {
                    Log.d("HeroRepository", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }
        })
    }
}