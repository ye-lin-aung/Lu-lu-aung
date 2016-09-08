package com.yelinaung.luluaung.useCases

import android.util.Log
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.repo.DataRepository
import com.yelinaung.luluaung.threads.PostExecutionThread
import com.yelinaung.luluaung.threads.ThreadExecutor
import rx.Observable
import javax.inject.Inject

/**
 * Created by user on 9/7/16.
 */

class GetItems : ItemCases {

    lateinit var dataRepository: DataRepository

    @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread, dataRepository: DataRepository) : super(threadExecutor, postExecutionThread) {
        this.dataRepository = dataRepository
    }


    override fun buildObservable(page: String): Observable<Item> {
        return this.dataRepository.getDataByPages(page)
    }

    override fun buildCache(): Observable<Item> {

        return this.dataRepository.cacheData()
    }

    override fun toString(): String {
        return "GetItems(dataRepository)"
    }

}
