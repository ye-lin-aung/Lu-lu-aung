package com.yelinaung.luluaung.views.activities

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.yelinaung.luluaung.AndroidApp
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.adapters.ImageRecyclerAdapter
import com.yelinaung.luluaung.event.ViewClick
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.repo.DataRepository
import com.yelinaung.luluaung.util.NetworkUtils
import com.yelinaung.luluaung.views.presenters.MainPresenter
import com.yelinaung.luluaung.views.views.MainView
import com.yelinaung.luluaung.widgets.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView, ViewClick {

    @Inject lateinit var userListPresenter: MainPresenter
    @Inject lateinit var dataRepo: DataRepository
    lateinit var imageRa: ImageRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as AndroidApp).dataComponent.inject(this)
        val tool = (activity_main.toolbar as Toolbar?)
        val tool_text = ((activity_main.toolbar as Toolbar?)!!.findViewById(R.id.text_tool) as TextView)
        tool_text.text = getString(R.string.app_name)
        tool_text.typeface = Typeface.createFromAsset(application.assets, "fonts/hipch.ttf")
        setSupportActionBar(tool)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        activity_main.item_rec.setHasFixedSize(true)
        imageRa = ImageRecyclerAdapter()
        activity_main.item_rec.adapter = imageRa;
        imageRa.click = this
        activity_main.no_data.setOnClickListener { v ->
            userListPresenter.resume()
        }
    }

    override fun hideNoData() {
        activity_main.no_data.visibility = View.GONE
    }

    override fun showNoData() {
        activity_main.no_data.visibility = View.VISIBLE
    }

    override fun click(position: Int, view: View) {
        startActivity(DetailActivity.intent.getIntent(imageRa.getItemAtPosition(position), this@MainActivity))
    }

    override fun processViews() {
        if (imageRa.itemCount > 1) {
            hideProgress()
            showitems()
            hideNoData()
        } else {
            hideProgress()
            showNoData()
            hideitems()
        }
    }

    override fun showProgress() {
        activity_main.progess.visibility = View.VISIBLE

    }

    override fun showitems() {
        activity_main.item_rec.visibility = View.VISIBLE

    }

    override fun hideitems() {
        activity_main.item_rec.visibility = View.GONE

    }

    override fun hideProgress() {
        activity_main.progess.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        this.userListPresenter.view = this
        activity_main.item_rec.setOnScrollListener(object : EndlessRecyclerViewScrollListener(activity_main.item_rec.layoutManager as GridLayoutManager, 5) {
            override fun onLoadMore() {
                if (NetworkUtils.isConnected(this@MainActivity)) {
                    userListPresenter.paginate()
                }
            }
        })
    }

    override fun onStop() {
        activity_main.item_rec.setOnScrollListener(null)
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        userListPresenter.resume()


    }

    override fun onError() {

    }

    override fun onPause() {
        super.onPause()
        userListPresenter.pause()
    }

    override fun renderItemList(data: List<Datum>) {
        imageRa.replaceList(data)
        processViews()
    }

    override fun viewItem(data: Datum) {

    }
}
