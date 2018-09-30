package com.example.bkubuzcu.rahatlaticisesler.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 * this is AppDatabase.
 * room database instance is created here.
 */
@Database(entities = [Song::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    /**
     * song database object
     */
    abstract fun songDao(): SongDao

    companion object {
        /**
         * instance
         */
        private var instance: AppDatabase? = null

        /**
         * created instance
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "example")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }
    }
}