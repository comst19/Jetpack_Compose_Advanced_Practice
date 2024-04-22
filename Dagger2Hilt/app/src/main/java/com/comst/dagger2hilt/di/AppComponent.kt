package com.comst.dagger2hilt.di

import android.app.Application
import com.comst.dagger2hilt.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, AppSubcomponents::class]
)
interface AppComponent{

    @Component.Factory
    interface Factory{
        fun create (@BindsInstance application: Application):AppComponent
    }

    fun application():Application // provision method

    fun helloWorld():String  // provision method

    fun inject(activity:MainActivity) // 멤버 인젝션 메서드

    fun mainSubcomponentFactory():MainSubcomponent.Factory
}