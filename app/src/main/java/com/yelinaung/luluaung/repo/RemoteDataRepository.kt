package com.yelinaung.luluaung.repo

import android.content.Context
import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.model.network.createMap
import com.yelinaung.luluaung.model.network.retrofit.CustomCallback
import com.yelinaung.luluaung.network.ApiClient
import retrofit2.Retrofit
import rx.Observable
import javax.inject.Inject

/**
 * Created by user on 9/4/16.
 */


class RemoteDataRepository : Repository, CustomCallback {

    lateinit var retrofit: Retrofit
    lateinit var context: Context

    var list = mutableListOf<Datum>()

    @Inject constructor(retrofit: Retrofit, context: Context) {
        this.retrofit = retrofit
        this.context = context


    }

    override fun getDataByPages(page: String): Observable<Item> {
        val call = retrofit.create(ApiClient::class.java).getItem(createMap(), page)
//        val call2 = retrofit.create(ApiClient::class.java).getDebug(createMap(), page)
        //Log.d("DATA", call2.request().toString());
        return call.asObservable()
    }

    override fun getData(): Observable<Item> {
        throw UnsupportedOperationException("No need")
    }

}