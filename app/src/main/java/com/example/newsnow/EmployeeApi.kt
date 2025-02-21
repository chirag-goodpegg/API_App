package com.example.newsnow

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// RETROFIT API INTERFACE
interface EmployeeApi {
    @GET("users")
    suspend fun getEmployees(): List<EmployeeDataModel>

    companion object {
        fun create(): EmployeeApi {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EmployeeApi::class.java)
        }
    }

}