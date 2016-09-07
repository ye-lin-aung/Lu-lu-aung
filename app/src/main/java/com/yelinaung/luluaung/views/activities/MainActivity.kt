package com.yelinaung.luluaung.views.activities

//import com.yelinaung.luluaung.repo.RemoteDataRepository
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.yelinaung.luluaung.AndroidApp
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.adapters.ImageRecyclerAdapter
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.repo.DataRepository
import com.yelinaung.luluaung.views.presenters.MainPresenter
import com.yelinaung.luluaung.views.views.MainView
import com.yelinaung.luluaung.widgets.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    @Inject lateinit var userListPresenter: MainPresenter
    @Inject lateinit var dataRepo: DataRepository
    lateinit var imageRa: ImageRecyclerAdapter
    lateinit var endless: EndlessRecyclerViewScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as AndroidApp).dataComponent.inject(this)
        setSupportActionBar(activity_main.toolbar as Toolbar?)
        activity_main.item_rec.setHasFixedSize(true)
        imageRa = ImageRecyclerAdapter()
        activity_main.item_rec.adapter = imageRa;



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
        activity_main.item_rec.setOnScrollListener(object : EndlessRecyclerViewScrollListener(activity_main.item_rec.layoutManager as GridLayoutManager) {
            override fun onLoadMore() {
                userListPresenter.paginate()
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

    override fun onPause() {
        super.onPause()
        userListPresenter.pause()
    }

    override fun renderItemList(data: List<Datum>) {

        imageRa.replaceList(data)
    }

    override fun viewItem(data: Datum) {

    }
}
