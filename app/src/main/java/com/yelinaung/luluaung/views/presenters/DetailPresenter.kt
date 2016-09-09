package com.yelinaung.luluaung.views.presenters

import com.yelinaung.luluaung.repo.CacheRepo
import com.yelinaung.luluaung.scope.RepoScope
import com.yelinaung.luluaung.views.views.DetailView
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by user on 9/9/16.
 */

@RepoScope class DetailPresenter : DetailPresenterImpl {


    lateinit var cache: CacheRepo
    lateinit var view: DetailView


    @Inject constructor(@Named("detailList") cache: CacheRepo) {
        this.cache = cache
    }

    override fun setItemView(view: DetailView) {
        this.view = view
    }

    override fun destroy() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun resume() {
        view.renderItemList(cache.getItems())
    }
}
