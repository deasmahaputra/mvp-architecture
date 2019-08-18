package com.deasmahaputra.mvparchitecture.base

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.deasmahaputra.mvparchitecture.common.LocaleHelper
import com.deasmahaputra.mvparchitecture.base.di.AppComponent
import com.deasmahaputra.mvparchitecture.base.di.AppModule
import com.deasmahaputra.mvparchitecture.base.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class Application : MultiDexApplication(), HasActivityInjector {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var activityDispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleHelper(base).onAttach())
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

}