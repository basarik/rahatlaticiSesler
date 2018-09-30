package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteContract
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouritePresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by bkubuzcu on 26/09/18.
 * this is FavouritePresenterTest.
 */
class FavouritePresenterTest {
    /**
     * mock view
     */
    private val view = mock<FavouriteContract.View>()
    /**
     * mock favourite repository
     */
    private val localRepository = MockLocalFavouriteRepository()
    /**
     * favourite presenter
     */
    private val presenter = FavouritePresenter(localRepository)

    @Before
    fun setup() {
        presenter.attach(view)
    }

    /**
     * get songs from database scenario
     */
    @Test
    fun getLocalFavourites() {
        presenter.getFavourites()

        verify(view).onGetFavourites(any())
    }
}