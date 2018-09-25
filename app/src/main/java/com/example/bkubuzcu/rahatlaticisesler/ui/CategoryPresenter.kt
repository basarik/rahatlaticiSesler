package com.example.bkubuzcu.rahatlaticisesler.ui

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.BasePresenter
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category

/**
 * Created by bkubuzcu on 25/09/18.
 */
class CategoryPresenter(private val repository: CategoryRepository) : BasePresenter<CategoryContract.View>(), CategoryContract.Presenter, OnResponseListener<List<Category>> {

    override fun getCategories() {
        view?.showProgress()
        repository.getCategories(this)
    }

    override fun onResponse(data: ApiResponse<List<Category>>) {
        view?.hideProgress()
        data.error?.apply {
            view?.onError(this)
        }

        data.success?.apply {
            view?.onGetCategories(this)
        }
    }

}