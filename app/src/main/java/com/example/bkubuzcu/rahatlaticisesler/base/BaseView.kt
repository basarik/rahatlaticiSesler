package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 25/09/18.
 */
interface BaseView {
    fun showProgress()

    fun hideProgress()

    fun onError(t: Throwable)
}