package com.comst.data

import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class UserDataStoreTest {

    @Test
    fun 토큰_저장_삭제_테스트() = runTest{
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val userDataStore = UserDataStore(context)

        val expectedTestToken = "abc123"
        userDataStore.setToken(expectedTestToken)

        var actualToken = userDataStore.getToken()
        Assert.assertEquals(expectedTestToken, actualToken)

        userDataStore.clear()
        actualToken = userDataStore.getToken()
        Assert.assertNull(null, actualToken)
    }
}