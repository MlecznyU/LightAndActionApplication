package com.example.demoappcv.infrastructure.room.module

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.example.demoappcv.infrastructure.room.MovieDao
import com.example.demoappcv.infrastructure.room.MovieDatabaseRoom
import com.example.demoappcv.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(
) {

    @Singleton
    @Provides
    fun providesMovieDatabaseRoom(application: Application): MovieDatabaseRoom {
        return databaseBuilder(
            application.applicationContext,
            MovieDatabaseRoom::class.java,
            "movies_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providersMovieDao(movieDatabaseRoom: MovieDatabaseRoom): MovieDao {
        return movieDatabaseRoom.movieDao
    }
}