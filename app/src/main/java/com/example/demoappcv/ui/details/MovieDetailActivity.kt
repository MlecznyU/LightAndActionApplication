package com.example.demoappcv.ui.details

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.demoappcv.R
import com.example.demoappcv.infrastructure.room.model.Movie
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var movieDetailActivityViewModel: MovieDetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)
    }

    override fun onResume() {
        super.onResume()
        getMovieData().observe(this, observer())
    }

    private fun getMovieData(): LiveData<Movie> {
        val id = intent.getIntExtra("id", -1)
        return movieDetailActivityViewModel.getMovieDetail(id)
    }

    private fun observer(): Observer<Movie> {
        return Observer {
            Glide.with(this).load(it.urlPoster).into(detailPosterIV)
            detialTitleTV.text = it.title
            detailMetascoreTV.text = it.metascore.toString()
            detailScoreTV.text = it.score.toString()
            detailPlotTV.text = it.plot
            detailYearTV.text = it.year
        }
    }
}