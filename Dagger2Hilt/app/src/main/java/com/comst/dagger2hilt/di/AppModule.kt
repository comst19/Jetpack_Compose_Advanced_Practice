package com.comst.dagger2hilt.di

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideHelloWorld():String{
        return "Hello World"
    }
}