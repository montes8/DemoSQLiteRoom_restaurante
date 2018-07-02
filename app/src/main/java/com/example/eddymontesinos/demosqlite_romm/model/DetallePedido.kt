package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey



@Entity(foreignKeys = [ ForeignKey(entity = Pedido::class, parentColumns = arrayOf("idPedido"), childColumns = arrayOf("pedidoId"), onDelete = ForeignKey.CASCADE),
                        ForeignKey(entity = Plato::class, parentColumns = arrayOf("idPlato"), childColumns = arrayOf("platoId"), onDelete = ForeignKey.CASCADE)])
data class DetallePedido (
        @PrimaryKey(autoGenerate = true)
        var idDetalle : Long? = null,

        var pedidoId : Long? = null,

        var platoId : Long? = null,

        var cantidad : Int? = null ,

        var subTotal: Double? = null
)