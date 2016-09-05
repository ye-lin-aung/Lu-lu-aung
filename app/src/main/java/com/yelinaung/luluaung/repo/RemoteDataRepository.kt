package com.yelinaung.luluaung.repo

import android.content.Context
import android.content.SharedPreferences
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.model.network.createMap
import com.yelinaung.luluaung.model.network.retrofit.CustomCallback
import com.yelinaung.luluaung.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

/**
 * Created by user on 9/4/16.
 */


class RemoteDataRepository : Repository, CustomCallback {

    lateinit var retrofit: Retrofit
    lateinit var context: Context

    val list = mutableListOf<Datum>()
    val pageList = mutableListOf<String>("MTA4OTgzODc4Nzc2NDQ0MwZDZD")

    @Inject constructor(retrofit: Retrofit, context: Context, sharedPreferences: SharedPreferences) {
        this.retrofit = retrofit
        this.context = context


    }


    override fun getData(): List<Datum> {
        synchronized(this) {
            val call = retrofit.create(ApiClient::class.java).getItem(createMap(), pageList.last())
            call.enqueue(this)
        }
        return list
    }

    override fun onFailure(call: Call<Item>?, t: Throwable?) {
        super.onFailure(call, t)
        t!!.printStackTrace()
    }

    override fun onResponse(call: Call<Item>?, response: Response<Item>?) {
        super.onResponse(call, response)
        if (response!!.body().paging!!.next != null && response.body().paging!!.next!!.length > 0) {
            pageList.add(response.body().paging!!.next.toString())
            Collections.copy(list, response.body().data)
        }
    }

}