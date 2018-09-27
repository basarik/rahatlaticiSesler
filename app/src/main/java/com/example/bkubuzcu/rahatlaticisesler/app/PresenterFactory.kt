package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryPresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryRepositoryImpl
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteContract
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouritePresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteRepositoryImpl

/**
 * Created by bkubuzcu on 26/09/18.
 */
open class PresenterFactory{
    fun categoryPresenter(): CategoryContract.Presenter = CategoryPresenter(categoryRepository())
    open fun categoryRepository(): CategoryRepository = CategoryRepositoryImpl(App.instance.service)

    fun favouritePresenter(): FavouriteContract.Presenter = FavouritePresenter(favouriteRepository())
    open fun favouriteRepository(): FavouriteRepository = FavouriteRepositoryImpl(App.instance.service)
}