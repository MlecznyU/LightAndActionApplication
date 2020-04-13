package com.example.demoappcv.ui.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        getMovieData().observe(this, observer())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun getMovieData(): LiveData<Movie> {
        val id = intent.getIntExtra("id", -1)
        return movieDetailActivityViewModel.getMovieDetail(id)
    }

    private fun observer(): Observer<Movie> {
        return Observer {
            Glide.with(this).load(it.urlPoster).into(detailPosterIV)
            detailTitleTV.text = it.title
            detailMetascoreTV.text = it.metascore.toString()
            detailScoreTV.text = it.score.toString()
            detailPlotTV.text = it.plot
            detailYearTV.text = it.year
            detailDirectorTV.text = it.director
            detailRuntimeTV.text = it.runtime
            detailActorsTV.text = it.actors
            detailCountryTV.text = it.country
            detailGenreTV.text = it.genre
            detailProductionTV.text = it.production
            supportActionBar?.title = ""
        }
    }
}