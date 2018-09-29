package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 */
class Util {
    companion object {
        fun isFavourite(song: Song): Boolean {
            App.instance.globalFavourites.forEach {
                if (song.id == it.id)
                    return true
            }
            return false
        }
    }
}