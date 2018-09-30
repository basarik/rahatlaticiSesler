package com.example.bkubuzcu.rahatlaticisesler.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 * this is SongDao.
 * all functions about song database are here.
 */
@Dao
interface SongDao {
    /**
     * get all songs from database
     */
    @get:Query("SELECT * from song")
    val all: List<Song>

    /**
     * insert related song to database
     */
    @Insert
    fun insert(song: Song)

    /**
     * delete related song from database
     */
    @Delete
    fun delete(song: Song)
}