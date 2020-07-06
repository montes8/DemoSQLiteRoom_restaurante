package com.example.eddymontesinos.demosqlite_romm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Categoria  (
@PrimaryKey(autoGenerate = true)
var idCategoria : Long? = null,
val categoria : String,
val fotoCategoria : String
):Parcelable