package com.yelinaung.luluaung.views.presenters

import android.util.Log
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.repo.CacheRepo
import com.yelinaung.luluaung.scope.RepoScope
import com.yelinaung.luluaung.useCases.ItemCases
import com.yelinaung.luluaung.views.views.MainView
import rx.Subscriber
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by user on 9/5/16.
 */


@RepoScope class MainPresenter : MainPresenterImpl {


    lateinit var useCase: ItemCases
    lateinit var cache: CacheRepo
    lateinit var view: MainView
    var loading = false
    lateinit var page: String;


    @Inject constructor(@Named("itemList") useCase: ItemCases, cache: CacheRepo) {
        this.useCase = useCase
        this.cache = cache
        page = cache.getPage() + ""
    }


    override fun setItemView(view: MainView) {
        this.view = view

    }

    override fun destroy() {

    }

    override fun pause() {
        useCase.removesubscribe()

    }

    override fun resume() {
        view.renderItemList(cache.getItems())
        useCase.execute(ItemSubscriber(), page)
        view.showProgress()
        view.hideNoData()
        view.hideitems()
    }

    fun paginate() {

        if (!loading) {
            loading = true
            useCase.execute(ItemSubscriber(), page)
        }
    }

    private inner class ItemSubscriber : Subscriber<Item>() {
        override fun onCompleted() {

            view.renderItemList(cache.getItems())
            view.processViews()
            loading = false
        }

        override fun onError(e: Throwable?) {
            e!!.printStackTrace()
            onCompleted()
        }

        override fun onNext(t: Item?) {

            if (t!!.data.count() > 0) {
                view.hideProgress()
                view.showitems()
                page = cache.getPage()
                this@MainPresenter.cache.addItem(t.paging!!.cursors!!.after.toString(), t)
            }
            Log.d("COMPLETED", "COMPLETED")
            onCompleted()

        }
    }

}
