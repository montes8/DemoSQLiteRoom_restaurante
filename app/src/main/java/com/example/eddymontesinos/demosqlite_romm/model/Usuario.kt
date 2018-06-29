package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Usuario (

        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String = "",

        var nombreUsuario : String = "",

        var contrasenia : String = "",

        var pais :String = ""
)