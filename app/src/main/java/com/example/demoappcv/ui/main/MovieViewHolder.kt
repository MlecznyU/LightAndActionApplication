package com.example.demoappcv.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoappcv.infrastructure.room.model.Movie
import kotlinx.android.synthetic.main.movie_tile.view.*


class MovieViewHolder(
    private val onCardClickedListener: (Movie) -> Unit,
    itemView: View
) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        val title = itemView.mainTitleTV
        val score = itemView.mainScoreTV
        val poster = itemView.posterTV
        val tile = itemView.moviePlotContainerCV

        tile.setOnClickListener {
            onCardClickedListener(movie)
        }
        Glide.with(itemView.context).load(movie.urlPoster).into(poster)
        title.text = movie.title
        score.text = movie.score.toString()
    }
}