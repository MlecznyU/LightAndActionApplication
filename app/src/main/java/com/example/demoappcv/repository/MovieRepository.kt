package com.example.demoappcv.repository

import androidx.lifecycle.LiveData
import com.example.demoappcv.infrastructure.network.ApiMovieService
import com.example.demoappcv.infrastructure.room.DataForAPI
import com.example.demoappcv.infrastructure.room.MovieDao
import com.example.demoappcv.infrastructure.room.model.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val apiMovieService: ApiMovieService
) {

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieDao.getAllMovies()
    }

    fun getMovieById(id: Int): LiveData<Movie> {
        return movieDao.getMovieById(id)
    }

    suspend fun updateMovies(): Boolean {
        return try {
            val movies = DataForAPI.movieIdList.map { id ->
                apiMovieService.getDetailMovieAsync(id).toRoomMovie()
            }
            movieDao.insert(movies)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}