package com.comst.dynamicfeature

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.comst.data.UserDataStore
import com.comst.fastcampussns.FooEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class DynamicFeatureActivity : ComponentActivity() {

    @Inject
    lateinit var userDateStore: UserDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val entryPoint =
            EntryPointAccessors.fromApplication(applicationContext, FooEntryPoint::class.java)
        val foo = entryPoint.foo()

        val component = DaggerDynamicFeatureComponent.builder()
            .fooEntryPoint(entryPoint)
            .build()

        component.inject(this)

        Log.e("DynamicFeature", "foo = $foo")
        Log.e("DynamicFeature","userDateStore = ${this::userDateStore.isInitialized}")
    }
}