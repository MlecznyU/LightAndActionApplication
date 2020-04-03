package com.example.demoappcv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_tile.view.*


class MovieViewHolder(
    private val onCardClickedListener: (Movie) -> Unit,
    itemView: View
) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(item: MovieAdapterItem, position: Int) {
        val title = itemView.mainTitleTV
        val score = itemView.mainScoreTV
        val poster = itemView.posterTV
        val tile = itemView.movieTileContainerCV

        tile.setOnClickListener {
            onCardClickedListener(item.movie)
        }
        Glide.with(itemView.context).load(item.movie.urlPoster).into(poster)
        title.text = item.movie.title
        score.text = item.movie.score.toString()
    }
}