package com.example.eddymontesinos.demosqlite_romm.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.Pedido

@Dao
interface PedidoDao {
    @Query("select * from Pedido")
    fun litarPedido(): List<Pedido>

    @Query("select * from Pedido where userId = :userId ")
    fun verpedidosUsuario(userId:String) : List<Pedido>


    @Insert
    fun insertarListaPedido(pedido : ArrayList<Pedido>) : Array<Long>

    @Insert
    fun insertPedido(pedido: Pedido): Long

    @Delete
    fun deletePedido(pedido: Pedido):Int
}