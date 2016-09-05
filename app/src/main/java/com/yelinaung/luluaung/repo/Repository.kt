package com.yelinaung.luluaung.repo

import com.yelinaung.luluaung.model.network.Datum

/**
 * Created by user on 9/4/16.
 */

interface Repository{
    fun getData():List<Datum>
}