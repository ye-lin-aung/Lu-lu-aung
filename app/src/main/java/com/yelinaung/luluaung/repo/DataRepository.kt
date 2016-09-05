package com.yelinaung.luluaung.repo

import com.yelinaung.luluaung.model.network.Datum
import javax.inject.Inject

/**
 * Created by user on 9/4/16.
 */



class DataRepository : Repository {
    @Inject lateinit var dataRepository: RemoteDataRepository
    var map = mutableMapOf<String, Datum>()

    fun putItem(data: Datum) {
        if (!map.containsValue(data)) {
            map.put(data.id!!, data)
        }

    }

    fun getItems(): List<Datum> {
        return map.values.toList()
    }

    fun remoteItem(data: Datum) {
        if (map.containsValue(data)) {
            map.remove(data.id!!)
        }
    }

    fun paginateData() {
        dataRepository.getData()
    }

    override fun getData(): List<Datum> {
        return map.values.toList()
    }
}

