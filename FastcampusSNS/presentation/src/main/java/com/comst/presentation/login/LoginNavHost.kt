package com.comst.presentation.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginNavHost(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute.WelcomeScreen.name,

    ){
        composable(route = LoginRoute.WelcomeScreen.name){
            WelcomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(route = LoginRoute.LoginScreen.name)
                }
            )
        }

        composable(route = LoginRoute.LoginScreen.name){
            LoginScreen()
        }

        composable(route = LoginRoute.SignUpScreen.name){
            SignUpScreen(
                id = "iisque",
                username = "Marla Fisher",
                password1 = "dui",
                password2 = "lorem",
                onIdChange = {},
                onUsernameChange = {},
                onPassword1Change = {},
                onPassword2Change = {},
                onSignUpClick = {}
            )
        }
    }
}