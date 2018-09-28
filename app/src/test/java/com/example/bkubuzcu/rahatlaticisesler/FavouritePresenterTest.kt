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
 */
class FavouritePresenterTest {
    private val view = mock<FavouriteContract.View>()
    private val repository = MockFavouriteRepository()
    private val localRepository = MockLocalFavouriteRepository()
    private val presenter = FavouritePresenter(repository, localRepository)

    @Before
    fun setup() {
        presenter.attach(view)
    }

    @Test
    fun favouriteListFail() {
        repository.isSuccess = false
        presenter.getFavourites()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onError(any())
    }

    @Test
    fun favouriteListSuccess() {
        repository.isSuccess = true
        presenter.getFavourites()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onGetFavourites(any())
    }
}