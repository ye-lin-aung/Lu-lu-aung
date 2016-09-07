package com.yelinaung.luluaung.model.network

import com.yelinaung.luluaung.BuildConfig
import java.util.*

/**
 * Created by user on 9/4/16.
 */


const val KEY_ACCESS_TOKEN = "access_token"
const val PRETTY = "1"
const val FIELDS = "images,name"
const val TYPE = "uploaded"
const val LIMIT = "25"
const val AFTER = "MTA4OTgzODc4Nzc2NDQ0MwZDZD"

fun createMap(): HashMap<String, String> {
    return HashMap(mutableMapOf(Pair(KEY_ACCESS_TOKEN, BuildConfig.ACESS_TOKEN), Pair("pretty", PRETTY), Pair("fields", FIELDS), Pair("type", TYPE), Pair("limit", LIMIT)))
}