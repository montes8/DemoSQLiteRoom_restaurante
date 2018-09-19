package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(foreignKeys = [ (ForeignKey(entity = Categoria::class, parentColumns = arrayOf("idCategoria"), childColumns = arrayOf("categoriaId"), onDelete = ForeignKey.CASCADE))])
class Plato(
        @PrimaryKey(autoGenerate = true)
        var idPlato : Long? =null,
        val categoriaId : Long,
        val nombrePlato: String,
        val imagen: String,
        val precioPlato: Double,
        val calorias : String,
        val descuento : Int,
        val descripcion : String
): Parcelable