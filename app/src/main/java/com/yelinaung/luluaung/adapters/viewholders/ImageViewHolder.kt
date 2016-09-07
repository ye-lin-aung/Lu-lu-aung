package com.yelinaung.luluaung.adapters.viewholders

/**
 * Created by user on 9/5/16.
 */

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.yelinaung.luluaung.R

class ImageViewHolder : RecyclerView.ViewHolder {
    lateinit var img: ImageView

    constructor(itemView: View?) : super(itemView) {
        img = itemView!!.findViewById(R.id.image) as ImageView
    }

}
