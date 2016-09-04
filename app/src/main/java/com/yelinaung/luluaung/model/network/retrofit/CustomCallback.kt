package com.yelinaung.luluaung.model.network.retrofit

import com.yelinaung.luluaung.model.network.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by user on 9/4/16.
 */
interface CustomCallback : Callback<Item> {
    override fun onFailure(call: Call<Item>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<Item>?, response: Response<Item>?) {
        if (response!!.code() == 404 || response.body().data.size > 0) {
            return
        }
    }
}