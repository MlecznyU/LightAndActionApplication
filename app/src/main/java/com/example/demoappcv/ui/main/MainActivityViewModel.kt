package com.example.demoappcv.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.infrastructure.room.MovieDatabaseRoom
import com.example.demoappcv.repository.MovieRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }
}