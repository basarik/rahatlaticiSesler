package com.example.bkubuzcu.rahatlaticisesler.base

/**
 * Created by bkubuzcu on 26/09/18.
 * this is BasePresenter.
 * all presenters reproduce from this
 */
open class BasePresenter<T: BaseView> : BaseMvpPresenter<T> {
    /**
     * related presenter view
     */
    var view:T? = null

    override fun attach(baseView: T) {
        view = baseView
    }

    override fun detach() {
        view = null
    }
}