package com.example.demoappcv.infrastructure.network

import com.example.demoappcv.infrastructure.network.model.NetworkMovie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = ""
const val HOST = "movie-database-imdb-alternative.p.rapidapi.com"

interface ApiMovieService {
    @Headers(
        "x-rapidapi-host: $HOST",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/")
    suspend fun getDetailMovieAsync(
        @Query(value = "i") imdbID: String
    ): NetworkMovie
}