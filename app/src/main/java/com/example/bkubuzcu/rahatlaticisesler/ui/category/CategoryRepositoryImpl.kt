package com.example.bkubuzcu.rahatlaticisesler.ui.category

import com.example.bkubuzcu.rahatlaticisesler.api.GithubService
import com.example.bkubuzcu.rahatlaticisesler.app.Constants
import com.example.bkubuzcu.rahatlaticisesler.base.ApiResponse
import com.example.bkubuzcu.rahatlaticisesler.base.OnResponseListener
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by bkubuzcu on 25/09/18.
 * this is CategoryRepositoryImpl.
 * service calls and database operations are performed here.
 */
class CategoryRepositoryImpl(private val service: GithubService) : CategoryRepository {
    override fun getCategories(listener: OnResponseListener<List<Category>>) {
        service.getCategories().enqueue(object : Callback<List<Category>?> {
            override fun onFailure(call: Call<List<Category>?>?, t: Throwable) {
                listener.onResponse(ApiResponse.error(t))
            }

            override fun onResponse(call: Call<List<Category>?>?, response: Response<List<Category>?>) {
                if (response.body() != null && response.code() == Constants.RESPONSE_SUCCESS_CODE) {
                    listener.onResponse(ApiResponse.success(response.body()!!))
                } else {
                    listener.onResponse(ApiResponse.error(Throwable(Constants.ERROR_OCCURRED)))
                }
            }
        })
    }
}

interface CategoryRepository {
    /**
     * call category service
     */
    fun getCategories(listener: OnResponseListener<List<Category>>)
}