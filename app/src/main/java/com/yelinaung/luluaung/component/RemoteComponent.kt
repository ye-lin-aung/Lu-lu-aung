package com.yelinaung.luluaung.component

import android.content.SharedPreferences
import com.yelinaung.luluaung.module.RemoteModule
import com.yelinaung.luluaung.scope.RepoScope
import dagger.Component

/**
 * Created by user on 9/4/16.
 */

@RepoScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(RemoteModule::class))
interface RemoteComponent {


}
