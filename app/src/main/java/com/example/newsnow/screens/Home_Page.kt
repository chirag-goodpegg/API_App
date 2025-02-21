package com.example.newsnow.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsnow.EmployeeDataModel
import com.example.newsnow.R
import com.example.newsnow.ui.theme.colorSecondary
import com.example.newsnow.viewModel.EmployeeViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomePage(navController: NavController, viewModel: EmployeeViewModel = viewModel()) {
    val employees by viewModel.users.collectAsState()
    Text("Employees",
        style = TextStyle(
            fontSize = 30.sp
        ),
        color = Color.White,
        modifier = Modifier
            .padding(top = 5.dp,)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    LazyColumn(
        modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp, top = 7.dp)
    ) {
        items(employees) { employee ->
            EmployeeCard(employee,navController)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun EmployeeCard(employee: EmployeeDataModel,navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("Details_Screen/${employee.login}") }
            .padding(top = 45.dp, start = 10.dp, end = 10.dp, )
            .border(
                4.dp,
                Color.White.copy(alpha = 0.5f),
                RoundedCornerShape(12.dp)
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
                            Color(0xFF7432f7),
                            Color(0xFFaf7ab0),
                            Color(0xFFbe8d6d)
                        )  // Light to dark blue
                    )
                )
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.avatar_img),
//                    contentDescription = "Avatar",
//                    modifier = Modifier
//                        .size(50.dp)
//                        .padding(4.dp),
//                    contentScale = ContentScale.FillBounds
//                )

                GlideImage(
                    imageModel = { employee.avatar }, // Image URL
                    modifier = Modifier
                        .size(150.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    )
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorSecondary,  // Change the background color
                        contentColor = Color.White    // Change the text/icon color inside the card
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .width(2000.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF7432f7),
                                        Color(0xFFaf7ab0),
                                        Color(0xFFbe8d6d)
                                    )  // Light to dark blue
                                )
                            )
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                top = 5.dp,
                                end = 10.dp,
                                bottom = 5.dp
                            )
                        ) {
                            Text("Name:")
                            Text(
                                text = employee.login,
                                modifier = Modifier.padding(end = 10.dp),
                                style = TextStyle(
                                    fontSize = 20.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
