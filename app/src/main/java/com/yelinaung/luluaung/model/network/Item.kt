package com.yelinaung.luluaung.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by user on 9/3/16.
 */

class Item {

    /**

     * @return
     * * The data
     */
    /**

     * @param data
     * * The data
     */
    @SerializedName("data")
    @Expose
    var data: List<Datum> = ArrayList()
    /**

     * @return
     * * The paging
     */
    /**

     * @param paging
     * * The paging
     */
    @SerializedName("paging")
    @Expose
    var paging: Paging? = null

    fun withData(data: List<Datum>): Item {
        this.data = data
        return this
    }

    fun withPaging(paging: Paging): Item {
        this.paging = paging
        return this
    }

}
