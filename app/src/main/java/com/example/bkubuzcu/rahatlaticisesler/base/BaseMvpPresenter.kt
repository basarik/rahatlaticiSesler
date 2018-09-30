package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 26/09/18.
 * this is BaseMvpPresenter.
 * BasePresenter reproduces from this
 */
interface BaseMvpPresenter<in T : BaseView> {
    /**
     * presenter attach here
     */
    fun attach(baseView: T)

    /**
     * presenter detach here
     */
    fun detach()
}