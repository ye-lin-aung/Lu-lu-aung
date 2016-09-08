package com.yelinaung.luluaung.util

import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager

/**
 * The type Activity utils.
 */

/**
 * Sets the activity in Fullscreen mode

 * @param activity
 * *     the activity
 */
fun setFullScreen(activity: Activity) {
    // Call before calling setContentView();
    activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/**
 * Hides the activity's action bar

 * @param activity
 * *     the activity
 */
fun hideActionBar(activity: Activity?) {
    // Call before calling setContentView();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && activity != null) {
        activity.window.requestFeature(Window.FEATURE_ACTION_BAR)
        activity.actionBar!!.hide()
    }
}
