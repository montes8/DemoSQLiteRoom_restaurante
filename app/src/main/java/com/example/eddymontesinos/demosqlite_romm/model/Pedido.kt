package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey


@Entity(foreignKeys = [ (ForeignKey(entity = Usuario::class, parentColumns = arrayOf("idUsu"), childColumns = arrayOf("userId"), onDelete = ForeignKey.CASCADE))])
data class Pedido (
@PrimaryKey(autoGenerate = true)
var idPedido : Long? = null,

var userId : Long? = null,

var fecha: String? = "",

var montoTotal : Double? = null
)