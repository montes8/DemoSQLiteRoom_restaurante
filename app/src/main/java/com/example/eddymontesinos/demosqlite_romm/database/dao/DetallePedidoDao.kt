package com.example.eddymontesinos.demosqlite_romm.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import com.example.eddymontesinos.demosqlite_romm.model.Plato

@Dao
interface DetallePedidoDao {

    @Query("select * from DetallePedido")
    fun litarDetallePedido(): List<DetallePedido>

    @Query("select * from Pedido inner join  DetallePedido on Pedido.idPedido = DetallePedido.pedidoId where DetallePedido.pedidoId= :pedidoId")
    fun getUsersForRepository(pedidoId: Long): List<Pedido>

    @Query("select * from Plato inner join  DetallePedido on Plato.idPlato = DetallePedido.platoId where DetallePedido.platoId= :platoId")
    fun getRepositoriesForUsers(platoId : Long):List<Plato>

    @Insert
    fun insertarDetallesListaPedido(detalle : ArrayList<DetallePedido>) : Array<Long>

    @Insert
    fun insertDetallePedido(detalle: DetallePedido): Long

    @Delete
    fun deleteDetallePedido(detalle: DetallePedido):Int


}