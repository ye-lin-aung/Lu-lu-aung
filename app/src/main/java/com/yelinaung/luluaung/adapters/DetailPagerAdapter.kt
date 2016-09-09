package com.yelinaung.luluaung.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.yelinaung.luluaung.views.fragments.DetailFragments
import com.yelinaung.luluaung.model.network.Datum

/**
 * Created by user on 9/9/16.
 */

class DetailPagerAdapter(fm: FragmentManager, val totalItems: Int, val list: List<Datum>) : FragmentStatePagerAdapter(fm) {


    override fun getCount(): Int {
        return totalItems
    }

    override fun getItem(position: Int): Fragment? {
        return DetailFragments.newInstance(list[position])
    }
}
