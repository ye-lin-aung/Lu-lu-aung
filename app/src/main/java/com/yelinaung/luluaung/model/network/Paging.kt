package com.yelinaung.luluaung.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by user on 9/3/16.
 */

class Paging {
    /**

     * @return
     * * The cursors
     */
    /**

     * @param cursors
     * * The cursors
     */
    @SerializedName("cursors")
    @Expose
    var cursors: Cursors? = null
    /**

     * @return
     * * The next
     */
    /**

     * @param next
     * * The next
     */
    @SerializedName("next")
    @Expose
    var next: String? = null
    /**

     * @return
     * * The previous
     */
    /**

     * @param previous
     * * The previous
     */
    @SerializedName("previous")
    @Expose
    var previous: String? = null

    fun withCursors(cursors: Cursors): Paging {
        this.cursors = cursors
        return this
    }

    fun withNext(next: String): Paging {
        this.next = next
        return this
    }

    fun withPrevious(previous: String): Paging {
        this.previous = previous
        return this
    }

}
