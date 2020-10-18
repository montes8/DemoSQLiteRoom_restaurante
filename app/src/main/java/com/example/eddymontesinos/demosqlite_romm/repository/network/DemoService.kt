package com.example.eddymontesinos.demosqlite_romm.repository.network

import com.example.eddymontesinos.demosqlite_romm.model.Categoria
import com.example.eddymontesinos.demosqlite_romm.repository.network.request.LoginRequest

import com.example.eddymontesinos.demosqlite_romm.repository.network.response.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DemoService {

    @GET("products")
    fun getData(): Call<ArrayList<Categoria>>


    @POST("login")
    fun login(@Body loginRequest : LoginRequest): Call<User>

    /*@POST("login")
    fun login(@Query("email")email : String,
              @Query("password")password : String): Call<User>*/

    companion object {
        fun create(): DemoService {
            return RetrofitCreator
                .getInstanceRetrofit()
                .create(DemoService::class.java)
        }
    }
}