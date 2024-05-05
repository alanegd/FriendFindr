package com.example.estudiando.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.estudiando.model.local.PersonEntity
import com.example.estudiando.model.local.PersonDao

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}