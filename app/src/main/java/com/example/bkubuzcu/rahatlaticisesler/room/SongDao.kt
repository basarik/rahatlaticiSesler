package com.example.bkubuzcu.rahatlaticisesler.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 */
@Dao
interface SongDao {
    @get:Query("SELECT * from song")
    val all: List<Song>

    @Insert
    fun insert(song: Song)

    @Delete
    fun delete(song: Song)
}