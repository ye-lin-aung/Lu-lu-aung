package com.yelinaung.luluaung.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 9/3/16.
 */

class Cursors {
    /**
     * @return
     * * The before
     */
    /**

     * @param before
     * * The before
     */
    @SerializedName("before")
    @Expose
    var before: String? = null
    /**

     * @return
     * * The after
     */
    /**

     * @param after
     * * The after
     */
    @SerializedName("after")
    @Expose
    var after: String? = null

    fun withBefore(before: String): Cursors {
        this.before = before
        return this
    }

    fun withAfter(after: String): Cursors {
        this.after = after
        return this
    }

}