package com.yelinaung.luluaung.repo

import android.content.Context
import android.util.Log
import com.yelinaung.luluaung.AndroidApp
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.model.network.createMap
import com.yelinaung.luluaung.model.network.retrofit.CustomCallback
import com.yelinaung.luluaung.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by user on 9/4/16.
 */
class RemoteDataRepository() : Repository {

    lateinit var context: Context

    constructor(mContext: Context) : this() {
        context = mContext
    }

    @Inject lateinit var retrofit: Retrofit
    var default_page = "MTA4OTgzODc4Nzc2NDQ0MwZDZD"

    init {
        (context as AndroidApp).applicationComponent.inject(this)
    }


    override fun getData() {
        synchronized(this) {
            val call: Call<Item> = retrofit.create(ApiClient::class.java).getItem(createMap(), default_page)
            call.enqueue(object : CustomCallback {
                override fun onResponse(call: Call<Item>?, response: Response<Item>?) {
                    super.onResponse(call, response)
                    Log.d("DATA", response!!.body().data.size.toString())
                    default_page = response!!.body().paging!!.next.toString();
                }

                override fun onFailure(call: Call<Item>?, t: Throwable?) {
                    super.onFailure(call, t)
                    t!!.printStackTrace()
                    Log.d("FAILED", t!!.message);
                }
            });
        }
    }
}