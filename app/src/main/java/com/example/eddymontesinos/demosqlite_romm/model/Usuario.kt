package com.example.eddymontesinos.demosqlite_romm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario (

        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String = "",

        var nombreUsuario : String = "",

        var contrasenia : String = "",

        var pais :String = ""
)