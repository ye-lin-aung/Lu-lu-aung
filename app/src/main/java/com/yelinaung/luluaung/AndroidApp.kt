package com.yelinaung.luluaung


import android.app.Application
import com.yelinaung.luluaung.component.*
import com.yelinaung.luluaung.module.ApplicationModule

/**
 * Created by user on 9/4/16.
 */


class AndroidApp : Application() {


    lateinit var applicationComponent: ApplicationComponent

    lateinit var repoComponent: RemoteComponent

    lateinit var dataComponent: DataComponent
        get

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build();
        repoComponent = DaggerRemoteComponent.builder().applicationComponent(applicationComponent).build()
        dataComponent = DaggerDataComponent.builder().applicationComponent(applicationComponent).build()


    }

}