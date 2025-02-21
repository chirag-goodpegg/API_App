package com.example.newsnow.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.newsnow.R


@Composable
fun SpashScreen(navController: NavController){
    var startAnimation by remember { mutableStateOf(false) }

    // Fade-in animation
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000), label = "fade"
    )

    // Start animation & navigate after delay
    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2000) // Show splash for 2 seconds
        navController.navigate("Home_Page") {
            popUpTo("splash") { inclusive = true } // Remove splash from backstack
        }
    }

    // UI with fade-in effect
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.avatar_img), // Add your logo in res/drawable
            contentDescription = "App Logo",
            modifier = Modifier
                .size(150.dp)
                .alpha(alphaAnim) // Apply fade-in animation
        )
    }


}