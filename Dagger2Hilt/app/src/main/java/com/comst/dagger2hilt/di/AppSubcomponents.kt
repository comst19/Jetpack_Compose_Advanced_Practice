package com.comst.dagger2hilt.di

import com.comst.dagger2hilt.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AppSubcomponents {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun mainActivity():MainActivity
}