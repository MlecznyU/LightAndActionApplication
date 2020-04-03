package com.example.demoappcv.example

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_detail.view.*

class ExampleMovieViewHolder(
    private val onCardClicked: (ExampleMovie) -> Unit,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: MovieAdapterItem) {
        //do stuff that display data
        itemView.aboutFilmTV.text = item.movie.title
        itemView.setOnClickListener {
            onCardClicked(item.movie)
        }
    }

}