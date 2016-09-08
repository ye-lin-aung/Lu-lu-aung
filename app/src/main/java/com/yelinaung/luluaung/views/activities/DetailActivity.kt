package com.yelinaung.luluaung.views.activities

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.util.setFullScreen
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.content_detail.view.*
import uk.co.senab.photoview.PhotoViewAttacher
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

const val DETAIL_PARCEL = "detail_parcel"

class DetailActivity : AppCompatActivity() {


    var loaded_bitmap: Bitmap? = null

    object intent {
        fun getIntent(datum: Datum, context: Context): Intent {
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DETAIL_PARCEL, datum)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setFullScreen(this)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "W8 its still loading", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        val datum = intent.getSerializableExtra(DETAIL_PARCEL) as Datum
        if (datum.name != null ) {
            name.text = datum.name
        }
        val bitmap = Glide.with(this).load(datum.images.get(0).source).asBitmap()
        bitmap.into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                loaded_bitmap = resource!!
                val attacher: PhotoViewAttacher = PhotoViewAttacher(content_detail.detail_image)
                if (loaded_bitmap != null) {
                    content_detail.detail_image.setImageBitmap(loaded_bitmap)
                    fab.setOnLongClickListener { v ->
                        DownTask().execute()
                        attacher.update()
                        true
                    }
                    fab.setOnClickListener { v ->
                        val myWallpaperManager = WallpaperManager.getInstance(applicationContext)
                        try {
                            myWallpaperManager.setBitmap(loaded_bitmap)
                            Snackbar.make(layout, "Wallpaper set", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                        } catch (e: IOException) {
                            e.printStackTrace()
                            Snackbar.make(layout, "Error Occured please try again later", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                        }
                    }

                }
            }
        })


    }

    inner class DownTask : AsyncTask<Unit, Unit, Boolean>() {

        override fun doInBackground(vararg p0: Unit?): Boolean {
            var folder = File(Environment.getExternalStorageDirectory().toURI().path + "/lu2aung/")
            if (!folder.exists()) {
                folder.mkdirs()
            }
            val file = File(folder.toURI().path + System.currentTimeMillis() + ".jpg");
            file.createNewFile()
            if (file.exists()) {
                Log.d("FILEs", file.absolutePath)
                val os = FileOutputStream(file);
                loaded_bitmap!!.compress(Bitmap.CompressFormat.JPEG, 100, os);
                return true
            } else {
                return false
            }
        }

        override fun onPostExecute(result: Boolean) {
            super.onPostExecute(result)
            if (result) {
                Snackbar.make(layout, "Image  save", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            } else {
                Snackbar.make(layout, "Error Occured please try again later", Snackbar.LENGTH_LONG).setAction("Action", null).show()

            }
        }
    }

}
