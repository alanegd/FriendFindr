package com.example.estudiando.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.estudiando.model.data.Id

@Entity(tableName = "people")
data class PersonEntity(
    @PrimaryKey val id: String,
)