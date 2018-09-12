package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Categoria  (
@PrimaryKey(autoGenerate = true)
var idCategoria : Long? = null,
val categoria : String = "",
val fotoCategoria : String = "")