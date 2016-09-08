package com.yelinaung.luluaung.repo

import android.util.Log
import com.yelinaung.luluaung.model.network.Item
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by user on 9/4/16.
 */

@Singleton
class DataRepository : Repository {


    @Inject lateinit var dataRepository: RemoteDataRepository

    @Inject constructor() {
        Log.d("we have created to here", "here")
    }

    lateinit var datas: Observable<Item>

    init {
        datas = Observable.empty()
    }

    fun cacheData(): Observable<Item> {
        return datas
    }

    override fun getDataByPages(page: String): Observable<Item> {
        datas = dataRepository.getDataByPages(page)
        return datas
    }

    override fun getData(): Observable<Item> {
        throw UnsupportedOperationException("No need")
    }
}

