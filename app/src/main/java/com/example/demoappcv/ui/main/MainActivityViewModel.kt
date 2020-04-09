package com.example.demoappcv.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demoappcv.infrastructure.room.model.Movie
import com.example.demoappcv.repository.MovieRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {


    fun getAllMovies(): LiveData<List<Movie>> {
        return movieRepository.getAllMovies()
    }

    suspend fun updateMovies(): Boolean{
        return movieRepository.updateMovies()
    }

}