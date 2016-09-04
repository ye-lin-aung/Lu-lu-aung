package com.yelinaung.luluaung.component

import com.yelinaung.luluaung.module.RetrofitModule
import com.yelinaung.luluaung.repo.RemoteDataRepository
import dagger.Component

/**
 * Created by user on 9/4/16.
 */

@Component(modules = arrayOf(RetrofitModule::class))
interface ApplicationComponent {
    fun inject(remoteSource: RemoteDataRepository);
}
