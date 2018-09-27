package com.example.bkubuzcu.rahatlaticisesler.model

import java.io.Serializable

/**
 * Created by bkubuzcu on 25/09/18.
 */
data class Category(val id:Int, val title:String):Serializable

data class Song(val id:Int, val title:String, val category:Int , val isFavourite:Boolean)