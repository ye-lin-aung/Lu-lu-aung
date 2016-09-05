package com.yelinaung.luluaung.component

import android.content.Context
import com.yelinaung.luluaung.module.ApplicationModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by user on 9/4/16.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun context(): Context
    fun retrofit(): Retrofit
}