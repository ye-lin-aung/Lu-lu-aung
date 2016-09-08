package com.yelinaung.luluaung.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by user on 9/3/16.
 */

class Image :Serializable{
    /**

     * @return
     * * The height
     */
    /**

     * @param height
     * * The height
     */
    @SerializedName("height")
    @Expose
    var height: Int = 0
    /**

     * @return
     * * The source
     */
    /**

     * @param source
     * * The source
     */
    @SerializedName("source")
    @Expose
    var source: String? = null
    /**

     * @return
     * * The width
     */
    /**

     * @param width
     * * The width
     */
    @SerializedName("width")
    @Expose
    var width: Int = 0

    fun withHeight(height: Int): Image {
        this.height = height
        return this
    }

    fun withSource(source: String): Image {
        this.source = source
        return this
    }

    fun withWidth(width: Int): Image {
        this.width = width
        return this
    }

}
