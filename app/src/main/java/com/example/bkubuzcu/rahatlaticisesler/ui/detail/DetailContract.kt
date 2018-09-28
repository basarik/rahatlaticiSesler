package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song

/**
 * Created by bkubuzcu on 27/09/18.
 */
interface DetailContract{
    interface View: BaseView{
        fun onGetSongs(songList:List<Song>)
    }

    interface Presenter:BaseMvpPresenter<View>{
        fun getSongs(category: Category)
        fun insertSong(song: Song)
        fun deleteSong(song: Song)
    }
}