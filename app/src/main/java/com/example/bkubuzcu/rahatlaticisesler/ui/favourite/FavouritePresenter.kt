package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 */
class FavouritePresenter(private val repository: FavouriteRepository) : BasePresenter<FavouriteContract.View>(), FavouriteContract.Presenter, OnResponseListener<List<Song>> {
    override fun getFavourites() {
        view?.showProgress()
        repository.getSongs(this)
    }

    override fun onResponse(data: ApiResponse<List<Song>>) {
        view?.hideProgress()
        data.error?.apply {
            view?.onError(this)
        }
        data.success?.apply {
            view?.onGetFavourites(this)
        }
    }

}