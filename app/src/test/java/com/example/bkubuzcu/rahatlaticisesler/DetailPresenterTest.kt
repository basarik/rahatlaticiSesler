package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailContract
import com.example.bkubuzcu.rahatlaticisesler.ui.detail.DetailPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by bkubuzcu on 28/09/18.
 * this is DetailPresenterTest.
 */
class DetailPresenterTest {
    /**
     * mock view
     */
    private val view = mock<DetailContract.View>()
    /**
     * mock repository
     */
    private val repository = MockDetailRepository()
    /**
     * mock favourite repository
     */
    private val localRepository = MockLocalFavouriteRepository()
    /**
     * detail presenter
     */
    private val presenter = DetailPresenter(repository, localRepository)

    @Before
    fun setup() {
        presenter.attach(view)
    }

    /**
     * song success scenario
     */
    @Test
    fun songListFail() {
        repository.isSuccess = false
        presenter.getSongs(repository.category)

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onError(any())
    }

    /**
     * song success scenario
     */
    @Test
    fun songListSuccess() {
        repository.isSuccess = true
        presenter.getSongs(repository.category)
        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onGetSongs(any())
    }
}