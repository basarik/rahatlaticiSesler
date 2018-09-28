package com.example.bkubuzcu.rahatlaticisesler

import android.support.v4.view.ViewPager
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    lateinit var adapter: MainAdapter

    override fun layoutResource() = R.layout.activity_main

    override fun initActivity() {
        adapter = MainAdapter(supportFragmentManager)
        vPFragment.adapter = adapter

        vPFragment.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
                if (position == 0){
                    refresh()
                }
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener({
            when (it.itemId) {
                R.id.favorites -> {
                    vPFragment.currentItem = 0
                    refresh()
                }

                R.id.categories -> vPFragment.currentItem = 1
            }
            true
        })
    }

    fun refresh() {
        (adapter.getItem(0) as FavouriteFragment?)?.refresh()
    }
}
