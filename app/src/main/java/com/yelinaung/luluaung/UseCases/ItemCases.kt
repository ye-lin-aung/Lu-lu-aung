package com.yelinaung.luluaung.UseCases

import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.threads.PostExecutionThread
import com.yelinaung.luluaung.threads.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Created by user on 9/7/16.
 */
abstract class ItemCases {

    private var subscription = Subscriptions.empty()
    lateinit var threadExecutor: ThreadExecutor
    lateinit var postExecutionThread: PostExecutionThread

    abstract fun buildObservable(page: String): Observable<Item>
    abstract fun buildCache(): Observable<Item>

    constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : super() {
        this.threadExecutor = threadExecutor
        this.postExecutionThread = postExecutionThread
    }


    fun execute(subscriber: Subscriber<Item>, page: String) {
        this.subscription = buildObservable(page).subscribeOn(Schedulers.from(threadExecutor)).observeOn(postExecutionThread.scheduler).subscribe(subscriber)
    }

    fun getCached(subscriber: Subscriber<Item>) {
        this.subscription = buildCache().subscribeOn(Schedulers.from(threadExecutor)).observeOn(postExecutionThread.scheduler).subscribe(subscriber)
    }

    fun removesubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

}