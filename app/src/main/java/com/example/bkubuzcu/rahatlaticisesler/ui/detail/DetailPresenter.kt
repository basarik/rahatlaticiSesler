package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.LocalFavouriteRepository

/**
 * Created by bkubuzcu on 28/09/18.
 */
class DetailPresenter(private val repository: DetailRepository,
                      private val localFavouriteRepository: LocalFavouriteRepository) : BasePresenter<DetailContract.View>(), DetailContract.Presenter, OnResponseListener<List<Song>> {
    override fun deleteSong(song: Song) {
        localFavouriteRepository.delete(song)
    }

    override fun insertSong(song: Song) {
        localFavouriteRepository.insert(song)
    }

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