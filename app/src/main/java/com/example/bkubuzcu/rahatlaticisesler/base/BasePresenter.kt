package com.example.bkubuzcu.rahatlaticisesler.base

open class BasePresenter<T: BaseView> : BaseMvpPresenter<T> {
    var view:T? = null

    override fun attach(baseView: T) {
        view = baseView
    }

    override fun detach() {
        view = null
    }
}