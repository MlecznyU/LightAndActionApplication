package com.example.demoappcv.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.repository.MovieRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val movieRepository = MovieRepository(application)

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }
}