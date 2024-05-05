package com.example.estudiando.factories

import com.example.estudiando.factories.PersonDaoFactory
import com.example.estudiando.repositories.PersonRepository

class PersonRepositoryFactory {
    companion object {
        private var personRepository: PersonRepository? = null
        fun getPersonRepository(): PersonRepository {
            if (personRepository == null) {
                personRepository = PersonRepository(PersonServiceFactory.getPersonService(), PersonDaoFactory.getPersonDao())
            }
            return personRepository as PersonRepository
        }
    }
}