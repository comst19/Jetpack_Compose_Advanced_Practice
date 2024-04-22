package com.comst.dagger2hilt

import android.app.Application
import com.comst.dagger2hilt.di.AppComponent
import com.comst.dagger2hilt.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }
}