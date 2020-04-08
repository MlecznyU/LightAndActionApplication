package com.example.demoappcv.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.demoappcv.R
import kotlinx.android.synthetic.main.movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

    }

    override fun onResume() {
        super.onResume()
        loadMovieDetail()

    }

    private fun loadMovieDetail() {
        if (intent.hasExtra("movie_title")) detialTitleTV.text =
            intent.getCharSequenceExtra("movie_title")
        if (intent.hasExtra("movie_score")) detailScoreTV.text =
            intent.getCharSequenceExtra("movie_score")
        if (intent.hasExtra("movie_poster_url")) Glide.with(this)
            .load(intent.getCharSequenceExtra("movie_poster_url"))
            .into(detailPosterIV)
    }
}