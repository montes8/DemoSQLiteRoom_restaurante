package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Plato(
        @PrimaryKey(autoGenerate = true)
        var idPlato : Long? =null,
        val nombrePlato: String,
        val imagen: String,
        val precioPlato: Double,
        val calorias : String,
        val descuento : Int,
        val descripcion : String
): Parcelable