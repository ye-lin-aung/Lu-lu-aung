package com.yelinaung.luluaung.module

import com.yelinaung.luluaung.repo.DataRepository
import com.yelinaung.luluaung.repo.Repository
import com.yelinaung.luluaung.scope.RepoScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 9/5/16.
 */
@Module
class DataModule {

    @Provides @RepoScope
    fun dataSource(dataRepository: DataRepository): Repository {
        return dataRepository
    }

}