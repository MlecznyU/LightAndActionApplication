package com.example.demoappcv.infrastructure.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demoappcv.infrastructure.Movie

@Dao
interface MovieDao {

    @Update
    fun update(movie: Movie)

    @Query("SELECT * FROM movies_table WHERE id LIKE :movieId")
    fun getMovieById(movieId: String): LiveData<Movie>

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movies_table")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

}