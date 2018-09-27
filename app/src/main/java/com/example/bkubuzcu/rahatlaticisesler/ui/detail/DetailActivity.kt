package com.example.bkubuzcu.rahatlaticisesler.ui.detail

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.app.App
import com.example.bkubuzcu.rahatlaticisesler.base.BaseActivity
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import com.example.bkubuzcu.rahatlaticisesler.ui.SongAdapter
import kotlinx.android.synthetic.main.fragment_category.*

class DetailActivity : BaseActivity(), DetailContract.View {
    override fun initActivity() {

        val category = intent.getSerializableExtra(KEY_CATEGORY) as Category


        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter = App.instance.presenterFactory.detailPresenter()
        presenter.attach(this)
        presenter.getSongs(category)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun layoutResource() = R.layout.activity_detail

    private lateinit var presenter: DetailContract.Presenter

    override fun onGetSongs(songList: List<Song>) {
        recyclerView.adapter = SongAdapter(songList)
    }

    companion object {
        const val KEY_CATEGORY = "category"
        fun start(context: Context, category: Category){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_CATEGORY, category)
            context.startActivity(intent)
        }
    }
}
