package com.example.demoappcv.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.repository.MovieRepository
import javax.inject.Inject

class MovieDetailActivityViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun getMovieDetail(movieId: String): LiveData<Movie> {
        return movieRepository.getMovieById(movieId)
    }
}