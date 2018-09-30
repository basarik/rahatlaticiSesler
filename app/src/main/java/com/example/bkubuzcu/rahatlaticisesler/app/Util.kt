package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 * this is Util.
 */
class Util {
    companion object {
        /**
         * it indicates that the song is favourite or not.
         */
        fun isFavourite(song: Song): Boolean {
            App.instance.globalFavourites.forEach {
                if (song.id == it.id)
                    return true
            }
            return false
        }
    }
}