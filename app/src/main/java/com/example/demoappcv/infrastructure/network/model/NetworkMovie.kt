package com.example.demoappcv.infrastructure.network.model

import com.example.demoappcv.infrastructure.room.model.Movie
import com.google.gson.annotations.SerializedName

data class NetworkMovie(
    @SerializedName(value = "Actors")
    val actors: String,
    @SerializedName(value = "Awards")
    val awards: String,
    @SerializedName(value = "Country")
    val country: String,
    @SerializedName(value = "Director")
    val director: String,
    @SerializedName(value = "Genre")
    val genre: String,
    @SerializedName(value = "Metascore")
    val metascore: String,
    @SerializedName(value = "Plot")
    val plot: String,
    @SerializedName(value = "Poster")
    val poster: String,
    @SerializedName(value = "Production")
    val production: String,
    @SerializedName(value = "Runtime")
    val runtime: String,
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
            runtime,
            production,
            genre,
            director,
            country,
            awards,
            actors,
            title,
            score.toDouble(),
            poster,
            plot,
            metascore.toDouble(),
            year
        )
    }
}