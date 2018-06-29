package com.example.eddymontesinos.demosqlite_romm.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido

@Dao
interface DetallePedidoDao {

    @Query("select * from DetallePedidoActivity")
    fun litarDetallePedido(): List<DetallePedido>

    @Insert
    fun insertarDetallePedido(detalle : ArrayList<DetallePedido>) : Array<Long>

    @Insert
    fun insertDetallePedido(detalle: DetallePedido): Long

    @Delete
    fun deleteDetallePedido(detalle: DetallePedido):Int
}