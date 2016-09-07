package com.yelinaung.luluaung.views

import com.yelinaung.luluaung.model.network.Datum

/**
 * Created by user on 9/5/16.
 */
interface View {
    fun renderItemList(data: List<Datum>)
    fun viewItem(data: Datum)
}