package com.example.bkubuzcu.rahatlaticisesler.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.base.BaseFragment
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by bkubuzcu on 25/09/18.
 */
class CategoryFragment : BaseFragment(),  CategoryContract.View {

    private lateinit var presenter:CategoryContract.Presenter

    override fun layoutResource() = R.layout.fragment_category


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        presenter = App.instance.presenterFactory.categoryPresenter()
        presenter.attach(this)

        presenter.getCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun onGetCategories(categories: List<Category>) {
        recyclerView.adapter = MyRecyclerViewAdapter(categories)
    }




}