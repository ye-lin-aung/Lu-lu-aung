package com.yelinaung.luluaung.views.presenters

import com.yelinaung.luluaung.views.Presenter
import com.yelinaung.luluaung.views.views.MainView

/**
 * Created by user on 9/8/16.
 */

interface MainPresenterImpl:Presenter{
    fun setItemView(view:MainView)
}
