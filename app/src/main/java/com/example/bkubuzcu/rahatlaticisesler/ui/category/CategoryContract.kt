package com.example.bkubuzcu.rahatlaticisesler.ui.category

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Category

/**
 * Created by bkubuzcu on 25/09/18.
 * this is CategoryContract.
 * this hosts all interface about view and presenter interactions
 */
interface CategoryContract {
    /**
     * category view
     */
    interface View : BaseView {
        fun onGetCategories(categories: List<Category>)
    }

    /**
     * category presenter
     */
    interface Presenter : BaseMvpPresenter<View> {
        fun getCategories()
    }
}