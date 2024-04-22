package com.comst.dagger2hilt.di

import dagger.Module
import dagger.Provides

@Module
class MainActivityNodule {

    @Provides
    @ActivityScope
    fun provideCurrentTime():Long{
        return System.currentTimeMillis()
    }
}