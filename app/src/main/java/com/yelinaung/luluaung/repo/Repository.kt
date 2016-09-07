package com.yelinaung.luluaung.repo


import com.yelinaung.luluaung.model.network.Item
import rx.Observable

/**
 * Created by user on 9/4/16.
 */

interface Repository {
    fun getData(): Observable<Item>
    fun getDataByPages(page:String): Observable<Item>
}