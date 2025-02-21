package com.example.newsnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.newsnow.navigation.AppNavigation
import com.example.newsnow.screens.HomePage
import com.example.newsnow.ui.theme.NewsNowTheme
import com.example.newsnow.ui.theme.colorPrimary
import com.example.newsnow.viewModel.EmployeeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val employeeViewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]
        setContent {
            NewsNowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(colorPrimary)
                    ) {
                        Text("Employees",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 5.dp),
                            color = Color.White,
                            fontSize = 30.sp,
                            )
//                        HomePage(employeeViewModel)
                        AppNavigation()
                    }
                }
            }
        }
    }
}

