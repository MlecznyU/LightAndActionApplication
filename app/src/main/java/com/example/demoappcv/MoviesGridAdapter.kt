package com.example.demoappcv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoappcv.R.layout.movie_tile
import kotlinx.android.synthetic.main.movie_tile.view.*

class MoviesGridAdapter(private val onCardClickedListener: (Movie) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var adapterItems = FakeData.movieList
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

        return MovieViewHolder(onCardClickedListener, movieTile)
    }

    override fun getItemCount() = adapterItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val adapterItem = adapterItems[position] as MovieAdapterItem
        (holder as MovieViewHolder).bind(adapterItem, position)

    }
}
