package com.yelinaung.luluaung

import android.app.Application
import com.yelinaung.luluaung.component.ApplicationComponent
import com.yelinaung.luluaung.component.DaggerApplicationComponent
import com.yelinaung.luluaung.module.RetrofitModule

/**
 * Created by user on 9/4/16.
 */
class AndroidApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

        get

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().retrofitModule(RetrofitModule()).build();


    }

}