package com.example.bkubuzcu.rahatlaticisesler.ui

import com.example.bkubuzcu.rahatlaticisesler.base.BaseMvpPresenter
import com.example.bkubuzcu.rahatlaticisesler.base.BaseView
import com.example.bkubuzcu.rahatlaticisesler.model.Category

/**
 * Created by bkubuzcu on 25/09/18.
 */
interface CategoryContract{
    interface View : BaseView{
        fun onGetCategories(categories:List<Category>)
    }

    interface Presenter: BaseMvpPresenter<View>{
        fun getCategories()
    }
}