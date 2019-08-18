package com.deasmahaputra.mvparchitecture.base.di

import android.app.Application
import com.deasmahaputra.mvparchitecture.movies.MovieActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkModule::class, StoredDataModule::class]
)
interface AppComponent{

    fun inject(movieActivity: MovieActivity)


}