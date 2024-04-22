package com.comst.dagger2hilt.di

import com.comst.dagger2hilt.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityNodule::class])
@ActivityScope
interface MainSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity:MainActivity):MainSubcomponent
    }

    fun inject(activity:MainActivity)
}