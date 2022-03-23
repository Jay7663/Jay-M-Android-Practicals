package com.example.androidpractical.interfaces

import com.example.androidpractical.R
import com.example.androidpractical.models.ApiUser
import com.example.androidpractical.models.CreateUserRequest
import com.example.androidpractical.models.LogInRequest
import com.example.androidpractical.models.SIngleUser
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiInterface {

    @GET("api/users?delay=3")
    fun getData(): Call<ApiUser>

    @POST("api/login")
    fun logInWithRetrofit(@Body loginRequest: LogInRequest): Call<Any>

    @POST("api/users")
    fun createUser(@Body createUserRequest: CreateUserRequest): Call<Any>

    @GET
    fun getSpecificUser(@Url url: String): Call<SIngleUser>

    companion object {
        fun getRetrofitObject(): Retrofit {
            return Retrofit.Builder().baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}