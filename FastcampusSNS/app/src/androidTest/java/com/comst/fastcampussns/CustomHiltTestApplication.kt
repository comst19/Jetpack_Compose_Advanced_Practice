package com.comst.fastcampussns

import android.app.Application
import android.util.Log
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.testing.CustomTestApplication

open class CustomHiltTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()

//        Log.e("Hilt", "애플리케이션 생성 후, 비즈니스 로직 수행")
//        val fooEntryPoint = EntryPointAccessors.fromApplication(this, FooEntryPoint::class.java)
        val fooEntryPoint = EarlyEntryPoints.get(this, FooEntryPoint::class.java)
        val foo = fooEntryPoint.foo()
        Log.e("Hilt", "foo.tag = ${foo.tag}")
    }
}

@CustomTestApplication(CustomHiltTestApplication::class)
interface MyCustom{

}