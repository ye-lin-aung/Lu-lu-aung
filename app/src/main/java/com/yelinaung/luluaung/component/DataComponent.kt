package com.yelinaung.luluaung.component

import com.yelinaung.luluaung.MainActivity
import com.yelinaung.luluaung.module.DataModule
import com.yelinaung.luluaung.scope.RepoScope
import dagger.Component

/**
 * Created by user on 9/5/16.
 */
@RepoScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(DataModule::class))
interface DataComponent:RemoteComponent{
    fun inject(mainActivity: MainActivity);
}