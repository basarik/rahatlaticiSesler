package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 * this is FavouritePresenter.
 */
class FavouritePresenter(private val localRepository: LocalFavouriteRepository) : BasePresenter<FavouriteContract.View>(), FavouriteContract.Presenter, OnLocalFavouritesListener {
    override fun delete(song: Song) {
        localRepository.delete(song)
    }

    override fun getFavourites() {
        localRepository.getFavourites(this)
    }

    override fun onGetLocalFavourites(list: List<Song>) {
        view?.onGetFavourites(list)
    }
}

