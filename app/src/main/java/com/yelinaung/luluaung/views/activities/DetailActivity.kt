package com.yelinaung.luluaung.views.activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import com.yelinaung.luluaung.AndroidApp
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.adapters.DetailPagerAdapter
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.util.setFullScreen
import com.yelinaung.luluaung.views.fragments.FILE_PER
import com.yelinaung.luluaung.views.presenters.DetailPresenter
import com.yelinaung.luluaung.views.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

const val DETAIL_PARCEL = "detail_parcel"

class DetailActivity : AppCompatActivity(), DetailView, ActivityCompat.OnRequestPermissionsResultCallback {


    @Inject lateinit var detailPresenter: DetailPresenter
    var position = 0

    override fun loadFirstTime(data: List<Datum>) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    object intent {
        fun getIntent(position: Int, context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DETAIL_PARCEL, position)
            return intent
        }
    }

    override fun viewItem(data: Datum) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderItemList(data: List<Datum>) {
        val pager = DetailPagerAdapter(supportFragmentManager, data.size, data)
        detail_pager.adapter = pager


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onStart() {
        super.onStart()
        detailPresenter.view = this
    }

    override fun onResume() {
        super.onResume()
        if (!EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            EasyPermissions.requestPermissions(this,"The app needs external storage option to save photos",FILE_PER, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        detailPresenter.resume()
        detail_pager.currentItem = position

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setFullScreen(this)
        (application as AndroidApp).dataComponent.inject(this)
        position = intent.getIntExtra(DETAIL_PARCEL, 0)


    }

}
