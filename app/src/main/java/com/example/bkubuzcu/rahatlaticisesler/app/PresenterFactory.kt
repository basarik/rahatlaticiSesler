package com.example.bkubuzcu.rahatlaticisesler.app

import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryPresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryRepositoryImpl
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailContract
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailPresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailRepositoryImpl
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteContract
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouritePresenter
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.LocalFavouriteRepository
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.LocalFavouriteRepositoryImpl

/**
 * Created by bkubuzcu on 26/09/18.
 * this is PresenterFactory.
 * all presenter and repository are created here.
 */
open class PresenterFactory {
    /**
     * categoryRepository
     */
    open fun categoryRepository(): CategoryRepository = CategoryRepositoryImpl(App.instance.service)

    /**
     * categoryPresenter
     */
    fun categoryPresenter(): CategoryContract.Presenter = CategoryPresenter(categoryRepository())

    /**
     * localFavouriteRepository
     */
    open fun localFavouriteRepository(): LocalFavouriteRepository = LocalFavouriteRepositoryImpl(App.instance.database.songDao())

    /**
     * favouritePresenter
     */
    fun favouritePresenter(): FavouriteContract.Presenter = FavouritePresenter(localFavouriteRepository())

    /**
     * detailRepository
     */
    open fun detailRepository(): DetailRepository = DetailRepositoryImpl(App.instance.service)

    /**
     * detailPresenter
     */
    fun detailPresenter(): DetailContract.Presenter = DetailPresenter(detailRepository(), localFavouriteRepository())
}