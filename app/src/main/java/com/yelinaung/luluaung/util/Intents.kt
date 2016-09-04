package com.yelinaung.luluaung.util

import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.yelinaung.luluaung.R

class Intents {

    /**
     * Attempt to launch the supplied [Intent]. Queries on-device packages before launching and
     * will display a simple message if none are available to handle it.
     */
    fun Intent.maybeStartActivity(context: Context): Boolean {

        if (this.hasHandler(context)) {
            context.startActivity(this)
            return true
        } else {
            Toast.makeText(context, R.string.no_intent_handler, LENGTH_LONG).show()
            return false
        }
    }

    /**
     * Queries on-device packages for a handler for the supplied [Intent].
     */
    fun Intent.hasHandler(context: Context): Boolean {
        val handlers = context.packageManager.queryIntentActivities(this, 0)
        return !handlers.isEmpty()

    }
}
