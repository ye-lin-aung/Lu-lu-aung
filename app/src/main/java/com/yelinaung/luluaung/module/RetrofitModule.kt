package com.yelinaung.luluaung.module

import com.yelinaung.luluaung.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by user on 9/3/16.
 */

@Singleton
@Module
class RetrofitModule {

    @Provides
    fun retrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}
