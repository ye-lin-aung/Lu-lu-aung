package com.yelinaung.luluaung.views.presenters

import com.yelinaung.luluaung.views.Presenter
import com.yelinaung.luluaung.views.views.DetailView


/**
 * Created by user on 9/9/16.
 */

interface DetailPresenterImpl : Presenter {
    fun setItemView(view: DetailView)
}

