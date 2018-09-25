package com.example.bkubuzcu.rahatlaticisesler

import android.os.Bundle
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.ui.CategoryFragment


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.main, CategoryFragment()).commit()


    }
}
