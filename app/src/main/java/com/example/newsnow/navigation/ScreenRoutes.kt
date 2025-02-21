package com.example.newsnow.navigation

sealed class ScreenRoutes(val routes: String ) {
    object Home : ScreenRoutes("Home_Page")
    object DetailsScreen : ScreenRoutes("Details_Screen/1{employeeId}"){
        fun createRoute(employeeId: Int) = "Details_Screen/$employeeId"
    }
}