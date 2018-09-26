package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryPresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryRepositoryImpl

/**
 * Created by bkubuzcu on 26/09/18.
 */
open class PresenterFactory{
    fun categoryPresenter():CategoryContract.Presenter = CategoryPresenter(categoryRepository())
    open fun categoryRepository(): CategoryRepository = CategoryRepositoryImpl(App.instance.service)
}