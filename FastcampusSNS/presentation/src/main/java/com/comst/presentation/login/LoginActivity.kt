package com.comst.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.comst.presentation.ui.theme.FastcampusSNSTheme

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            FastcampusSNSTheme {
                LoginNavHost()
            }
        }
    }
}