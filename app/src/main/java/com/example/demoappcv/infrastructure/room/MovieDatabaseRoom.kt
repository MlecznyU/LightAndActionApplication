package com.example.demoappcv.infrastructure.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.demoappcv.infrastructure.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabaseRoom : RoomDatabase() {

    abstract val movieDao: MovieDao

    private class MovieDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //Todo change it to network on if
            InstanceOfMovieDatabaseRoom?.let { db ->
                scope.launch {
                    val movieDao = db.movieDao

                    movieDao.deleteAll()

                    FakeData.movieList.forEach{
                        movieDao.insert(it)
                    }
                }
            }
        }
    }

    companion object {
        private var InstanceOfMovieDatabaseRoom: MovieDatabaseRoom? = null


        @Synchronized
        fun getInstance(
            context: Context,
            viewModelScope: CoroutineScope
        ): MovieDatabaseRoom {
            if (InstanceOfMovieDatabaseRoom == null) {
                InstanceOfMovieDatabaseRoom = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabaseRoom::class.java,
                    "movies_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(MovieDatabaseCallback(viewModelScope))
                    .build()
            }
            return InstanceOfMovieDatabaseRoom!!
        }
    }
}
