package com.yelinaung.luluaung.module

import android.app.Application
import android.content.Context
import com.yelinaung.luluaung.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by user on 9/4/16.
 */
@Module
class ApplicationModule(val application: Application) {


    @Singleton
    @Provides fun context(): Context = application



    @Provides @Singleton
    fun retrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}
