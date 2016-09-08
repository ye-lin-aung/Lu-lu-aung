package com.yelinaung.luluaung.module

import com.yelinaung.luluaung.useCases.GetItems
import com.yelinaung.luluaung.useCases.ItemCases
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

    @Provides @RepoScope @Named("itemList") fun provideGetUserListUseCase(
            getUserList: GetItems): ItemCases {
        return getUserList
    }

}