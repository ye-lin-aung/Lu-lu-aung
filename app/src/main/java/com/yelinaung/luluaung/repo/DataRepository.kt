package com.yelinaung.luluaung.repo

import com.yelinaung.luluaung.model.network.Item
import rx.Observable
import javax.inject.Inject

/**
 * Created by user on 9/4/16.
 */


class DataRepository : Repository {


    @Inject lateinit var dataRepository: RemoteDataRepository

    @Inject constructor()

    var datas: Observable<Item> = Observable.empty()

    fun cacheData(): Observable<Item> {
        return datas
    }

    override fun getDataByPages(page: String): Observable<Item> {
        datas = datas.mergeWith(dataRepository.getDataByPages(page))
        return datas
    }

    override fun getData(): Observable<Item> {
        throw UnsupportedOperationException("No need")
    }
}

