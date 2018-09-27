package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 28/09/18.
 */
class DetailPresenter(private val repository: DetailRepository) : BasePresenter<DetailContract.View>(), DetailContract.Presenter, OnResponseListener<List<Song>> {

    override fun getSongs(category: Category) {
        view?.showProgress()
        repository.getSongs(this, category)
    }

    override fun onResponse(data: ApiResponse<List<Song>>) {
        view?.hideProgress()
        data.error?.apply {
            view?.onError(this)
        }
        data.success?.apply {
            view?.onGetSongs(this)
        }
    }
}