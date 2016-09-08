package com.yelinaung.luluaung.views.views

import com.yelinaung.luluaung.views.View


/**
 * Created by user on 9/5/16.
 */

interface MainView : View {

    fun showProgress()
    fun hideProgress()
    fun processViews()
    fun showitems()
    fun hideNoData()
    fun showNoData()
    fun hideitems()
    fun onError()

}
