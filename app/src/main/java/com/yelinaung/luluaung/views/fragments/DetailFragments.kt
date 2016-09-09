package com.yelinaung.luluaung.views.fragments


import android.Manifest
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.model.network.Datum
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.content_detail.view.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import uk.co.senab.photoview.PhotoViewAttacher
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Created by user on 9/9/16.
 */
const val BUNDLE_KEY = "BDN"
const val FILE_PER = 10

class DetailFragments : Fragment() {


    lateinit var datum: Datum
    lateinit var animation: Animation
    lateinit var loaded_bitmap: Bitmap


    var resouse_loaded: Boolean = false

    companion object {
        fun newInstance(datum: Datum): Fragment {
            val d: DetailFragments = DetailFragments()
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_KEY, datum)
            d.arguments = bundle
            return d
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        datum = arguments.getSerializable(BUNDLE_KEY) as Datum

        return inflater!!.inflate(R.layout.content_detail, container, false)
    }

    fun showText(view: View, message: String) {
        Snackbar.make(layout.rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    @AfterPermissionGranted(FILE_PER)
    fun DownloadTaskIfReady() {
        val perms = Manifest.permission.WRITE_EXTERNAL_STORAGE
        if (EasyPermissions.hasPermissions(context, perms)) {
            if (resouse_loaded) {
                DownTask().execute()
            } else {
                showText(layout, "Sorry Wallpaper is not Ready")
            }

        } else {
            showText(layout, "Permission denied by user")
            // Do not have permissions, request them now
            //EasyPermissions.requestPermissions(this, getString(R.string.camera_and_wifi_rationa)
        }


    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation = AnimationUtils.loadAnimation(context, R.anim.fab_animation)
        val bitmap = Glide.with(this).load(datum.images.get(0).source).asBitmap()
        layout.fab.setOnClickListener { v1 -> showText(layout, "Sorry Image have not been loaded yet") }
        layout.fab.visibility = View.GONE
        bitmap.into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                loaded_bitmap = resource!!
                val attacher: PhotoViewAttacher = PhotoViewAttacher(content_detail.detail_image)
                resouse_loaded = true
                content_detail.detail_image.setImageBitmap(loaded_bitmap)
                attacher.update()
                fab.startAnimation(animation)
                layout.fab.visibility = View.VISIBLE
                layout.fab.setOnLongClickListener { v2 ->

                    DownloadTaskIfReady()
                    true
                }
                layout.fab.setOnClickListener { v1 ->
                    val myWallpaperManager = WallpaperManager.getInstance(context.applicationContext)
                    try {
                        myWallpaperManager.setBitmap(loaded_bitmap)
                        showText(layout, "Wallpaper Set")
                    } catch (e: IOException) {
                        e.printStackTrace()
                        showText(layout, "Error Occur please try again later")
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
                loaded_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
                return true
            } else {
                return false
            }
        }

        override fun onPostExecute(result: Boolean) {
            super.onPostExecute(result)
            if (result) {
                showText(layout, "Downloaded")
            } else {
                showText(layout, "Error Occur please try again late")

            }
        }
    }

}
