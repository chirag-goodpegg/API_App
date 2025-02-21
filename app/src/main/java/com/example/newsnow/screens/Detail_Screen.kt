package com.example.newsnow.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsnow.ui.theme.colorSecondary
import com.example.newsnow.viewModel.EmployeeViewModel
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    username: String, navController: NavController, viewModel: EmployeeViewModel = viewModel()
) {
    val user = viewModel.users.collectAsState().value.find { it.login == username }

    Scaffold(topBar = {
        TopAppBar(title = { Text(username) }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        })
    }) {
        user?.let {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .border(
                        4.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(12.dp)
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = colorSecondary,  // Change the background color
                    contentColor = Color.White    // Change the text/icon color inside the card
                ),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF381c67),
                                    Color(0xFF73516e),
                                    Color(0xFFd3a674),
                                    Color(0xFFfdecab)
                                )  // Light to dark blue
                            )
                        )
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        GlideImage(
                            imageModel = { it.avatar }, // Image URL
                            modifier = Modifier
                                .size(300.dp)
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp)),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Username: ${it.login}", style = TextStyle(fontSize = 24.sp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("ID: ${it.id}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Node ID: ${it.node_id}")
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}