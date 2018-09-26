package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by bkubuzcu on 26/09/18.
 */
class CategoryPresenterTest {

    private val view = mock<CategoryContract.View>()
    private val repository = MockCategoryRepository()
    private var presenter = CategoryPresenter(repository)


    @Before
    fun setup() {
        presenter.attach(view)
    }

    @Test
    fun categoryListFail() {
        repository.isSuccess = false
        presenter.getCategories()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onError(any())
    }

    @Test
    fun categoryListSuccess() {
        repository.isSuccess = true
        presenter.getCategories()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onGetCategories(any())
    }


}