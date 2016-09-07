package com.yelinaung.luluaung.network

import com.yelinaung.luluaung.model.network.Item
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by user on 9/4/16.
 */


//https://graph.facebook.com/


interface ApiClient {
    @GET("/v2.7/212390098842654/photos?")
    fun getItem(@QueryMap(encoded = true) luMap: Map<String, String>, @Query("after") after: String): Observable<Item>

    @GET("/v2.7/212390098842654/photos?")
    fun getDebug(@QueryMap(encoded = true) luMap: Map<String, String>, @Query("after") after: String): retrofit2.Call<Item>
}