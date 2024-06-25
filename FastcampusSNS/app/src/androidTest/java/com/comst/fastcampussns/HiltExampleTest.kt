package com.comst.fastcampussns

import com.comst.data.UserDataStore
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
//@UninstallModules(FooModule::class)
class HiltExampleTest {

    @Inject
    lateinit var userDataStore: UserDataStore

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

//    @Inject
//    lateinit var foo:Foo

//    @Inject
//    lateinit var bar:Bar
//
//    @BindValue
//    val foo:Foo = Foo("HiltExampleTest")

//    @Test
//    fun 주입테스트(){
//        hiltRule.inject()
//        Assert.assertNotNull(userDataStore)
//        Assert.assertEquals("HiltExampleTest", bar.foo.tag)
//    }
//
//    @Test
//    fun bar주입테스트(){
//        hiltRule.inject()
//        Assert.assertNotNull(bar)
//    }

    @Test
    fun test(){

    }

//    @Test
//    fun Foo주입테스트(){
//        hiltRule.inject()
//        Assert.assertEquals("FooModule",foo.tag)
//    }
}