package com.example.bkubuzcu.rahatlaticisesler

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bkubuzcu.rahatlaticisesler.ui.category.CategoryFragment
import com.example.bkubuzcu.rahatlaticisesler.ui.favourite.FavouriteFragment

/**
 * Created by bkubuzcu on 27/09/18.
 * this is MainAdapter.
 */
class MainAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    /**
     * fragments with viewPager
     */
    private val fragments = listOf(
            FavouriteFragment(),
            CategoryFragment())

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

}