package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryContract
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by bkubuzcu on 26/09/18.
 * this is CategoryPresenterTest.
 */
class CategoryPresenterTest {

    /**
     * mock view
     */
    private val view = mock<CategoryContract.View>()
    /**
     * mock repository
     */
    private val repository = MockCategoryRepository()
    /**
     * category presenter
     */
    private var presenter = CategoryPresenter(repository)

    @Before
    fun setup() {
        presenter.attach(view)
    }

    /**
     * category success scenario
     */
    @Test
    fun categoryListFail() {
        repository.isSuccess = false
        presenter.getCategories()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onError(any())
    }

    /**
     * category fail scenario
     */
    @Test
    fun categoryListSuccess() {
        repository.isSuccess = true
        presenter.getCategories()

        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).onGetCategories(any())
    }

}