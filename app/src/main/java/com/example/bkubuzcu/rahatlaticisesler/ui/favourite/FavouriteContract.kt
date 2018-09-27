package com.example.bkubuzcu.rahatlaticisesler.ui.favourite

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 26/09/18.
 */
interface FavouriteContract {
    interface View : BaseView {
        fun onGetFavourites(favouriteList:List<Song>)
    }

    interface Presenter: BaseMvpPresenter<View> {
        fun getFavourites()
    }
}