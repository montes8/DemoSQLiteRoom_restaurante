package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.PrimaryKey

class Categoria  (
@PrimaryKey(autoGenerate = true)
var idCategoria : Long? = null,
val categoria : String = "")