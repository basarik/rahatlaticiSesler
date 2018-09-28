package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 */
class FavouritePresenter(private val repository: FavouriteRepository, private val localRepository: LocalFavouriteRepository) : BasePresenter<FavouriteContract.View>(), FavouriteContract.Presenter, OnResponseListener<List<Song>>, OnLocalFavourites {
    override fun onGetLocalFavourites(list: List<Song>) {
        if (list.isEmpty()) {
            view?.showProgress()
            repository.getSongs(this@FavouritePresenter)
        } else {
            view?.onGetFavourites(list)
        }
    }

    override fun getFavourites() {
        localRepository.getFavourites(this)
    }

    override fun onResponse(data: ApiResponse<List<Song>>) {
        view?.hideProgress()
        data.error?.apply {
            view?.onError(this)
        }
        data.success?.apply {
            view?.onGetFavourites(this)
            localRepository.insertAll(this@apply)
        }
    }

}