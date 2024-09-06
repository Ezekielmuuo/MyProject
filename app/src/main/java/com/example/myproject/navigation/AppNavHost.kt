package com.example.myproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.myproject.ui.theme.screens.Details.DetailScreen
import com.example.myproject.ui.theme.screens.Orders.AddOrdersScreen
import com.example.myproject.ui.theme.screens.Orders.ViewOrdersScreen


import com.example.myproject.ui.theme.screens.about.AboutScreen

import com.example.myproject.ui.theme.screens.home.HomeScreen

import com.example.myproject.ui.theme.screens.login.LoginScreen

import com.example.myproject.ui.theme.screens.signup.SignupScreen
import com.example.myproject.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }


        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ROUT_DETAILS) {
            DetailScreen(navController = navController)
        }
        composable(ADD_ORDERS_URL) {
            AddOrdersScreen(navController = navController)
        }
        composable(VIEW_ORDERS_URL) {
            ViewOrdersScreen(navController = navController)
        }





    }
}