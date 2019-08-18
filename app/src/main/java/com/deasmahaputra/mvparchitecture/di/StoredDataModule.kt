package com.deasmahaputra.mvparchitecture.base.di

import android.content.Context
import com.deasmahaputra.mvparchitecture.storage.PreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StoredDataModule {

    @Provides
    @Singleton
    fun providesPreferencesManager(context: Context): PreferencesManager = PreferencesManager(context)
}