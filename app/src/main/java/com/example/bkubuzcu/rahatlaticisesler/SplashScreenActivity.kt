package com.example.bkubuzcu.rahatlaticisesler

import android.content.Intent
import android.os.Handler
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity

class SplashScreenActivity : BaseActivity() {
    override fun layoutResource() = R.layout.activity_splash_screen

    override fun initActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }
}
