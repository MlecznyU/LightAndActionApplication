package com.example.demoappcv.infrastructure.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoappcv.infrastructure.room.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabaseRoom : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        private var InstanceOfMovieDatabaseRoom: MovieDatabaseRoom? = null

        @Synchronized
        fun getInstance(
            context: Context
        ): MovieDatabaseRoom {
            if (InstanceOfMovieDatabaseRoom == null) {
                InstanceOfMovieDatabaseRoom = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabaseRoom::class.java,
                    "movies_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return InstanceOfMovieDatabaseRoom!!
        }
    }
}
