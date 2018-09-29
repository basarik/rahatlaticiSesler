package com.example.bkubuzcu.rahatlaticisesler.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.bkubuzcu.rahatlaticisesler.R

/**
 * Created by bkubuzcu on 25/09/18.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    private lateinit var loading: ProgressDialog

    abstract fun layoutResource(): Int
    abstract fun initActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
        loading = ProgressDialog(this)
        loading.setMessage(getString(R.string.loadingMessage))
        initActivity()
    }

    override fun showProgress() {
        loading.show()
    }

    override fun hideProgress() {
        loading.hide()
    }

    override fun onError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }
}