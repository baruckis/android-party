package com.baruckis.androidparty.ui.di

import com.baruckis.androidparty.ui.launcher.LauncherActivity
import com.baruckis.androidparty.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeLauncherActivity(): LauncherActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

}