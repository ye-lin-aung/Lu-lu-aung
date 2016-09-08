package com.yelinaung.luluaung.repo

import com.yelinaung.luluaung.model.network.Datum
import com.yelinaung.luluaung.model.network.Item
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by user on 9/8/16.
 */

@Singleton
class CacheRepo : Repo {

    lateinit var map: HashMap<String, Item>
    var list: MutableList<Datum> = mutableListOf()
    lateinit var hash_map: MutableList<Datum>
    var keyArrays: MutableList<String> = mutableListOf()

    @Inject constructor() {
        map = hashMapOf()
        hash_map = mutableListOf<Datum>()
    }


    fun addItem(key: String, item: Item) {
        if (!map.contains(key)) {
            map.put(key, item)
            keyArrays.add(item.paging!!.cursors!!.after.toString())
        }

    }

    fun getPage(): String {
        if (keyArrays.isNotEmpty()) {
            return keyArrays.last()
        } else {
            return ""
        }
    }

    fun getPosition(item: Datum): Int {
        return getItems().toList().indexOf(item)
    }

    fun getItems(): List<Datum> {
        map.values.forEach { v1 ->
            v1.data.forEach { v2 ->
                if (!hash_map.contains(v2)) {
                    hash_map.add(v2)
                }
            }

        }
        return hash_map.toList()
    }

    fun removeItem(key: String) {
        if (map.contains(key)) {
            map.remove(key)
        }
    }

}
