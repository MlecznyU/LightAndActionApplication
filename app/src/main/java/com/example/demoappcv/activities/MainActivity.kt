package com.example.demoappcv.activities

import android.app.Application
import com.example.demoappcv.view.MoviesGridAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoappcv.R
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.infrastructure.room.MovieDao
import com.example.demoappcv.repository.MovieRepository
import com.example.demoappcv.view.MovieAdapterItem
import com.example.demoappcv.view.MovieViewHolder
import com.example.demoappcv.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.let {
//            it.setDisplayHomeAsUpEnabled(false)
//            it.setDisplayShowHomeEnabled(false)
//            it.setDisplayShowTitleEnabled(false)
//            it.setDisplayUseLogoEnabled(false)
//        }

        val adapter = MoviesGridAdapter {
            val sendDataToMovieDetailIntent = Intent(this, MovieDetailActivity::class.java)
            sendDataToMovieDetailIntent.putExtra("movie_score", it.score.toString())
            sendDataToMovieDetailIntent.putExtra("movie_title", it.title)
            sendDataToMovieDetailIntent.putExtra("movie_poster_url", it.urlPoster)
            startActivity(sendDataToMovieDetailIntent)
        }
        val observer = Observer<List<Movie>>() {
            adapter.updateItems(it)
        }
        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        model.getAllMovies().observe(this, observer)
        moviesGridRV.layoutManager = GridLayoutManager(this, 2)
        moviesGridRV.adapter = adapter


    }
}
