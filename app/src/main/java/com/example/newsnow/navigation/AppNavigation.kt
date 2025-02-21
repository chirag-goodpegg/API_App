package com.example.newsnow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsnow.screens.DetailScreen
import com.example.newsnow.screens.HomePage
import com.example.newsnow.screens.SpashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SpashScreen(navController)
        }
        composable("Home_Page") {
            HomePage(navController)
        }
        composable("Details_Screen/{employeeId}") { backStackEntry ->
            val employeeId = backStackEntry.arguments?.getString("employeeId")?: return@composable
            DetailScreen(employeeId,navController)

            // Handle the employeeId here
        }

    }
}