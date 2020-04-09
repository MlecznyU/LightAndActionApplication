package com.example.demoappcv.infrastructure.network

import com.example.demoappcv.infrastructure.network.model.NetworkMovie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = "277c1a4c35msh4b2a99ba66a1a5ap12e03bjsnaa7e22e7e3fc"
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