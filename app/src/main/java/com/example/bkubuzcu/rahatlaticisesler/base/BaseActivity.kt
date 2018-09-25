package com.example.bkubuzcu.rahatlaticisesler.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by bkubuzcu on 25/09/18.
 */
open class BaseActivity : AppCompatActivity(), BaseView {

    private lateinit var looding: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        looding = ProgressDialog(this)
    }

    override fun showProgress() {
        looding.show()
    }

    override fun hideProgress() {
        looding.hide()
    }

    override fun onError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }


}