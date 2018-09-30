package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 27/09/18.
 * this is DetailContract.
 * this hosts all interface about view and presenter interactions
 */
interface DetailContract {
    /**
     * detail view
     */
    interface View : BaseView {
        fun onGetSongs(songList: List<Song>)
    }

    /**
     * detail presenter
     */
    interface Presenter : BaseMvpPresenter<View> {
        fun getSongs(category: Category)
        fun insertSong(song: Song)
        fun deleteSong(song: Song)
    }
}