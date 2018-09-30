package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 * this is FavouriteContract
 * this hosts all interface about view and presenter interactions
 */
interface FavouriteContract {
    /**
     * favourite view
     */
    interface View : BaseView {
        fun onGetFavourites(favouriteList: List<Song>)
    }

    /**
     * favourite presenter
     */
    interface Presenter : BaseMvpPresenter<View> {
        fun getFavourites()
        fun delete(song: Song)
    }
}