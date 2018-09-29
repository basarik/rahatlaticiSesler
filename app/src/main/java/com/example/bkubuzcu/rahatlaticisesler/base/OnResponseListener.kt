package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 25/09/18.
 */
interface OnResponseListener<in T> {
    fun onResponse(data: ApiResponse<T>)
}

data class ApiResponse<out T>(val success: T? = null, val error: Throwable? = null) {
    companion object {
        fun <T> success(data: T) = ApiResponse(success = data)
        fun <T> error(err: Throwable) = ApiResponse<T>(error = err)
    }
}