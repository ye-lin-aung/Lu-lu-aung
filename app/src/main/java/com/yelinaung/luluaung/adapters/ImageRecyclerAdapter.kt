package com.yelinaung.luluaung.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.yelinaung.luluaung.R
import com.yelinaung.luluaung.adapters.viewholders.ImageViewHolder
import com.yelinaung.luluaung.adapters.viewholders.ProgressViewHolder
import com.yelinaung.luluaung.event.ViewClick
import com.yelinaung.luluaung.model.network.Datum
import java.util.*


/**
 * Created by user on 9/5/16.
 */

class ImageRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context
    val PRORESS = 1
    val ITEM = 0
    var map: HashMap<String, Datum> = hashMapOf()
    var list: MutableList<Datum> = mutableListOf()
    var click: ViewClick? = null

    fun replaceList(list: List<Datum>) {
        list.forEach { v1 ->
            if (!map.containsKey(v1.id)) {
                map.put(v1.id!!, v1);
            }
        }
        this.list = map.values.toMutableList()
        notifyDataSetChanged()
    }

    fun getItemAtPosition(position: Int): Datum {
        return list.get(position)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.count()) return 1 else return 0
    }

    override fun getItemCount(): Int {
        return this.list.count() + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ImageViewHolder) {
            Glide.with(context).load(this.list.get(position).images.get(0).source).crossFade().placeholder(R.drawable.icon).into(((holder)).img)
            holder.itemView.setOnClickListener() { v -> click!!.click(position, holder.itemView) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        context = parent!!.context
        if (viewType == ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_recycler, parent, false)

            return ImageViewHolder(view);
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress, parent, false)
            return ProgressViewHolder(view);
        }
    }
}
