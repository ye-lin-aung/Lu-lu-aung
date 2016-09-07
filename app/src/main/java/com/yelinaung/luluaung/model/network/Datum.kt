package com.yelinaung.luluaung.model.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by user on 9/3/16.
 */

class Datum {


    /**

     * @return
     * * The images
     */
    /**

     * @param images
     * * The images
     */
    @SerializedName("images")
    @Expose
    var images: List<Image> = ArrayList()
    /**

     * @return
     * * The id
     */
    /**

     * @param id
     * * The id
     */

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    fun withImages(images: List<Image>): Datum {
        this.images = images
        return this
    }

    fun withId(id: String): Datum {
        this.id = id
        return this
    }

    override fun toString(): String {
        return "Datum(id=$id, images=$images, name=$name)"
    }

}
