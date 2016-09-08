package com.yelinaung.luluaung.module

import android.app.Application
import android.content.Context
import com.yelinaung.luluaung.BuildConfig
import com.yelinaung.luluaung.repo.*
import com.yelinaung.luluaung.threads.JobExecutor
import com.yelinaung.luluaung.threads.PostExecutionThread
import com.yelinaung.luluaung.threads.ThreadExecutor
import com.yelinaung.luluaung.threads.UIThread
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by user on 9/4/16.
 */
@Module
class ApplicationModule(val application: Application) {


    @Singleton
    @Provides fun context(): Context = application

    @Singleton @Provides fun threadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Singleton @Provides fun mainThread(uiThread: UIThread): PostExecutionThread = uiThread

    @Singleton @Provides fun remote(dataRepository: RemoteDataRepository): Repository = dataRepository

    @Singleton @Provides fun dataRepo(dataRepository: DataRepository): Repository = dataRepository

    @Singleton @Provides fun provideCache(cacheRepo: CacheRepo): Repo = cacheRepo

    @Provides @Singleton
    fun retrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        return retrofit
    }

}
