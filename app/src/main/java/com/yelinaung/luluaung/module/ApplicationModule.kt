package com.yelinaung.luluaung.module

import android.app.Application
import com.yelinaung.luluaung.repo.RemoteDataRepository
import com.yelinaung.luluaung.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by user on 9/4/16.
 */
@Module
class ApplicationModule(var application: Application) {

    @Singleton
    @Provides fun getRemoteDataSource(repository: RemoteDataRepository): Repository = repository

}
