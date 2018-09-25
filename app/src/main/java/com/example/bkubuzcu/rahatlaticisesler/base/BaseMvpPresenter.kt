package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 16/07/18.
 */
interface BaseMvpPresenter<in T : BaseView> {
    fun attach(baseView: T)

    fun detach()
}