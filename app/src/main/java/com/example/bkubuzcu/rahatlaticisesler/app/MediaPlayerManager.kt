package com.example.bkubuzcu.rahatlaticisesler.app

import android.media.MediaPlayer
import android.util.Log
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 * this is MediaPlayer manager.
 * all MediaPlayer functions are collected here as a manager.
 */
class MediaPlayerManager : HashMap<Int, MediaPlayer>() {

    /**
     * listener of MediaPlayer
     */
    var listener: SongCompletionListener? = null

    /**
     * create MediaPlayer as song size
     */
    fun setSongs(songs: List<Song>) {
        songs.forEach {
            this[it.id] = MediaPlayer()
        }
    }

    /**
     * release MediaPlayer
     */
    fun release() {
        entries.forEach {
            it.value.stop()
        }
    }

    /**
     * play or pause song according to the status of the song
     */
    fun playAndPause(song: Song) {
        this[song.id]?.apply {
            if (isPlaying) {
                pause()
            } else {
                //do when the song starts playing
                if (currentPosition == 0) {
                    try {
                        setDataSource(song.url)
                        prepareAsync()
                        setOnPreparedListener({
                            start()
                            setOnCompletionListener {
                                listener?.onCompleted(song)
                            }
                        })
                    } catch (e: Exception) {
                        Log.d("playAndPause", Constants.ERROR_OCCURRED)
                    }
                }
                //do when the song is paused
                else {
                    start()
                    setOnCompletionListener {
                        listener?.onCompleted(song)
                    }
                }
            }
        }
    }
}

interface SongCompletionListener {
    /**
     * this function is triggered when the song is finished
     */
    fun onCompleted(song: Song)
}