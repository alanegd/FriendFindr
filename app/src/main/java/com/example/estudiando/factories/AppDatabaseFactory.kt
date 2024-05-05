package com.example.estudiando.factories

import android.content.Context
import androidx.room.Room
import com.example.estudiando.persistence.AppDatabase

class AppDatabaseFactory private constructor() {
    companion object {
        private var appDatabase: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "friend_findr-db").build()
            }
            return appDatabase as AppDatabase
        }
    }
}