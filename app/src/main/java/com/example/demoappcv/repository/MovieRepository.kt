package com.example.demoappcv.repository

import androidx.lifecycle.LiveData
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.infrastructure.room.MovieDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieDao: MovieDao) {


    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }

    fun getMovieById(id: String): LiveData<Movie> {
        return movieDao.getMovieById(id)
    }

    suspend fun updateMovie(movie: Movie) {
        movieDao.update(movie)
    }

    suspend fun insertMovie(movie: Movie){
        movieDao.insert(movie)
    }

}