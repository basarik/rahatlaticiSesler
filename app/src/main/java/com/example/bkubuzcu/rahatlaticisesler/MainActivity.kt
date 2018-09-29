package com.example.bkubuzcu.rahatlaticisesler

import android.support.v4.view.ViewPager
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private lateinit var adapter: MainAdapter
    private val fragmentFavourite = 0
    private val fragmentLibrary = 1

    override fun layoutResource() = R.layout.activity_main

    override fun initActivity() {
        adapter = MainAdapter(supportFragmentManager)

        vPFragment.adapter = adapter
        vPFragment.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
                if (position == 0) {
                    refresh()
                }
                when (position) {
                    fragmentFavourite -> getActivityTitle(fragmentFavourite)
                    fragmentLibrary -> getActivityTitle(fragmentLibrary)
                }
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener({
            when (it.itemId) {
                R.id.favorites -> {
                    vPFragment.currentItem = fragmentFavourite
                    refresh()
                    getActivityTitle(fragmentFavourite)
                }

                R.id.categories -> {
                    vPFragment.currentItem = fragmentLibrary
                    getActivityTitle(fragmentLibrary)
                }
            }
            true
        })
    }

    private fun refresh() {
        (adapter.getItem(fragmentFavourite) as FavouriteFragment?)?.refresh()
    }

    private fun getActivityTitle(fragment: Int) {
        if (fragment == fragmentLibrary) {
            setTitle(R.string.library)
        } else {
            setTitle(R.string.favourite)
        }
    }
}
