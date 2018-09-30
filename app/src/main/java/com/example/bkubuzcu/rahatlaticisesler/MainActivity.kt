package com.example.bkubuzcu.rahatlaticisesler

import android.support.v4.view.ViewPager
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by bkubuzcu on 26/09/18.
 * this is MainActivity.
 */
class MainActivity : BaseActivity() {

    /**
     * main adapter
     */
    private lateinit var adapter: MainAdapter
    /**
     * favourite fragment id
     */
    private val fragmentFavourite = 0
    /**
     * category fragment id
     */
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
                if (position == fragmentFavourite) {
                    refreshFavourites()
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
                    refreshFavourites()
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

    /**
     * refresh songs
     */
    private fun refreshFavourites() {
        (adapter.getItem(fragmentFavourite) as FavouriteFragment?)?.refresh()
    }

    /**
     * decides the activity title.
     */
    private fun getActivityTitle(fragment: Int) {
        if (fragment == fragmentLibrary) {
            setTitle(R.string.library)
        } else {
            setTitle(R.string.favourite)
        }
    }
}
