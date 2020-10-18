package com.example.eddymontesinos.demosqlite_romm.repository.network.request

import com.google.gson.annotations.SerializedName

class LoginRequest (
    @SerializedName("email")
    var email : String,
    @SerializedName("password")
    var password : String
)