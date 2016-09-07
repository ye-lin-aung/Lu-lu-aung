package com.yelinaung.luluaung.module

import com.yelinaung.luluaung.UseCases.GetItems
import com.yelinaung.luluaung.UseCases.ItemCases
import com.yelinaung.luluaung.repo.DataRepository
import com.yelinaung.luluaung.repo.Repository
import com.yelinaung.luluaung.scope.RepoScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by user on 9/5/16.
 */
@Module
class DataModule {
    private var item_Id = -1

    @Provides @RepoScope
    fun dataSource(dataRepository: DataRepository): Repository {
        return dataRepository
    }

    @Provides @RepoScope @Named("itemList") fun provideGetUserListUseCase(
            getUserList: GetItems): ItemCases {
        return getUserList
    }
}