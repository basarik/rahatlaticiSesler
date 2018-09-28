package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.app.MediaPlayerManager
import com.example.bkubuzcu.rahatlaticisesler.base.BaseFragment
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.OnItemClickListener
import com.example.bkubuzcu.rahatlaticisesler.ui.SongAdapter
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by bkubuzcu on 26/09/18.
 */
class FavouriteFragment : BaseFragment(), FavouriteContract.View, OnItemClickListener {

    private val mediaPlayerManager = MediaPlayerManager()
    private lateinit var presenter: FavouriteContract.Presenter

    override fun onItemClick(song: Song) {
        mediaPlayerManager.playAndPause(song)
    }

    override fun layoutResource() = R.layout.fragment_favourite

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        presenter = App.instance.presenterFactory.favouritePresenter()
        presenter.attach(this)

        presenter.getFavourites()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
        mediaPlayerManager.release()
    }

    override fun onGetFavourites(favouriteList: List<Song>) {
        recyclerView.adapter = SongAdapter(favouriteList, this)
        mediaPlayerManager.setSongs(favouriteList)
    }
}