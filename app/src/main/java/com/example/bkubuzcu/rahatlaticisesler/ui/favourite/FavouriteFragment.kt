package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.SeekBar
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.app.MediaPlayerManager
import com.example.bkubuzcu.rahatlaticisesler.app.SongCompletionListener
import com.example.bkubuzcu.rahatlaticisesler.base.BaseFragment
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.OnItemClickListener
import com.example.bkubuzcu.rahatlaticisesler.ui.SongAdapter
import kotlinx.android.synthetic.main.fragment_favourite.*


/**
 * Created by bkubuzcu on 26/09/18.
 */
class FavouriteFragment : BaseFragment(), FavouriteContract.View, OnItemClickListener, SongCompletionListener {

    private val mediaPlayerManager = MediaPlayerManager()
    private lateinit var presenter: FavouriteContract.Presenter
    private var localSongList = App.instance.globalFavourites

    override fun layoutResource() = R.layout.fragment_favourite

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)

        presenter = App.instance.presenterFactory.favouritePresenter()
        presenter.attach(this)
        presenter.getFavourites()

        mediaPlayerManager.listener = this

        val audioManager = activity?.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        seekBar.apply {
            progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
            max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, newVolume: Int, b: Boolean) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
        mediaPlayerManager.release()
    }

    override fun onPlayClick(song: Song) {
        mediaPlayerManager.playAndPause(song)
    }

    override fun onCompleted(song: Song) {
        localSongList.find { it.id == song.id }?.isPlay = false
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun onFavouriteClick(song: Song) {
        presenter.delete(song)
        localSongList.remove(song)

        recyclerView.adapter.notifyDataSetChanged()

        if (song.isPlay){
            mediaPlayerManager.release()
        }
    }

    override fun onGetFavourites(favouriteList: List<Song>) {
        recyclerView.adapter = SongAdapter(localSongList, this)
        mediaPlayerManager.setSongs(localSongList)
    }

    fun refresh() {
        presenter.getFavourites()
    }
}