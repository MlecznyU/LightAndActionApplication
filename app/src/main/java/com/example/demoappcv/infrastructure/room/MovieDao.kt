package com.example.demoappcv.infrastructure.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.demoappcv.infrastructure.Movie

@Dao
interface MovieDao {

    @Update
    fun update(movie: Movie)

    @Query("SELECT * FROM movies_table WHERE id LIKE :movieId")
    fun getMovieById(movieId: String):Movie

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>


}