package com.yelinaung.luluaung.network

import com.yelinaung.luluaung.model.network.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Created by user on 9/4/16.
 */


//https://graph.facebook.com/


interface ApiClient {
    @GET("/v2.7/212390098842654/photos?")
    fun getItem(@QueryMap luMap: Map<String, String>, @Query("after") after: String): Call<Item>
}