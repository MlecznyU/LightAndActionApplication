package com.example.demoappcv.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.infrastructure.room.MovieDao
import com.example.demoappcv.infrastructure.room.MovieDatabaseRoom


class MovieRepository(application: Application) {
    private var db = MovieDatabaseRoom.getInstance(application)
    private val movieDao : MovieDao = db.movieDao


    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }

    fun getMovieById(id: String): Movie {
        return movieDao.getMovieById(id)
    }

    fun updateMovie(movie: Movie) {
        movieDao.update(movie)
    }

}