package com.example.estudiando.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
    fun insert(personEntity: PersonEntity)

    @Delete
    fun delete(personEntity: PersonEntity)

    @Query("SELECT * FROM people")
    fun getAll(): List<PersonEntity>

    @Query("SELECT * FROM people WHERE id=:id")
    fun getById(id: Int): PersonEntity?
}