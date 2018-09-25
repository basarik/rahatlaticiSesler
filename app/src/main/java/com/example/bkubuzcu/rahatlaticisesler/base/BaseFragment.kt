package com.example.bkubuzcu.rahatlaticisesler.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Created by bkubuzcu on 25/09/18.
 */
abstract class BaseFragment : Fragment(), BaseView{
    abstract fun layoutResource() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource(), container, false)
    }

    override fun showProgress() {
        baseActivity()?.showProgress()
    }

    override fun hideProgress() {
        baseActivity()?.hideProgress()
    }

    override fun onError(t: Throwable) {
        baseActivity()?.onError(t)
    }

    private fun baseActivity() = activity as BaseActivity?
}