package com.yelinaung.luluaung.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.model.network.Datum

/**
 * Created by user on 9/8/16.
 */

class DetailFragmentRecyclerAdapter : RecyclerView.Adapter<DetailFragmentRecyclerAdapter.ViewHolder> {
    lateinit var list: List<Datum>
    lateinit var context: Context

    constructor(list: List<Datum>) : super() {
        this.list = list
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: DetailFragmentRecyclerAdapter.ViewHolder?, position: Int) {
        //
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DetailFragmentRecyclerAdapter.ViewHolder {
        context = parent!!.context
        val view = LayoutInflater.from(context).inflate(R.layout.content_detail, parent, false);
        return ViewHolder(view)
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View?) : super(itemView)
    }
}
