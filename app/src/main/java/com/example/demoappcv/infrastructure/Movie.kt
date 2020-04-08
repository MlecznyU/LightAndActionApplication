package com.example.demoappcv.infrastructure

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val score: Double,
    val urlPoster: String
)