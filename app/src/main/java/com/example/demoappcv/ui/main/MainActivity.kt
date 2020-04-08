package com.example.demoappcv.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoappcv.R
import com.example.demoappcv.infrastructure.Movie
import com.example.demoappcv.ui.details.MovieDetailActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.let {
//            it.setDisplayHomeAsUpEnabled(false)
//            it.setDisplayShowHomeEnabled(false)
//            it.setDisplayShowTitleEnabled(false)
//            it.setDisplayUseLogoEnabled(false)
//        }

        val adapter = moviesGridAdapter()

        model.getAllMovies().observe(this, observer(adapter))
        moviesGridRV.layoutManager = GridLayoutManager(this, 2)
        moviesGridRV.adapter = adapter


    }

    private fun observer(adapter: MoviesGridAdapter): Observer<List<Movie>> {
        return Observer<List<Movie>>() {
            adapter.updateItems(it)
        }
    }

    private fun moviesGridAdapter(): MoviesGridAdapter {
        return MoviesGridAdapter {
            val sendDataToMovieDetailIntent = Intent(this, MovieDetailActivity::class.java)
            sendDataToMovieDetailIntent.putExtra("movie_score", it.score.toString())
            sendDataToMovieDetailIntent.putExtra("movie_title", it.title)
            sendDataToMovieDetailIntent.putExtra("movie_poster_url", it.urlPoster)
            this.startActivity(sendDataToMovieDetailIntent)
        }
    }
}
