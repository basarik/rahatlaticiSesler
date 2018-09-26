package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryRepository

/**
 * Created by bkubuzcu on 26/09/18.
 */
class MockCategoryRepository : CategoryRepository {

    var isSuccess = true

    override fun getCategories(listener: OnResponseListener<List<Category>>) {
        if (isSuccess) {
            listener.onResponse(ApiResponse.success(CATEGORIES))
        } else {
            listener.onResponse(ApiResponse.error(Throwable(ERROR)))
        }


    }

    companion object {
        const val ERROR = "Mock Error"
        val CATEGORIES = listOf(Category(0, "asd"))
    }
}