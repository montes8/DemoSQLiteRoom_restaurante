package com.example.eddymontesinos.demosqlite_romm.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = [ (ForeignKey(entity = Usuario::class, parentColumns = arrayOf("idUsu"), childColumns = arrayOf("userId"), onDelete = ForeignKey.CASCADE))])
data class Pedido (
@PrimaryKey(autoGenerate = true)
var idPedido : Long? = null,

var userId : Long? = null,

var fecha: String? = "",

var direccion : String = "",

var montoTotal : Double? = null
)