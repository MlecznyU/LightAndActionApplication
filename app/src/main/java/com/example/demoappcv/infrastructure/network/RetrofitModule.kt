package com.example.demoappcv.infrastructure.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun providersOkClient(connectivityInterceptor: ConnectivityInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(connectivityInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providersRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://movie-database-imdb-alternative.p.rapidapi.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiMovieService(retrofit: Retrofit): ApiMovieService {
        return retrofit.create(ApiMovieService::class.java)
    }
}