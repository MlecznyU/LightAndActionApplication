package com.example.demoappcv.activities

import com.example.demoappcv.MoviesGridAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoappcv.R
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


        moviesGridRV.layoutManager = GridLayoutManager(this, 2)
        moviesGridRV.adapter = MoviesGridAdapter {
            val sendDataToMovieDetailIntent = Intent(this, MovieDetailActivity::class.java)
            sendDataToMovieDetailIntent.putExtra("movie_score",it.score.toString())
            sendDataToMovieDetailIntent.putExtra("movie_title",it.title)
            sendDataToMovieDetailIntent.putExtra("movie_poster_url",it.urlPoster)
            startActivity(sendDataToMovieDetailIntent)
        }

    }
}
