package com.example.bkubuzcu.rahatlaticisesler.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by bkubuzcu on 25/09/18.
 */
data class Category(val id: Int, val title: String) : Serializable

@Entity(tableName = "song")
data class Song(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "category")
        val category: Int,
        @ColumnInfo(name = "isFavourite")
        var isFavourite: Boolean,
        @ColumnInfo(name = "url")
        val url: String,
        var isPlay: Boolean
)