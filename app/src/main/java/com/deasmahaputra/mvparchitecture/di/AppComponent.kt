package com.deasmahaputra.mvparchitecture.base.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkModule::class, StoredDataModule::class]
)
interface AppComponent{


}