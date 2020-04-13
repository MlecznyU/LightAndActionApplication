package com.example.demoappcv.infrastructure.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
class Movie(

    @PrimaryKey(autoGenerate = true) val id: Int,
    val runtime: String,
    val production: String,
    val genre: String,
    val director: String,
    val country: String,
    val awards: String,
    val actors: String,
    val title: String,
    val score: Double,
    val urlPoster: String,
    val plot: String,
    val metascore: Double,
    val year: String
)