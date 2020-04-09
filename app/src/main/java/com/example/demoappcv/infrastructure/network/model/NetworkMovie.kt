package com.example.demoappcv.infrastructure.network.model

import com.example.demoappcv.infrastructure.room.model.Movie
import com.google.gson.annotations.SerializedName
import java.text.NumberFormat

data class NetworkMovie(

    @SerializedName(value = "Metascore")
    val metascore: String,
    @SerializedName(value = "Plot")
    val plot: String,
    @SerializedName(value = "Poster")
    val poster: String,
    @SerializedName(value = "Title")
    val title: String,
    @SerializedName(value = "Year")
    val year: String,
    @SerializedName(value = "imdbID")
    val id: String,
    @SerializedName(value = "imdbRating")
    val score: String
) {
    fun toRoomMovie(): Movie {
        return Movie(
            (id.replace("tt", "").toInt()),
            title,
            score.toDouble(),
            poster,
            plot,
            metascore.toDouble(),
            year
        )
    }

}