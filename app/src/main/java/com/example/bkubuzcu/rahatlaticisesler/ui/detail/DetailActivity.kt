package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.app.MediaPlayerManager
import com.example.bkubuzcu.rahatlaticisesler.app.SongCompletionListener
import com.example.bkubuzcu.rahatlaticisesler.app.Util
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.OnItemClickListener
import com.example.bkubuzcu.rahatlaticisesler.ui.SongAdapter
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by bkubuzcu on 27/09/18.
 * this is DetailActivity.
 */

class DetailActivity : BaseActivity(), DetailContract.View, OnItemClickListener, SongCompletionListener {

    /**
     * MediaPlayer
     */
    private val mediaPlayerManager = MediaPlayerManager()
    /**
     * it is used to update the icon when the song is finished
     */
    private lateinit var localSongList: List<Song>
    /**
     * detail presenter
     */
    private lateinit var presenter: DetailContract.Presenter

    override fun layoutResource() = R.layout.activity_detail

    override fun initActivity() {

        val category = intent.getSerializableExtra(KEY_CATEGORY) as Category

        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter = App.instance.presenterFactory.detailPresenter()
        presenter.attach(this)
        presenter.getSongs(category)

        mediaPlayerManager.listener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
        mediaPlayerManager.release()
    }

    override fun onGetSongs(songList: List<Song>) {
        localSongList = songList
        recyclerView.adapter = SongAdapter(localSongList, this)
        mediaPlayerManager.setSongs(localSongList)
    }

    override fun onPlayClick(song: Song) {
        mediaPlayerManager.playAndPause(song)
    }

    override fun onCompleted(song: Song) {
        localSongList.find { it.id == song.id }?.isPlay = false
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun onFavouriteClick(song: Song) {
        if (Util.isFavourite(song)) {
            presenter.deleteSong(song)
        } else {
            presenter.insertSong(song)
        }
    }

    companion object {
        /**
         * const category
         */
        const val KEY_CATEGORY = "category"

        /**
         * start activity
         */
        fun start(context: Context, category: Category) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_CATEGORY, category)
            context.startActivity(intent)
        }
    }
}
