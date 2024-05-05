package com.example.estudiando.repositories

import android.util.Log
import com.example.estudiando.factories.PersonDaoFactory
import com.example.estudiando.factories.PersonServiceFactory
import com.example.estudiando.model.data.PeopleWrapper
import com.example.estudiando.model.data.Person
import com.example.estudiando.model.local.PersonDao
import com.example.estudiando.model.remote.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(private val personService: PersonService = PersonServiceFactory.getPersonService(), private val personDao: PersonDao = PersonDaoFactory.getPersonDao()) {
    fun getAll(callback: (List<Person>) -> Unit) {
        val getAll = personService.getAll(10)
        getAll.enqueue(object : Callback<PeopleWrapper> {
            override fun onResponse(call: Call<PeopleWrapper>, response: Response<PeopleWrapper>) {
                if (response.isSuccessful) {
                    val people = response.body()?.people ?: emptyList()
                    callback(people)
                }
            }

            override fun onFailure(call: Call<PeopleWrapper>, t: Throwable) {
                t.message?.let {
                    Log.d("PersonRepository", it)
                }
            }
        })
    }
}