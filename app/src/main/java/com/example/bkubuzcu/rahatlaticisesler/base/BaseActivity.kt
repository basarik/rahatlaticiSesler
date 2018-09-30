package com.example.bkubuzcu.rahatlaticisesler.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.bkubuzcu.rahatlaticisesler.R

/**
 * Created by bkubuzcu on 25/09/18.
 * this is BaseActivity.
 * all activities reproduce from this
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    /**
     * loadingDialog
     */
    private lateinit var loading: ProgressDialog

    /**
     * activity layout
     */
    abstract fun layoutResource(): Int

    /**
     * activity operations that will make on onCreate
     */
    abstract fun initActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
        loading = ProgressDialog(this)
        loading.setMessage(getString(R.string.loadingMessage))
        initActivity()
    }

    /**
     * show loading
     */
    override fun showProgress() {
        loading.show()
    }

    /**
     * hide loading
     */
    override fun hideProgress() {
        loading.hide()
    }

    override fun onError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }
}