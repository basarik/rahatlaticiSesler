package com.example.bkubuzcu.rahatlaticisesler

import android.support.v4.view.ViewPager
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun layoutResource() = R.layout.activity_main

    override fun initActivity() {
        vPFragment.adapter = MainAdapter(supportFragmentManager)

        vPFragment.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener({
            when (it.itemId) {
                R.id.favorites -> vPFragment.currentItem = 0
                R.id.categories -> vPFragment.currentItem = 1
            }
            true
        })
    }
}
