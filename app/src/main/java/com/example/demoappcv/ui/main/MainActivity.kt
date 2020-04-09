package com.example.demoappcv.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demoappcv.R
import com.example.demoappcv.ui.details.MovieDetailActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var model: MainActivityViewModel

    private lateinit var adapter: MoviesGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        setupRecyclerView()
        observeMoviesList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.refreshAb) {
            Toast.makeText(this, "Database has been refreshed!", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                model.updateMovies()
            }
        }else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun setupRecyclerView() {
        adapter = MoviesGridAdapter {
            val sendDataToMovieDetailIntent = Intent(this, MovieDetailActivity::class.java)
            sendDataToMovieDetailIntent.putExtra("id", it.id)
            this.startActivity(sendDataToMovieDetailIntent)
        }
        moviesGridRV.layoutManager = GridLayoutManager(this, 2)
        moviesGridRV.adapter = adapter
    }

    private fun observeMoviesList() {
        model.getAllMovies().observe(this, Observer() {
            adapter.updateItems(it)
        })
    }
}
