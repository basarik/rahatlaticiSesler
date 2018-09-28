package com.example.bkubuzcu.rahatlaticisesler.app

import android.media.MediaPlayer
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 */
class MediaPlayerManager : HashMap<Int, MediaPlayer>() {

    fun setSongs(songs: List<Song>) {
        songs.forEach {
            this[it.id] = MediaPlayer()
        }
    }

    fun release() {
        entries.forEach {
            it.value.stop()
        }
    }

    fun playAndPause(song: Song) {
        this[song.id]?.apply {
            if (isPlaying) {
                pause()
            } else {
                if (currentPosition == 0) {
                    try {
                        setDataSource(song.url)
                        prepare()
                    } catch (e: Exception) {
                    }
                }
                start()
            }
        }
    }

}