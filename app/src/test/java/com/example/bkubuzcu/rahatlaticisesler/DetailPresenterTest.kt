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
 */
class DetailPresenterTest {
    private val view = mock<DetailContract.View>()
    private val repository = MockDetailRepository()
    private val localRepository = MockLocalFavouriteRepository()
    private val presenter = DetailPresenter(repository, localRepository)

    @Before
    fun setup() {
        presenter.attach(view)
    }

    @Test
    fun songListFail() {
        repository.isSuccess = false
        presenter.getSongs(repository.category)

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onError(any())
    }

    @Test
    fun songListSuccess() {
        repository.isSuccess = true
        presenter.getSongs(repository.category)
        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onGetSongs(any())
    }
}