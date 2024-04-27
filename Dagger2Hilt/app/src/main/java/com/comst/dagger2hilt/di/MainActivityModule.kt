package com.comst.dagger2hilt.di

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideCurrentTime():Long{
        return System.currentTimeMillis()
    }
}