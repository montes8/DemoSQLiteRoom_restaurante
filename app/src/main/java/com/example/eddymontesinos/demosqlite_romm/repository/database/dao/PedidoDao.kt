package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.Pedido

@Dao
interface PedidoDao {
    @Query("select * from Pedido")
    fun litarPedido(): List<Pedido>

    @Query("select * from Pedido where userId = :userId ")
    fun verpedidosUsuario(userId:Long) : List<Pedido>

    @Query("select * from Pedido where idPedido= :pedidoid")
    fun otenerpedidoId(pedidoid : Long) : Pedido


    @Query("SELECT COUNT(*) FROM pedido")
    fun optieneCantidadDeFila():Int

    @Insert
    fun insertarListaPedido(pedido : ArrayList<Pedido>) : Array<Long>

    @Insert
    fun insertPedido(pedido: Pedido): Long

    @Delete
    fun deletePedido(pedido: Pedido):Int
}