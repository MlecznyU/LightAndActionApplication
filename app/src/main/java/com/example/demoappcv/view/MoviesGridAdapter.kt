package com.example.demoappcv.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappcv.R.layout.movie_tile
import com.example.demoappcv.infrastructure.Movie

class MoviesGridAdapter(private val onCardClickedListener: (Movie) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var adapterItems = listOf<MovieAdapterItem>()
    //TODO change adapterItems to implement movies from sql

    fun updateItems(adapterItems: List<MovieAdapterItem>) {
        this.adapterItems = adapterItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieTile =
            LayoutInflater.from(parent.context).inflate(
                movie_tile,
                parent,
                false
            ) as View

        return MovieViewHolder(
            onCardClickedListener,
            movieTile
        )
    }

    override fun getItemCount() = adapterItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val adapterItem = adapterItems[position] as MovieAdapterItem
        (holder as MovieViewHolder).bind(adapterItem, position)

    }
}
