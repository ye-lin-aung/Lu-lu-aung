package com.yelinaung.luluaung.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.yelinaung.luluaung.repo.RemoteDataRepository
import com.yelinaung.luluaung.repo.Repository
import com.yelinaung.luluaung.scope.RepoScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 9/4/16.
 */
@Module
class RemoteModule {

    @Provides @RepoScope
    fun sharePref(context: Context): SharedPreferences {
        val sharePreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharePreferences
    }

    @Provides @RepoScope
    fun getRemoteDataSource(repository: RemoteDataRepository): Repository = repository

}
