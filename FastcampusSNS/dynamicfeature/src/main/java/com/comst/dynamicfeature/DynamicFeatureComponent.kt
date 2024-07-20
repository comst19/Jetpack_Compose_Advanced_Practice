package com.comst.dynamicfeature

import com.comst.fastcampussns.FooEntryPoint
import dagger.Component

@Component(dependencies = [FooEntryPoint::class])
interface DynamicFeatureComponent {

    fun inject(target:DynamicFeatureActivity)
}