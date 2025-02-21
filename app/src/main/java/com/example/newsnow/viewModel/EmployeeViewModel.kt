package com.example.newsnow.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsnow.EmployeeApi
import com.example.newsnow.EmployeeDataModel
import com.example.newsnow.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {
//    var employees by mutableStateOf<List<EmployeeDataModel>>(emptyList())
//        private set
private val api = EmployeeApi.create()
    private val employees = MutableStateFlow<List<EmployeeDataModel>>(emptyList())
    val users: StateFlow<List<EmployeeDataModel>> = employees

    init {
        fetchEmployees()
    }

    private fun fetchEmployees() {
        viewModelScope.launch {
            try {
                employees.value = api.getEmployees()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}