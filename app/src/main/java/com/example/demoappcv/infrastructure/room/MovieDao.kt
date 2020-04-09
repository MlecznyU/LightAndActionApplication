package com.example.demoappcv.infrastructure.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demoappcv.infrastructure.room.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies_table WHERE id = :movieId")
    fun getMovieById(movieId: Int): LiveData<Movie>

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movies_table")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movies: List<Movie>)

}