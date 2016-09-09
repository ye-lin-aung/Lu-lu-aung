package com.yelinaung.luluaung.event

import android.graphics.Bitmap
import android.view.View

/**
 * Created by user on 9/8/16.
 */

interface BitmapClick {
  fun click(position:Int,view:View,image:Bitmap)
}

