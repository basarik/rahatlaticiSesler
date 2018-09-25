package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryPresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryRepository

/**
 * Created by bkubuzcu on 26/09/18.
 */
class PresenterFactory{
    fun categoryPresenter():CategoryContract.Presenter = CategoryPresenter(categoryRepository())
    fun categoryRepository() = CategoryRepository(App.instance.service)
}