package com.example.estudiando.repositories

import android.util.Log
import com.example.estudiando.model.data.Person
import com.example.estudiando.model.local.PersonDao
import com.example.estudiando.model.local.PersonEntity
import com.example.estudiando.model.remote.PersonResponse
import com.example.estudiando.model.remote.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(
    private val personService: PersonService,
    private val personDao: PersonDao
) {
    fun isFavorite(id: Int): Boolean {
        return (personDao.getById(id) != null)
    }

    fun insertPerson(id: Int) {
        val personEntity = PersonEntity(id = id)
        personDao.insert(personEntity)
    }

    fun deletePerson(id: Int) {
        val personEntity = PersonEntity(id = id)
        personDao.delete(personEntity)
    }


    fun getAll(callback: (List<Person>) -> Unit) {
        val getAll = personService.getAll()
        getAll.enqueue(object : Callback<PersonResponse> {
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                if (response.isSuccessful) {
                    val people = response.body()?.people ?: emptyList()
                    for (person in people) {
                        person.isFavorite = isFavorite(person.id)
                    }
                    callback(people)
                }
            }

            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("PersonRepository", it)
                }
            }
        })
    }
}