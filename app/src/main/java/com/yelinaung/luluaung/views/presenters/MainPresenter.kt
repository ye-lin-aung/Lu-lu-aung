package com.yelinaung.luluaung.views.presenters

import com.yelinaung.luluaung.UseCases.ItemCases
import com.yelinaung.luluaung.model.network.Item
import com.yelinaung.luluaung.scope.RepoScope
import com.yelinaung.luluaung.views.views.MainView
import rx.Subscriber
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by user on 9/5/16.
 */


@RepoScope class MainPresenter : MainPresenterImpl {

    var list: MutableList<String> = mutableListOf();
    lateinit var useCase: ItemCases
    lateinit var view: MainView;
    var loading = false


    @Inject constructor(@Named("itemList") useCase: ItemCases) {
        this.useCase = useCase
        list.add("MTA4OTgzODc4Nzc2NDQ0MwZDZD")
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
        if (!loading) {
            loading = true
            useCase.execute(ItemSubscriber(), list.last())
        }
        useCase.getCached(ItemSubscriber())
        view.showProgress()
        view.hideitems()
    }

    fun paginate() {
        if (!loading) {
            loading = true
            useCase.execute(ItemSubscriber(), list.last())
        }
        
    }

    private inner class ItemSubscriber : Subscriber<Item>() {
        override fun onCompleted() {
            loading = false
        }

        override fun onError(e: Throwable?) {
            e!!.printStackTrace()
        }

        override fun onNext(t: Item?) {
            if (t!!.data.distinct().count() > 0) {
                view.hideProgress()
                view.showitems()
                list.add(t.paging!!.cursors!!.after.toString())
                this@MainPresenter.view.renderItemList(t.data.distinct())
            }
            onCompleted()
        }
    }

}
