package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 25/09/18.
 * this is BaseView.
 * all presenter view reproduce from this
 */
interface BaseView {
    /**
     * show progress dialog when service call starts
     */
    fun showProgress()

    /**
     * * hide progress dialog when service call ended
     */
    fun hideProgress()

    /**
     * show error message when service call ended
     */
    fun onError(t: Throwable)
}