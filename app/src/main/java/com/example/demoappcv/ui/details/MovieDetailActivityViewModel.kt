package com.example.demoappcv.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demoappcv.infrastructure.room.model.Movie
import com.example.demoappcv.repository.MovieRepository
import javax.inject.Inject

class MovieDetailActivityViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<Movie> {
        return movieRepository.getMovieById(movieId)
    }
}