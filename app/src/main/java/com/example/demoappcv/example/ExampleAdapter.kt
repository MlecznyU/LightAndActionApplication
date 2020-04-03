package com.example.demoappcv.example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappcv.R

class ExampleAdapter(
    private val onMovieClickedListener: (ExampleMovie) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = listOf<ExampleAdapterItem>()

    fun updateItems(items: List<ExampleAdapterItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_detail, parent)
            ExampleMovieViewHolder(onMovieClickedListener, view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_detail, parent)
            ExampleAdvertViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val adapterItem = items[position]) {
            is MovieAdapterItem -> (holder as ExampleMovieViewHolder).bind(adapterItem)
            is AdvertAdapterItem -> (holder as ExampleAdvertViewHolder).bind(adapterItem)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is MovieAdapterItem -> 1
            is AdvertAdapterItem -> 2
        }
    }
}
